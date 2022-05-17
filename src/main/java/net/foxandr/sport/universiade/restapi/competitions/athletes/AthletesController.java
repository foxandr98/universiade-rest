package net.foxandr.sport.universiade.restapi.competitions.athletes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
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

    @GetMapping("/athletes/{id}")
    public AthletesEntity getAthletes(@PathVariable(name = "id") Long id, String locale){
        try {
            return athletesEntityRepository.findAthletesEntityByLocaleAndId(locale, id);
        } catch (Exception ex) {
            return null;
        }
    }

}
