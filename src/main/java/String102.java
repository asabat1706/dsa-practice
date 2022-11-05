public class String102 {
    public static void main(String[] args)
    {
        String s = "interviewbit";
        System.out.println(findVowel(s));
    }

    private static String findVowel(String s) {
        StringBuilder substr= new StringBuilder();
        for(int i=0; i< s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'
            || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U')
            {
                substr.append(s.charAt(i));
            }
        }
        return substr.toString();
    }
}
