package com.kodnest.tunehub.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	
	private String name;
	private String sartist;
	private String sgeneric;
	private String slink;
	@ManyToMany
	private List<PlayList> playlists;
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Song(int sid, String name, String sartist, String sgeneric, String slink, List<PlayList> playlists) {
		super();
		this.sid = sid;
		this.name = name;
		this.sartist = sartist;
		this.sgeneric = sgeneric;
		this.slink = slink;
		this.playlists = playlists;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSartist() {
		return sartist;
	}
	public void setSartist(String sartist) {
		this.sartist = sartist;
	}
	public String getSgeneric() {
		return sgeneric;
	}
	public void setSgeneric(String sgeneric) {
		this.sgeneric = sgeneric;
	}
	public String getSlink() {
		return slink;
	}
	public void setSlink(String slink) {
		this.slink = slink;
	}
	public List<PlayList> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<PlayList> playlists) {
		this.playlists = playlists;
	}
	@Override
	public String toString() {
		return "Song [sid=" + sid + ", name=" + name + ", sartist=" + sartist + ", sgeneric=" + sgeneric + ", slink="
				+ slink + ", playlists=" + playlists + "]";
	}
	
	
}
