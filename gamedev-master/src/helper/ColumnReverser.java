package helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColumnReverser {

    public static List<Integer> reverseCharacterColumns(List<Integer> columns) {
        List<Integer> cols = new ArrayList<>(columns);
        // Reverse the priority of column preferences.

        // Special case if priority column is middle. No swapping should occur on first index.
        /*
            1,2,0   ->  1,0,2
            1,0,2   ->  1,2,0
         */
        if(cols.get(0) == 1) {
            // Swap only the 2nd and 3rd preferred columns
            Collections.swap(cols, 1, 2);
        }
        else {
            /*
                Reverse other combinations:
                    2,1,0   -> 0,1,2
                    0,1,2   -> 2,1,0
             */
            Collections.reverse(cols);
        }

        return cols;
    }

}
