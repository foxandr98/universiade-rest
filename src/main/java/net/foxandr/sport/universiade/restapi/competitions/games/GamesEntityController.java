package net.foxandr.sport.universiade.restapi.competitions.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GamesEntityController {

    private final GamesEntityRepository gamesEntityRepository;

    @Autowired
    public GamesEntityController(GamesEntityRepository gamesEntityRepository) {
        this.gamesEntityRepository = gamesEntityRepository;
    }

    @GetMapping("/games")
    public List<GamesEntity> getGamesByLocale(String locale){
        return gamesEntityRepository.findAllByLocale(locale);
    }

//    @GetMapping("/games/{id}")
//    public GamesEntity getGameById(@PathVariable("id") Long id){
//        return gamesEntityRepository.findGamesEntitiesById(id);
//    }
}
