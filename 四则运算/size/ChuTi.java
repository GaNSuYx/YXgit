package size;   
import java.util.Random;
import java.util.Scanner;  
import java.lang.Math;
public class ChuTi 
{    
	int sum;
	public static void main(String[] args) 
	{   
		ChuTi t = new ChuTi();   // 提示用户考试信息      
		// 将分数sum初始化为0；   
		t.sum = 0;  
		// 创建一个随机类   
		Random r = new Random();   
		// 进行10个循环，对应着10道题
		System.out.println("请输入你要做的题目数量");
		int num;
		Scanner scan = new Scanner(System.in);
		num=scan.nextInt();
		System.out.println("本次测试共"+num+"道题，每题十分");
		System.out.println("考试过程中是否有乘除法？y/n");
		String flag;
		Scanner scanflag = new Scanner(System.in);
		flag=scanflag.next();
		//打印出考试成绩    
		for (int i = 0; i < num; i++) 
		{     
			t.core(flag);    
		}  
		
		System.out.println(" 考试结束 ");   
		System.out.println(" 您的总分为" + t.sum);  
	}

	//考试的题目。  
	private void core(String flag) 
	{     //产生一个随即生成器
		Random r = new Random(); 
		int m, n;
		double ran = Math.random();
		m=(int)(ran*10);
		 //产生一个在0，1，-1之中的数   
		if(flag.compareToIgnoreCase("y")==0)
		{
			n = m % 4;
		}
		else {
			n = m % 2;
		}
		switch (n) 
		{     
		//如果n为0，则进行加法运算     
		case 0:      
			int a1,b1,c1;       
			//a为操作数，b为被操作数，都是10以内的数字。      
			a1 = r.nextInt() % 100;      
			b1 = r.nextInt() % 100;       
			//给出运算式，让用户输入答案      
			System.out.println(a1 + "+" + "(" + b1 + ")=?");      
			Scanner scan1 = new Scanner(System.in);      
			c1 = scan1.nextInt();           
			//判断用户的答案正确与否，若正确则加10分，错 误就只提示错误      
			if (c1 != a1 + b1)        
			System.out.println("回答错误");
			else 
			{
				System.out.println(" 回答正确");       
				sum = sum + 10;       
			}        
			break;      
		//如果n为1，则进行减法运算     
		case 1:      
			int a2,b2,c2;       
			//q为操作数，w为被操作数，都是10以内的数字。      
			a2 = r.nextInt() % 100;      
			b2 = r.nextInt() % 100;       
			//给出运算式，让用户输入答案            
			System.out.println(a2 + "-" + "(" + b2 + ")" +  "=?");      
			Scanner scan2 = new Scanner(System.in);      
			c2 = scan2.nextInt();        
			//判断用户的答案正确与否，若正确则加10分，错 误就只提示错误      
			if (c2 != a2 - b2)        
				System.out.println("回答错误");       
			else 
			{       
				System.out.println(" 回答正确");            
				sum = sum + 10;
			}        
			break; 
		case 2: //乘法运算     
			int a3,b3,c3;       
			//q为操作数，w为被操作数，都是10以内的数字。      
			a3 = r.nextInt() % 10;      
			b3 = r.nextInt() % 10;       
			//给出运算式，让用户输入答案            
			System.out.println(a3 + "*" + "(" + b3 + ")" +  "=?");      
			Scanner scan3 = new Scanner(System.in);      
			c3 = scan3.nextInt();        
			//判断用户的答案正确与否，若正确则加10分，错 误就只提示错误      
			if (c3 != a3 * b3)        
				System.out.println("回答错误");       
			else 
			{       
				System.out.println(" 回答正确");            
				sum = sum + 10;
			}        
			break; 
			
		case 3:  //除法运算    
			int a4,b4;
			double c4;       
			//q为操作数，w为被操作数，都是10以内的数字。      
			a4 = r.nextInt() % 10;  
			b4 = r.nextInt() % 10;
			if(b4==0) 
			{
				while(true)
				{
					System.out.println("分母不能为零，请重新输入");
					b4 = r.nextInt() % 10;
					if(b4!=0)
					{
						break;
					}
				}
				
			}
			//给出运算式，让用户输入答案            
			System.out.println(a4 + "/" + "(" + b4 + ")" +  "=?");      
			Scanner scan4 = new Scanner(System.in);      
			c4 = scan4.nextInt();        
			//判断用户的答案正确与否，若正确则加10分，错 误就只提示错误      
			if (c4 != a4*1.0 / b4)        
				System.out.println("回答错误");       
			else 
			{       
				System.out.println(" 回答正确");            
				sum = sum + 10;
			}        
			break;    	
			
		} 
	}  
}