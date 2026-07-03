public class SingleLinkedList {
    private HeroNode head = new HeroNode();

    public static class HeroNode {
        private int no;
        private String name;
        private String nickName;
        private HeroNode next;

        public HeroNode() {
        }

        public HeroNode(int no, String name, String nickName, HeroNode next) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
            this.next = next;
        }

       /* public HeroNode(HeroNode node) {
            this.next = node;
        }*/

        public HeroNode(int no, String name, String nickName) {
            this(no, name, nickName, null);
        }

        @Override
        public String toString() {
            return "座次：" + this.no + ",姓名：" + this.name + ",称号：" + this.nickName;
        }
    }

    public boolean isNUll() {
        return head.next == null;
    }

    public int size() {
        if (head.next == null) {
            return 0;
        }
        HeroNode node = head.next;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    //尾插
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    //按照no从小到大的顺序插入链表
    public void addByNo(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            }
            temp = temp.next;
        }
        if (temp.no == node.no) {
            System.out.println("座次已存在！");
            return;
        }
        node.next = temp.next;
        temp.next = node;
    }

    //修改节点
    public void update(HeroNode node) {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            if (temp.no == node.no) {
                temp.name = node.name;
                temp.nickName = node.nickName;
                return;
            }
            temp = temp.next;
        }
        System.out.println("该节点不存在！");
    }

    //删除
    public void delete(int no) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == no) {
                if (temp.next.next == null) {
                    temp.next = null;
                    return;
                } else {
                    temp.next = temp.next.next;
                }
            }
            temp = temp.next;
        }
    }

    //获取倒数第index个节点
    public HeroNode getLastNode(int index) {
        if (head.next == null) {
            System.out.println("链表为空！");
            return null;
        }
        if (index <= 0 || index > size()) {
            System.out.println("索引越界！");
            return null;
        }
        //将倒数转化为正数
        index = size() - index + 1;
        HeroNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    //打印链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //反转链表

    //方式一：栈
    /*public void reservse() {
        if (isNUll()) {
            System.out.println("链表为空！");
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode node = head.next;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        node = head;
        while (!stack.empty()) {
            HeroNode resNode = stack.pop();
            if (stack.empty()) {
                resNode.next=null;
            }
            node.next = resNode;
            node = node.next;
        }
    }*/

    //方式二：遍历链表取出每个节点放在新链表头部
    public void reservse() {
        if (isNUll() || size() == 1) {
            return;
        }
        HeroNode cur = head.next;//用来遍历原来链表
        HeroNode next = null;//cur的下一个节点
        HeroNode resHead = new HeroNode();//新链表的head
        while (cur != null) {
            next = cur.next;
            cur.next = resHead.next;//让当前节点的next指向新链表首部
            resHead.next = cur;//让新的头节点指向当前节点
            cur = next;
        }
        head.next = resHead.next;
    }
}
