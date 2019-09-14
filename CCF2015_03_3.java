package ccf.csp;

import java.util.Scanner;

public class CCF2015_03_3 {
/*
 * 试题编号：	201503-3
	试题名称：	节日
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　有一类节日的日期并不是固定的，而是以“a月的第b个星期c”的形式定下来的，比如说母亲节就定为每年的五月的第二个星期日。
	　　现在，给你a，b，c和y1, y2(1850 ≤ y1, y2 ≤ 2050)，希望你输出从公元y1年到公元y2年间的每年的a月的第b个星期c的日期。
	　　提示：关于闰年的规则：年份是400的整数倍时是闰年，否则年份是4的倍数并且不是100的倍数时是闰年，其他年份都不是闰年。例如1900年就不是闰年，而2000年是闰年。
	　　为了方便你推算，已知1850年1月1日是星期二。
	输入格式
	　　输入包含恰好一行，有五个整数a, b, c, y1, y2。其中c=1, 2, ……, 6, 7分别表示星期一、二、……、六、日。
	输出格式
	　　对于y1和y2之间的每一个年份，包括y1和y2，按照年份从小到大的顺序输出一行。
	　　如果该年的a月第b个星期c确实存在，则以"yyyy/mm/dd"的格式输出，即输出四位数的年份，两位数的月份，两位数的日期，中间用斜杠“/”分隔，位数不足时前补零。
	　　如果该年的a月第b个星期c并不存在，则输出"none"（不包含双引号)。
	样例输入
	5 2 7 2014 2015
	样例输出
	2014/05/11
	2015/05/10
	评测用例规模与约定
	　　所有评测用例都满足：1 ≤ a ≤ 12，1 ≤ b ≤ 5，1 ≤ c ≤ 7，1850 ≤ y1, y2 ≤ 2050。
 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		int count = scanner.nextInt();
		int week = scanner.nextInt();
		
		int lowYear = scanner.nextInt();
		int upYear = scanner.nextInt();
		
		for(int year = lowYear;year<=upYear;year++) {
			int sumDay = sumDay(year);
			int daysCount = 0,firstDay = 0;
			switch (month) {
			case 1://一月
				firstDay = sumDay%7 + 2;//一月第一天是星期几,+2是因为1850年一月一号是星期二
				if (firstDay > 7)
				{
					firstDay = firstDay -7;		
				}
				if (firstDay <= week )
				{
					 daysCount = (count-1)*7 + (week - firstDay) ;				
				}
				else {
					
					daysCount = (count)*7 + (week - firstDay);				
				}
				
				daysCount = daysCount +1;
				if (daysCount > 31)
				{
					System.out.println("none");
				}
				else if(daysCount < 10) {
					System.out.println(year+"/"+"01"+"/0"+daysCount);
				}
				else {
					System.out.println(year+"/"+"01"+"/"+daysCount);
				}
				break;
				
			case 2:
				int flag = 0;
				if (isLeapYear(year))
				{
					flag = 29;
				}
				else {
					flag = 28;
				}
				sumDay =sumDay + 31;
				firstDay = sumDay%7 + 2;//一月第一天是星期几
				if (firstDay > 7)
				{
					firstDay = firstDay -7;				
				}
				
				if (firstDay <= week )
				{
					 daysCount = (count-1)*7 + (week - firstDay);				
				}
				else {
					
					daysCount = (count)*7 + (week - firstDay);				
				}
				daysCount = daysCount +1;
				
				if (daysCount > flag)
				{
					System.out.println("none");
				}
				else if(daysCount < 10) {
					System.out.println(year+"/"+"02"+"/0"+daysCount);
				}
				else {
					System.out.println(year+"/"+"02"+"/"+daysCount);
				}				
				break;
			case 3:
				if (isLeapYear(year))
				{
					sumDay = sumDay + 31 + 29;
				}
				else {
					sumDay = sumDay + 31 + 28;
				}
				
				firstDay = sumDay%7 + 2;//一月第一天是星期几
				if (firstDay > 7)
				{
					firstDay = firstDay -7;				
				}
				
				
				if (firstDay <= week )
				{
					 daysCount = (count-1)*7 + (week - firstDay);				
				}
				else {
					
					daysCount = (count)*7 + (week - firstDay);				
				}
				daysCount = daysCount +1;
				if (daysCount > 31)
				{
					System.out.println("none");
				}
				else if(daysCount < 10) {
					System.out.println(year+"/"+"03"+"/0"+daysCount);
				}
				else {
					System.out.println(year+"/"+"03"+"/"+daysCount);
				}				
				break;
				
			case 4:
				if (isLeapYear(year))
				{
					sumDay = sumDay + 31 + 29 +31;
				}
				else {
					sumDay = sumDay + 31 + 28 + 31;
				}
				
				firstDay = sumDay%7 + 2;//一月第一天是星期几
				if (firstDay > 7)
				{
					firstDay = firstDay -7;				
				}
				if (firstDay <= week )
				{
					 daysCount = (count-1)*7 + (week - firstDay);				
				}
				else {
					
					daysCount = (count)*7 + (week - firstDay);				
				}
				daysCount = daysCount +1;
				if (daysCount > 30)
				{
					System.out.println("none");
				}
				else if(daysCount < 10) {
					System.out.println(year+"/"+"04"+"/0"+daysCount);
				}
				else {
					System.out.println(year+"/"+"04"+"/"+daysCount);
				}		
				break;
			case 5:
				if (isLeapYear(year))
				{
					sumDay = sumDay + 31 + 29 + 31 +30;
				}
				else {
					sumDay = sumDay + 31 + 28 + 31 +30;
				}
				
				firstDay = sumDay%7 + 2;//一月第一天是星期几
				if (firstDay > 7)
				{
					firstDay = firstDay -7;				
				}
				if (firstDay <= week )
				{
					 daysCount = (count-1)*7 + (week - firstDay);				
				}
				else {
					
					daysCount = (count)*7 + (week - firstDay);				
				}
				daysCount = daysCount +1;
				if (daysCount > 31)
				{
					System.out.println("none");
				}
				else if(daysCount < 10) {
					System.out.println(year+"/"+"05"+"/0"+daysCount);
				}
				else {
					System.out.println(year+"/"+"05"+"/"+daysCount);
				}		
				break;
			case 6:
				if (isLeapYear(year))
				{
					sumDay = sumDay + 31 + 29 + 31 +30 + 31;
				}
				else {
					sumDay = sumDay + 31 + 28 + 31 + 30 + 31;
				}
				
				firstDay = sumDay%7 + 2;//一月第一天是星期几
				if (firstDay > 7)
				{
					firstDay = firstDay -7;				
				}
				if (firstDay <= week )
				{
					 daysCount = (count-1)*7 + (week - firstDay);				
				}
				else {
					
					daysCount = (count)*7 + (week - firstDay);				
				}
				daysCount = daysCount +1;
				if (daysCount > 30)
				{
					System.out.println("none");
				}
				else if(daysCount < 10) {
					System.out.println(year+"/"+"06"+"/0"+daysCount);
				}
				else {
					System.out.println(year+"/"+"06"+"/"+daysCount);
				}		
				break;
			case 7:
				
				if (isLeapYear(year))
				{
					sumDay = sumDay + 31 + 29 + 31 +30 + 31 + 30;
				}
				else {
					sumDay = sumDay + 31 + 28 + 31 + 30 + 31 +30;
				}
				
				firstDay = sumDay%7 + 2;//一月第一天是星期几
				if (firstDay > 7)
				{
					firstDay = firstDay -7;				
				}
				if (firstDay <= week )
				{
					 daysCount = (count-1)*7 + (week - firstDay);				
				}
				else {
					
					daysCount = (count)*7 + (week - firstDay);				
				}
				daysCount = daysCount +1;
				if (daysCount > 31)
				{
					System.out.println("none");
				}
				else if(daysCount < 10) {
					System.out.println(year+"/"+"07"+"/0"+daysCount);
				}
				else {
					System.out.println(year+"/"+"07"+"/"+daysCount);
				}		
				break;
			case 8:
				
				if (isLeapYear(year))
				{
					sumDay = sumDay + 31 + 29 + 31 +30 + 31 + 30 + 31;
				}
				else {
					sumDay = sumDay + 31 + 28 + 31 + 30 + 31 + 30 +31;
				}
				
				firstDay = sumDay%7 + 2;//一月第一天是星期几
				if (firstDay > 7)
				{
					firstDay = firstDay -7;				
				}
				if (firstDay <= week )
				{
					 daysCount = (count-1)*7 + (week - firstDay);				
				}
				else {
					
					daysCount = (count)*7 + (week - firstDay);				
				}
				daysCount = daysCount +1;
				if (daysCount > 31)
				{
					System.out.println("none");
				}
				else if(daysCount < 10) {
					System.out.println(year+"/"+"08"+"/0"+daysCount);
				}
				else {
					System.out.println(year+"/"+"08"+"/"+daysCount);
				}		
				break;
			case 9:
				if (isLeapYear(year))
				{
					sumDay = sumDay + 31 + 29 + 31 +30 + 31 + 30 + 31 + 31;
				}
				else {
					sumDay = sumDay + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
				}
				
				firstDay = sumDay%7 + 2;//一月第一天是星期几
				if (firstDay > 7)
				{
					firstDay = firstDay -7;				
				}
				if (firstDay <= week )
				{
					 daysCount = (count-1)*7 + (week - firstDay);				
				}
				else {
					
					daysCount = (count)*7 + (week - firstDay);				
				}
				daysCount = daysCount +1;
				if (daysCount > 30)
				{
					System.out.println("none");
				}
				else if(daysCount < 10) {
					System.out.println(year+"/"+"09"+"/0"+daysCount);
				}
				else {
					System.out.println(year+"/"+"09"+"/"+daysCount);
				}		
				break;
			case 10:
				if (isLeapYear(year))
				{
					sumDay = sumDay + 31 + 29 + 31 +30 + 31 + 30 + 31 + 31 + 30;
				}
				else {
					sumDay = sumDay + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
				}
				
				firstDay = sumDay%7 + 2;//一月第一天是星期几
				if (firstDay > 7)
				{
					firstDay = firstDay -7;				
				}
				if (firstDay <= week )
				{
					 daysCount = (count-1)*7 + (week - firstDay);				
				}
				else {
					
					daysCount = (count)*7 + (week - firstDay);				
				}
				
				if (daysCount > 31)
				{
					System.out.println("none");
				}
				else if(daysCount < 10) {
					System.out.println(year+"/"+"10"+"/0"+daysCount);
				}
				else {
					System.out.println(year+"/"+"10"+"/"+daysCount);
				}		
				break;

			case 11:
				
				if (isLeapYear(year))
				{
					sumDay = sumDay + 31 + 29 + 31 +30 + 31 + 30 + 31 + 31 + 30 + 31;
				}
				else {
					sumDay = sumDay + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
				}
				
				firstDay = sumDay%7 + 2;//一月第一天是星期几
				if (firstDay > 7)
				{
					firstDay = firstDay -7;				
				}
				if (firstDay <= week )
				{
					 daysCount = (count-1)*7 + (week - firstDay);				
				}
				else {
					
					daysCount = (count)*7 + (week - firstDay);				
				}
				daysCount = daysCount +1;
				if (daysCount > 30)
				{
					System.out.println("none");
				}
				else if(daysCount < 10) {
					System.out.println(year+"/"+"11"+"/0"+daysCount);
				}
				else {
					System.out.println(year+"/"+"11"+"/"+daysCount);
				}		
				break;
			case 12:
				
				if (isLeapYear(year))
				{
					sumDay = sumDay + 31 + 29 + 31 +30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
				}
				else {
					sumDay = sumDay + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
				}
				
				firstDay = sumDay%7 + 2;//一月第一天是星期几
				if (firstDay > 7)
				{
					firstDay = firstDay -7;				
				}
				if (firstDay <= week )
				{
					 daysCount = (count-1)*7 + (week - firstDay);				
				}
				else {
					
					daysCount = (count)*7 + (week - firstDay);				
				}
				daysCount = daysCount +1;
				if (daysCount > 31)
				{
					System.out.println("none");
				}
				else if(daysCount < 10) {
					System.out.println(year+"/"+"12"+"/0"+daysCount);
				}
				else {
					System.out.println(year+"/"+"12"+"/"+daysCount);
				}		
				break;
			}
									
		}
	}
	public static boolean isLeapYear(int year)
	{		
     return (year%400==0)||(year % 4 == 0 && year % 100 != 0)?true:false;		
	}
	
	public static int sumDay(int year) {
		
		int sumDay = 0;
		for (int i = 1850; i < year; i++)
		{
			if (isLeapYear(i))
			{
				sumDay +=  366;
			}
			else {
				sumDay += 365;
			}
			
		}
		return sumDay;
		
	}
	
}
