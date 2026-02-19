
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventManager {

    Connect cn = new Connect();
    EventObj eArr[] = new EventObj[200];
    private int counter;

    /**
     * Default constructor
     */
    public EventManager() {
        Connect db = new Connect();
        ResultSet rs = db.query("Select * from EventsAdmin");

        try {
            while (rs.next()) {
                int evID = rs.getInt("EventID");
                String eD = rs.getString("EventDate");
                String eN = rs.getString("EventName");
                String loc = rs.getString("Location");
                String desc = rs.getString("Description");
                eArr[counter] = new EventObj(evID, eN, desc, loc, eD);
                counter++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ApplicantManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @return Formatted String of all Events in table
     */
    public String display() {
        String display = String.format("%-12s %-25s %-18s %-18s %-35s%n",
                "EventID", "EventName", "EventDate", "Location", "Description");

        for (int i = 0; i < counter; i++) {
            display += String.format("%-12s %-25s %-18s %-18s %-35s%n",
                    eArr[i].getEventID(),
                    eArr[i].getEventName(),
                    eArr[i].getEventDate(),
                    eArr[i].getLocation(),
                    eArr[i].getDescription()
            );
        }

        return display;
    }

    /**
     *
     * @param eo
     * @return Adds event to Events table based on user's input
     */
    public int addEvent(EventObj eo) {

        String sql = "Insert into EventsAdmin"
                + " (EventName, Description, Location, EventDate"
                + ") values ("
                + "'" + eo.getEventName() + "','"
                + eo.getDescription() + "','" + eo.getLocation() + "','" + eo.getEventDate()
                + "')";
        System.out.println(sql);
        int result = cn.modify(sql);
        return result;
    }

    /**
     *
     * @param eo
     * @return Updates event with matching ID with the inputted values from the
     * user
     */
    public int updateEvent(EventObj eo) {
        String sql = "Update EventsAdmin SET EventName ='" + eo.getEventName()
                + "', EventDate = '" + eo.getEventDate() + "', Location = '" + eo.getLocation()
                + "', Description = '" + eo.getDescription() + "' WHERE EventID =" + eo.getEventID();

        System.out.println(sql);
        int result = cn.modify(sql);
        return result;
    }

    /**
     *
     * @param id
     * @return Deletes event with matching ID from Event table
     */
    public int delete(int id) {
        int error = cn.modify("DELETE FROM EventsAdmin WHERE EventID =" + id);
        return error;
    }

    /**
     *
     * @param id
     * @return Finds an event with matching ID and returns its details in a
     * formatted String
     */
    public String findEvent(int id) {
        String display = String.format("%-12s %-25s %-18s %-18s %-35s%n",
                "EventID", "EventName", "EventDate", "Location", "Description");

        for (int i = 0; i < counter; i++) {
            if (id == eArr[i].getEventID()) {
                display += String.format("%-12s %-25s %-18s %-18s %-35s%n",
                        eArr[i].getEventID(),
                        eArr[i].getEventName(),
                        eArr[i].getEventDate(),
                        eArr[i].getLocation(),
                        eArr[i].getDescription()
                );
            }

        }

        return display;
    }

    /**
     * sorts events according to how close they are to current date
     */
    public void sortEvents() {
        for (int i = 0; i < counter - 1; i++) {
            for (int j = i + 1; j < counter; j++) {
                if (LocalDate.parse(eArr[i].getEventDate()).isAfter(LocalDate.parse(eArr[j].getEventDate()))) {
                    EventObj temp = eArr[j];
                    eArr[j] = eArr[i];
                    eArr[i] = temp;
                }
            }
        }

    }
}
