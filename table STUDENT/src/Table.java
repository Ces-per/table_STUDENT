
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import dao.Converter;
import dao.shange_student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

import static javax.swing.SwingConstants.CENTER;

public class Table extends JFrame{
    public Table() throws SQLException{
        //Создание окна
        super("Library");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Подключение к базе данных и получение результсета таблицы

        Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "1");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, age, klass, \"Familiya\", \"Name_\", \"Otchestvo\"\n" +
                "\tFROM public.\"ученики\"\n" +
                "\twhere delet= true;");
        //Создание таблицы и помещение в блок данных
        shange_student sh = new shange_student();
        JTable table = new  JTable(Converter.buildTableModel(rs));
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Box contents = new Box(BoxLayout.X_AXIS);
        contents.add(new JScrollPane(table));




        //Создание кнопки и помещение в панель со всеми кнопками
        JButton insert = new JButton("Добавить запись");
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setVisible(false);
                JFrame frame = new JFrame("табличка ученики");
                button b = new button();
                b.show(frame);
                //setVisible(true);
            }
        });

        JButton change = new JButton("Изменить");
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setVisible(false);
                JFrame uframe = new JFrame("изменить учеников");
                update_button ub = new update_button();
                ub.show(uframe);
                //setVisible(true);
            }
        });

        JButton delet = new JButton("Удалить");
        delet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setVisible(false);
                JFrame dframe = new JFrame("удалить учеников");
                delet_button db = new delet_button();
                db.show(dframe);
                //setVisible(true);
            }
        });

        JButton recon = new JButton("recon");
        recon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contents.remove(new JScrollPane(table));

                ResultSet rs = null;
                try {
                    rs = stmt.executeQuery("SELECT id, age, klass, \"Familiya\", \"Name_\", \"Otchestvo\"\n" +
                            "\tFROM public.\"ученики\"\n" +
                            "\twhere delet= true;");
                JTable table1 = new  JTable(Converter.buildTableModel(rs));
                table1.setColumnSelectionAllowed(false);
                table1.setRowSelectionAllowed(true);
                table1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                Box contents1 = new Box(BoxLayout.X_AXIS);
                contents1.add(new JScrollPane(table1));
                getContentPane().add(contents1);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                /*recon_botton rb = new recon_botton();
                rb.show(contents);*/


            }
        });

        JPanel Buttons = new JPanel();
        Buttons.add(insert);
        Buttons.add(change);
        Buttons.add(delet);
        Buttons.add(recon);
        //Оформление окна(добавление в него блока с таблице и панели кнопок, задача размера)
        getContentPane().add(contents);

        getContentPane().add(Buttons, BorderLayout.EAST);
        setSize(800,400);
        setVisible(true);


    }
    public static void main(String[] args) throws Exception {
        //Запуск конструктора класса, образующего окно
        new Table();
    }
}
// добавтиь кнопку для повторнрого получения даных из таблици