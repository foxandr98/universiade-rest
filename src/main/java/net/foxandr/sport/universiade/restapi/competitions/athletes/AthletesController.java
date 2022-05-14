package net.foxandr.sport.universiade.restapi.competitions.athletes;

import net.foxandr.sport.universiade.restapi.competitions.games.GamesEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AthletesController {

    private final AthletesEntityRepository athletesEntityRepository;

    @Autowired
    public AthletesController(AthletesEntityRepository athletesEntityRepository) {
        this.athletesEntityRepository = athletesEntityRepository;
    }

    @GetMapping("/athletes")
    public List<AthletesEntityInfoDTO> getAthletes(String locale){
        try {
            return athletesEntityRepository.findAthletesEntityByLocale(locale).stream()
                    .map(x -> new AthletesEntityInfoDTO(x, x.getAthletesTEntities().get(0)))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
}
