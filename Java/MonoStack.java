import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class MonoStack {

    public static int[] nle(int[] A) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] nle = new int[A.length];
        Arrays.fill(nle, -1);

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                int x = stack.pop();
                nle[x] = i;
            }
            stack.push(i);
        }

        return nle;
    }

    public static int[] ple(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] ple = new int[A.length];
        Arrays.fill(ple, -1);

        for (int i = 0; i < A.length; i++) {
            while (!stack.empty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            ple[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ple;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(nle(new int[] {1, 5, 6, 4, 0}), new int[] {4, 3, 3, 4, -1}));
        System.out.println(Arrays.equals(ple(new int[] {1, 5, 6, 4, 0}), new int[] {-1, 0, 1, 0, -1}));
    }
}
