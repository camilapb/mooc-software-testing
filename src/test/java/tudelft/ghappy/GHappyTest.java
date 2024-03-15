package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class GHappyTest {

    private GHappy gHappy;

    @BeforeEach
    void initialize(){
        this.gHappy = new GHappy();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void nullEmptyAndBlankStrings(String text){
        boolean result = this.gHappy.gHappy(text);
        Assertions.assertFalse(result);
    }

    @Test
    void stringWithUnhappyG(){
        boolean result = this.gHappy.gHappy("xxgxx");
        Assertions.assertFalse(result);
    }

    @Test
    void stringWithHappyG(){
        boolean result = this.gHappy.gHappy("xxggxx");
        Assertions.assertTrue(result);
    }

    @Test
    void stringWithPairsOfHappyGs(){
        boolean result = this.gHappy.gHappy("xxggyyggxx");
        Assertions.assertTrue(result);
    }

    @Test
    void startsWithHappyG(){
        boolean result = this.gHappy.gHappy("ggxxyyzz");
        Assertions.assertTrue(result);
    }

    @Test
    void endsWithHappyG() {
        boolean result = this.gHappy.gHappy("xxyyzzgg");
        Assertions.assertTrue(result);
    }

}
