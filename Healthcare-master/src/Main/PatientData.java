package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class PatientData {
    private JPanel rootPanel;
    private JTable showTable;
    private final String[] COLUMNS = {"ID/TAJ","First Name","Last Name","Date Of Birth","Height","Blood Type","Note","Status"};

    ArrayList<Patient>  patientlist = new ArrayList<>();

    public PatientData() {
        createTable();
    }

    public static void listData() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void createTable() {
        DefaultTableModel model = (DefaultTableModel) showTable.getModel();
        patientlist  = Patient.ReadXML("./patient.xml");
        Object rowData[] = new Object[8];
        for(Integer i = 0; i < patientlist.size(); i++) {
            rowData[0] = patientlist.get(i).getTAJ();
            rowData[1] = patientlist.get(i).getFirstName();
            rowData[2] = patientlist.get(i).getLastName();
            rowData[3] = patientlist.get(i).getDateOfBirth();
            rowData[4] = patientlist.get(i).getHeight();
            rowData[5] = patientlist.get(i).getBloodType();
            rowData[6] = patientlist.get(i).getNote();
            rowData[7] = patientlist.get(i).getStatus();
            model.addRow(rowData);
        }

        //        showTable.setModel(new DefaultTableModel(model, new String[] {"ID/TAJ","First Name","Last Name","Date Of Birth","Height","Blood Type","Note","Status"}));
    }

    public static void createGUI() {
        PatientData ui = new PatientData();
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Patient Database List");
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}