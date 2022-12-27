package java_problem.stack;

public class DailyTemperatures {
    public static void main(String args[]) {
        int[] tokens = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(dailyTemperatures(tokens));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        if(n==1) return new int[]{0};
        int[] result=new int[n];
        int i=0;
        while(i<n-1){
            int j=i+1;
            boolean isHigher=false;
            int count=0;
            while(j<n){
                count++;
                if(temperatures[i]<temperatures[j]){
                    isHigher=true;
                    break;
                }
                j++;
            }
            if(isHigher){
                result[i]=count;
            }
            else{
                result[i]=0;
            }
            i++;
        }
        return result;
    }
}
