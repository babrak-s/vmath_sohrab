package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Vec3Test {
    @Test
    void givenNoArgs_whenVec3Created_thenVectorIsZero() {
        var v = new Vec3();
        assertEquals(v.x(), 0.0f);
        assertEquals(v.y(), 0.0f);
        assertEquals(v.z(), 0.0f);
    }

    @Test
    void givenArgs_whenVec3Created_thenVectorHasGivenValues() {
        var v = new Vec3(1.0f, 2.0f, 3.0f);
        assertEquals(v.x(), 1.0f);
        assertEquals(v.y(), 2.0f);
        assertEquals(v.z(), 3.0f);
    }

    @Test
    void givenNaNValues_whenVec3Created_thenThrowsException() {
        assertThrows(ArithmeticException.class, () -> new Vec3(Float.NaN, Float.NaN, Float.NaN));
    }

    @Test
    void givenZeroVector_whenMagnitudeCalculated_thenResultIsZero() {
        var v = new Vec3(0.0f, 0.0f, 0.0f);
        assertEquals(v.mag(), 0.0f);
    }

    @Test
    void givenNonZeroVectors_whenMagnitudeCalculated_thenResultsAreCorrect() {
        var v1 = new Vec3(1.0f, 0.0f, 0.0f);
        assertEquals(v1.mag(), 1.0f);
        var v2 = new Vec3(0.0f, 1.0f, 0.0f);
        assertEquals(v2.mag(), 1.0f);
        var v3 = new Vec3(0.0f, 0.0f, 1.0f);
        assertEquals(v3.mag(), 1.0f);
        var v4 = new Vec3(-1.0f, 0.0f, 0.0f);
        assertEquals(v4.mag(), 1.0f);
        var v5 = new Vec3(0.0f, -1.0f, 0.0f);
        assertEquals(v5.mag(), 1.0f);
        var v6 = new Vec3(0.0f, 0.0f, -1.0f);
        assertEquals(v6.mag(), 1.0f);
        var v7 = new Vec3(1.0f, 1.0f, 1.0f);
        assertEquals(v7.mag(), 1.7320508075688772f);
    }

    @Test
    void givenZeroVector_whenSquaredMagnitudeCalculated_thenResultIsZero() {
        var v = new Vec3(0.0f, 0.0f, 0.0f);
        assertEquals(v.magSqr(), 0.0f);
    }

    @Test
    void givenNonZeroVectors_whenSquaredMagnitudeCalculated_thenResultsAreCorrect() {
        var v1 = new Vec3(1.0f, 0.0f, 0.0f);
        assertEquals(v1.magSqr(), 1.0f);
        var v2 = new Vec3(0.0f, 1.0f, 0.0f);
        assertEquals(v2.magSqr(), 1.0f);
        var v3 = new Vec3(0.0f, 0.0f, 1.0f);
        assertEquals(v3.magSqr(), 1.0f);
        var v4 = new Vec3(-1.0f, 0.0f, 0.0f);
        assertEquals(v4.magSqr(), 1.0f);
        var v5 = new Vec3(0.0f, -1.0f, 0.0f);
        assertEquals(v5.magSqr(), 1.0f);
        var v6 = new Vec3(0.0f, 0.0f, -1.0f);
        assertEquals(v6.magSqr(), 1.0f);
        var v7 = new Vec3(1.0f, 1.0f, 1.0f);
        assertEquals(v7.magSqr(), 3.0);
    }

    @Test
    void givenNonZeroVector_whenNormalized_thenResultIsUnitVector() {
        var v = new Vec3(0.0f, 10.0f, 0.0f).norm();
        assertEquals(v.x(), 0.0f);
        assertEquals(v.y(), 1.0f);
        assertEquals(v.z(), 0.0f);
    }

    @Test
    void givenZeroVector_whenNormalized_thenThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            new Vec3(0.0f, 0.0f, 0.0f).norm();
        });
    }

    @Test
    void givenTwoVectors_whenAdded_thenResultIsCorrect() {
        var v1 = new Vec3(1.0f, 2.0f, 3.0f);
        var v2 = new Vec3(2.0f, 3.0f, 4.0f);
        var sum1 = v1.add(v2);
        assertEquals(sum1.x(), 3.0f);
        assertEquals(sum1.y(), 5.0f);
        assertEquals(sum1.z(), 7.0f);

        var v3 = new Vec3(-1.0f, 1.0f, -1.0f);
        var v4 = new Vec3(1.0f, -1.0f, 1.0f);
        var sum2 = v3.add(v4);
        assertEquals(sum2.x(), 0.0f);
        assertEquals(sum2.y(), 0.0f);
        assertEquals(sum2.z(), 0.0f);
    }

    @Test
    void givenTwoVectors_whenSubtracted_thenResultIsCorrect() {
        var v1 = new Vec3(1.0f, 2.0f, 3.0f);
        var v2 = new Vec3(2.0f, 3.0f, 4.0f);
        var diff1 = v1.sub(v2);
        assertEquals(diff1.x(), -1.0f);
        assertEquals(diff1.y(), -1.0f);
        assertEquals(diff1.z(), -1.0f);

        var v3 = new Vec3(-1.0f, 1.0f, -1.0f);
        var v4 = new Vec3(1.0f, -1.0f, 1.0f);
        var diff2 = v3.sub(v4);
        assertEquals(diff2.x(), -2.0f);
        assertEquals(diff2.y(), 2.0f);
        assertEquals(diff2.z(), -2.0f);
    }

    @Test
    void givenVectorAndScalar_whenMultiplied_thenResultIsCorrect() {
        var v1 = new Vec3(1.0f, 2.0f, 3.0f);
        var prod1 = v1.mul(2.0f);
        assertEquals(prod1.x(), 2.0f);
        assertEquals(prod1.y(), 4.0f);
        assertEquals(prod1.z(), 6.0f);

        var v3 = new Vec3(-1.0f, 1.0f, -1.0f);
        var prod2 = v3.mul(0.0f);
        assertEquals(prod2.x(), -0.0);
        assertEquals(prod2.y(), 0.0f);
        assertEquals(prod2.z(), -0.0f);
    }

    @Test
    void givenTwoVectors_whenDotProductCalculated_thenResultIsCorrect() {
        var n1 = new Vec3(1.0f, 2.0f, 3.0f);
        var l1 = new Vec3(2.0f, 3.0f, 4.0f);
        var dot1 = n1.dot(l1);
        assertEquals(dot1, 20.0f);

        var n2 = new Vec3(-1.0f, 1.0f, -1.0f);
        var l2 = new Vec3(1.0f, -1.0f, 1.0f);
        var dot2 = n2.dot(l2);
        assertEquals(dot2, -3.0f);
    }

    @Test
    void givenTwoVectors_whenCrossProductCalculated_thenResultIsCorrect() {
        var v1 = new Vec3(1.0f, 2.0f, 3.0f);
        var v2 = new Vec3(2.0f, 3.0f, 4.0f);
        Vec3 cross = v1.cross(v2);
        assertEquals(cross.x(), -1.0f);
        assertEquals(cross.y(), 2.0f);
        assertEquals(cross.z(), -1.0f);
    }

    @Test
    void givenThreeVectors_whenTripleProductCalculated_thenResultIsCorrect() {
        var a = new Vec3(1.0f, 2.0f, 3.0f);
        var b = new Vec3(4.0f, 5.0f, 6.0f);
        var c = new Vec3(7.0f, 8.0f, 9.0f);

        float tripleProduct = a.triple(b, c);
        assertEquals(tripleProduct, 0.0f);
    }

    @Test
    void givenTwoVectors_whenLerpCalculated_thenResultIsCorrect() {
        Vec3 v1 = new Vec3(1.0f, 2.0f, 3.0f);
        Vec3 v2 = new Vec3(3.0f, 4.0f, 5.0f);
        float t1 = 0.5f;
        Vec3 result1 = v1.lerp(v2, t1);
        assertEquals(result1.x(), 2.0f);
        assertEquals(result1.y(), 3.0f);
        assertEquals(result1.z(), 4.0f);

        Vec3 v3 = new Vec3(-1.0f, 0.0f, 1.0f);
        Vec3 v4 = new Vec3(1.0f, 2.0f, 3.0f);
        float t2 = 0.25f;
        Vec3 result2 = v3.lerp(v4, t2);
        assertEquals(result2.x(), -0.5f);
        assertEquals(result2.y(), 0.5f);
        assertEquals(result2.z(), 1.5);
    }

    @Test
    void givenZeroVector_whenConvertedToString_thenResultIsZeroString() {
        var v1 = new Vec3();
        assertEquals(v1.toString(), "(0.0, 0.0, 0.0)");
    }

    @Test
    void givenIntParameters_whenConvertedToString_thenResultIsFloatString() {
        var v2 = new Vec3(1, 2, 3);
        assertEquals(v2.toString(), "(1.0, 2.0, 3.0)");
    }

    @Test
    void givenRealParameters_whenConvertedToString_thenResultIsCorrect() {
        var v3 = new Vec3(0.5f, 0.25f, 0.125f);
        assertEquals(v3.toString(), "(0.5, 0.25, 0.125)");
    }
}
