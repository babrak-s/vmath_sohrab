package vmath;

public class Vec3 {
    private final float x, y, z;

    public Vec3() {
        this(0.0f, 0.0f, 0.0f);
    }

    public Vec3(float x, float y, float z) {
        if (Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z)) {
            throw new ArithmeticException();
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public float z() {
        return z;
    }

    public float mag() {
        return (float) Math.sqrt(x*x + y*y + z*z);
    }

    public float magSqr() {
        return x*x + y*y + z*z;
    }

    public Vec3 norm() {
        float norm = 1.0f / (float) Math.sqrt(x*x + y*y + z*z);
        return new Vec3(x*norm, y*norm, z*norm);
    }

    public Vec3 add(Vec3 other) {
        return new Vec3(x + other.x, y + other.y, z + other.z);
    }

    public Vec3 sub(Vec3 other) {
        return new Vec3(x - other.x, y - other.y, z - other.z);
    }

    public Vec3 mul(float scalar) {
        return new Vec3(x*scalar, y*scalar, z*scalar);
    }

    public float dot(Vec3 other) {
        return x*other.x + y*other.y + z*other.z;
    }

    public Vec3 cross(Vec3 other) {
        return new Vec3(
            y*other.z() - z*other.y(),
            z*other.x() - x*other.z(),
            x*other.y() - y*other.x()
        );
    }

    public float triple(Vec3 b, Vec3 c) {
        Vec3 bCrossC = b.cross(c);
        return this.dot(bCrossC);
    }

    public Vec3 lerp(Vec3 other, float t) {
        float newX = (1 - t)*x + t*other.x;
        float newY = (1 - t)*y + t*other.y;
        float newZ = (1 - t)*z + t*other.z;
        return new Vec3(newX, newY, newZ);
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
