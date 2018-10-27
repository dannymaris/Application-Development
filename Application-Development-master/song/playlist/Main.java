package com.song.playlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.print.attribute.standard.PrinterLocation;
import javax.sound.midi.Soundbank;

public class Main {
	private static Scanner scan=new Scanner(System.in);
	private static ArrayList<Album> albums=new ArrayList<Album>();
	public static void main(String[] args) {
		Album album=new Album("ChainSmoker","Guyz");
		album.addSong("closer",4.5);
		album.addSong("SuperMan",3.2);
		album.addSong("Colors",2.5);
		albums.add(album);
		album=new Album("divide","Ed Sherean");
		album.addSong("Shape of You", 4.0);
		album.addSong("Castle on the hill",3.9);
		albums.add(album);
		LinkedList<Song> linkedList=new LinkedList<Song>();
		albums.get(0).addPlayList(1, linkedList);
		albums.get(0).addPlayList(2, linkedList);
		albums.get(1).addPlayList("Shape of You", linkedList);
		
		play(linkedList);
	}
	public static void play(LinkedList<Song> playList)
	{
		System.out.println("Playing Song...");
		ListIterator<Song> listIterator=playList.listIterator();
		if(listIterator.hasNext())
		{
		System.out.println("Now Playing "+listIterator.next().toString()+" ....");
		}
		else
		{
			System.out.println("Empty Playlist");
		}
		int action;
		boolean quit=false;
		boolean forward=true;
		printActions();
		while(!quit)
		{	action=scan.nextInt();
			scan.nextLine();
			switch(action)
			{
			case 0:
				System.out.println("Playlist complete...");
				quit=true;
				break;
			case 1:
				if(!forward)
				{
					if(listIterator.hasNext())
					{
						listIterator.next(); 
					}
					forward=true;
				}
				if(listIterator.hasNext())
				{
					System.out.println("Now Playing "+listIterator.next().toString());
				}
				else
				{
					System.out.println("Reached End of the list");
				}
				break;
			case 2:
				if(forward)
				{
					if(listIterator.hasPrevious())
					{
						listIterator.previous();
					}
					forward=false;
				}
				if(listIterator.hasPrevious())
				{
					System.out.println("Now Playing "+listIterator.previous().toString());
				}
				else
				{
					System.out.println("We are at Start of the list");
				}
				break;
			case 3:
				if(forward)
				{
					if(listIterator.hasNext())
					{
						System.out.println("Now RePlaying "+listIterator.next().toString());
					}
					else if(listIterator.hasPrevious())
					{
						System.out.println("Now RePlaying "+listIterator.previous().toString());
					}
				}
				break;
			case 4:
				printPlaylist(playList);
				break;
			case 5:
				printActions();
				break;
			}
		}

	}
	public static void printActions()
	{
		System.out.println("Available Actions\npress:");
		System.out.println("0-Quit\n"+
							"1-forward\n"+
							"2-backward\n"+
							"3-repaly\n"+
							"4-print playlist\n"+
							"5-print actions");	
		System.out.println("Enter Your Action:");
	}
	public static void printPlaylist(LinkedList<Song> playLists)
	{
		Iterator<Song> playList=playLists.iterator();
		System.out.println("===================================");
		while(playList.hasNext())
		{
			System.out.println(playList.next().toString());
		}
		System.out.println("===================================");
	}
}