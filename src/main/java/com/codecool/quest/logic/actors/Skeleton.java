package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

import java.util.Random;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell);
    }

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
