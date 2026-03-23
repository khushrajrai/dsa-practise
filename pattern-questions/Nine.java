
import java.util.Scanner;

//     1
//    23
//   345
//  4567
public class Nine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();

        int row = 1;
        while (row <= n) {
            int space = n - row;
            int col = 1;
            while (space != 0) {
                System.out.print("  ");
                space--;
            }
            while (col <= row) {
                System.out.print((row + col - 1) + " ");
                col++;
            }
            System.out.println();
            row++;
        }

        sc.close();
    }
}
