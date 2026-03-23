
import java.util.Scanner;

// Pattern
// 1 2 3 4 5 5 4 3 2 1
// 1 2 3 4 * * 4 3 2 1
// 1 2 3 * * * * 3 2 1
// 1 2 * * * * * * 2 1
// 1 * * * * * * * * 1
public class Eleven {

    public static void main(String[] args) {

        int n = 5;
        int row = 1;
        while (row <= n) {
            int col = 1;
            while (col <= n - row + 1) {
                System.out.print(col + " ");
                col++;
            }
            int star = 1;
            while (star <= (2 * row - 2)) {
                System.out.print("* ");
                star++;
            }
            int col2 = n - row + 1;
            while (col2 >= 1) {
                System.out.print(col2 + " ");
                col2--;
            }
            System.out.println();
            row++;
        }
    }
}
