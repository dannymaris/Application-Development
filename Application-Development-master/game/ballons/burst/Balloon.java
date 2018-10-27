package com.game.ballons.burst;

import java.util.Scanner;

public class Balloon {
	private char[][] board=new char[3][3];	
	private Scanner scan=new Scanner(System.in);
	private char userMove;
	private int userPos;
	public Balloon()
	{
		initializeBoard();
		
	}
	public void play()
	{
		System.out.println("Enter the Column");
		userPos=scan.nextInt()-1;
		System.out.println("Enter your ballon color ");
		userMove=scan.next().charAt(0);
		
	}
	public boolean addBallon()
	{
		if(!isEmpty())
		{
			board[2][userPos]=userMove;
			
		}
		else
		{
		
		int index=checkUserColumn();
		if(index>=0)
		{
			if(isFreeNeighbour())
			{
				
				board[index][userPos]=userMove;
			}
		}
		else
		{
			System.out.println("invalid entry, Full!!");
			printBoard();
			return false;
		}
		int burstIndex=isSameColorBurst();
		if(burstIndex>=0)
		{
			for(int i=0;i<=2;i++)
			{
				board[i][burstIndex]='-';
			}
			System.out.println("Balloon bursted");
			printBoard();
		}
		
		
			
		}
		return true;
	}
	public boolean checkUserColumnFull()
	{
		int count=0;
		for(int i=2;i>=0;i--)
		{
			if(board[i][userPos]!='-')
				count++;
		}
		if(count==3)
			return false;
		return true;
		
	}
	public int  isSameColorBurst()
	{
		int count=0,k=0,i,j;
		char ch;
		for(i=2;i>=0;i--)
		{
			count=0;
			ch=board[2][k++];
			for( j=2;j>=0;j--)
			{
				if(board[j][i]==ch)
				{
					++count;
					
				}
				System.out.println("ch="+ch+"board="+board[j][i]);
			}
			System.out.println("count ="+count+" i ="+i+"ch="+ch+" board=");
			if(count==3)
			{
			
				return i;
			}
			
		}
		
	
		return -1;
	}
	public boolean isFreeNeighbour()
	{
		
		int row=checkUserColumn()+1;
			for(int j=0;j<=2;j++)
			{
				if(board[row][j]=='-'  )
				{
					board[row][j]=userMove;
					return false;
				}
			}
		
		return true;
		
	}
	public int checkUserColumn()
	{

		for(int i=2;i>=0;i--)
		{
			if(board[i][userPos]=='-')
				return i;
		}
		return -1;
	
	}
	public boolean isEmpty()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]!='-')
					return true;
			}
		}
		return false;

	}
	
	
	
	public void initializeBoard() {
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j]='-';
			}
		}
	}
	public void printBoard()
	{
		System.out.println("contet of the Board");
		System.out.println("       rows");
		for(int i=0;i<3;i++)
		{
			System.out.print("       "+(i+1));
			for(int j=0;j<3;j++)
			{
				System.out.print("   "+board[i][j]);
			}
			System.out.println();
			
		}
		System.out.println();
		System.out.println("           1   2   3   ");
		System.out.println("           Columns ");
	}
	
}
