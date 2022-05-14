//package net.foxandr.sport.universiade.restapi.competitions.games;
//
//import net.foxandr.sport.universiade.restapi.competitions.athletes.AthletesEntity;
//import net.foxandr.sport.universiade.restapi.competitions.athletes.AthletesEntityRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//public class CustomGameRepositoryImpl implements TestInterfaceRepository{
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Autowired
//    private AthletesEntityRepository athletesEntityRepository;
//
//
//    //    @Query("SELECT g " +
//    //            "FROM GamesEntity g " +
//    //            "JOIN FETCH g.participantsEntities p " +
//    //            "JOIN FETCH p.athletesEntity a " +
//    //            "JOIN FETCH a.athletesTEntities at " +
//    //            "WHERE at.locale = :locale AND g.id = :gameId")
//    //    List<GamesEntity> findParticipantsEntitiesByGameIdAndLocale(Long gameId, String locale);
//
//    @Override
//    public GamesEntity findParticipantsEntitiesByGameIdAndLocale(Long gameId, String locale) {
//        List<AthletesEntity> athletes = athletesEntityRepository.findAthletesEntityByLocale(locale);
//        return entityManager.createQuery(
//                "SELECT g FROM GamesEntity g JOIN FETCH g.participantsEntities p WHERE p.athletesEntity.
//    }
//}
