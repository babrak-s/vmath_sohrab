package vmath;

public class Mat4 {
    private final float[] m;

    public Mat4() {
        m = new float[] {
            1.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 1.0f
        };
    }

    public Mat4(float m00, float m01, float m02, float m03,
                float m10, float m11, float m12, float m13,
                float m20, float m21, float m22, float m23,
                float m30, float m31, float m32, float m33) {
        if (Float.isNaN(m00) || Float.isNaN(m01) || Float.isNaN(m02) || Float.isNaN(m03) ||
            Float.isNaN(m10) || Float.isNaN(m11) || Float.isNaN(m12) || Float.isNaN(m13) ||
            Float.isNaN(m20) || Float.isNaN(m21) || Float.isNaN(m22) || Float.isNaN(m23) ||
            Float.isNaN(m30) || Float.isNaN(m31) || Float.isNaN(m32) || Float.isNaN(m33)) {
            throw new ArithmeticException();
        }
        m = new float[] {
            m00, m01, m02, m03,
            m10, m11, m12, m13,
            m20, m21, m22, m23,
            m30, m31, m32, m33
        };
    }

    public Mat4(float[] m) {
        if (m == null || m.length != 16) {
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
        if (i < 0 || i >= 4 || j < 0 || j >= 4) {
            throw new IndexOutOfBoundsException();
        }
        return m[i * 4 + j];
    } 

    public Mat4 mul(Mat4 other) {
        Mat4 result = new Mat4();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                float value = 0.0f;
                for (int k = 0; k < 4; k++) {
                    value += this.get(i, k)*other.get(k, j);
                }
                result.m[i*4 + j] = value;
            }
        }
        return result;
    }    

    @Override
    public String toString() {
        return "(" + m[0]  + ", " + m[1]  + ", " + m[2]  + ", " + m[3]  + ")" + "\n" +
               "(" + m[4]  + ", " + m[5]  + ", " + m[6]  + ", " + m[7]  + ")" + "\n" +
               "(" + m[8]  + ", " + m[9]  + ", " + m[10] + ", " + m[11] + ")" + "\n" +
               "(" + m[12] + ", " + m[13] + ", " + m[14] + ", " + m[15] + ")";
    }

    public float[] toArray() {
        return m.clone();
    }
}
