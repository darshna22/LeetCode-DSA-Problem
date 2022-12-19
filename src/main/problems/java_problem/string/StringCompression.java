package java_problem.string;

class StringCompression {
    public static void main(String args[]) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println( compress(chars));
    }
    public static int compress(char[] chars) {
        String s="";
        int n=chars.length;
        if(n==1) return 1;
        int i=0;
        while(i<n){
            int count=0;
            int j=i;
            while(j<n && (chars[i]==chars[j])){
                count++;
                j++;
            }
            if(count==1){
                s=s+String.valueOf(chars[i]);
            }else{
                s=s+String.valueOf(chars[i])+count;
            }
            i=j;
        }
        for(int c=0;c<s.length();c++){
            chars[c]=s.charAt(c);
        }

        return s.length();
    }
}
