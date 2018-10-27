package com.games.zoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tictactoe {
	private static Scanner scan=new Scanner(System.in);
	private static final char HUMANMOVE='X';
	private static final char COMPUTERMOVE='O';
	private static final int HUMAN=1;
	private static final int COMPUTER=2;
	private static final int SIDE=3;
	public static char[][] board=new char[SIDE][SIDE];
	public static ArrayList<Integer> move=new ArrayList<>();
	public static void main(String[] args) {

		intialize();
		playGame(HUMAN);
		
	}
	public static void intialize( )
	{
		for(int i=0;i<SIDE;i++)
		{
			for(int j=0;j<SIDE;j++)
			{
				board[i][j]='-';
				
			}
		}
		for(int i=0;i<SIDE*SIDE;i++)
		{
			move.add(i);
		}
		Collections.shuffle(move);
	}
	public static void printBoard()
	{
		for(int i=0;i<SIDE;i++)
		{
			System.out.println("\n\t\t\t\t\t"+board[i][0]+" | "+board[i][1]+" | "+board[i][2]);
			System.out.println("\\n\\t\\t\\t\\t\\t--------------------------------");
		}
	}
	public static void playGame(int whoseTurn)
	{
		System.out.println("Welcome to TIC TAC TOE Game");
		printInstructions();
		int moveIndex=0;
		int x,y,ch,i=0;
		
		while(!gameOver() && moveIndex<SIDE*SIDE)
		{
			printBoard();
			
			if(whoseTurn==HUMAN)
			{
				System.out.println("Play Your Move");
				ch=scan.nextInt()-1;
				scan.nextLine();
				x=ch/SIDE;
				y=ch%SIDE;
				board[x][y]=HUMANMOVE;
				moveIndex++;
				whoseTurn=COMPUTER;
			}
			else if(whoseTurn==COMPUTER)
			{
				System.out.println("Computer Move");
				x=move.get(i)/SIDE;
				y=move.get(i++)%SIDE;
				if(board[x][y]==HUMAN)
				{
					continue;
				}
				board[x][y]=COMPUTERMOVE;
				System.out.println("Compueter move ");
				whoseTurn=HUMAN;
			}
			
		}
		if(moveIndex==SIDE*SIDE && !gameOver())
		{
			printBoard();
			System.out.println("Its Draw");
		}
		else
		{
			if(whoseTurn==COMPUTER)
			System.out.println("Human Won ");
			else
			System.out.println("Computer Won ");
			printBoard();
		}
	}
	
	public static boolean gameOver()
	{
		return checkRow()||checkCol()||checkDiagonal();
	}
	public static boolean  checkRow()
	{
		for(int i=0;i<SIDE;i++)
		{
			if(board[i][0]!='-' && board[i][0] ==board[i][1] && board[i][1]==board[i][2])
			{
				return true;
			}
		}
		return false;
	}
	public static boolean checkCol()
	{
		for(int i=0;i<SIDE;i++)
		{
			if(board[0][i]!='-' && board[0][i]==board[1][i] && board[1][i]==board[2][i])
			{
				return true;
			}
		}
		return false;
	}
	public static boolean checkDiagonal()
	{
		if(board[0][0]!='-' && board[0][0]==board[1][1] && board[1][1]==board[2][2])
		{
			return true;
		}
		else if(board[1][2]!='-' &&board[1][2]==board[1][1] && board[1][1]==board[2][0])
		{
			return true;
		}
		return false;
	}
	
	public static void printInstructions()
	{
		System.out.println("Enter the following number to play the game");
		for(int i=0;i<SIDE;i++)
		{
			System.out.println("\n\t\t\t\t\t"+(i+1)+" | "+(i+1)+" | "+(i+1));
			System.out.println("\\n\\t\\t\\t\\t\\t--------------------------------");
		}
	}

}
