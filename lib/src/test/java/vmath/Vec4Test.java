package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Vec4Test {

    @Test
    void givenNoArgs_whenVec4Created_thenVectorIsZero() {
        var v = new Vec4();
        assertEquals(v.x(), 0.0f);
        assertEquals(v.y(), 0.0f);
        assertEquals(v.z(), 0.0f);
        assertEquals(v.w(), 0.0f);
    }

    @Test
    void givenArgs_whenVec4Created_thenVectorHasGivenValues() {
        var v = new Vec4(1.0f, 2.0f, 3.0f, 4.0f);
        assertEquals(v.x(), 1.0f);
        assertEquals(v.y(), 2.0f);
        assertEquals(v.z(), 3.0f);
        assertEquals(v.w(), 4.0f);
    }

    @Test
    void givenNaNValues_whenVec4Created_thenThrowsException() {
        assertThrows(ArithmeticException.class, () -> new Vec4(Float.NaN, Float.NaN, Float.NaN, Float.NaN));
    }

    @Test
    void givenZeroVector_whenMagnitudeCalculated_thenResultIsZero() {
        var v = new Vec4(0.0f, 0.0f, 0.0f, 0.0f);
        assertEquals(v.mag(), 0.0f);
    }

    @Test
    void givenNonZeroVectors_whenMagnitudeCalculated_thenResultsAreCorrect() {
        var v1 = new Vec4(0.0f, 1.0f, 0.0f, 0.0f);
        assertEquals(v1.mag(), 1.0f);
        var v2 = new Vec4(1.0f, 0.0f, 0.0f, 0.0f);
        assertEquals(v2.mag(), 1.0f);
        var v3 = new Vec4(0.0f, -1.0f, 0.0f, 0.0f);
        assertEquals(v3.mag(), 1.0f);
        var v4 = new Vec4(-1.0f, 0.0f, 0.0f, 0.0f);
        assertEquals(v4.mag(), 1.0f);
        var v5 = new Vec4(1.0f, 1.0f, 0.0f, 0.0f);
        assertEquals(v5.mag(), 1.4142135381698608f);
        var v6 = new Vec4(2.0f, 1.0f, 1.0f, 1.0f);
        assertEquals(v6.mag(), 2.6457513110645905f);
    }

    @Test
    void givenZeroVector_whenSquaredMagnitudeCalculated_thenResultIsZero() {
        var v = new Vec4(0.0f, 0.0f, 0.0f, 0.0f);
        assertEquals(v.magSqr(), 0.0f);
    }

    @Test
    void givenNonZeroVectors_whenSquaredMagnitudeCalculated_thenResultsAreCorrect() {
        var v1 = new Vec4(1.0f, 0.0f, 0.0f, 0.0f);
        assertEquals(v1.magSqr(), 1.0f);

        var v2 = new Vec4(0.0f, 1.0f, 0.0f, 0.0f);
        assertEquals(v2.magSqr(), 1.0f);

        var v3 = new Vec4(0.0f, 0.0f, 1.0f, 0.0f);
        assertEquals(v3.magSqr(), 1.0f);

        var v4 = new Vec4(0.0f, 0.0f, 0.0f, 1.0f);
        assertEquals(v4.magSqr(), 1.0f);

        var v5 = new Vec4(-1.0f, 0.0f, 0.0f, 0.0f);
        assertEquals(v5.magSqr(), 1.0f);

        var v6 = new Vec4(0.0f, -1.0f, 0.0f, 0.0f);
        assertEquals(v6.magSqr(), 1.0f);

        var v7 = new Vec4(0.0f, 0.0f, -1.0f, 0.0f);
        assertEquals(v7.magSqr(), 1.0f);

        var v8 = new Vec4(0.0f, 0.0f, 0.0f, -1.0f);
        assertEquals(v8.magSqr(), 1.0f);

        var v9 = new Vec4(1.0f, 1.0f, 1.0f, 1.0f);
        assertEquals(v9.magSqr(), 4.0f);
    }

    @Test
    void givenNonZeroVector_whenNormalized_thenResultIsUnitVector() {
        var v = new Vec4(0.0f, 10.0f, 11.0f, 5.0f).norm();
        assertEquals(v.x(), 0.0f);
        assertEquals(v.y(), 0.63757671306333829f);
        assertEquals(v.z(), 0.70133444436967211f);
        assertEquals(v.w(), 0.31878835653166914f);
    }

    @Test
    void givenZeroVector_whenNormalized_thenThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            new Vec4(0.0f, 0.0f, 0.0f, 0.0f).norm();
        });
    }

    @Test
    void givenTwoVectors_whenAdded_thenResultIsCorrect() {
        var v1 = new Vec4(1.0f, 2.0f, 3.0f, 4.0f);
        var v2 = new Vec4(2.0f, 3.0f, 1.0f, 2.0f);
        var sum1 = v1.add(v2);
        assertEquals(sum1.x(), 3.0f);
        assertEquals(sum1.y(), 5.0f);
        assertEquals(sum1.z(), 4.0f);
        assertEquals(sum1.w(), 6.0f);

        var v3 = new Vec4(-1.0f, 1.0f, -1.0f, 1.0f);
        var v4 = new Vec4(1.0f, -1.0f, -1.0f, -1.0f);
        var sum2 = v3.add(v4);
        assertEquals(sum2.x(), 0.0f);
        assertEquals(sum2.y(), 0.0f);
        assertEquals(sum2.z(), -2.0f);
        assertEquals(sum2.w(), 0.0f);
    }

    @Test
    void givenTwoVectors_whenSubtracted_thenResultIsCorrect() {
        var v1 = new Vec4(1.0f, 2.0f, 7.0f, 4.0f);
        var v2 = new Vec4(2.0f, 3.0f, 6.0f, 3.0f);
        var diff1 = v1.sub(v2);
        assertEquals(diff1.x(), -1.0f);
        assertEquals(diff1.y(), -1.0f);
        assertEquals(diff1.z(), 1.0f);
        assertEquals(diff1.w(), 1.0f);

        var v3 = new Vec4(-1.0f, 1.0f, -7.0f, -4.0f);
        var v4 = new Vec4(1.0f, -1.0f, -7.0f, -3.0f);
        var diff2 = v3.sub(v4);
        assertEquals(diff2.x(), -2.0f);
        assertEquals(diff2.y(), 2.0f);
        assertEquals(diff2.z(), 0.0f);
        assertEquals(diff2.w(), -1.0f);
    }

    @Test
    void givenVectorAndScalar_whenMultiplied_thenResultIsCorrect() {
        var v1 = new Vec4(1.0f, 2.0f, 5.0f, 4.0f);
        var prod1 = v1.mul(2.0f);
        assertEquals(prod1.x(), 2.0f);
        assertEquals(prod1.y(), 4.0f);
        assertEquals(prod1.z(), 10.0f);
        assertEquals(prod1.w(), 8.0f);

        var v3 = new Vec4(-1.0f, 1.0f, 3.0f, -2.0f);
        var prod2 = v3.mul(0.0f);
        assertEquals(prod2.x(), -0.0);
        assertEquals(prod2.y(), 0.0f);
        assertEquals(prod2.z(), 0.0f);
        assertEquals(prod2.w(), -0.0);
    }

    @Test
    void givenTwoVectors_whenDotProductCalculated_thenResultIsCorrect() {
        var n1 = new Vec4(1.0f, 2.0f, 5.0f, 4.0f);
        var l1 = new Vec4(2.0f, 3.0f, 1.0f, 2.0f);
        var dot1 = n1.dot(l1);
        assertEquals(dot1, 21.0f);

        var n2 = new Vec4(-1.0f, 1.0f, -2.0f, 0.0f);
        var l2 = new Vec4(1.0f, -1.0f, 2.0f, 1.0f);
        var dot2 = n2.dot(l2);
        assertEquals(dot2, -6.0f);
    }

    @Test
    void givenTwoVectors_whenLerpCalculated_thenResultIsCorrect() {
        var v1 = new Vec4(1.0f, 2.0f, 3.0f, 4.0f);
        var v2 = new Vec4(2.0f, 3.0f, 1.0f, 2.0f);
        float t1 = 0.5f;
        Vec4 result1 = v1.lerp(v2, t1);
        assertEquals(result1.x(), 1.5f);
        assertEquals(result1.y(), 2.5f);
        assertEquals(result1.z(), 2.0f);
        assertEquals(result1.w(), 3.0f);

        var v3 = new Vec4(-1.0f, 0.0f, 1.0f, 1.0f);
        var v4 = new Vec4(1.0f, 2.0f, 3.0f, 4.0f);
        float t2 = 0.25f;
        Vec4 result2 = v3.lerp(v4, t2);
        assertEquals(result2.x(), -0.5f);
        assertEquals(result2.y(), 0.5f);
        assertEquals(result2.z(), 1.5f);
        assertEquals(result2.w(), 1.75f);
    }

    @Test
    void givenZeroVector_whenConvertedToString_thenResultIsZeroString() {
        var v1 = new Vec4();
        assertEquals(v1.toString(), "(0.0, 0.0, 0.0, 0.0)");
    }

    @Test
    void givenIntParameters_whenConvertedToString_thenResultIsFloatString() {
        var v2 = new Vec4(1, 2, 3, 4);
        assertEquals(v2.toString(), "(1.0, 2.0, 3.0, 4.0)");
    }

    @Test
    void givenRealParameters_whenConvertedToString_thenResultIsCorrect() {
        var v3 = new Vec4(0.5f, 0.25f, -1.555f, 3.0f);
        assertEquals(v3.toString(), "(0.5, 0.25, -1.555, 3.0)");
    }
}
