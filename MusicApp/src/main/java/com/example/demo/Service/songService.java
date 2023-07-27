package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Song;
import com.example.demo.Repository.SongRepository;


@Service
public class songService {
	@Autowired
	SongRepository song;
	public List<Song> getAllSongs() {
	        return song.findAll();
	}

	public Song getSongById(int id) {
	        return song.findById(id).get();
	}

	public boolean addSong(Song user) {
	        return (song.save(user) != null) ? true : false;
	}
}
