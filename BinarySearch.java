package programs;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {11, 23, 32, 52, 76, 81, 111, 135, 140, 170};
        int searchElement = 111;

        int index = binarySearch(arr, searchElement);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found.");
        }
    }

    private static int binarySearch(int[] arr, int searchElement) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == searchElement) {
                return mid;
            } else if (arr[mid] < searchElement) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

