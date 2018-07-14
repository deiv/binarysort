package org.deiv.binarysort.bussines.utils;

import org.deiv.binarysort.bussines.alg.BinaryComparator;
import org.deiv.binarysort.error.bussines.LogicException;

import java.util.Arrays;

public class ArrayUtils {

    public static Integer[] binarySort(Integer[] integerList)
    {
        Arrays.sort(integerList, new BinaryComparator());

        return integerList;
    }

    public static Integer[] copyOf(String[] input)
    {
        Integer[] out = new Integer[input.length];

        for (int idx = 0; idx < input.length; idx++) {
            try {
                out[idx] = Integer.parseInt(input[idx]);

            } catch (NumberFormatException ex) {
                /* hemos validado anteriormente ... */
                throw new LogicException(ex);
            }
        }

        return out;
    }
}
