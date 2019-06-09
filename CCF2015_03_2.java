package ccf.csp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CCF2015_03_2 {
/*
 * 试题编号：	201503-2
	试题名称：	数字排序
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　给定n个整数，请统计出每个整数出现的次数，按出现次数从多到少的顺序输出。
	输入格式
	　　输入的第一行包含一个整数n，表示给定数字的个数。
	　　第二行包含n个整数，相邻的整数之间用一个空格分隔，表示所给定的整数。
	输出格式
	　　输出多行，每行包含两个整数，分别表示一个给定的整数和它出现的次数。按出现次数递减的顺序输出。如果两个整数出现的次数一样多，则先输出值较小的，然后输出值较大的。
	样例输入
	12
	5 2 3 3 1 3 4 2 5 2 3 5
	样例输出
	3 4
	2 3
	5 3
	1 1
	4 1
	评测用例规模与约定
	　　1 ≤ n ≤ 1000，给出的数都是不超过1000的非负整数。
 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++)
		{
			int key = scanner.nextInt();
			Integer value = map.get(key);
			
			if (value == null)
			{
				map.put(key, 1);
			}
			else {
				value++;
				map.put(key, value);
			}			
		}
		List<Times> result = new ArrayList<>();
		for(Map.Entry<Integer, Integer> mEntry:map.entrySet()) {
			Times times  = new Times(mEntry.getKey(), mEntry.getValue());
			result.add(times);			
		}
		
		Collections.sort(result, new MyComparator());
		
		for (Times times : result)
		{
			System.out.println(times.getKey() +" "+  times.getValue());
		}
		
	}
}

class Times {
	Integer key;
	Integer value;
	public Times(Integer key, Integer value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	
	
}

class MyComparator implements Comparator<Times>
{

	@Override
	public int compare(Times o1, Times o2) {
		int value1 = o1.getValue();
		int value2 = o2.getValue();
		if (value1 != value2)
		{
			return (value1-value2) > 0 ? -1 : 1;
		}
		else {
			int key1 = o1.getKey();
			int key2 = o2.getKey();
			
			return (key1-key2) > 0 ? 1 : -1;
		}
	}


}
