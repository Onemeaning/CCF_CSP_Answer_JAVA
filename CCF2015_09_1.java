package ccf.csp;

import java.util.Scanner;

public class CCF2015_09_1 {
/*
 * 试题编号：      201509-1
	试题名称：	数列分段
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　给定一个整数数列，数列中连续相同的最长整数序列算成一段，问数列中共有多少段？
	输入格式
	　　输入的第一行包含一个整数n，表示数列中整数的个数。
	　　第二行包含n个整数a1, a2, …, an，表示给定的数列，相邻的整数之间用一个空格分隔。
	输出格式
	　　输出一个整数，表示给定的数列有多个段。
	样例输入
	8
	8 8 8 0 12 12 8 0
	样例输出
	5
	样例说明
	　　8 8 8是第一段，0是第二段，12 12是第三段，倒数第二个整数8是第四段，最后一个0是第五段。
	评测用例规模与约定
	　　1 ≤ n ≤ 1000，0 ≤ ai ≤ 1000。
 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] input = new int[n];
		for(int i = 0;i<n;i++)
		{
			input[i] = scanner.nextInt();
		}
		int count=0,i = 0,j = 0;
		for (i = 0; i < n; i++)
		{	
			j = i+1;
			while(j < n && input[j] == input[i]  )
			{				
				i = j;	
				j++;
			}
			count ++;
		}
		System.out.println(count);
	}
}
