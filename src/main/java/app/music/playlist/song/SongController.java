package app.music.playlist.song;

import app.music.playlist.APIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/song/")
public class SongController implements APIController<Song, UUID> {

    private final SongService service;

    @Autowired
    public SongController(SongService service) {
        this.service = service;
    }

    @GetMapping("all")
    @Override
    public List<Song> getAll() {
        return service.all();
    }

    @Override
    public void add(Song entry) {

    }

    @PostMapping("add")
    public void add(
            @RequestBody Song song,
            @RequestParam(required = false) UUID albumId) {
        service.addSong(song, albumId);
    }

    @GetMapping("{id}")
    public Song getSongById(@PathVariable String id) {
        return service.getSongById(UUID.fromString(id));
    }

    @PostMapping("update/{id}")
    public void update(@PathVariable UUID id,
                       @RequestBody String title,
                       @RequestBody UUID albumId,
                       @RequestBody List<Long> genreIds) {
        service.updateSong(id,title, albumId, genreIds);
    }

    @RequestMapping("delete/{id}")
    @Override
    public void delete(@PathVariable UUID id) {
        service.deleteSong(id);
    }
}
