package chapter11.b;

import java.security.InvalidParameterException;

public class Tile {
    private char letter;
    private int value;

    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    public static void printTile(Tile tile) {
        System.out.println(tile);
    }

    @Override
    public String toString() {
        return this.letter + " : " + this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tile)) {
            return false;
        }

        Tile tile = (Tile) obj;
        return (this.letter == tile.letter) && (this.value == tile.value);
    }

    public int getValue() {
        return this.value;
    }

    public char getLetter() {
        return this.letter;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}
