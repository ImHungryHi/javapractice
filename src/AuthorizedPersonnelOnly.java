import java.io.*;

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

    private static StackTraceElement[] method9() {
        return method10();
    }

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
        }
        catch (NullPointerException ex) {
            // Do whatever you want to do when a null pointer was encountered
        }
        catch (ArithmeticException ex) {
            // Just don't divide by 0 4Head
        }
        catch (Exception ex) {
            // Last ditch effort to catch any exceptions that weren't caught by the previous catches
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
}
