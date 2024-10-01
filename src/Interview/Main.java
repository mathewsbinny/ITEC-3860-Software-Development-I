public class Main {
    public static void main(String[] args) {
        long sum = 0;
        long sum2 = 0;
        long difference;
        for(int i=1; i<101; i++) {
            sum += i * i;
        }
        System.out.println(sum);

        for(int i=1; i<101; i++) {
            sum2 += i;
        }
        sum2 = Math.pow(sum2, 2);
        difference = sum2 - sum;
        System.out.println(difference);
    }
}