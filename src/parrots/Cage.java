package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public int count() {
        return data.size();
    }

    public boolean remove(String name) {
       for (Parrot parrot : data) {
           if (parrot.getName().equals(name)) {
               data.remove(parrot);
               return true;
           }
       }
        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = (Parrot) data.stream().filter(parrot1 -> parrot1.getName().equals(name));
        parrot.setAvailable(false);

        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
       return data.stream().filter(parrot -> parrot.getSpecies().equals(species)).collect(Collectors.toList());
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Parrots available at %s:", name)).append(System.lineSeparator());

        for (Parrot parrot : data) {
            sb.append(parrot.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

}
