LRU Program

Run time complexity:
1. get - O(1)
Checking the key in the HashMap which is O(1)
Going to the node directly with the help of the address stored in HashMap and taking the value which is O(1) complexity, hence O(1)
 
2. set - O(1)
Checking If element exists in HashMap: O(1)
If Exists:
Taking address from the HashMap: O(1)
Coding to the node directly and Deleting the element: O(1)
Adding at the front of the LinkedList 0(1)

If element does not exists: O(1)
If the hashMap has reached the maximum limit:
Delete of the element in hashMap: O(1)
Deletion of the element from linked list at the end:O(1) hence I am keeping tail pointer
Adding the new element in HashMap:O(1)
Adding the new element at the head of the Linked list:O(1)

Assumptions:
1. If the input for Get has the string with spaces, it is considered as an error.
2. If the input is other than "Size" or "Get" or "Set" then it is considered as an invalid input and I am exiting the Program
3. Checking the input based on the delimiter " " and checking on the number of elements in the array created using delimiter.

How to Run code in terminal:
1.Open terminal
2.Go to the source folder and execute below commands
   > javac Tester.java 
   > java Tester

