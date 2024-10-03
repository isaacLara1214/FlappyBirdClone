public class Matrix4f  {

    public static final int SIZE = 4 * 4;
    public float[] elements = new float[SIZE];

    public Matrix4f() {

    }

    public static Matrix4f identity() {
        Matrix4f identityMatrix = new Matrix4f();
        // make sure every entry is zero
        for (int i = 0; i < SIZE; i++) {
            identityMatrix.elements[i] = 0.0f;
        }

        // sets the diagonal to 1
        identityMatrix.elements[0 + 0 * 4] = 1.0f;
        identityMatrix.elements[0 + 1 * 4] = 1.0f;
        identityMatrix.elements[0 + 2 * 4] = 1.0f;
        identityMatrix.elements[0 + 3 * 4] = 1.0f;

        return identityMatrix;
    }

    public static Matrix4f orethographic(float left, float top, float right, float bottom, float far, float near) {
        Matrix4f orethographicMatrix = identity();

        orethographicMatrix.elements[0 + 0 * 4] = 2.0f / (right - left);
        orethographicMatrix.elements[1 + 1 * 4] = 2.0f / (right - left);
        orethographicMatrix.elements[2 + 2 * 4] = 2.0f / (right - left);

        orethographicMatrix.elements[0 + 3 * 4] = (left + right) / (left - right);
        orethographicMatrix.elements[1 + 3 * 4] = (bottom + top) / (bottom - top);
        orethographicMatrix.elements[2 + 3 * 4] = (far + near) / (far - near);

        return orethographicMatrix;
    }

    public static Matrix4f translate(Vector3f vector) {
        Matrix4f translatedMatrix = identity();
        translatedMatrix.elements[0 + 3 * 4] = vector.x;
        translatedMatrix.elements[1 + 3 * 4] = vector.y;
        translatedMatrix.elements[2 + 3 * 4] = vector.z;

        return translatedMatrix;
    }

    public static Matrix4f rotate(float angle) {
        Matrix4f rotatedMatrix = identity();
        float rads = (float) Math.toRadians(angle);
        float cos = (float) Math.cos(rads);
        float sin = (float) Math.sin(rads);

        rotatedMatrix.elements[0 + 0 * 4] = cos;
        rotatedMatrix.elements[1 + 0 * 4] = sin;
        rotatedMatrix.elements[0 + 1 * 4] = -sin;
        rotatedMatrix.elements[1 + 1 * 4] = cos;

        return rotatedMatrix;
    }


}
