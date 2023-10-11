package aplication.services;

import domain.model.Player;
import domain.repository.PlayerRepository;
import infrastructure.PlayerInfrastructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerServiceTest {
    private PlayerService playerService;
    private PlayerRepository playerRepository;

    @BeforeEach
    public void setUp() {
        playerRepository = new PlayerInfrastructure();
        playerService = new PlayerService(playerRepository);
    }

    @Test
    public void testRegister() {
        Player newPlayer = playerService.register("testUser", "password123");
        assertNotNull(newPlayer);
        assertEquals("testUser", newPlayer.getUsername());


        Player duplicatePlayer = playerService.register("testUser", "anotherPassword");
        assertNull(duplicatePlayer);
    }

    @Test
    public void testLogin() {
        Player player = playerService.register("testUser", "password123");

        Player loggedInPlayer = playerService.login("testUser", "password123");
        assertNotNull(loggedInPlayer);


        Player wrongPasswordPlayer = playerService.login("testUser", "wrongPassword");
        assertNull(wrongPasswordPlayer);


        Player nonexistentPlayer = playerService.login("nonexistentUser", "password123");
        assertNull(nonexistentPlayer);
    }

    @Test
    public void testViewBalance() {
        Player player = playerService.register("testUser", "password123");
        double balance = playerService.viewBalance("testUser");
        assertEquals(0.0, balance, 0.001); // Проверьте, что баланс равен 0 после регистрации
    }
}

