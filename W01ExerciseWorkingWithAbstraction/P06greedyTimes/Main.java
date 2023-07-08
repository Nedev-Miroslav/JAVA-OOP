
package W01ExerciseWorkingWithAbstraction.P06greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long limitBag = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();


        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long count = Long.parseLong(safe[i + 1]);

            BagRead currentItemInTheBag = new BagRead(name);
            String item = currentItemInTheBag.checkInputItem(name);

            if (item.equals("")) {
                continue;
            } else if (limitBag < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count) {
                continue;
            }

            if (checkItem(bag, count, item)) continue;

            if (!bag.containsKey(item)) {
                bag.put((item), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(item).containsKey(name)) {
                bag.get(item).put(name, 0L);
            }

            bag.get(item).put(name, bag.get(item).get(name) + count);

        }


      PrintBag.printResult(bag);
    }

    private static boolean checkItem(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long count, String item) {
        if (Items.valueOf(item).equals(Items.Gem)) {
            if (!bag.containsKey(item)) {
                if (bag.containsKey("Gold")) {
                    if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (bag.get(item).values().stream().mapToLong(e -> e).sum() + count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                return true;
            }
        } else if (Items.valueOf(item).equals(Items.Cash)) {
            if (!bag.containsKey(item)) {
                if (bag.containsKey("Gem")) {
                    if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (bag.get(item).values().stream().mapToLong(e -> e).sum() + count > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                return true;
            }
        }
        return false;
    }


}