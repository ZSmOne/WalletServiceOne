package infrastructure;

import domain.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlayerInfrastructureTest {
    private PlayerInfrastructure playerInfrastructure;

    @BeforeEach
    public void setUp() {
        playerInfrastructure = new PlayerInfrastructure();
    }

    @Test
    public void testSaveUser() {
        Player player = new Player("testUser", "password123", 100.0);
        playerInfrastructure.saveUser(player);
        Player savedPlayer = playerInfrastructure.findByUsername("testUser");
        assertEquals("testUser", savedPlayer.getUsername());
    }

    @Test
    public void testFindByUsername() {
        Player notFoundPlayer = playerInfrastructure.findByUsername("nonexistentUser");
        assertNull(notFoundPlayer);

        Player player = new Player("testUser", "password123", 100.0);
        playerInfrastructure.saveUser(player);
        Player foundPlayer = playerInfrastructure.findByUsername("testUser");
        assertEquals("testUser", foundPlayer.getUsername());
    }
}

