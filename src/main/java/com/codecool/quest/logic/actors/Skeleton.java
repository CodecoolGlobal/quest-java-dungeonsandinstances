package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

import java.util.Random;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell);
        Random random = new Random();
        int maxCorruptionRate = 10;
        int maxStrength = 5;
        int maxProtection = 12;
        int ceilingDamage = 9;
        this.corruptionRate = (random.nextInt(maxCorruptionRate) + 1)*1000;
        this.strength = random.nextInt(maxStrength) + 1;
        this.protection = random.nextInt(maxProtection) + 1;
        this.maxDamage = random.nextInt(ceilingDamage) + 1;
        this.health = random.nextInt(9) + 1;
    }

    public int getCorruptionRate() {
        return corruptionRate;
    }

    private int corruptionRate;

    @Override
    public void move() {

        Random random = new Random();
        int newDX = random.nextInt(3)-1;
        int newDY = random.nextInt(3)-1;

        Cell nextCell = cell.getNeighbor(newDX, newDY);

        if (nextCell.freeForMovement()) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
