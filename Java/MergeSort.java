import java.util.Arrays;

/*
Time: O(nlogn), Space: O(n)
*/
public class MergeSort {

    public static void sort(int[] a, int l, int r) {
        if (l < r) {
            int pvtIdx = (l + r) / 2;
            sort(a, l, pvtIdx);
            sort(a, pvtIdx + 1, r);
            merge(a, l, pvtIdx, r);
        }
    }

    private static void merge(int[] a, int l, int m, int r) {
        int[] a1 = new int[m - l + 1]; //[l..m]
        int[] a2 = new int[r - m]; // [m+1..r]
        for (int i = 0; i < a1.length; i++) {
            a1[i] = a[l + i];
        }
        for (int i = 0; i < a2.length; i++) {
            a2[i] = a[m + 1 + i];
        }
        
        int i = 0, j = 0, k = l;
        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                a[k++] = a1[i++];
            } else {
                a[k++] = a2[j++];
            }
        }

        while (i < a1.length) {
            a[k++] = a1[i++];
        }

        while (j < a2.length) {
            a[k++] = a2[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] { 2, 7, 1, 6 };
        sort(a, 0, a.length - 1);
        System.out.println("Test case 1: {2,7,1,6} " + Arrays.equals(a, new int[] { 1, 2, 6, 7 }));
        a = new int[] { 4, 3, 2, 1 };
        sort(a, 0, a.length - 1);
        System.out.println("Test case 2: {4,3,2,1} " + Arrays.equals(a, new int[] { 1, 2, 3, 4 }));
        a = new int[] { 1, 2, 3, 4 };
        sort(a, 0, a.length - 1);
        System.out.println("Test case 3: {1,2,3,4} " + Arrays.equals(a, new int[] { 1, 2, 3, 4 }));
    }

}