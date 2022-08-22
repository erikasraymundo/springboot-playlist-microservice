package app.music.playlist;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface APIController<T, V> {

    public List<T> getAll();

    public void add(T entry);

    public void delete(V id);

}
