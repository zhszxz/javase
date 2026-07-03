public class HashTable {
    private EmployeeLinkedList[] employeeLinkedListArray;
    private static int size = 16;
    private static final double LOADINGFACTOR = 0.75;

    public HashTable() {
        employeeLinkedListArray = new EmployeeLinkedList[size];
        for (int i = 0; i < employeeLinkedListArray.length; i++) {
            employeeLinkedListArray[i] = new EmployeeLinkedList();
        }
    }

    public void add(Employee emp) {
        int hash = hashCode(emp.id);
        employeeLinkedListArray[hash].add(emp);
    }

    public void deleteEmpById(int id) {
        int hash = hashCode(id);
        employeeLinkedListArray[hash].deleteById(id);
    }

    public void findEmpById(int id) {
        int hash = hashCode(id);
        Employee employee = employeeLinkedListArray[hash].findEmpById(id);
        if (employee == null) {
            System.out.println("没有找到该雇员！");
        } else {
            System.out.println(employee);
        }
    }

    public void list() {
        for (int i = 0; i < employeeLinkedListArray.length; i++) {
            employeeLinkedListArray[i].list(i);
        }
    }

    public int hashCode(int id) {
        return id % size;
    }
}
