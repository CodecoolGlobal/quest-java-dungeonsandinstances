package com.codecool.quest.logic;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    PINE("pine"),
    BRIDGE("bridge"),
    TARLOS("tarlos"),
    POLITICIAN1("politician1"),
    POLITICIAN2("politician2"),
    PARLIAMENT("parliament"),
    RIVER("river");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }


//    public boolean canMoveToNExtCell() {
//
//        for (CellType tile : CellType.values()) {
//            //System.out.println(tile);
//            return tile.equals(FLOOR);
//        }
//        return true;
//    }

}

