package ccf.csp;

import java.util.Scanner;

public class CCF2019_03_1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] samples = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			samples[i] = scanner.nextInt();
		}
		
		if (samples[n-1] > samples[0]) //升序
		{
			System.out.print(samples[n-1]+" ");//最大值
			
			if (n % 2 == 0)//偶数个数
			{
				if( (samples[n/2-1]+samples[n/2]) % 2 == 0) //是个整数
				{
					int medium = (samples[n/2-1]+samples[n/2])/2;
					System.out.print(medium+" ");
				}
				else
				{
					double medium = (samples[n/2-1]+samples[n/2])/2.0;
					System.out.print(String.format("%.1f", medium)+" ");
				}
										
			}
			
			else //奇数个数
			{
				int medium = samples[n/2];
				System.out.print(medium+" ");
			}
			
			System.out.print(samples[0]); //最小值
					
		}
		else //降序
		{
			
			System.out.print(samples[0]+" ");//最大值
			if (n % 2 == 0)//偶数个数
			{
				
				if( (samples[n/2-1]+samples[n/2]) % 2 == 0) //是个整数
				{
					int medium = (samples[n/2-1]+samples[n/2])/2;
					System.out.print(medium+" ");
				}
				else
				{
					double medium = (samples[n/2-1]+samples[n/2])/2.0;
					System.out.print(String.format("%.1f", medium)+" ");
				}
				
			}
			else //奇数个数
			{
				int medium = samples[n/2];
				System.out.print(medium+" ");
			}
			
			System.out.print(samples[n-1]);//最小值
		}
	}
}
