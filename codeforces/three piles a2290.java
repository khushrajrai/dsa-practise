// A. Three Piles
// time limit per test1 second
// memory limit per test256 megabytes

// There are three piles of stones. The first pile contains a
//  stones, the second pile contains b
//  stones, and the third pile contains c
//  stones.

// You must make exactly one move: take one stone from one of the piles and put it on one of the other two piles. You cannot skip this move, and you cannot make more than one move.

// Determine whether you can make this move so that all three piles contain the same number of stones.

// Input
// Each test contains multiple test cases. The first line contains the number of test cases t
//  (1≤t≤1000
// ). The description of the test cases follows.

// The only line of each test case contains three integers a
// , b
// , and c
//  (1≤a≤b≤c≤10
// ) — the numbers of stones in the first, second, and third piles.

// Output
// For each test case, print "YES" if you can make the move so that all three piles contain the same number of stones, and "NO" otherwise.

// You can output the answer in any case (upper or lower). For example, the strings "yEs", "yes", "Yes", and "YES" will be recognized as positive responses.

// Example
// InputCopy
// 6
// 1 2 3
// 2 2 2
// 3 4 5
// 1 1 4
// 8 9 10
// 3 5 7
// OutputCopy
// YES
// NO
// YES
// NO
// YES
// NO
// Note
// In the first test case, you can take a stone from the third pile and put it on the first pile. Then each pile contains 2
//  stones.

// In the second test case, all piles already contain the same number of stones. However, a move is mandatory, and after any move the piles no longer contain the same number of stones.

// In the fourth test case, two moves would be enough to make each pile contain 2
//  stones, but only one move is allowed. After any single move, the piles do not contain the same number of stones.

import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t=sc.nextInt();
      while(t-->0){
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = {a,b,c};
        Arrays.sort(arr);
        if(arr[1]-arr[0]==1 && arr[2]-arr[1]==1){
          System.out.println("YES");
        }else{
          System.out.println("NO");
        }
      }
    }
}