package com.max.design.behavioral.iterator.group;

import com.max.design.behavioral.iterator.lang.Collection;
import com.max.design.behavioral.iterator.lang.Iterator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Rick
 * @date 2021-12-02 21:28
 */
public class GroupStructure implements Collection<Employee, Link> {

    private String groupId;
    private String groupName;
    private Map<String,Employee> employeeMap = new ConcurrentHashMap<>();
    private Map<String, List<Link>> linkMap = new ConcurrentHashMap<>();
    private Map<String, String> invertedMap = new ConcurrentHashMap<>();

    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }
    @Override public boolean add(Employee element) {
        return null != employeeMap.put(element.getUId(), element);
    }

    @Override public boolean remove(Employee element) {
        return null != employeeMap.remove(element.getUId());
    }

    @Override public boolean addLink(String key, Link link) {
        invertedMap.put(link.getToId(), link.getFromId());
        if(linkMap.containsKey(key)) { return linkMap.get(key).add(link);}
        else {
            List<Link> links = new LinkedList<>();
            links.add(link);
            linkMap.put(key, links);
            return true;
        }
    }

    @Override public boolean removeLink(String key) {
        return null != linkMap.remove(key);
    }

    @Override public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {

            HashMap<String, Integer> keyMap = new HashMap<String, Integer>();

            int totalIdx = 0;
            private String fromId = groupId;  // 雇员ID，From
            private String toId = groupId;   // 雇员ID，To
            @Override public boolean hasNext() {
                return totalIdx < employeeMap.size();
            }

            @Override public Employee next() {
                List<Link> links = linkMap.get(toId);
                int cursorIdx = getCursorIdx(toId);

                // 同级节点扫描
                if (null == links) {
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                // 上级节点扫描
                while (cursorIdx > links.size() - 1) {
                    fromId = invertedMap.get(fromId);
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                // 获取节点
                Link link = links.get(cursorIdx);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIdx++;

                // 返回结果
                return employeeMap.get(link.getToId());
            }

            private int getCursorIdx(String toId) {
                int idx = 0;
                if (keyMap.containsKey(toId)) {
                    idx = keyMap.get(toId);
                    keyMap.put(toId, ++idx);
                }else {
                    keyMap.put(toId, idx);
                }
                return idx;
            }
        };
    }
}
