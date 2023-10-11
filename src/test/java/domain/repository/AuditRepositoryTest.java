package domain.repository;

import domain.model.Audit;
import domain.repository.AuditRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuditRepositoryTest {
    private AuditRepository auditRepository;

    @BeforeEach
    public void setUp() {
        auditRepository = new AuditRepository();
    }

    @Test
    public void testSaveOperation() {
            Audit audit = new Audit("Login", "testUser");
            auditRepository.saveOperation(audit);
            List<Audit> operations = auditRepository.operations; // Используйте поле operations для доступа к списку
            assertTrue(operations.contains(audit));
        }



    @Test
    public void testShowAudit() {
        Audit audit1 = new Audit("Login", "testUser1");
        Audit audit2 = new Audit("Logout", "testUser2");
        auditRepository.saveOperation(audit1);
        auditRepository.saveOperation(audit2);

        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutput));

        auditRepository.showAudit();

        String consoleOutputString = consoleOutput.toString();
        assertTrue(consoleOutputString.contains("Login"));
        assertTrue(consoleOutputString.contains("Logout"));
        assertTrue(consoleOutputString.contains("testUser1"));
        assertTrue(consoleOutputString.contains("testUser2"));
    }
}
