package ccf.csp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class CCF2014_09_2 {
/*
	 * 试题编号：	201409-2
	试题名称：	画图
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　在一个定义了直角坐标系的纸上，画一个(x1,y1)到(x2,y2)的矩形指将横坐标范围从x1到x2，纵坐标范围从y1到y2之间的区域涂上颜色。
	　　下图给出了一个画了两个矩形的例子。第一个矩形是(1,1) 到(4, 4)，用绿色和紫色表示。第二个矩形是(2, 3)到(6, 5)，用蓝色和紫色表示。图中，一共有15个单位的面积被涂上颜色，其中紫色部分被涂了两次，但在计算面积时只计算一次。在实际的涂色过程中，所有的矩形都涂成统一的颜色，图中显示不同颜色仅为说明方便。
	
	　　给出所有要画的矩形，请问总共有多少个单位的面积被涂上颜色。
	输入格式
	　　输入的第一行包含一个整数n，表示要画的矩形的个数。
	　　接下来n行，每行4个非负整数，分别表示要画的矩形的左下角的横坐标与纵坐标，以及右上角的横坐标与纵坐标。
	输出格式
	　　输出一个整数，表示有多少个单位的面积被涂上颜色。
	样例输入
	2
	1 1 4 4
	2 3 6 5
	样例输出
	15
	评测用例规模与约定
　　1<=n<=100，0<=横坐标、纵坐标<=100。
 */
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int x1,x2,y1,y2;
		int[][] rectangle = new int[100][100];
		for (int i = 0; i < n; i++)
		{
			x1 = scanner.nextInt();
			y1 = scanner.nextInt();
			x2 = scanner.nextInt();
			y2 = scanner.nextInt();
			
			for (int j =x1; j < x2; j++)
			{
				for (int k = y1; k < y2; k++)
				{
					rectangle[j][k] = 1;
				}
			}
		}
		
		int area = 0;
		for (int i = 0; i < rectangle.length; i++)
		{
			for (int j = 0; j < rectangle.length; j++)
			{
				if (rectangle[i][j]==1)
				{
					area++;
				}
				
			}
		}
		
		System.out.println(area);
	}
}
//		Collections.sort(rectangles,new locationComp());
//		
//		System.out.println(rectangles);
//		
//		long overlap = 0;
//		long totalArea = 0;
//		for (int i = 0; i < rectangles.size(); i++)
//		{
//			Rectangle base = rectangles.get(i);
//			totalArea =  totalArea + base.area();
//			for (int j = i+1; j < rectangles.size(); j++)
//			{
//				Rectangle compare = rectangles.get(j);
//				if (compare.x1 >= base.x2 || compare.y2 <= base.y1 || compare.y1 >= base.y2)//没有重叠区域
//				{
//					break;
//				}
//				else 
//				{
//					if (compare.y2 < base.y2 && compare.y1 < base.y1)
//					{
//						if (compare.x2 < base.x2)
//						{
//							overlap = overlap+(compare.x2-compare.x1)*(compare.y2-base.y1);
//						}
//						else
//						{
//							overlap = overlap+(base.x2-compare.x1)*(compare.y2-base.y1);
//						}
//						
//					}
//					
//					
//					else if(compare.y2 < base.y2 && compare.y1 >= base.y1 )
//					{
//						if (compare.x2 < base.x2)
//						{
//							overlap = overlap+(compare.x2-compare.x1)*(compare.y2-compare.y1);
//						}
//						else
//						{
//							overlap = overlap+(base.x2-compare.x1)*(compare.y2-compare.y1);
//						}
//					}
//					
//					else if(compare.y2 >= base.y2 && compare.y1 >= base.y1 )
//					{
//						if (compare.x2 < base.x2)
//						{
//							overlap = overlap+(compare.x2-compare.x1)*(base.y2-compare.y1);
//						}
//						else
//						{
//							overlap = overlap+(base.x2-compare.x1)*(base.y2-compare.y1);
//						}
//					}
//					
//				}
//				System.out.println("overlap"+overlap);
//				totalArea = totalArea -overlap;	
//				overlap = 0;
//
//			}
//		}
//		System.out.println( totalArea +"-"+ overlap +"=" + (totalArea-overlap) );
//	}
//}
//class Rectangle{
//	
//	int x1;
//	int x2;
//	int y1;
//	int y2;
//	
//	public Rectangle(int x1, int x2, int y1, int y2) {
//		super();
//		this.x1 = x1;
//		this.x2 = x2;
//		this.y1 = y1;
//		this.y2 = y2;
//	}
//	public int getX1() {
//		return x1;
//	}
//	public void setX1(int x1) {
//		this.x1 = x1;
//	}
//	public int getX2() {
//		return x2;
//	}
//	public void setX2(int x2) {
//		this.x2 = x2;
//	}
//	public int getY1() {
//		return y1;
//	}
//	public void setY1(int y1) {
//		this.y1 = y1;
//	}
//	public int getY2() {
//		return y2;
//	}
//	public void setY2(int y2) {
//		this.y2 = y2;
//	}
//	@Override
//	public String toString() {
//		return "Rectangle [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
//	}
//	
//	public  long area() {
//		return (x2-x1)*(y2-y1);
//	}
//	
//	
//}
//
//class locationComp implements Comparator<Rectangle>{
//
//	@Override
//	public int compare(Rectangle o1, Rectangle o2) {
//		
//		if (o1.x1 < o2.x1)
//		{
//			return -1;
//		}
//		else if (o1.x1 > o2.x1)
//		{
//			return 1;
//		}
//		
//		else 
//		{			
//			if (o1.y1 < o2.y1)
//			{
//				return -1;
//			}
//			else if (o1.y1 > o2.y1)
//			{
//				return 1;
//			}
//			else {
//				return 0;
//			}
//		}
//		
//	}
//
//
//
//  
//
//}
