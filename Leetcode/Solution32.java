
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution32 {

    private static final int MX = 1000001;
    private static final List<Integer>[] factors = new ArrayList[MX];

    static {

        for (int i = 0; i < MX; i++) {
            factors[i] = new ArrayList<>();
        }

        for (int i = 2; i < MX; i++) {

            if (factors[i].isEmpty()) {

                for (int j = i; j < MX; j += i) {
                    factors[j].add(i);
                }
            }
        }
    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            for (int p : factors[nums[i]]) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q;
        q = new ArrayDeque<>();
        boolean[] seen = new boolean[n];

        q.offer(0);
        seen[0] = true;

        int jumps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                if (i == n - 1) {
                    return jumps;
                }

                if (i > 0 && !seen[i - 1]) {
                    seen[i - 1] = true;
                    q.offer(i - 1);
                }

                if (i + 1 < n && !seen[i + 1]) {
                    seen[i + 1] = true;
                    q.offer(i + 1);
                }

                if (factors[nums[i]].size() == 1) {

                    int p = nums[i];

                    List<Integer> next = map.remove(p);

                    if (next != null) {

                        for (int idx : next) {

                            if (!seen[idx]) {
                                seen[idx] = true;
                                q.offer(idx);
                            }
                        }
                    }
                }
            }

            jumps++;
        }

        return -1;
    }
}

/*   Minimum Jumps to Reach End via Prime Teleportation

You are given an integer array nums of length n.

You start at index 0, and your goal is to reach index n - 1.

From any index i, you may perform one of the following operations:

Adjacent Step: Jump to index i + 1 or i - 1, if the index is within bounds.
Prime Teleportation: If nums[i] is a prime number p, you may instantly jump to any index j != i such that nums[j] % p == 0.
Return the minimum number of jumps required to reach index n - 1.

 

Example 1:

Input: nums = [1,2,4,6]

Output: 2

Explanation:

One optimal sequence of jumps is:

Start at index i = 0. Take an adjacent step to index 1.
At index i = 1, nums[1] = 2 is a prime number. Therefore, we teleport to index i = 3 as nums[3] = 6 is divisible by 2.
Thus, the answer is 2.

Example 2:

Input: nums = [2,3,4,7,9]

Output: 2

Explanation:

One optimal sequence of jumps is:

Start at index i = 0. Take an adjacent step to index i = 1.
At index i = 1, nums[1] = 3 is a prime number. Therefore, we teleport to index i = 4 since nums[4] = 9 is divisible by 3.
Thus, the answer is 2.

Example 3:

Input: nums = [4,6,5,8]

Output: 3

Explanation:

Since no teleportation is possible, we move through 0 → 1 → 2 → 3. Thus, the answer is 3.
 

Constraints:

1 <= n == nums.length <= 105
1 <= nums[i] <= 106 */