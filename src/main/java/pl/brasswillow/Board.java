package pl.brasswillow;

public class Board {

    private Item player = Item.empty();
    private Item box = Item.empty();
    private Item storage = Item.empty();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private int width;

    private int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Board putPlayer(int x, int y) {
        this.player = new Item(x,y);
        return this;
    }

    public boolean isPlayerPosition(int x, int y) {
        return player.isOn(x,y);
    }

    public Board putBox(int x, int y) {
        this.box= new Item(x,y);
        return this;
    }

    public boolean isBoxPosition(int x, int y) {

        return box.isOn(x,y);
    }

    public Board putStorage(int x, int y) {
        storage = new Item(x,y);
        return this;
    }

    public boolean isStoragePosition(int x, int y) {
        return storage.isOn(x,y);
    }

    public void tryToMovePlayerRight() {
        if (isPLayerNotNextToWall()) {
            movePlayerRight();
        }
        if (isPlayerOnBoxPosition()) {
            if (isBoxNotNextToWall()) {
                moveBoxRight();
            }
        }
    }

    private void moveBoxRight() {
        box.moveRight();
    }

    private void movePlayerRight() {
        player.moveRight();
    }

    private boolean isBoxNotNextToWall() {
        return ! box.isOn(width-1, box.getY());
    }

    private boolean isPLayerNotNextToWall() {
        return !player.isOn(width-1,player.getY());
    }

    private boolean isPlayerOnBoxPosition() {
        return player.isOn(box.getX(), box.getY());
    }

    public void movePlayerLeft() {
        player = new Item(0,player.getY());
    }
}
