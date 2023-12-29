package vmath;

public class Vec2 {
    private final float x;
    private final float y;

    /**
        * Constructs a zero vector (0.0, 0.0).
    */
    public Vec2() {
        this(0.0f, 0.0f);
    }

    /**
        * Constructs a vector with specified x and y coordinates.
        *
        * @param x The x-coordinate of the vector.
        * @param y The y-coordinate of the vector.
        * @throws ArithmeticException if x or y is NaN.
     */
    public Vec2(float x, float y) {
        if (Float.isNaN(x) || Float.isNaN(y)) {
            throw new ArithmeticException();
        }
        this.x = x;
        this.y = y;
    }

    /**
        * Returns the x-coordinate of the vector.
        *
        * @return The x-coordinate.
     */
    public float x() {
        return x;
    }

    /**
        * Returns the y-coordinate of the vector.
        *
        * @return The y-coordinate.
     */
    public float y() {
        return y;
    }

    /**
        * Calculates the magnitude (length) of the vector.
        *
        * @return The magnitude of the vector.
    */
    public float mag() {
        return (float) Math.sqrt(x*x + y*y);
    }

    /**
        * Normalizes the vector to a unit vector.
        *
        * @return A new vector representing the normalized version of this vector.
    */
    public Vec2 norm() {
        float norm = 1.0f / (float) Math.sqrt(x*x + y*y);
        return new Vec2(x*norm, y*norm);
    }

    /**
        * Adds this vector to another vector.
        *
        * @param other The vector to be added.
        * @return A new vector representing the sum of this vector and the other vector.
    */
    public Vec2 add(Vec2 other) {
        return new Vec2(x + other.x, y + other.y);
    }

    /**
        * Subtracts another vector from this vector.
        *
        * @param other The vector to be subtracted.
        * @return A new vector representing the difference between this vector and the other vector.
    */
    public Vec2 sub(Vec2 other) {
        return new Vec2(x - other.x, y - other.y);
    }

    /**
        * Multiplies this vector by a scalar.
        *
        * @param other The scalar value to multiply with.
        * @return A new vector representing the scaled vector.
    */
    public Vec2 mul(float other) {
        return new Vec2(x*other, y*other);
    }

    /**
        * Calculates the dot product of this vector with another vector.
        *
        * @param other The vector to calculate the dot product with.
        * @return The dot product of this vector and the other vector.
    */
    public float dot(Vec2 other) {
        return x*other.x + y*other.y;
    }

    /**
        * Returns a string representation of the vector in the format "(x, y)".
        *
        * @return A string representation of the vector.
    */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
