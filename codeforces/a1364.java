// A. XXXXX
// time limit per test1 second
// memory limit per test256 megabytes
// Ehab loves number theory, but for some reason he hates the number x
// . Given an array a
// , find the length of its longest subarray such that the sum of its elements isn't divisible by x
// , or determine that such subarray doesn't exist.

// An array a
//  is a subarray of an array b
//  if a
//  can be obtained from b
//  by deletion of several (possibly, zero or all) elements from the beginning and several (possibly, zero or all) elements from the end.
// Input
// The first line contains an integer t
//  (1≤t≤5)
//  — the number of test cases you need to solve. The description of the test cases follows.
// The first line of each test case contains 2 integers n
//  and x
//  (1≤n≤105
// , 1≤x≤104
// ) — the number of elements in the array a
//  and the number that Ehab hates.
// The second line contains n
//  space-separated integers a1
// , a2
// , …
// , an
//  (0≤ai≤104
// ) — the elements of the array a
// .
// Output
// For each testcase, print the length of the longest subarray whose sum isn't divisible by x
// . If there's no such subarray, print −1
// .
// Example
// InputCopy
// 3
// 3 3
// 1 2 3
// 3 4
// 1 2 3
// 2 2
// 0 6
// OutputCopy
// 2
// 3
// -1
// Note
// In the first test case, the subarray [2,3]
//  has sum of elements 5
// , which isn't divisible by 3
// .
// In the second test case, the sum of elements of the whole array is 6
// , which isn't divisible by 4
// .
// In the third test case, all subarrays have an even sum, so the answer is −1
// .
import java.io.*;
import java.util.*;

public class a1364 {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();
            int x = fs.nextInt();

            int sum = 0;
            int first = -1;
            int last = -1;

            for (int i = 0; i < n; i++) {
                int a = fs.nextInt();

                sum += a;

                if (a % x != 0) {
                    if (first == -1) {
                        first = i;
                    }

                    last = i;
                }
            }

            if (sum % x != 0) {
                out.println(n);
            } else if (first == -1) {
                out.println(-1);
            } else {
                int removeFirst = n - first - 1;
                int removeLast = last;

                out.println(Math.max(removeFirst, removeLast));
            }
        }

        out.flush();
    }

    static class FastScanner {

        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();

                if (line == null) {
                    return null;
                }

                st = new StringTokenizer(line);
            }

            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}
