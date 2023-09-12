package cats;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HouseTest {



    @Test (expected = IllegalArgumentException.class)
    public void testAddingHouseWithInvalidCapacity(){
        House house = new House("House", -1);
    }

    @Test (expected = NullPointerException.class)
    public void testAddHouseWithNullName(){
        House house = new House(null, 1);

    }

    @Test (expected = NullPointerException.class)
    public void testAddHouseWithEmptyName(){
        House house = new House("", 1);

    }

    @Test
    public void testCreateHouse(){
        House house = new House("House", 3);
        assertEquals("House", house.getName());
    }
    @Test
    public void testCapacity(){
        House house = new House("House", 1);
        assertEquals(1, house.getCapacity());
    }

    @Test
    public void testAddCat(){
        House house = new House("House", 1);
        Cat cat = new Cat("cat1");
        assertEquals(0, house.getCount());
        house.addCat(cat);
        assertEquals(1, house.getCount());
    }


    @Test (expected = IllegalArgumentException.class)
    public void testCatOverSize(){
        Cat cat = new Cat("cat1");
        Cat cat2 = new Cat("cat2");
        House house = new House("House", 1);
        house.addCat(cat);
        house.addCat(cat2);
    }


    @Test
    public void testRemoveCat(){
        House house = new House("House", 3);
        Cat cat = new Cat("cat1");
        Cat cat2 = new Cat("cat2");
        house.addCat(cat);
        house.addCat(cat2);
        assertEquals(2, house.getCount());
        house.removeCat("cat2");
        assertEquals(1, house.getCount());


    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveMissingCat(){
        House house = new House("House", 3);
        Cat cat = new Cat("cat1");
        Cat cat2 = new Cat("cat2");
        house.addCat(cat);
        house.addCat(cat2);
        assertEquals(2, house.getCount());
        house.removeCat("cat3");
        assertEquals(1, house.getCount());

    }

    @Test
    public void testCatForSale(){
        House house = new House("House", 3);
        Cat cat = new Cat("cat1");
        house.addCat(cat);
        Cat catSailing = house.catForSale("cat1");

       assertFalse(catSailing.isHungry());



    }

    @Test (expected = IllegalArgumentException.class)
    public void testMissingCatForSale(){
        House house = new House("House", 3);
        Cat cat = new Cat("cat1");
        Cat cat2 = new Cat("cat2");
        house.addCat(cat);
        house.addCat(cat2);
        house.catForSale("cat3");

    }


    @Test
    public void testStatistics(){
        House house = new House("House", 3);
        Cat cat = new Cat("cat1");
        Cat cat2 = new Cat("cat2");
        house.addCat(cat);
        house.addCat(cat2);

        assertEquals("The cat cat1, cat2 is in the house House!", house.statistics());

    }



}