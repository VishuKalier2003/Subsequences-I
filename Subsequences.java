/* Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements... You may return the answer in any order...
 * Eg 1: nums = [4,6,7,7]             Output = [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * Eg 2: nums = [4,4,3,1]             Output = [[4,4]]
  */
import java.util.*;
public class Subsequences
{
    int arr[];    // Defined outside function so can be used by both functions collectively...
    HashSet<List<Integer>> set = new HashSet<List<Integer>>();   // Set to store unique values...
    public List<List<Integer>> findsubsequences(int nums[])
    {
        arr = nums;
        List<Integer> arrayList = new ArrayList<Integer>();
        Recursion(arrayList, 0);    //Calling Recursion...
        List<List<Integer>> list = new ArrayList<List<Integer>>(set);
        return list;
    }
    public void Recursion(List<Integer> arrayList, int index)
    {
        if(arrayList.size() >= 2)
            set.add(new ArrayList<Integer>(arrayList));    // Adding an Empty arraylist...
        for(int i = index; i < arr.length; i++)
        {
            if(arrayList.size() == 0 || arr[i] >= arrayList.get(arrayList.size() - 1))
            {   // If list is empty or the current element is larger than previous element...
                arrayList.add(arr[i]);      // Add the element...
                Recursion(arrayList, i+1);      // Recursive Call for next element...
                arrayList.remove(arrayList.size()-1);
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the size of the array : ");
        x = sc.nextInt();
        int array[] = new int[x];
        for(int i = 0; i < array.length; i++)
        {
            System.out.print("Enter data : ");
            array[i] = sc.nextInt();
        }
        Subsequences subsequences = new Subsequences();       // Object creation...
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        answer = subsequences.findsubsequences(array);    // Function call...
        for(int i = 0; i < answer.size(); i++)
        {
            for(int j = 0; j < answer.get(i).size(); j++)
                System.out.print(answer.get(i).get(j)+", ");
            System.out.println();
        }
        sc.close();
    }
}

// Time Complexity  - O(n^2) time...
// Space Complexity - O(k) space...        k is the number of distinct permutations...

/* DEDUCTIONS :- 
 * 1. Since we want an increasing sequence, the current element must be larger than the previous...
 * 2. Each sequence must be unique thus, we use HashSet to store the unique sequences and reduce time complexity...
 * 3. Every index must be called via Recursion... 
*/