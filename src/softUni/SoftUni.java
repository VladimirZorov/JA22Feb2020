package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
        Student student1;
        if (data.size() >= capacity) {
            return "The hall is full.";
        }
        for (Student student2 : data) {
            if (student2.equals(student)) {
                return "Student is already in the hall.";
            }
        }
        data.add(student);
        return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
    }

    public String remove(Student student) {
        for (Student student1 : data) {
            if (student1.equals(student)) {
                return String.format("Removed student %s %s.", student1.getFirstName(), student1.getLastName());
                data.remove(student);
            }
        }
        return null;
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : data) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hall size: %d", data.size())).append(System.lineSeparator());
        for (Student student : data) {
            sb.append(student.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
