package bakery;

import java.util.ArrayList;
import java.util.Collection;

public class Bakery {

    private String name;
    private int capacity;
    private Collection<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
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
        int maxAge = 0;
        for (Employee employee : employees) {
            if (employee.getAge() > maxAge) {
                maxAge = employee.getAge();
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
        sb.append(String.format("Employees working at Bakery %s:", name)).append(System.lineSeparator());
        for (Employee employee : employees) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

}
