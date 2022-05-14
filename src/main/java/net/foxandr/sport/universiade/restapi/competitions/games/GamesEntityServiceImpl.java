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

    public List<GamesEntityInfoDTO> findGamesEntitiesByLocale(String locale){
        return gamesEntityRepository.findGamesEntitiesByLocale(locale).stream()
                .map(x -> new GamesEntityInfoDTO(x, x.getGamesTEntities().get(0)))
                .collect(Collectors.toList());
    }

    public GamesEntityInfoDTO findGamesEntityByLocaleAndId(String locale, Long id){
        var gameInfo = gamesEntityRepository.findGamesEntityByLocaleAndId(locale, id);
        return new GamesEntityInfoDTO(gameInfo, gameInfo.getGamesTEntities().get(0));
    }

    public List<GamesEntity> findParticipantsEntitiesByGameIdAndLocale(Long gameId, String locale){
        return gamesEntityRepository.findParticipantsEntitiesByGameIdAndLocale(gameId, locale);
    }

}
