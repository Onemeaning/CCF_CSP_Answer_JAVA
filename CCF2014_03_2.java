package ccf.csp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CCF2014_03_2 {
/*
 * 问题描述
	　　在某图形操作系统中,有 N 个窗口,每个窗口都是一个两边与坐标轴分别平行的矩形区域。窗口的边界上的点也属于该窗口。窗口之间有层次的区别,在多于一个窗口重叠的区域里,只会显示位于顶层的窗口里的内容。
	　　当你点击屏幕上一个点的时候,你就选择了处于被点击位置的最顶层窗口,并且这个窗口就会被移到所有窗口的最顶层,而剩余的窗口的层次顺序不变。如果你点击的位置不属于任何窗口,则系统会忽略你这次点击。
	　　现在我们希望你写一个程序模拟点击窗口的过程。
	输入格式
	　　输入的第一行有两个正整数,即 N 和 M。(1 ≤ N ≤ 10,1 ≤ M ≤ 10)
	　　接下来 N 行按照从最下层到最顶层的顺序给出 N 个窗口的位置。 每行包含四个非负整数 x1, y1, x2, y2,表示该窗口的一对顶点坐标分别为 (x1, y1) 和 (x2, y2)。保证 x1 < x2,y1 2。
	　　接下来 M 行每行包含两个非负整数 x, y,表示一次鼠标点击的坐标。
	　　题目中涉及到的所有点和矩形的顶点的 x, y 坐标分别不超过 2559 和　　1439。
	输出格式
	　　输出包括 M 行,每一行表示一次鼠标点击的结果。如果该次鼠标点击选择了一个窗口,则输出这个窗口的编号(窗口按照输入中的顺序从 1 编号到 N);如果没有,则输出"IGNORED"(不含双引号)。
	样例输入
	3 4
	0 0 4 4
	1 1 5 5
	2 2 6 6
	1 1
	0 0
	4 4
	0 5
	样例输出
	2
	1
	1
	IGNORED
	样例说明
	　　第一次点击的位置同时属于第 1 和第 2 个窗口,但是由于第 2 个窗口在上面,它被选择并且被置于顶层。
	　　第二次点击的位置只属于第 1 个窗口,因此该次点击选择了此窗口并将其置于顶层。现在的三个窗口的层次关系与初始状态恰好相反了。
	　　第三次点击的位置同时属于三个窗口的范围,但是由于现在第 1 个窗口处于顶层,它被选择。
	　　最后点击的 (0, 5) 不属于任何窗口。
 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		List<Window> windows = new ArrayList<>();
		List<Click> clicks = new ArrayList<>();
		Map<Window,Integer> wMap = new LinkedHashMap<>();
		
		//存储窗口以及对应的窗口号
		for(int i = 0;i<n;i++) {
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			Window window = new Window(x1, y1, x2, y2);
			wMap.put(window,i+1);		
		}		
		
		//存储点击事件的坐标
		for (int i = 0; i < m; i++)
		{
			int x = scanner.nextInt();
			int y =scanner.nextInt();
			Click click = new Click(x, y);
			clicks.add(click);
		}
		
		//倒序取出,为了从窗口顶部开始遍历
		for (Window window : wMap.keySet())
		{
			windows.add(0, window);
		}
				
		int index = n;//当前窗口序号;
		int flagindex = 0;//记录当前遍历窗口的位置；
		List<String> output = new ArrayList<>();
		for (Click click : clicks)
		{
			for (Window window : windows)
			{
				if (click.x >= window.x1 && click.x <= window.x2 && click.y>=window.y1 && click.y<=window.y2)
				{
					output.add(wMap.get(window)+"");
					
					//将点击的窗口置于最上层
					windows.add(0,window);
					windows.remove(flagindex+1);
					break;
				}
				else {
					index--;
				}
				flagindex++;
			}
			if (index==0)
			{
				output.add("IGNORED");
			}
			index = n;
			flagindex = 0;
		}
		
		
		for (String string : output)
		{
			System.out.println(string);
		}
		
	}
	
	
}
class Window{
	int x1;
	int y1;
	public Window(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	int x2;
	int y2;
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	@Override
	public String toString() {
		return "Window [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
	}	
	
}

class Click{
	public Click(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	int x;
	int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Click [x=" + x + ", y=" + y + "]";
	}
	
}