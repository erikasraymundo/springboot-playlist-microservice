package app.music.playlist.song;

import app.music.playlist.album.Album;
import app.music.playlist.album.AlbumRepository;
import app.music.playlist.genre.Genre;
import app.music.playlist.genre.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SongService {
    private final SongRepository repository;
    private final AlbumRepository albumRepository;
    private final GenreRepository genreRepository;


    @Autowired
    public SongService(SongRepository repository, AlbumRepository albumRepository, GenreRepository genreRepository) {
        this.repository = repository;
        this.albumRepository = albumRepository;
        this.genreRepository = genreRepository;
    }


    public List<Song> all() {
        return repository.findAll();
    }

    public Song getSongById(UUID songId) {
        return repository.findById(songId)
                .orElseThrow(() -> new IllegalStateException("Song ID not found."));
    }

    public void addSong(Song song, UUID albumId) {

        if (albumId != null && albumId.toString().length() > 0) {
            Album album = albumRepository.findById(albumId)
                    .orElseThrow(() -> new IllegalStateException("Album ID does not exist."));

            song.setAlbum(album);
        }

        repository.save(song);
    }

    public void updateSong(UUID songId, String title, UUID albumId, List<Long> genreIds) {
        Song song = repository.findById(songId)
                .orElseThrow(() -> new IllegalStateException("Song ID not found."));

        if (title != null && title.length() > 0) {
            song.setTitle(title);
        }

        if (albumId != null && albumId.toString().length() > 0) {
            Album album = albumRepository.findById(albumId)
                    .orElseThrow(() -> new IllegalStateException("Album ID not found."));

            song.setAlbum(album);
        }

        if (genreIds != null && !genreIds.isEmpty()) {
            List<Genre> genres = (List<Genre>) genreIds.stream().map(id -> {
                return genreRepository.findById(id)
                        .orElseThrow(() -> new IllegalStateException("Genre ID not found."));
            });
        }

    }

    public void deleteSong(UUID id) {
        repository.deleteById(id);
    }

}
