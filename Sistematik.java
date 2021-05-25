package sistematik;

import java.util.Scanner;

/**
 *
 * @author rahimgng
 */
public class Sistematik {

    Scanner a = new Scanner(System.in);
    //int boyut = a.nextInt();
    //int [] dizi = new int[100];

    public void Olustur() {
        System.out.println("N ve n degerleri ");
        int N = 0, n = 0, k, b;

        //for(int i = 0; i < 2 ; i++){
        N = a.nextInt();
        n = a.nextInt();
        //}
        k = N / n;

        b = (int) (1 + Math.random() * (k - 1));
        System.out.println("k degeri : "+k + ", b degeri :"+b);
        for (int j = 0; j < (n); j++) {
            //dizi[j] = (int) (1 + Math.random() * (k));
            System.out.println("Sistematik Rastgele Ornekleme : " + (b + (j * k)));
        }

    }

    public static void main(String[] args) {
        //System.out.println("Dizi Boyutu");
        Sistematik s = new Sistematik();
        s.Olustur();
    }

}
