package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.PlayList;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.PlaylistService;
import com.kodnest.tunehub.service.SongService;

@Controller
public class PlaylistController {
	
	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	SongService songService;
	
	@GetMapping("/addplay")
	public String createplaylist(Model model) {
		List<Song> songList=songService.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "addplaylist";
	}
	
	@PostMapping("/addplaylistsong")
	public String addplaylistsong(@ModelAttribute PlayList playlist) {
		PlayList nameExist= playlistService.nameExist(playlist);
		if(nameExist==null) {
			playlistService.addPlayList(playlist);
			
			//update the song_playlists table
			List<Song> songs = playlist.getSongs();
			
			for (Song song : songs) {
				song.getPlaylists().add(playlist);
				songService.updateSong(song);
			}
			
			System.out.println("playlist added successfully!");
		}
		else {
			System.out.println("Duplicate songs");
		}
		
		return "adminhome";
		
	}
	
	@GetMapping("/playlist")
	   public String viewPlaylist(Model model) {
	       List<PlayList> fetchAllPlaylist = playlistService.fetchAllPlaylist();
	        model.addAttribute("playlists",fetchAllPlaylist);
	        return "viewplaylist";
	   }
	

}
