package com.max.design.behavioral.memento;

import lombok.Data;

/**
 * 记录者类
 * @author Rick
 * @date 2021-12-06 17:45
 */
@Data
public class ConfigOriginator {

    private ConfigFile configFile;

    public ConfigMemento saveMemento() {
        return new ConfigMemento(configFile);
    }

    public void getMemento(ConfigMemento memento) {
        this.configFile = memento.getConfigFile();
    }
}
