package org.deiv.binarysort.bussines;

import org.deiv.binarysort.bussines.utils.ArrayUtils;
import org.deiv.binarysort.error.bussines.LogicException;

public class RestBusinnes {

    public static Integer[] doBinarySort(String input)
            throws LogicException
    {
        String[] numberArray = input.split(",");

        if (numberArray.length == 0) {
            /* cero ?!?!?! uhm ... */
            throw new LogicException();
        }

        return
            ArrayUtils.binarySort(
                ArrayUtils.copyOf(numberArray));
    }
}
