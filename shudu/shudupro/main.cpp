#include<iostream>
#include<stdlib.h> 
#include<time.h>
#include<fstream> 
#include"Sudu.h"
using namespace std;

int main(int argc ,char *argv[])
{
	int n,i,j,k;
	
	n=atoi(argv[argc - 1]);		//����������

	srand((unsigned)time(NULL));		//������� 
	
	freopen("sudoku.txt","w",stdout);			//����ļ���sudoku.txt�� 
		
	if(n<1000000 && n>1)			//�ж�����ı����Ƿ�Ϊint�� 
	{
		for(i=0;i<n;i++)
		{
			change(); 
			int num1[9][9]={0};
			firstrank(num1,i,num2);			//ȷ����һ�е�����

			if(diffrent(num1,num2,i)==1)		//�ж��Ƿ��ظ�
			{
				build(num1,1,0);		//��ʼ��������

				for(j=0;j<9;j++)		//����������ļ���sudoku.txt���� 
				{
					for(k=0;k<9;k++)
					{
						cout << num1[j][k] << " ";
					}
		
					cout << endl;
				}
		
				cout << endl;		//ÿ����������һ������ 
			}
			else
			{
				i=i-1;
			}
 
		}
	}
	else
	{
		cout << "������������ԡ�" << endl;		//��������Ϊint�ͣ������������ʾ 
	}
	

	return 0;
} 