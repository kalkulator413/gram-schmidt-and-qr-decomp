package gramSchmidt;

import java.util.Arrays;

public class Vector {

    private double[] vals;

    public Vector (double[] coords) {
        vals = new double[coords.length];
        System.arraycopy(coords, 0, vals, 0, coords.length);
    }

    public Vector(int... coords) {
        vals = new double[coords.length];
        for (int i = 0; i < coords.length; i ++) {
            vals[i] = coords[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("(");
        for (double val: vals) {
            res.append(val).append(" ");
        }
        res.replace(res.length() - 1, res.length() - 1, ")");
        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector)) {
            return false;
        }
        Vector v = (Vector) o;
        return Arrays.equals(v.vals, vals);
    }

    public int dimension() {
        return vals.length;
    }

    //use the standard dot product as the inner product
    public double norm() {
        return Math.sqrt(dotProduct(this, this));
    }

    public double normSquared() {
        return dotProduct(this, this);
    }

    public void normalize() {
        Vector v = normalize(this);
        this.vals = v.vals;
    }

    public static Vector add(Vector v1, Vector v2) {
        if (v1.dimension() != v2.dimension()) {
            throw new IllegalArgumentException("Can't add vectors of different sizes");
        }
        Vector result = zeroVector(v1.dimension());
        for (int i = 0; i < v1.dimension(); i ++) {
            result.vals[i] = v1.vals[i] + v2.vals[i];
        }
        return result;
    }

    public static Vector scale(Vector v1, double scalar) {
        Vector result = zeroVector(v1.dimension());
        for (int i = 0; i < v1.dimension(); i ++) {
            result.vals[i] = scalar * v1.vals[i];
        }
        return result;
    }


    public static Vector subtract(Vector v1, Vector v2) {
        return add(v1, scale(v2, -1));
    }

    public static double dotProduct(Vector a, Vector b) {
        double cumSum = 0;
        for (int i = 0; i < a.dimension(); i ++) {
            cumSum += a.vals[i]*b.vals[i];
        }
        return cumSum;
    }

    public static Vector projAOntoB(Vector a, Vector b) {
        if (a.dimension() != b.dimension()) {
            throw new IllegalArgumentException("Can't find projection with vectors of different sizes");
        }
        if (b.equals(zeroVector(b.dimension()))) {
            return zeroVector(b.dimension());
        }
        double scalar = dotProduct(a, b) / b.normSquared();
        return scale(b, scalar);
    }

    public static Vector normalize(Vector a) {
        return scale(a, 1 / a.norm());
    }

    public static Vector projAOntoB(Vector a, Basis V) {
        Basis copy = new Basis(V);
        if (V.isEmpty()) {
            return zeroVector(a.dimension());
        }
        Vector curr = projAOntoB(a, copy.pop());
        return add(curr, projAOntoB(a, copy));
    }

    public static Vector zeroVector(int size) {
        return new Vector(new double[size]);
    }

}
