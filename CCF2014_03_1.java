package ccf.csp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CCF2014_03_1 {
	/*
	 * 问题描述
		　　有 N 个非零且各不相同的整数。请你编一个程序求出它们中有多少对相反数(a 和 -a 为一对相反数)。
		输入格式
		　　第一行包含一个正整数 N。(1 ≤ N ≤ 500)。
		　　第二行为 N 个用单个空格隔开的非零整数,每个数的绝对值不超过1000,保证这些整数各不相同。
		输出格式
		　　只输出一个整数,即这 N 个数中包含多少对相反数。
		样例输入
		5
		1 2 3 -1 -2
		样例输出
		2
	 */
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] input = scanner.nextLine().trim().split(" ");
		int[] inputInt = new int[n];
		for (int i = 0; i < input.length; i++)
		{
			inputInt[i] = Integer.parseInt(input[i]);
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++)
		{
			set.add(inputInt[i]);
		}
		
		int counts = 0;
		for (Integer integer : set)
		{
			if (set.contains(-integer))
			{
				counts++;
			}
		}
		System.out.println(counts/2);
		
	}
}
