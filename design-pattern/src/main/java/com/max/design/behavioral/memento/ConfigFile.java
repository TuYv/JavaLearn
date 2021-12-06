package com.max.design.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 配置文件
 * @author Rick
 * @date 2021-12-06 17:45
 */
@Data
@AllArgsConstructor
public class ConfigFile {
    /** 版本号 */
    private String versionNo;
    /** 内容 */
    private String content;
    /** 时间 */
    private Date dateTime;
    /** 操作者 */
    private String operator;
}
