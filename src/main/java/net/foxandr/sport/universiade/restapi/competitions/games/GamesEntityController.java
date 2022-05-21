package net.foxandr.sport.universiade.restapi.competitions.games;

import net.foxandr.sport.universiade.restapi.competitions.games.events.EventsDTOProjection;
import net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines.sports.SportsDTOProjection;
import net.foxandr.sport.universiade.restapi.competitions.venues.VenuesDTOProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class GamesEntityController {

    GamesEntityService gamesEntityService;

    @Autowired
    public GamesEntityController(GamesEntityService gamesEntityService) {
        this.gamesEntityService = gamesEntityService;
    }


    @GetMapping("/games")
    public List<GamesDTOProjection> getGamesByLocale(String locale){
        try{
            return gamesEntityService.findShortGamesInfoByLocale(locale);
        } catch (Exception ex) {
            return null;
        }
    }

    @GetMapping("/games/{id}")
    public Set<GamesEntity> getGamesObjectsByLocale(String locale,
                                                    @PathVariable(name = "id") Long id){
        try{
            return gamesEntityService.findFullGamesInfoByLocaleAndId(locale, id);
        } catch (Exception ex) {
            return null;
        }
    }


    @GetMapping("/games/{id}/venues")
    public List<VenuesDTOProjection> findEventsByLocaleAndGameId(String locale,
                                                                 @PathVariable(name="id") Long gameId){
        return gamesEntityService.findDistinctVenuesByLocaleAndGameId(locale, gameId);
    }

    @GetMapping("/games/{id}/events")
    public List<EventsDTOProjection> findAllEventsByLocaleAndGameId(String locale,
                                                                    @PathVariable(name="id") Long gameId)
    {
        return gamesEntityService.findAllEventsByLocaleAndGameId(locale, gameId);
    }

    @GetMapping("/games/{id}/sports")
    public List<SportsDTOProjection> findDistinctSportsByLocaleAndGameId(String locale,
                                                                         @PathVariable(name="id") Long gameId)
    {
        return gamesEntityService.findDistinctSportsByLocaleAndGameId(locale, gameId);
    }

//    @GetMapping("/games/{id}/participants")
//    public List<GamesEntity> findParticipantsEntitiesByGameIdAndLocale(@PathVariable("id") Long id, String locale){
//        return gamesEntityService.findParticipantsEntitiesByGameIdAndLocale(id, locale);
//    }


}
