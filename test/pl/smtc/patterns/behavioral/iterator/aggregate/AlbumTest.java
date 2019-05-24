package pl.smtc.patterns.behavioral.iterator.aggregate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {
    private static final String TEST_NAME = "ALBUM_NAME";
    private static final String TEST_GENRE = "ALBUM_GENRE";
    private static final int TEST_YEAR = 2099;
    private Song testSong = new Song("TEST_ARTIST", "SONG_1");
    private Album testAlbum = new Album(TEST_NAME, TEST_GENRE, TEST_YEAR);

    @BeforeEach
    void setup() {
        testAlbum.addSong(testSong);
    }

    @Test
    void addSongShouldAddNewSongToAlbum() {
        assertEquals(1, testAlbum.songs.size());
        testAlbum.addSong(new Song("NEW_ARTIST", "SONG_2"));
        assertEquals(2, testAlbum.songs.size());
        assertEquals("NEW_ARTIST", testAlbum.songs.get(1).getArtist());
        assertEquals("SONG_2", testAlbum.songs.get(1).getTitle());
    }

    @Test
    void removeSongShouldRemoveExistingSongFromAlbum() {
        assertEquals(1, testAlbum.songs.size());
        testAlbum.removeSong(testSong);
        assertEquals(0, testAlbum.songs.size());
    }

    @Test
    void getNameShouldReturnAlbumName() {
        assertEquals(TEST_NAME, testAlbum.getName());
    }

    @Test
    void getGenreShouldReturnAlbumGenre() {
        assertEquals(TEST_GENRE, testAlbum.getGenre());
    }

    @Test
    void getYearShouldReturnAlbumYear() {
        assertEquals(TEST_YEAR, testAlbum.getYear());
    }

    @Test
    void getSongsIteratorShouldReturnSongIterator() {
        Album.SongIterator iterator = testAlbum.getSongsIterator();
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals("TEST_ARTIST", iterator.currentItem().getArtist());
        assertEquals("SONG_1", iterator.currentItem().getTitle());
    }
}