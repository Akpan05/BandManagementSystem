
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DELL
 */
public class MemberManager {

    Member bArr[] = new Member[20];
    private int counter;
    Connect cn = new Connect();

    /**
     * Default Constructor
     */
    public MemberManager() {
        Connect db = new Connect();
        ResultSet rs = db.query("Select * from MemberAdmin");

        try {
            while (rs.next()) {
                int mID = rs.getInt("MemberID");
                String fN = rs.getString("FirstName");
                String s = rs.getString("Surname");
                String pN = rs.getString("PhoneNumber");
                String i = rs.getString("Instrument");
                int age = rs.getInt("Age");
                String jD = rs.getString("JoinDate");
                bArr[counter] = new Member(mID, fN, s, pN, i, age, jD);
                counter++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ApplicantManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @return Formatted String of all Members in table
     */
    public String display() {
        String display = "MemberID\t\t\tFirstName\t\t\tSurname\t\t\tPhoneNumber\t\t\tInstrument\t\t\tAge\t\t\tJoinDate\n";
        for (int i = 0; i < counter; i++) {
            display += bArr[i].getID() + "\t\t\t" + bArr[i].getFirstName() + "\t\t\t" + bArr[i].getSurname() + "\t\t\t" + bArr[i].getPhoneNumber() + "\t\t\t"
                    + bArr[i].getInstrument() + "\t\t\t" + bArr[i].getAge() + "\t\t\t" + bArr[i].getJoinDate() + "\n";
        }
        return display;
    }

    /**
     *
     * @param bo
     * @return Adds event to Members table based on user's input
     */
    public int addMember(Member bo) {
        String sql = "Insert into BandAdmin"
                + " (FirstName, Surname, PhoneNumber, Instrument, Age,"
                + " JoinDate) values ("
                + "'" + bo.getFirstName() + "','"
                + bo.getSurname() + "','" + bo.getPhoneNumber() + "','"
                + bo.getInstrument() + "'," + bo.getAge() + ",'"
                + bo.getJoinDate() + "')";

        System.out.println(sql);
        int result = cn.modify(sql);
        return result;
    }

    /**
     *
     * @param id
     * @return Deletes member with matching ID from Event table
     */
    public int delete(int id) {
        int error = cn.modify("DELETE FROM BandAdmin WHERE MemberID =" + id);
        return error;
    }

    /**
     *
     * @param bo
     * @return Updates member with matching ID with the inputted values from the
     * user
     */
    public int updateApplicant(Member bo) {
        String sql = "Update BandAdmin SET FirstName ='" + bo.getFirstName()
                + "', Surname = '" + bo.getSurname() + "', PhoneNumber = '" + bo.getPhoneNumber() + "', Instrument = '" + bo.getInstrument()
                + "', Age =" + bo.getAge() + ", JoinDate = '" + bo.getJoinDate() + "' WHERE MemberID =" + bo.getID();

        System.out.println(sql);
        int result = cn.modify(sql);
        return result;
    }

    /**
     *
     * @param id
     * @return Finds an member with matching ID and returns its details in a
     * formatted String
     */
    public String findMember(int id) {
        String display = "MemberID\t\t\tFirstName\t\t\tSurname\t\t\tPhoneNumber\t\t\tInstrument\t\t\tAge\t\t\tJoinDate\n";
        for (int i = 0; i < counter; i++) {
            if (bArr[i].getID() == id) {
                display += bArr[i].getID() + "\t\t\t" + bArr[i].getFirstName() + "\t\t\t" + bArr[i].getSurname() + "\t\t\t" + bArr[i].getPhoneNumber() + "\t\t\t"
                        + bArr[i].getInstrument() + "\t\t\t" + bArr[i].getAge() + "\t\t\t" + bArr[i].getJoinDate() + "\n";
            }
        }
        return display;
    }

}
