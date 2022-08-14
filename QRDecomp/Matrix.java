package QRDecomp;

import gramSchmidt.Vector;

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

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j ++) {
                result += columns[j].get(i);
            }
            result = result.substring(result.length() - 2);
            result += "\n";
        }
        return result;
    }
}
