// Allocate Minimum Pages
// Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

// Each student receives atleast one book.
// Each student is assigned a contiguous sequence of books.
// No book is assigned to more than one student.
// The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.
// Note: If it is not possible to allocate books to all students, return -1.
class Solution {

    public int findPages(int[] arr, int k) {
        // code here
        if (k > arr.length) {
            return -1;
        }
        int start = 0;
        int end = 0;
        for (int a : arr) {
            start = Math.max(start, a);
            end += a;
        }
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isAllocationPossible(arr, mid, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean isAllocationPossible(int arr[], int maxPages, int students) {
        int studentCount = 1;
        int pages = 0;
        for (int a : arr) {
            pages += a;
            if (pages > maxPages) {
                pages = a;
                studentCount++;
            }
            if (studentCount > students) {
                return false;
            }
        }
        return true;
    }
}
