package Main;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        ArrayList<Patient> p0 = new ArrayList<>();

        String Datebir = "01.04.1981";
        Date datebir = null;
        try {
            datebir = new SimpleDateFormat("dd.mm.yyyy").parse(Datebir);
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Nem megfelelő dátum formátum !");
        }


        p0.add( new Patient("000 000 001", "Joe", "Smith", datebir,  181, "A+", "Active",true));
//        p0.add( new Patient("000 000 002", "John", "Smith", "1981.05.01", 175, "AB+", "Active",false));
//        p0.add( new Patient("000 000 003", "John", "Doe", "02.02.1966", 170, "O+", "Active",true));

        Patient.DataList(p0);
        Patient.WriteXML(p0,"./patient.xml");
/*
        p0 = Patient.DataAdd("000 000 004", "Jessie", "James", "01.04.1981", 180, "B-", "Active");
        Patient.WriteXML(p0);
        Patient.DataList(p0);

        ArrayList<Patient> p1 = Patient.ReadXML();

        Patient.DataList(p1);

        Patient.DataList(p0);

        ArrayList<Patient> p2 = Patient.DataDelete(p0,"000 000 002");

        Patient.DataList(p2);
*/
    }
/*
    public static ArrayList<Patient> DataDelete(ArrayList<Patient> p, String taj_field) {

        Integer i;

        for (i=0; i<p.size(); i++) {
            if (p.get(i).getTAJ() == taj_field) {
                p.remove(i+0);
            }
        }
        return p;
    }

    public static ArrayList<Patient> DataAdd(String taj_field, String firstname_field, String lastname_field, String dateofbirth_field, Integer height_field, String bloodtype_field, String status_field) {

        ArrayList<Patient> p = ReadXML();

        p.add(new Patient(taj_field,firstname_field,lastname_field,dateofbirth_field,height_field,bloodtype_field,status_field));

        return p;
    }

    public static void DataList(ArrayList<Patient> p) {
        int i;
        for (i = 0;i < p.size(); i++) {
            System.out.println(p.get(i).ListPatient());
        }
    }

    public static void WriteXML(ArrayList<Patient> p) {
        try{
            FileOutputStream fos = new FileOutputStream(new File("./patient.xml"));
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(p);
            encoder.close();
            fos.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static ArrayList<Patient> ReadXML() {

        try{
            FileInputStream fis = new FileInputStream(new File("./patient.xml"));
            XMLDecoder decoder = new XMLDecoder(fis);

            ArrayList<Patient> p1 = (ArrayList<Patient>) decoder.readObject();
            decoder.close();
            fis.close();
            return p1;
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return null;
    } */
}



