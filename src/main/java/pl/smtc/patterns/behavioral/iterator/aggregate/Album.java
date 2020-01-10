package pl.smtc.patterns.behavioral.iterator.aggregate;

import pl.smtc.patterns.behavioral.iterator.iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Album {
    protected List<Song> songs = new ArrayList<>();
    private String name;
    private String genre;
    private int year;

    public Album(String name, String genre, int year) {
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public SongIterator getSongsIterator() {
        return new SongIterator();
    }

    public class SongIterator implements Iterator<Song> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < songs.size();
        }

        @Override
        public void first() {
            index = 0;
        }

        @Override
        public void next() {
            index++;
        }

        @Override
        public Song currentItem() {
            return songs.get(index);
        }
    }
}
