public class MinPlanesToDestination {
    public static int minPlanesToDestination(int[] fuel) {
        int n = fuel.length;
        if (n == 1) return 0;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n; i++) {
            if (i > farthest) {
                return -1;
            }

            farthest = Math.max(farthest, i + fuel[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] fuel1 = {2, 1, 2, 3, 1};
        int[] fuel2 = {1, 6, 3, 4, 5, 0, 0, 0, 6};

        System.out.println(minPlanesToDestination(fuel1)); // Output: 2
        System.out.println(minPlanesToDestination(fuel2)); // Output: 3
    }
}
