package org.deiv.binarysort.bussines.alg;

import java.util.Comparator;

public class BinaryComparator implements Comparator<String> {
    public int compare(String a, String b)
    {
        Integer l = Integer.parseInt(a);
        Integer r = Integer.parseInt(b);

        int lCount = countBinaryOnes(l);
        int rCount = countBinaryOnes(r);

        if ( lCount == rCount) {
            return l.compareTo(r);
        }

        return lCount < rCount ? 1 : -1;
    }

    private int countBinaryOnes(int number)
    {
        int totalOnes = 0;

        for (int idx=0; idx < Integer.BYTES; idx++) {
            int firstBit = 0x1 & number;

            if (firstBit == 1) {
                totalOnes++;
            }

            number >>= 1;
        }

        return totalOnes;
    }
}