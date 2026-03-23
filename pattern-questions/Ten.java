
import java.util.Scanner;

// Pattern
//    *
//   ***
//  *****
// *******
//  *****
//   ***
//    *
public class Ten {

    public static void main(String[] args) {

        int n = 5;
        // cin >> n;
        int row = 1;

        // Upper Part
        while (row <= n) {
            int space = n - row;
            while (space != 0) {
                System.out.print(" ");
                space--;
            }
            int star = 1;
            while (star <= (2 * row - 1)) {
                System.out.print("*");
                star++;
            }
            System.out.println();
            row++;
        }

        // Lower part
        row = n - 1;
        while (row >= 1) {
            int space = n - row;
            while (space != 0) {
                System.out.print(" ");
                space--;
            }

            int star = 1;
            while (star <= (2 * row - 1)) {
                System.out.print("*");
                star++;
            }
            System.out.println();
            row--;
        }
    }
}
