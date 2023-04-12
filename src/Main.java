public class Main {
    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(13);
        stack.push(69);
        stack.push(73);
        stack.push(42);
        stack.push(666);

        stack.forEach(System.out::println);

        System.out.println(stack.pop());

        System.out.println(stack.isEmpty());

        System.out.println(stack.peek());

        System.out.println(stack.size());

        SmartArray smartArray = new SmartArray();

        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(3);
        smartArray.add(4);

        System.out.println(smartArray.contains(4));

        System.out.println(smartArray.isEmpty());

        System.out.println(smartArray.get(0));

        System.out.println(smartArray.size());

        smartArray.remove(2);

        smartArray.forEach(System.out::println);

        System.out.println(smartArray.remove(1));

        smartArray.add(1, 13);

        System.out.println("--------------------------------------");


        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);

        node.next = node1;
        node1.next = node2;

        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        System.out.println(linkedList.removeFirst());

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));

        linkedList.addFirst(3);

        linkedList.addLast(4);
        System.out.println(linkedList.removeLast());


    }
}