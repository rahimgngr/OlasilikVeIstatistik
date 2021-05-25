/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permcomb;

import java.util.Scanner;

/**
 *
 * @author rahimgng
 */
public class PermComb {

    Scanner s = new Scanner(System.in);
    Scanner s1 = new Scanner(System.in);
    //Scanner s2 = new Scanner(System.in);

    int N = s.nextInt();
    int r = s1.nextInt();
    //int sayi = s2.nextInt();

    public int faktoriyel(int sayi) {
        int faktoriyel = 1;
        for (int i = 1; i <= sayi; i++) {
            faktoriyel = faktoriyel * i;

        }
        return faktoriyel;
    }

    public void permutasyon() {
        int perm;
        int a = N - r;
        
        perm = faktoriyel(N) / faktoriyel(N - r);
        System.out.println("Permutasyon : " + perm);
    }
    
    public void combina() {
        int comb;
        //int a = N - r; 
        
        comb = faktoriyel(N) / (faktoriyel(r) * faktoriyel(N - r));
        System.out.println("Kombinasyon : " + comb);
    }

    public static void main(String[] args) {
        System.out.println("N ve r degerleri :");
        PermComb p = new PermComb();

        p.permutasyon();
        p.combina();
    }

}
