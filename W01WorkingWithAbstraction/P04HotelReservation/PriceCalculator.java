package W01WorkingWithAbstraction.P04HotelReservation;

public class PriceCalculator {

    public static double vacationPrice(double pricePerDay, int days, Season season, DiscountType discountType) {
        double priceAllDays = 0;
        priceAllDays = pricePerDay * days;
        priceAllDays = priceAllDays * season.getMultiplyCoefficient();
        priceAllDays = priceAllDays - priceAllDays * (discountType.getPercent() / 100);
        return priceAllDays;


    }


}
