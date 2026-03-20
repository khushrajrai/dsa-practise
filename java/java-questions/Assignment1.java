// Question

// 1. Take a number as input from user.
// 2. keep dividing the number by 2, till it becomes 0.
// 3. if the number becomes even at any point then skip the iteration.
// 4. if the number of times you have divided becomes 5 or more, then break the loop.
// 5. print the odd numbers.
import java.util.*;

class Assignment1 {

    public static void main(String args[]) {
        int num = 0;
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        //Approach
        int count = 0;
        while (num > 0) {
            num = num / 2;
            count++;
            if (count >= 5) {
                System.out.println("Exits the Loop");
                break;
            }
            if (num % 2 == 0) {
                continue;
            } else {
                System.out.println(num);
            }
        }
    }
}
