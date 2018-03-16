#include "Sudu.h"
#include<stdlib.h>

bool sign=false;
int num2[1000000][9]={0};

void firstrank(int num[][9],int n,int sum[][9])		//随机取数独矩阵第一排的值 
{
	int a[9]={8,1,2,3,4,5,6,7,9};
	int ran,temp;
	
	for(int i=2;i<9;i++)	//数组除了第一个数固定为8，其余重组 
	{
		ran=rand()%(9-i)+i;
		
		temp=a[i-1];
		a[i-1]=a[ran];
		a[ran]=temp;		
	}
	
	for(int j=0;j<9;j++)	//将a数组的值赋给矩阵num的第一排 
	{
		num[0][j]=a[j];
		sum[n][j]=a[j];
	}
}

bool check(int n,int i,int j,int num[][9])		//判定数字n能否放入num[i][j]中 
{
	int a,b;
	int x,y;
	
	for(a=0;a<9;a++)		//判断第i行是否有与n重复的数字 
	{
		if(num[i][a]==n) return false;
	}
	
	for(b=0;b<9;b++)		//判断第j列是否有与n重复的数字 
	{
		if(num[b][j]==n) return false;
	}
	
	if(i<3) x=0;		//num[i][j]所在的小九宫左上角的行 
	else if(i>5) x=6;
	else x=3;
	
	if(j<3) y=0;		//num[i][j]所在的小九宫左上角的列 
	else if(j>5) y=6;
	else y=3;
	
	for(a=x;a<x+3;a++)		//判断该九宫中是否有与n重复的数字 
	{
		for(b=y;b<y+3;b++)
		{
			if(num[a][b]==n) return false;
		}
	}
	
	return true;
}

int build(int num[][9],int x,int y)		//构建数独矩阵 
{
	int k;
	
	if(x==9)		//当全部填满时，数独矩阵完成 
	{
		sign=true;
		return 0;
	}

	for(k=1;k<=9;k++)		//从1开始逐个测试是否能放入num[x][y]的位置中 
	{
		if(check(k,x,y,num)==true)
		{
			num[x][y]=k;
			if(y<8)
			{
				build(num,x,y+1);		//该位不是这一行的最末位，则继续对其下一位进行置数 
			}
			else 
			{
				build(num,x+1,0); 		//该位已经是这一行的最末位，跳至下一行首位进行置数 
			}
			
			if(sign==true) 		//当数独阵完成时，直接返回 
			{
				return 0;
			}
		 
			num[x][y]=0;		//如果置数失败，则将这位置0，继续寻找下一个适合的数字 
		} 
	}


}

void change()
{
	sign=false;		//重置sign的值为false 
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


