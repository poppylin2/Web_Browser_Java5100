package URL;

import java.util.ArrayList;
import java.util.List;

//The purpose of URL List is to maintain a history of user-inputted URLs
public class urlList {
    private static List<String> queue = new ArrayList<String>();// Store user-inputted website URL
    private static int pointer = -1;// point to the url of current webpage
    // get current page URL

    public static String getCurrent() {
        if (queue.size() == 0)
            return null;
        return queue.get(pointer);
    }

    // pointer to the right -->move forward
    public static boolean right() {
        // Check if the pointer is already at the last element of the queue
        if (pointer == queue.size() - 1) {
            return false;
        }
        pointer++;
        return true;
    }

    // pointer to the left -->move backward
    public static boolean left() {
        // Check if the pointer is already at the first element of the queue
        if (pointer == 0) {
            return false;
        }
        pointer--;
        return true;
    }

    // add urls
    public static boolean add(String url) {
        if (pointer + 1 > queue.size() - 1) {
            queue.add(url);
            pointer++;
        } else {
            queue.set(++pointer, url);
        }
        return true;
    }

}
