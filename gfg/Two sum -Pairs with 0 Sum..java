// Two sum -Pairs with 0 Sum

// Given an integer array arr, return all the unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0.
// Note: The pairs must be returned in sorted order, the solution array should also be sorted, and the answer must not contain any duplicate pairs.
// Examples:
// Input: arr = [-1, 0, 1, 2, -1, -4]
// Output: [[-1, 1]]
// Explanation: arr[0] + arr[2] = (-1)+ 1 = 0.
// arr[2] + arr[4] = 1 + (-1) = 0.
// The distinct pair are [-1,1].
// Input: arr = [6, 1, 8, 0, 4, -9, -1, -10, -6, -5]
// Output: [[-6, 6],[-1, 1]]
// Explanation: The distinct pairs are [-1, 1] and [-6, 6].
// Constraints:
// 3 ≤ arr.size ≤ 105
// -105 ≤ arr[i] ≤ 105
// User function Template for Java
class Solution {

    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashSet<String> seen = new HashSet<>();
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            int secondVal = k - arr[i];
            if (freqMap.getOrDefault(secondVal, 0) > 0) {
                if (arr[i] == secondVal && freqMap.get(arr[i]) < 2) {
                    continue;
                }
                int a = Math.min(arr[i], secondVal);
                int b = Math.max(arr[i], secondVal);

                String key = a + "," + b;
                if (!seen.contains(key)) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(a);
                    pair.add(b);
                    res.add(pair);
                    seen.add(key);
                }

                freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) - 1);
            }
        }
        res.sort((x, y) -> {
            if (!x.get(0).equals(y.get(0))) {
                return x.get(0) - y.get(0);
            }
            return x.get(1) - y.get(1);
        });
        return res;
    }
}

// class Solution {
//     public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
//         // code here
//         HashMap<Integer,Integer> freqMap = new HashMap<>();
//         ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//         HashSet<String> seen = new HashSet<>();
//         int k=0;
//         for(int i=0;i<arr.length;i++){
//             int secondVal=k-arr[i];
//             if(freqMap.getOrDefault(secondVal,0)>0){
//                 if(arr[i]==secondVal && freqMap.get(arr[i])<1){
//                     continue;
//                 }
//                 int a = Math.min(arr[i],secondVal);
//                 int b = Math.max(arr[i],secondVal);
//                 String key = a+","+b;
//                 if(!seen.contains(key)){
//                     ArrayList<Integer> pair = new ArrayList<>();
//                     pair.add(a);
//                     pair.add(b);
//                     res.add(pair);
//                     seen.add(key);
//                 }
//             }
//             freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);
//         }
//         res.sort((x,y)->{
//             if(!x.get(0).equals(y.get(0))){
//                 return x.get(0) - y.get(0);
//             }
//             return x.get(1)-y.get(1);
//         });
//         return res;
//     }
// }
