/**
 * 
 */
package com.github.xujh.wxsoaf.messages;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author stevenxu
 * 
 */
public class MessagesLoad {
    @Autowired
    private ResourceBundleMessageSource messageSource;

    public String getResource() {
        String content = null;

        content = messageSource.getMessage("duplicateFormSubmission", null, Locale.CHINA);

        return content;
    }
}
