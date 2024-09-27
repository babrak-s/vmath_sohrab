package vmath;

public class Mat2 {
    private final float[] m;

    public Mat2() {
        m = new float[] {
            1.0f, 0.0f,
            0.0f, 1.0f
        };
    }

    public Mat2(float m00, float m01,
                float m10, float m11) {
        if (Float.isNaN(m00) || Float.isNaN(m01) ||
            Float.isNaN(m10) || Float.isNaN(m11)) {
            throw new ArithmeticException();
        }
        m = new float[] {
            m00, m01,
            m10, m11
        };
    }

    public Mat2 mul(Mat2 other){
        float m00, m01, m10, m11;
        m00 = m[0]*other.m[0] + m[1]*other.m[2];
        m01 = m[0]*other.m[1] + m[1]*other.m[3];
        m10 = m[2]*other.m[0] + m[3]*other.m[2];
        m11 = m[2]*other.m[1] + m[3]*other.m[3];
        return new Mat2(m00, m01, m10, m11);
    }

    public Mat2(float[] m) {
        if (m == null || m.length != 4) {
            throw new IllegalArgumentException();
        }
        for (float value : m) {
            if (Float.isNaN(value)) {
                throw new ArithmeticException();
            }
        }
        this.m = m.clone();
    }
  
    public float get(int i, int j) {
        if (i < 0 || i >= 2 || j < 0 || j >= 2) {
            throw new IndexOutOfBoundsException();
        }
        return m[i * 2 + j];
    }

    public Vec2 mul(Vec2 other) {
        return new Vec2(
            other.x()*m[0] + other.y()*m[1],
            other.x()*m[2] + other.y()*m[3]
        );
    }
  
    public float[] toArray() {
        return m.clone();
    }
  
    @Override
    public String toString() {
        return "(" + m[0]  + ", " + m[1]  + ")" + "\n" +
               "(" + m[2]  + ", " + m[3]  + ")";
    }
}
