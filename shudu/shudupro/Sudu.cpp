#include "Sudu.h"
#include<stdlib.h>

bool sign=false;
int num2[1000000][9]={0};

void firstrank(int num[][9],int n,int sum[][9])		//���ȡ���������һ�ŵ�ֵ 
{
	int a[9]={8,1,2,3,4,5,6,7,9};
	int ran,temp;
	
	for(int i=2;i<9;i++)	//������˵�һ�����̶�Ϊ8���������� 
	{
		ran=rand()%(9-i)+i;
		
		temp=a[i-1];
		a[i-1]=a[ran];
		a[ran]=temp;		
	}
	
	for(int j=0;j<9;j++)	//��a�����ֵ��������num�ĵ�һ�� 
	{
		num[0][j]=a[j];
		sum[n][j]=a[j];
	}
}

bool check(int n,int i,int j,int num[][9])		//�ж�����n�ܷ����num[i][j]�� 
{
	int a,b;
	int x,y;
	
	for(a=0;a<9;a++)		//�жϵ�i���Ƿ�����n�ظ������� 
	{
		if(num[i][a]==n) return false;
	}
	
	for(b=0;b<9;b++)		//�жϵ�j���Ƿ�����n�ظ������� 
	{
		if(num[b][j]==n) return false;
	}
	
	if(i<3) x=0;		//num[i][j]���ڵ�С�Ź����Ͻǵ��� 
	else if(i>5) x=6;
	else x=3;
	
	if(j<3) y=0;		//num[i][j]���ڵ�С�Ź����Ͻǵ��� 
	else if(j>5) y=6;
	else y=3;
	
	for(a=x;a<x+3;a++)		//�жϸþŹ����Ƿ�����n�ظ������� 
	{
		for(b=y;b<y+3;b++)
		{
			if(num[a][b]==n) return false;
		}
	}
	
	return true;
}

int build(int num[][9],int x,int y)		//������������ 
{
	int k;
	
	if(x==9)		//��ȫ������ʱ������������� 
	{
		sign=true;
		return 0;
	}

	for(k=1;k<=9;k++)		//��1��ʼ��������Ƿ��ܷ���num[x][y]��λ���� 
	{
		if(check(k,x,y,num)==true)
		{
			num[x][y]=k;
			if(y<8)
			{
				build(num,x,y+1);		//��λ������һ�е���ĩλ�������������һλ�������� 
			}
			else 
			{
				build(num,x+1,0); 		//��λ�Ѿ�����һ�е���ĩλ��������һ����λ�������� 
			}
			
			if(sign==true) 		//�����������ʱ��ֱ�ӷ��� 
			{
				return 0;
			}
		 
			num[x][y]=0;		//�������ʧ�ܣ�����λ��0������Ѱ����һ���ʺϵ����� 
		} 
	}


}

void change()
{
	sign=false;		//����sign��ֵΪfalse 
}


bool diffrent(int a[][9],int b[][9],int n)
{
	int i,j;
	if(n==0) return true;
	else
	{
		for(i=0;i<n;i++)
		{
			for(j=0;j<9;j++)
			{
				if(a[0][j]!=b[i][j]) break;
				else if(a[0][j]==b[i][j]&&j<8) continue;
				else return false;
			}
		}
	}
	
	return true;
}


