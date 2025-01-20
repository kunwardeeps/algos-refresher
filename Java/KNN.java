import java.util.Arrays;
import java.util.PriorityQueue;

public class KNN {

    public static void main(String[] args) {
        System.out.println(Arrays.deepEquals(kClosest(new int[][] {{ 1, 3 }, { -2, 2 }}, 1), 
        new int[][] {{-2, 2}}));
        System.out.println(Arrays.deepEquals(kClosest(new int[][] {{ 3, 3 }, { 5, -5 }, { -2, 4}}, 2), 
        new int[][] {{ 3, 3 }, { -2, 4}}));
    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }
}
