package robots;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ServiceTest {

    @Test (expected = NullPointerException.class)
    public void testAddServiceWithNullName(){
        Service service = new Service(null, 3);
    }

    @Test (expected = NullPointerException.class)
    public void testAddServiceWithEmptyName(){
        Service service = new Service("", 3);
    }


    @Test (expected = IllegalArgumentException.class)
    public void testAddServiceWithInvalidCapacity(){
        Service service = new Service("Service1", -1);
    }

    @Test
    public void testCreateService(){
        Service service = new Service("Service1", 6);
        assertEquals("Service1", service.getName());
    }

    @Test
    public void testGetCapacityOfService(){
        Service service = new Service("Service1", 6);
        assertEquals("Service1", service.getName());
        assertEquals(6, service.getCapacity());

    }

    @Test
    public void testAddRobot(){
        Service service = new Service("Service1", 6);
        Robot robot1 = new Robot("Robots1");
        Robot robot2 = new Robot("Robots2");
        assertEquals(0, service.getCount());
        service.add(robot1);
        service.add(robot2);
        assertEquals(2, service.getCount());

    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddRobotWhenThereIsNoEnoughCapacity(){
        Service service = new Service("Service1", 1);
        Robot robot1 = new Robot("Robots1");
        Robot robot2 = new Robot("Robots2");
        assertEquals(0, service.getCount());
        service.add(robot1);
        service.add(robot2);
        assertEquals(2, service.getCount());

    }

    @Test
    public void testRemoving(){
        Service service = new Service("Service1", 6);
        Robot robot1 = new Robot("Robots1");
        Robot robot2 = new Robot("Robots2");
        service.add(robot1);
        service.add(robot2);
        assertEquals(2, service.getCount());
        service.remove("Robots1");
        assertEquals(1, service.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemovingMissingRobot(){
        Service service = new Service("Service1", 6);
        Robot robot1 = new Robot("Robots1");
        Robot robot2 = new Robot("Robots2");
        service.add(robot1);
        service.add(robot2);

        service.remove("Robots6");

    }

    @Test
    public void testRobotForSale() {
        Service service = new Service("Service", 6);
        Robot robot = new Robot("Rob");
        service.add(robot);
        Robot sell = service.forSale("Rob");
        assertFalse(sell.isReadyForSale());

    }

    @Test (expected = IllegalArgumentException.class)
    public void testSellMissingRobot(){
        Service service = new Service("Service", 6);
        Robot robot = new Robot("Rob");
        service.add(robot);
        Robot sell = service.forSale("Rob1");
        assertFalse(sell.isReadyForSale());
    }

    @Test
    public void testStatistic(){
        Service service = new Service("Service1", 6);
        Robot robot1 = new Robot("Robots1");
        Robot robot2 = new Robot("Robots1");
        service.add(robot1);
        service.add(robot2);

        assertEquals("The robot Robots1, Robots1 is in the service Service1!", service.report());

    }




}