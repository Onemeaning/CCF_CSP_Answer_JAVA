package ccf.csp;

import java.util.Scanner;

public class CCF2015_12_1 {
/*
 * 试题编号：	201512-1
	试题名称：	数位之和
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　给定一个十进制整数n，输出n的各位数字之和。
	输入格式
	　　输入一个整数n。
	输出格式
	　　输出一个整数，表示答案。
	样例输入
	20151220
	样例输出
	13
	样例说明
	　　20151220的各位数字之和为2+0+1+5+1+2+2+0=13。
	评测用例规模与约定
	　　所有评测用例满足：0 ≤ n ≤ 1000000000。
 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		char[] input = scanner.nextLine().toCharArray();
		int[] result = new int[input.length];
		for (int i = 0; i < input.length; i++)
		{
			switch (input[i]) {
			case '0':
				result[i] = 0;
				break;
			case '1':
				result[i] = 1;
				break;
			case '2':
				result[i] = 2;
				break;
			case '3':
				result[i] = 3;
				break;
			case '4':
				result[i] = 4;
				break;
			case '5':
				result[i] = 5;
				break;
			case '6':
				result[i] = 6;
				break;
			case '7':
				result[i] = 7;
				break;
			case '8':
				result[i] = 8;
				break;
			case '9':
				result[i] = 9;
				break;
			default:
				break;
		}
		
		}
		int output = 0;
		for (int i = 0; i < result.length; i++)
		{
			output+=result[i];
		}
		System.out.println(output);
	}
}
