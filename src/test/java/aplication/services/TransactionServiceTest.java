package aplication.services;

import domain.model.Player;
import domain.repository.TransactionRepository;
import infrastructure.TransactionInfrastructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TransactionServiceTest {
    private TransactionService transactionService;
    private TransactionRepository transactionRepository;
    private Player testPlayer;

    @BeforeEach
    public void setUp() {
        transactionRepository = new TransactionInfrastructure();
        transactionService = new TransactionService(transactionRepository);
        testPlayer = new Player("testUser", "password123", 100.0);
    }

    @Test
    public void testCredit() {
        transactionService.credit("12345", testPlayer, 50.0);
        double balance = testPlayer.getBalance();
        assertTrue(transactionRepository.findTransactionByID("12345"));
        assertEquals(150.0, balance, 0.001);


        transactionService.credit("12345", testPlayer, 30.0);
        assertFalse(transactionRepository.findTransactionByID("12345"));
    }

    @Test
    public void testDebit() {
        transactionService.debit("54321", testPlayer, 30.0);
        double balance = testPlayer.getBalance();
        assertTrue(transactionRepository.findTransactionByID("54321"));
        assertEquals(70.0, balance, 0.001);


        transactionService.debit("54321", testPlayer, 20.0);
        assertFalse(transactionRepository.findTransactionByID("54321"));


        transactionService.debit("54322", testPlayer, 80.0);
        double newBalance = testPlayer.getBalance();
        assertFalse(transactionRepository.findTransactionByID("54322"));
        assertEquals(70.0, newBalance, 0.001);
    }
}
