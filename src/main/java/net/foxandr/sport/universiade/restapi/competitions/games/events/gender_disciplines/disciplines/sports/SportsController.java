package net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines.sports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SportsController {

    SportsRepository sportsRepository;

    @Autowired
    public SportsController(SportsRepository sportsRepository) {
        this.sportsRepository = sportsRepository;
    }

    @GetMapping("/sports")
    public List<SportDTOProjection> getSports(String locale, Long id){
        return sportsRepository.findDistinctSportsByLocaleAndGameId(id, locale);
    }

}
