package cn.devcorp.demo.annocation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EsealAuditLog {
    String value() default "";
}