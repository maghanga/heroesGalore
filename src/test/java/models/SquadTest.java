package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void returnSquadName_String() {
        Squad testSquad = new Squad(1, "Lightbearers", "Educating");
        assertEquals("Lightbearers", testSquad.getSquadName());
    }

    @Test
    public void returnPurpose_String() {
        Squad testSquad = new Squad(1, "Lightbearers", "Educating");
        assertEquals("Educating", testSquad.getCause());
    }

    @Test
    public void returnId_int(){
        Squad testSquad = new Squad(1, "Lightbearers", "Educating");
        assertEquals(1, testSquad.getMaxSize());
    }

}