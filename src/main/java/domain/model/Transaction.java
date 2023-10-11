package domain.model;
/**
 * Класс, представляющий транзакцию в приложении.
 */

public class Transaction {
    private String transactionId;
    private String type;

    private double amount;


    private Player player;
        public Transaction(String transactionId, Player player, double amount, String type) {
            this.player = player;
            this.type = type;
            this.amount = amount;
            this.transactionId = transactionId;
        }


    public String getTransactionId() {
        return transactionId;
    }
}


