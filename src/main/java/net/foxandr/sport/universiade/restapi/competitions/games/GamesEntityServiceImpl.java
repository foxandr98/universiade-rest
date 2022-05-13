package net.foxandr.sport.universiade.restapi.competitions.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GamesEntityServiceImpl implements GamesEntityService{

    private final GamesEntityRepository gamesEntityRepository;
    @Autowired
    public GamesEntityServiceImpl(GamesEntityRepository gamesEntityRepository) {
        this.gamesEntityRepository = gamesEntityRepository;
    }

    public List<GamesInfoEntityDTO> findGamesEntitiesByLocale(String locale){
        return gamesEntityRepository.findGamesEntitiesByLocale(locale).stream()
                .map(x -> new GamesInfoEntityDTO(x, x.getGamesTSById().get(0)))
                .collect(Collectors.toList());
    }

    public GamesInfoEntityDTO findGamesEntityByLocaleAndId(String locale, Long id){
        var gameInfo = gamesEntityRepository.findGamesEntityByLocaleAndId(locale, id);
        return new GamesInfoEntityDTO(gameInfo, gameInfo.getGamesTSById().get(0));
    }
}
