package domain.repository;


import domain.model.Player;

public interface PlayerRepository{
    void saveUser(Player player);
    Player findByUsername (String username);


    }

