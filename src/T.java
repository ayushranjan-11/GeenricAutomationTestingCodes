public class T {
    int t=20;
    T() {
        t=40;
    }
}

class Main {
    public static void main(String[] args) {
        T t1 = new T();
        System.out.print(t1.t);
    }
}