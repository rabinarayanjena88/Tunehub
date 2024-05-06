package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.PlayList;
import com.kodnest.tunehub.repository.PlaylistRepository;
import com.kodnest.tunehub.service.PlaylistService;


@Service
public class PlaylistServiceImpl implements PlaylistService {
	
	
	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addPlayList(PlayList playlist) {
		playlistRepository.save(playlist);
		
	}

	@Override
	public PlayList nameExist(PlayList playlist) {
		PlayList pname = playlistRepository.findByname(playlist.getName());
		 if(pname==null) {
		      System.out.println("Absent");
		      return null;
		    }
		    else {
		      System.out.println("Present");
		      return playlist;
		    }
	}

	@Override
	public List<PlayList> fetchAllPlaylist() {
		List<PlayList> allplaylist = playlistRepository.findAll();
	    return allplaylist;
	}

	
}
