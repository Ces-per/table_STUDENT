package buttonexample;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;


public class primer {

    public JTable table;

    public static void main(String[] args) {
        final buttonexample.primer example = new buttonexample.primer();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                example.createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        table = new JTable(new JTableModel());
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        //table.getColumn("Button1").setCellRenderer(buttonRenderer);
        table.getColumn("Button2").setCellRenderer(buttonRenderer);
        table.addMouseListener(new JTableButtonMouseListener(table));

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().setPreferredSize(new Dimension(500, 200));
        frame.pack();
        frame.setVisible(true);
    }

    public static class JTableModel extends AbstractTableModel {
        private static final long serialVersionUID = 1L;
        private static final String[] COLUMN_NAMES = new String[] {"Id", "Stuff", "Asdfsdf", "Button2"};
        private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {Integer.class, String.class, String.class,  JButton.class};

        @Override public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

        @Override public int getRowCount() {
            return 4;
        }

        @Override public String getColumnName(int columnIndex) {
            return COLUMN_NAMES[columnIndex];
        }

        @Override public Class<?> getColumnClass(int columnIndex) {
            return COLUMN_TYPES[columnIndex];
        }

        @Override public Object getValueAt(final int rowIndex, final int columnIndex) {

            switch (columnIndex) {
                case 0: return rowIndex;
                case 1: return "Text for "+rowIndex;
                case 2: return "Column for "+rowIndex;
                case 3: final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            // When this is clicked the whole row will be deleted.
                            JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button),
                                    "Button clicked for row "+rowIndex);
                        }
                    });
                    return button;
                default: return "Error";
            }
        }
    }

    private static class JTableButtonRenderer implements TableCellRenderer {
        @Override public Component getTableCellRendererComponent(JTable table, Object     value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton)value;
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }
            return button;
        }
    }

    private static class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX());
            int row    = e.getY()/table.getRowHeight();

            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() &&
                    column >= 0) {
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton) {
                    ((JButton)value).doClick();
                }
            }
        }
    }
}