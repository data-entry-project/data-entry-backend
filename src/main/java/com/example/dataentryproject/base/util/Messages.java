package com.example.dataentryproject.base.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * This class handles all the messages which will be picked from
 * messages.properties file.
 * @author ankit.kothari
 * @Since 16/08/2018.
 */
@Component
public class Messages {

    /** The message source. */
    @Autowired
    private MessageSource messageSource;

    /** The accessor. */
    private MessageSourceAccessor accessor;

    /**
     * Inits the.
     */
    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource);
    }

    /**
     * Gets the.
     *
     * @param code
     *            the code
     * @return the string
     */
    public String get(String code) {
        return accessor.getMessage(code);
    }
    
    /**
     * This method is used to get value with dynamic parameters.
     * 
     * @param code {@link String}
     * @param value {@link String}
     * @return {@link String}
     */
    public String getParameterisedValue(String code, String... value) {
      return accessor.getMessage(code, value);
    }

}

