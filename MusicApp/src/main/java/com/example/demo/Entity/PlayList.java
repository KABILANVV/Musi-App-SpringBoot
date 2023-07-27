package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Playlist")
public class PlayList {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playlist_id;
	private String playlistname;


    @OneToMany(mappedBy = "playList", cascade = CascadeType.ALL)
    private List<Song> songs;

    @ManyToOne
    @JoinColumn(name = "user_id") // The name of the foreign key column in the playlists table
    private User user;
}