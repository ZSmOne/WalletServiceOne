package domain.model;

import domain.model.Player;
import domain.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    private Transaction transaction;
    private Player testPlayer;

    @BeforeEach
    public void setUp() {
        // Создаем игрока для использования в транзакции
        testPlayer = new Player("testUser", "password123", 100.0);
        // Создаем транзакцию
        transaction = new Transaction("12345", testPlayer, 50.0, "deposit");
    }

    @Test
    public void testGetTransactionId() {
        String transactionId = transaction.getTransactionId();
        assertEquals("12345", transactionId);
    }
}
