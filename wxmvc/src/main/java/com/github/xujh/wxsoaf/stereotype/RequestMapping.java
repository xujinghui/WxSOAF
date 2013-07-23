/**
 * 
 */
package com.github.xujh.wxsoaf.stereotype;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.Mapping;

import com.github.xujh.wxsoaf.annotation.RequestType;

/**
 * @author stevenxu
 * 
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface RequestMapping {

	String[] value() default {};

	RequestType[] type() default {};
}
