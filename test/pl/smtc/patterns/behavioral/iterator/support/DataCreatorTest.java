package pl.smtc.patterns.behavioral.iterator.support;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.smtc.patterns.behavioral.iterator.aggregate.Album;
import pl.smtc.patterns.behavioral.iterator.aggregate.Playlist;

import static org.junit.jupiter.api.Assertions.*;

class DataCreatorTest {
    private Playlist playlist;

    @BeforeEach
    void setup() {
        playlist = new DataCreator().createPlaylist();
    }

    @Test
    void createPlaylistShouldHaveTestData() {
        assertTrue(playlist.getAlbumsIterator().hasNext());
    }

    @Test
    void createPlaylistShouldHaveAlbumQueenAsFirstElement() {
        playlist.getAlbumsIterator().first();
        Album firstAlbum = playlist.getAlbumsIterator().currentItem();
        assertEquals("Greatest Hits", firstAlbum.getName());
    }

    @Test
    void createPlaylistShouldHaveTwoAlbums() {
        int albumCounter = 0;
        Playlist.AlbumIterator albumIterator = playlist.getAlbumsIterator();
        while(albumIterator.hasNext()) {
            albumCounter++;
            albumIterator.next();
        }
        assertEquals(2, albumCounter);
    }

    @Test
    void createPlaylistShouldHaveSevenSongs() {
        int songCounter = 0;
        Playlist.AlbumIterator albumIterator = playlist.getAlbumsIterator();
        while(albumIterator.hasNext()) {
            Album currentAlbum = albumIterator.currentItem();
            Album.SongIterator songIterator = currentAlbum.getSongsIterator();
            while(songIterator.hasNext()) {
                songCounter++;
                songIterator.next();
            }
            albumIterator.next();
        }
        assertEquals(7, songCounter);
    }

}