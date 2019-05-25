package pl.smtc.patterns.behavioral.iterator.aggregate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {
    private Playlist playlist = new Playlist();
    private Album initialAlbum = new Album("ALBUM_NAME", "MIX", 2000);

    @BeforeEach
    void setup() {
        playlist.addAlbum(initialAlbum);
    }

    @Test
    void addAlbumShouldAddNewAlbumToPlaylist() {
        assertEquals(1, playlist.tracks.size());
        playlist.addAlbum(new Album("SECOND", "POP", 2001));
        assertEquals(2, playlist.tracks.size());
        assertEquals("SECOND", playlist.tracks.get(1).getName());
        assertEquals("POP", playlist.tracks.get(1).getGenre());
        assertEquals(2001, playlist.tracks.get(1).getYear());
    }

    @Test
    void removeAlbumShouldRemoveExistingAlbumFromPlaylist() {
        assertEquals(1, playlist.tracks.size());
        playlist.removeAlbum(initialAlbum);
        assertEquals(0, playlist.tracks.size());
    }

    @Test
    void getAlbumsIteratorShouldReturnAlbumIterator() {
        Playlist.AlbumIterator iterator = playlist.getAlbumsIterator();
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals("ALBUM_NAME", iterator.currentItem().getName());
        assertEquals("MIX", iterator.currentItem().getGenre());
        assertEquals(2000, iterator.currentItem().getYear());
    }
}