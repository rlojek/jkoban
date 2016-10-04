package pl.brasswillow;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JKobanTest {

    private static final String EMPTY_BOARD =
        "" +
            "####\n" +
            "#  #\n" +
            "####";

    private static final String BOARD_WITH_PAYER_0_0 =
        "" +
            "####\n" +
            "#@ #\n" +
            "####";

    private static final String BOARD_WITH_PLAYER_0_0_BOX_1_0 =
        "" +
            "####\n" +
            "#@o#\n" +
            "####";

    private static final  String BOARD_WITH_STORAGE_ONLY =
        "" +
            "###\n" +
            "#.#\n" +
            "###" ;
    private static final String BOARD_WITH_PAYER_1_0 =
        "" +
            "####\n" +
            "# @#\n" +
            "####";

    private static final String BOARD_WITH_PAYER_2_0 =
        "" +
            "#####\n" +
            "#  @#\n" +
            "#####";

    private Board board;
    private JKoban cut;

    @Test
    public void shouldPrintEmptyBoard() throws Exception {
        //given
        board = new Board(2, 1);
        cut = new JKoban(board);
        //when
        String result = cut.getBoardString();
        //then
        assertThat(result).isEqualTo(EMPTY_BOARD);
    }

    @Test
    public void shouldPrintBoardWithPlayerOn_0_0() throws Exception {
        //given
        board = new Board(2, 1);
        board.putPlayer(0, 0);
        cut = new JKoban(board);

        //when
        String result = cut.getBoardString();
        //then
        assertThat(result).isEqualTo(BOARD_WITH_PAYER_0_0);
    }

    @Test
    public void shouldPrintBoardWithPlayerOn_0_0_andBox_1_0() throws Exception {
        //given
        board = new Board(2, 1)
            .putPlayer(0, 0)
            .putBox(1, 0);
        cut = new JKoban(board);
        //when
        String result = cut.getBoardString();
        //then
        assertThat(result).isEqualTo(BOARD_WITH_PLAYER_0_0_BOX_1_0);
    }

    @Test
    public void shouldPrintBoardWithSorageOnly() throws Exception {
        //given
        board = new Board(1, 1)
            .putStorage(0,0);
        cut = new JKoban(board);
        //when
        String result = cut.getBoardString();
        //then
        assertThat(result).isEqualTo(BOARD_WITH_STORAGE_ONLY);
    }



    @Test
    public void shouldMovePlayerRight() throws Exception{
        board = new Board(2,1).putPlayer(0,0);
        cut = new JKoban(board);

        cut.movePlayerRight();
        String result = cut.getBoardString();

        assertThat(result).isEqualTo(BOARD_WITH_PAYER_1_0);
    }

    @Test
    public void shouldMovePlayerRightTwice() throws Exception{
        board = new Board(3,1).putPlayer(0,0);
        cut = new JKoban(board);

        cut.movePlayerRight();
        cut.movePlayerRight();
        String result = cut.getBoardString();

        board.tryToMovePlayerRight();
        board.tryToMovePlayerRight();
        assertThat(board.isPlayerPosition(2,0)).isTrue();

        assertThat(result).isEqualTo(BOARD_WITH_PAYER_2_0);
    }

}
