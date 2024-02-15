import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @org.junit.jupiter.api.Test
    public void EqualTest() {
        int [] a = {1,2,3,4,5}; // Эталон
        int [] b = {3,2,4,1,5};
        int [] b1 = {1,5,3,2,4};
        assertArrayEquals(a, Matrix.sort(b));
        assertArrayEquals(a, Matrix.sort(b1));
    }

    @org.junit.jupiter.api.Test
    public void NegativeEqualTest() {
        int [] a = {-85,-21,-21,-5,-5,5}; // Эталон
        int [] b = {-5,5,-85,-5,-21,-21};
        int [] b1 = {-21,-5,5,-21,-85,-5};
        assertArrayEquals(a, Matrix.sort(b));
        assertArrayEquals(a, Matrix.sort(b1));
    }

    @org.junit.jupiter.api.Test
    public void OneNumTest() {
        int [] a = {1};
        int [] b = {1};
        assertArrayEquals(a, Matrix.sort(b));
    }

    @org.junit.jupiter.api.Test
    public void SameEqualTest() {
        int [] a = {3,4,5,6,7};
        int [] b = {3,4,5,6,7};
        assertArrayEquals(a, Matrix.sort(b));
    }
}