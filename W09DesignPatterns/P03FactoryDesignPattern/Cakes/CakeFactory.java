package W09DesignPatterns.P03FactoryDesignPattern.Cakes;

import W09DesignPatterns.P03FactoryDesignPattern.Cake;

public class CakeFactory {

    // Идеята на този pattern е да изнесем логиката за създаването на даден обект в клас който да се грижи само за това

        public static Cake createCake(String cakeType, double price, double diameter, int pieces){
            String type = "Choko";

           Cake cake = null;

            switch (type) {
                case "Choko":
                    cake = new ChocoCake(price, diameter, pieces);
                    break;

                case "Fruit":
                    cake = new FruitCake(price, diameter, pieces);
                    break;
                case "Spanach":
                    cake = new SpanachCake(price, diameter, pieces);
                    break;
            }
            return cake;

        }

}
