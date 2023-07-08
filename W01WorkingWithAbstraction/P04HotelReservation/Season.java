package W01WorkingWithAbstraction.P04HotelReservation;

public enum Season {
    AUTUMN (1),
    SPRING (2),
    WINTER(3),
    SUMMER(4);

    private int multiplyCoefficient;

    Season(int multiplyCoefficient){
        this.multiplyCoefficient = multiplyCoefficient;
    }

    public int getMultiplyCoefficient() {
        return multiplyCoefficient;
    }

    public void setMultiplyCoefficient(int multiplyCoefficient) {
        this.multiplyCoefficient = multiplyCoefficient;
    }
}
