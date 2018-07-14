package org.deiv.binarysort.bussines.alg;

import java.util.Comparator;

public class BinaryComparator implements Comparator<Integer> {

    public int compare(Integer l, Integer r)
    {
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

        for (int idx=0; idx < Integer.BYTES * 4; idx++) {

            /* obtenemos el primer bit */
            int firstBit = 0x1 & number;

            if (firstBit == 1) {
                totalOnes++;
            }

            /* desplazamos un bit a la derecha */
            number >>= 1;
        }

        return totalOnes;
    }
}