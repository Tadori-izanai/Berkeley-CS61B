package disc02;

public class StringList {
    public String first;
    public StringList rest;

    public StringList(String str, StringList list) {
        first = str;
        rest = list;
    }

    public static void main(String[] args) {
        StringList L = new StringList("eat", null);
        L = new StringList("shouldn't", L);
        L = new StringList("you", L);
        L = new StringList("sometimes", L);

        StringList M = L.rest;

        StringList R = new StringList("many", null);
        R = new StringList("potatoes", R);
        R.rest.rest = R;

        M.rest.rest.rest = R.rest;
        L.rest.rest = L.rest.rest.rest;
        L = M.rest;

        System.out.println(L.first);
    }
}
