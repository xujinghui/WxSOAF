/**
 * 
 */
package com.github.xujh.wxsoaf.stereotype;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.xujh.wxsoaf.annotation.RequestType;

/**
 * @author stevenxu
 * 
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface WxController {
    /**
     * The value may indicate a suggestion for a logical component name, to be turned into a Spring bean in case of an
     * autodetected component.
     * 
     * @return the suggested component name, if any
     */
    String value() default "";

    RequestType[] type() default {};
}
