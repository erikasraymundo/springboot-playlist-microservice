package app.music.playlist.album;

import app.music.playlist.APIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/album/")
public class AlbumController implements APIController<Album, UUID> {

    private final AlbumService service;

    @Autowired
    public AlbumController(AlbumService service) {
        this.service = service;
    }

    @GetMapping("all")
    @Override
    public List<Album> getAll() {
        return service.all();
    }

    @PostMapping("add")
    @Override
    public void add(@RequestBody Album album) {
        service.addAlbum(album);
    }

    @PutMapping("update/{id}")
    public void update(@PathVariable UUID id,
                       @RequestBody Album album) {

        service.updateAlbum(id, album.getTitle(), album.getSinger(), album.getReleaseDate(), album.getUrlCoverPhoto());
    }

    @GetMapping("delete/{id}")
    @Override
    public void delete(@PathVariable UUID id) {
        service.deleteAlbum(id);
    }
}
