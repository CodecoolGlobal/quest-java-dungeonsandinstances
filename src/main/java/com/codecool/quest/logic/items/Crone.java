package com.codecool.quest.logic.items;

import com.codecool.quest.logic.Cell;

public class Crone extends Item{
    public Crone(Cell cell) { super(cell); }

    @Override
    public String getTileName() {
        return "crone";
    }
}
