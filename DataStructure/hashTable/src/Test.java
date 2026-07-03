import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.println("add：添加雇员");
            System.out.println("delete：删除雇员");
            System.out.println("find：查找雇员");
            System.out.println("list：显示雇员");
            System.out.println("exit：退出");
            input = scanner.next();
            switch (input) {
                case "add":
                    System.out.println("请输入id：");
                    int id = scanner.nextInt();
                    System.out.println("请输入姓名");
                    String name = scanner.next();
                    System.out.println("请输入地址：");
                    String address = scanner.next();
                    Employee employee = new Employee(id, name, address);
                    hashTable.add(employee);
                    break;
                case "delete":
                    System.out.println("请输入id：");
                    hashTable.deleteEmpById(scanner.nextInt());
                    break;
                case "find":
                    System.out.println("请输入id：");
                    hashTable.findEmpById(scanner.nextInt());
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    continue;
            }
        }
    }
}
