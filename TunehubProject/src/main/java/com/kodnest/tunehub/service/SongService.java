package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.Song;

public interface SongService {
	
	List<Song> getSong();
	void addSong(Song song);
	
	Song nameExists(Song song);
	
	List<Song> fetchAllSongs();
	
	void updateSong(Song song);
	void deleteSongById(Integer sid);
	
   
}
