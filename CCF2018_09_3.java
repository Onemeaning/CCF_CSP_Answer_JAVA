package ccf.csp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CCF2018_09_3 {
/*
 * 元素选择器，
 * 层叠样式表（CSS）是一种用来为结构化文档添加样式的计算机语言；
 * 
 * 11 5
	html
	..head
	....title
	..body
	....h1
	....p #subtitle
	....div #main
	......h2
	......p #one
	......div
	........p #two
	p
	#subtitle
	h3
	div p
	div div p
 */
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] para = scanner.nextLine().trim().split(" ");
		int m = Integer.parseInt(para[0]);
		int n = Integer.parseInt(para[1]);
		List<Documnet> documnets = new ArrayList<>();
		List<List<Integer>> output = new ArrayList<>();
		
		for (int i = 0; i < m; i++)
		{
			String[] line = scanner.nextLine().trim().split(" ");
			Documnet documnet = null;
			int indentCount = 0;
			while(line[0].startsWith("."))
			{
				line[0] =  line[0].substring(1);
				indentCount++;
			}
			if (line.length > 1)
			{
				documnet = new Documnet(line[0], line[1], indentCount);
			}
			else
			{
				documnet = new Documnet(line[0], "", indentCount);
			}
			documnets.add(documnet);			
		}
		
		for (int i = 0; i < n; i++)
		{
			String[] line = scanner.nextLine().trim().split(" ");
			List<Integer> list = new ArrayList<>();;
			int count = 0;
			for (int j = 0; j < m; j++)
			{
				
				Documnet documnet = documnets.get(j);
						
				if (line.length == 1) //
				{
					if (!line[0].startsWith("#"))
					{
						if (documnet.tag.equals(line[0]))
						{
							list.add(j+1);
							count++;
						}
						
					}
					else
					{
						if (documnet.id.equals(line[0]))
						{
							list.add(j+1);
							count++;
						}
						
					}
				}
				else if (line.length == 2)
				{
					if (documnet.tag.equals(line[0]))
					{
						int indent = documnet.indent;
						for (int k = j+1; k < m; k++)
						{
							Documnet adocumnet = documnets.get(k);
							if (line[1].equals(adocumnet.tag) && adocumnet.indent == indent+2)
							{
								list.add(k+1);
								count++;
							}
						}
					}
				}
				
				else if (line.length == 3)
				{
					if (documnet.tag.equals(line[0]))
					{
						int indent = documnet.indent;
						for (int k = j+1; k < m; k++)
						{
							Documnet adocumnet = documnets.get(k);
							if (line[1].equals(adocumnet.tag) && adocumnet.indent == indent+2)
							{
									for (int q = k+1; q < m; q++)
									{
										Documnet bdocumnet = documnets.get(q);
										if (line[2].equals(bdocumnet.tag) && bdocumnet.indent == adocumnet.indent+2)
										{
											list.add(q+1);
											count++;
										}
									}
							}
						}
					}
				}
			}
			list.add(0,count);
			output.add(list);
		}
		
		for (List<Integer> list : output)
		{
			for (Integer list2 : list)
			{
				System.out.print(list2 + " ");
			}
			System.out.println();
		}
	}
}

class Documnet{
	String tag;
	String id;
	Integer indent;
	
	public Documnet(String tag, String id, Integer indent) {
		super();
		this.tag = tag;
		this.id = id;
		this.indent = indent;
	}

	@Override
	public String toString() {
		return "Documnet [tag=" + tag + ", id=" + id + ", indent=" + indent + "]";
	}
	
	
}
