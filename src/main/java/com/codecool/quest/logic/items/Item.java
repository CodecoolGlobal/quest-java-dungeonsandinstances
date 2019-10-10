package com.codecool.quest.logic.items;

import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.Drawable;
import com.codecool.quest.logic.Cell;

public abstract class Item implements Drawable {
    private Cell cell;


    public Item (Cell cell){
        this.cell = cell;
        this.cell.setItem(this);
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
