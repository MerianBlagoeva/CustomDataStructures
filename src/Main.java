public class Main {
    public static void main(String[] args) {

        //Test main class

        Stack<Integer> stack = new Stack<>();

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

        SmartArray<Integer> smartArray = new SmartArray<>();

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


        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        System.out.println(linkedList.removeFirst());

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));

        linkedList.addFirst(3);

        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());

        System.out.println("--------------");

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        linkedList.forEach(System.out::println);

        int[] array = linkedList.toArray();
        System.out.println(array[0]);

        LinkedListTail linkedListTail = new LinkedListTail();
        linkedListTail.addFirst(1);
        linkedListTail.addFirst(2);
        linkedListTail.addFirst(3);

        linkedListTail.addLast(1);
        linkedListTail.addLast(2);
        linkedListTail.addLast(3);
        linkedListTail.addLast(4);

        System.out.println(linkedListTail.toArray()[0]);
        System.out.println(linkedListTail.get(0));
        linkedListTail.forEach(System.out::println);

        System.out.println(linkedListTail.removeLast());
        System.out.println(linkedListTail.removeLast());
        System.out.println(linkedListTail.removeLast());
        System.out.println(linkedListTail.removeLast());

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addFirst(3);
        doublyLinkedList.addFirst(4);

        doublyLinkedList.addLast(1);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(4);

        System.out.println(doublyLinkedList.removeFirst());
        System.out.println(doublyLinkedList.removeFirst());
        System.out.println(doublyLinkedList.removeFirst());
        System.out.println(doublyLinkedList.removeFirst());

        doublyLinkedList.addLast(1);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(4);

        System.out.println("----------------------");

        System.out.println(doublyLinkedList.removeLast());
        System.out.println(doublyLinkedList.removeLast());
        System.out.println(doublyLinkedList.removeLast());
        System.out.println(doublyLinkedList.removeLast());

        doublyLinkedList.addLast(1);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(4);
        doublyLinkedList.addLast(5);
        doublyLinkedList.addLast(6);

        System.out.println("************");

        System.out.println(doublyLinkedList.get(0));
        System.out.println(doublyLinkedList.get(3));
        System.out.println(doublyLinkedList.get(2));

        System.out.println(doublyLinkedList.toArray()[0]);

    }
}