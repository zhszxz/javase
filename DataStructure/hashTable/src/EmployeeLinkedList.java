public class EmployeeLinkedList {
    private Employee head;

    public void add(Employee emp) {//默认将雇员加在链表最后
        if (head == null) {
            head = emp;
        } else {
            Employee cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = emp;
        }
    }

    public void deleteById(int id) {
        if (head == null) {
            return;
        } else if (head.id == id) {
            head = head.next;
        } else {
            Employee cur = head;
            while (true) {
                if (cur.next == null) {
                    break;
                }
                if (cur.next.id == id) {
                    cur.next = cur.next.next;
                    return;
                }
                cur = cur.next;
            }
        }
    }

    public Employee findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空！");
            return null;
        }
        Employee cur = head;
        while (true) {
            if (cur == null || cur.id == id) {
                break;
            }
            cur = cur.next;
        }
        return cur;
    }

    public void list(int i) {
        if (head == null) {
            System.out.println("第" + (i + 1) + "条链表：");
            return;
        }
        Employee cur = head;
        System.out.print("第" + (i + 1) + "条链表：");
        while (cur != null) {
            System.out.println("=>id=" + cur.id + ",name=" + cur.name);
            cur = cur.next;
        }
    }
}
