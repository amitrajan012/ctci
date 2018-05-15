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
The ideal hash function should be easy to compute, has uniformly distributed keys and less collision frequency. The most common hashing technique (for positive integers) is **modulo M**(where M is prime) hashing, which distributes the keys over the array of size M evenly. For the real numbers between 0 and 1, the keys can be multiplied by M and rounded off to the nearest integer to get an index between 0 and M-1 (this approach gives the more weight to the MSBs of the keys rendering the LSBs ineffective). This issue can be addressed by using the modular hashing on the binary representation of the keys.

JAVA uses the above-mentioned technique for the implementation of `hashCode()` method for each class. This method digests the data stored in an instance of the class into a single hash value(32-bit signed integer). All the classes inherit a basic hash scheme from the fundamental base class `java.lang.Object`, but many override this to provide a hash function that better handles their specific data. Classes which provide their own implementation must override the object method `public int hashCode()`. The implementation of `hashCode()` for an object must be consistent with `equals`, i.e. `a.equals(b)` is true, `a.hashCode()` must have the same numeric value as `b.hashCode()`. For e.g., in the `String` class, hashCode is computed using the following formula:

`s.charAt(0) * 31^(n-1) + s.charAt(1) * 31^(n-2) + ... + s.charAt(n-1)*1`
A `hashCode()` can be converted to the index of an array by implementing modular hashing with M to produce integers between 0 and M-1. A simple JAVA implementation is as follows:
```
private int hash(Key key) {
   return (key.hashCode() & 0x7fffffff) % M;
}
```
A simple implementation of `hashCode()` for a user defined class is as follows (it is to be noted that the implementation of `.equals()` and `hashCode()` are consistent):

```
public final class PhoneNumber {
    private final int area;   // area @code (3 digits)
    private final int exch;   // exchange  (3 digits)
    private final int ext;    // extension (4 digits)
    
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        PhoneNumber that = (PhoneNumber) other;
        return (this.area == that.area) && (this.exch == that.exch) && (this.ext == that.ext);
    }
    
    @Override
    public int hashCode() {
        return 31 * (area + 31 * exch) + ext;
    }
}
```

There are several techniques that can be used for the collission resolution in hashing. Some of them are as follows:
1) **Seperate Chaining(Open hashing):**
  In seperate chaining, each element of the hash table is a linked list. An element is stored in the specified linked list in the hash table. In the case of collision (two elements having the same hash value), both the elements are stored in the same linked list. For uniformly distributed keys, the average cost of the lookup depends on the average numeber of keys per linked list. The worst case cost is proportional to the total entries in the hash table (when all the entries are inserted into the same linked list).
  
2) **Linear Probing (Open addressing or Closed hashing):**
  In Linear Probing/ Open Addressing, all the elements are stored in the hasht table itself and hence the size of the table must be greater than or equal to the total number of keys. For insertion, Keep probing until an empty slot is found. Once an empty slot is found, insert k. For searching, keep probing until key is found or an empty slot is reached. Deletion is performed by marking the slots of deleted key as "deleted". Insert can insert an item in a deleted slot, but search doesn’t stop at a deleted slot. The basic algorithm for the linear probing is as follows:
  ```
  i=0
  while(slot hash(x)+i % M is full) { //Where M is the size of the hash table
      i++;
  }
  insert in slot hash(x)+i
  ```
  The main drawback of linear probing is clustering. Consecutive elements can form groups, making the insertion of new elements time consuming (as searching the free slots need more work). In **Quadratic Probing**, instead of `ith` slot `i^2`th slot is looked. The algorithm is as follows:
  ```
  i=0
  while(slot hash(x)+i^2 % M is full) { //Where M is the size of the hash table
      i++;
  }
  insert in slot hash(x)+i^2
  ```
  
  References:
  
  https://en.wikipedia.org/wiki/Java_hashCode()
  
  https://algs4.cs.princeton.edu/34hash/
  
  https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/tutorial/
  
  https://www.geeksforgeeks.org/hashing-set-2-separate-chaining/
  
  https://www.geeksforgeeks.org/hashing-set-3-open-addressing/
  
  
