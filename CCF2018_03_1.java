package ccf.csp;

import java.util.Scanner;

/*
 * 试题编号：	201803-1
	试题名称：	跳一跳
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　近来，跳一跳这款小游戏风靡全国，受到不少玩家的喜爱。
	　　简化后的跳一跳规则如下：玩家每次从当前方块跳到下一个方块，如果没有跳到下一个方块上则游戏结束。
	　　如果跳到了方块上，但没有跳到方块的中心则获得1分；跳到方块中心时，若上一次的得分为1分或这是本局游戏的第一次跳跃则此次得分为2分，否则此次得分比上一次得分多两分（即连续跳到方块中心时，总得分将+2，+4，+6，+8...）。
	　　现在给出一个人跳一跳的全过程，请你求出他本局游戏的得分（按照题目描述的规则）。
	输入格式
	　　输入包含多个数字，用空格分隔，每个数字都是1，2，0之一，1表示此次跳跃跳到了方块上但是没有跳到中心，2表示此次跳跃跳到了方块上并且跳到了方块中心，0表示此次跳跃没有跳到方块上（此时游戏结束）。
	输出格式
	　　输出一个整数，为本局游戏的得分（在本题的规则下）。
	样例输入
	1 1 2 2 2 1 1 2 2 0
	样例输出
	22
	数据规模和约定
	　　对于所有评测用例，输入的数字不超过30个，保证0正好出现一次且为最后一个数字。
 */
public class CCF2018_03_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int score = 0;
		int lastScore = 0;
		while(n != 0) {
			
			if (n == 1)
			{				
				score += 1;
				lastScore = 1;
			}
			else 
			{
				if (lastScore == 1)
				{
					lastScore = lastScore + 1;					
				}
				else 
				{
					lastScore = lastScore + 2;		
				}
				
				score += lastScore;
			}
			
			n = scanner.nextInt();
		}
		System.out.println(score);
	}
}
