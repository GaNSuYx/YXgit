#include<iostream>
#include<stdlib.h> 
#include<time.h>
#include<fstream> 
#include"Sudu.h"
using namespace std;

int main(int argc ,char *argv[])
{
	int n,i,j,k;
	
	n=atoi(argv[argc - 1]);		//命令行输入

	srand((unsigned)time(NULL));		//随机种子 
	
	freopen("sudoku.txt","w",stdout);			//输出文件“sudoku.txt” 
		
	if(n<1000000 && n>1)			//判断输入的变量是否为int型 
	{
		for(i=0;i<n;i++)
		{
			change(); 
			int num1[9][9]={0};
			firstrank(num1,i,num2);			//确定第一行的排序

			if(diffrent(num1,num2,i)==1)		//判断是否重复
			{
				build(num1,1,0);		//开始构建数独

				for(j=0;j<9;j++)		//输出数独阵到文件“sudoku.txt”中 
				{
					for(k=0;k<9;k++)
					{
						cout << num1[j][k] << " ";
					}
		
					cout << endl;
				}
		
				cout << endl;		//每个数独阵间隔一个空行 
			}
			else
			{
				i=i-1;
			}
 
		}
	}
	else
	{
		cout << "输入错误，请重试。" << endl;		//若变量不为int型，则输出错误提示 
	}
	

	return 0;
} 