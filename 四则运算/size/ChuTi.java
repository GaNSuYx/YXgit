package size;   
import java.util.Random;
import java.util.Scanner;  
import java.lang.Math;
public class ChuTi 
{    
	int sum;
	public static void main(String[] args) 
	{   
		ChuTi t = new ChuTi();   // ��ʾ�û�������Ϣ      
		// ������sum��ʼ��Ϊ0��   
		t.sum = 0;  
		// ����һ�������   
		Random r = new Random();   
		// ����10��ѭ������Ӧ��10����
		System.out.println("��������Ҫ������Ŀ����");
		int num;
		Scanner scan = new Scanner(System.in);
		num=scan.nextInt();
		System.out.println("���β��Թ�"+num+"���⣬ÿ��ʮ��");
		System.out.println("���Թ������Ƿ��г˳�����y/n");
		String flag;
		Scanner scanflag = new Scanner(System.in);
		flag=scanflag.next();
		//��ӡ�����Գɼ�    
		for (int i = 0; i < num; i++) 
		{     
			t.core(flag);    
		}  
		
		System.out.println(" ���Խ��� ");   
		System.out.println(" �����ܷ�Ϊ" + t.sum);  
	}

	//���Ե���Ŀ��  
	private void core(String flag) 
	{     //����һ���漴������
		Random r = new Random(); 
		int m, n;
		double ran = Math.random();
		m=(int)(ran*10);
		 //����һ����0��1��-1֮�е���   
		if(flag.compareToIgnoreCase("y")==0)
		{
			n = m % 4;
		}
		else {
			n = m % 2;
		}
		switch (n) 
		{     
		//���nΪ0������мӷ�����     
		case 0:      
			int a1,b1,c1;       
			//aΪ��������bΪ��������������10���ڵ����֡�      
			a1 = r.nextInt() % 100;      
			b1 = r.nextInt() % 100;       
			//��������ʽ�����û������      
			System.out.println(a1 + "+" + "(" + b1 + ")=?");      
			Scanner scan1 = new Scanner(System.in);      
			c1 = scan1.nextInt();           
			//�ж��û��Ĵ���ȷ�������ȷ���10�֣��� ���ֻ��ʾ����      
			if (c1 != a1 + b1)        
			System.out.println("�ش����");
			else 
			{
				System.out.println(" �ش���ȷ");       
				sum = sum + 10;       
			}        
			break;      
		//���nΪ1������м�������     
		case 1:      
			int a2,b2,c2;       
			//qΪ��������wΪ��������������10���ڵ����֡�      
			a2 = r.nextInt() % 100;      
			b2 = r.nextInt() % 100;       
			//��������ʽ�����û������            
			System.out.println(a2 + "-" + "(" + b2 + ")" +  "=?");      
			Scanner scan2 = new Scanner(System.in);      
			c2 = scan2.nextInt();        
			//�ж��û��Ĵ���ȷ�������ȷ���10�֣��� ���ֻ��ʾ����      
			if (c2 != a2 - b2)        
				System.out.println("�ش����");       
			else 
			{       
				System.out.println(" �ش���ȷ");            
				sum = sum + 10;
			}        
			break; 
		case 2: //�˷�����     
			int a3,b3,c3;       
			//qΪ��������wΪ��������������10���ڵ����֡�      
			a3 = r.nextInt() % 10;      
			b3 = r.nextInt() % 10;       
			//��������ʽ�����û������            
			System.out.println(a3 + "*" + "(" + b3 + ")" +  "=?");      
			Scanner scan3 = new Scanner(System.in);      
			c3 = scan3.nextInt();        
			//�ж��û��Ĵ���ȷ�������ȷ���10�֣��� ���ֻ��ʾ����      
			if (c3 != a3 * b3)        
				System.out.println("�ش����");       
			else 
			{       
				System.out.println(" �ش���ȷ");            
				sum = sum + 10;
			}        
			break; 
			
		case 3:  //��������    
			int a4,b4;
			double c4;       
			//qΪ��������wΪ��������������10���ڵ����֡�      
			a4 = r.nextInt() % 10;  
			b4 = r.nextInt() % 10;
			if(b4==0) 
			{
				while(true)
				{
					System.out.println("��ĸ����Ϊ�㣬����������");
					b4 = r.nextInt() % 10;
					if(b4!=0)
					{
						break;
					}
				}
				
			}
			//��������ʽ�����û������            
			System.out.println(a4 + "/" + "(" + b4 + ")" +  "=?");      
			Scanner scan4 = new Scanner(System.in);      
			c4 = scan4.nextInt();        
			//�ж��û��Ĵ���ȷ�������ȷ���10�֣��� ���ֻ��ʾ����      
			if (c4 != a4*1.0 / b4)        
				System.out.println("�ش����");       
			else 
			{       
				System.out.println(" �ش���ȷ");            
				sum = sum + 10;
			}        
			break;    	
			
		} 
	}  
}