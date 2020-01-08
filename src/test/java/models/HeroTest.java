package models;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

public class HeroTest {
    @Test
    public void returnName_String(){
        Hero testHero = new Hero("Nehru", 22, "thought","speed");
        assertEquals("Nehru", testHero.getName());
    }

    @Test
    public void returnSpecialPower_String() {
        Hero testHero = new Hero("Nehru", 22, "thought", "speed");
        assertEquals("thought", testHero.getPower());
    }

    @Test
    public void returnWeakness_String() {
        Hero testHero = new Hero("Nehru", 22, "thought", "speed");
        assertEquals("speed", testHero.getWeakness());
    }
}