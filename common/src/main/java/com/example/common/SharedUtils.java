package com.example.common;
/**
 * @author can
 * @date 8/17/20
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SharedUtils {
    private static final Logger logger = LoggerFactory.getLogger(SharedUtils.class);

    public static String getText() {
        return "A string from 'shared-library'";
    }
}
