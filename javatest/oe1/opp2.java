package javatest.oe1;

public class opp2 {
    public static void main(String[] args) {
        int[][] times = {{5,6,7},
                    {20,23,26},
                    {13,12,11}};

        for(int[] time : times) {
            int tot = convert(time);
            print(time, tot);
        }        
    }

    public static int convert(int[] time) {
        return time[0] * 3600 + time[1] * 60 + time[2];
    }

    public static void print(int[] time, int tot) {
        System.out.printf("%d hours %d minutes %d seconds = %d seconds %n", time[0], time[1], time[2], tot);
    }

}
