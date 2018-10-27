package com.games.zoho;

public class Suduku {
	private static final int N=9;
	private static int row=0;
	private static int col=0;
	private static final int UNASSIGNED=0;
	private static int[][] grid=new int[][]{{3, 0, 6, 5, 0, 8, 4, 0, 0},
		{5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0},
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        public static void main(String[] args) {
			if(solveSuduku())
			{
				System.out.println("suduku solved row"+row+" col "+col);
				printGrid();
			}
			else
			{
				System.out.println("suduku solved row"+row+" col "+col);
				
				System.out.println("not solvable");
				printGrid();
			}
        	
		}
        public static boolean solveSuduku()
        {
        	if(!findUnassigned())
        	{
        		return true;
        	}
        	for(int num=1;num<=9;num++)
        	{
        		//printGrid();
        		if(isSafe(row,col,num))
        		{
        			grid[row][col]=num;
        			if(solveSuduku())
        			{
        				return true;
        			}
        			grid[row][col]=UNASSIGNED;
        		}
        	}
        	return false;
        }
        public static boolean findUnassigned()
        {
        	for(row=0;row<N;row++)
        	{
        		for(col=0;col<N;col++)
        		{
        			if(grid[row][col]==UNASSIGNED)
        			{
        				return true;
        			}
        		}
        	}
        	return false;
        }
        public static boolean isSafe(int row,int col,int num)
        {
        	return !isUsedInRow(row,num) && !isUsedInCol(col,num) && !isUsedInBox(row-row%3,col-col%3,num);
        }
        public static boolean isUsedInRow(int row,int num)
        {
        	for(int col=0;col<N;col++)
        	{
        		if(grid[row][col]==num)
        			return true;
        	}
        	return false;
        }
        public static boolean isUsedInCol(int col,int num)
        {
        	for(int row=0;row<N;row++)
        	{
        		if(grid[row][col]==num)
        			return true;
        	}
        	return false;
        }
        public static boolean isUsedInBox(int rowStart,int colStart,int num)
        {
        	for(int row=0;row<3;row++)
        	{
        		for(int col=0;col<3;col++)
        		{
        			if(grid[row+rowStart][col+colStart]==num)
        				return true;
        		}
        	}
        	return false;
        }
		public static void printGrid() {
		System.out.println("\tGrid");
		for(int row=0;row<N;row++)
		{
			for(int col=0;col<N;col++)
			{
				System.out.printf("%2d",grid[row][col]);
			}
			System.out.println();
		}
	}
}
