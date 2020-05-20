package com.thl.string.Medium;

/**
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。
 *
 * 示例1:
 *
 *  输入：0.625
 *  输出："0.101"
 * 示例2:
 *
 *  输入：0.1
 *  输出："ERROR"
 *  提示：0.1无法被二进制准确表示
 */
public class Num_05_02 {
	public static void main(String[] args) {
		Num_05_02 test = new Num_05_02();
		System.out.println(test.printBin(0.1));
//		double d = 1.2345;
//		int d1 = (int) d;
//		System.out.println(d);
//		System.out.println(d1);
//		System.out.println(d-1.0);
	}
	public String printBin(double num) {
		if (num < 0 || num > 1)
			return "ERROR";

		StringBuilder res = new StringBuilder();
		res.append("0.");
		int divisor = 2;
		for (int i = 2; i < 32; i++) {
			if (num * divisor >= 1) {
				res.append("1");
				num -= (1.0/divisor);
			} else
				res.append("0");

			if (num == 0)
				return res.toString();

			divisor *= 2;

		}

		if (num != 0)
			return "ERROR";

		return res.toString();
	}

	public String printBin2(double num) {
		char[] bits = new char[32];
		bits[0] = '0';
		bits[1] = '.';
		int curr = 2;
		int divisor = 2;
		while (num != 0 && curr < bits.length) {
			if (num * divisor >= 1) {
				bits[curr] = '1';
				num -= (1.0 / divisor);
			} else {
				bits[curr] = '0';
			}
			divisor *= 2;
			curr++;
		}
		if (num != 0) {
			return "ERROR";
		}
		return String.valueOf(bits, 0, curr);
	}
}
