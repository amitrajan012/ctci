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

**Case 3:** When node to be deleted has two children, find the inorder successor of the node, copy it to the node and delete 
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


### Graph :

A graph, usually denoted as `G = <V, E>` where `V` is a set of vertices and `E` set of edges (denote link between vertices), is a non-linear data structure. Each edge is a pair `(x, y)` where `x` and `y` belongs to `V`. If the edge pair is ordered, the graph is a **directed graph**, otherwise the graph is called **undirected**. Sometimes edges have a parameter called as **edge cost (or weight)**. A graph is **simple** if there is only one edge between vertices, otherwise the graph is called as a **multigraph**. In a directed graph an edge leaves **origin** and ends in a **destination**. Some common terms and facts associated with a graph is as follows:

* **out-degree of a vertex** : number of edges leaving the vertex 
* **in-degree of a vertex** : number of edges entering the vertex
* **degree of a vertex** : in-degree + out-degree of the vertex
* **sink** : a node whose out-degree is 0
* **path** : sequence of distinct vertices connected by edges
* **path length** : number of distinct edges on the path or sum of the costs along the path (in a weighted graph)
* **cycle** : for a directed graph, the path that begins and ends at the same vertex
* **forest** : a graph without cycles
* **connected graph** : a graph in which there exists a path between any two vertices
* **tree** : a connected graph without cycles or a connected forest
* In a directed graph, the sum of in-degrees (or out-degrees) equals the number of edges (as every edge exactly contributes one unit to all in-degrees/out-degrees)
* In a connected graph with `m` edges, the sum of degrees of all the vertices is `2m`
* In a undirected graph with `n` vertices, there are at most `nC2` edges
* In a directed graph with `n` vertices, there are at most `n(n-1)` edges
* For a graph, `|E| < |V|^2`
* A graph can be classified into **dense** and **sparse** graph based on total number of edges
* For an **undirected graph** G: if G is connected : `|E| >= |V|-1`; if G is a tree: `|E| = |V|-1`; if G is a forest: `|E| <= |V|-1`


There are two standard ways to represent a graph: as a collection of **adjacency list** or as an **adjacency matrix**. The adjacency list representation is used for sparse graphs and the adjacency matrix representation is used for dense graphs. The **adjacency list representation** of a graph (shown in the following figure) consists of an array of linked lists (one for each vertex), where each list contains all vertices adjacent to the chosen vertex. A potential disadvantage of the adjacency-list representation is that there is no quicker way to determine if there is an edge between two given vertices.

<p align="center">
  <img src="/images/AdjacencyList_Graph.png" width="450"/>
</p>

The **adjacency matrix representation** of a directed graph `G = <V, E>` consists of a `|V|*|V|` matrix such that:
```
matrix[i][j] = cost/1, if there is an edge between vertices i and j
matrix[i][j] = 0/infinity, otherwise
```

#### Graph Traversal Algorithms: 

To search a graph, all the vertices should be visited in a systematic order. Any vertex can be chosen as the starting point and all the vertices accessible from it is visited in a systematic order. We need to mark the vertices as visited as well to take care of cycles in the graph. A graph can be disconnected as well. A data structure (called as container) can be implemented where all the unvisited adjacent vertices are stored. The algorithm is as follows:
```
while(container is not empty) {
  remove a vertex from the container
  find all adjacent vertices and mark them as visited and add them to container
}
```

The algorithm runs in `O(|V|+|E|)` time. There are two most common traversal algorithms: **Depth-First Order(DFT)** and **Breadth-First Order(BFT)**. In DFT, a vertex followed by its children are visited. In BFT, a vertex followed by all its siblings are visited first and then their children is visited. DFT can be implemented using a stack as the container, while queue is used to implement BFT.

1. **Depth-First Order (Stack as Container):** 

The Depth-First Order traversal of the following graph is shown below. Stack `S` is used as the container and an array `visited` is used to track the visited vertices.

<p align="center">
  <img src="/images/DFT_Graph.png" width="450"/>
</p>

Start from vertex 1: `S = {1}`, `V = {1}`

Pop 1 from top of the stack and visit it's all adjacent unvisited vertices:  `S = {4, 3, 2}`, `V = {1, 4, 3, 2}`

Pop 4: `S = {8, 7, 3, 2}`, `V = {1, 4, 3, 2, 8, 7}`

Pop 8: `S = {6, 7, 3, 2}`, `V = {1, 4, 3, 2, 8, 7, 6}`

Pop 6: `S = {5, 7, 3, 2}`, `V = {1, 4, 3, 2, 8, 7, 6, 5}`

Pop 5: `S = {7, 3, 2}`, `V = {1, 4, 3, 2, 8, 7, 6, 5}`

Pop 7: No unvisited adjacent vertices of 7, `S = {3, 2}`, `V = {1, 4, 3, 2, 8, 7, 6, 5}`

Pop 3: `S = {2}`, `V = {1, 4, 3, 2, 8, 7, 6, 5}`

Pop 3: No unvisited adjacent vertices of 2, `S = {}`, `V = {1, 4, 3, 2, 8, 7, 6, 5}`

The algorithm is as follows:
```
DFS(Vertex V, boolean visited[]) {
  visited[v] = true
  Iterator i = adjacent[v].iterator()
  while(i.hasNext()) {
    Vertex v1 = i.next()
    if(!visited[v1]){
      DFS(v1, visited[])
    }
  }
}
```

2. **Breadth-First Order (Queue as a container):** In Breadth-First Order traversal of the graph, stack is replaced by a queue (i.e. the vertex is added at the end and removed from the beginning). BFT gives the shortest path between any two vertices of an **unweighted** graph. The steps for the BFT traversal for the above graph and the algorithm is as follows: 

Start from vertex 1: `Q = {1}`, `V = {1}`

Dequeue 1: `Q = {2, 3, 4}`, `V = {1, 2, 3, 4}`

Dequeue 2: `Q = {3, 4, 5, 6}`, `V = {1, 2, 3, 4, 5, 6}`

Dequeue 3: `Q = {4, 5, 6}`, `V = {1, 2, 3, 4, 5, 6}`

Dequeue 4: `Q = {5, 6, 7, 8}`, `V = {1, 2, 3, 4, 5, 6, 7, 8}`

Dequeue 5: `Q = {6, 7, 8}`, `V = {1, 2, 3, 4, 5, 6, 7, 8}`

Dequeue 6: `Q = {7, 8}`, `V = {1, 2, 3, 4, 5, 6, 7, 8}`

Dequeue 7: `Q = {8}`, `V = {1, 2, 3, 4, 5, 6, 7, 8}`

Dequeue 8: `Q = {}`, `V = {1, 2, 3, 4, 5, 6, 7, 8}`

```
BFS(Vertex V) {
  visited[i] = false //for all vertices
  Queue Q
  visited[S] = true //where S is the start vertex
  Q.add(S)
  while(!Q.isEmpty()){
    Vertex v = Q.poll();
    Iterator i = adjacent[v].iterator()
    while(i.hasNext()) {
      Vertex v1 = i.next()
        if(!visited[v1]){
          visited[v1] = true
          Q.add(v1)
        }
    }
  }
}
```

3. **Dijkstra's Algorithm:** For a directed or undirected graph where each edge has a nonnegative weight and one of the node is designated as source, the problem is to find the shortest path between the source and any other vertices in the graph. As BFT gives the shortest path between any two vertices for an unweighted graph, this idea can be extended for the graphs whose edge weights are all **positive integers**. Each edge of wight `W` can be replaced by `W-1` vertices each of weight 1 and then BFT can be applied. This idea can not be applied for non-integer weights. In this case Dijkstra's Algorithm serves the purpose. It is based on greedy approach. Here, all vertices are divided into two sets: **Discovered(D)** and **Undiscovered(U)**. In the beginning, D only contains the source. At each step, a vertex from U is chosen whose weight to the source is the least and is added to D. The distance values (or weights) of it's adjacent vertices are updated as well. The process is repeated until all the vertices are included in D (or all the vertices are visited). The algorithm is as follows:

```
dijkstra(Graph G, Vertex source){
  int[] dist //holds the shortest distance from source to vertex i, initially all the values are set to infinity
  boolean[] D //used to distinguish between discovered and undiscovered vertices, initially all values are set to false
  
  for(all vertices) {
    Vertex u = minDistance(dist, D)
    D[u] = true //Mark picked vertex as discovered
    //Update distance of adjacent vertices of u if and only if it is not yet discovered (not in D) and
    //total distance(weight) of source through u is smaller than current value of distance
    for(all adjacent vertices v of u) {
      if(!D[v]){
        if(dist[v] > dist[u] + weight(u, v)) {
          dist[v] = dist[u] + weight(u, v)
        }
      }
    }
  }
}

minDistance(int[] dist, boolean[] D) {
  int min = MAX_VALUE
  int minIndex = -1
  for(all vertices v) {
    if(!D[v] && dist[v] <= min) {
      min = dist[v]
      minIndex = v
    }
  }
}
```



References & Image Source:
  
http://www.cs.cmu.edu/~clo/www/CMU/DataStructures/Lessons/
