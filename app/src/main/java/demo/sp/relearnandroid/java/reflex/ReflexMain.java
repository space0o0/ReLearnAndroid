package demo.sp.relearnandroid.java.reflex;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflexMain {

    private static StudentInfo studentInfo;
    private static SchoolInfo schoolInfo;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {
        createInfo();

//        getObjClass();
//        getAllFields();
//        getAllMethods();
//        getPrivateMethod();
        modifyPrivateFidle();
    }

    private static void createInfo() {
        studentInfo = new StudentInfo();

        studentInfo.setName("nnname");
        studentInfo.setAge("90");
        studentInfo.setSex("boy");
        schoolInfo = new SchoolInfo();
    }

    private static void getObjClass() {

        try {
            Class<?> clazz = Class.forName("demo.sp.relearnandroid.java.reflex.StudentInfo");

            studentInfo = (StudentInfo) clazz.newInstance();

            studentInfo.setName("ddd");

            System.out.println(studentInfo.getName());
            System.out.println(clazz.getConstructors().length);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取类的属性信息
     */
    private static void getAllFields() {

        Class clazz = studentInfo.getClass();
        System.out.println(clazz.getName());

        //获取公共的field
        Field[] publicFields = clazz.getFields();

        //获取所有的field
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            int modifier = field.getModifiers();
            System.out.println("modifier is " + modifier);

            System.out.println("field type:" + field.getType().getName());
            System.out.println("field name:" + field.getName());
        }

    }

    /**
     * 获取类的所有方法信息
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void getAllMethods() {
        Class clazz = studentInfo.getClass();

        //获取所有的public方法
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {

            System.out.println("method name : " + method.getName());
            System.out.println("return type name : " + method.getReturnType().getName());
            System.out.println("-----------------");

            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getType().getName() + "  " + parameter.getName());
            }

            System.out.println("-----------------");

            Class[] exceptions = method.getExceptionTypes();
            for (Class exception : exceptions) {
                System.out.println("throws : " + exception.getName());
            }
        }


    }

    /**
     * 调用私有方法
     */
    private static void getPrivateMethod() {

        TestClass test = new TestClass();
        Class clazz = test.getClass();

        try {
            Method privateMethod = clazz.getDeclaredMethod("privateMethod", String.class, int.class);

            privateMethod.setAccessible(true);

            privateMethod.invoke(test, "aaa", 88);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改私有属性
     */
    private static void modifyPrivateFidle() {
        //获取到类的class对象
        TestClass testClass = new TestClass();
        Class clazz = testClass.getClass();

        try {
            Field privateField = clazz.getDeclaredField("message");

            privateField.setAccessible(true);

            privateField.set(testClass, "changedMessage");

            testClass.getMessage();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}
