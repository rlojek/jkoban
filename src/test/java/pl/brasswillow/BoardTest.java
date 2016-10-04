package pl.brasswillow;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    public void shouldMovePlayerRightTwice() throws Exception{
        Board board = new Board(3,1).putPlayer(0,0);
        board.tryToMovePlayerRight();
        board.tryToMovePlayerRight();
        assertThat(board.isPlayerPosition(2,0)).isTrue();
    }

    @Test
    public void shouldMovePlayerLeft() throws Exception{
        Board board = new Board(2, 1).putPlayer(1, 0);
        board.movePlayerLeft();

        assertThat(board.isPlayerPosition(0,0)).isTrue();

    }

    @Test
    public void shouldNotMoveRightOutOfBoard() throws Exception{
        Board board = new Board(2, 1).putPlayer(1, 0);
        board.tryToMovePlayerRight();
        board.tryToMovePlayerRight();
        board.tryToMovePlayerRight();

        assertThat(board.isPlayerPosition(1, 0)).isTrue();
    }

    @Test
    public void shouldPlayerMoveBoxRight() {
        Board board = new Board(3,1).putPlayer(0,0).putBox(1,0);

        board.tryToMovePlayerRight();

        assertThat(board.isBoxPosition(2,0)).isTrue();
    }

    @Test
    public void shouldPlayerNotMoveBoxRightIfNotTouchingIt() {
        Board board = new Board(4,1).putPlayer(0,0).putBox(3,0);

        board.tryToMovePlayerRight();

        assertThat(board.isBoxPosition(3,0)).isTrue();
    }

    @Test
    public void shouldNotMoveBoxRightWithoutFreeSpaceOnRight() {
        Board board = new Board(2,1).putPlayer(0,0).putBox(1,0);

        board.tryToMovePlayerRight();

        assertThat(board.isBoxPosition(1,0)).isTrue();
    }
}