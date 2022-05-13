package Main;

/*import com.sun.tools.javac.Main; */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HealthCare extends JFrame implements ActionListener {
    private JTextField textField_firstname;
    private JTextField textField_lastname;
    private JTextField textField_datebirth;
    private JTextField textField_height;
    private JTextField textField_blood;
    private JTextField textField_database_count;
    private JTextField textField_id;
    private JButton newButton;
    private JButton deletePatientButton;
    private JButton saveXMLButton;
    private JButton cancelButton;
    private JComboBox Combo_DataList;
    private JTextField textField_database_size;
    private JPanel mainPanel;
    private JButton exitButton;
    private JLabel textMessage;
    private JButton loadXMLFileButton;
    private JTextField patientXmlTextField;
    private JRadioButton activeRadioButton;
    private JRadioButton inactiveRadioButton;
    private JTextArea textArea1_note;
    private JButton updateButton;
    private JButton databaseListButton;


    ArrayList<Patient> patients = new ArrayList<>();
    boolean status = true;
    Integer aktual_record = null;
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");

    public HealthCare() {
        setContentPane(mainPanel);
        setTitle("HealthCare");
        setSize(650,540);
        setVisible(true);

        loadXMLFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patients = Patient.ReadXML(patientXmlTextField.getText());
                if(patients == null) {
                    JOptionPane.showMessageDialog(null,"Nem létezik a betölteni kívánt "+ patientXmlTextField.getText() + " fájl !");
                } else {
                    textField_database_size.setText(Integer.toString(patients.size()));
                    textMessage.setText("Adatok betöltése a " + patientXmlTextField.getText() + " fájlból megtörtént !");
                    loadComboBoxItem();
                }
            }
        });

        saveXMLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(patients.size() == 0) {
                    JOptionPane.showMessageDialog(null,"Üres az adatbázis ezért nem menthető a "+ patientXmlTextField.getText() + " fájlba !");
                } else {
                    Patient.WriteXML(patients, patientXmlTextField.getText());
                    textField_database_size.setText(Integer.toString(patients.size()));
                    textMessage.setText("Adatok mentése a " + patientXmlTextField.getText() + " fájlba megtörtént !");
                    textField_database_size.setText("");
                }
            }
        });

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean id_use = false;

                if (textField_id.getText().getBytes().length == 0) {
                    JOptionPane.showMessageDialog(null,"Nincs megadva azonosító !");
                } else {
                    for (Integer i = 0; i < patients.size(); i++) {
                        if (patients.get(i).getTAJ().equals(textField_id.getText())) {
                            id_use = true;
                        }
                    }
                    if (id_use == true) {
                        JOptionPane.showMessageDialog(null, "Ez az azonosító már létezik, kérem adjon meg másikat !");
                    } else {
                        Integer heigght = Integer.parseInt(textField_height.getText());
                        String Datebir = textField_datebirth.getText();
                        Date datebir = null;
                        try {
                            datebir = new SimpleDateFormat("dd.MM.YYYY").parse(Datebir);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                        patients.add(new Patient(textField_id.getText(),textField_firstname.getText(),textField_lastname.getText(), datebir,heigght,textField_blood.getText(),textArea1_note.getText(),status));
                        textField_database_size.setText(Integer.toString(patients.size()));
                        textMessage.setText("Adatok mentése a memóriába megtörtént !");
                        Combo_DataList.addItem(textField_id.getText());
//                        clear_field();
                    }
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer id_use = null;

                if(textField_id.getText().getBytes().length == 0) {
                    JOptionPane.showMessageDialog(null,"Nincs megadva azonosító !");
                } else {
                    for (Integer i=0; i<patients.size(); i++) {
                        if (patients.get(i).getTAJ().equals(textField_id.getText())) {
                            id_use = i;
                        }
                    }
                    if (id_use != null) {
                        String Datebir = textField_datebirth.getText();
                        Date datebir = null;
                        try {
                            datebir = new SimpleDateFormat("dd.MM.YYYY").parse(Datebir);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null,"Nem megfelelő dátum formátum !");
                        }
                        patients.get(aktual_record).setFirstName(textField_firstname.getText());
                        patients.get(aktual_record).setLastName(textField_lastname.getText());
                        patients.get(aktual_record).setDateOfBirth(datebir);
                        patients.get(aktual_record).setHeight(Integer.parseInt(textField_height.getText()));
                        patients.get(aktual_record).setBloodType(textField_blood.getText());
                        patients.get(aktual_record).setNote(textArea1_note.getText());
                        textMessage.setText("Adatok módosítása megtörtént a memóriába !");
                    } else {
                        JOptionPane.showMessageDialog(null,"Nincs a keresésnek megfelelő adat !");
                    }
                }
            }
        });

        deletePatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer id_use = null;

                if (textField_id.getText().getBytes().length == 0) {
                    JOptionPane.showMessageDialog(null,"Nincs megadva azonosító !");
                } else {
                    for (Integer i=0; i<patients.size(); i++) {
                        if (patients.get(i).getTAJ().equals(textField_id.getText())) {
                            id_use = i;
                        }
                    }
                    if (id_use != null) {
                        patients.remove(id_use+0);
                        textField_database_size.setText(Integer.toString(patients.size()));
                        textField_database_count.setText(Integer.toString(id_use));
                        textMessage.setText("Adatok törlése a memóriából megtörtént !");
                        Combo_DataList.removeItemAt(id_use+0);
                        clear_field();
                    } else {
                        JOptionPane.showMessageDialog(null,"Nincs a keresésnek megfelelő adat !");
                    }
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear_field();
            }
        });

        Combo_DataList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(Combo_DataList.getSelectedIndex());
                if(e.getID() > 0) {
                    load_field(Combo_DataList.getSelectedIndex());
                    textField_database_count.setText(String.valueOf(Combo_DataList.getSelectedIndex() + 1));
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("EXIT");
                if(JOptionPane.showConfirmDialog(frame,"Biztosan kilép a programból ?", "EXIT HealthCare",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }
            }
        });

        activeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status = true;
                patients.get(aktual_record).setStatus(true);
            }
        });

        inactiveRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status = false;
                patients.get(aktual_record).setStatus(false);
            }
        });
//
        databaseListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientData.listData();
            }
        });
    }

    public static void main(String[] args) {
        HealthCare myFrame = new HealthCare();
    }

    public void loadComboBoxItem() {
//        try {
            if (Combo_DataList.getItemCount() <= 0) {
                for (Integer i = 0; i < patients.size(); i++) {
                    Combo_DataList.addItem(patients.get(i).getTAJ());
                }
            }
//         }
//        catch(Exception e) {
//            System.out.println(e);
//        }
    }

    public void clear_field() {
        this.textField_id.setText("");
        this.textField_firstname.setText("");
        this.textField_lastname.setText("");
        this.textField_datebirth.setText("");
        this.textField_height.setText("");
        this.textField_blood.setText("");
        this.textArea1_note.setText("");
        this.textMessage.setText("");
        this.activeRadioButton.setSelected(true);
    }

    public void load_field(Integer index) {
        aktual_record = index;
        this.textField_id.setText(this.patients.get(index).getTAJ());
        this.textField_firstname.setText(this.patients.get(index).getFirstName());
        this.textField_lastname.setText(this.patients.get(index).getLastName());
        this.textField_datebirth.setText(this.dateFormat.format(patients.get(index).getDateOfBirth()));
        this.textField_height.setText(this.patients.get(index).getHeight().toString());
        this.textField_blood.setText(this.patients.get(index).getBloodType());
        this.textArea1_note.setText(this.patients.get(index).getNote());
        this.textField_database_count.setText("");
        this.textField_database_size.setText(Integer.toString(patients.size()));
        this.textMessage.setText("");
        status = this.patients.get(index).getStatus().booleanValue();
        if (this.patients.get(index).getStatus().booleanValue() == true) {
            this.activeRadioButton.setSelected(true);
        } else {
            this.inactiveRadioButton.setSelected(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
