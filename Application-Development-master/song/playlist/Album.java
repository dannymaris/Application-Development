package com.song.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	public Album(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	
	private Song findSong(String title)
	{
		for(Song checkedSong:this.songs)
		{
			if(checkedSong.getName().equals(title))
			{
				return checkedSong;
				
			}
		}
		return null;
	}
	public boolean addSong(String title,double duration)
	{
		if(findSong(title)==null)
		{
			this.songs.add(new Song(title,duration));
		}
		return false;
	}
	public boolean addPlayList(int trackNumber,LinkedList<Song> linkedList)
	{
		int index=trackNumber-1;
		if((index>0)&& (index<=this.songs.size()))
		{
			linkedList.add(this.songs.get(index));
			return true;
		}
		return false;
	}
	public boolean addPlayList(String title,LinkedList<Song> linkedList)
	{
		Song songs=findSong(title);
		if(songs!=null)
		{
			linkedList.add(songs);
		}
		return false;
	}
	
}
