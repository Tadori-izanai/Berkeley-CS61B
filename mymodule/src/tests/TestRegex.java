package tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        String input = "n123123S";
        String input2 = "n114514sWASD";
        String input3 = "llsaddd";
//        String input4 = "N543Swwwwwaaas:quit";
        String input4 = "N543S:quit";

        Pattern regex = Pattern.compile("(?i)N(\\d+)S");
        Matcher matcher = regex.matcher(input);
//        if (matcher.matches()) {
//            System.out.println(matcher.group(1));
//        }
//
//        regex = Pattern.compile("(?i)N(\\d+)S(\\w+)");
//        matcher = regex.matcher(input2);
//        if (matcher.matches()) {
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//        }

        regex = Pattern.compile("(?i)L(\\w+)?(:Q)?\\w*");
        matcher = regex.matcher(input3);
        if (matcher.matches()) {
            System.out.println(matcher.group(1));
        }

//        regex = Pattern.compile("(?i)N(\\d+)S(\\w+)?(:Q)?\\w*");
//        matcher = regex.matcher(input4);
//        if (matcher.matches()) {
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//            System.out.println(matcher.group(3));
//        }
    }
}
