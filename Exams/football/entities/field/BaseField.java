package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
//      Друг начин
//        int sum = 0;
//        for (Supplement supplement : supplements) {
//           sum += supplement.getEnergy();
//        }

        return supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (capacity <= this.getPlayers().size()) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);

        }

        this.getPlayers().add(player);

    }

    @Override
    public void removePlayer(Player player) {
        this.getPlayers().remove(player);

    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.getSupplements().add(supplement);

    }

    @Override
    public void drag() {
//    Друг начин
//        for (Player player : this.players) {
//            player.stimulation();
//        }

        players.forEach(Player::stimulation);

    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();


        sb.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append("Player: ");
        if(getPlayers().isEmpty()){
            sb.append("none");
        } else {
            sb.append(this.getPlayers().stream().map(Player::getName).collect(Collectors.joining(" ")).trim());
        }
        sb.append(System.lineSeparator());

        sb.append(String.format("Supplement: %d", this.getSupplements().size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Energy: %d", sumEnergy()));
        sb.append(System.lineSeparator());

        return sb.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

  }
