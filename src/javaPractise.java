public class javaPractise {

    public static void main(String[] args) {
        convertNumberToYearsMonthDays(1234546);
    }
    public static void convertNumberToYearsMonthDays(int number) {
        int months =0;
        int days;
        if(number>0) {
            int year = number/365;
            //System.out.println(year);
            if(number%365>30) {
                months = (number%365)/30;
                days = (number%365)%30;
            } else days = (number%365);

            //System.out.println(months);
            System.out.println(number+" Days is "+year+" years"+" "+months+" months"+" "+days+" days");
        } else System.out.println("Check your input");

    }
}
