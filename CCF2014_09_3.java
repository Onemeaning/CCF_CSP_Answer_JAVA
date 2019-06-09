package ccf.csp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CCF2014_09_3 {
/**
 * 试题编号：	201409-3
	试题名称：	字符串匹配
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　给出一个字符串和多行文字，在这些文字中找到字符串出现的那些行。你的程序还需支持大小写敏感选项：当选项打开时，表示同一个字母的大写和小写看作不同的字符；当选项关闭时，表示同一个字母的大写和小写看作相同的字符。
	输入格式
	　　输入的第一行包含一个字符串S，由大小写英文字母组成。
	　　第二行包含一个数字，表示大小写敏感的选项，当数字为0时表示大小写不敏感，当数字为1时表示大小写敏感。
	　　第三行包含一个整数n，表示给出的文字的行数。
	　　接下来n行，每行包含一个字符串，字符串由大小写英文字母组成，不含空格和其他字符。
	输出格式
	　　输出多行，每行包含一个字符串，按出现的顺序依次给出那些包含了字符串S的行。
	样例输入
	Hello
	1
	5
	HelloWorld
	HiHiHelloHiHi
	GrepIsAGreatTool
	HELLO
	HELLOisNOTHello
	样例输出
	HelloWorld
	HiHiHelloHiHi
	HELLOisNOTHello
	样例说明
	　　在上面的样例中，第四个字符串虽然也是Hello，但是大小写不正确。如果将输入的第二行改为0，则第四个字符串应该输出。
	评测用例规模与约定
	　　1<=n<=100，每个字符串的长度不超过100
 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String regex = scanner.nextLine();
		int switcher = Integer.parseInt(scanner.nextLine().trim());
		int n = Integer.parseInt(scanner.nextLine().trim());
		List<String> samples = new ArrayList<>();
		List<String> results = new ArrayList<>();
		for (int i = 0; i < n; i++)
		{
			samples.add(scanner.nextLine().trim());
		}
		
		String aRegex = "";
		
		switch (switcher) 
		{		
		case 0://大小写不敏感
			aRegex = regex.toUpperCase();			
			for (String string : samples)
			{
				String sample = string.toUpperCase();
				while (sample.length()>0 && !sample.startsWith(aRegex))
				{
					sample = sample.substring(1);
				}
				if (sample.length()>=aRegex.length())
				{
					results.add(string);
				}

			}
									
			break;

		case 1://大小写敏感
			
			aRegex = regex;			
			for (String string : samples)
			{
				String sample = string;
				while (sample.length()>0 && !sample.startsWith(aRegex))
				{
					sample = sample.substring(1);
				}
				if (sample.length()>=aRegex.length())
				{
					results.add(string);
				}

			}
			break;
		}
				
		for (String string : results)
		{
			System.out.println(string);
	    }
		
	}
			
}
