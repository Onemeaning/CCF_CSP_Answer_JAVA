package ccf.csp;

import java.util.Scanner;
import java.util.Stack;

public class CCF2019_03_2 {

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		
		int output = 0;
		Stack<String> temp = new Stack<>();
		Stack<String> okData = new Stack<>();
		
		//输入字符串格式化,并处理乘除运算
		for (int i = 0; i < n; i++)
		{
			String line = scanner.nextLine();	
			
			for (int j = 0; j < line.length(); j++)
			{
				String aChar = String.valueOf(line.charAt(j));
				
				if (aChar.equals("+" ) || aChar.equals("-"))
				{
					temp.push(aChar);
				}
				else if (aChar.equals("x") )
				{
					int left = Integer.parseInt(temp.pop());
					j++;
					int right = Integer.parseInt(String.valueOf(line.charAt(j)));
					int result = left * right;
					temp.push(result+"");
				}
				
				else if (aChar.equals("/")) 
				{
					int left = Integer.parseInt(temp.pop());
					j++;
					int right = Integer.parseInt(String.valueOf(line.charAt(j)));
					int result = left / right;
					temp.push(result+"");
				}
				
				else
				{
					temp.push(aChar);
				}
										
			}
			
//			System.out.println(temp.toString());
			
			//更改出栈顺序,这样后面处理加减法的时候是正确的从左到右的云算法则;
			while(temp.size() > 0)
			{				
				okData.push(temp.pop());
			}
			
			
			//处理加减法运算
			while(okData.size()>1)
			{
				String rights = okData.pop();
				int right = 0;
				int left = 0;
				if (rights.startsWith("-"))
				{
					right = -Integer.parseInt(rights.substring(1));
				}
				else
				{
					right = Integer.parseInt(rights);
				}
				
				String opetion = okData.pop();
				
				
				String lefts = okData.pop();
				
				if (lefts.startsWith("-"))
				{
					left = -Integer.parseInt(lefts.substring(1));
				}
				else
				{
					left = Integer.parseInt(lefts);
				}
				
				
				if (opetion.equals("+"))
				{
					int result = right + left;
					okData.push(result+"");
				}
				else if(opetion.equals("-"))
				{
					int result = right - left ;
					okData.push(result+"");
				}
				
			}
			
			output = Integer.parseInt(okData.pop());
			
			if (output == 24)
			{
				System.out.println("Yes");
			}
			else 
			{
				System.out.println("No");
			}
		}
			
	}
}
