package domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс, представляющий операцию, совершаемую игроком в приложении для проведения аудита.
 */
public class Audit {

    private LocalDateTime time;
    private String typeOperation;
    private String username;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");// Формат выводимой даты

    public Audit(String typeOperation, String username) {

        this.typeOperation = typeOperation;
        this.username = username;
        this.time = LocalDateTime.now();

    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public String getUsername() {
        return username;
    }
}
