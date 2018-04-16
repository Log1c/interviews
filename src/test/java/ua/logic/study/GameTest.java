package ua.logic.study;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//the perfect instance explanation for @Mock, @Spy, @InjectMock
public class GameTest {
    @Mock
    Player player;

    @Spy
    List<String> enemies = new ArrayList<>();

    @InjectMocks
    Game game;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void attackWithSwordTest() {
        Mockito.when(player.getWeapon()).thenReturn("Sword");

        enemies.add("Dragon");
        enemies.add("Orc");

        assertEquals(2, game.numberOfEnemies());

        assertEquals("Player attack with: Sword", game.attack());
    }
}
