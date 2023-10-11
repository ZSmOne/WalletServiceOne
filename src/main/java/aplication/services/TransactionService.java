package aplication.services;

import domain.model.Player;
import domain.model.Transaction;
import domain.repository.TransactionRepository;
/**
 * Класс предоставляющий функциональность и бизнес-логику, связанную с управлением транзакциями.
 */
public class TransactionService {

    private TransactionRepository transactionRepository;

    /**
     * Конструктор класса TransactionService.
     *
     * @param transactionRepository Репозиторий транзакций, с которым взаимодействует сервис.
     */
    public TransactionService (TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    /**
     * Зачисляет средства на баланс игрока, если ID транзакции уникален.
     *
     * @param transactionID Номер транзакции.
     * @param player Игрок, на баланс которого, зачисляются средства.
     * @param amount Сумма, которая зачисляется на баланс.
     */
    public void credit(String transactionID, Player player, double amount){
        if (amount > 0 & !transactionRepository.findTransactionByID(transactionID)){

            Transaction transaction = new Transaction(transactionID ,player, amount, "Credit");
            transactionRepository.saveTransaction(transaction);
            player.setBalance(player.getBalance() + amount);
        }
        else {
            System.out.println("Ошибка: Номер транзакции уже существует.");
        }
    }

    /**
     * Списывает средства с баланса игрока, если ID транзакции уникален.
     *
     * @param transactionID Номер транзакции.
     * @param player Игрок, на баланс которого списываются средства.
     * @param amount Сумма, которая списывается с баланса.
     */
    public void debit (String transactionID, Player player, double amount){
        if (amount < 0 | amount > player.getBalance()){
            System.out.println("Ошибка: Невозможно снять сумму с баланса.");
        } else if(transactionRepository.findTransactionByID(transactionID)) {
            System.out.println("Ошибка: Номер транзакции уже существует.");
        }else {
            player.setBalance(player.getBalance() - amount);
            Transaction transaction = new Transaction(transactionID ,player, amount, "Debit");
            transactionRepository.saveTransaction(transaction);
        }
    }


}
