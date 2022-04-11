package hesparza.problems;

public class LongestPalindrome {

    public void run() {
        long startTime = 0;
        long endTime = 0;
        String result = "";

//        startTime = System.nanoTime();
//        result = longestPalindrome5("anitalavalatina");
//        endTime = System.nanoTime();
//        System.out.println(((endTime - startTime)/1000000) + ": " +result);
//
//        startTime = System.nanoTime();
//        result = longestPalindrome5("babad");
//        endTime = System.nanoTime();
//        System.out.println(((endTime - startTime)/1000000) + ": " +result);
//
//        startTime = System.nanoTime();
//        result = longestPalindrome5("cbbd");
//        endTime = System.nanoTime();
//        System.out.println(((endTime - startTime)/1000000) + ": " +result);
//
//        startTime = System.nanoTime();
//        result = longestPalindrome5("a");
//        endTime = System.nanoTime();
//        System.out.println(((endTime - startTime)/1000000) + ": " +result);
//
//        startTime = System.nanoTime();
//        result = longestPalindrome5("ac");
//        endTime = System.nanoTime();
//        System.out.println(((endTime - startTime)/1000000) + ": " +result);
//
//        startTime = System.nanoTime();
//        result = longestPalindrome5("xyzadmbbr");
//        endTime = System.nanoTime();
//        System.out.println(((endTime - startTime)/1000000) + ": " +result);
//
//        startTime = System.nanoTime();
//        result = longestPalindrome5("xyzadbbmr");
//        endTime = System.nanoTime();
//        System.out.println(((endTime - startTime)/1000000) + ": " +result);

        startTime = System.nanoTime();
        result = longestPalindrome5("321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123");
        endTime = System.nanoTime();
        System.out.println(((endTime - startTime)/1000000) + ": " +result);

//        startTime = System.nanoTime();
//        result = longestPalindrome5("eabcb");
//        endTime = System.nanoTime();
//        System.out.println(((endTime - startTime)/1000000) + ": " +result);
//
//        startTime = System.nanoTime();
//        result = longestPalindrome5("esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq");
//        endTime = System.nanoTime();
//        System.out.println(((endTime - startTime)/1000000) + ": " +result);
//
        startTime = System.nanoTime();
        result = longestPalindrome5("aaaa");
        endTime = System.nanoTime();
        System.out.println(((endTime - startTime)/1000000) + ": " +result);
    }

    public String longestPalindrome5(String s) {
        String result = s.charAt(0) + "";
        String partialMatch = null;
        for (int i = 0, j = -1, k = 1; k < s.length(); i++, k++, j++) {
            if (j >= 0 && s.charAt(j) == s.charAt(k)) {
                partialMatch = getPalindrome(s, j, k);
                if(result.length() <= partialMatch.length()) {
                    result = partialMatch;
                }
            }
            if (k < s.length() && s.charAt(i) == s.charAt(k)) {
                partialMatch = getPalindrome(s, i, k);
                if(result.length() <= partialMatch.length()) {
                    result = partialMatch;
                }
            }
        }
        return result;
    }

    //This one failed due to processing time out exceeded since it is (O)n^2
    public String longestPalindrome4(String s) {
        String result = s.charAt(0) + "";
        for (int i = s.length(); i > 1; i--) {
            result = getPalindrome(i, s);
            if (result.length() > 1) {
                break;
            }
        }
        return result;
    }
    private String getPalindrome(int wordSize, String s) {
        String result = s.charAt(0) + "";
        for (int j = 0; j + wordSize <= s.length(); j++) {
            String substr = s.substring(j, wordSize + j);
            if (substr.equalsIgnoreCase(new StringBuilder(substr).reverse().toString())) {
                if (result.length() < substr.length()) {
                    result = substr;
                }
            }
        }
        return result;
    }
    //This one failed due to processing time out exceeded since it is (O)n^2
    public String longestPalindrome3(String s) {
        String result = s.charAt(0) + "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    String substr = s.substring(i, j + 1);
                    if (substr.equalsIgnoreCase(new StringBuilder(substr).reverse().toString())) {
                        if (result.length() <= substr.length()) {
                            result = substr;
                        }
                    }
                }
            }
        }
        return result;
    }

    public String longestPalindrome2(String s) {
        String result = s.charAt(0) + "";
        String partialMatch = null;
        for (int i = 0, j = 0, k = 0; i < s.length(); i++) {
            j = i - 1;
            k = i + 1;
            if (j >= 0 && k < s.length()) {
                if (s.charAt(i) == s.charAt(k)) {
                    partialMatch = getPalindrome(s, i, k);
                    if(result.length() <= partialMatch.length()) {
                        result = partialMatch;
                    }
                }
                if (s.charAt(j) == s.charAt(k)) {
                    partialMatch = getPalindrome(s, j, k);
                    if(result.length() <= partialMatch.length()) {
                        result = partialMatch;
                    }
                }
            } else if (k < s.length()) {
                if (s.charAt(i) == s.charAt(k)) {
                    partialMatch = getPalindrome(s, i, k);
                    if(result.length() <= partialMatch.length()) {
                        result = partialMatch;
                    }
                }
            }
        }
        return result;
    }

    public String longestPalindrome(String s) {
        String result = s.charAt(0) + "";
        String partialMatch = null;
        for (int i = 0, j = 1, k = 2; i < s.length(); i++, j++, k++) {
            if (j == s.length() || result.length() == s.length()) {
                break;
            }

            //palindrome with 2 chars found
            if (j < s.length() && s.charAt(i) == s.charAt(j)) {
                partialMatch = getPalindrome(s, i, j);
                if(result.length() <= partialMatch.length()) {
                    result = partialMatch;
                }
            }

            //palindrome with 3 chars found
            if (k < s.length() && s.charAt(i) == s.charAt(k)) {
                partialMatch = getPalindrome(s, i, k);
                if(result.length() <= partialMatch.length()) {
                    result = partialMatch;
                }
            }
        }
        return result;
    }

    private String getPalindrome(String s, int beginIndex, int endIndex) {
        boolean match = true;
        String result = "";
        do {
            result = s.substring(beginIndex, endIndex + 1);
            beginIndex--;
            endIndex++;
            if (beginIndex < 0 || endIndex >= s.length()) {
                break;
            }
            if (s.charAt(beginIndex) != s.charAt(endIndex)) {
                match = false;
            }
        } while (match);
        return result;
    }
}
