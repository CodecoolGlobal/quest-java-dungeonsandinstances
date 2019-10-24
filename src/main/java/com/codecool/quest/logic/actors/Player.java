package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.Encounter;
import com.codecool.quest.logic.GameMap;
import com.codecool.quest.logic.actors.Actor;

import java.util.Random;

public class Player extends Actor {

    private int newDX;
    private int newDY;

    private int wealth = 0;
    public int getWealth() {
        return wealth;
    }

    public void setWealth(int wealth) {
        this.wealth = wealth;
    }




    public Player(Cell cell) {
        super(cell);
        this.health = 10;
        this.corruptionRate = 999999999;
        Random random = new Random();
        int maxCorruptionRate = 10;
        int maxStrength = 5;
        int maxProtection = 12;
        int ceilingDamage = 12;
        this.corruptionRate = (random.nextInt(maxCorruptionRate) + 1)*1000;
        this.strength = random.nextInt(maxStrength) + 1;
        this.protection = random.nextInt(maxProtection) + 1;
        this.maxDamage = ceilingDamage;

    }

    @Override
    public void move() {
        if (this.newDY == 0 && this.newDX == 0) {
            return;
        }

        Cell nextCell = cell.getNeighbor(this.newDX, this.newDY);
        this.newDX = 0;
        this.newDY = 0;

        if (nextCell.freeForEncounter()) {
            System.out.println(nextCell);
            Encounter encounter = new Encounter();
            encounter.encounter(this, cell.getActor());
        }

        if (nextCell.freeForMovement()) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }

    }

    @Override
    public int getCorruptionRate() {
        return corruptionRate;
    }

    public String getTileName() {
        return "player";
    }

    public void setNewDX(int newDX) {
        this.newDX = newDX;
    }

    public void setNewDY(int newDY) {
        this.newDY = newDY;
    }
}
