package cafe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Cafe {

    private String name;
    private int capacity;
    private Collection<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee oldestEmployee = null;
        int max = 0;
       for (Employee employee : employees) {
           if (employee.getAge() > max) {
               max = employee.getAge();
               oldestEmployee = employee;
           }
       }
        return oldestEmployee;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Employees working at Cafe %s:", name)).append(System.lineSeparator());
        for (Employee employee : employees) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

}
