package com.codecool.quest.logic.items;

import com.codecool.quest.logic.Cell;

public class Pine extends Item{
    public Pine(Cell cell) { super(cell); }

    @Override
    public String getTileName() {
        return "pine";
    }
}
