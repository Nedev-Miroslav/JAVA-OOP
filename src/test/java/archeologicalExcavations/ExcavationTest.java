package archeologicalExcavations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExcavationTest {


    @Test
    public void testCreateExcavation(){
        Excavation excavation = new Excavation("testName", 10);
        assertEquals("testName", excavation.getName());
        assertEquals(10, excavation.getCapacity());

    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateExcavationWithInvalidCapacity(){
        Excavation excavation = new Excavation("testName", -10);
    }

    @Test (expected = NullPointerException.class)
    public void testCreateExcavationWithNullName(){
        Excavation excavation = new Excavation(null, 10);
    }


    @Test
    public void testAddArch() {
        Excavation excavation = new Excavation("testName", 10);
        Archaeologist archaeologist1 = new Archaeologist("A1", 60.0);
        Archaeologist archaeologist2 = new Archaeologist("A2", 60.0);
        assertEquals(60.0, archaeologist1.getEnergy(), 0.0);
        excavation.addArchaeologist(archaeologist1);
        assertEquals(1, excavation.getCount());


        excavation.addArchaeologist(archaeologist2);
        assertEquals(2, excavation.getCount());


    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddMoreArchThenCapacity() {
        Excavation excavation = new Excavation("testName", 1);
        Archaeologist archaeologist1 = new Archaeologist("A1", 60);
        Archaeologist archaeologist2 = new Archaeologist("A2", 60);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSameArch(){
        Excavation excavation = new Excavation("testName", 3);
        Archaeologist archaeologist1 = new Archaeologist("A1", 60);
        Archaeologist archaeologist2 = new Archaeologist("A1", 60);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
    }


    @Test
    public void testRemoveArch(){
        Excavation excavation = new Excavation("testName", 3);
        Archaeologist archaeologist1 = new Archaeologist("A1", 60);
        Archaeologist archaeologist2 = new Archaeologist("A2", 60);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        assertEquals(2, excavation.getCount());
        excavation.removeArchaeologist("A1");
        assertEquals(1, excavation.getCount());


    }

}

