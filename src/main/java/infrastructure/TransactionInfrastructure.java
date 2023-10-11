package infrastructure;

import domain.model.Transaction;
import domain.repository.TransactionRepository;


import java.util.HashSet;
import java.util.Set;
/**
 * Класс, отвечающий за хранение и управление транзакциями в памяти приложения.
 * Имплементирует интерфейс репозитория игроков TransactionRepository.
 */
public class TransactionInfrastructure implements TransactionRepository {

    private Set<String> transactionData = new HashSet<>();
    /**
     * Этот метод реализует метод интерфейса TransactionRepository
     * Добавляет транзакцию в репозиторий.
     * @param transaction добавляемая транзакция.
     */
    @Override
    public void saveTransaction(Transaction transaction) {
        transactionData.add(transaction.getTransactionId());
    }
    /**
     * Этот метод реализует метод интерфейса TransactionRepository
     * Проверяе, существует ли уже транзакция с таким ID.
     * @param transactionID ID транзакции.
     * @return true, если транзакции с таким ID есть и false, если нет.
     */
    @Override
    public boolean findTransactionByID(String transactionID) {
        return transactionData.contains(transactionID);
    }
}
