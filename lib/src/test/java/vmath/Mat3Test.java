package vmath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Mat3Test {

    @Test
    void givenNoArgs_whenMat3Created_thenMatrixIsIdentity() {
        var m = new Mat3();

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 0.0f);
        assertEquals(m.get(0, 2), 0.0f);

        assertEquals(m.get(1, 0), 0.0f);
        assertEquals(m.get(1, 1), 1.0f);
        assertEquals(m.get(1, 2), 0.0f);

        assertEquals(m.get(2, 0), 0.0f);
        assertEquals(m.get(2, 1), 0.0f);
        assertEquals(m.get(2, 2), 1.0f);
    }

    @Test
    void givenArrayArg_whenMat3Created_thenMatrixHasGivenValues() {
        var a = new float[] {
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, 9.0f
        };
        var m = new Mat3(a);

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);
        assertEquals(m.get(0, 2), 3.0f);

        assertEquals(m.get(1, 0), 4.0f);
        assertEquals(m.get(1, 1), 5.0f);
        assertEquals(m.get(1, 2), 6.0f);

        assertEquals(m.get(2, 0), 7.0f);
        assertEquals(m.get(2, 1), 8.0f);
        assertEquals(m.get(2, 2), 9.0f);
    }
    
    @Test
    void givenNullArray_whenMat3Created_thenThrowsException() {
        float[] a = null;
        assertThrows(IllegalArgumentException.class, () -> new Mat3(a));
    }

    @Test
    public void givenNaNValues_whenConstructorCalled_thenThrowArithmeticException() {
        assertThrows(ArithmeticException.class, () -> new Mat3(
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, Float.NaN
        ));

        assertThrows(ArithmeticException.class, () -> new Mat3(
            Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN
        ));
    }

    @Test
    public void givenValidValues_whenConstructorCalled_thenNoExceptionThrown() {
        var a = new Mat3(
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, 9.0f
        );

        assertEquals(1.0f, a.get(0, 0));
        assertEquals(2.0f, a.get(0, 1));
        assertEquals(3.0f, a.get(0, 2));

        assertEquals(4.0f, a.get(1, 0));
        assertEquals(5.0f, a.get(1, 1));
        assertEquals(6.0f, a.get(1, 2));

        assertEquals(7.0f, a.get(2, 0));
        assertEquals(8.0f, a.get(2, 1));
        assertEquals(9.0f, a.get(2, 2));
    }

    @Test
    void givenArrayOfInvalidLength_whenMat3Created_thenThrowsException() {
        var a1 = new float[] {
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat3(a1));

        var a2 = new float[] {
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, 9.0f, 10.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat3(a2));
    }

    @Test
    void givenArrayWithNaNs_whenMat3Created_thenThrowsException() {
        float[] a1 = {
            Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN
        };
        assertThrows(ArithmeticException.class, () -> new Mat3(a1));

        float[] a2 = {
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, Float.NaN
        };
        assertThrows(ArithmeticException.class, () -> new Mat3(a2));
    }

    @Test
    void givenTwoMatrices_whenMultiplied_thenResultIsCorrect() {
        var m1 = new Mat3();
        var m2 = new Mat3();

        var product1 = m1.mul(m2);

        assertEquals(1.0f, product1.get(0, 0));
        assertEquals(0.0f, product1.get(0, 1));
        assertEquals(0.0f, product1.get(0, 2));
        assertEquals(0.0f, product1.get(1, 0));
        assertEquals(1.0f, product1.get(1, 1));
        assertEquals(0.0f, product1.get(1, 2));
        assertEquals(0.0f, product1.get(2, 0));
        assertEquals(0.0f, product1.get(2, 1));
        assertEquals(1.0f, product1.get(2, 2));

        var m3 = new Mat3(
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, 9.0f
        );
        var m4 = new Mat3(
            -1.0f, -2.0f, -3.0f,
            -4.0f, -5.0f, -6.0f,
            -7.0f, -8.0f, -9.0f
        );

        var product2 = m3.mul(m4);

        assertEquals(-30.0f, product2.get(0, 0));
        assertEquals(-36.0f, product2.get(0, 1));
        assertEquals(-42.0f, product2.get(0, 2));
        assertEquals(-66.0f, product2.get(1, 0));
        assertEquals(-81.0f, product2.get(1, 1));
        assertEquals(-96.0f, product2.get(1, 2));
        assertEquals(-102.0f, product2.get(2, 0));
        assertEquals(-126.0f, product2.get(2, 1));
        assertEquals(-150.0f, product2.get(2, 2));
    }
}
