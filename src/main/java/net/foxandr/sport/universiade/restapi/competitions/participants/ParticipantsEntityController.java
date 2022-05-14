package net.foxandr.sport.universiade.restapi.competitions.participants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParticipantsEntityController {

    private final ParticipantsEntityRepository participantsEntityRepository;

    @Autowired
    public ParticipantsEntityController(ParticipantsEntityRepository participantsEntityRepository) {
        this.participantsEntityRepository = participantsEntityRepository;
    }

    @GetMapping("/participants")
    public List<ParticipantsEntity> getParticipantsByLocale(String locale){
        return participantsEntityRepository.findParticipantsEntitiesByLocale(locale);
    }

//    @GetMapping("/games/{id}/participants")
//    public List<ParticipantsEntity> findParticipantsEntitiesByGameIdAndLocale(@PathVariable("id") Long id, String locale){
//        return participantsEntityRepository.findParticipantsEntitiesByGameIdAndLocale(id, locale);
//    }

}
