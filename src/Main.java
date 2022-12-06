import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        Integer[] TEST = new Integer[100_000];
        for (int i = 0; i < TEST.length; i++) {
            TEST[i] = (int) (Math.random() * 1000);
        }

        Integer[] test1;
        Integer[] test2;
        Integer[] test3;

        test1 = Arrays.copyOf(TEST,100_000);
        test2 = Arrays.copyOf(TEST,100_000);
        test3 = Arrays.copyOf(TEST,100_000);

        long start1 = System.currentTimeMillis();
        sortBubble(test1);
        System.out.println("Сортировка пузырьком. Время: ");
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        sortSelection(test2);
        System.out.println("Сортировка выбором. Время: ");
        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        sortInsertion(test3);
        System.out.println("Сортировка вставкой. Время: ");
        System.out.println(System.currentTimeMillis() - start3);
    }

    // пузырьковая сортировка
    public static void sortBubble(Integer[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    // сортировка выбором
    public static void sortSelection(Integer[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            int tmp = arr[minElementIndex];
            arr[minElementIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    // сортировка вставкой
    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}