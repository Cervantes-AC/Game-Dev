package pos;

import charsys.RPGCharacter;
import party.Party;

public class Position {
    private int row, col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setPosition(Position position) {
        this.row = position.getRow();
        this.col = position.getCol();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
