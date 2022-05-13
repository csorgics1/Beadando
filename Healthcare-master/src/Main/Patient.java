package Main;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Patient {
    private String TAJ;             /* azonosító 000000001 */
    private String FirstName;       /* Kereszt név */
    private String LastName;        /* Vezeték név */
    private Date DateOfBirth;       /* 1970.01.01 */
    private Integer Height;         /* 187 */
    private String BloodType;       /* A+, A- stb. */
    private String Note;            /* Egészséges, Beteg */
    private Boolean Status;         /* Active = True, Inactive = False */

    public Patient() {
    }

    public Patient(String TAJ, String FirstName, String LastName, Date DateOfBirth, Integer Height, String BloodType, String Note, Boolean Status) {
        this.TAJ = TAJ;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.DateOfBirth = DateOfBirth;
        this.Height = Height;
        this.BloodType = BloodType;
        this.Note = Note;
        this.Status = Status;
    }

    public Patient(Patient patient) {
    }

    public String ListPatient() {
        return TAJ+" "+FirstName+" "+LastName+" "+DateOfBirth+" "+Height+" "+BloodType+" "+Note+" "+Status;
    }

    public String getTAJ() { return TAJ; }

    public void setTAJ(String TAJ) {
        this.TAJ = TAJ;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public Integer getHeight() {
        return Height;
    }

    public void setHeight(Integer height) {
        Height = height;
    }

    public String getBloodType() {
        return BloodType;
    }

    public void setBloodType(String bloodType) {
        BloodType = bloodType;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public static ArrayList<Patient> DataDelete(ArrayList<Patient> p, String taj_field) {

        for (Integer i=0; i<p.size(); i++) {
            if (p.get(i).getTAJ() == taj_field) {
                p.remove(i+0);                      /* Miért kell a +0 */
            }
        }
        return p;
    }

    public static ArrayList<Patient> DataAdd(String taj_field, String firstname_field, String lastname_field, Date dateofbirth_field, Integer height_field, String bloodtype_field, String note_field, Boolean status_filed) {

        ArrayList<Patient> p = ReadXML("./patient.xml");


        p.add(new Patient(taj_field,firstname_field,lastname_field,dateofbirth_field,height_field,bloodtype_field,note_field,status_filed));

        return p;
    }

    public static void DataList(ArrayList<Patient> p) {

        for (Integer i=0; i<p.size(); i++) {
            System.out.println(p.get(i).ListPatient());
        }
    }

    public static void WriteXML(ArrayList<Patient> p, String xmlfile_name) {
        try{
            FileOutputStream fos = new FileOutputStream(new File(xmlfile_name));
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(p);
            encoder.close();
            fos.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static ArrayList<Patient> ReadXML(String xmlfile_name) {

        try{
            FileInputStream fis = new FileInputStream(new File(xmlfile_name));
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
    }
}