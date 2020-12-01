package lesson3;

import java.util.Scanner;

public class GuessWordApplication {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String guessedWord = words[(int) Math.round(Math.random() * words.length)];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста, отгадайте загаданное слово.");
        String answer;
        boolean oneMoreTime = true;
        do {
            answer = scanner.next();
            if (!guessedWord.equals(answer.toLowerCase())) {
                StringBuilder sb = new StringBuilder();
                int shortest = Math.min(answer.length(), guessedWord.length());
                for (int i = 0; i < shortest; i++) {
                    sb.append(answer.charAt(i) == guessedWord.charAt(i) ? answer.charAt(i) : "#");
                }
                sb.append("#".repeat(15 - shortest));
                System.out.println("Вы ответили не правильно.");
                System.out.println(sb.toString());
            } else {
                oneMoreTime = false;
            }
        } while (oneMoreTime);
        System.out.println("Вы ответили правильно!");
    }
}
