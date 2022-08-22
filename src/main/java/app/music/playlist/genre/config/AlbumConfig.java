package app.music.playlist.genre.config;

import app.music.playlist.album.Album;
import app.music.playlist.album.AlbumRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class AlbumConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(AlbumRepository repository) {
//        return args -> {
//            Album folklore = new Album(
//                    "Folklore",
//                    LocalDate.of(2020, 7, 24),
//                    "Taylor Swift"
//            );
//
//            Album lover = new Album(
//                    "Lover",
//                    LocalDate.of(2019, 8, 23),
//                    "Taylor Swift",
//                    "https://i.redd.it/trcrquo8r1j41.jpg"
//            );
//
//            repository.saveAll(List.of(folklore, lover));
//        };
//    }

}
