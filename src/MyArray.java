import java.util.Arrays;

public class MyArray {
    private long[] array;
    private long size = 0;

    public MyArray(long sizeArray) {
        this.size = sizeArray;
        this.array = new long[(int) size];
        addElementsInArray();
    }

    public void addElementsInArray () {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public void deleteRandomElement() {
        long[] result = new long[array.length - 1];
        int randomPosition = (int) (Math.random() * array.length);
        array[randomPosition] = 0;

        System.arraycopy(array, 0, result, 0, randomPosition);
        System.arraycopy(array, randomPosition + 1, result, randomPosition, array.length - randomPosition - 1);

        size--;
        array = result;
    }

    public void shuffle() {
        for (long i = 0; i < array.length; i++) {
            int randomPosition = (int) (Math.random() * (array.length - 1 - i));
            long lastNumber = array[array.length - 1 - (int) i];
            array[array.length - 1 - (int) i] = array[randomPosition];
            array[randomPosition] = lastNumber;
        }
    }

    public long searchMissingNumberBase() {
        long originSum = (size + 1) * (size + 2) / 2;
        long actualSum = 0;
        for (long i : array) {
            actualSum += i;
        }

        return originSum - actualSum;
    }

    public long searchMissingNumberXor() {
        long xor = 0;

        for (long i = 1; i < size + 2; i++) {
            xor ^= i;
        }

        for (long j = 0; j < size; j++) {
            xor ^= array[(int) j];
        }

        return xor;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
