package code.dynamic;

import java.util.*;

/**
 * Created by hernan on 01-04-14.
 * Problem mirror split recursive palindrome
 */
public class DetectPalindrome {

    public static void main(String[] args) {
        String in = "afoolishconsistencyisthehobgoblinoflittlemindsadoredbylittlestatesmenandphi" +
                    "losophersanddivineswithconsistencyagreatsoulhassimplynothingtodohemayaswell" +
                    "concernhimselfwithhisshadowonthewallspeakwhatyouthinknowinhardwordsandtomor" +
                    "rowspeakwhattomorrowthinksinhardwordsagainthoughitcontradicteverythingyousa" +
                    "idtodayahsoyoushallbesuretobemisunderstoodisitsobadthentobemisunderstoodpyt" +
                    "hagoraswasmisunderstoodandsocratesandjesusandlutherandcopernicusandgalileoa" +
                    "ndnewtonandeverypureandwisespiritthatevertookfleshtobegreatistobemisunderstood";
        Map<String, Integer> palindromeMap = palindrome(in);
        String element = resultElement(palindromeMap);
        System.out.println("-- CLAVE PALINDROME -- " + element);
    }

    public static String resultElement( Map<String, Integer> map) {
        int maxValueInMap=(Collections.max(map.values()));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                return entry.getKey();
            }
        }
        return "";
    }

    public static Map<String, Integer> palindrome(String s) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        for (int i = s.length(); i > 0; --i) {
            for (int j = 0; j <= s.length() - i; ++j) {
                String sub = s.substring(j, j + i);
                if (isPalindrome(sub))
                    result.put(sub, sub.length());
            }
        }
        return result;
    }

    private static boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;
        else
            return s.charAt(0) == s.charAt(s.length() - 1) &&
                    isPalindrome(s.substring(1, s.length() - 1));
    }
}
