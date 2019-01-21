package pingPkg;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

public class ipTable extends JFrame {
    private JTable overview;
    private JPanel ipPanel;
    private JScrollPane ipScroll;
    DefaultTableModel tableModel = new DefaultTableModel();
    controller Controller = new controller();

    public ipTable()  {
        setTitle(misc.getModalTitle());
        setSize(misc.getScreenWidth(), misc.getScreenHeight());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(ipPanel);
        iniTable();
        iniCheckIP();


        // Kill all thread pertaining to this program
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

    }

    public void iniTable(){
        tableModel.addColumn("ip");
        tableModel.addColumn("Status");
        tableModel.addColumn("time");
        overview.setModel(tableModel);
        overview.setDefaultEditor(Object.class, null);
        JTableHeader header = overview.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 15));
        overview.setFont(new Font("", 1, 12));
        overview.setRowHeight(30);
        for(int index =0; index < 255; index++) {
            tableModel.addRow(new Object[]{new misc().getbaseIP() + index, ""});
        }

    }

    public void iniCheckIP(){
        Controller.checkIP();
        // New timer which works!
        int delay = 1000; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for(pingModel pingList: Controller.getPingObject()){
                    for (Map.Entry<Integer, Boolean> entry : pingList.result().entrySet()) {
                        int key = entry.getKey();
                        Boolean val = entry.getValue();
                        tableModel.setValueAt(val, key, 1);
                        tableModel.setValueAt(pingList.time(), key, 2);
                        Controller.writeToFile(new misc().getbaseIP() + key + " | " + val + " | " + pingList.time() );
                        TableColumn col = overview.getColumnModel().getColumn(1);
                        DefaultTableModel model3 = (DefaultTableModel)overview.getModel();
                        col.setCellRenderer(new Renderer());
                        model3.fireTableDataChanged();

                    }
                }
            }
        };
        new Timer(delay, taskPerformer).start();
    }
}


