package gramSchmidt;

import java.util.*;

public class VectorSet implements Iterable<Vector> {

    public List<Vector> vectors;

    public VectorSet() {
        vectors = new ArrayList<>();
    }

    public VectorSet (VectorSet V) {
        vectors = new ArrayList<>(V.vectors);
    }

    public VectorSet (Vector... vectors) {
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

    public static VectorSet span(Vector... vectors) {
        VectorSet V = new VectorSet();
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
