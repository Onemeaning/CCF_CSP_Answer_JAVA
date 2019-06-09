package ccf.csp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
	 * 问题描述
	　　给定n个正整数，找出它们中出现次数最多的数。如果这样的数有多个，请输出其中最小的一个。
	输入格式
	　　输入的第一行只有一个正整数n(1 ≤ n ≤ 1000)，表示数字的个数。
	　　输入的第二行有n个整数s1, s2, …, sn (1 ≤ si ≤ 10000, 1 ≤ i ≤ n)。相邻的数用空格分隔。
	输出格式
	　　输出这n个次数中出现次数最多的数。如果这样的数有多个，输出其中最小的一个。
	样例输入
	6
	10 1 10 20 30 20
	样例输出
	10
 * @author Meanlam
 *
 */
public class CCF2013_12_1 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] input = scanner.nextLine().trim().split(" ");
		
		int maxValues = 0;
		int minKey = 0;
		List<Integer> outkey = new ArrayList<>();
		Map<Integer, Integer> result = new HashMap<>();
		for (int i = 0; i < n; i++)
		{
			Integer key = Integer.parseInt(input[i]);
			Integer value = result.get(key);
			if (value==null)
			{
				result.put(key, 1);			
			}
			else {	
			   value = value+1;
			   result.put(key, value);
			}
		}
		
		for (int t : result.values())
		{
			if (t>maxValues)
			{
				maxValues = t;
			}
		}

				
		for (Map.Entry<Integer, Integer> entry : result.entrySet())
		{
			if (entry.getValue()==maxValues)
			{
				outkey.add(entry.getKey());
			}
		}
		
		if (outkey.size()>0)
		{
			minKey = outkey.get(0);
			for (Integer out : outkey)
			{
				if (out<minKey)
				{
					minKey = out;
				}
			}
		}
		System.out.println(minKey);
		
	}

}
