package java_problem.array;

public class Palindrome {
    public static void main(String args[]) {
        String sentence = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(sentence));
    }

    private static boolean isPalindrome(String s1) {
        String s= s1.toLowerCase();
        String resultStr="";
        for(int c=0;c<s.length();c++){
            if((s.charAt(c)>=97 && s.charAt(c)<=122) || (s.charAt(c)>=48 && s.charAt(c)<=57) )
                resultStr+=s.charAt(c);
        }
        System.out.println(resultStr);
        int start=0;
        int end=resultStr.length()-1;
        while(start<=end){
            if(resultStr.charAt(start)!=resultStr.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

