package net.foxandr.sport.universiade.restapi.competitions.games;

import net.foxandr.sport.universiade.restapi.competitions.participants.ParticipantsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GamesEntityController {

    private final GamesEntityServiceImpl gamesEntityService;

    @Autowired
    public GamesEntityController(GamesEntityServiceImpl gamesEntityService) {
        this.gamesEntityService = gamesEntityService;
    }

    @GetMapping("/games")
    public List<GamesEntityInfoDTO> getGamesByLocale(String locale){
        try{
            return gamesEntityService.findGamesEntitiesByLocale(locale);
        } catch (Exception ex) {
            return null;
        }

    }

    @GetMapping("/games/{id}")
    public GamesEntityInfoDTO getGameById(@PathVariable("id") Long id, String locale){

        try{
            return gamesEntityService.findGamesEntityByLocaleAndId(locale, id);
        } catch (Exception ex) {
            return null;
        }
    }

    @GetMapping("/games/{id}/participants")
    public List<GamesEntity> findParticipantsEntitiesByGameIdAndLocale(@PathVariable("id") Long id, String locale){
        return gamesEntityService.findParticipantsEntitiesByGameIdAndLocale(id, locale);
    }


}
