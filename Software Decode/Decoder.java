
//Brandon Sapp
import java.util.*;
import java.util.Hashtable;

public class Decoder {

    static Queue outputVals = new Queue();

    public static Queue decode(Queue queue, Hashtable<String, Integer> table) {
        while (queue.size() >= 6) {
            int count = 0;
            int idx = -1;
            queue.normalize();
            int[] compareTo = new int[6];
            int[] nextVals;
            if (queue.size() == 6) {
                nextVals = queue.peek(6);
            } else {
                nextVals = queue.peek(7);
            }
            Integer[] milesVals = new Integer[] { 0, 20, 40, 60, 80, 100, 120,
                    140, 160, 180, 200 };
            for (int i = 0; i < nextVals.length; i++) {
                if (Arrays.asList(milesVals).contains((nextVals[i]))) {
                    continue;
                } else {
                    count++;
                    idx = i;
                }
            }
            if (count >= 2) {
                queue.next();
            } else if (count == 1) {
                if (idx == nextVals.length - 1) {
                    for (int j = 0; j < 6; j++) {
                        compareTo[j] = nextVals[j];
                    }
                } else {
                    for (int j = 0; j < 6; j++) {
                        if (idx == j) {
                            compareTo[j] = nextVals[j + 1];
                            for (int k = idx + 1; k < 6; k++) {
                                compareTo[k] = nextVals[k + 1];
                            }
                            break;
                        } else {
                            compareTo[j] = nextVals[j];
                        }
                    }
                }
            } else {
                for (int k = 0; k < 6; k++) {
                    compareTo[k] = nextVals[k];
                }
            }
            if (table.get(Arrays.toString(compareTo)) != null) {
                outputVals.loadValue(table.get(Arrays.toString(compareTo)));
                if (count == 1) {
                    if (idx == nextVals.length - 1) {
                        for (int n = 0; n < 6; n++) {
                            queue.next();
                        }
                    } else {
                        for (int n = 0; n < 7; n++) {
                            queue.next();
                        }
                    }

                } else {
                    for (int n = 0; n < 6; n++) {
                        queue.next();
                    }
                }
            } else {
                queue.next();
            }

        }
        return outputVals;

    }

}
