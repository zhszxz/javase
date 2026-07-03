public class test {
    public static void main(String[] args) {
        Queue queue = new Queue(4);
        queue.add(11);
        queue.add(22);
        queue.add(33);
        queue.list();
        System.out.println();
        System.out.println(queue.peek());
        queue.pop();
        queue.pop();
        queue.pop();
        System.out.println(queue.isEmpty());
        queue.add(44);
        queue.list();
    }
}
