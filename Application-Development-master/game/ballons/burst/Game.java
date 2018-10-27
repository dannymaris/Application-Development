package com.game.ballons.burst;

public class Game {
	
	public static void main(String[] args) {
		boolean finish=true;
		boolean full=true;
		Balloon balloon=new Balloon();
		
		do
		{
			balloon.printBoard();
			balloon.play();
			finish=balloon.addBallon();
			full=balloon.checkUserColumnFull();
			System.out.println("Full "+full+" Finish "+finish);
			System.out.println("index "+balloon.checkUserColumn());
		}while(finish );
		if(!finish)
		{
			System.out.println("Ballon Storage Full,Program Terminated");
		}
		if(!full)
		{
			System.out.println("Column is filled.Program Terminated");
		}
		
	}
}
