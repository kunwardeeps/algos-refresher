import java.beans.Transient;
import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int arr[], int x) { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 

            if (arr[m] == x) {
                return m; 
            }
            if (arr[m] < x) {
                l = m + 1; 
            } else {
                r = m - 1; 
            }
        } 
        return -1; 
    } 

    public static int binarySearchCeil(int arr[], int x) { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            if (arr[m] == x) {
                return m; 
            }
            if (arr[m] < x) {
                l = m + 1; 
            } else {
                r = m - 1; 
            }
        } 
        return l > arr.length - 1 ? -1 : l; 
    } 

    public static int binarySearchFloor(int arr[], int x) { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            if (arr[m] == x) {
                return m; 
            }
            if (arr[m] < x) {
                l = m + 1; 
            } else {
                r = m - 1; 
            }
        } 
        return r < 0 ? -1 : r; 
    } 

    public static int binarySearchHigh(int arr[], int x) { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            if (arr[m] <= x) {
                l = m + 1; 
            } else {
                r = m - 1; 
            }
        } 
        return r; 
    } 

    public static int binarySearchLow(int arr[], int x) { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            if (arr[m] < x) {
                l = m + 1; 
            } else {
                r = m - 1; 
            }
        } 
        return l; 
    } 

    /**
     * Recursive
     */
    public int binarySearchRecursive(int arr[], int l, int r, int x) { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 

            if (arr[mid] == x) {
                return mid; 
            }
            if (arr[mid] > x) {
                return binarySearchRecursive(arr, l, mid - 1, x); 
            }
            return binarySearchRecursive(arr, mid + 1, r, x); 
        } 
        return -1; 
    } 

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5, 7};
        System.out.println(Arrays.toString(arr));
        System.out.println("floor 6:" + (binarySearchFloor(arr, 6) == 2));
        System.out.println("floor 0:" + (binarySearchFloor(arr, 0) == -1));
        System.out.println("floor 4:" + (binarySearchFloor(arr, 4) == 1));
        System.out.println("floor 2:" + (binarySearchFloor(arr, 2) == 0));

        System.out.println("ceil 0:" + (binarySearchCeil(arr, 0) == 0));
        System.out.println("ceil 6:" + (binarySearchCeil(arr, 6) == 3));
        System.out.println("ceil 2:" + (binarySearchCeil(arr, 2) == 1));
        System.out.println("ceil 8:" + (binarySearchCeil(arr, 8) == -1));

        System.out.println("Binary 1:" + (binarySearch(arr, 1) == 0));
        System.out.println("Binary 3:" + (binarySearch(arr, 3) == 1));
        System.out.println("Binary 5:" + (binarySearch(arr, 5) == 2));
        System.out.println("Binary 7:" + (binarySearch(arr, 7) == 3));
        System.out.println("Binary 2:" + (binarySearch(arr, 2) == -1));

        int[] arr1 = new int[] {1, 1, 3, 5, 5, 5, 7, 7};
        System.out.println(Arrays.toString(arr1));
        System.out.println("Binary High 5:" + (binarySearchHigh(arr1, 5) == 5));
        System.out.println("Binary High 7:" + (binarySearchHigh(arr1, 7) == 7));
        System.out.println("Binary Low 7:" + (binarySearchLow(arr1, 7) == 6));
        System.out.println("Binary Low 1:" + (binarySearchLow(arr1, 1) == 0));
    }
}