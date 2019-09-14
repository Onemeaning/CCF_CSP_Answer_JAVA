package ccf.csp;

import java.util.Scanner;

public class CCF2016_12_2 {
/*
 * 201612-2
	试题名称：	工资计算
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　小明的公司每个月给小明发工资，而小明拿到的工资为交完个人所得税之后的工资。假设他一个月的税前工资（扣除五险一金后、未扣税前的工资）为S元，则他应交的个人所得税按如下公式计算：
	　　1） 个人所得税起征点为3500元，若S不超过3500，则不交税，3500元以上的部分才计算个人所得税，令A=S-3500元；
	　　2） A中不超过1500元的部分，税率3%；
	　　3） A中超过1500元未超过4500元的部分，税率10%；
	　　4） A中超过4500元未超过9000元的部分，税率20%；
	　　5） A中超过9000元未超过35000元的部分，税率25%；
	　　6） A中超过35000元未超过55000元的部分，税率30%；
	　　7） A中超过55000元未超过80000元的部分，税率35%；
	　　8） A中超过80000元的部分，税率45%；
	　　例如，如果小明的税前工资为10000元，则A=10000-3500=6500元，其中不超过1500元部分应缴税1500×3%=45元，超过1500元不超过4500元部分应缴税(4500-1500)×10%=300元，超过4500元部分应缴税(6500-4500)×20%=400元。总共缴税745元，税后所得为9255元。
	　　已知小明这个月税后所得为T元，请问他的税前工资S是多少元。
	输入格式
	　　输入的第一行包含一个整数T，表示小明的税后所得。所有评测数据保证小明的税前工资为一个整百的数。
	输出格式
	　　输出一个整数S，表示小明的税前工资。
	样例输入
	9255
	样例输出
	10000
	评测用例规模与约定
	　　对于所有评测用例，1 ≤ T ≤ 100000。
 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int salary = scanner.nextInt();
		int[] tax = new int[] {0,45,300,900,6500,6000,8750};
		if (salary <=3500)
		{
			System.out.println((int)salary);
		}
		else if (salary>3500 && salary <= 5000)
		{
			System.out.println((int)((salary+tax[0]-3500*0.03)/(1-0.03)));
		}
		else if (salary>5000 && salary <= 8000)
		{
			System.out.println((int)((salary+tax[0]+tax[1]-5000*0.1)/(1-0.1)));
		}
		else if (salary>8000 && salary <= 12500)
		{
			System.out.println((int)((salary+tax[0]+tax[1]+tax[2]-8000*0.2)/(1-0.2)));
		}
		
		else if (salary>12500 && salary <= 38500)
		{
			System.out.println((int)((salary+tax[0]+tax[1]+tax[2]+tax[3]-12500*0.25)/(1-0.25)));
		}
		
		else if (salary>38500 && salary <= 58500)
		{
			System.out.println((int)((salary+tax[0]+tax[1]+tax[2]+tax[3]+tax[4]-38500*0.3)/(1-0.3)));
		}
		else if (salary>58500 && salary <= 83500)
		{
			System.out.println((int)((salary+tax[0]+tax[1]+tax[2]+tax[3]+tax[4]+tax[5]-58500*0.35)/(1-0.35)));
		}
		else
		{
			System.out.println((int)((salary+tax[0]+tax[1]+tax[2]+tax[3]+tax[4]+tax[5]+tax[6]-83500*0.45)/(1-0.45)));
		}
			
	}
}
