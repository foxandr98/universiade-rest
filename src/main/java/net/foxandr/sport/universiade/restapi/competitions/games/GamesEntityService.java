package net.foxandr.sport.universiade.restapi.competitions.games;

import net.foxandr.sport.universiade.restapi.competitions.venues.VenuesDTOProjection;
import net.foxandr.sport.universiade.restapi.competitions.venues.VenuesEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GamesEntityService {

    GamesEntityRepository gamesEntityRepository;
    VenuesEntityRepository venuesEntityRepository;

    @Autowired
    public GamesEntityService(GamesEntityRepository gamesEntityRepository, VenuesEntityRepository venuesEntityRepository) {
        this.gamesEntityRepository = gamesEntityRepository;
        this.venuesEntityRepository = venuesEntityRepository;
    }

    public Set<GamesEntity> findFullGamesInfoByLocaleAndId(String locale, Long id){
        return gamesEntityRepository.findFullGamesInfoByLocaleAndId(locale, id);
    }


    public List<GamesDTOProjection> findShortGamesInfoByLocale(String locale){
        return gamesEntityRepository.findShortGamesInfoByLocale(locale);
    }


    public List<VenuesDTOProjection> findDistinctVenuesByLocaleAndGameId(String locale, Long id){
        return venuesEntityRepository.findDistinctVenuesByLocaleAndGameId(locale, id);
    }

}
