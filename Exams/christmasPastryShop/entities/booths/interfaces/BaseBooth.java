package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth{

    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;


    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {

        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.boothNumber = boothNumber;
        this.setCapacity(capacity);
        this.numberOfPeople = 0;
        this.isReserved = false;
        this.pricePerPerson = pricePerPerson;
        this.price = 0;



    }

    public void setCapacity(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }

        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if(numberOfPeople <= 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }


        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReserved = true;
        this.price = numberOfPeople * this.pricePerPerson;
    }

    @Override
    public double getBill() {
       double priceDeli = delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
       double priceCocktail = cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
       double bootPrice = getPrice();

        double sum = priceDeli + priceCocktail + bootPrice;

        return sum;
    }

    @Override
    public void clear() {
       this.isReserved = false;
       this.delicacyOrders.clear();
       this.cocktailOrders.clear();
       this.price = 0;
       this.numberOfPeople = 0;


    }
}
