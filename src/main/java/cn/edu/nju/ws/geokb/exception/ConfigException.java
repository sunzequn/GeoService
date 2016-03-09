package cn.edu.nju.ws.geokb.exception;

import java.io.IOException;

/**
 * Created by Sloriac on 16/3/9.
 */
public class ConfigException extends IOException {

    public ConfigException(String message) {
        super(message);
    }
}
