package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.actors.Actor;
import com.codecool.quest.logic.items.*;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

    private int newDX;
    private int newDY;
    private List<Item> inventory = new ArrayList<>();


    public Player(Cell cell) {
        super(cell);


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

    public Item getItemToPickup( Cell cell){
        if (cell.getItem().equals(null)){
            return null;
        }else{
            return cell.getItem();
        }
    }

    public void pickUpItem(Item item){
        inventory.add(item);
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

    public Item getItem(){
        return inventory.get(0);
    }
}
