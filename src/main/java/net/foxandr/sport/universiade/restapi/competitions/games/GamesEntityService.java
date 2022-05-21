package net.foxandr.sport.universiade.restapi.competitions.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GamesEntityService {

    GamesEntityRepository gamesEntityRepository;
    @Autowired
    public GamesEntityService(GamesEntityRepository gamesEntityRepository) {
        this.gamesEntityRepository = gamesEntityRepository;
    }


    public Set<GamesEntity> findFullGamesInfoByLocaleAndId(String locale, Long id){
        return gamesEntityRepository.findFullGamesInfoByLocaleAndId(locale, id);
    }


    public List<GamesDTOProjection> findShortGamesInfoByLocale(String locale){
        return gamesEntityRepository.findShortGamesInfoByLocale(locale);

    }

}
