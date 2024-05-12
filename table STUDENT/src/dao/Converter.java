package dao;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.*;
public class Converter {
    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();
        //Вектор со названиями колонок
        Vector<String> columnNames = new Vector<String>();
        //Число колонок
        int columnCount = metaData.getColumnCount();
        //Добавление названий в вектор через цикл
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        //Вектор со строками таблицы(вместо каждой строки вектор типа Object)
        //Вектор, состоящий из векторов содержащих Object
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        //Считывание результсета
        while (rs.next()) {
            //На каждую строку отдельный вектор, содержащий её объект
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                //Добавление к вектору строки в виде типа Object по индексу
                vector.add(rs.getObject(columnIndex));
            }
            //Добавление к дате вектора строки
            data.add(vector);
        }
        //Возврат модели таблицы
        return new DefaultTableModel(data, columnNames);
    }
}
