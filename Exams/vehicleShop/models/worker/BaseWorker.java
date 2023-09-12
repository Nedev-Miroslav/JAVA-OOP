package vehicleShop.models.worker;

import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseWorker implements Worker{

    private String name;
    private int strength;
    private Collection<Tool> tools;

    public BaseWorker(String name, int strength) {
        this.setName(name);
        this.setStrength(strength);
        this.tools = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.equals("")){
            throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    public void setStrength(int strength) {
        if (strength < 0){
            throw new IllegalArgumentException(ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO);
        }

        this.strength = strength;
    }

    @Override
    public void working() {
        if (this.getStrength() - 10 > 0){
            this.setStrength(this.getStrength() - 10);
        } else {
            this.setStrength(0);
        }

    }

    @Override
    public void addTool(Tool tool) {
        this.getTools().add(tool);

    }

    @Override
    public boolean canWork() {
        return this.getStrength() > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return this.tools;
    }
    @Override
    public String toString() {
        long leftTools = this.tools.stream().filter(tool -> tool.getPower() > 0).count();
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name + ", Strength: " + strength).append(System.lineSeparator());
        sb.append("Tools: " + leftTools + " fit left").append(System.lineSeparator());
        return sb.toString().trim();
    }
}
