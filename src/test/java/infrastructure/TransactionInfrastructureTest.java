package infrastructure;

import domain.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TransactionInfrastructureTest {
    private TransactionInfrastructure transactionInfrastructure;

    @BeforeEach
    public void setUp() {
        transactionInfrastructure = new TransactionInfrastructure();
    }

    @Test
    public void testSaveTransaction() {
        Transaction transaction = new Transaction("12345", null, 50.0, "deposit");
        transactionInfrastructure.saveTransaction(transaction);
        assertTrue(transactionInfrastructure.findTransactionByID("12345"));
    }

    @Test
    public void testFindTransactionByID() {

        boolean result = transactionInfrastructure.findTransactionByID("nonexistentID");
        assertFalse(result);


        Transaction transaction = new Transaction("54321", null, 30.0, "withdraw");
        transactionInfrastructure.saveTransaction(transaction);
        boolean found = transactionInfrastructure.findTransactionByID("54321");
        assertTrue(found);
    }
}
