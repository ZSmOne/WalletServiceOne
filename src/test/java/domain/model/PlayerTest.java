package domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("testUser", "password123", 100.0);
    }

    @Test
    public void testGetUsername() {
        String username = player.getUsername();
        assertEquals("testUser", username);
    }

    @Test
    public void testGetPassword() {
        String password = player.getPassword();
        assertEquals("password123", password);
    }

    @Test
    public void testGetBalance() {
        double balance = player.getBalance();
        assertEquals(100.0, balance, 0.001);
    }
}
