
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DELL
 */
public class ApplicantObj extends Member {

    private String applicationDate;
    private String status;
    private int yearsExp;

    /**
     *
     * @return ApplicationDate from applicant table
     */
    public String getApplicationDate() {
        return applicationDate;
    }

    /**
     *
     * @return Status from applicant table
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @return YearsExp from applicant table
     */
    public int getYearsExp() {
        return yearsExp;
    }

    /**
     * Default Constructor
     *
     * @param aID
     * @param fN
     * @param sN
     * @param pN
     * @param age
     * @param instrument
     * @param aD
     * @param s
     * @param yE
     */
    public ApplicantObj(int aID, String fN, String sN, String pN, int age, String instrument, String aD, String s, int yE) {
        super(aID, fN, sN, pN, instrument, age, null);
        applicationDate = aD;
        status = s;
        yearsExp = yE;
    }

    /**
     * Default Constructor (excludes applicantID)
     *
     * @param aID
     * @param fN
     * @param sN
     * @param pN
     * @param age
     * @param instrument
     * @param aD
     * @param s
     * @param yE
     */
    public ApplicantObj(String fN, String sN, String pN, int age, String instrument, String aD, String s, int yE) {

        super(fN, sN, pN, instrument, age, null);
        applicationDate = aD;
        status = s;
        yearsExp = yE;
    }

}
