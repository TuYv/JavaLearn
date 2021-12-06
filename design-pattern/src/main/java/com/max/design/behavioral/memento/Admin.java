package com.max.design.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理员类
 * @author Rick
 * @date 2021-12-06 17:45
 */
public class Admin {
    private int cursorIdx = -1;
    private List<ConfigMemento> mementoList = new ArrayList<>();
    private Map<String, ConfigMemento> mementoMap = new ConcurrentHashMap<>();

    public void append(ConfigMemento memento) {
        mementoList.add(memento);
        mementoMap.put(memento.getConfigFile().getVersionNo(), memento);
        cursorIdx++;
    }

    public ConfigMemento undo() {
        cursorIdx--;
        if (cursorIdx >= 0) {
          return mementoList.get(cursorIdx);
        }
        return null;
    }

    public ConfigMemento redo() {
        if (Objects.isNull(mementoList.get(cursorIdx + 1))) {
            return null;
        }
        return mementoList.get(++cursorIdx);
    }

    public ConfigMemento get(String versionNo) {
        return mementoMap.get(versionNo);
    }
}
