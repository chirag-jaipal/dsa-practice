package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BaseballGame {
  // Approach 1: ArrayList
  public static int calPoints(String[] operations) {
    int n = operations.length;
    ArrayList<Integer> record = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      switch (operations[i]) {
        case "+":
          record.add(record.get(record.size() - 1) + record.get(record.size() - 2));
          break;

        case "D":
          record.add(2 * record.getLast());
          break;

        case "C":
          record.removeLast();
          break;

        default:
          record.add(Integer.parseInt(operations[i]));
          break;
      }
      System.out.println(record);
    }

    int sum = 0;
    for (int num : record) {
      sum += num;
    }

    return sum;
  }

  // Approach 2: Stack
  public static int calculatePoints(String[] operations) {
    int n = operations.length;
    Deque<Integer> record = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      switch (operations[i]) {
        case "+":
          int top = record.pop();
          int newRecord = top + record.peek();
          record.push(top);
          record.push(newRecord);
          break;

        case "D":
          record.push(2 * record.peek());
          break;

        case "C":
          record.pop();
          break;

        default:
          record.push(Integer.parseInt(operations[i]));
          break;
      }
    }

    int sum = 0;
    for (int val : record) {
      sum += val;
    }

    return sum;
  }

  public static void main(String[] args) {
    String[] ops = { "5", "-2", "4", "C", "D", "9", "+", "+" };
    System.out.println("RESULT1: " + calPoints(ops));
    System.out.println("RESULT2: " + calculatePoints(ops));
  }
}
