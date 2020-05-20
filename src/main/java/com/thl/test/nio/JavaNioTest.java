package com.thl.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class JavaNioTest {
	public static void main(String[] args) throws IOException {

		Selector serverSelect = Selector.open();
		Selector clientSelect = Selector.open();

		new Thread(() -> {
			try {
				ServerSocketChannel listenerChannel = ServerSocketChannel.open();
				listenerChannel.socket().bind(new InetSocketAddress(8000));
				listenerChannel.configureBlocking(false);
				listenerChannel.register(serverSelect, SelectionKey.OP_ACCEPT);

				while (true) {
					if (serverSelect.select(1) > 0) {
						Set<SelectionKey> set = serverSelect.selectedKeys();
						Iterator<SelectionKey> iterator = set.iterator();

						while (iterator.hasNext()) {
							SelectionKey key = iterator.next();
							if (key.isAcceptable()) {
								try {
									SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
									clientChannel.configureBlocking(false);
									clientChannel.register(clientSelect, SelectionKey.OP_READ);
								} finally{
									iterator.remove();
								}
							}
						}

					}
				}
			} catch (ClosedChannelException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}).start();

		new Thread(() -> {
			try {
				while (true) {
					if (clientSelect.select(1) > 0) {
						Set<SelectionKey> set = clientSelect.selectedKeys();
						Iterator<SelectionKey> iterator = set.iterator();
						while (iterator.hasNext()) {
							SelectionKey key = iterator.next();
							if (key.isReadable()) {
								try {
									SocketChannel channel = (SocketChannel)key.channel();
									ByteBuffer allocate = ByteBuffer.allocate(1024);

									channel.read(allocate);
									allocate.flip();
									System.out.println("client massage : " + Charset.defaultCharset().newDecoder().decode(allocate).toString());

								} finally {
									iterator.remove();
									key.interestOps(SelectionKey.OP_READ);
								}
							}


						}
					}

				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
