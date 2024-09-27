package vmath;

public class Vec2 {
    private final float x;
    private final float y;

    public Vec2() {
        this(0.0f, 0.0f);
    }

    public Vec2(float x, float y) {
        if (Float.isNaN(x) || Float.isNaN(y)) {
            throw new ArithmeticException();
        }
        this.x = x;
        this.y = y;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public float mag() {
        return (float) Math.sqrt(x*x + y*y);
    }

    public float magSqr() {
        return x*x + y*y;
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

    public Vec2 lerp(Vec2 other, float t) {
        float newX = (1 - t)*x + t*other.x;
        float newY = (1 - t)*y + t*other.y;
        return new Vec2(newX, newY);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
