package hotel;

import parrots.Parrot;

import java.util.ArrayList;
import java.util.Collection;

public class Hotel {

    private String name;
    private int capacity;
    private Collection<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : roster) {
            if(person.getName().equals(name)) {
                roster.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        return roster.stream().filter(person -> person.getName().equals(name))
                .filter(person -> person.getHometown().equals(hometown)).findFirst().orElse(null);
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:", name)).append(System.lineSeparator());
       for (Person person : roster) {
           sb.append(person.toString()).append(System.lineSeparator());
       }
        return sb.toString().trim();
    }

}
