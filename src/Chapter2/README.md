## Chapter 2 | Linked Lists
### Linked List :
Array, being a static structure, can not be easily extended or reduced to fit the data set. New insertions and deletions 
are costly for Arrays too. Linked List is another linear data structure which addresses these issues of Array. Each element
(also called as node) comprises of data and reference to the next node. The last node has reference to `null`. Entry point 
of a linked list is called the head of the node(reference to the first node). For an empty list, the head is null reference.   

<p align="center">
  <img src="/images/LinkedList.png" width="450"/>
</p>

Linked list has some disadvantages over array. To access an element, the entire list from the head needs to be traversed until
the node having the element is reached. It uses extra space(to store the reference of the next node) as well.

Linked list has following types:
1) **Singly Linked List:** Described above
2) **Doubly Linked List:** 
  A double linked list has two references (one to the next and another to the previous node).
  
<p align="center">
  <img src="/images/DLinkedList.png" width="450"/>
</p>

3) **Circular Linked List:** In a cirular linked list (apart from being a singly linked list), last node has a circular
reference to the first node as well.
