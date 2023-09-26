import java.util.*;

public class AutoGeneratedArray {

    static Scanner console = new Scanner(System.in);
    static Random random = new Random();
    static int maxArrayLength = 100;
    static int maxNumber = 1000;

    public static void main(String[] args) {

        int n = inputNumberOfArrays();
        Integer[][] array = new Integer[n][];
        ArrayList<Integer> listOfLengths = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int randomLength = generateRandomNumber(maxArrayLength);

            if (i > 0) {
                while (listOfLengths.contains(randomLength)) {
                    randomLength = generateRandomNumber(maxArrayLength);
                }
            }
            listOfLengths.add(i, randomLength);

            array[i] = new Integer[randomLength];
            for (int j = 0; j < randomLength; j++) {
                array[i][j] = generateRandomNumber(maxNumber);
            }
        }

        for (int i = 0; i < n; i++) {
            if (array[i].length % 2 == 0) {
                Arrays.sort(array[i]);
            } else {
                Arrays.sort(array[i], Collections.reverseOrder());
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

    }

    static int inputNumberOfArrays() {
        System.out.println("Введите количество массивов (натуральное число от 1 до " + maxArrayLength + ") :");
        int number = console.nextInt();
        while (number < 1 || number > maxArrayLength) {
            System.out.println("Вы ввели недопустимое число (меньше 1 или больше "
                    + maxArrayLength + "). Введите число от 1 до " + maxArrayLength + " :");
            number = console.nextInt();
        }
        return number;
    }

    static int generateRandomNumber(int bound) {
        return random.nextInt(bound) + 1;
    }

}
