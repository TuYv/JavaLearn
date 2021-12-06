package com.max.design.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 配置文件备忘录
 * @author Rick
 * @date 2021-12-06 17:45
 */
@Data
@AllArgsConstructor
public class ConfigMemento {

    private ConfigFile configFile;
}
