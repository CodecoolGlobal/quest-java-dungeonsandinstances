package com.codecool.quest.logic;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    PINE("pine");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }


    public boolean canMoveToNExtCell() {

        for (CellType tile : CellType.values()) {
            //System.out.println(tile);
            if (tile.equals(FLOOR)) return true;
            else {return false;}
        }
        return true;
    }
}
