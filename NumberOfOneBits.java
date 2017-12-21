public class NumberOfOneBits {

    //How many 1 bits are there in the product of A and B?
    public static long solution(int A, int B) {
        long product = (long)A * (long)B;
        long nBits = (long)Math.ceil(Math.log(product) / Math.log(2)+1);
        long count = 0;
        for (long i = 0; i < nBits; i++) {
            if (((product >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 7));
        System.out.println(solution(1, 4));
        System.out.println(solution(5,500));
        System.out.println(solution(0, 0));
        System.out.println(solution(100000000, 100000000));
        System.out.println(solution(1,1));
        System.out.println(solution(1,2));
        System.out.println(solution(1,9));
    }
}