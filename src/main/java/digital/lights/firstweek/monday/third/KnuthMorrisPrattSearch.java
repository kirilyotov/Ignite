package digital.lights.firstweek.monday.third;

public class KnuthMorrisPrattSearch implements StringSearch {

    public int positionOf(String part, String whole) {
        if (part == null || whole == null) {
            throw new NullPointerException();
        }
        if (part.length() == 0)
            return 0;

        int partLength = part.length(),
                wholeLength = whole.length();

        int position = -1;

        int[] lps = LPSArray(part);
        int j = 0,
                i = 0;

        while (partLength - j <= wholeLength - i) {
            if (part.charAt(j) == whole.charAt(i)) {
                j++;
                i++;
            }
            if (j == partLength) {
                position = i - j;
                return position;
            } else if (i < wholeLength && part.charAt(j) != whole.charAt(i)) {
                {
                    if (j != 0) {
                        j = lps[j - 1];
                    } else {
                        i++;
                    }
                }
            }
        }

        return position;
    }

    /**
     * Array for the longest proper prefix which is also suffix of string.
     *
     * @param part String to find lps.
     */
    private int[] LPSArray(String part) {
        int[] lps = new int[part.length()];
        lps[0] = 0;

        int len = 0;
        int i = 0;

        while (i < part.length()) {
            if (part.charAt(i) == part.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }

}
