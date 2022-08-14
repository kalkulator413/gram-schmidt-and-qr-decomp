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
        Matrix M = new Matrix(v1, v2, v3);

        System.out.println(M);
    }
}
