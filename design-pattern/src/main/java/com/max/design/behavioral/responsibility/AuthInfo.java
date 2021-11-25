package com.max.design.behavioral.responsibility;

import lombok.Data;

/**
 * @author Rick
 * @date 2021-11-25 21:25
 */
@Data
public class AuthInfo {
    private String code;
    private String info = "";

    public AuthInfo(String code, String ...infos) {
        this.code = code;
        for (String info : infos) {
            this.info = this.info.concat(info);
        }
    }
}
