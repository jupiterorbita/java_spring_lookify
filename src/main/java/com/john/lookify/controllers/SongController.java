package com.john.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.john.lookify.models.Song;
import com.john.lookify.services.SongService;

@Controller
public class SongController {

	@Autowired
	private SongService ss;
	
//	private final SongService ss;
//	public SongController(SongService songService) {
//		this.ss = songService;
//	}
//	----- FRONT ROUTES -----
	@GetMapping("/")
	public String root() {
		return "index.jsp";
	}
//	SHOW ALL ----------------
	@GetMapping("/dashboard")
	public String dashboard(Model x) {
		List<Song> songs = ss.allSongs();		
		x.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
//	CREATE NEW (page) ------------------------
	@GetMapping("/new")
	public String newPage(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
//	CREATE NEW (METHOD) ------------------------
//	@RequestMapping(value="/create", method=RequestMethod.POST)
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("song") Song song,
						 BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		ss.createSong(song);
		return "redirect:/dashboard";
	}
//	SHOW ONE-----------------
	@GetMapping("/songs/{id}")
	public String showPage(@PathVariable Long id, Model x) {
		Song s = ss.findSong(id);
		x.addAttribute("s", s);
		return "show.jsp";
	}
	
//	DELETE (link)
	@RequestMapping("/delete_link/{id}")
	public String destroy_link(@PathVariable Long id, RedirectAttributes rA) {
		rA.addFlashAttribute("deleted", "you deleted a song!");
		ss.deleteSong(id);
		return "redirect:/dashboard";
	}
	
//	DELETE (method)
	@DeleteMapping("/delete/{id}")
	public String destroy(@PathVariable Long id, RedirectAttributes rA) {
		rA.addFlashAttribute("deleted", "you deleted a song!");
		ss.deleteSong(id);
		return "redirect:/dashboard";
	}
//	==================================
//	search artists method
	@PostMapping("/search")
	public String searchArtist(@RequestParam("query") String query,
								RedirectAttributes rA) {
		List<Song> songs = ss.songsByArtist(query);
		if (songs.isEmpty()) {
			System.out.println("EMPTY");
			rA.addFlashAttribute("notFound", "query not found try again");
		}
		rA.addFlashAttribute("foundSongs", songs);
		return "redirect:/search/" + query;
	}
//	show artists songs page
	@GetMapping("/search/{query}")
	public String showFoundSongsPage(@PathVariable("query") String query,
									Model x) {
		x.addAttribute("query", query);
		return "search.jsp";
	}
//	show top songs page
	@GetMapping("/top5")
	public String showTopSongsPage(Model x) {
		List<Song> top5songs = ss.songsByRating();
		x.addAttribute("top5songs", top5songs);
		return "top5.jsp";
	}
	
	
	
	
}
