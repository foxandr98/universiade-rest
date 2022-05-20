package net.foxandr.sport.universiade.restapi.competitions.games;

import net.foxandr.sport.universiade.restapi.competitions.games.gamesDTO.GameDTO;
import net.foxandr.sport.universiade.restapi.competitions.games.gamesDTO.GameDTOList;
import net.foxandr.sport.universiade.restapi.competitions.games.gamesDTO.GameDTOProjection;
import net.foxandr.sport.universiade.restapi.competitions.participants.ParticipantsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class GamesEntityController {

    GamesEntityService gamesEntityService;

    @Autowired
    public GamesEntityController(GamesEntityService gamesEntityService) {
        this.gamesEntityService = gamesEntityService;
    }

    @GetMapping("/games")
    public List<GamesEntity> getGamesByLocale(String locale){
        try{
//            return gamesEntityService.findGamesEntitiesByLocale(locale).stream()
//                    .map(x -> new GamesEntityInfoDTO(x, x.getGamesTEntities().get(0)))
//                    .collect(Collectors.toList());
            var a = gamesEntityService.findGamesEntitiesByLocale(locale);
            return a;
        } catch (Exception ex) {
            return null;
        }

    }

    @GetMapping("/gameso")
    public List<GameDTOProjection> getGamesObjectsByLocale(String locale){
        try{
//            return gamesEntityService.findGamesEntitiesByLocale(locale).stream()
//                    .map(x -> new GamesEntityInfoDTO(x, x.getGamesTEntities().get(0)))
//                    .collect(Collectors.toList());
            var a = gamesEntityService.findGamesObjectsByLocale(locale);
            return a;
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
