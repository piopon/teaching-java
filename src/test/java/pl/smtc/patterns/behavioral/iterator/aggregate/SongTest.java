package pl.smtc.patterns.behavioral.iterator.aggregate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    private static final String TEST_ARTIST = "TEST_ARTIST";
    private static final String TEST_TITLE = "TEST_TITLE";
    private Song testSong = new Song(TEST_ARTIST, TEST_TITLE);

    @Test
    void getArtistShouldReturnSongArtist() {
        assertEquals(TEST_ARTIST, testSong.getArtist());
    }

    @Test
    void getTitleShouldReturnSongTitle() {
        assertEquals(TEST_TITLE, testSong.getTitle());
    }
}