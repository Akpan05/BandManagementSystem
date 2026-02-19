
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DELL
 */
public class Member {

    private int ID;
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String instrument;
    private int age;
    private String joinDate;

    /**
     * Default constructor
     *
     * @param mID
     * @param fN
     * @param s
     * @param pN
     * @param i
     * @param a
     * @param jD
     */
    public Member(int mID, String fN, String s, String pN, String i, int a, String jD) {
        ID = mID;
        firstName = fN;
        surname = s;
        phoneNumber = pN;
        instrument = i;
        age = a;
        joinDate = jD;
    }

    /**
     * Default constructor (Excludes ID)
     *
     * @param mID
     * @param fN
     * @param s
     * @param pN
     * @param i
     * @param a
     * @param jD
     */
    public Member(String fN, String s, String pN, String i, int a, String jD) {

        firstName = fN;
        surname = s;
        phoneNumber = pN;
        instrument = i;
        age = a;
        joinDate = jD;
    }

    /**
     *
     * @return MemberID from BandMember table
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @return FirstName from BandMember table
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return Surname from BandMember table
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @return PhoneNumber from BandMember table
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @return Instrument from BandMember table
     */
    public String getInstrument() {
        return instrument;
    }

    /**
     *
     * @return Age from BandMember table
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @return JoinDate from BandMember table
     */
    public String getJoinDate() {
        return joinDate;
    }

}
