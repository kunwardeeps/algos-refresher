import java.util.Arrays;

/*
Pseudo code:

quicksort(a):
    q = partition(a,p,r) // q is pivot index in correct place
    quicksort(a,p,q-1)
    quicksort(a,q+1,r)

partition(a,l,r):
    pivot = a[r]
    i=l-1
    for (j = l to r-1):
        if (a[j] > pivot):
            i++
            swap(a[i],a[j])
    swap(a[i+1],pivot)
    return i+1        
*/
public class QuickSort {

    /*
     * a = input array
     * l = left index
     * r = right index
     */
    public static void sort(int[] a, int l, int r) {
        if (l < r) {
            int pvtIdx = partition(a, l, r);
            sort(a, l, pvtIdx - 1);
            sort(a, pvtIdx + 1, r);
        }

    }

    // quick select
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int pivot = partition(nums, lo, hi);
            if(pivot < k) {
                lo = pivot + 1;
            } else if (pivot > k) {
                hi = pivot - 1;
            } else {
                break;
            }
        }
        return nums[k];
     }     

    private static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
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