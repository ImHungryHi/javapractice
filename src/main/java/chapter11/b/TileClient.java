package chapter11.b;

public class TileClient {
    public static void main(String[] args) {
        Tile tile = new Tile('Z', 10);
        Tile.printTile(tile);
        System.out.println("Equals:");
        System.out.println("A;3 = " + tile.equals(new Tile('A', 3)));
        System.out.println("Z;10 = " + tile.equals(new Tile('Z', 10)));
        System.out.println("Z;3 = " + tile.equals(new Tile('Z', 3)));
        System.out.println("A;10 = " + tile.equals(new Tile('A', 10)));
        System.out.println("toString = " + tile);
    }
}
