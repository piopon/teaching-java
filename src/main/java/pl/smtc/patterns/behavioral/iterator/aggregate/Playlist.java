package pl.smtc.patterns.behavioral.iterator.aggregate;

import pl.smtc.patterns.behavioral.iterator.iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    protected List<Album> tracks = new ArrayList<>();

    public void addAlbum(Album album) {
        tracks.add(album);
    }

    public void removeAlbum(Album album) {
        tracks.remove(album);
    }

    public AlbumIterator getAlbumsIterator() {
        return new AlbumIterator();
    }

    public class AlbumIterator implements Iterator<Album> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < tracks.size();
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
        public Album currentItem() {
            return tracks.get(index);
        }
    }
}
