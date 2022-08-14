package gramSchmidt;

import java.util.*;

public class Basis implements Iterable<Vector> {

    public List<Vector> vectors;

    public Basis() {
        vectors = new ArrayList<>();
    }

    public Basis(Basis V) {
        vectors = new ArrayList<>(V.vectors);
    }

    public Basis(Vector... vectors) {
        this.vectors = Arrays.asList(vectors);
    }

    public Vector get(int index) {
        if (index >= vectors.size() || index < 0) {
            throw new IllegalArgumentException();
        }
        return vectors.get(index);
    }

    public boolean isEmpty() {
        return vectors == null || vectors.size() == 0;
    }

    public static Basis span(Vector... vectors) {
        Basis V = new Basis();
        V.vectors = Arrays.asList(vectors);
        return V;
    }

    public Vector pop(int i) {
        return vectors.remove(i);
    }

    public void add(Vector v, int i) {
        vectors.add(i, v);
    }

    public void add(Vector v) {
        vectors.add(vectors.size(), v);
    }

    public Vector pop() {
        return pop(0);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Vector v : this) {
            res.append(v).append("\n");
        }
        if (res.length() >= 2) {
            res.delete(res.length() - 2, res.length());
        }
        return res.toString();
    }

    @Override
    public Iterator<Vector> iterator() {
        return vectors.iterator();
    }
}
