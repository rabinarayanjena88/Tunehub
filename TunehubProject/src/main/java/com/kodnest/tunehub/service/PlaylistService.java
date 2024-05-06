package com.kodnest.tunehub.service;

import java.util.List;


import com.kodnest.tunehub.entity.PlayList;

public interface PlaylistService {

	public void addPlayList(PlayList playlist);

	public PlayList nameExist(PlayList playlist);

	public List<PlayList> fetchAllPlaylist();


}
