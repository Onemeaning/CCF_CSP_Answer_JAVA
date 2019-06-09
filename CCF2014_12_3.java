package ccf.csp;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CCF2014_12_3 {
/*
 * 试题编号：	201412-3
	试题名称：	集合竞价
	时间限制：	1.0s
	内存限制：	256.0MB
	问题描述：	
	问题描述
	　　某股票交易所请你编写一个程序，根据开盘前客户提交的订单来确定某特定股票的开盘价和开盘成交量。
	　　该程序的输入由很多行构成，每一行为一条记录，记录可能有以下几种：
	　　1. buy p s 表示一个购买股票的买单，每手出价为p，购买股数为s。
	　　2. sell p s 表示一个出售股票的卖单，每手出价为p，出售股数为s。
	　　3. cancel i表示撤销第i行的记录。
	　　如果开盘价为p0，则系统可以将所有出价至少为p0的买单和所有出价至多为p0的卖单进行匹配。因此，此时的开盘成交量为出价至少为p0的买单的总股数和所有出价至多为p0的卖单的总股数之间的较小值。
	　　你的程序需要确定一个开盘价，使得开盘成交量尽可能地大。如果有多个符合条件的开盘价，你的程序应当输出最高的那一个。
	输入格式
	　　输入数据有任意多行，每一行是一条记录。保证输入合法。股数为不超过108的正整数，出价为精确到恰好小数点后两位的正实数，且不超过10000.00。
	输出格式
	　　你需要输出一行，包含两个数，以一个空格分隔。第一个数是开盘价，第二个是此开盘价下的成交量。开盘价需要精确到小数点后恰好两位。
	样例输入
	buy 9.25 100
	buy 8.88 175
	sell 9.00 1000
	buy 9.00 400
	sell 8.92 400
	cancel 1
	buy 100.00 50
	样例输出
	9.00 450
	评测用例规模与约定
　　对于100%的数据，输入的行数不超过5000
 */
	public static void main(String[] args) {
		
		Map<Integer, Records> map = new TreeMap<>();
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		
		for (int i = 1; i < 5001; i++)
		{
			String line = scanner.nextLine().trim();
			if (line.length()>0)
			{
				
				String[] strings = line.split(" ");
				String type = strings[0];
				if (!type.equals("cancel"))
				{					
					double price = Double.parseDouble(strings[1]);
					Long counts = Long.parseLong(strings[2]);
					map.put(i, new Records(type, price, counts));	
				}
				else 
				{
					int index = Integer.parseInt(strings[1]);
					Records record = new Records(type, 0, 0l);
					map.put(index, record);//覆盖原来的那条记录；
				}
							
			}
			else {
				break;
			}
		}
		
		List<Records> buyRecords = new ArrayList<>();
		List<Records> sellRecords = new ArrayList<>();
		
		for(Records record :map.values()) {

			if (record.type.equals("buy"))
			{
				buyRecords.add(record);
			}
			else if (record.type.equals("sell"))
			{
					sellRecords.add(record);
			}
		}
		
		Collections.sort(buyRecords, new PriceDown());
		Collections.sort(sellRecords, new PriceUp());
		

//		System.out.println(buyRecords);
//		System.out.println(sellRecords);
		
		double p0 = 0;
		long sellCount;
		long buyCount = 0 ; 
		long finalCount = 0;
		double finalP0 = 0.0;
		
		for (Records buyRecord : buyRecords)
		{
			p0 = buyRecord.price;
			buyCount += buyRecord.counts;
			
			sellCount = 0;
			for (Records sellRecord : sellRecords)
			{
				
				if (sellRecord.price > p0 )
				{
					break;
				}
				
				sellCount += sellRecord.counts;
			}
			
			
			long tempCount = Math.min(sellCount, buyCount);
//			System.out.println(p0 + ":" + tempCount);
			
			if (tempCount > finalCount)
			{
				finalCount = tempCount;
				finalP0 = p0;
			}
		}
				
		System.out.printf("%.2f", finalP0);
		System.out.println(" "+finalCount);
				
		
	}
}

class PriceUp implements Comparator<Records>{//按照价格升序

	@Override
	public int compare(Records o1, Records o2) {
		return (o1.price - o2 .price) > 0 ? 1 : -1 ;
	}	
}

class PriceDown implements Comparator<Records>{//按照价格降序
	
	@Override
	public int compare(Records o1, Records o2) {
		return (o1.price - o2 .price) > 0 ? -1 : 1 ;
	}	
	
}



class Records{
	String type;
	double price;
	Long counts;
	public Records(String type, double price, Long counts) {
		super();
		this.type = type;
		this.price = price;
		this.counts = counts;
	}
	@Override
	public String toString() {
		return "Records [type=" + type + ", price=" + price + ", counts=" + counts + "]";
	}			
}
