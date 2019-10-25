package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

import java.util.Random;

public abstract class Politician extends Actor {
    protected int newDX;
    protected int newDY;
    protected int positionBeforeMove = 1;

    public Politician(Cell cell) {

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

    public void takeSteps() {
        Cell nextCell = cell.getNeighbor(this.newDX, this.newDY);
        if (nextCell.freeForMovement()) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;

            if (this.positionBeforeMove == 8) {
                this.positionBeforeMove = 1;
            } else {
                this.positionBeforeMove++;
            }
        }
    }

    @Override
    public abstract String getTileName();

    @Override
    public int getCorruptionRate() {
        return corruptionRate;
    }
}
