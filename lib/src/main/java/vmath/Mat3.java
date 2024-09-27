package vmath;

public class Mat3 {
    private final float[] m;

    public Mat3() {
        m = new float[] {
            1.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 1.0f
        };
    }

    public Mat3(float m00, float m01, float m02,
                float m10, float m11, float m12,
                float m20, float m21, float m22) {
        if (Float.isNaN(m00) || Float.isNaN(m01) || Float.isNaN(m02) ||
            Float.isNaN(m10) || Float.isNaN(m11) || Float.isNaN(m12) ||
            Float.isNaN(m20) || Float.isNaN(m21) || Float.isNaN(m22)) {
            throw new ArithmeticException();
        }
        m = new float[] {
            m00, m01, m02,
            m10, m11, m12,
            m20, m21, m22
        };
    }

    public Mat3(float[] m) {
        if (m == null || m.length != 9) {
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
        if (i < 0 || i >= 3 || j < 0 || j >= 3) {
            throw new IndexOutOfBoundsException();
        }
        return m[i * 3 + j];
    }

    public Mat3 mul(Mat3 other) {
        Mat3 res = new Mat3();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                float sum = 0.0f;
                for (int k = 0; k < 3; k++) {
                    sum += this.get(i, k)*other.get(k, j);
                }
                res.m[i*3 + j] = sum;
            }
        }
        return res;
    }

    public Vec3 mul(Vec3 other) {
        return new Vec3(
            other.x()*m[0] + other.y()*m[1] + other.z()*m[2],
            other.x()*m[3] + other.y()*m[4] + other.z()*m[5],
            other.x()*m[6] + other.y()*m[7] + other.z()*m[8]
        );
    }
    
    public float[] toArray() {
        return m.clone();
    }
}
