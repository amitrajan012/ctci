## Chapter 1 | Arrays and Strings
### Hash Tables
Hashing is a technique used to uniquely identify a specific object from a group of similar objects. Every object is assigned 
a key which can be used to retrieve information about it. If the keys are small integers, an array can be used to impelement 
a symbol table, where keys serve as the index of the array (i.e. the value associated with key i is stored in the array 
position i). For larger and more complicated keys, different **hashing techniques** are used to convert keys into array indices.

Hashing is implemented in two steps:
1. Implementation of a **hash function**, which converts the search key into array indices. A collision-resolution algorithm
needs to be implemented to handle the issue of two or more different keys hashing to the same array index.
2. Objects are then stored in a Hash Table (implemented using arrays) from which it can be quickly retrieved using hashed key.

A **hash function** is a function that can be used to map a data set of arbitrary size to that of a fixed size. 
The ideal hash function should be easy to compute, has uniformly distributed keys and less collision frequency. 
