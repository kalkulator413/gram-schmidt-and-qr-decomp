package QRDecomp;

import gramSchmidt.Basis;
import gramSchmidt.GramSchmidt;
import gramSchmidt.Vector;

import java.util.Arrays;

public class Matrix {

    Vector[] columns;
    int height;
    int width;

    public Matrix(Vector... columns) {
        width = columns.length;
        height = columns[0].dimension();
        this.columns = new Vector[width];
        System.arraycopy(columns, 0, this.columns, 0, columns.length);
    }

    public Matrix[] QRDecomp() {
        Basis U = GramSchmidt.gramSchmidt(columns);
        Vector[] newCols = new Vector[width];
        int counter = 0;
        for (Vector v : U) {
            newCols[counter] = v;
            counter += 1;
        }
        Matrix Q = new Matrix(newCols);
        Matrix QTranspose = Q.transpose();

        Matrix R = multiply(QTranspose, this);
        return new Matrix[]{Q, R};
    }

    public Matrix transpose() {
        Vector[] newCols = new Vector[height];

        for (int i = 0; i < height; i ++) {
            double[] currVals = new double[width];
            for (int j = 0; j < width; j ++) {
                currVals[j] = columns[j].get(i);
            }
            newCols[i] = new Vector(currVals);
        }
        return new Matrix(newCols);
    }

    public static Matrix multiply(Matrix A, Matrix B) {
        if (A.width != B.height) {
            throw new IllegalArgumentException("A's # of cols must be equal to B's # of rows");
        }
        Vector[] newCols = new Vector[B.width];
        //A * bi
        for (int i = 0; i < newCols.length; i ++) {
//            B.columns[i];
            Vector currCol = Vector.zeroVector(A.height);
            for (int j = 0; j < B.height; j ++) {
                Vector col = Vector.scale(A.columns[j], B.columns[i].get(j));
                currCol = Vector.add(currCol, col);
            }
            newCols[i] = currCol;
        }
        return new Matrix(newCols);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < height; i ++) {
            result.append("|");
            for (int j = 0; j < width; j ++) {
                result.append(columns[j].get(i)).append(" ");
            }
            result.deleteCharAt(result.length() - 1);
            result.append("|\n");
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Matrix m)) {
            return false;
        }
        return Arrays.equals(m.columns, columns);
    }
}
