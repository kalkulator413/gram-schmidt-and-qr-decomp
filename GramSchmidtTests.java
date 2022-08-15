import gramSchmidt.Basis;
import gramSchmidt.GramSchmidt;
import gramSchmidt.Vector;

import org.junit.Test;
import static org.junit.Assert.*;

public class GramSchmidtTests {

    @Test
    public void threeVectors() {
        Vector v1 = new Vector(1, 0, 0, 0);
        Vector v2 = new Vector(1, 1, 0, 0);
        Vector v3 = new Vector(1, 0, 3, 4);

        Vector u1 = new Vector(1, 0, 0, 0);
        Vector u2 = new Vector(0, 1, 0, 0);
        Vector u3 = new Vector(0, 0, 0.6, 0.8);
        Basis U = new Basis(u1, u2, u3);

        assertEquals(U, GramSchmidt.gramSchmidt(v1, v2, v3));
    }

    @Test
    public void oneVector() {
        Vector v = new Vector(1, 2, 3);
        assertEquals(GramSchmidt.gramSchmidt(v).dimension(), 1);
        assertEquals(Vector.normalize(v), GramSchmidt.gramSchmidt(v).get(0));
    }

    @Test
    public void fiveVectors() {
        Vector v1 = new Vector(1, 0, 0, 0, 0, 0, 0);
        Vector v2 = new Vector(0, 12, 0, 0, 0, 0, 7);
        Vector v3 = new Vector(0, 0, 3, 0, 0, 4, 0);
        Vector v4 = new Vector(0, 0, 0, 1, 0, 0, 0);
        Vector v5 = new Vector(0, 0, 0, 0, 1, 0, 0);

        Vector u1 = new Vector(1, 0, 0, 0, 0, 0, 0);
        Vector u2 = new Vector(0, 0.864, 0, 0, 0, 0, 0.504);
        Vector u3 = new Vector(0, 0, 0.6, 0, 0, 0.8, 0);
        Vector u4 = new Vector(0, 0, 0, 1, 0, 0, 0);
        Vector u5 = new Vector(0, 0, 0, 0, 1, 0, 0);
        Basis U = new Basis(u1, u2, u3, u4, u5);

        assertEquals(U, GramSchmidt.gramSchmidt(v1, v2, v3, v4, v5));
    }

    @Test
    public void standardBasis() {
        Vector v1 = new Vector(1, 0, 0, 0);
        Vector v2 = new Vector(0, 1, 0, 0);
        Vector v3 = new Vector(0, 0, 1, 0);
        Vector v4 = new Vector(0, 0, 0, 1);
        Basis E_4 = new Basis(v1, v2, v3, v4);

        assertEquals(E_4, GramSchmidt.gramSchmidt(v1, v2, v3, v4));
    }

    @Test
    public void linearlyDependent() {
        Vector v1 = new Vector(1, 0, 0, 0);
        Vector v2 = new Vector(0, 1, 0, 0);
        Vector v3 = new Vector(0, 0, 1, 0);
        Vector v4 = new Vector(1, 1, 1, 0);

        Basis E_4 = new Basis(v1, v2, v3);

        assertEquals(E_4, GramSchmidt.gramSchmidt(v1, v2, v3, v4));
    }

}
