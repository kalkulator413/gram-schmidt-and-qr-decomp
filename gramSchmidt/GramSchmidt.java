package gramSchmidt;

public class GramSchmidt {

    public static Basis gramSchmidt(Vector... vectors) {
        Basis currBasis = new Basis();
        for (Vector v_i : vectors) {
            Vector proj = Vector.projAOntoB(v_i, currBasis);
            Vector u_i = Vector.subtract(v_i, proj);
            if (!u_i.equals(Vector.zeroVector(u_i.dimension()))) {
                currBasis.add(u_i);
            }
        }
        for (Vector v : currBasis) {
            v.normalize();
        }
        return currBasis;
    }
}
