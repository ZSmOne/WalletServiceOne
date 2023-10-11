package Presentation;

import domain.repository.AuditRepository;
import aplication.services.PlayerService;
import aplication.services.TransactionService;
import infrastructure.PlayerInfrastructure;
import infrastructure.TransactionInfrastructure;
import aplication.IN.ConsoleUI;

public class AppMain {
    public static void main(String[] args) {

        PlayerService playerService = new PlayerService(new PlayerInfrastructure());
        TransactionService transactionService = new TransactionService(new TransactionInfrastructure());
        AuditRepository auditRepository = new AuditRepository();
        ConsoleUI consoleUI = new ConsoleUI(playerService, transactionService, auditRepository);

        consoleUI.start();
    }
}