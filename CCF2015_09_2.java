package ccf.csp;

import java.util.Scanner;

public class CCF2015_09_2 {
/*
 * 试题编号：	201509-2
	试题名称：	日期计算
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　给定一个年份y和一个整数d，问这一年的第d天是几月几日？
	　　注意闰年的2月有29天。满足下面条件之一的是闰年：
	　　1） 年份是4的整数倍，而且不是100的整数倍；
	　　2） 年份是400的整数倍。
	输入格式
	　　输入的第一行包含一个整数y，表示年份，年份在1900到2015之间（包含1900和2015）。
	　　输入的第二行包含一个整数d，d在1至365之间。
	输出格式
	　　输出两行，每行一个整数，分别表示答案的月份和日期。
	样例输入
	2015
	80
	样例输出
	3
	21
	样例输入
	2000
	40
	样例输出
	2
	9
 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		int days = scanner.nextInt();
		
		int[] monthDays = new int[] {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int[] leapYearMonthDays = new int[] {0,31,29,31,30,31,30,31,31,30,31,30,31};
		int month = 0,lowBound = 0,upBound = 0;
		
		for (int i = 0; i < 12; i++)
		{
			if (isLeapYear(year))
			{
				lowBound += leapYearMonthDays[i];
				upBound += lowBound + leapYearMonthDays[i+1];
				if (days>lowBound && days < upBound)
				{
					month = i +1;
				}
			}
			else
			{
				lowBound += monthDays[i];
				upBound += lowBound + monthDays[i+1];
				if (days>lowBound && days < upBound)
				{
					month = i +1;
				}
			}
			
		}
					
		int counts = 0;
		if (isLeapYear(year))
		{			
			for (int i = 0; i < month-1; i++)
			{
				counts+=leapYearMonthDays[i+1];
			}
			
		}
		else {
			for (int i = 0; i < month-1; i++)
			{
				counts+=monthDays[i+1];
			}
		}
		
		
		System.out.println(month);	
		System.out.println(days-counts);
		
	
	}
	public static boolean isLeapYear(int year) {
		return (year%400==0||(year%4==0&&year%100!=0))?true : false;
	}
}
