package W03Inheritance.P03RandomArrayList;

import java.util.ArrayList;
import java.util.Random;


public class RandomArrayList extends ArrayList {


    public Object getRandomElement() {
        int randomIndex = new Random().nextInt(super.size());

        return super.remove(randomIndex);

    }


}
