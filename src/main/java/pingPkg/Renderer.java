package pingPkg;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Renderer
        extends DefaultTableCellRenderer {


        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cr = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (value != null && column == 1) {

                if (value.toString().equals("true")) {
                    setBackground(Color.green);
                } else if(value.toString().equals("false")) {
                    setBackground(Color.red);

                }else{
                    setBackground(Color.white);

                }
            }
            return cr;
        }

    }
