package ccf.csp;

import java.util.Arrays;
import java.util.Scanner;

public class CCF2014_09_1 {
/*
	 * 试题编号：	201409-1
	试题名称：	相邻数对
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　给定n个不同的整数，问这些数中有多少对整数，它们的值正好相差1。
	输入格式
	　　输入的第一行包含一个整数n，表示给定整数的个数。
	　　第二行包含所给定的n个整数。
	输出格式
	　　输出一个整数，表示值正好相差1的数对的个数。
	样例输入
	6
	10 2 6 3 7 8
	样例输出
	3
	样例说明
	　　值正好相差1的数对包括(2, 3), (6, 7), (7, 8)。
	评测用例规模与约定
	　　1<=n<=1000，给定的整数为不超过10000的非负整数。
 */
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 int n = scanner.nextInt();
		 int[] input = new int[n];
		 int[] result = new int[n-1]; 
		for (int i = 0; i < n; i++)
		{
			input[i] = scanner.nextInt();
		}
		Arrays.sort(input);
		for (int i = 0; i < n-1; i++)
		{
			result[i] = input[i+1]-input[i];
		} 
		int resultcount = 0;
		for (int i = 0; i < result.length; i++)
		{
			if (result[i]==1)
			{
				resultcount++;
			}
		} 
		 
		System.out.println(resultcount); 
		
	}
	
	
	
}
