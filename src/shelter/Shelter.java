package shelter;

import java.util.ArrayList;
import java.util.Collection;

public class Shelter {

    private int capacity;
    private Collection<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal animal : data) {
            if (animal.getName().equals(name)) {
                data.remove(animal);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {

        return data.stream().filter(animal -> animal.getName().equals(name))
                .filter(animal -> animal.getCaretaker().equals(caretaker))
                .findFirst().orElse(null);
    }

    public Animal getOldestAnimal() {
        Animal oldestAnimal = null;
        int old = 0;
        for (Animal animal : data) {
            if (animal.getAge() > old) {
                old = animal.getAge();
                oldestAnimal = animal;
            }
        }
        return oldestAnimal;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append(System.lineSeparator());

        for (Animal animal : data) {
            sb.append(animal.getName() + " " + animal.getCaretaker()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
