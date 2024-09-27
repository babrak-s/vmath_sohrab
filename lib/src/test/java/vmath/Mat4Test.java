package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Mat4Test {

    @Test
    void givenNoArgs_whenMat4Created_thenMatrixIsIdentity() {
        var m = new Mat4();

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 0.0f);
        assertEquals(m.get(0, 2), 0.0f);
        assertEquals(m.get(0, 3), 0.0f);

        assertEquals(m.get(1, 0), 0.0f);
        assertEquals(m.get(1, 1), 1.0f);
        assertEquals(m.get(1, 2), 0.0f);
        assertEquals(m.get(1, 3), 0.0f);

        assertEquals(m.get(2, 0), 0.0f);
        assertEquals(m.get(2, 1), 0.0f);
        assertEquals(m.get(2, 2), 1.0f);
        assertEquals(m.get(2, 3), 0.0f);

        assertEquals(m.get(3, 0), 0.0f);
        assertEquals(m.get(3, 1), 0.0f);
        assertEquals(m.get(3, 2), 0.0f);
        assertEquals(m.get(3, 3), 1.0f);
    }

    @Test
    void givenArgs_whenMat4Created_thenMatrixHasGivenValues() {
        var m = new Mat4(
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);
        assertEquals(m.get(0, 2), 3.0f);
        assertEquals(m.get(0, 3), 4.0f);

        assertEquals(m.get(1, 0), 5.0f);
        assertEquals(m.get(1, 1), 6.0f);
        assertEquals(m.get(1, 2), 7.0f);
        assertEquals(m.get(1, 3), 8.0f);

        assertEquals(m.get(2, 0), 9.0f);
        assertEquals(m.get(2, 1), 10.0f);
        assertEquals(m.get(2, 2), 11.0f);
        assertEquals(m.get(2, 3), 12.0f);

        assertEquals(m.get(3, 0), 13.0f);
        assertEquals(m.get(3, 1), 14.0f);
        assertEquals(m.get(3, 2), 15.0f);
        assertEquals(m.get(3, 3), 16.0f);
    }

    @Test
    void givenNaNValues_whenMat4Created_thenThrowsException() {
        assertThrows(ArithmeticException.class, () -> new Mat4(
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN
        ));

        assertThrows(ArithmeticException.class, () -> new Mat4(
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, Float.NaN
        ));
    }

    @Test
    void givenArrayArg_whenMat4Created_thenMatrixHasGivenValues() {
        var a = new float[] {
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        };
        var m = new Mat4(a);
      
        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);
        assertEquals(m.get(0, 2), 3.0f);
        assertEquals(m.get(0, 3), 4.0f);

        assertEquals(m.get(1, 0), 5.0f);
        assertEquals(m.get(1, 1), 6.0f);
        assertEquals(m.get(1, 2), 7.0f);
        assertEquals(m.get(1, 3), 8.0f);

        assertEquals(m.get(2, 0), 9.0f);
        assertEquals(m.get(2, 1), 10.0f);
        assertEquals(m.get(2, 2), 11.0f);
        assertEquals(m.get(2, 3), 12.0f);

        assertEquals(m.get(3, 0), 13.0f);
        assertEquals(m.get(3, 1), 14.0f);
        assertEquals(m.get(3, 2), 15.0f);
        assertEquals(m.get(3, 3), 16.0f);
    }

    @Test
    void givenNullArray_whenMat4Created_thenThrowsException() {
        float[] a = null;
        assertThrows(IllegalArgumentException.class, () -> new Mat4(a));
    }

    @Test
    void givenArrayOfInvalidLength_whenMat4Created_thenThrowsException() {
        var a1 = new float[] {
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat4(a1));

        var a2 = new float[] {
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f, 17.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat4(a2));
    }

    @Test
    void givenArrayWithNaNs_whenMat4Created_thenThrowsException() {
        float[] a1 = {
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN,
            Float.NaN, Float.NaN, Float.NaN, Float.NaN
        };
        assertThrows(ArithmeticException.class, () -> new Mat4(a1));

        float[] a2 = {
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, Float.NaN
        };
        assertThrows(ArithmeticException.class, () -> new Mat4(a2));
    }

    @Test
    void givenIndices_whenGetCalled_thenReturnCorrectValue() {
        var m = new Mat4(
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);
        assertEquals(m.get(0, 2), 3.0f);
        assertEquals(m.get(0, 3), 4.0f);

        assertEquals(m.get(1, 0), 5.0f);
        assertEquals(m.get(1, 1), 6.0f);
        assertEquals(m.get(1, 2), 7.0f);
        assertEquals(m.get(1, 3), 8.0f);

        assertEquals(m.get(2, 0), 9.0f);
        assertEquals(m.get(2, 1), 10.0f);
        assertEquals(m.get(2, 2), 11.0f);
        assertEquals(m.get(2, 3), 12.0f);

        assertEquals(m.get(3, 0), 13.0f);
        assertEquals(m.get(3, 1), 14.0f);
        assertEquals(m.get(3, 2), 15.0f);
        assertEquals(m.get(3, 3), 16.0f);
    }

    @Test
    void givenInvalidIndices_whenGetIsCalled_thenThrowsException() {
        var m = new Mat4();

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(4, 0));

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, 4));
    }

    @Test
    void givenIdentityMatrix_whenMultipliedWithAnyMatrix_thenResultIsTheSame() {
        var i = new Mat4(); 
        var m = new Mat4(
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );
        var dot = i.mul(m);
        
        assertEquals(1.0f, dot.get(0, 0));
        assertEquals(2.0f, dot.get(0, 1));
        assertEquals(3.0f, dot.get(0, 2));
        assertEquals(4.0f, dot.get(0, 3));

        assertEquals(5.0f, dot.get(1, 0));
        assertEquals(6.0f, dot.get(1, 1));
        assertEquals(7.0f, dot.get(1, 2));
        assertEquals(8.0f, dot.get(1, 3));

        assertEquals(9.0f, dot.get(2, 0));
        assertEquals(10.0f, dot.get(2, 1));
        assertEquals(11.0f, dot.get(2, 2));
        assertEquals(12.0f, dot.get(2, 3));

        assertEquals(13.0f, dot.get(3, 0));
        assertEquals(14.0f, dot.get(3, 1));
        assertEquals(15.0f, dot.get(3, 2));
        assertEquals(16.0f, dot.get(3, 3));
    }

    @Test
    void givenTwoSpecificMatrices_whenMultiplied_thenResultIsAsExpected() {
        var m1 = new Mat4(
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );
        var m2 = new Mat4(
            2.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 2.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 2.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 2.0f
        );
        var expected = new Mat4(
            2.0f, 4.0f, 6.0f, 8.0f,
            10.0f, 12.0f, 14.0f, 16.0f,
            18.0f, 20.0f, 22.0f, 24.0f,
            26.0f, 28.0f, 30.0f, 32.0f
        );
        var dot = m1.mul(m2);

        assertEquals(expected.get(0, 0), dot.get(0, 0));
        assertEquals(expected.get(0, 1), dot.get(0, 1));
        assertEquals(expected.get(0, 2), dot.get(0, 2));
        assertEquals(expected.get(0, 3), dot.get(0, 3));

        assertEquals(expected.get(1, 0), dot.get(1, 0));
        assertEquals(expected.get(1, 1), dot.get(1, 1));
        assertEquals(expected.get(1, 2), dot.get(1, 2));
        assertEquals(expected.get(1, 3), dot.get(1, 3));

        assertEquals(expected.get(2, 0), dot.get(2, 0));
        assertEquals(expected.get(2, 1), dot.get(2, 1));
        assertEquals(expected.get(2, 2), dot.get(2, 2));
        assertEquals(expected.get(2, 3), dot.get(2, 3));

        assertEquals(expected.get(3, 0), dot.get(3, 0));
        assertEquals(expected.get(3, 1), dot.get(3, 1));
        assertEquals(expected.get(3, 2), dot.get(3, 2));
        assertEquals(expected.get(3, 3), dot.get(3, 3));
    }

    @Test
    void givenMatricesFromFloatArray_whenMultiplied_thenResultIsAsExpected() {
        float[] a1 = {
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        };
        float[] a2 = {
            2.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 2.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 2.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 2.0f
        };
        var m1 = new Mat4(a1);
        var m2 = new Mat4(a2);
        var expected = new Mat4(
            2.0f, 4.0f, 6.0f, 8.0f,
            10.0f, 12.0f, 14.0f, 16.0f,
            18.0f, 20.0f, 22.0f, 24.0f,
            26.0f, 28.0f, 30.0f, 32.0f
        );
        var dot = m1.mul(m2);

        assertEquals(expected.get(0, 0), dot.get(0, 0));
        assertEquals(expected.get(0, 1), dot.get(0, 1));
        assertEquals(expected.get(0, 2), dot.get(0, 2));
        assertEquals(expected.get(0, 3), dot.get(0, 3));

        assertEquals(expected.get(1, 0), dot.get(1, 0));
        assertEquals(expected.get(1, 1), dot.get(1, 1));
        assertEquals(expected.get(1, 2), dot.get(1, 2));
        assertEquals(expected.get(1, 3), dot.get(1, 3));

        assertEquals(expected.get(2, 0), dot.get(2, 0));
        assertEquals(expected.get(2, 1), dot.get(2, 1));
        assertEquals(expected.get(2, 2), dot.get(2, 2));
        assertEquals(expected.get(2, 3), dot.get(2, 3));

        assertEquals(expected.get(3, 0), dot.get(3, 0));
        assertEquals(expected.get(3, 1), dot.get(3, 1));
        assertEquals(expected.get(3, 2), dot.get(3, 2));
        assertEquals(expected.get(3, 3), dot.get(3, 3));
    }

    @Test
    void givenNoArgsMatrix_whenConvertedToString_thenResultIsIdentityMatrix() {
        var m = new Mat4();
        assertEquals(m.toString(), "(1.0, 0.0, 0.0, 0.0)\n" +
                                   "(0.0, 1.0, 0.0, 0.0)\n" +
                                   "(0.0, 0.0, 1.0, 0.0)\n" +
                                   "(0.0, 0.0, 0.0, 1.0)");
    }

    @Test
    void givenIntParameters_whenConvertedToString_thenResultIsFloatString() {
        var m = new Mat4(
            1, 2, 3, 4,
            5, 6, 7, 8,
            9, 10, 11, 12,
            13, 14, 15, 16
        );
        assertEquals(m.toString(), "(1.0, 2.0, 3.0, 4.0)\n"    +
                                   "(5.0, 6.0, 7.0, 8.0)\n"    +
                                   "(9.0, 10.0, 11.0, 12.0)\n" +
                                   "(13.0, 14.0, 15.0, 16.0)");
    }

    @Test
    void givenRealParameters_whenConvertedToString_thenResultIsCorrect() {
        var m = new Mat4(
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );
        assertEquals(m.toString(), "(1.0, 2.0, 3.0, 4.0)\n"    +
                                   "(5.0, 6.0, 7.0, 8.0)\n"    +
                                   "(9.0, 10.0, 11.0, 12.0)\n" +
                                   "(13.0, 14.0, 15.0, 16.0)");
    }

    @Test
    void whenToArrayCalled_thenConvertsToArray() {
        var m = new Mat4(
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        );
        float[] a1 = {
            1.0f, 2.0f, 3.0f, 4.0f,
            5.0f, 6.0f, 7.0f, 8.0f,
            9.0f, 10.0f, 11.0f, 12.0f,
            13.0f, 14.0f, 15.0f, 16.0f
        };
        float[] a2 = m.toArray();
        assertArrayEquals(a1, a2);
        assertNotSame(a1, a2);
    }
}
