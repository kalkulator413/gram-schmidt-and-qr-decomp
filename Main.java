import gramSchmidt.GramSchmidt;
import gramSchmidt.Vector;

public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(1, 0, 0, 0);
        Vector v2 = new Vector(1, 1, 0, 0);
        Vector v3 = new Vector(1, 0, 3, 4);
        System.out.println(GramSchmidt.gramSchmidt(v1, v2, v3));
    }
}
