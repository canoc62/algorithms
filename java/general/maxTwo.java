import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  
  public static void main(String[] args) {
    ArrayList<int> numbers = new ArrayList<int>();
    numbers.add(4, 4, 3, 2, 1);
    
    ArrayList<int> numbers2 = new ArrayList<int>();
    numbers.add(4, 4, 7, 2, 5);
    
    MaxTwo getResult1 = new MaxTwo(numbers);
    System.out.println("Result 1: " + getResult1.getResults());
    MaxTwo getResult2 = new MaxTwo(numbers2);
    System.out.println("Result 2: " + getResult2.getResults());
  }
  
  private class MaxTwo {
    
    private ArrayList<int> numbers;
    private largest;
    private secondLargest;
    
    public MaxTwo(ArrayList<int> numbers) {
      this.numbers = numbers;
    }
    
    public int[] getResults(ArrayList<int> numbers) {
      if (numbers.size() < 2) {
        return -1;
      }
      
      int firstVal = numbers.get(0);
      int secondVal = numbers.get(1);
      
      int largest = firstVal > secondVal ? firstVal : secondVal;
      int secondLargest = firstVal > secondVal ? secondVal : firstVal;
      
      for (int i = 2; i < numbers.size(); i++) {
        if (numbers.get(i) > largest) {
          secondLargest = largest;
          largest = numbers.get(i);
        } else if (numbers.get(i) > secondLargest) {
          secondLargest = numbers.get(i);
        }
      }
      
      int[] result = new int[2];
      result = [largest, secondLargest];
      
      return result;
    }
  }
}