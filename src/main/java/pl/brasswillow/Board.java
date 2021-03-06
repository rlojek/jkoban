package pl.brasswillow;

public class Board {

    private int playerX = -1;
    private int playerY = -1;
    private int boxX = -1;
    private int boxY = -1;
    private int storageX = -1;
    private int storageY = -1;

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
        playerX = x;
        playerY = y;
        return this;
    }

    public boolean isPlayerPosition(int x, int y) {
        return x == playerX && y == playerY;
    }

    public Board putBox(int x, int y) {
        boxX = x;
        boxY = y;
        return this;
    }

    public boolean isBoxPosition(int x, int y) {
        return x == boxX && y == boxY;
    }

    public Board putStorage(int x, int y) {
        storageX = x;
        storageY = y;
        return this;
    }

    public boolean isStoragePosition(int x, int y) {
        return x == storageX && y == storageY;
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
        boxX += 1;
    }

    private void movePlayerRight() {
        playerX += 1;
    }

    private boolean isBoxNotNextToWall() {
        return boxX != width - 1;
    }

    private boolean isPLayerNotNextToWall() {
        return playerX < width - 1;
    }

    private boolean isPlayerOnBoxPosition() {
        return playerX == boxX;
    }

    public void movePlayerLeft() {
        playerX = 0;
    }
}
