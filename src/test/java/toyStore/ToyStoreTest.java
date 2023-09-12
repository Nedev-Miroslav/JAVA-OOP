package toyStore;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class ToyStoreTest {

    @Test
    public void testContainsShelf() {
        ToyStore toyStore = new ToyStore();
        Map<String, Toy> toyShelf;
        toyShelf = new LinkedHashMap<>();
        toyShelf.put("A", null);
        toyShelf.put("B", null);
        toyShelf.put("C", null);
        toyShelf.put("D", null);
        toyShelf.put("E", null);
        toyShelf.put("F", null);
        toyShelf.put("G", null);

        assertEquals(toyShelf, toyStore.getToyShelf());

    }

    @Test (expected = OperationNotSupportedException.class)
        public void testAddToyTwice() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("test1", "testing");
        toyStore.addToy("A", toy);
        toyStore.addToy("B", toy);

    }

    @Test
    public void testCorrectAdd() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("test1", "testing");
        Toy toy2 = new Toy("test1", "testing");
        String result = toyStore.addToy("A", toy);

        assertEquals("test1", toyStore.getToyShelf().get("A").getManufacturer());
        assertEquals("Toy:testing placed successfully!", result);
        long exist = toyStore.getToyShelf().values().stream().filter(Objects::nonNull).count();
        Assert.assertEquals(1, exist);


    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyToNotExistShelf() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("test1", "testing");
        toyStore.addToy("M", toy);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testToAddInAlreadyTakenShelf() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("test1", "testing");
        Toy toy2 = new Toy("test2", "testing");
        toyStore.addToy("A", toy1);
        toyStore.addToy("A", toy2);


    }


    @Test
    public void testRemove() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("test1", "testing");
        Toy toy2 = new Toy("test2", "testing2");
        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy2);

        assertEquals(toy2, toyStore.getToyShelf().get("B"));
        String result =  toyStore.removeToy("B", toy2);
        assertEquals(null, toyStore.getToyShelf().get(null));
        long exist = toyStore.getToyShelf().values().stream().filter(Objects::nonNull).count();
        Assert.assertEquals(1, exist);
        assertEquals("Remove toy:testing2 successfully!", result);



    }
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveNotExistShelf() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("test1", "testing");
        Toy toy2 = new Toy("test2", "testing");

        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy2);

        assertEquals(toy2, toyStore.getToyShelf().get("B"));
        toyStore.removeToy("M", toy2);



    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveNotExistToy() throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("test1", "testing");
        Toy toy2 = new Toy("test2", "testing");
        Toy toy3 = new Toy("test3", "testing");
        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy2);

        assertEquals(toy2, toyStore.getToyShelf().get("B"));
        toyStore.removeToy("A", toy3);



    }
}


