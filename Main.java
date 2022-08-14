import QRDecomp.Matrix;
import gramSchmidt.Vector;

public class Main {
    public static void main(String[] args) {
        //columns of A
        Vector a1 = new Vector(1, 0, 0, 0);
        Vector a2 = new Vector(1, 1, 0, 0);
        Vector a3 = new Vector(1, 0, 3, 4);
        Matrix A = new Matrix(a1, a2, a3);

        System.out.println("A = \n" + A);

        Matrix[] QR = A.QRDecomp();
        System.out.println("Q = \n" + QR[0]);
        System.out.println("R = \n" + QR[1]);

        System.out.println("QR = \n" + Matrix.multiply(QR[0], QR[1]));
    }
}
