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

    public float mag() {
        return (float) Math.sqrt(x*x + y*y);
    }

    public Vec2 norm() {
        float norm = 1.0f / (float) Math.sqrt(x*x + y*y);
        return new Vec2(x*norm, y*norm);
    }

    public Vec2 add(Vec2 other) {
        return new Vec2(x + other.x, y + other.y);
    }

    public Vec2 sub(Vec2 other) {
        return new Vec2(x - other.x, y - other.y);
    }

    public Vec2 mul(float other) {
        return new Vec2(x*other, y*other);
    }

    public float dot(Vec2 other) {
        return x*other.x + y*other.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
