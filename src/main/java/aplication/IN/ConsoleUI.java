package aplication.IN;

import domain.model.Audit;
import domain.model.Player;
import domain.model.Transaction;
import domain.repository.AuditRepository;
import aplication.services.PlayerService;
import aplication.services.TransactionService;

import java.util.Scanner;
/**
 * Класс, представляющий консольный пользовательский интерфейс приложения.
 */
public class ConsoleUI {
    private PlayerService playerService;
    private TransactionService transactionService;
    private AuditRepository auditRepository;
    private Player authenticatedPlayer;
    private Transaction transaction;
    private Scanner scanner;
    /**
     * Конструктор класса PlayerService.
     *
     * @param playerService сервис управления игроками.
     * @param transactionService сервис управления транзакциями
     * @param auditRepository класс репозитория аудита
     *
     */
    public ConsoleUI(PlayerService playerService, TransactionService transactionService, AuditRepository auditRepository) {
        this.playerService = playerService;
        this.transactionService = transactionService;
        this.auditRepository = auditRepository;
        this.scanner = new Scanner(System.in);
    }
    /**
     * Метод запускает консольный интерфейс меню, либо меню игрока и обрабатывает действия игроков.
     */
    public void start() {
        while (true) {
            if (authenticatedPlayer == null) {
                showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем перевод строки

            switch (choice) {
                case 1: registerPlayer();
                    break;
                case 2: login();
                    break;
                case 3: conductAudit();
                    break;
                case 4: exit();
                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите действие из меню.");
            }
            } else {
                showPlayerMenu();
                int choicePlayer = scanner.nextInt();
                scanner.nextLine(); // Считываем перевод строки

                switch (choicePlayer) {
                    case 1: creditPlayer();
                        break;
                    case 2: debitPlayer();
                        break;
                    case 3: viewBalance();
                        break;
                    case 4: exit();
                        break;
                    default:
                        System.out.println("Неверный выбор. Пожалуйста, выберите действие из меню.");
                }

            }
        }
    }
    /**
     * Отображает главное меню в консоли для выбора действий.
     */
    private void showMainMenu() {
        System.out.println("Главное меню:");
        System.out.println("1. Регистрация");
        System.out.println("2. Авторизация");
        System.out.println("3. Аудит");
        System.out.println("4. Выход");
        System.out.print("Выберите действие: ");
    }

    /**
     * Отображает меню игрока в консоли для выбора действий.
     */
    private void showPlayerMenu() {
        System.out.println("Меню игрока:");
        System.out.println("1. Кредитовать");
        System.out.println("2. Дебетовать");
        System.out.println("3. Показать баланс");
        System.out.println("4. Выйти из аккаунта");
        System.out.print("Выберите действие: ");
    }

    /**
     * Регистрирует нового игрока и сохраняет информацию о нем.
     */
    private void registerPlayer() {
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        playerService.register(username, password);
        Audit operation = new Audit ("Регистрация игрока", username);
        auditRepository.saveOperation(operation);

    }

    /**
     * Выполняет процедуру входа для зарегистрированного игрока.
     */
    private void login() {
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        authenticatedPlayer = playerService.login(username, password);
        Audit operation = new Audit ("Авторизация игрока", username);
        auditRepository.saveOperation(operation);
    }

    /**
     * Зачисляет средства на баланс игрока.
     */

    private void creditPlayer() {
        System.out.print("Введите сумму для кредитования: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Считываем перевод строки
        System.out.print("Введите номер транзакции: ");
        String transactionId = scanner.nextLine();
        transactionService.credit(transactionId, authenticatedPlayer, amount);
        Audit operation = new Audit ("Кредит игрока", authenticatedPlayer.getUsername());
        auditRepository.saveOperation(operation);
    }

    /**
     * Списывает средства с баланса игрока.
     */
    private void debitPlayer() {
        System.out.print("Введите сумму для дебетования: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Считываем перевод строки
        System.out.print("Введите номер транзакции: ");
        String transactionId = scanner.nextLine();
        transactionService.debit(transactionId, authenticatedPlayer, amount);
        Audit operation = new Audit ("Дебит игрока", authenticatedPlayer.getUsername());
        auditRepository.saveOperation(operation);
    }

    /**
     * Отображает текущий баланс игрока.
     */
    private void viewBalance() {
        System.out.println("Баланс игрока " + authenticatedPlayer.getUsername() + ": " + authenticatedPlayer.getBalance());
    }
    /**
     * Завершает сеанс игрока или завершает программу.
     */
    private void exit() {
        if (authenticatedPlayer != null) {
            authenticatedPlayer = null;
        } else {
            System.exit(0);
        }
    }
    /**
     * Показывает журнал аудита операций.
     */
    private void conductAudit(){
        auditRepository.showAudit();
    }
}
