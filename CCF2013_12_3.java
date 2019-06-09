package ccf.csp;

import java.util.Scanner;

public class CCF2013_12_3 {
/*
 * 问题描述
	　　在横轴上放了n个相邻的矩形，每个矩形的宽度是1，而第i（1 ≤ i ≤ n）个矩形的高度是hi。这n个矩形构成了一个直方图。例如，下图中六个矩形的高度就分别是3, 1, 6, 5, 2, 3。
		
	　　请找出能放在给定直方图里面积最大的矩形，它的边要与坐标轴平行。对于上面给出的例子，最大矩形如下图所示的阴影部分，面积是10。
	
	输入格式
	　　第一行包含一个整数n，即矩形的数量(1 ≤ n ≤ 1000)。
	　　第二行包含n 个整数h1, h2, … , hn，相邻的数之间由空格分隔。(1 ≤ hi ≤ 10000)。hi是第i个矩形的高度。
	输出格式
	　　输出一行，包含一个整数，即给定直方图内的最大矩形的面积。
	样例输入
	6
	3 1 6 5 2 3
	样例输出
	10
 */
	public static void main(String[] args) {
		int width = 0;
		int height = 0;

		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		int[] area = new int[n];//存储面积
		
		String[] input = scanner.nextLine().trim().split(" ");
		int [] hi = new int[n];
		for (int i = 0; i < n; i++)
		{
			hi[i] = Integer.parseInt(input[i]);
		}
		
		for (int i = 0; i < n; i++)
		{
			width = 0;
			height = hi[i];
			int index = i;
			
			//往左遍历
			while(index >= 0 && hi[index] >= height) {
				index--;
				width++;				
			}
			
			index = i+1;
			
			//往右遍历
			while(index < n && hi[index] >= height) {
				index++;
				width++;				
			}
			
			area[i] = width*height;
		}
		int maxArea = 0;
		for (int i = 0; i < n; i++)
		{
			if (area[i]>maxArea)
			{
				maxArea = area[i];
			}
		}
		System.out.println(maxArea);
		
	}
}
