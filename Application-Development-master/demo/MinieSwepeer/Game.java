package com.demo.MinieSwepeer;

public class Game {
	Board board;
	private boolean finish;
	public Game()
	{
		board=new Board();
		finish=false;
		play(board);
	}
	
	public void play(Board board)
	{
		do
		{
			board.show();
			finish=board.setPosition();
			
			if(!finish)
			{
				board.printNeighbour();
				finish=board.win();
			}
		
		}while(!finish);
		
		if(board.win())
		{
			System.out.println("Congratulation You Won");
		}
		else
		{
			System.out.println("Mine! You Lose");
		}
	}
}
