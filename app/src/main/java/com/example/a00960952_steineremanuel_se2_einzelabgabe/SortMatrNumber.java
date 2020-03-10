package com.example.a00960952_steineremanuel_se2_einzelabgabe;

public class SortMatrNumber {

    String number;

    public SortMatrNumber(String number) {
        this.number = number;
    }

    public String getSortedNumber() { // 00960952 mod 7 = 6
        // Sortiere gerade Ziffern links danach ungerade Ziffern rechts
        String sortedNumber = "";
        char[] array = number.toCharArray();
        char swap = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                swap = array[i];
                array[i] = array[i + 1];
                array[i + 1] = swap;
            }
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] % 2 == 1) {
                
            }
        }


        return sortedNumber;
    }

}
