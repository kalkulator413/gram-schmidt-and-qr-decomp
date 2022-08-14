import gramSchmidt.Basis;
import gramSchmidt.GramSchmidt;
import gramSchmidt.Vector;

import org.junit.Test;
import static org.junit.Assert.*;

public class Main {

    @Test
    public void test() {
        Vector v1 = new Vector(1, 0, 0, 0);
        Vector v2 = new Vector(1, 1, 0, 0);
        Vector v3 = new Vector(1, 0, 3, 4);

        Vector u1 = new Vector(1, 0, 0, 0);
        Vector u2 = new Vector(0, 1, 0, 0);
        Vector u3 = new Vector(0, 0, 0.6, 0.8);
        Basis U = new Basis(u1, u2, u3);

        assertEquals(U, GramSchmidt.gramSchmidt(v1, v2, v3));
    }

}
