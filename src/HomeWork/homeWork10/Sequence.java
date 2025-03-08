package HomeWork.homeWork10;

public class Sequence {
    public static int[] filter(int[] array, ByCondition condition) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (condition.IsOk(array[i])) {
                result[i] = array[i];
            }

        }
        return result;
    }
}
