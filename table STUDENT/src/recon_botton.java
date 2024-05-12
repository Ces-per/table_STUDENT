import dao.Converter;
import dao.shange_student;

import javax.swing.*;
import java.sql.SQLException;


public class recon_botton {
    public void show(Box contents){


        shange_student sh = new shange_student();
        JTable table1 = null;
        try {
            table1 = new JTable(Converter.buildTableModel(sh.selctstudent()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        table1.setColumnSelectionAllowed(false);
        table1.setRowSelectionAllowed(true);
        table1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contents = new Box(BoxLayout.X_AXIS);
        contents.add(new JScrollPane(table1));
        System.out.println("Обновлено строк ");
    }
}