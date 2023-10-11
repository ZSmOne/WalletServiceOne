package aplication.services;

import domain.model.Player;
import domain.repository.PlayerRepository;
/**
 * Класс предоставляющий функциональность и бизнес-логику, связанную с управлением игроками.
 */
public class PlayerService {

    private PlayerRepository playerRepository;

    /**
     * Конструктор класса PlayerService.
     *
     * @param playerRepository Репозиторий игроков, с которым взаимодействует сервис.
     */
    public PlayerService (PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }
    /**
     * Регистрирует нового игрока с указанным именем и паролем.
     *
     * @param username Имя нового игрока.
     * @param password Пароль нового игрока.
     * @return Новый игрок, если регистрация успешна, или null, если игрок с таким именем уже существует.
     */
    public Player register(String username, String password){
        Player existingPlayer = playerRepository.findByUsername(username);
        if (existingPlayer != null) {
            System.out.println("Игрок с таким именем уже существует");
            return null;
        }
        Player newPlayer = new Player (username, password,0);
        playerRepository.saveUser(newPlayer);
        return newPlayer;
    }

    /**
     * Выполняет авторизацию игрока с указанным именем и паролем.
     *
     * @param username Имя игрока.
     * @param password Пароль игрока.
     * @return Игрок, если вход успешен, или null, если логин или пароль неверны.
     */
    public Player login(String username, String password) {
        Player player = playerRepository.findByUsername(username);
        if (player != null && player.getPassword().equals(password)) {
            return player;
        }
        System.out.println("Неверный логин или пароль");
        return null;
    }
    /**
     * Возвращает баланс игрока с указанным именем.
     *
     * @param username Имя игрока.
     * @return Баланс игрока.
     */
    public double viewBalance (String username){
        Player player = playerRepository.findByUsername(username);
        return player.getBalance();
    }
}


