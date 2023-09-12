package garage;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GarageTest {

    @Test
    public void testCreateGarageAndAddCarIn(){
        Garage garage = new Garage();
        Car car = new Car("Opel", 230, 10000.00);
        assertEquals(0, garage.getCount());
        garage.addCar(car);
        assertEquals(1, garage.getCount());
        assertEquals(1, garage.getCars().size());
    }

    @Test
    public void testCreateCar(){
        Car car = new Car("Opel", 230, 10000.00);
        assertEquals("Opel", car.getBrand());
        assertEquals(230, car.getMaxSpeed());
        assertEquals(10000.00, car.getPrice(), 0.00);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNullCar(){
        Garage garage = new Garage();
        Car car = null;
        garage.addCar(car);
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove(){
        Garage garage = new Garage();
        Car car1 = new Car("VW", 200, 9000.00);
        Car car2 = new Car("Opel", 230, 10000.00);
        Car car3 = new Car("BMW", 240, 11000.00);

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(210);

        assertEquals(car2, allCarsWithMaxSpeedAbove.get(0));
        assertEquals(car3, allCarsWithMaxSpeedAbove.get(1));

    }

    @Test
    public void testGetTheMostExpensiveCar() {
        Garage garage = new Garage();
        Car car1 = new Car("VW", 200, 9000.00);
        Car car2 = new Car("Opel", 230, 10000.00);
        Car car3 = new Car("BMW", 240, 11000.00);

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();
        assertEquals(car3, theMostExpensiveCar);
    }

    @Test
    public void testFindAllCarsByBrand() {
        Garage garage = new Garage();
        Car car1 = new Car("Opel", 200, 9000.00);
        Car car2 = new Car("Opel", 230, 10000.00);
        Car car3 = new Car("BMW", 240, 11000.00);

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        List<Car> opel = garage.findAllCarsByBrand("Opel");
        assertEquals(car1, opel.get(0));
        assertEquals(car2, opel.get(1));

    }



}