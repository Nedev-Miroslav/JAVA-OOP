package football;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FootballTeamTest {

    @Test
    public void testCreateTeam() {
        FootballTeam footballTeam = new FootballTeam("LUD", 3);
        assertEquals("LUD", footballTeam.getName());
        assertEquals(3, footballTeam.getVacantPositions());
    }

    @Test(expected = NullPointerException.class)
    public void TestCreateTeamWithNullName() {
        FootballTeam footballTeam = new FootballTeam(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void TestCreateTeamWithEmptyName() {
        FootballTeam footballTeam = new FootballTeam("", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestCreateTeamWithNegativePosition() {
        FootballTeam footballTeam = new FootballTeam("Lud", -3);
    }

    @Test
    public void AddPlayer() {
        FootballTeam footballTeam = new FootballTeam("LUD", 3);
        Footballer footballer1 = new Footballer("Moti");
        assertEquals(0, footballTeam.getCount());
        footballTeam.addFootballer(footballer1);
        assertEquals(1, footballTeam.getCount());
        assertEquals("Moti", footballer1.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddMorePlayerThenPosition() {
        FootballTeam footballTeam = new FootballTeam("LUD", 1);
        Footballer footballer1 = new Footballer("Moti");
        Footballer footballer2 = new Footballer("Kesheru");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
    }

    @Test
    public void testRemovePlayer() {
        FootballTeam footballTeam = new FootballTeam("LUD", 3);
        Footballer footballer1 = new Footballer("Moti");
        footballTeam.addFootballer(footballer1);
        assertEquals(1, footballTeam.getCount());
        footballTeam.removeFootballer("Moti");
        assertEquals(0, footballTeam.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNotExistingPlayer() {
        FootballTeam footballTeam = new FootballTeam("LUD", 3);
        Footballer footballer1 = new Footballer("Moti");
        footballTeam.addFootballer(footballer1);

        footballTeam.removeFootballer("Kesheru");

    }

    @Test
    public void SellPlayer() {
        FootballTeam footballTeam = new FootballTeam("LUD", 3);
        Footballer footballer1 = new Footballer("Moti");
        footballTeam.addFootballer(footballer1);
        footballTeam.footballerForSale("Moti");
        assertFalse(footballer1.isActive());

    }

    @Test(expected = IllegalArgumentException.class)
    public void SellNotExistPlayer() {
        FootballTeam footballTeam = new FootballTeam("LUD", 3);
        Footballer footballer1 = new Footballer("Moti");
        footballTeam.addFootballer(footballer1);
        footballTeam.footballerForSale("Kesheru");

    }
    @Test
    public void testStatistics(){
        FootballTeam footballTeam = new FootballTeam("LUD", 3);
        Footballer footballer1 = new Footballer("Moti");
        Footballer footballer2 = new Footballer("Kesheru");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        assertEquals("The footballer Moti, Kesheru is in the team LUD.", footballTeam.getStatistics());

    }

}