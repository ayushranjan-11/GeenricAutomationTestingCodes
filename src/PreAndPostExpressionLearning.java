public class PreAndPostExpressionLearning {
    public static void main(String[] args) {
        int a =5;
        int b = a++;

        System.out.println(a+","+b);
        System.out.println(" We will try to print counting from 0 to 5 with post and pre increment");
        postIncrementTest();
        preIncrementTest();

    }

    public static void postIncrementTest() {
        int i = 0;
        int j;
        for(j = i++; j<5;j++) {
            System.out.println(i);
        }
        System.out.println("Now the value of i is: "+i);
        System.out.println("Now the value of j is: "+j);
    }

    public static void preIncrementTest() {
        int i = 0;
        int j;
        for(j = ++i;j<5;++j) {
            System.out.println(i);
        }
        System.out.println("Now the value of i is: "+i);
        System.out.println("Now the value of j is: "+j);
    }
}
