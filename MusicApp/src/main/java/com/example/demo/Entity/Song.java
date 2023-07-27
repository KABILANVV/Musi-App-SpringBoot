package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Song")
public class Song {
	@Id
    @GeneratedValue
	private int song_id;
	
	private String songname;
	private String songdesc;
	private String url;
	@Column(name = "song_like")
	private boolean song_like;
	@JsonIgnore	
	@ManyToOne
	@JoinColumn(name = "playlist_id") // The name of the foreign key column in the songs table
	private PlayList playList;
}
