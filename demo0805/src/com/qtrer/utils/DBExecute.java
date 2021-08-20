package com.qtrer.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class DBExecute {
    public static void main(String[] args) {
        List<Map<String, Object>> map1 = executeQuery("select * from perinfo");
        List<Map<String, Object>> map2 = executeQuery("select name,pwd from perinfo");
        List<Map<String, Object>> map3 = executeQuery("select * from dish");
        List<Map<String, Object>> map4 = executeQuery("select name from dish");
        map4.forEach(new Consumer<Map<String, Object>>() {
            @Override
            public void accept(Map<String, Object> stringObjectMap) {
                stringObjectMap.forEach(new BiConsumer<String, Object>() {
                    @Override
                    public void accept(String s, Object o) {
                        System.out.println(s+":"+o);
                    }
                });
            }
        });
    }
    public static<T> List<T> executeQuery(Class<T> clazz, String sql, Object...args){
        List<T> list = new ArrayList<>();
        try(PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql)){
            for (int i=0;i<args.length;i++) ps.setObject(i+1,args[i]);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()){
                T t = clazz.getConstructor().newInstance();
                for (int i=1;i<=rsmd.getColumnCount();i++){
                    Field field = clazz.getDeclaredField(rsmd.getColumnName(i));
                    field.setAccessible(true);
                    field.set(t,rs.getObject(rsmd.getColumnLabel(i)));
                }
                list.add(t);
            }

        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Map<String, Object>> executeQuery(String sql, Object...args){
        List<Map<String, Object>> list = new ArrayList<>();
        try(PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql)){
            for (int i=0;i<args.length;i++) ps.setObject(i+1,args[i]);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()){
                Map<String, Object> map = new HashMap<>();
                for (int i=1;i<=rsmd.getColumnCount();i++){
                    map.put(rsmd.getColumnName(i),rs.getObject(rsmd.getColumnLabel(i)));
                }
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Integer executeUpdate(String sql, Object...args){
        try(PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql)){
            for (int i=0;i<args.length;i++) ps.setObject(i+1,args[i]);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
