package basitornekleme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BasitOrnekleme {

    int sayac = 0, i, j;
    Scanner s = new Scanner(System.in);
    Scanner s1 = new Scanner(System.in);
    Scanner s2 = new Scanner(System.in);

    int say = s.nextInt();
    int xMin = s1.nextInt();
    int xMax = s2.nextInt();

    ArrayList<Integer> sayi = new ArrayList<>();
    //int sayacd[] = new int[say];
    //sayi = ;

    public void Olustur() {
        if (xMax > xMin) {
            while (sayac < say) {
                int uretilenSayi = (int) (xMin + Math.random() * (xMax - xMin));

                if (xMax - xMin >= say) {
                    if (sayi.indexOf(uretilenSayi) == -1) {
                        sayi.add(uretilenSayi);
                        sayac++;
                    }
                }
                if (xMax - xMin <= say) {
                    sayi.add(uretilenSayi);
                    sayac++;
                }
            }

            Collections.sort(sayi);
            for (int i = 0; i < sayi.size(); i++) {
                System.out.print(" " + sayi.get(i));
            }
        } else {
            System.out.println("Dizi Olusturulamadi ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Dizi Boyutu, xMin, xMax : ");
        BasitOrnekleme b = new BasitOrnekleme();
        b.Olustur();

    }
}
