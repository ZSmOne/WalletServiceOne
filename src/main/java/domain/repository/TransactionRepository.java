package domain.repository;

import domain.model.Transaction;

public interface TransactionRepository {
    void saveTransaction(Transaction transaction);
    boolean findTransactionByID(String transactionID);
}
