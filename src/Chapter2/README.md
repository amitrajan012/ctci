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

**Node Class:**
```
private static class Node<Type>
{
   private Type data;
   private Node<Type> next;

   public Node(Type data, Node<Type> next)
   {
      this.data = data;
      this.next = next;
   }
}
```

**Linked List Operations:**

1. **addFirst:** Creates a node and add it to the beginning of the list.
```
public void addFirst(Type item)
{
   head = new Node<Type>(item, head);
}
```
2. **Traverse:** Starting with the head, traverse each node until `null` is encountered.
```
Node temp = head;
while(temp != null) temp = temp.next;
```
3. **addLast:** Append a node at the end of the list.
```
public void addLast(Type item)
{
   if(head == null) addFirst(item);
   else
   {
      Node<Type> temp = head;
      while(temp.next != null) temp = temp.next;

      temp.next = new Node<Type>(item, null);
   }
}
```
4. **insertAfter:** Insert a new node after the node containing the key.
```
public void insertAfter(Type key, Type toInsert)
{
   Node<Type> temp = head;
   while(temp != null && !temp.data.equals(key)) temp = temp.next;

   if(temp != null)
      temp.next = new Node<Type>(toInsert, temp.next);
}
```
5. **insertBefore:** Insert a new node before the node containing the key.
```
public void insertBefore(Type key, Type toInsert)
{
  if(head == null) return null;
  if(head.data.equals(key)){
    addFirst(toInsert);
    return;
  }
   Node<Type> cur = head;
   Node<Type> prev = null;
   while(cur != null && !cur.data.equals(key)) {
    prev = cur;
    cur = cur.next;
  }
  //Insert between cur and prev
   if(temp != null)
      prev.next = new Node<Type>(toInsert, cur);
}
```
6. **remove:** Delete the node containing the key.
```
public void remove(Type key){
  if(head == null) return; //Or error can be raised
  if(head.data.equals(key)) {
    head = head.next;
    return;
  }
  Node<Type> cur = head;
  Node<Type> prev = null;
  while(cur != null && !cur.data.equals(key)) {
    prev = cur;
    cur = cur.next;
  }
  //Delete the node : If key not found, and error can be raised as well
  if(cur != null){
    prev.next = cur.next;
  }
}
```
7. **reverse:** Reverse the given linked list.
```
public void reverse() {
  if(head == null) return;
  Node<Type> cur = head;
  Node<Type> prev = null;
  Node<Type> next = null;
  while(cur != null) {
    next = cur.next; //Save the next pointer
    cur.next = prev; //Reverse the linking
    prev = cur; //Move the pointer
    cur = next; //Move the pointer
  }
  head = prev;
}
```
8. **Cloning:** For the cloning of the list, if the `colne()` method of the `Object class` is used, a shallow copy of the list is made. It will create a copy of the first node and will share the rest. Cloning of a linked list can be implemented by traversing the original list and copying each node by `addFirst()` method. The reverse of the resultant list is the new cloned list.   
