//         1
//       1  1
//     1  2  1
//   1  3  3  1
// 1  4  6  4  1

import java.util.Scanner;

public class PascalTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            //space
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print(" ");
            }
            //Main Pattern
            int num = 1;
            for (int k = 0; k <= i; k++) {
                System.out.print(num + " ");
                num = num * (i - k) / (k + 1);
            }
            System.out.println();
        }
        sc.close();
    }
}
