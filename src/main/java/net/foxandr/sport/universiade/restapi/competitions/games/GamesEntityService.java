package net.foxandr.sport.universiade.restapi.competitions.games;

import net.foxandr.sport.universiade.restapi.competitions.games.gamesDTO.GameDTO;
import net.foxandr.sport.universiade.restapi.competitions.games.gamesDTO.GameDTOList;
import net.foxandr.sport.universiade.restapi.competitions.games.gamesDTO.GameDTOProjection;
import net.foxandr.sport.universiade.restapi.competitions.games.gamesDTO.GameEventsProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
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

    public List<GameDTOProjection> findGamesObjectsByLocale(String locale){
        return gamesEntityRepository.findGamesObjectsByLocale(locale);

    }

    public GamesEntity findGamesEntityByLocaleAndId(String locale, Long id){
        return gamesEntityRepository.findGamesEntityByLocaleAndId(locale, id);
    }




    public Set<GameEventsProjection> findAllGamesEventsProjections(){
        return gamesEntityRepository.findAllGamesEventsProjections();
    }



//    public List<GameDTOList> test(String locale){
//        return gamesEntityRepository.test(locale);
//    }

//    public GameDTO findGamesEntityById(Long id){
//        return gamesEntityRepository.findGamesEntitiesById(id);
//    }



}
