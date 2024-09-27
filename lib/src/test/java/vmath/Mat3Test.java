package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void givenIdentityMatrix_whenMultipliedWithAnyMatrix_thenResultIsTheSame() {
        var i = new Mat3(); 
        var m = new Mat3(
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, 9.0f
        );
        var dot = i.mul(m);

        assertEquals(1.0f, dot.get(0, 0));
        assertEquals(2.0f, dot.get(0, 1));
        assertEquals(3.0f, dot.get(0, 2));

        assertEquals(4.0f, dot.get(1, 0));
        assertEquals(5.0f, dot.get(1, 1));
        assertEquals(6.0f, dot.get(1, 2));

        assertEquals(7.0f, dot.get(2, 0));
        assertEquals(8.0f, dot.get(2, 1));
        assertEquals(9.0f, dot.get(2, 2));
    }

    @Test
    void givenTwoSpecificMatrices_whenMultiplied_thenResultIsAsExpected() {
        var m1 = new Mat3(
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, 9.0f
        );
        var m2 = new Mat3(
            2.0f, 0.0f, 0.0f,
            0.0f, 2.0f, 0.0f,
            0.0f, 0.0f, 2.0f
        );
        var expected = new Mat3(
            2.0f, 4.0f, 6.0f,
            8.0f, 10.0f, 12.0f,
            14.0f, 16.0f, 18.0f
        );
        var dot = m1.mul(m2);

        assertEquals(expected.get(0, 0), dot.get(0, 0));
        assertEquals(expected.get(0, 1), dot.get(0, 1));
        assertEquals(expected.get(0, 2), dot.get(0, 2));

        assertEquals(expected.get(1, 0), dot.get(1, 0));
        assertEquals(expected.get(1, 1), dot.get(1, 1));
        assertEquals(expected.get(1, 2), dot.get(1, 2));

        assertEquals(expected.get(2, 0), dot.get(2, 0));
        assertEquals(expected.get(2, 1), dot.get(2, 1));
        assertEquals(expected.get(2, 2), dot.get(2, 2));
    }

    @Test
    void givenMatricesFromFloatArray_whenMultiplied_thenResultIsAsExpected() {
        float[] a1 = {
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, 9.0f
        };
        float[] a2 = {
            2.0f, 0.0f, 0.0f,
            0.0f, 2.0f, 0.0f,
            0.0f, 0.0f, 2.0f
        };
        var m1 = new Mat3(a1);
        var m2 = new Mat3(a2);
        var expected = new Mat3(
            2.0f, 4.0f, 6.0f,
            8.0f, 10.0f, 12.0f,
            14.0f, 16.0f, 18.0f
        );
        var dot = m1.mul(m2);

        assertEquals(expected.get(0, 0), dot.get(0, 0));
        assertEquals(expected.get(0, 1), dot.get(0, 1));
        assertEquals(expected.get(0, 2), dot.get(0, 2));

        assertEquals(expected.get(1, 0), dot.get(1, 0));
        assertEquals(expected.get(1, 1), dot.get(1, 1));
        assertEquals(expected.get(1, 2), dot.get(1, 2));

        assertEquals(expected.get(2, 0), dot.get(2, 0));
        assertEquals(expected.get(2, 1), dot.get(2, 1));
        assertEquals(expected.get(2, 2), dot.get(2, 2));
    }

    @Test
    void givenVec3_whenMultiplied_thenResultIsCorrect() {
        Mat3 m = new Mat3(
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, 9.0f
        );
        Vec3 v = new Vec3(5.0f, 6.0f, 7.0f);

        Vec3 r = m.mul(v);

        assertEquals(38.0f, r.x());
        assertEquals(92.0f, r.y());
        assertEquals(146.0f, r.z());
    }

    @Test
    void whenToArrayCalled_thenConvertsToArray() {
        var m = new Mat3(
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, 9.0f
        );
        float[] a1 = {
            1.0f, 2.0f, 3.0f,
            4.0f, 5.0f, 6.0f,
            7.0f, 8.0f, 9.0f
        };
        float[] a2 = m.toArray();
        assertArrayEquals(a1, a2);
        assertNotSame(a1, a2);
    }
}
