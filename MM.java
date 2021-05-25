package mm;

import java.util.Scanner;

/**
 *
 * @author rahimgng
 */
public class MM {

    int frekans = 0, i, k, mod;
    Scanner s = new Scanner(System.in);
    int boyut = s.nextInt();
    int[] dizi = new int[boyut];

    public void olustur() {
        for (int i = 0; i < boyut; i++) {
            dizi[i] = s.nextInt();
        }
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
        System.out.println(" ");
        System.out.println("--------------------------");
        return A;
    }

    public void mod() {
        for (i = 0; i < boyut; ++i) {
            int sayac = 0;
            for (k = 0; k < boyut; ++k) {
                if (dizi[k] == dizi[i]) {
                    ++sayac;
                }
            }
            if (sayac > frekans) {
                frekans = sayac;
                mod = dizi[i];
            }
        }
        System.out.println("Mod : " + mod + ", Tekrarlanma Sayisi : " + frekans);
    }

    public void medyan() {
        double medyan;
        int a;
        if (boyut % 2 != 0) {
            a = (boyut + 1) / 2;
            System.out.println("Medyan Degeri : " + (double) dizi[a - 1]);
        } else {
            a = dizi[(boyut / 2) - 1] + dizi[(boyut / 2)];
            System.out.println("Medyan Degeri : " + a);
        }
    }

    public int[] arO(int A[]) {
        double toplam = 0;
        for (int i = 0; i < boyut; i++) {
            toplam += A[i];
        }
        toplam /= boyut;
        System.out.println("Artmetik Ortalama : " + toplam);
        return A;
    }

    public int[] geO(int A[]) {
        int carpim = 1;
        for (int i = 0; i < boyut; i++) {
            carpim *= A[i];
        }
        double sayi = Math.pow(carpim, (1.0 / (double) (boyut)));
        sayi = Math.ceil(sayi);
        System.out.println("Geometrik Ortalama : " + sayi);
        return A;
    }

    public int[] haO(int A[]) {
        double toplam;
        toplam = 0;
        for (int i = 0; i < boyut; i++) {
            toplam += (1 / (double) A[i]);
        }
        double sayi = boyut / toplam;
        //sayi = Math.ceil(sayi);
        System.out.println("Harmonik Ortalama : " + sayi);
        return A;
    }

    public int[] ornV(int A[]) {
        double aro = 0, orv = 0, ss = 0,deg;
        for (int i = 0; i < boyut; i++) {
            aro += A[i];
        }
        aro /= boyut;

        for (int j = 0; j < boyut; j++) {
            orv += Math.pow((double) A[j] - aro, 2);
        }
        orv /= (boyut - 1);
        ss = Math.sqrt(orv);
        deg = ss / aro;

        System.out.println("Örneklem Varyansı : " + orv);
        System.out.println("Standart Sapma : " + ss);
        System.out.println("Degisim Katsayisi : " + deg);
        
        return A;
    }

    public int[] mutS(int A[]) {
        double aro = 0 , oms = 0;
        for (int i = 0; i < boyut; i++) {
            aro += A[i];
        }
        aro /= boyut;
        for(int j = 0; j < boyut; j++){
            oms += Math.abs(A[j] - aro);
        }
        oms /= boyut;
        
        System.out.println("Ortalama Mutlak Sapma : "+oms);
        return A;
    }
    public int[] carpO(int A[]) {
        double aro = 0,crp  = 0;
        for (int i = 0; i < boyut; i++) {
            aro += A[i];
        }
        aro /= boyut;

        for (int j = 0; j < boyut; j++) {
            crp += Math.pow((double) A[j] - aro, 3);
        }
        crp /= (boyut - 1);

        System.out.println("Carpıklık Olcutu : " + crp);
        return A;
    }
    public int[] basO(int A[]) {
        double aro = 0,bs  = 0;
        for (int i = 0; i < boyut; i++) {
            aro += A[i];
        }
        aro /= boyut;

        for (int j = 0; j < boyut; j++) {
            bs += Math.pow((double) A[j] - aro, 4);
        }
        bs /= (boyut - 1);

        System.out.println("Basiklik Olcutu : " + bs);
        return A;
    }

    public static void main(String[] args) {
        System.out.println("Dizi Boyutu ve Degerlerini Giriniz ");
        MM m = new MM();
        m.olustur();
        m.sirala(m.dizi, m.boyut);
        m.mod();
        m.medyan();
        m.arO(m.dizi);
        m.geO(m.dizi);
        m.haO(m.dizi);
        m.ornV(m.dizi);
        m.mutS(m.dizi);
        m.carpO(m.dizi);
        m.basO(m.dizi);
    }

}
