package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public class Politician1 extends Politician {
    public Politician1(Cell cell) {
        super(cell);
    }

    @Override
    public void move() {
        switch (positionBeforeMove) {
            case 1:
            case 2:
                this.newDX = 1;
                this.newDY = 0;
                break;
            case 3:
            case 4:
                this.newDX = 0;
                this.newDY = 1;
                break;
            case 5:
            case 6:
                this.newDX = -1;
                this.newDY = 0;
                break;
            case 7:
            case 8:
                this.newDX = 0;
                this.newDY = -1;
                break;
        }
        super.takeSteps();
    }

    @Override
    public String getTileName() { return "politician1"; }
}
