package com.qtrer.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBExecute {
    public static<T> List<T> executeQuery(Class<T> clazz, String sql, Object...args){
        List<T> list = new ArrayList<>();
        try(PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql)){
            for (int i=0;i< args.length;i++) ps.setObject(i+1, args[i]);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()){
                for (int i=1;i<=rsmd.getColumnCount();i++){
                    T t = clazz.getConstructor().newInstance();
                    Field field = clazz.getDeclaredField(rsmd.getColumnName(i));
                    field.setAccessible(true);
                    field.set(t, rs.getObject(rsmd.getColumnLabel(i)));
                    list.add(t);
                }
            }
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Integer executeUpdate(String sql, Object...args){
        try(PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql)){
            for (int i=0;i< args.length;i++) ps.setObject(i+1, args[i]);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
