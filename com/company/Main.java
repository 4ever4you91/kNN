package com.company;
// This problem of classification may be solved with kNN algorithm

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
                String s = "";
                Scanner in = null;
                try {
                    in = new Scanner(new File("C:\\Users\\Gennady\\Downloads\\irisdata.txt")); // Insert the path to file;
                }
                catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

                while (in.hasNext()) {
                    s += in.nextLine() + " ";
                }

                if (in != null) {
                    in.close();
                }
                String [] mass;
                s=s.replace("Iris-setosa ", "");
                s=s.replace("Iris-versicolor ", "").replace("Iris-virginica ", "");
                mass = s.split(",");
                double [][] arr = new double[150][4];
                int y = 0;
                for(int k = 0; k<150; k++){
                    for(int i = 0; i<4; i++)
                        arr[k][i] = Double.parseDouble(mass[y++]);
                }
                System.out.println(Arrays.deepToString(arr));


                 kNN(arr, 13, 4.2, 3.5, 5.4, 3.5);



    }
    static void kNN(double arr[][], int k, double s_length, double s_width, double p_length, double p_width) {
        double g;
        int i = 0;
        double [] mass = new double[150];
        for (i = 0; i < 150; i++) {
            for (int l = 0; l < 1; l++) {
                g = Math.sqrt(Math.pow(s_length - arr[i][l], 2) + Math.pow(s_width - arr[i][l + 1], 2) + Math.pow(p_length - arr[i][l + 2], 2) + Math.pow(p_width - arr[i][l + 3], 2));
                mass[i] = g;
            }
        }

        double[] ma = mass.clone();
        Arrays.sort(mass);
        ArrayList set = new ArrayList();
        ArrayList vers = new ArrayList();
        ArrayList virg = new ArrayList();
        for(int m = 0; m < k; m ++) {
            for (int z = 0; z < 150; z++) {
                if (ma[z] == mass[m] && z < 50) {
                    set.add(mass[m]);
                }
                if (ma[z] == mass[m] && z >= 50 && z < 100) {
                    vers.add(mass[m]);
                }
                if (ma[z] == mass[m] && z >= 100 && z < 150) {
                    virg.add(mass[m]);
                }
            }
        }

        double seto = 0.0;
        for(int j = 0; j < set.size(); j++){

          seto += 1/Math.pow((double)set.get(j), 2.0);

        }
        double versi = 0.0;
            for(int j = 0; j < vers.size(); j++){

                versi += 1/Math.pow((double)vers.get(j), 2.0);

            }
        double virgi = 0.0;
            for(int j = 0; j < virg.size(); j++){

                virgi += 1/Math.pow((double)virg.get(j), 2.0);

            }

        if (seto > versi && seto > virgi){
            System.out.println("Iris Setosa");
        }
        if (versi > virgi && versi > seto){
                System.out.println("Iris Versicolour");
            }
        if (virgi > versi && virgi > seto){
                System.out.println("Iris Virginica");
            }

    }

}
