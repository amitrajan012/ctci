## Chapter 3 | Stacks and Queues
### Stack :
Stacks can be considered as a subcase (limited access data structure) of sequential data structure. It follows **LIFO** (last-in 
first-out) principle for insertion and removal of elements. For a pushdown stack, only two operations are allowed: **push** and 
**pop**. Stack can be considered as a recursive data structure: a stack is either empty or it consists of top element and the
rest which is a stack. Some of the applications of stack are: in reversing word, implementation of "undo" mechanism in text 
editors, language processingn (space for parameters and local variables, syntax checking for matching braces, implementation of 
recursion).

In a standard programming language, stack is an adapter class (built on top of other data structures (Array, Vector, ArrayList,
Linked List etc.)). A stack should provide a constant time (O(1)) implementation of these functionalities : `push(Type e), 
pop(), peek(), isEmpty()`.

<b>Array-based Implementation: </b> In Array based implementation of stack, two variables `capacity` and `top` is maintained, 
where `-1 =< top <= capacity-1`. A `top` value of `-1` means that the stack is empty. When `top` reaches `capacity-1`, stack is
full and it needs to be resized (dynamic stack abstraction) or should throw an exception on insertion.

<b>Linked List-based Implementation: </b> Linked List based implementation provides the most efficient implementation of
dynamic stack. A pictorial representation is as follows:
<p align="center">
  <img src="/images/LinkedListStack.png" width="450"/>
</p>

### Queue :
Queue follows **FIFO** (first-in first-out) principle for insertion and removal of elements. It mainly supports two operations:
**enqueue** and **dequeue**.

In a standard programming language, queue as well is an adapter class. A queue should provide a constant time (O(1)) 
implementation of these functionalities : `enqueue(Type e), dequeue(), getFront(), isEmpty(), clear()`. Basic algorithms for 
queue implementation through array is as follows:

1. **enqeue(Type e) :**
```
enqueue(Type e):
  if queue is full
    return overflow
  
  rear = rear+1;
  queue[rear] = e
  return true
```

2. **dequeue() :**
```
dequeue():
  if queue is empty
    return underflow
    
  Type e = queue[front]
  front = front+1
  return true
```

3. **getFront() :**
```
getFront():
  return queue[front]
```

4. **isEmpty() :**
```
isEmpty():
  if front > rear
    return true
  else
    return false
```

5. **clear() :**
```
clear():
  while(front <= rear)
    queue[front] = null
    front = front+1
```

References & Image Source:
  
  https://www.cs.cmu.edu/~adamchik/15-121/lectures/Stacks%20and%20Queues/Stacks%20and%20Queues.html
