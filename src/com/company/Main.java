package com.company;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sat, sut, zorluk, topele, puan = 0;
        double sonzorluk;
        Scanner scan = new Scanner(System.in);
        System.out.println("Oyunun Satır Büyüklüğünü Giriniz.");
        sat = scan.nextInt();
        System.out.println("Oyunun Sütun Büyüklüğünü Giriniz.");
        sut = scan.nextInt();
        topele = sut * sat;
        String[][] ktarla = new String[sat][sut];
        for (int i = 0; i < sat; i++) {
            for (int j = 0; j < sut; j++) {
                ktarla[i][j] = "*";
            }
        }
        int[][] tarla = new int[sat][sut];
        for (int i = 0; i < sat; i++) {
            for (int j = 0; j < sut; j++) {
                tarla[i][j] = 0;
            }
        }
        for (int i = 0; i < sat; i++) {
            for (int j = 0; j < sut; j++) {
                System.out.print(ktarla[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("20 ile 80 Arasında Zorluk Derecesini Giriniz.");
        zorluk = scan.nextInt();
        while (true) {
            if (zorluk < 20 || zorluk > 80) {
                System.out.println("Girilen Değer Uygun Değildir!");
                System.out.println("20 ile 80 Arasında Zorluk Derecesini Giriniz.");
                zorluk = scan.nextInt();
            } else {
                break;
            }
        }
        System.out.println("Girilen Zorluk Değeri %" + zorluk + ". Oyun Yapılandırılıyor.");
        sonzorluk = topele * ((double) zorluk / 100);
        int intsonzorluk = (int) sonzorluk;
        Random rnd = new Random();
        for (int i = 0; i < intsonzorluk; i++) {
            int bombsat = rnd.nextInt(sat);
            int bombsut = rnd.nextInt(sut);
            while (true) {
                if (tarla[bombsat][bombsut] == 1) {
                    bombsat = rnd.nextInt(sat);
                    bombsut = rnd.nextInt(sut);
                } else {
                    tarla[bombsat][bombsut] = 1;
                    break;
                }
            }
        }/* Mayınlar Kullanıcıya Gözükmesin Diye Yoruma alındı.
        for (int i = 0; i < sat; i++) {
            for (int j = 0; j < sut; j++) {
                System.out.print(tarla[i][j] + "  ");
            }
            System.out.println();
        }*/
        System.out.println(intsonzorluk + " Tane Mayın Yerleştirildi Oyun Başlıyor...");
        // Kullanıcılar indis değerinin 0'dan başlayacağını bilmeme ihtimalinden dolayı değerleri 1'den başlatacağım yani ilk değerler 0'dan değil 1'den başlayacak.
        int kulsat, kulsut;
        while (true) {

            System.out.println("0 ile " + (sat + 1) + " Arasında Bir satır Seçiniz.");
            kulsat = scan.nextInt();
            while (true) {
                if (kulsat < 1 || kulsat > sat) {
                    System.out.print("Girilen Değerler İstenilen Aralıkta Değil! ");
                    System.out.println("0 ile " + (sat + 1) + " Arasında Bir satır Seçiniz.");
                    kulsat = scan.nextInt();
                } else {
                    break;
                }
            }
            System.out.println("0 ile " + (sut + 1) + " Arasında Bir Sütun Seçiniz");
            kulsut = scan.nextInt();
            while (true) {
                if (kulsut < 1 || kulsut > sut) {
                    System.out.print("Girilen Değerler İstenilen Aralıkta Değil! ");
                    System.out.println("0 ile " + (sut + 1) + " Arasında Bir satır Seçiniz.");
                    kulsut = scan.nextInt();
                } else {
                    break;
                }
            }
            kulsat -= 1;
            kulsut -= 1;
            while (true) {
                if (Objects.equals(ktarla[kulsat][kulsut], Integer.toString(tarla[kulsat][kulsut]))) {
                    System.out.println("Girdiğiniz Değerler Daha önce Girilmiştir.");
                    System.out.println("0 ile " + (sat + 1) + " Arasında Bir satır Seçiniz.");
                    kulsat = scan.nextInt();
                    System.out.println("0 ile " + (sut + 1) + " Arasında Bir satır Seçiniz.");
                    kulsut = scan.nextInt();
                    kulsat -= 1;
                    kulsut -= 1;
                } else {
                    break;
                }
            }


            if (tarla[kulsat][kulsut] == 1) {
                System.out.println("Mayına Denk Geldiniz. Puanınız : " + puan);
                ktarla[kulsat][kulsut] = Integer.toString(tarla[kulsat][kulsut]);
                for (int i = 0; i < sat; i++) {
                    for (int j = 0; j < sut; j++) {
                        System.out.print(ktarla[i][j] + "  ");
                    }
                    System.out.println();
                }
                break;
            } else {
                puan += 5;
                System.out.println("Mayınsız Bölge! Puanınız : " + puan);
            }
            ktarla[kulsat][kulsut] = Integer.toString(tarla[kulsat][kulsut]);
            for (int i = 0; i < sat; i++) {
                for (int j = 0; j < sut; j++) {
                    System.out.print(ktarla[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }
}
