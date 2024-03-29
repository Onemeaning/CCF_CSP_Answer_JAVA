package ccf.csp;

import java.util.Scanner;

/*
 * 试题编号：	201803-2
	试题名称：	碰撞的小球
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　数轴上有一条长度为L（L为偶数)的线段，左端点在原点，右端点在坐标L处。有n个不计体积的小球在线段上，开始时所有的小球都处在偶数坐标上，速度方向向右，速度大小为1单位长度每秒。
	　　当小球到达线段的端点（左端点或右端点）的时候，会立即向相反的方向移动，速度大小仍然为原来大小。
	　　当两个小球撞到一起的时候，两个小球会分别向与自己原来移动的方向相反的方向，以原来的速度大小继续移动。
	　　现在，告诉你线段的长度L，小球数量n，以及n个小球的初始位置，请你计算t秒之后，各个小球的位置。
	提示
	　　因为所有小球的初始位置都为偶数，而且线段的长度为偶数，可以证明，不会有三个小球同时相撞，小球到达线段端点以及小球之间的碰撞时刻均为整数。
	　　同时也可以证明两个小球发生碰撞的位置一定是整数（但不一定是偶数）。
	输入格式
	　　输入的第一行包含三个整数n, L, t，用空格分隔，分别表示小球的个数、线段长度和你需要计算t秒之后小球的位置。
	　　第二行包含n个整数a1, a2, …, an，用空格分隔，表示初始时刻n个小球的位置。
	输出格式
	　　输出一行包含n个整数，用空格分隔，第i个整数代表初始时刻位于ai的小球，在t秒之后的位置。
	样例输入
	3 10 5
	4 6 8
	样例输出
	7 9 9
	样例说明
	　　初始时，三个小球的位置分别为4, 6, 8。
	
	　　一秒后，三个小球的位置分别为5, 7, 9。
	
	　　两秒后，第三个小球碰到墙壁，速度反向，三个小球位置分别为6, 8, 10。
	
	　　三秒后，第二个小球与第三个小球在位置9发生碰撞，速度反向（注意碰撞位置不一定为偶数），三个小球位置分别为7, 9, 9。
	
	　　四秒后，第一个小球与第二个小球在位置8发生碰撞，速度反向，第三个小球碰到墙壁，速度反向，三个小球位置分别为8, 8, 10。
	
	　　五秒后，三个小球的位置分别为7, 9, 9。
	
	样例输入
	10 22 30
	14 12 16 6 10 2 8 20 18 4
	样例输出
	6 6 8 2 4 0 4 12 10 2
	数据规模和约定
	　　对于所有评测用例，1 ≤ n ≤ 100，1 ≤ t ≤ 100，2 ≤ L ≤ 1000，0 < ai < L。L为偶数。
	　　保证所有小球的初始位置互不相同且均为偶数。
 */
public class CCF2018_03_2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); //小球的个数
		int l = scanner.nextInt(); //线段的长度
		int t = scanner.nextInt(); //经历的时刻
		
		int[] currentPosition = new int[n]; //存储初始时刻的小球的位置
		int[] prePosition =  new int[n]; //存储上一次小球的位置
		int[] state = new int[n];  // 存储小球的运动状态
		
		for (int i = 0; i < n; i++) //小球的初始运动方向都是向右的，我们这里使用1表示向右运动，用-1表示向左运动；
		{
			state[i] = 1;
		}
		
		for (int i = 0; i < n; i++) //初始化小球的初始位置，这个是由题设决定的
		{
			currentPosition[i] = scanner.nextInt();
		}
		
		
		int state1 = 0;
		int state2 = 0;
		
		for (int i = 0; i < t; i++) //t次循环中更新每个转态的信息
		{
			
			for (int j = 0; j < n; j++)
			{
				prePosition[j] = currentPosition[j];
			}
			
			
			for (state1 = 0; state1 < n; state1++)
			{
				//与边缘碰撞的时候
				if (currentPosition[state1] == 0 && state[state1] == -1 || currentPosition[state1] == l && state[state1] == 1)
				{
					state[state1] = -state[state1]; 
				}
				// 小球之间的碰撞
				else 
				{
					for(state2 = 0;state2 < n ;state2 ++ )
					{
						if (prePosition[state2] == prePosition[state1] && state1 != state2)
						{
							state[state1] = -state[state1];
						}
					}
				}
				
				currentPosition[state1] = prePosition[state1] + state[state1];
				
				
			}
				
		}
		
		for (int i = 0; i < n; i++)
		{
			System.out.print(currentPosition[i] + " ");
			
		}
		
	}
	
}
