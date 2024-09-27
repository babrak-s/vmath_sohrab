package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Mat2Test {

    @Test
    void givenNoArgs_whenMat2Created_thenMatrixIsIdentity() {
        var m = new Mat2();

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 0.0f);

        assertEquals(m.get(1, 0), 0.0f);
        assertEquals(m.get(1, 1), 1.0f);
    }
  
    @Test
    void givenArgs_whenMat2Created_thenMatrixHasGivenValues() {
        var m = new Mat2(
            1.0f, 2.0f,
            3.0f, 4.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);

        assertEquals(m.get(1, 0), 3.0f);
        assertEquals(m.get(1, 1), 4.0f);
    }

    @Test
    void givenNaNValues_whenMat2Created_thenThrowsException() {
        assertThrows(ArithmeticException.class, () -> new Mat2(
            Float.NaN, Float.NaN,
            Float.NaN, Float.NaN
        ));

        assertThrows(ArithmeticException.class, () -> new Mat2(
            1.0f, 2.0f,
            3.0f, Float.NaN
        ));
    }

    @Test
    void givenArrayArg_whenMat2Created_thenMatrixHasGivenValues() {
        var a = new float[] {
            1.0f, 2.0f,
            3.0f, 4.0f
        };
        var m = new Mat2(a);

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);

        assertEquals(m.get(1, 0), 3.0f);
        assertEquals(m.get(1, 1), 4.0f);
    }

    @Test
    void givenNullArray_whenMat2Created_thenThrowsException() {
        float[] a = null;
        assertThrows(IllegalArgumentException.class, () -> new Mat2(a));
    }

    @Test
    void givenArrayOfInvalidLength_whenMat2Created_thenThrowsException() {
        var a1 = new float[] {
            1.0f, 2.0f,
            3.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat2(a1));

        var a2 = new float[] {
            1.0f, 2.0f,
            3.0f, 4.0f, 5.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat2(a2));
    }

    @Test
    void givenArrayWithNaNs_whenMat2Created_thenThrowsException() {
        float[] a1 = {
            Float.NaN, Float.NaN,
            Float.NaN, Float.NaN
        };
        assertThrows(ArithmeticException.class, () -> new Mat2(a1));

        float[] a2 = {
            1.0f, 2.0f,
            3.0f, Float.NaN
        };
        assertThrows(ArithmeticException.class, () -> new Mat2(a2));
    }

    @Test
    void givenIndices_whenGetCalled_thenReturnCorrectValue() {
        var m = new Mat2(
            1.0f, 2.0f,
            3.0f, 4.0f
        );

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);

        assertEquals(m.get(1, 0), 3.0f);
        assertEquals(m.get(1, 1), 4.0f);
    }

    @Test
    void givenInvalidIndices_whenGetIsCalled_thenThrowsException() {
        var m = new Mat2();

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(2, 0));

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, 2));
    }

    @Test
    void givenVec2_whenMultiplied_thenResultIsCorrect() {
        Mat2 m = new Mat2(
            1.0f, 2.0f,
            3.0f, 4.0f
        );
        Vec2 v = new Vec2(5.0f, 6.0f);

        Vec2 r = m.mul(v);

        assertEquals(17.0f, r.x());
        assertEquals(39.0f, r.y());
    }

    @Test
    void whenToArrayCalled_thenConvertsToArray() {
        var m = new Mat2(
            1.0f, 2.0f,
            3.0f, 4.0f
        );
        float[] a1 = {
            1.0f, 2.0f,
            3.0f, 4.0f
        };
        float[] a2 = m.toArray();
        assertArrayEquals(a1, a2);
        assertNotSame(a1, a2);
    }

    @Test
    void givenNoArgsMatrix_whenConvertedToString_thenResultIsIdentityMatrix() {
        var m = new Mat2();
        assertEquals(m.toString(), "(1.0, 0.0)\n" +
                                   "(0.0, 1.0)");
    }

    @Test
    void givenIntParameters_whenConvertedToString_thenResultIsFloatString() {
        var m = new Mat2(
            1, 2,
            3, 4
        );
        assertEquals(m.toString(), "(1.0, 2.0)\n" +
                                   "(3.0, 4.0)");
    }

    @Test
    void givenRealParameters_whenConvertedToString_thenResultIsCorrect() {
        var m = new Mat2(
            2.0f, 3.0f,
            5.0f, 1.0f
        );
        assertEquals(m.toString(), "(2.0, 3.0)\n" +
                                   "(5.0, 1.0)");
    }

    @Test
    void givenIdentityMatrix_whenMultipliedWithAnyMatrix_thenResultIsTheSame() {
        var i = new Mat2(); 
        var m = new Mat2(
            1.0f, 2.0f,
            3.0f, 4.0f
        );
        var dot = i.mul(m);

        var expected = new Mat2(
            1.0f, 2.0f,
            3.0f, 4.0f
        );

        assertEquals(expected.get(0, 0), dot.get(0, 0));
        assertEquals(expected.get(0, 1), dot.get(0, 1));
        assertEquals(expected.get(1, 0), dot.get(1, 0));
        assertEquals(expected.get(1, 1), dot.get(1, 1));
    }

    @Test
    void givenTwoSpecificMatrices_whenMultiplied_thenResultIsAsExpected() {
        var m1 = new Mat2(
            1.0f, 2.0f,
            3.0f, 4.0f
        );

        var m2 = new Mat2(
            5.0f, 6.0f,
            7.0f, 8.0f
        );

        var expected = new Mat2(
            19.0f, 22.0f,
            43.0f, 50.0f
        );

        var result = m1.mul(m2);

        assertEquals(expected.get(0, 0), result.get(0, 0));
        assertEquals(expected.get(0, 1), result.get(0, 1));
        assertEquals(expected.get(1, 0), result.get(1, 0));
        assertEquals(expected.get(1, 1), result.get(1, 1));
    }

    @Test
    void givenMatricesFromFloatArray_whenMultiplied_thenResultIsAsExpected() {
        float[] a1 = {
            1.0f, 2.0f,
            3.0f, 4.0f
        };

        float[] a2 = {
            5.0f, 6.0f,
            7.0f, 8.0f
        };

        var m1 = new Mat2(a1);
        var m2 = new Mat2(a2);

        var expected = new Mat2(
            19.0f, 22.0f,
            43.0f, 50.0f
        );

        var result = m1.mul(m2);

        assertEquals(expected.get(0, 0), result.get(0, 0));
        assertEquals(expected.get(0, 1), result.get(0, 1));
        assertEquals(expected.get(1, 0), result.get(1, 0));
        assertEquals(expected.get(1, 1), result.get(1, 1));
    }
}