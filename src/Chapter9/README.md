## Chapter 9 | Sorting and Searching

* **Selection Sort** :

In Selection Sort, an array is sorted by repeatedly finding the minimum element and moving it in the front of the array. The 
beginning of the same array can be used to store the sorted array. The time complexity of the algorithm is `O(n^2)`.

* **Bubble Sort** :

In Bubble Sort, we start at the beginning of the array and swap the first two elements if they are not in order. This swapping 
is repeated until we reach the end of the array. The whole pass of swapping is repeated until the array is sorted. Space 
complexity for the algorithm is `O(1)`. Worst case time complexity is `O(n*n)` (when the array is sorted in reverse order) and 
the average case time complexity is `O(n^2)`.

* **Merge Sort** :

Merge Sort is a **Divide and Conquer** algorithm. It divides the input array in two halves, sort the two halves separately and 
then merge the two sorted halves. Merge Sort is a recursive algorithm and hence it's time complexity can be expressed as: 
`T(n) = 2T(n/2) + O(n)` which is `O(nlogn)`. Space complexity is `O(n)`.

* **Quick Sort** :

In Quick Sort, we pick a pivot and partition the given array around the picked pivot. Pivot can be picked in many ways. The 
algorithm (when pivot is the element at last index is as follows):
```
 int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
                //swap arr[i] and arr[j]
                ...
            }
        }
 
        // swap arr[i+1] and arr[pivot] (or pivot)
        ...
        
        return i+1;
    }
 
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            // pi is partitioning index, arr[pi] is now at right place 
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
```

The time complexity of quick sort can be expressed as: ` T(n) = T(k) + T(n-k-1) + O(n)`, where k is the number of elements 
which is smaller than pivot. Hence the worst case time complexity is `O(n^2)`, when `k=0` (i.e. picked pivot is always smallest 
or largets element). Best case time occurs when pivot is always the middle element (`k = n/2`), which gives best case time 
complexity as `O(nlogn)`. The average case time complexity is `O(nlogn)` as well.

* **Bucket Sort** :

In Bucket Sort, we partition the array into finite number of buckets and sort each bucket individually. Individual buckets can 
be sorted by any sorting algorithm. The time complexity of bucket sort is `O(n+m)`, where `n` is the number of items in the 
array and `m` is the number of distinct items. Bucket Sort is useful when input is uniformly distributed over a range. 

* **Counting Sort** :

Counting Sort is based on hashing technique. It counts the number of objects having distinct key values and then the position 
of individual object is obtained in the output sequence. The algorithm is as follows:
```
Input Sequence (Range 0-9): 1, 4, 1, 2, 7, 5, 2
Count of each object: 
Index:     0  1  2  3  4  5  6  7  8  9
Count:     0  2  2  0  1  1  0  1  0  0
Cumulative Count:
Index:     0  1  2  3  4  5  6  7  8  9
Count:     0  2  4  4  5  6  6  7  7  7
Output: (2-0) 1s, (4-2) 2s, (4-4) 3s, (5-4) 4s, (6-5) 5s, (6-6) 6s, (7-6) 7s, (7-7) 8s, (7-7) 9s 
      : 1, 1, 2, 2, 4, 5, 7
```

The time complexity of the algorithm is `O(n+k)` where `n` is the number of elements in the input array and `k` is the range of 
the input. Counting sort is efficient when the range is within a limit.


References:

https://www.geeksforgeeks.org/
