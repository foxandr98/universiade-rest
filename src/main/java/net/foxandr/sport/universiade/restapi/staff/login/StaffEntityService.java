package net.foxandr.sport.universiade.restapi.staff.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffEntityService {
    StaffEntityRepository staffEntityRepository;

    @Autowired
    public StaffEntityService(StaffEntityRepository staffEntityRepository) {
        this.staffEntityRepository = staffEntityRepository;
    }

    public StaffEntity getByLogin(String login){
        return staffEntityRepository.findByLoginName(login);
    }

}
