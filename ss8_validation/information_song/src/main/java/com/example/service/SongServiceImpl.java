package com.example.service;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SongServiceImpl implements ISongService{
    @Autowired
    private ISongRepository iSongRepository;
    @Override
    public List<Song> listAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void create(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return iSongRepository.findById(id);
    }

    @Override
    public void update(Song song) {
        iSongRepository.save(song);
    }
}
