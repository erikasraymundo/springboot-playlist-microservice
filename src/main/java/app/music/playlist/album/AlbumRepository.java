package app.music.playlist.album;

import app.music.playlist.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID> {

    Optional<Album> findAlbumByTitle(String title);

}
