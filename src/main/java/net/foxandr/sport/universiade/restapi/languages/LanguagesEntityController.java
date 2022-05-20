package net.foxandr.sport.universiade.restapi.languages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class LanguagesEntityController {

    LanguagesEntityRepository languagesEntityRepository;

    @Autowired
    public LanguagesEntityController(LanguagesEntityRepository languagesEntityRepository) {
        this.languagesEntityRepository = languagesEntityRepository;
    }

    @GetMapping("/languages")
    public List<LanguagesEntity> getAllLanguages(){
        return languagesEntityRepository.findAll();
    }

}
