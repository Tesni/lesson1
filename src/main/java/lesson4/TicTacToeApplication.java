package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeApplication {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    /*
        Проверяем в цикле условия для каждого из победных вариантов (вертикали, диагонали, горизонтали) по каждой из клеток.
        Не проверяем клетки, откуда заведомо не построить приносящий победу вариант (1)
     */
    public static boolean checkWin(char symb) {
        boolean result = false;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (x <= map[y].length - DOTS_TO_WIN && y <= map.length - DOTS_TO_WIN) { // 1
                    result = checkDiagonal(symb, y, x);
                    if (result) break;
                }
                if (x <= map[y].length - DOTS_TO_WIN) { // 1
                    result = checkHorizontal(symb, y, x);
                    if (result) break;
                }
                if (y <= map.length - DOTS_TO_WIN && x + 1 - DOTS_TO_WIN >= 0) { // 1
                    result = checkReverseDiagonal(symb, y, x);
                    if (result) break;
                }
                if (y <= map.length - DOTS_TO_WIN) { // 1
                    result = checkVertical(symb, y, x);
                    if (result) break;
                }
            }
            if (result) break;
        }
        return result;
    }

    public static boolean checkHorizontal(char symb, int y, int x) {
        return checkHorizontalLine(symb, y, x, DOTS_TO_WIN);
    }

    public static boolean checkVertical(char symb, int y, int x) {
        return checkVerticalLine(symb, y, x, DOTS_TO_WIN);
    }

    public static boolean checkDiagonal(char symb, int y, int x) {
        return checkDiagonalLine(symb, y, x, DOTS_TO_WIN);
    }

    public static boolean checkReverseDiagonal(char symb, int y, int x) {
        return checkReverseDiagonalLine(symb, y, x, DOTS_TO_WIN);
    }


    /*
        Серия методов проверки "выигрышности" линии определённой длины
        В текущей реализации "выигрышными" считаются только непрерывные линии
     */
    public static boolean checkHorizontalLine(char symb, int y, int x, int lineLength) {
        boolean result = true;
        for (int k = 0; k < lineLength; k++) {
            if (map[y][x + k] != symb) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean checkVerticalLine(char symb, int y, int x, int lineLength) {
        boolean result = true;
        for (int k = 0; k < lineLength; k++) {
            if (map[y + k][x] != symb) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean checkDiagonalLine(char symb, int y, int x, int lineLength) {
        boolean result = true;
        for (int k = 0; k < lineLength; k++) {
            if (map[y + k][x + k] != symb) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean checkReverseDiagonalLine(char symb, int y, int x, int lineLength) {
        boolean result = true;
        for (int k = 0; k < lineLength; k++) {
            if (map[y + k][x - k] != symb) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    /*
        Логика ИИ построена на проверке выигрышности текущего расклада игрока в порядке приоритета (внешний цикл) (1)
        Для каждого успешного "вхождения" в "удачное намерение игрока" проверяется возможность "закрыть" продолжение (2)
        Все значения для данного приоритета добавляются в общий пулл (ввиду отсутствия объектного подхода -
        пишутся в строку с фиксированными разделителями).
        В конце итерации внешнего цикла проверяется, пуста ли строка для данного приоритета.
        Если да - происходит понижение приоритета (уменьшение длины искомых пользовательских линий).
        Если нет - компьютер выбирает случайный из "приоритетных" вариантов и выставляет его.
     */
    public static void aiTurn() {
        StringBuilder sb = new StringBuilder();
        for (int lineLength = DOTS_TO_WIN; lineLength > 0; lineLength--) { // 1
            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map[y].length; x++) {
                    if (x <= map[y].length - lineLength && y <= map.length - lineLength) {
                        if (checkDiagonalLine(DOT_X, y, x, lineLength)) {
                            if (isCellValid(x - 1, y - 1)) { // 2
                                sb.append(x - 1).append(",").append(y - 1).append(";");
                            }
                            if (isCellValid(x + lineLength, y + lineLength)) { // 2
                                sb.append(x + lineLength).append(",").append(y + lineLength).append(";");
                            }
                        }
                    }
                    if (x <= map[y].length - lineLength) {
                        if (checkHorizontalLine(DOT_X, y, x, lineLength)) {
                            if (isCellValid(x - 1, y)) { // 2
                                sb.append(x - 1).append(",").append(y).append(";");
                            }
                            if (isCellValid(x + lineLength, y)) { // 2
                                sb.append(x + lineLength).append(",").append(y).append(";");
                            }
                        }
                    }
                    if (y <= map.length - lineLength && x + 1 - lineLength >= 0) {
                        if (checkReverseDiagonalLine(DOT_X, y, x, lineLength)) {
                            if (isCellValid(x - lineLength, y + lineLength)) { // 2
                                sb.append(x - lineLength).append(",").append(y + lineLength).append(";");
                            }
                            if (isCellValid(x + 1, y - 1)) { // 2
                                sb.append(x + 1).append(",").append(y - 1).append(";");
                            }
                        }
                    }
                    if (y <= map.length - lineLength) {
                        if (checkVerticalLine(DOT_X, y, x, lineLength)) {
                            if (isCellValid(x, y - 1)) { // 2
                                sb.append(x).append(",").append(y - 1).append(";");
                            }
                            if (isCellValid(x, y + lineLength)) { // 2
                                sb.append(x).append(",").append(y + lineLength).append(";");
                            }
                        }
                    }
                }
            }

            System.out.println(lineLength);
            if (!sb.isEmpty()) break;
        }

        String[] variants = sb.substring(0, sb.lastIndexOf(";")).split(";");
        String[] variant = variants[rand.nextInt(variants.length)].split(",");

        System.out.println("Компьютер походил в точку " + (Integer.parseInt(variant[1]) + 1) + " " + (Integer.parseInt(variant[0]) + 1));
        map[Integer.parseInt(variant[1])][Integer.parseInt(variant[0])] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        System.out.println("Установите размер поля (клеток по диагнонали и вертикали):");
        SIZE = sc.nextInt();
        System.out.println("Введите длину ряда для победы:");
        DOTS_TO_WIN = sc.nextInt();

        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
