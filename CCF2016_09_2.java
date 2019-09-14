package ccf.csp;

import java.util.Scanner;

import sun.tools.jar.resources.jar;

public class CCF2016_09_2 {
/*
 * 试题编号：	201609-2
	试题名称：	火车购票
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　请实现一个铁路购票系统的简单座位分配算法，来处理一节车厢的座位分配。
	　　假设一节车厢有20排、每一排5个座位。为方便起见，我们用1到100来给所有的座位编号，第一排是1到5号，第二排是6到10号，依次类推，第20排是96到100号。
	　　购票时，一个人可能购一张或多张票，最多不超过5张。如果这几张票可以安排在同一排编号相邻的座位，则应该安排在编号最小的相邻座位。否则应该安排在编号最小的几个空座位中（不考虑是否相邻）。
	　　假设初始时车票全部未被购买，现在给了一些购票指令，请你处理这些指令。
	输入格式
	　　输入的第一行包含一个整数n，表示购票指令的数量。
	　　第二行包含n个整数，每个整数p在1到5之间，表示要购入的票数，相邻的两个数之间使用一个空格分隔。
	输出格式
	　　输出n行，每行对应一条指令的处理结果。
	　　对于购票指令p，输出p张车票的编号，按从小到大排序。
	样例输入
	4
	2 5 4 2
	样例输出
	1 2
	6 7 8 9 10
	11 12 13 14
	3 4
	样例说明
	　　1) 购2张票，得到座位1、2。
	　　2) 购5张票，得到座位6至10。
	　　3) 购4张票，得到座位11至14。
	　　4) 购2张票，得到座位3、4。
	评测用例规模与约定
	　　对于所有评测用例，1 ≤ n ≤ 100，所有购票数量之和不超过100。
 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] sits = new int[20][5];

		
		int n = scanner.nextInt();
		
		
		for (int i = 0; i < n; i++)
		{
			int need = scanner.nextInt();
			int space = 0;
			
			for (int row = 0; row < 20; row++)
			{
				int remains = 0;
				
				for (int column = 0; column < 5; column++)
				{			
					if (sits[row][column] == 0)
					{
						remains++;
					}
				}
				
				if (remains >= need)
				{
					space = (row+1)*5 -remains;
					while(need > 0)
					{
						space++;
						need--;
						sits[row][space-5*row-1] = 1;
						System.out.print(space+" ");
					}
					break;
				}
				
				else if (remains < need && row == 19) //整个车厢都找不到相邻的座位的情况下
				{
					for (int j = 0; j < 20; j++)
					{
						for (int j2 = 0; j2 < 5; j2++)
						{
							if (sits[j][j2] == 0 && need > 0)
							{
								need--;
								System.out.print((j*5+j2+1)+" ");
							}
						}
					}
				}
				
				
			}
			
			System.out.println();
		}
	}
}
