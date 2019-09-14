package ccf.csp;

import java.util.Scanner;

public class CCF2017_03_1 {
/*
 * 试题编号：	201703-1
	试题名称：	分蛋糕
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　小明今天生日，他有n块蛋糕要分给朋友们吃，这n块蛋糕（编号为1到n）的重量分别为a1, a2, …, an。小明想分给每个朋友至少重量为k的蛋糕。小明的朋友们已经排好队准备领蛋糕，对于每个朋友，小明总是先将自己手中编号最小的蛋糕分给他，当这个朋友所分得蛋糕的重量不到k时，再继续将剩下的蛋糕中编号最小的给他，直到小明的蛋糕分完或者这个朋友分到的蛋糕的总重量大于等于k。
	　　请问当小明的蛋糕分完时，总共有多少个朋友分到了蛋糕。
	输入格式
	　　输入的第一行包含了两个整数n, k，意义如上所述。
	　　第二行包含n个正整数，依次表示a1, a2, …, an。
	输出格式
	　　输出一个整数，表示有多少个朋友分到了蛋糕。
	样例输入
	6 9
	2 6 5 6 3 5
	样例输出
	3
	样例说明
	　　第一个朋友分到了前3块蛋糕，第二个朋友分到了第4、5块蛋糕，第三个朋友分到了最后一块蛋糕。
	评测用例规模与约定
	　　对于所有评测用例，1 ≤ n ≤ 1000，1 ≤ k ≤ 10000，1 ≤ ai ≤ 1000。
 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] input = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++)
		{
			input[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < n; i++)
		{
			int index = i;
			int sum = 0;
			while(index < n && sum < k )
			{
				sum += input[index];
				i = index;
				index++;			
			}
			count++;
		}
		System.out.println(count);
		
	}
}