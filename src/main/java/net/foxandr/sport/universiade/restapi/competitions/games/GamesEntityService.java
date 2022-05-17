package net.foxandr.sport.universiade.restapi.competitions.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GamesEntityService {

    GamesEntityRepository gamesEntityRepository;
    @Autowired
    public GamesEntityService(GamesEntityRepository gamesEntityRepository) {
        this.gamesEntityRepository = gamesEntityRepository;
    }

    public List<GamesEntity> findGamesEntitiesByLocale(String locale){
        return gamesEntityRepository.findGamesEntitiesByLocale(locale);

    }

    public GamesEntity findGamesEntityByLocaleAndId(String locale, Long id){
        return gamesEntityRepository.findGamesEntityByLocaleAndId(locale, id);
    }


}
