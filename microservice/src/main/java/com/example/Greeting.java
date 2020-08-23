package com.example; /**
 * @author can
 * @date 8/17/20
 * <p>
 * ${tags}
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Greeting {
    private static final Logger logger = LoggerFactory.getLogger(Greeting.class);

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
