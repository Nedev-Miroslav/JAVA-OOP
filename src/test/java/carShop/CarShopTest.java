package carShop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CarShopTest {


    @Test
    public void testCreationOfCarShop() {
        CarShop carShop = new CarShop();
        Car car1 = new Car("Opel", 75, 3000);
        Car car2 = new Car("Opel", 175, 13000);

        carShop.add(car1);
        carShop.add(car2);

        assertEquals(2, carShop.getCount());
        assertEquals(car1, carShop.getCars().get(0));

    }

    @Test (expected = NullPointerException.class)
    public void testCreationOfCarShopNull() {
        CarShop carShop = new CarShop();
        Car car1 =  null;

        carShop.add(car1);

    }


    @Test
    public void testFindingCarsWithMaxHP(){
        CarShop carShop = new CarShop();
        Car car1 = new Car("Opel", 75, 3000);
        Car car2 = new Car("Opel", 175, 13000);

        carShop.add(car1);
        carShop.add(car2);

        assertEquals(1, carShop.findAllCarsWithMaxHorsePower(100).size());

    }

    @Test
    public void testRemovingCar(){
        CarShop carShop = new CarShop();
        Car car1 = new Car("Opel", 75, 3000);
        Car car2 = new Car("Opel", 175, 13000);

        carShop.add(car1);
        carShop.add(car2);

        assertEquals(2, carShop.getCount());
        carShop.remove(car1);
        assertEquals(1, carShop.getCount());


    }

    @Test
    public void testGetMostExpensiveCar(){
        CarShop carShop = new CarShop();
        Car car1 = new Car("Opel", 75, 3000);
        Car car2 = new Car("Opel", 175, 13000);

        carShop.add(car1);
        carShop.add(car2);

        assertEquals(13000, carShop.getTheMostLuxuryCar().getPrice(), 0.00);


    }


    @Test
    public void testFindAllCarByModel(){
        CarShop carShop = new CarShop();
        Car car1 = new Car("Opel", 75, 3000);
        Car car2 = new Car("Opel", 175, 13000);
        Car car3 = new Car("VW", 95, 3100);
        Car car4 = new Car("BMV", 275, 18000);

        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);
        carShop.add(car4);

        List<Car> testList = new ArrayList<>();
        testList.add(car1);
        testList.add(car2);


        List<Car> list = carShop.findAllCarByModel("Opel");

        assertEquals(testList.get(1), list.get(1));


    }



}