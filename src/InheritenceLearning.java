public class InheritenceLearning {

    public InheritenceLearning() {
        System.out.println("This is 1st class");
    }
    public void testMethod() {
        System.out.println("This is a test method that check this class object use from parent class");
    }
    public static void testMethodAsStatic() {
        System.out.println("This is a static method");
    }
}

class InheritanceLearningPartTwo extends InheritenceLearning {
    public InheritanceLearningPartTwo() {
        System.out.println("This is 2nd class which is inheriting 1st class");
        InheritenceLearning.testMethodAsStatic();
        //Static methods from parent class can be only called inside constructor and not outside of child class constructor
    }

}

class InheritanceLearningPartThree extends InheritanceLearningPartTwo {
    public InheritanceLearningPartThree() {
        System.out.println("This is the 3rd class that is inheriting 2nd class");
        InheritenceLearning.testMethodAsStatic();
    }

    public static void main(String[] args) {
        InheritanceLearningPartThree inheritanceLearningPartThree = new InheritanceLearningPartThree();
        inheritanceLearningPartThree.testMethod();
        //Class InheritanceLearningPartThree was able to use method from its parent class InheritanceLearning

    }
}


