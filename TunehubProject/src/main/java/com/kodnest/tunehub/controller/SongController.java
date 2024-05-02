package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService songService;
	
	@PostMapping("/addsongs")
    public String saveSong(@ModelAttribute Song song) {
		Song nameExists = songService.nameExists(song);
		if(nameExists==null) {
        songService.addSong(song);
        System.out.println("Song added successfully!");
		}
		else {
			System.out.println("Duplicate songs");
		}
        return "adminhome";
    }
	
	//...........................
	
	
	@GetMapping("/playsongs")
	public String playSongs(Model model) {
		
		boolean premium=true;
		
		if (premium) {
			List<Song> songslist = songService.fetchAllSongs();
			model.addAttribute("songs", songslist);
			System.out.println(songslist);
			
			return "viewsongs";
			
		} else {
			return "pay";

		}	
	}
	
	
	@GetMapping("/viewsongs")
	public String viewSongs(Model model) {
		
			List<Song> songslist = songService.fetchAllSongs();
			model.addAttribute("songs", songslist);
			System.out.println(songslist);
			
			return "viewsongs";
		
	}
	

	
	
	
	// New method for deleting a song
    @PostMapping("/deleteSong") // Assuming you are using POST method for deletion
    public String deleteSong(@RequestParam("sid") Integer sid) {
        // Invoke the service method to delete the song by ID
        songService.deleteSongById(sid);
        System.out.println("Song deleted successfully!");
        return "redirect:/viewsongs"; // Redirect to the view songs page after deletion
    }

}
