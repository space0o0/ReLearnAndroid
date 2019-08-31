package demo.sp.relearnandroid.java.reflex;

class TestClass {

    private String message = "privateMessage";

    public TestClass() {
        privateMethod("dd", 99);

        System.out.println(message);
    }

    private void privateMethod(String name, int age) {
        System.out.println(name + " now is " + age);
    }

    public void getMessage() {
        System.out.println(message);
    }
}
