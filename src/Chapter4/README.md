## Chapter 4 | Trees and Graphs
### Tree :
The disadvantage of array and linked list is the time necessary to make a search is O(n) (as both are linear data structures).
A tree (nonlinear data structure) is a collection of nodes connected by directed or undirected edges. A tree can be visualized
as one node (called as root) and zero or more subtrees. The properties of trees are as follows:
1. One node is distinguished as **root**
2. Every other node is connected by a directed edge from exactly one other node (called as parent)
3. Each node can have arbitrary number of children
4. Nodes with no children are called **leaves**, with at least one children are called **internal nodes**, having same parents
are called **siblings**.
5. **Height of a node** is the number of edges from the node to the deepest leaf. **Height of the tree** is the height of the 
root.
5. A tree is a **Binary Tree**, if each node of the tree does not have more than two children.

A general tree can be implemented using **first child/next sibling** method. A general tree node can be defined as:
```
public class TreeNode{
  private Type data;
  private TreeNode leftChild;
  private LinkedList siblings;
  public TreeNode(Type t){
    data = t; leftChild = NULL; siblings = NULL;
  }
}
```

A tree node of a **binary tree** can be defined as:
```
public class BTreeNode{
  private Type data;
  private BTreeNode left, right;
  public BTreeNode(Type t){
    data = t; left = right = NULL;
  }
}
```

A **full binary tree** is a binary tree where each node has exactly zero or two children. A **complete binary tree** is a binary
tree which is completely filled with an exception of the bottom-most level (which is filled from left to right). A **binary 
search tree (BST)** is a binary tree in which the elements of left subtree, a node and it's right subtree form an ordered
sequence. In other words, the traversal order of **(left subtree, root, right subtree)**, also called as **inorder traversal**
gives an ordered sequence. A **balanced BST** provides a logarithmic time access of each element. A balanced BST with `n` nodes 
has a maximum of `log(n)` levels and hence it takes at most `log(n)` comparisons to find a particular node. A BST which is not 
balanced can have a worst case height of order `O(n)` and behaves almost like a linked list. For the efficient implementation
of BST, it should be kept as balanced as possible.

Algorithms for insertion, search and deletion in a BST are as follows:

1. **Insert a node:**
```
BTreeNode insert(BTreeNode root, Type t){
  if(root == null)
    return new BTreeNode(t)
  if(t < root.data)
    root.left = insert(root.left, t)
  else if(t > root.data)
    root.right = insert(root.right, t)
    
  return root
}
```

2. **Search a node:**
```
boolean search(BTreeNode root, Type t){
  if(root == null)
    return false
  if(root.data == t)
    return true
  if(t < root.data)
    search(root.left, t)
  if(t > root.data)
    search(root.right, t)
}
```

3. **Delete a node:**

**Case 1:** When node is a leaf, simply delete the node

**Case 2:** When node to be deleted has only one child, copy the child to the node and delete the child

**Case 3:** When node to be deleted has two childrens, find the inorder successor of the node, copy it to the node and delete 
the inorder successor (predecessor can be used too)

```
BTreeNode delete(BTreeNode root, Type t){
  if(root == null)
    return root
  if(t < root.data)
    root.left = delete(root.left, t)
  else if(t > root.data)
    root.right = delete(root.right, t)
  else {
    if(root.left == null)
      return root.right
    else if(root.right == null)
      return root.left
    
    //Case 3: Node with two children
    root.data = min(root.right)
    root.right = delete(root.right, root.data)
  }
}
```

A BST can be traversed in following ways:

1. **InOrder Traversal:** Traversal order is **(left subtree, root, right subtree)**. It is always symmetrical and gives the
ordered sequence of nodes.
```
void inorder(BTreeNode root){
  if(root != null){
    inorder(root.left)
    //Traverse root
    inorder(root.right)
  }
}
```

2. **PreOrder Traversal:** Traversal order is **(root, left subtree, right subtree)**. 
```
void preorder(BTreeNode root){
  if(root != null){
    //Traverse root
    inorder(root.left)
    inorder(root.right)
  }
}
```

3. **PostOrder Traversal:** Traversal order is **(left subtree, right subtree, root)**. It is mainly used when a tree needs 
to be deleted from leaf to root.
```
void postorder(BTreeNode root){
  if(root != null){
    inorder(root.left)
    inorder(root.right)
    //Traverse root
  }
}
```

4. **LevelOrder/ Breadth First Traversal:** LevelOrder Traversal visits the tree level wise. The elements are encountered as: 
**(root, level1(left to right), ...)**. This can be implemented using a **Queue**.
```
void levelorder(BTreeNode root){
  Queue q
  q.add(root)
  while(q is not empty){
    BTreeNode temp = q.head()
    if(temp.left != null)
      q.add(temp.left)
    if(temp.right != null)
      q.add(temp.right)
  }
}
```

For the `O(log n)` search algorithms to be performed, BST should be balanced. One way to obtain a balanced BST is to randomize 
the data before insertion. The cost of this operation is `O(n)` with a drawback that the data should be known in advance. On 
the new insertion in an existing tree, the randomization process does not work. Another approach to keep a BST balanced is by 
implementing **AVL Trees**. For the construction of AVL Trees, a new term **balance factor** is defined as:

```
balance factor of a node = |node.left.height - node.right.height|
```

**Each node in an AVL Tree has a balance factor which is less than or equal to 1.** The insertion in AVL Tree works as a simple 
BST insertion followed by balancing of the tree which needs certain rotation steps based on different cases for imbalance.


