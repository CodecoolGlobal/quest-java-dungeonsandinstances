package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public class Politician2 extends Actor {
    private int newDX;
    private int newDY;
    private int positionBeforeMove = 1;

    public Politician2(Cell cell) {
        super(cell);
    }

    @Override
    public void move() {
        switch (positionBeforeMove) {
            case 1:
            case 2:
                this.newDX = -1;
                this.newDY = 0;
                break;
            case 3:
            case 4:
                this.newDX = 0;
                this.newDY = 1;
                break;
            case 5:
            case 6:
                this.newDX = 1;
                this.newDY = 0;
                break;
            case 7:
            case 8:
                this.newDX = 0;
                this.newDY = -1;
                break;
        }
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
    public String getTileName() { return "politician2"; }
}
