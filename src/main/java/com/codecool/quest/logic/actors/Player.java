package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.actors.Actor;

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

    private final int strength = 7;

    private final int protection = 15;



    public Player(Cell cell) {
        super(cell);
        this.health = 10;

    }

    @Override
    public void move() {
        if (this.newDY == 0 && this.newDX == 0) {
            return;
        }

        Cell nextCell = cell.getNeighbor(this.newDX, this.newDY);
        this.newDX = 0;
        this.newDY = 0;
        if (nextCell.freeForMovement()) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
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

    public void payOrFight() {
    }
}
