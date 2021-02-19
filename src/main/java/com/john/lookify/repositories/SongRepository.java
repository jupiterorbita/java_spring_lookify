package com.john.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.john.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

	List<Song> findAll();
	
//	List<Song> findByRatingGreaterThan(Integer search);
	
	List<Song> findByArtistContaining(String search);
	
	List<Song> findTop5ByOrderByRatingDesc();
	
	Long countByTitleContaining(String search); 
	
	Long deleteByTitleStartingWith(String search); 
	
}
