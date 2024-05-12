import dao.shange_student;
import entity.student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Collectors;

public class LIBRARY_WINDOW extends  JFrame{
    public static void main(String[] args) throws Exception {
        shange_student sh = new shange_student();
        List<student> studentList = sh.findStreets("");
      //  sh.UpdateStudent(studentList.get(0));
        studentList.forEach(st-> System.out.println(st.getName_()+ st.getId() + st.getAge()+ st.getKlass()));

        Long[] data1 =  studentList
                .stream()
                .map(s->s.getId())
                .collect(Collectors.toList())
                .toArray(new Long[studentList.size()]);

        Long[] data2 =  studentList
                .stream()
                .map(s->s.getAge())
                .collect(Collectors.toList())
                .toArray(new Long[studentList.size()]);

        Long[] data3 =  studentList
                .stream()
                .map(s->s.getKlass())
                .collect(Collectors.toList())
                .toArray(new Long[studentList.size()]);

        String[] data4 =  studentList
                .stream()
                .map(s->s.getFamiliya())
                .collect(Collectors.toList())
                .toArray(new String[studentList.size()]);

        String[] data5 =  studentList
                .stream()
                .map(s->s.getName_())
                .collect(Collectors.toList())
                .toArray(new String[studentList.size()]);

        String[] data6 =  studentList
                .stream()
                .map(s->s.getOtchestvo())
                .collect(Collectors.toList())
                .toArray(new String[studentList.size()]);


        JPanel windowContent = new JPanel();
        final JList<Long> list1 = new JList<Long>(data1);
        final JList<Long> list2 = new JList<Long>(data2);
        final JList<Long> list3 = new JList<Long>(data3);
        final JList<String> list4 = new JList<String>(data4);
        final JList<String> list5 = new JList<String>(data5);
        final JList<String> list6 = new JList<String>(data6);
        windowContent.add(list1);
        windowContent.add(list2);
        windowContent.add(list3);
        windowContent.add(list4);
        windowContent.add(list5);
        windowContent.add(list6);
        FlowLayout fl = new FlowLayout();
        windowContent.setLayout(fl);
        JFrame frame = new JFrame("табличка ученики");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(windowContent);
        frame.setSize(500,300);
        frame.setVisible(true);
    }

}

//добавить поле ввода