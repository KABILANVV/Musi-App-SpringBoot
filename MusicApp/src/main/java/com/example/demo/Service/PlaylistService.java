package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.PlayList;
import com.example.demo.Repository.playlistRepository;

@Service
public class PlaylistService {
	
	@Autowired
	private playlistRepository play;
	
	 public List<PlayList> getAllPlayLists() {
	        return play.findAll();
	    }

	    public PlayList getPlayListById(int id) {
	        return play.findById(id).get();
	    }

	    public boolean addPlaylist(PlayList list) {
	        return (play.save(list) != null) ? true : false;
	    }
	

}

