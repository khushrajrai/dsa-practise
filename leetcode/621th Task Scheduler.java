// 621. Task Scheduler

// You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

// Return the minimum number of CPU intervals required to complete all tasks.

 

// Example 1:

// Input: tasks = ["A","A","A","B","B","B"], n = 2

// Output: 8

// Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

// After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

// Example 2:

// Input: tasks = ["A","C","A","B","D","B"], n = 1

// Output: 6

// Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

// With a cooling interval of 1, you can repeat a task after just one other task.

// Example 3:

// Input: tasks = ["A","A","A", "B","B","B"], n = 3

// Output: 10

// Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

// There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.

 

// Constraints:

// 1 <= tasks.length <= 104
// tasks[i] is an uppercase English letter.
// 0 <= n <= 100

class Task implements Comparable<Task>{
    int frequency;
    int executionTime;
    Task(int f,int t){
        frequency=f;
        executionTime=t;
    }
    public int compareTo(Task that){
        return that.frequency-this.frequency; //dcrs.
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> freqMap=new HashMap<>();
        for(char ch:tasks){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        //insertion in maxHeap PQ
        PriorityQueue<Task> pq = new PriorityQueue<>();
        //insert tasks in pq
        for(char ch : freqMap.keySet()){
            int freq=freqMap.get(ch);
            pq.offer(new Task(freq,0));
        }
        Queue<Task> queue = new LinkedList<>();
        int time=0;
        while(!queue.isEmpty() || !pq.isEmpty()){
            time++;
            //check if there is a task in pq & process it
            if(!pq.isEmpty()){
                Task task = pq.poll();
                task.frequency--;
                if(task.frequency>0){
                    task.executionTime=time+n;
                    queue.offer(task);
                } 
            }
            //shift the active process to the PQ
            if(!queue.isEmpty() && queue.peek().executionTime==time){
                pq.offer(queue.poll());
            }
        }
        return time;
    }
}