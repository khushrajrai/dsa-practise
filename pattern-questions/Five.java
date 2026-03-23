
import java.util.Scanner;

// 1
// 23
// 345
// 4567
public class Five {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();

        int row = 1;
        while (row <= n) {
            int col = 1;
            while (col <= row) {
                System.out.print(row + col - 1);
                col++;
            }
            System.out.println();
            row++;
        }

        sc.close();
    }
}
