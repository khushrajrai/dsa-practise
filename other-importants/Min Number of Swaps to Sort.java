// Min Number of Swaps to Sort

import java.util.*;

class Main {

    public static int minSwap(int[] arr) {
        int n = arr.length;
        int a[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = arr[i];
            a[i][1] = i;
        }
        //Sort
        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));
        int swaps = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] || a[i][1] == i) {
                continue;
            }
            int cycle = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = a[j][1];
                cycle++;
            }
            swaps += cycle - 1;
        }
        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minSwap(arr));
    }
}
