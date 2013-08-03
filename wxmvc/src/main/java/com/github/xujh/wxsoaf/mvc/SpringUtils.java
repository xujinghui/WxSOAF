/**
 * 
 */
package com.github.xujh.wxsoaf.mvc;

import java.util.Map;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.google.common.base.Strings;

/**
 * @author stevenxu
 * 
 */
public class SpringUtils {
    private SpringUtils() {

    }

    public static final String NO_FOUND_CONTROLLER = "noTypeOrController";
    public static final String TYPE_SELECTOR = "typeSelector";
    public static final String HANDLER_SELECTOR = "handlerSelector";
    public static final String DEFAULT = "default";

    // public static WebApplicationContext getWebAppCtx() {
    // return ContextLoader.getCurrentWebApplicationContext();
    // }

    public static Object getBean(String name) {
        if (Strings.isNullOrEmpty(name)) {
            return null;
        }
        return ContextLoader.getCurrentWebApplicationContext().getBean(name);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> claz) {
        return ContextLoader.getCurrentWebApplicationContext().getBeansOfType(claz);
    }

    public static String[] getBeanNamesForType(Class<?> claz) {
        return ContextLoader.getCurrentWebApplicationContext().getBeanNamesForType(claz);
    }
}
