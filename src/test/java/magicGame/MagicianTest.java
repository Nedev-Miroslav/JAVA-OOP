package magicGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicianTest {

    @Test(expected = NullPointerException.class)
    public void testSetInvalidUserNameToMagician() {

        Magician magician = new Magician("", 100);

    }

    @Test(expected = NullPointerException.class)
    public void testSetNullUserNameToMagician() {

        Magician magician = new Magician(null, 100);

    }

    @Test
    public void testSetValidUserNameToMagician() {

        Magician magician = new Magician("Mag1", 100);

        assertEquals("Mag1", magician.getUsername());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidHealth() {
        Magician magician = new Magician("Mag1", -100);
    }

    @Test
    public void testSetValidHealth() {
        Magician magician = new Magician("Mag1", 100);
        assertEquals(100, magician.getHealth());

    }

    @Test
    public void testGetMagics() {
        Magician magician = new Magician("Mag1", 100);
        Magic magic1 = new Magic("blackMagic", 100);
        Magic magic2 = new Magic("redMagic", 10);
        magician.addMagic(magic1);
        magician.addMagic(magic2);

        assertEquals(magic2, magician.getMagics().get(1));

    }

    @Test(expected = NullPointerException.class)
    public void testAddNullMagics() {
        Magician magician = new Magician("Mag1", 100);
        Magic magic1 = null;
        magician.addMagic(magic1);

    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageWhenHealthIsZeroOrNegative() {
        Magician magician = new Magician("Mag1", 0);

        magician.takeDamage(100);


    }

    @Test
    public void testTakeDamageMoreDamageThenHealthContent() {
        Magician magician = new Magician("Mag1", 10);

        magician.takeDamage(100);
        assertEquals(0, magician.getHealth());

    }


    @Test
    public void testTakeDamage() {
        Magician magician = new Magician("Mag1", 100);

        magician.takeDamage(10);

        assertEquals(90, magician.getHealth());

    }

    @Test
    public void testRemoveMagic() {
        Magician magician = new Magician("Mag1", 100);
        Magic magic1 = new Magic("blackMagic", 100);
        Magic magic2 = new Magic("redMagic", 10);
        magician.addMagic(magic1);
        magician.addMagic(magic2);
        assertEquals(2, magician.getMagics().size());
        magician.removeMagic(magic1);
        assertEquals(1, magician.getMagics().size());

    }


    @Test
    public void testGetMagic() {
        Magician magician = new Magician("Mag1", 100);
        Magic magic1 = new Magic("blackMagic", 100);
        Magic magic2 = new Magic("redMagic", 10);
        magician.addMagic(magic1);
        magician.addMagic(magic2);

        Magic gottenMagic = magician.getMagic("blackMagic");

        assertEquals(magic1, gottenMagic);

    }

    @Test
    public void testGetBullets() {
        Magic magic1 = new Magic("blackMagic", 100);
        assertEquals(100, magic1.getBullets());

    }


    @Test
    public void testGetMagicNull() {
        Magician magician = new Magician("Mag1", 100);
        Magic magic1 = new Magic("blackMagic", 100);
        Magic magic2 = new Magic("redMagic", 10);
        magician.addMagic(magic1);
        magician.addMagic(magic2);

        Magic gottenMagic = magician.getMagic("blackMagic1");

        assertEquals(null, gottenMagic);

    }


}