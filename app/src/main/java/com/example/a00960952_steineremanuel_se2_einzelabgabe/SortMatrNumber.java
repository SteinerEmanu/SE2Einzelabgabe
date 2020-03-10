package com.example.a00960952_steineremanuel_se2_einzelabgabe;

public class SortMatrNumber {

    private String number;

    public SortMatrNumber(String number) {
        this.number = number;
    }

    public String getSortedNumber() { // 00960952 mod 7 = 6
        // Sortiere gerade Ziffern links danach ungerade Ziffern rechts
        String sortedNumber = "";
        char[] unsortedArray = number.toCharArray();
        char[] sortedArray = new char[number.length()];
        char swap = 0;
        int countEven = 0;
        int counter = 0;

        for (int i = 0; i < unsortedArray.length; i++) {
            if (Character.getNumericValue(unsortedArray[i]) % 2 == 0) countEven++;
        }

        for (int i = 0; i < unsortedArray.length; i++) {
            for (int j = i; j < unsortedArray.length; j++) {
                if (unsortedArray[i] > unsortedArray[j]) {
                    swap = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[j];
                    unsortedArray[j] = swap;
                }
            }
        }

        for (int i = 0; i < unsortedArray.length; i++) {
            if (Character.getNumericValue(unsortedArray[i]) % 2 == 1)
                sortedArray[countEven++] = unsortedArray[i];
            else sortedArray[counter++] = unsortedArray[i];

        }
        sortedNumber = String.copyValueOf(sortedArray);
        return sortedNumber;
    }

}
