public class Employee {
    int id;
    String name;
    String address;

    Employee next;

    public Employee() {
    }

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return "Employee{id = " + id + ", name = " + name + ", address = " + address + ", next = " + next + "}";
    }
}
