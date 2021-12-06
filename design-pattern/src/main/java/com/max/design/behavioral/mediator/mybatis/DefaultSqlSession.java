package com.max.design.behavioral.mediator.mybatis;

import lombok.AllArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * @author Rick
 * @date 2021-12-03 15:54
 */
@AllArgsConstructor
public class DefaultSqlSession implements SqlSession{

    private Connection connection;
    private Map<String, XNode> mapperElement;

    @Override public <T> T selectOne(String statement) {
        try {
            XNode xNode = mapperElement.get(statement);
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            return (T) baseSelect(preparedStatement, xNode).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private <T> List<T> baseSelect(PreparedStatement preparedStatement, XNode xNode)
        throws SQLException, ClassNotFoundException {
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet2Obj(resultSet, Class.forName(xNode.getResultType()));
    }

    @Override public <T> T selectOne(String statement, Object parameter) {
        XNode xNode = mapperElement.get(statement);
        Map<Integer, String> parameterMap = xNode.getParameter();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            buildParameter(preparedStatement, parameter, parameterMap);
            return (T) baseSelect(preparedStatement, xNode).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override public <T> List<T> selectList(String statement) {
        XNode xNode = mapperElement.get(statement);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            return baseSelect(preparedStatement, xNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override public <T> List<T> selectList(String statement, Object parameter) {
        XNode xNode = mapperElement.get(statement);
        Map<Integer, String> parameterMap = xNode.getParameter();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            buildParameter(preparedStatement, parameter, parameterMap);
            return baseSelect(preparedStatement, xNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override public void close() {
        if (null == connection) return;
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private <T> List<T> resultSet2Obj(ResultSet resultSet, Class<?> clazz) {
        List<T> list = new ArrayList<>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                T obj = (T) clazz.newInstance();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    Object value = resultSet.getObject(i);
                    String columnName = metaData.getColumnName(i);
                    //拼写实例中的set方法
                    String setMethod = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
                    Method method = value instanceof Timestamp ? clazz.getMethod(setMethod, Date.class)
                                                            : clazz.getMethod(setMethod, value.getClass());
                    method.invoke(obj, value);
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 参数写入sql
     * @param preparedStatement
     * @param parameter 参数
     * @param parameterMap 参数名集合
     * @throws SQLException
     * @throws IllegalAccessException
     */
    private void buildParameter(PreparedStatement preparedStatement, Object parameter, Map<Integer, String> parameterMap) throws SQLException, IllegalAccessException {
        int size = parameterMap.size();
        if (parameter instanceof Long) {
            for (int i = 1; i <=size; i++) {
                preparedStatement.setLong(i, Long.parseLong(parameter.toString()));
            }
        } else if (parameter instanceof Integer) {
            for (int i = 1; i <=size; i++) {
                preparedStatement.setInt(i, Integer.parseInt(parameter.toString()));
            }
        }else if (parameter instanceof String) {
            for (int i = 1; i <= size; i++) {
                preparedStatement.setString(i, parameter.toString());
            }
            //多个参数
        } else {
            Map<String, Object> fieldMap = new HashMap<>();
            //对象参数
            Field[] declaredFields = parameter.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                String name = field.getName();
                field.setAccessible(true);
                Object object = field.get(parameter);
                field.setAccessible(false);
                fieldMap.put(name, object);
            }

            for (int i = 0; i <= size; i++) {
                Object object = fieldMap.get(parameterMap.get(i));

                if (object instanceof Short) {
                    preparedStatement.setShort(i, Short.parseShort(object.toString()));
                    continue;
                }

                if (object instanceof Integer) {
                    preparedStatement.setInt(i, Integer.parseInt(object.toString()));
                    continue;
                }

                if (object instanceof Long) {
                    preparedStatement.setLong(i, Long.parseLong(object.toString()));
                    continue;
                }

                if (object instanceof String) {
                    preparedStatement.setString(i, object.toString());
                    continue;
                }

                if (object instanceof Date) {
                    preparedStatement.setDate(i, (java.sql.Date) object);
                }

            }
        }
    }
}

























