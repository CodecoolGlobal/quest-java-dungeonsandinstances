package com.codecool.quest.logic;

import com.codecool.quest.logic.actors.Actor;
import com.codecool.quest.logic.actors.Skeleton;
import com.codecool.quest.logic.items.Item;
import com.sun.scenario.effect.Effect;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;
    private Item item;
    private GameMap gameMap;
    private int x, y;

    Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public Actor getActor() {
        return actor;
    }

    public Item getItem (){ return item; }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    @Override
    public String getTileName() {
        return type.getTileName();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean freeForMovement() {
        return (this.getType().equals(CellType.FLOOR) || this.getType().equals(CellType.BRIDGE) || this.getType().equals(CellType.PARLIAMENT)) && this.getActor() == null;
    }

    public boolean freeForEncounter() {
        return (this.getType().equals(CellType.FLOOR) || this.getType().equals(CellType.BRIDGE) || this.getType().equals(CellType.PARLIAMENT)) && this.getActor() != null;
    }
}
