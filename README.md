# CustomDataStructures

![Screenshot_3](https://user-images.githubusercontent.com/110605865/231555457-7095aecc-5bec-464f-95db-f69dffb14436.png)


In this workshop, i created 5 custom data structures:

## SmartArray:

 The SmartArray is an implementation of the ArrayList data structure in Java. It uses an array to store elements and resizes itself automatically when it reaches its maximum capacity or when the number of elements it holds becomes too low. 

Functionalities:

**add(int element):** Adds an element to the end of the SmartArray. If the SmartArray is full, it grows in size by creating a new array with double the capacity and copying the elements over.

**get(int index):** Returns the element at the specified index in the SmartArray. Throws an IndexOutOfBoundsException if the index is out of bounds.

**size():** Returns the number of elements in the SmartArray.

**remove(int index):** Removes the element at the specified index in the SmartArray and returns the removed element. If the SmartArray is less than 25% full after removal, it shrinks in size by creating a new array with half the capacity and copying the elements over.

**contains(int element):** Returns true if the SmartArray contains the specified element, false otherwise.

**add(int index, int element):** Adds an element to the SmartArray at the specified index, shifting all the subsequent elements to the right. If the SmartArray is full, it grows in size.

**forEach(Consumer<Integer> consumer):** Iterates over the elements in the SmartArray and applies the specified action to each element.

**isEmpty():** Returns true if the SmartArray is empty, false otherwise.

## Stack:

The Stack is an implementation of the LIFO data structure.

It uses a singly linked list, where each element of the Stack is represented by a node. The **Node** class has two fields: element, which holds the value of the node, and previous, which points to the previous node in the Stack.

The Stack class has three fields: top, which is a reference to the top node in the Stack; size, which keeps track of the number of elements in the Stack; and the Node class, which defines the structure of each node in the Stack.

The implementation follows the standard behavior of a stack in Java:

**push(int element)**;  
**pop()**;  
**peek()**;  
**forEach(Consumer<Integer> consumer)**;  
**size()**;  
**isEmpty()**;  
## LinkedList

This is an implementation of a singly linked list data structure.
The linked list consists of nodes, each containing an integer value and a reference to the **next** node in the list.

Functionalities:

**addFirst**: Adds an element to the beginning of the list  
**addLast**: Adds an element to the end of the list  
**removeFirst**: Removes the first element from the list and returns its value  
**removeLast**: Removes the last element from the list and returns its value  
**get**: Returns the element at the specified index in the list  
**size**: Returns the number of elements in the list  
**isEmpty**: Returns true if the list is empty, false otherwise  
**forEach**: Applies the given consumer function to each Node in the list in order.
**toArray**: Returns an array representation of the list, with the values in order
## LinkedList with a tail:

This is a singly linked list with a tail pointer, which can be used to efficiently add or remove elements from both ends of the list. It provides the same functionalities as the LinkedList.
 
The tail field that stores a reference to the last node in the linked list allows for more efficient addition of elements to the end of the list, as well as easier implementation of certain operations such as removeLast().
In LinkedList, adding an element to the end of the list requires iterating through the entire list to find the last node, which is an O(n) operation. In LinkedListTail, adding an element to the end of the list is an O(1) operation.
## DoublyLinkedList
![Screenshot_4](https://user-images.githubusercontent.com/110605865/231569750-ab392b2f-c791-4924-8b13-19d085512953.png)

This is an implementation of a doubly linked list, a linear data structure that consists of a sequence of nodes, where each node contains a reference to the **previous** and **next** nodes in the sequence, allowing for bi-directional traversal. This means that the doubly linked list can traverse the list in both forward and backward directions, while LinkedList and LinkedList with a tail can only traverse the list in a forward direction. The DoublyLinkedList provides the same functionalities as the LinkedList.
