package W01ExerciseWorkingWithAbstraction.P06greedyTimes;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrintBag {

        public static void printResult(LinkedHashMap<String, LinkedHashMap<String, Long>> bag) {
        for (Map.Entry<String, LinkedHashMap<String, Long>> x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }


}
