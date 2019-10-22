package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.Drawable;

import java.util.Random;

public abstract class Actor implements Drawable {
    protected Cell cell;

    public void setHealth(int health) {
        this.health += health;
    }

    protected int health;

    public int getStrength() {
        return strength;
    }

    protected int protection;

    public int getMaxDamage() {
        return maxDamage;
    }

    protected int maxDamage;

    protected int strength;


    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public abstract void move();

    public int getHealth() {
        return health;
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

    public int getProtection() {
        return protection;
    }
}
