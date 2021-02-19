package com.john.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.john.lookify.models.Song;
import com.john.lookify.repositories.SongRepository;

@Service
public class SongService {

	private final SongRepository songRepo;
	public SongService(SongRepository sR) {
		this.songRepo = sR;
	}
	
//	= = =  C R U D  = = = 
	
//	READ ALL
	public List<Song> allSongs(){
		return songRepo.findAll();
	}
//  CREATE
	public Song createSong(Song s) {
		return songRepo.save(s);
	}
// READ ONE
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
//		if (optionalSong.isPresent()) {
//			return optionalSong.get();
//		} else {			
//			return null;
//		}
		return optionalSong != null? optionalSong.get(): null;
	}
//	UPDATE - by id
	public Song EditById(Long id,
						 String title,
						 String artist,
						 Integer rating) {
		Song s = findSong(id);
		if (s != null) {
			s.setTitle(title);
			s.setArtist(artist);
			s.setRating(rating);
			return songRepo.save(s);
		} else {			
			return null;
		}
	}
//	UPDATE THE WHOLE OBJ - SAVE>?
	public Song updateSong(Song s) {
		return songRepo.save(s);
	}
//	DELETE
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
//  Return all songs by an artist
	public List<Song> songsByArtist(String search){
		System.out.println(songRepo.findByArtistContaining(search));
		return songRepo.findByArtistContaining(search);
	}
//return sorted list by rating
	public List<Song> songsByRating(){
		return songRepo.findTop5ByOrderByRatingDesc(); 
	}
	
	
	
	
}
