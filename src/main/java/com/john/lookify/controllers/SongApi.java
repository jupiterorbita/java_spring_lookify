package com.john.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.john.lookify.models.Song;
import com.john.lookify.services.SongService;

@RestController
public class SongApi {

	private final SongService ss;
	public SongApi(SongService songService) {
		this.ss = songService;
	}
//	---------- API ROUTES ---------
//	READ ALL - GET ALL
	@RequestMapping("/api/songs")
	public List<Song> index() {
		return ss.allSongs();
	}
//	CREATE ONE - POST
	@RequestMapping(value="/api/songs", method=RequestMethod.POST)
	public Song create(@RequestParam String title,
						@RequestParam String artist,
						@RequestParam Integer rating) {
		Song s = new Song(title, artist, rating);
		return ss.createSong(s);
	}
//	READ ONE - by ID
	@RequestMapping("/api/songs/{id}")
	public Song show(@PathVariable Long id) {
		Song s = ss.findSong(id);
		return s;
	}
//	UPDATE - by id
	@RequestMapping(value="/api/songs/{id}",
					method=RequestMethod.PUT)
	public Song update(@PathVariable Long id,
						@RequestParam String title,
						@RequestParam String artist,
						@RequestParam Integer rating) {
		Song s = ss.EditById(id, title, artist, rating);
		return s;
	}
//	DELETE
	@RequestMapping(value="/api/songs/{id}",
					method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		ss.deleteSong(id);
	}
	
	
	
}
