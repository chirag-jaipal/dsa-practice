package Strings;

public class ToggleCharacters {
    public static void main(String[] args) {
        String s = "helloEveryOne";
        String str = toggleCharacters(s);
        System.out.println(str);
    }

    public static String toggleCharacters(String s) {
        int n = s.length();

        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a') {
                newStr.append(Character.toUpperCase(ch));
            } else {
                newStr.append(Character.toLowerCase(ch));
            }
        }

        return newStr.toString();
    }
}
