package domain.model;

import domain.model.Audit;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuditTest {
    @Test
    public void testGetTime() {
        Audit audit = new Audit("Login", "testUser");
        LocalDateTime time = audit.getTime();
        assertNotNull(time);
    }

    @Test
    public void testGetTypeOperation() {
        Audit audit = new Audit("Logout", "testUser");
        String typeOperation = audit.getTypeOperation();
        assertEquals("Logout", typeOperation);
    }

    @Test
    public void testGetUsername() {
        Audit audit = new Audit("Deposit", "testUser");
        String username = audit.getUsername();
        assertEquals("testUser", username);
    }
}
