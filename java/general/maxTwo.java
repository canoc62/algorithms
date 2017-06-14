import java.util.ArrayList;
import java.util.Arrays;

public class MaxTwo {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(4);
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);

        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        numbers2.add(4);
        numbers2.add(4);
        numbers2.add(7);
        numbers2.add(2);
        numbers2.add(5);

        MaxTwoInner getResult1 = new MaxTwoInner(numbers);
        System.out.println("Result 1: " + Arrays.toString(getResult1.getResults()));
        MaxTwoInner getResult2 = new MaxTwoInner(numbers2);
        System.out.println("Result 2: " + Arrays.toString(getResult2.getResults()));
    }

    private static class MaxTwoInner {

        private ArrayList<Integer> numbers;
        private int largest;
        private int secondLargest;

        public MaxTwoInner(ArrayList<Integer> numbers) {
            this.numbers = numbers;
        }

        public int[] getResults() {
            int[] result = new int[2];
            if (this.numbers.size() < 2) {
                return result;
            }

            int firstVal = this.numbers.get(0);
            int secondVal = this.numbers.get(1);

            int largest = firstVal > secondVal ? firstVal : secondVal;
            int secondLargest = firstVal > secondVal ? secondVal : firstVal;

            for (int i = 2; i < this.numbers.size(); i++) {
                if (this.numbers.get(i) > largest) {
                    secondLargest = largest;
                    largest = this.numbers.get(i);
                } else if (this.numbers.get(i) > secondLargest) {
                    secondLargest = this.numbers.get(i);
                }
            }
            
            result[0] = largest;
            result[1] = secondLargest;
            return result;
        }

        // public String toString() {
        //   return "" + this.getResults().toString();
        // }
    }
}
