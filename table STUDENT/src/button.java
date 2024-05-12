import dao.shange_student;
import entity.student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import static com.sun.glass.ui.Cursor.setVisible;

public class button {

    public void show(JFrame frame) {

        JPanel windowContent = new JPanel();
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        windowContent.setLayout(fl);

       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(windowContent);
        frame.setSize(360,400);
        frame.setVisible(true);

        JLabel id_name = new JLabel("Id");
        frame.add(id_name);
        id_name.setSize(100,20);
        id_name.setVisible(true);
        JTextField id_field = new JTextField(25);
        id_field.setToolTipText("Введите id");
        frame.add(id_field);
        id_field.setSize(100,20);
        id_field.setVisible(true);

        JLabel age_name = new JLabel("Возраст");
        frame.add(age_name);
        age_name.setVisible(true);
        age_name.setSize(100,20);
        JTextField age_field = new JTextField(25);
        age_field.setToolTipText("Введите возраст");
        frame.add(age_field);
        age_field.setSize(100,20);
        age_field.setVisible(true);

        JLabel class_name = new JLabel("Класс");
        frame.add(class_name);
        class_name.setSize(100,20);
        class_name.setVisible(true);
        JTextField class_field = new JTextField(25);
        class_field.setToolTipText("Введите класс");
        frame.add(class_field);
        class_field.setSize(100,20);
        class_field.setVisible(true);

        JLabel lastname_name = new JLabel("Фамилия");
        frame.add(lastname_name);
        lastname_name.setVisible(true);
        lastname_name.setSize(100,20);
        JTextField lastname_field = new JTextField(25);
        lastname_field.setToolTipText("Введите фамилию");
        frame.add(lastname_field);
        lastname_field.setVisible(true);
        lastname_field.setSize(100,20);

        JLabel name_name = new JLabel("Имя");
        frame.add(name_name);
        name_name.setVisible(true);
        name_name.setSize(100,20);
        JTextField name_field = new JTextField(25);
        name_field.setToolTipText("Введите име");
        frame.add(name_field);
        name_field.setVisible(true);
        name_field.setSize(100,20);

        JLabel middlename_name = new JLabel("Отчество");
        frame.add(middlename_name);
        middlename_name.setVisible(true);
        middlename_name.setSize(100,20);
        JTextField middlename_field = new JTextField(25);
        middlename_field.setToolTipText("Введите отчество");
        frame.add(middlename_field);
        middlename_field.setSize(100,20);
        middlename_field.setVisible(true);

        JButton add = new JButton("Добавить");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                student st = new student();
                st.setId(Long.valueOf(id_field.getText()));
                st.setage(Long.valueOf(age_field.getText()));
                st.setKlass(Long.valueOf(class_field.getText()));
                st.setFamiliya(lastname_field.getText());
                st.setName_(name_field.getText());
                st.setOtchestvo(middlename_field.getText());
                new shange_student().createstudent(st);
            }
        });

        windowContent.add(add);
    }
}