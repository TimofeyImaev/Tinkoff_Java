package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {
    private static final Logger LOGGER = LogManager.getLogger();

    public Task4() {

    }

    public record CallingInfo(String className, String methodName) {
        public static CallingInfo callingInfo() {
            StackTraceElement[] stacks = (new Throwable()).getStackTrace();
            String className = stacks[1].getClassName().split("\\$")[1];
            String methodName = stacks[1].getMethodName();

            LOGGER.trace("Back of stacks {} {}", className, methodName);

            return new CallingInfo(className, methodName);
        }
    }

    public static class SomeClass1 {
        public CallingInfo someFunction1() {
            return CallingInfo.callingInfo();
        }
    }

    public static class SomeClass2 {
        public CallingInfo someFunction2() {
            return CallingInfo.callingInfo();
        }
    }

    public static class SomeClass3 {
        public CallingInfo someFunction3() {
            return CallingInfo.callingInfo();
        }
    }
}
