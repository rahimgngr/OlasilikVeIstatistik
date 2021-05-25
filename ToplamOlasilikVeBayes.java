package ToplamOlasilikVeBayes;

import java.util.Scanner;

/**
 *
 * @author rahimgng
 */
public class ToplamOlasilikVeBayes {

    Scanner s = new Scanner(System.in);
    int boyut = s.nextInt();
    Scanner s1 = new Scanner(System.in);
    double dizi1[] = new double[boyut];
    double dizi2[] = new double[boyut];
    double secim;

    public ToplamOlasilikVeBayes() {
        this.boyut = boyut;
        this.secim = secim;
    }

    public void topOsveB() {
        double topOs = 0.0, bayes = 0.0;
        System.out.println("Ai olasılık degerleri : ");
        for (int i = 0; i < boyut; i++) {
            dizi1[i] = s.nextDouble();
        }
        System.out.println("X-Ai olasılık degerleri : ");
        for (int j = 0; j < boyut; j++) {
            dizi2[j] = s.nextDouble();
        }
        for (int k = 0; k < boyut; k++) {
            topOs += dizi1[k] * dizi2[k];
        }

        System.out.println("Kacinci sayinin Bayes'i :");
        Scanner s1 = new Scanner(System.in);
        secim = s1.nextDouble();
        for (int a = 0; a < boyut; a++) {
            if (a == (secim - 1)) {
                bayes = dizi1[a] * dizi2[a] / topOs;
            }
        }

        System.out.println("Toplam Olasilik : " + topOs);
        System.out.println("Bayes : " + bayes);
    }

    public static void main(String[] args) {
        System.out.println("n değeri : ");
        ToplamOlasilikVeBayes t = new ToplamOlasilikVeBayes();
        t.topOsveB();
    }

}
