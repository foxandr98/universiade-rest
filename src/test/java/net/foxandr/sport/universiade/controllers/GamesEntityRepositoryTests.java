package net.foxandr.sport.universiade.controllers;

import net.foxandr.sport.universiade.restapi.competitions.games.GamesEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.GamesEntityRepository;
import net.foxandr.sport.universiade.restapi.competitions.games.GamesInfoEntityDTO;
import net.foxandr.sport.universiade.restapi.competitions.games.GamesTEntity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GamesEntityRepositoryTests {

    @Autowired
    private GamesEntityRepository gamesEntityRepository;

    @Test
    public void notNull(){
        Assert.assertNotNull(gamesEntityRepository);
    }

    @Test
    public void getGamesEntityByLocaleAndIdTest() throws Exception{
        List<GamesTEntity> gameTEntity = new ArrayList<GamesTEntity>();
        gameTEntity.add(new GamesTEntity("Казань", "XXVII Всемирная летняя Универсиада 2013"));
        var gameEntity = new GamesEntity((long) 1, "WSGS2013", (short) 2013, true, gameTEntity);

        Assert.assertEquals(gameEntity, gamesEntityRepository.findGamesEntityByLocaleAndId("ru", (long)1));

    }
}
