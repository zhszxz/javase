public class DoubleLinkedList {
    private HeroNode head = new HeroNode();

    public static class HeroNode {
        private int no;
        private String name;
        private String nickName;
        private HeroNode pre;
        private HeroNode next;

        public HeroNode() {
        }

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "座次：" + this.no + ",姓名：" + this.name + ",称号：" + this.nickName;
        }
    }

    //尾插
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //按照no从小到大的顺序插入链表
    public void addByNo(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {//遍历到最后一个元素还未找到
                if (temp.no == node.no) {
                    System.out.println("座次已存在！");
                    return;
                }
                temp.next = node;//直接将node尾插
                node.pre = temp;
                return;
            }
            if (node.no < temp.next.no) {//如果找到node.no < temp.next.no,则temp和temp.next之间就是node该插入的位置
                break;
            }
            temp = temp.next;
        }
        if (temp.no == node.no) {
            System.out.println("座次已存在！");
            return;
        }
        //将node插入到temp和temp.next之间
        HeroNode nextNode = temp.next;
        node.next = nextNode;
        nextNode.pre = node;
        temp.next = node;
        node.pre = temp;
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
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            if (temp.no == no) {
                temp.pre.next = temp.next;//让待删除结点前一个节点的next指向待删除结点的下一个节点
                if (temp.next == null) {//若删除的是最后一个节点
                    temp.pre = null;//该节点pre置为null即可
                } else {
                    temp.next.pre = temp.pre;//删除的不是最后一个节点，让待删除结点下个节点的pre指向待删除结点的前一个节点
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("no未找到！");
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

}
