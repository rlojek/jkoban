package pl.brasswillow.cucumber;

import cucumber.api.DataTable;
import cucumber.api.java8.En;
import pl.brasswillow.Board;
import pl.brasswillow.JKoban;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StepDefinitions implements En {

    private JKoban jKoban;
    private Board board;


    public StepDefinitions() {
        Given("^a game looks like this:$", (DataTable initial) -> {
            List<String> strings = initial.asList(String.class);
            board = new Board(strings.get(1).length() - 2, strings.size() - 2);
            board.putPlayer(1, 0);
            jKoban = new JKoban(board);
        });

        When("^player moves left$", () -> {
            jKoban.movePlayerLeft();
        });

        Then("^a game should look like this:$", (DataTable required) -> {
            String boardString = jKoban.getBoardString();
            List<String> rows = Arrays.asList(boardString.split("\n"));
            List<List<String>> raw = new ArrayList<>();
            for (String row : rows) {
                raw.add(Collections.singletonList(row));
            }
            DataTable output = DataTable.create(raw);
            required.diff(output);
        });

    }

}
