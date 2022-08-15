import QRDecomp.Matrix;
import gramSchmidt.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class QRDecompTests {

    @Test
    public void test1() {
        Vector v1 = new Vector(1, 0, 0, 0);
        Vector v2 = new Vector(1, 1, 0, 0);
        Vector v3 = new Vector(1, 0, 3, 4);
        Matrix V = new Matrix(v1, v2, v3);
        Matrix[] QR = V.QRDecomp();

        Vector q1 = new Vector(1, 0, 0, 0);
        Vector q2 = new Vector(0, 1, 0, 0);
        Vector q3 = new Vector(0, 0, 0.6, 0.8);
        assertEquals(QR[0], new Matrix(q1, q2, q3));

        Vector r1 = new Vector(1, 0, 0);
        Vector r2 = new Vector(1, 1, 0);
        Vector r3 = new Vector(1, 0, 5);
        assertEquals(QR[1], new Matrix(r1, r2, r3));

        assertEquals(Matrix.multiply(QR[0], QR[1]), V);
    }

    @Test
    public void test2() {
        Vector v1 = new Vector(1, 0);
        Vector v2 = new Vector(3, 4);
        Vector v3 = new Vector(0, 1);
        Matrix V = new Matrix(v1, v2, v3);
        Matrix[] QR = V.QRDecomp();

        Vector q1 = new Vector(1, 0);
        Vector q2 = new Vector(0, 1);
        assertEquals(QR[0], new Matrix(q1, q2));

        Vector r1 = new Vector(1, 0);
        Vector r2 = new Vector(3, 4);
        Vector r3 = new Vector(0, 1);
        assertEquals(QR[1], new Matrix(r1, r2, r3));

        assertEquals(V, Matrix.multiply(QR[0], QR[1]));
    }
}
