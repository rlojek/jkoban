package pl.brasswillow;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ItemTest {

    @Test
    public void shouldHoldPosition(){
        int x =0;
        int y = 0;
        Item item = new Item(x,y);

        assertThat(item.isOn(x,y)).isTrue();
    }
}


