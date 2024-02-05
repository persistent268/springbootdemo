//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.devcorp.demo.utils;

public class ExceptionUtils {
    public ExceptionUtils() {
    }

    public static RuntimeException wrap2Runtime(Exception e) {
        return e instanceof RuntimeException ? (RuntimeException)e : new RuntimeException(e);
    }

    public static Throwable getOriginal(Throwable e) {
        Throwable ex = e.getCause();
        return ex != null ? getOriginal(ex) : e;
    }
}
