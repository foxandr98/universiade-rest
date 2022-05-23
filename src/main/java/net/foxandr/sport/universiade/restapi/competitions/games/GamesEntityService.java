package net.foxandr.sport.universiade.restapi.competitions.games;

import net.foxandr.sport.universiade.restapi.competitions.games.events.EventsCompetitorsEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.events.EventsDTOProjection;
import net.foxandr.sport.universiade.restapi.competitions.games.events.EventsEntityRepository;
import net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines.sports.SportsDTOProjection;
import net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines.sports.SportsEntityRepository;
import net.foxandr.sport.universiade.restapi.competitions.games.medals.MedalsSummaryEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.medals.MedalsSummaryRepository;
import net.foxandr.sport.universiade.restapi.competitions.participants.ParticipantsEntity;
import net.foxandr.sport.universiade.restapi.competitions.participants.ParticipantsEntityRepository;
import net.foxandr.sport.universiade.restapi.competitions.venues.VenuesDTOProjection;
import net.foxandr.sport.universiade.restapi.competitions.venues.VenuesEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class GamesEntityService {

    GamesEntityRepository gamesEntityRepository;
    VenuesEntityRepository venuesEntityRepository;
    EventsEntityRepository eventsEntityRepository;

    SportsEntityRepository sportsEntityRepository;

    ParticipantsEntityRepository participantsEntityRepository;

    MedalsSummaryRepository medalsSummaryRepository;

    @Autowired
    public GamesEntityService(GamesEntityRepository gamesEntityRepository,
                              VenuesEntityRepository venuesEntityRepository,
                              EventsEntityRepository eventsEntityRepository,
                              SportsEntityRepository sportsEntityRepository,
                              ParticipantsEntityRepository participantsEntityRepository,
                              MedalsSummaryRepository medalsSummaryRepository) {
        this.gamesEntityRepository = gamesEntityRepository;
        this.venuesEntityRepository = venuesEntityRepository;
        this.eventsEntityRepository = eventsEntityRepository;
        this.sportsEntityRepository = sportsEntityRepository;
        this.participantsEntityRepository = participantsEntityRepository;
        this.medalsSummaryRepository = medalsSummaryRepository;
    }


    public Set<GamesEntity> findFullGamesInfoByLocaleAndId(String locale, Long id) {
        return gamesEntityRepository.findFullGamesInfoByLocaleAndId(locale, id);
    }


    public List<GamesDTOProjection> findShortGamesInfoByLocale(String locale) {
        return gamesEntityRepository.findShortGamesInfoByLocale(locale);
    }


    public List<VenuesDTOProjection> findDistinctVenuesByLocaleAndGameId(String locale, Long id) {
        return venuesEntityRepository.findDistinctVenuesByLocaleAndGameId(locale, id);
    }

    public List<EventsDTOProjection> findAllEventsByLocaleAndGameId(String locale, Long id) {
        return eventsEntityRepository.findAllEventsByLocaleAndGameId(locale, id);
    }

    public List<SportsDTOProjection> findDistinctSportsByLocaleAndGameId(String locale, Long id) {
        return sportsEntityRepository.findDistinctSportsByLocaleAndGameId(locale, id);
    }


//    public Set<GamesParticipantsDTO> findAllParticipantsByLocaleAndId(String locale, Long id){
//        return gamesEntityRepository.findAllParticipantsByLocaleAndId(locale, id);
//    }

    public Set<ParticipantsEntity> findAllParticipantsByLocaleAndId(String locale, Long id) {
        return participantsEntityRepository.findAllParticipantsByLocaleAndId(locale, id);
    }

    public Set<EventsCompetitorsEntity> findCompetitorsResultsByLocaleAndEventId(String locale,
                                                                                 Long gameId, Long eventId) {
        return participantsEntityRepository.findCompetitorsResultsByLocaleAndEventId(locale, gameId, eventId);
    }


    public List<MedalsSummaryEntity> getMedalsSummaryByLocaleAndGameId(String locale, Long gameId) {
        return medalsSummaryRepository.getMedalsSummaryByLocaleAndGameId(locale, gameId);
    }

}
