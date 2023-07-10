package W03Inheritance.P04StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("no such element");
        }
        return this.data.remove(this.data.size() - 1);
    }

    public String peek(){
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        if (data.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
