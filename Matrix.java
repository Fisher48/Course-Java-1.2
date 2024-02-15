import java.util.Arrays;
public class Matrix {

    public static int[] sort(int [] b) {
        int x, y = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                x = b[i];
                y = b[j];
                if (b[j] >= b[i]) {
                    y = b[i];
                    x = b[j];
                    b[i] = x;
                    b[j] = y;
                }
            }
        }
        return b;
    }
    public static void main(String[] args) {
        int [] a = {-21,-5,5,-21,-85,-5};
        System.out.println(Arrays.toString(sort(a)));
    }
}