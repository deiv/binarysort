package org.deiv.binarysort.bussines.utils;

import org.deiv.binarysort.bussines.alg.BinaryComparator;

import java.util.Arrays;

public class SortUtils {

    public static String[] binarySort(String[] integerList)
    {
        Arrays.sort(integerList, new BinaryComparator());

        return integerList;
    }
}
