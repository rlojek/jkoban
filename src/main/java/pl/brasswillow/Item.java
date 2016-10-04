package pl.brasswillow;

public class Item {


    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isOn(int x, int y) {
        return this.x == x && this.y == y;
    }

    public void moveRight(){
        this.x+=1;
    }

    public static Item empty() {
        return new Item(-1,-1){
            @Override
            public boolean isOn(int x, int y) {
                return false;
            }
        };
    }
}
