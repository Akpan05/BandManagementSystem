/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ApplicantManager {

    private int counter;
    Connect cn = new Connect();
    ApplicantObj aArr[] = new ApplicantObj[200];

    /**
     * Default constructor
     */
    public ApplicantManager() {
        Connect db = new Connect();
        ResultSet rs = db.query("Select * from ApplicantAdmin");

        try {
            while (rs.next()) {
                int aID = rs.getInt("ApplicantID");
                String fN = rs.getString("FirstName");
                String sN = rs.getString("Surname");
                String pN = rs.getString("PhoneNumber");
                int a = rs.getInt("Age");
                String mID = rs.getString("Instrument");
                String aD = rs.getString("ApplicationDate");
                String s = rs.getString("Status");
                int yE = rs.getInt("YearsExperience");
                aArr[counter] = new ApplicantObj(aID, fN, sN, pN, a, mID, aD, s, yE);
                counter++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ApplicantManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @return displays all applicants from the applicants table
     */
    public String display() {
        String display = "ApplicantID\t\t\tFirstName\t\t\tSurname\t\t\tPhoneNumber\t\t\tAge\t\t\tInstrument\t\t\tApplicationDate\t\t\tStatus\t\t\tYearsExperience\n";
        for (int i = 0; i < counter; i++) {
            display += aArr[i].getID() + "\t\t\t" + aArr[i].getFirstName() + "\t\t\t" + aArr[i].getSurname() + "\t\t\t" + aArr[i].getPhoneNumber() + "\t\t\t"
                    + aArr[i].getAge() + "\t\t\t" + aArr[i].getInstrument() + "\t\t\t" + aArr[i].getApplicationDate() + "\t\t\t" + aArr[i].getStatus() + "\t\t\t"
                    + aArr[i].getYearsExp() + "\n";
        }
        return display;
    }

    /**
     *
     * @param applicantObj
     * @return adds an applicant to applicant table with the details the user
     * puts in
     */
    public int addApplicant(ApplicantObj applicantObj) {
        String sql = "Insert into ApplicantAdmin"
                + " (FirstName, Surname, PhoneNumber, Age,"
                + "  Instrument ,ApplicationDate,Status, YearsExperience) values ("
                + "'" + applicantObj.getFirstName() + "','"
                + applicantObj.getSurname() + "','" + applicantObj.getPhoneNumber() + "',"
                + applicantObj.getAge() + ",'" + applicantObj.getInstrument() + "',"
                + applicantObj.getApplicationDate() + ",'" + applicantObj.getStatus() + "','"
                + applicantObj.getYearsExp() + "')";

        System.out.println(sql);
        int result = cn.modify(sql);
        return result;
    }

    /**
     *
     * @param applicantObj
     * @return updates the applicant with the matching ID with the values
     * inputted in UI
     */
    public int updateApplicant(ApplicantObj applicantObj) {
        String sql = "Update ApplicantAdmin SET FirstName ='" + applicantObj.getFirstName()
                + "', Surname = '" + applicantObj.getSurname() + "', PhoneNumber = '" + applicantObj.getPhoneNumber()
                + "', Age =" + applicantObj.getAge() + ", MemberID = " + applicantObj.getInstrument() + ", ApplicationDate = '" + applicantObj.getApplicationDate() + "', Status = '" + applicantObj.getStatus()
                + "', YearsExperience =" + applicantObj.getYearsExp() + " WHERE ApplicantID =" + applicantObj.getID();

        System.out.println(sql);
        int result = cn.modify(sql);
        return result;
    }

    /**
     *
     * @param id
     * @return deletes the record of the applicant with the matching ID
     */
    public int delete(int id) {
        int error = cn.modify("DELETE FROM ApplicantAdmin WHERE ApplicantID =" + id);
        return error;
    }

    /**
     *
     * @param id
     * @return //Finds an applicant based on their ID and returns a String
     * display of their details
     */
    public String findAppl(int id) {
        String display = "ApplicantID\t\t\tFirstName\t\t\tSurname\t\t\tPhoneNumber\t\t\tAge\t\t\tInstrument\t\t\tApplicationDate\t\t\tStatus\t\t\tYearsExperience\n";
        for (int i = 0; i < counter; i++) {
            if (aArr[i].getID() == id) {
                display += aArr[i].getID() + "\t\t\t" + aArr[i].getFirstName() + "\t\t\t" + aArr[i].getSurname() + "\t\t\t" + aArr[i].getPhoneNumber() + "\t\t\t"
                        + aArr[i].getAge() + "\t\t\t" + aArr[i].getInstrument() + "\t\t\t" + aArr[i].getApplicationDate() + "\t\t\t" + aArr[i].getStatus() + "\t\t\t"
                        + aArr[i].getYearsExp() + "\n";
            }
        }
        return display;
    }
}
