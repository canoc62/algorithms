import java.util.Scanner;
import java.util.Arrays;

public class IntSort {

  private static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("Enter how many numbers you want to sort: ");
    int numberToSort = s.nextInt();

    int[] numbers = getInputs(numberToSort);

    System.out.println("Unsorted Array: " + Arrays.toString(numbers));
    System.out.println("Sorted: " + Arrays.toString(sortArray(numbers)));
  }

  public static int[] getInputs(int capacity) {
    int[] arr = new int[capacity];

    System.out.println("Enter " + capacity + " integers:");

    for(int i = 0; i < capacity; i++) {
      arr[i] = s.nextInt();
    }

    return arr;
  }

  public static int[] copyArray(int[] array) {
    int[] copy = new int[array.length];

    for (int i = 0; i < array.length; i++) {
      copy[i] = array[i];
    }

    return copy;
  }

  public static int[] sortArray(int[] array) {
    int[] toBeSorted = copyArray(array);

    int temp;
    boolean flag = true;

    while(flag) {
      flag = false;

      for (int i = 0; i < toBeSorted.length - 1; i++) {

        if (toBeSorted[i] > toBeSorted[i + 1]) {
          temp = toBeSorted[i];
          toBeSorted[i] = toBeSorted[i + 1];
          toBeSorted[i + 1] = temp;
          flag = true;
        }
      }
    }

    return toBeSorted;
  }
}