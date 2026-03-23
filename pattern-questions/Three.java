
import java.util.Scanner;

// 4321
// 4321
// 4321
// 4321
public class Three {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();

        int i = 1;
        while (i <= n) {
            int j = n;
            while (j >= 1) {
                System.out.print(j);
                j--;
            }
            System.out.println();
            i++;
        }

        sc.close();
    }
}
