package gramSchmidt;

public class GramSchmidt {

    public static VectorSet gramSchmidt(Vector... vectors) {
        VectorSet currBasis = new VectorSet();
        for (Vector v_i : vectors) {
            Vector proj = Vector.projAOntoB(v_i, currBasis);
            Vector u_i = Vector.subtract(v_i, proj);
            currBasis.add(u_i);
        }
        for (Vector v : currBasis) {
            v.normalize();
        }
        return currBasis;
    }


    public static void main(String[] args) {
        Vector v1 = new Vector(1, 0, 0, 0);
        Vector v2 = new Vector(1, 1, 0, 0);
        Vector v3 = new Vector(1, 0, 3, 4);
        System.out.println(gramSchmidt(v1, v2, v3));
    }
}
