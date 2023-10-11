package infrastructure;

import domain.model.Player;
import domain.repository.PlayerRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс, отвечающий за хранение и управление игроками в памяти приложения
 * Имплементирует интерфейс репозитория игроков PlayerRepository.
 */
public class PlayerInfrastructure implements PlayerRepository {

    private Map<String, Player> playerData = new HashMap<>();
    /**
     * Этот метод реализует метод интерфейса PlayerRepository
     * Добавляет игрока в репозиторий.
     * @param player Добавляемый игрок.
     */
    @Override
    public void saveUser(Player player) {
        playerData.put(player.getUsername(), player);
    }
    /**
     * Этот метод реализует метод интерфейса PlayerRepository
     * Получает игрока по имени пользователя.
     * @param username имя пользователя игрока.
     * @return Игрок, соответствующий имени пользователя, или null, если игрок не найден.
     */
    @Override
    public Player findByUsername(String username) {
        return playerData.get(username);
    }
}

