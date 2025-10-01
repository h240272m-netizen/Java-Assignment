package question_2a;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(5);
        numbers.add(20);
        numbers.add(30);
        numbers.add(6);

        // Use Stream to filter numbers divisible by 5
        List<Integer> divisibleByFive = numbers.stream()
                .filter(n -> n % 5 == 0)
                .collect(Collectors.toList());

        // Print the filtered numbers
        System.out.println("Numbers divisible by 5: " + divisibleByFive);
    }
}
