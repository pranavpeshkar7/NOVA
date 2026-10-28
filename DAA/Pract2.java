import java.util.*;

class Job {
    char id;
    int deadline, profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class Pract2 {
    public static void main(String[] args) {
        Job[] jobs = {
            new Job('A', 2, 100), new Job('B', 1, 19), new Job('C', 2, 27),
            new Job('D', 1, 25), new Job('E', 3, 15)
        };

        // sort by profit (high to low)
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxD = 0;
        for (Job j : jobs) maxD = Math.max(maxD, j.deadline);

        char[] slot = new char[maxD + 1];
        Arrays.fill(slot, '-');
        int totalProfit = 0;

        for (Job j : jobs) {
            for (int t = j.deadline; t >= 1; t--) {
                if (slot[t] == '-') {
                    slot[t] = j.id;
                    totalProfit += j.profit;
                    break;
                }
            }
        }

        System.out.print("Job sequence: ");
        for (int i = 1; i <= maxD; i++) System.out.print(slot[i] + " ");
        System.out.println("\nMaximum profit: " + totalProfit);
    }
}
