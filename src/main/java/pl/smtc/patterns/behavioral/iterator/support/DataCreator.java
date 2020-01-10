package pl.smtc.patterns.behavioral.iterator.support;

import pl.smtc.patterns.behavioral.iterator.aggregate.Album;
import pl.smtc.patterns.behavioral.iterator.aggregate.Playlist;
import pl.smtc.patterns.behavioral.iterator.aggregate.Song;

import java.util.ArrayList;
import java.util.List;

public class DataCreator {

    public Playlist createPlaylist() {
        Playlist playlist = new Playlist();
        playlist.addAlbum(createQueenAlbum());
        playlist.addAlbum(createEminemAlbum());

        return playlist;
    }

    private Album createQueenAlbum() {
        List<Song> queenSongs = new ArrayList<>();
        String artistName = "Queen";
        queenSongs.add(new Song(artistName, "Bohemian Rhapsody"));
        queenSongs.add(new Song(artistName, "Another One Bites the Dust"));
        queenSongs.add(new Song(artistName, "Don't Stop Me Now"));
        queenSongs.add(new Song(artistName, "We Will Rock You"));

        return createAlbum("Greatest Hits", queenSongs);
    }

    private Album createEminemAlbum() {
        List<Song> queenSongs = new ArrayList<>();
        String artistName = "Eminem";
        queenSongs.add(new Song(artistName, "Stan"));
        queenSongs.add(new Song(artistName, "The Way I Am"));
        queenSongs.add(new Song(artistName, "The Real Slim Shady"));

        return createAlbum("The Marshall Mathers LP", queenSongs);
    }

    private Album createAlbum(String albumName, List<Song> songs) {
        Album album = new Album(albumName, "MIX", 2001);
        songs.forEach(album::addSong);

        return album;
    }
}
