package pl.brasswillow;

public class Item {


    private int x;
    private int y;

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isOn(int x, int y) {
        return this.x == x && this.y == y;
    }
}
