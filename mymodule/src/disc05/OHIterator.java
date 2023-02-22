package disc05;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OHIterator implements Iterator<OHRequest> {
    OHRequest curr;

    public OHIterator(OHRequest queue) {
        curr = queue;
    }

    public boolean isGood(String description) {
        return description != null && description.length() > 5;
    }

    @Override
    public boolean hasNext() {
        /* curr 以及后面的 OHRequest 是否存在 good description */
//        while (!isGood(curr.description) && curr != null) {
        // 要先判断是不是 null
        while (curr != null && !isGood(curr.description)) {
            curr = curr.next;
        }
        return (curr != null);
    }

    @Override
    public OHRequest next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        OHRequest returnValue = curr;
        curr = curr.next;
        return returnValue;
    }

}
