package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public abstract class Politician extends Actor {
    protected int newDX;
    protected int newDY;
    protected int positionBeforeMove = 1;

    public Politician(Cell cell) {
        super(cell);
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
}
