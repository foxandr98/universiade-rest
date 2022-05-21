package net.foxandr.sport.universiade.restapi.competitions.games;

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

    @GetMapping("/gameso")
    public Set<GamesEntity> getGamesObjectsByLocale(String locale, Long id){
        try{
            return gamesEntityService.findFullGamesInfoByLocaleAndId(locale, id);
        } catch (Exception ex) {
            return null;
        }
    }







//    @GetMapping("/gamestest")
//    public List<GameDTOList> test(String locale){
//        try{
//            var a = gamesEntityService.test(locale);
//            return a;
//        } catch (Exception ex) {
//            return null;
//        }
//
//    }



//    @GetMapping("/gamestest")
//    public List<GameDTO> getTest(Long id){
//        var a = gamesEntityService.findGamesEntityById(id);
//        var b = a.get(0).getCodeName();
//        return a;
//    }

//    @GetMapping("/gamestest")
//    public GameDTO getTest(Long id){
//        var a = gamesEntityService.findGamesEntityById(id);
//        var b = a.getCodeName();
//        var c = a.getIocName();
//        return a;
//    }

//    @GetMapping("/games/{id}")
//    public GamesEntityInfoDTO getGameById(@PathVariable("id") Long id, String locale){
//        try{
//            var gameEntity = gamesEntityService.findGamesEntityByLocaleAndId(locale, id);
//            return new GamesEntityInfoDTO(gameEntity, gameEntity.getGamesTEntities().get(0));
//        } catch (Exception ex) {
//            return null;
//        }
//    }

//    @GetMapping("/games/{id}/participants")
//    public List<GamesEntity> findParticipantsEntitiesByGameIdAndLocale(@PathVariable("id") Long id, String locale){
//        return gamesEntityService.findParticipantsEntitiesByGameIdAndLocale(id, locale);
//    }


}
