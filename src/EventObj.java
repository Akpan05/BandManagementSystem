
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DELL
 */
public class EventObj {

    private int eventID;

    /**
     *
     * @return EventID from Events table
     */
    public int getEventID() {
        return eventID;
    }
    private String eventDate;
    private String eventName;
    private String location;
    private String description;

    /**
     *
     * @return EventDate from Events table
     */
    public String getEventDate() {
        return eventDate;
    }

    /**
     *
     * @return EventName from Events table
     */
    public String getEventName() {
        return eventName;
    }

    /**
     *
     * @return Location from Events table
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @return Description from Events table
     */
    public String getDescription() {
        return description;
    }

    /**
     * Default Constructor (excludes EventID)
     *
     * @param eN
     * @param desc
     * @param loc
     * @param eD
     */
    public EventObj(String eN, String desc, String loc, String eD) {

        eventDate = eD;
        eventName = eN;
        location = loc;
        description = desc;
    }

    /**
     * Default Constructor
     *
     * @param eN
     * @param desc
     * @param loc
     * @param eD
     */
    public EventObj(int evID, String eN, String desc, String loc, String eD) {
        eventID = evID;
        eventDate = eD;
        eventName = eN;
        location = loc;
        description = desc;
    }

}
