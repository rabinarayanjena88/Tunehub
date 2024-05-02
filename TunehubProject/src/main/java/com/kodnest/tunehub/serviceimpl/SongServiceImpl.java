package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl implements SongService{
	
	@Autowired
	SongRepository songRepository;

	@Override
	public List<Song> getSong() {
		
		return songRepository.findAll();
	}

	@Override
	public void addSong(Song song) {
	  songRepository.save(song);
	  
		
	}

	@Override
	public Song nameExists(Song song) {
		 Song sname= songRepository.findByname(song.getName());
		    if(sname==null) {
		      System.out.println("Absent");
		      return null;
		    }
		    else {
		      System.out.println("Present");
		      return song;
		    }
	}
	

	@Override
	public List<Song> fetchAllSongs() {
		
		List<Song> songs = songRepository.findAll();
		return songs;
	}
	
	

	@Override
	public void updateSong(Song song) {
		
		songRepository.save(song);
	}

	@Override
	public void deleteSongById(Integer sid) {
		 songRepository.deleteById(sid);
		
	}


}
