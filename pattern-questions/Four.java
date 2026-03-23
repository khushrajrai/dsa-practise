
import java.util.Scanner;

// 1
// 23
// 456
// 78910
public class Four {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();

        int row = 1;
        int count = 1;
        while (row <= n) {
            int col = 1;
            while (col <= row) {
                System.out.print(count);
                count++;
                col++;
            }
            System.out.println();
            row++;
        }

        sc.close();
    }
}
