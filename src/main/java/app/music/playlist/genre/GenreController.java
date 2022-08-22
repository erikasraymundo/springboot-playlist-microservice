package app.music.playlist.genre;

import app.music.playlist.APIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genre/")
public class GenreController implements APIController<Genre, Long> {

    private final GenreService service;

    @Autowired
    public GenreController(GenreService service) {
        this.service = service;
    }

    @GetMapping("all")
    @Override
    public List<Genre> getAll() {
        return service.all();
    }

    @PostMapping(value = "add")
    @Override
    public void add(@RequestBody Genre genre) {
        service.addGenre(genre);
    }

    @PutMapping(value = "update/{id}")
    public void update(@PathVariable Long id, @RequestBody Genre genre) {
        service.updateGenre(id, genre.getTitle());
    }

    @GetMapping("delete/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        service.deleteGenre(id);
    }
}
