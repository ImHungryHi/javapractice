package code;

import java.io.*;
import java.nio.file.FileSystemException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class AuthorizedPersonnelOnly {
    // This class contains code that may never - under any circumstance - generate detailed output towards the user
    // Or may never even be logically comprehended by the end user

    /*
     * -----------------------------------------------------------------------------------------
     * -------------------------------------- STACK TRACE --------------------------------------
     * -----------------------------------------------------------------------------------------
     */
    public static String getCallingMethodName() {
        // Get the name of the method that called the current method
        // The first element will be "getMethodName", the second is the current method, the third is the previous and so on
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static int getCallingLineNumber() {
        // Get the line number from which the method was called
        return Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static StackTraceElement[] getFullStackTrace() {
        // Return the stack trace array
        return Thread.currentThread().getStackTrace();
    }

    // Method and class name example
    public static void log(String s) {
        System.out.println(Thread.currentThread().getStackTrace()[2].getClassName() + ": "
                + Thread.currentThread().getStackTrace()[2].getMethodName() + ": "
                + s);
    }

    /*
     * --------- Bunny hopping methods to show difference in stack trace calls ---------
     */
    private static StackTraceElement[] method1() {
        return method2();
    }
    private static StackTraceElement[] method2() {
        return method3();
    }
    private static StackTraceElement[] method3() {
        return method4();
    }
    private static StackTraceElement[] method4() {
        return method5();
    }
    private static StackTraceElement[] method5() {
        return method6();
    }
    private static StackTraceElement[] method6() {
        return method7();
    }
    private static StackTraceElement[] method7() {
        return method8();
    }
    private static StackTraceElement[] method8() {
        return method9();
    }
    private static StackTraceElement[] method9() { return method10(); }
    private static StackTraceElement[] method10() {
        return Thread.currentThread().getStackTrace();
    }

    public static int getStackCallDifference() {
        // If a method10 is called via bunny hopping through method1, return the amount of methods that were called inbetween, including methods 1 and 10
        return method1().length - method10().length + 1;
    }

    /*
     * -----------------------------------------------------------------------------------------
     * -------------------------------------- EXCEPTIONS --------------------------------------
     * -----------------------------------------------------------------------------------------
     */
    public static void catchMultipleExceptions() {
        // Catch multiple exceptions like this
        try {
            // I solemnly swear that I'm up to no good
            int a = 42 / 0; // ArithmeticException

            // 2 examples of NullPointerException
            String s = null, m = s.toLowerCase();
            HashMap<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);

            // ArrayIndexOutOfBoundsException
            int[] arr = new int[2];
            arr[8] = 5;

            // IndexOutOfBoundsException
            ArrayList<String> list = new ArrayList<String>();
            String str = list.get(18);

            // NumberFormatException
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        }
        catch (ArithmeticException ex) {
            // Just don't divide by 0 4Head
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass().getCanonicalName());
        }
        catch (NullPointerException ex) {
            // Do whatever you want to do when a null pointer was encountered
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            // Yep
        }
        catch (IndexOutOfBoundsException ex) {
            // Nope
        }
        catch (NumberFormatException ex) {
            System.out.println(ex.getClass().getCanonicalName());
        }
        catch (Exception ex) {
            // Last ditch effort to catch any exceptions that weren't caught by the previous catches
        }
    }

    public static void differentExceptions() {
        try {
            int a = 42 / 0;
        }
        catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass().getCanonicalName());
        }

        try {
            String s = null;
            String m = s.toLowerCase();

            // THIS ALSO THROWS NULLPOINTEREXCEPTIONS
            HashMap<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);
        }
        catch (NullPointerException ex) {
            System.out.println(ex.getClass().getCanonicalName());
        }

        try {
            int[] m = new int[2];
            m[8] = 5;
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getClass().getCanonicalName());
        }

        try {
            ArrayList<String> list = new ArrayList<String>();
            String s = list.get(18);
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getClass().getCanonicalName());
        }

        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        }
        catch (NumberFormatException ex) {
            System.out.println(ex.getClass().getCanonicalName());
        }
    }

    // You can choose not to catch an exception, but rather throw it like so
	public static void throwByMethodSignature() throws FileNotFoundException, ClassNotFoundException {}	// If you've included code to read from a file, this method will throw a FileNotFoundException if it's absent
	// You HAVE to try-catch a call to this method in order to compile

    // Get info from an exception
    public static void getNameAndMessageFromException() {
        try {
            int a = 42 / 0;
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass().getCanonicalName());
        }
    }

    // Check which class an object is an instance of, useful with eg exceptions but also in mixed object arrays
    public static void checkInstanceOfException() {
        try {
            throw new RuntimeException("Well, this is random");
        }
        catch (Exception exception) {
            if (exception instanceof RuntimeException) {
                RuntimeException e = (RuntimeException) exception;
                System.out.println(e.getMessage());
            }
        }
    }

    /*
     * --------- Creating your own exceptions, inheriting other Exception classes ---------
     */
    // Checked vs unchecked exceptions (checked at compile time) - first 2 are examples of the former
    static class MyException extends IOException {}
    static class MyException2 extends SQLException {}
    static class MyException3 extends NullPointerException {}
    static class MyException4 extends ArithmeticException {}

    // You can further extend these Exceptions and they'll be instances of all parent Exception classes
    static class Exception1 extends Exception {}
    static class Exception2 extends Exception1 {}
    static class Exception3 extends Exception2 {}

    // Grouping and inheriting exception classes; when exceptions inherit one another, catch them
    // from the lowest level all the way up to the root.
    // Eg: Exception3 inherits from Exception2, Exception2 from 1, 1 from Exception, catch in this order
    public static void throwExceptionByMethodSignature() throws Exception1, Exception2, Exception3 {
        int i = (int) (Math.random() * 3);
        if (i == 0)
            throw new Exception1(); // No try-catch necessary because the method signature already throws one of these exceptions
        if (i == 1)
            throw new Exception2();
        if (i == 2)
            throw new Exception3();
    }

    public static void catchExceptionFromSignature() {
        try {
            throwExceptionByMethodSignature();
        }
        // This sequence will catch the specific Exception instance, so that Exception3 - being a child of 1 - doesn't catch 1
        catch(Exception3 ex) {
            //
        }
        catch(Exception2 ex) {
            //
        }
        catch(Exception1 ex) {
            //
        }
    }

    // ++++++++++++++++++++++++++++++++++++ //
    // Catch, log, rethrow and catch again to log
    public static StatelessBean BEAN = new StatelessBean();

    public static void catchLogRethrowCatchExceptions() {
        try {
            handleExceptions();
        }
        catch (FileSystemException ex) {
            BEAN.log(ex);
        }
    }

    public static void handleExceptions() throws FileSystemException {
        try {
            BEAN.throwExceptions();
        }
        catch (FileSystemException ex) {
            BEAN.log(ex);
            throw ex;
        }
        catch (CharConversionException ex) {
            BEAN.log(ex);
        }
        catch (IOException ex) {
            BEAN.log(ex);
        }
    }

    public static class StatelessBean {
        public void log(Exception exception) {
            System.out.println(exception.getMessage() + ", " + exception.getClass().getSimpleName());
        }

        public void throwExceptions() throws CharConversionException, FileSystemException, IOException {
            int i = (int) (Math.random() * 3);
            if (i == 0)
                throw new CharConversionException();
            if (i == 1)
                throw new FileSystemException("");
            if (i == 2)
                throw new IOException();
        }
    }
    // ++++++++++++++++++++++++++++++++++ //

    /*
     * -----------------------------------------------------------------------------------------
     * ----------------------------------- ACCESS MODIFIERS ------------------------------------
     * -----------------------------------------------------------------------------------------
     */
    public static class A {
        private int number = 7;

        public A(int number) {
            this.number = number;
            writeStuff();   // If we left the private out and the protected writeStuff in, this call would use B.writeStuff()
        }

        // This will be overridden by any child class that has a protected (or otherwise) void writeStuff() method
        /*
        protected void writeStuff() {
            System.out.println(this.number);
        }
        */

        private void writeStuff() {
            System.out.println(this.number);
        }
    }

    public static class B extends A {
        protected int number = 3;

        public B(int number) {
            super(number);
            this.number += number;
            writeStuff();
        }

        // This would override any protected, public or default methods up on top
        protected void writeStuff() {
            System.out.println(number);
        }
    }
}
