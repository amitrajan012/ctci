## Chapter 5 | Bit Manipulation
Some common problems related to bit manipulation are as follows:

* **Left Shift** :
The operator `<<` is used to left shift the bits. `x << n` left shifts the bits of `x` by `n` positions resulting in `x*2^n`, 
assuming that there is no overflow. While left shifting bits, the missing bits in the right is filled with 0. 

* **Right Shift** :
The operator `>>` (also called as Signed right shift) is used to right shift the bits. The missing bits on the left are filled
with the value of the highest order bit. '>>>' (called as Unsigned right shift) fills the missing left bits with 0. To extract 
`ith` bit of a number `x`, we need to shift `x` right by `i` bits and then and it with 1 (`(x >> i) & 1`).

* **XOR Operation** :
Bitwise XOR can be used to implement bitwise addition of two numbers. The algorithm is as follows:
```
Sum = (A ^ B) ^ C(in)
C(out) = (A & B) | ((A ^ B) & C(in))
```

* **OR Operation** :
OR operation can be used to set a particular bit (`ith`) of a variable `x` by doing `x | (1 << i)`.

* **XOR of numbers from 1 to n** :
While doing XOR of numbers, we get a 0 just before a multiple of 4 (i.e. when n is of the form 4k+3). The entire pattern is: 
when `n = 4k, XOR = n; n = 4k+1, XOR = 1; n = 4k+2, XOR = n+1; n = 4k+3, XOR = 0;`. Hence the algorithm is:
```
findXOR(int n):
  if(n%4 == 0)
    return n
  else if(n%4 == 1)
    return 1
  else if(n%4 == 2)
    return n+1
  else
    return 0
```

* **Check whether a number is a power of 2** :
Power of 2 should be of the form of `1000...`. So for a number `x`, which is a power of 2, `x-1` will be of the form `01111..`. 
`x & (x-1)` will give the result as 0 for such numbers. Hence, `!(x & (x-1))` will give the expected result. We need to handle 
the case of 0 seperately.

* **Swapping two numbers** :
Two numbers can be swapped by: `A = A^B; B = B^A; A = A^B`.

* **Flip the bits of a number** :
The bits of a number can be flipped by subtracting the number from all 1s.

References:

https://www.geeksforgeeks.org/bits-manipulation-important-tactics/
