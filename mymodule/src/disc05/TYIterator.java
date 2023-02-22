package disc05;

import java.util.NoSuchElementException;

public class TYIterator extends OHIterator {
    public TYIterator(OHRequest queue) {
        super(queue);
    }

    @Override
    public OHRequest next() {
//        if (!hasNext()) {
//            throw new NoSuchElementException();
//        }
//        OHRequest returnValue = curr;
//
//        if (curr.description.contains("thank u")) {
//            curr = curr.next;
//        }
//        curr = curr.next;
//        return returnValue;

        OHRequest result = super.next();
        if (result != null && result.description.contains("thank u")) {
            result = super.next();
        }
        return result;
    }
}
