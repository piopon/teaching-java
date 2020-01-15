package pl.smtc.patterns.behavioral.iterator;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.behavioral.iterator.aggregate.Album;
import pl.smtc.patterns.behavioral.iterator.aggregate.Playlist;
import pl.smtc.patterns.behavioral.iterator.aggregate.Song;
import pl.smtc.patterns.behavioral.iterator.support.DataCreator;

import java.util.ArrayList;
import java.util.List;

public class IteratorPattern implements ConsoleExample {
    @Override
    public void execute() {
        Playlist myPlaylist = new DataCreator().createPlaylist();
        System.out.println("PLAYLIST:");
        Playlist.AlbumIterator albumIterator = myPlaylist.getAlbumsIterator();
        while (albumIterator.hasNext()) {
            printSongs(albumIterator.currentItem());
            albumIterator.next();
        }
    }

    @Override
    public String getName() {
        return "Iterator pattern";
    }

    private void printSongs(Album album) {
        String albumName = album.getName();
        Album.SongIterator songIterator = album.getSongsIterator();
        while (songIterator.hasNext()) {
            String songArtist = songIterator.currentItem().getArtist();
            String songTitle =  songIterator.currentItem().getTitle();
            System.out.println(" * " + songArtist + " - " + songTitle + " [album: " + albumName + "]");
            songIterator.next();
        }
    }
}
