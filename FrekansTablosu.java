package FrekansTablosu;

import java.util.Scanner;

class dizi {

    Scanner s = new Scanner(System.in);
    ;
    int say = s.nextInt();

    int[] sayi;
    int n;
    int R;
    int k;
    int h;

    int lim[];
    int lim1[];
    double sin[];
    double sin1[];
    int sinf[];
    int ek[];
    int sayacd[];

    public dizi() {
        //this.s = new Scanner(System.in);
        //this.say = s.nextInt();
        this.sayi = new int[say];
        this.n = sayi.length;
        this.R = sayi[sayi.length - 1] - sayi[0];
        this.k = (int) Math.sqrt(n) + 1;
        this.h = (int) (R / k) + 1;
        this.lim = new int[k];
        this.lim1 = new int[k];
        this.sin = new double[k];
        this.sin1 = new double[k];
        this.sinf = new int[k];
        this.ek = new int[k];
        this.sayacd = new int[100000];
    }

    public int[] sirala(int[] A, int n) {
        int min = 0;
        int tmp;
        int i;
        int j;
        for (i = 0; i < n - 1; i++) {
            min = i;
            for (j = i; j < n; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            tmp = A[i];
            A[i] = A[min];
            A[min] = tmp;
        }
        System.out.println("Siralanmis Dizi :");
        System.out.println("--------------------------");
        for (int k = 0; k < n; k++) {
            System.out.print(" " + A[k]);
        }
        System.out.println("");
        return A;
    }

    public void olustur() {
        System.out.println("Dizi Boyutu : " + sayi.length);
        System.out.println("Dizi Elemanlari Girisi ");
        for (int i = 0; i < sayi.length; i++) {
            sayi[i] = s.nextInt();
        }
    }

    public void frekansBul() {

        int sayac = 0, j;
        System.out.println("Frekans Serisi");
        System.out.println("--------------------------");
        System.out.println("Xi " + "Fi");
        for (int i = 0; i < sayi.length * 1000; i++) {
            sayac = 0;
            for (j = 0; j < sayi.length; j++) {
                if (i == sayi[j]) {
                    sayac++;
                }
            }

            if (sayac != 0) {
                sayacd[i] = sayac;
                System.out.println(i + " " + sayacd[i]);
            }
        }
        System.out.println("");
        System.out.println("--------------------------");
    }

    public void SinifLimitleri() {

        int i, j;
        n = sayi.length;
        R = sayi[sayi.length - 1] - sayi[0];

        k = (int) Math.sqrt(n) + 1;

        //k = k + 1;
        h = (int) (R / k) + 1;

        //System.out.println("here " + h + " " + R);
        lim[0] = sayi[0];
        lim1[0] = sayi[0] + (h - 1);
        System.out.println("Sınıf Limitleri");
        System.out.println("--------------------------");
        System.out.println("" + lim[0] + " " + lim1[0]);
        for (i = 1; i < k; i++) {
            lim[i] = lim[i - 1] + h;
            lim1[i] = lim1[i - 1] + h;
            System.out.println("" + lim[i] + " " + lim1[i]);
        }
        System.out.println("--------------------------");
    }

    public void sinifSinirlari() {
        int i;
        System.out.println("Sınıf Sınırları");
        System.out.println("--------------------------");

        sin[0] = ((double) (lim[0] + (lim[0] - 1)) / 2);
        sin1[0] = ((double) (lim[1] + lim1[0]) / 2);
        //sin1[0] = sin[0] + h;
        System.out.println("" + sin[0] + " " + sin1[0]);
        for (i = 1; i < k; i++) {
            sin[i] = sin[i - 1] + h;
            sin1[i] = sin1[i - 1] + h;
            //sin1[i] = 0;
            System.out.println("" + sin[i] + " " + sin1[i]);
        }
        System.out.println("--------------------------");
    }

    public void sinifFrekanslari() {
        int i, sayac = 0, j;

        System.out.println("Sınıf Frekansı");
        System.out.println("--------------------------");
        for (j = 0; j < k; j++) {
            sayac = 0;
            for (i = 0; i < sayi.length; i++) {
                if ((double) sayi[i] > sin[j] && (double) sayi[i] < sin1[j]) {
                    sayac++;
                }
            }
            //if (sayac != 0) {
            sinf[j] = sayac;
            System.out.println("" + sayac);

            //}
        }
        System.out.println("--------------------------");
    }

    public void sinifOrtaNoktasi() {
        int i;
        System.out.println("Sınıf Orta Noktası");
        System.out.println("--------------------------");

        for (i = 0; i < k; i++) {
            System.out.println("" + ((sin[i] + sin1[i]) / 2));
        }
        System.out.println("--------------------------");
    }

    public void eklenikFrekans() {
        ek[0] = sinf[0];
        ek[1] = sinf[0] + sinf[1];
        System.out.println("Sınıf Eklenik Frekansı");
        System.out.println("--------------------------");
        System.out.println("" + ek[0] + "\n" + ek[1]);
        for (int i = 2; i < k; i++) {
            ek[i] = ek[i - 1] + sinf[i];
            System.out.println("" + ek[i]);
        }
        System.out.println("--------------------------");
    }

    public void oransalFrekans() {
        System.out.println("Sınıf Oransal Frekansı");
        System.out.println("--------------------------");
        for (int i = 0; i < k; i++) {
            System.out.println("" + (sinf[i] / (double) sayi.length));
        }
        System.out.println("--------------------------");
    }

    public void oransalEklenikFrekans() {
        System.out.println("Sınıf Oransal Eklenik Frekansı");
        System.out.println("--------------------------");
        for (int i = 0; i < k; i++) {
            System.out.println("" + (ek[i] / (float) sayi.length));
        }
        System.out.println("--------------------------");
    }

    public void dortteBirlikler() {
        double n1 = 0, j1, fQ1 = 0, L1 = 0, a, b;
        double Q1, Q3, toplam = 0;
        double n3 = 0, j3, fQ3 = 0, L3 = 0;
        int i = 0, sayac = 0, z, sayac1 = 0;
        a = (double) n / 4;
        b = (double) n * 3 / 4;

        /* Q1 */
        for (i = 0; i < k; i++) {
            if (toplam <= a) {
                toplam += (double) sinf[i];
                sayac++;
            }
            L1 = sin[sayac - 1];
            fQ1 = sinf[sayac - 1];
        }

        for (int j = 0; j < (sayac - 1); j++) {
            n1 += sinf[j];
        }

        j1 = a - n1;
        Q1 = L1 + (j1 * h / fQ1);
        System.out.println("Q1 : " + Q1);
        toplam = 0;

        /* Q3 */
        for (z = 0; z < k; z++) {
            if (toplam <= b) {
                toplam += (double) sinf[z];
                ++sayac1;
            }
            L3 = sin[sayac1 - 1];
            fQ3 = sinf[sayac1 - 1];
        }
        for (int k = 0; k < (sayac1 - 1); k++) {
            n3 += sinf[k];
        }
        j3 = b - n3;
        Q3 = L3 + (j3 * h / fQ3);
        System.out.println("Q3 : " + Q3);
    }
}
public class FrekansTablosu {
    public static void main(String[] args) {
        System.out.print("Dizi Boyutu Girisi : ");
        dizi d = new dizi();
        d.olustur();
        d.sirala(d.sayi, d.sayi.length);
        d.frekansBul();
        d.SinifLimitleri();
        d.sinifSinirlari();
        d.sinifFrekanslari();
        d.sinifOrtaNoktasi();
        d.eklenikFrekans();
        d.oransalFrekans();
        d.oransalEklenikFrekans();
        d.dortteBirlikler();
    }
}
