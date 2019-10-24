package com.codecool.quest.logic;

import com.codecool.quest.logic.actors.*;
import java.util.Random;

public class Encounter {

    // Constructor
    public Encounter() {
    }

    // Methods
    private void fight(Player player, Skeleton enemy) {
        int dice = 20;
        Random random = new Random();
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            int attackPlayer = random.nextInt(dice)+1;
            int attackEnemy = random.nextInt(dice)+1;

            if (attackPlayer + player.getStrength() > enemy.getProtection()) {
                int damage = random.nextInt(player.getMaxDamage()) + 1;
                enemy.setHealth(-damage);
            }

            if (attackEnemy + enemy.getStrength() > player.getProtection() ) {
                int damage = random.nextInt(enemy.getMaxDamage());
                player.setHealth(-damage);
            }
        }

        if (player.getHealth() <= 0) {
            // Game over
        }

        else if (player.getHealth() > 0 && enemy.getHealth() <= 0) {
            enemy.getCell().setActor(null);
            // Game continues
        }
    }

    public void encounter(Player player, Skeleton enemy) {

        if (player.getWealth() >= enemy.getCorruptionRate()) {
            player.setWealth(-enemy.getCorruptionRate());
            enemy.getCell().setActor(null);
        }

        else {
            this.fight(player, enemy);
        }
    }

}
