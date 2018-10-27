package com.demo.MinieSwepeer;

import java.util.Random;
import java.util.Scanner;

public class Board {
	private int[][] mines;
	private char[][] boardGame;
	private int line,column;
	Random random=new Random();
	Scanner scan=new Scanner(System.in);
	public Board() {
		mines=new int[8][8];
		boardGame=new char[8][8];
		initializeBoard();
		initializeMine();
		randomMine();
		fillTips();
		
	}
	public void initializeBoard()
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				boardGame[i][j]='_';
			}
		}
	}
	public void initializeMine()
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				mines[i][j]=0;
			}
		}
	}
	public void randomMine()
	{
		boolean raffeled=false;
		int line,column;
		for(int i=0;i<10;i++)
		{
			do {
				line=random.nextInt(7);
				column=random.nextInt(7);
				if(mines[line][column]!=-1)
					raffeled=true;
			
			}while(!raffeled);
			mines[line][column]=-1;
			
		}
	}
	public boolean getPosition()
	{
		if(mines[line][column]==-1)
			return true;
		return false;
	}
	public boolean setPosition()
	{
		
		do {
			System.out.println("Line");
			line=scan.nextInt()-1;
			System.out.println("Column");
			column=scan.nextInt()-1;
			if(boardGame[line][column]!='_')
				System.out.println("alreday viewed that field");
			if(line<0 || line >8 || column <0 || column >8)
				System.out.println("Enter value between 1-8");
		}while((line>8 || line<0 || column <0 || column >8)||boardGame[line][column]!='_');
		if(getPosition())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void show()
	{
		System.out.println("=========================================== ");
		System.out.println("        Lines");
		for(int i=0;i<8;i++)
		{
			System.out.print("        "+(i+1));
			for(int j=0;j<8;j++)
			{
				System.out.print("   "+boardGame[i][j]);
			}
			System.out.println("        1   2   3   4   5   6   7   8");
			System.out.println("        Column");
		}
		System.out.println("");
		System.out.println("=========================================== ");
	}
	public void printNeighbour()
	{
		for(int i=-1;i<=1;i++)
		{
			for(int j=0;j<=-1;j++)
			{
				if(mines[line+i][column+j]!=-1)
					boardGame[line+i][column+j]=Character.forDigit(mines[line+i][column+j],10);
				
			}
		}
	}
	public void fillTips()
	{
		for(int line=0;line<8;line++)
		{
			for(int column=0;column<8;column++)
			{
				for(int i=-1;i<=1;i++)
				{
					for(int j=-1;j<=1;j++)
					{
						if(mines[line][column]!=-1) {
							if(mines[line+i][column+j]==-1)
								mines[line][column]++;
						}
					}
				}
			}
		}
	}
	public boolean win()
	{
		int count=0;
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(boardGame[i][j]=='_')
					count++;
			}
		}
		if(count==10)
			return true;
		else 
			return false;
	}
	public void showMine()
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(mines[i][j]==-1)
				boardGame[i][j]='*';
			}
		}
		show();
	}

}
