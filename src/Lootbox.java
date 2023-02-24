import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(firstLootBox::offer);
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(secondLootBox::push);

        int totalCount = 0;

        while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()) {
            int tempFirstLoot = firstLootBox.peek();
            int tempSecondLoot = secondLootBox.peek();
            int tempSum = tempFirstLoot + tempSecondLoot;

            if (tempSum % 2 == 0) {
                totalCount += firstLootBox.poll()+secondLootBox.pop();;


            } else {
                firstLootBox.offerLast(secondLootBox.pollFirst());
            }
        }

        if (firstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (totalCount >= 100) {
            System.out.printf("Your loot was epic! Value: %d", totalCount);
        } else {
            System.out.printf("Your loot was poor... Value: %d", totalCount);
        }
    }
}
