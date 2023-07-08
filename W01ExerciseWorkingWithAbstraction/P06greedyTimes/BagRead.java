package W01ExerciseWorkingWithAbstraction.P06greedyTimes;

public class BagRead {

    private String name;

    public BagRead(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String checkInputItem(String name) {
        String item = "";

        if (name.length() == 3) {
            item = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            item = "Gem";
        } else if (name.toLowerCase().endsWith("gold")) {
            item = "Gold";
        }
        return item;
    }


}
