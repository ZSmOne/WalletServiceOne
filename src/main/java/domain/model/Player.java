package domain.model;

/**
 * Класс, представляющий игрока в приложении.
 */
public class Player {
    //private int playerId;
    private String username;
    private String password;
    private double balance;
    public Player(String username, String password, double balance) {
        //this.playerId = playerId;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

}
