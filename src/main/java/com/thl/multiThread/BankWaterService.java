package com.thl.multiThread;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * 应用CyclicBarrier模拟银行流水
 *
 */

public class BankWaterService implements Runnable{

	private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);
	private ConcurrentHashMap hashmap = new ConcurrentHashMap<String, Integer>();
	private ExecutorService executor = new ThreadPoolExecutor(4,
			4,
			1000,
			TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>());

	public void count(){
		for (int i = 0; i < 4; i++) {
			executor.execute(new Runnable() {
				public void run() {
					hashmap.put(Thread.currentThread().getName(), 1);

					try {
						System.out.println(Thread.currentThread().getName() + "到达同步屏障");
						cyclicBarrier.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			});
		}
		executor.shutdown();

	}


	public void run() {
		//当线程到达同步屏障时，统计计算的结果

		System.out.println("所有线程到达同步屏障，开始计算统计结果");
		int result = 0;
		Set<Map.Entry<String, Integer>> set = hashmap.entrySet();
		for (Map.Entry<String, Integer> v: set) {
			result += v.getValue();
		}

		System.out.println("统计结果result = " + result);

	}

	public static void main(String[] args) throws InterruptedException {
		BankWaterService bankWaterService = new BankWaterService();
		bankWaterService.count();
		Thread.sleep(10000);
		System.out.println("当前alive线程 = " + Thread.activeCount());
	}
}
