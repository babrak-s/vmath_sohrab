package vmath;

public class Vec4 {
    private final float x, y, z, w;

    public Vec4() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public Vec4(float x, float y, float z, float w) {
        if (Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z) || Float.isNaN(w)) {
            throw new ArithmeticException();
        }
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
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

    public float w() {
        return w;
    }

    public float mag() {
        return (float) Math.sqrt(x*x + y*y + z*z + w*w);
    }

    public float magSqr() {
        return x*x + y*y + z*z + w*w;
    }

    public Vec4 norm() {
        float norm = 1.0f / (float) Math.sqrt(x*x + y*y + z*z + w*w);
        return new Vec4(x*norm, y*norm, z*norm, w*norm);
    }

    public Vec4 add(Vec4 other) {
        return new Vec4(x + other.x, y + other.y, z + other.z, w + other.w);
    }

    public Vec4 sub(Vec4 other) {
        return new Vec4(x - other.x, y - other.y, z - other.z, w - other.w);
    }

    public Vec4 mul(float scalar) {
        return new Vec4(x*scalar, y*scalar, z*scalar, w*scalar);
    }

    public float dot(Vec4 other) {
        return x*other.x + y*other.y + z*other.z + w*other.w;
    }

    public Vec4 lerp(Vec4 other, float t) {
        float newX = (1 - t)*x + t*other.x;
        float newY = (1 - t)*y + t*other.y;
        float newZ = (1 - t)*z + t*other.z;
        float newW = (1 - t)*w + t*other.w;
        return new Vec4(newX, newY, newZ, newW);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + w + ")";
    }
}
