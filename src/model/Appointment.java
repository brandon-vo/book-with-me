package model;

public class Appointment {

    // Fields
    private String topLength;
    private String buzzCut;
    private String thinOut;
    private String fadeType;
    private String taperType;
    private String sideType;
    private String design;
    private String beard;
    private String lineUp;
    private String appointmentDate;
    private String time;
    private String cost;
    private String uniqueID;

    // Constructor
    public Appointment(String topLength, String buzzCut, String thinOut, String fadeType,
                       String taperType, String sideType, String design, String beard, String lineUp,
                       String appointmentDate, String time, String cost, String uniqueID) {
        this.topLength = topLength;
        this.buzzCut = buzzCut;
        this.thinOut = thinOut;
        this.fadeType = fadeType;
        this.taperType = taperType;
        this.sideType = sideType;
        this.design = design;
        this.beard = beard;
        this.lineUp = lineUp;
        this.appointmentDate = appointmentDate;
        this.time = time;
        this.cost = cost;
        this.uniqueID = uniqueID;
    }

    // Getters
    public String getTopLength() { return topLength; }

    public String getBuzzCut() { return buzzCut; }

    public String getThinOut() { return thinOut; }

    public String getFadeType() { return fadeType; }

    public String getTaperType() { return taperType; }

    public String getSideType() { return sideType; }

    public String getDesign() { return design; }

    public String getBeard() { return beard; }

    public String getLineUp() { return lineUp; }

    public String getAppointmentDate() { return appointmentDate; }

    public String getTime() { return time; }

    public String getCost() { return cost; }

    public String getUniqueID() { return uniqueID; }

    // Getting only relevant data for the appointment (all null is ignored)
    private String getAppointment() {
        String appointments = "";

        if (!this.topLength.contains("null")) {
            appointments += "Top Length: " + this.topLength + " inches, ";
        }
        if (!this.buzzCut.contains("null")) {
            appointments += this.buzzCut + ", ";
        }
        if (!this.thinOut.contains("null")) {
            appointments += this.thinOut + ", ";
        }
        if (!this.fadeType.contains("null")) {
            appointments += this.fadeType + ", ";
        }
        if (!this.taperType.contains("null")) {
            appointments += this.taperType + ", ";
        }
        if (!this.sideType.contains("null")) {
            appointments += this.sideType + ", ";
        }
        if (!this.design.contains("null")) {
            appointments += this.design + ", ";
        }
        if (!this.beard.contains("null")) {
            appointments += this.beard + ", ";
        }
        if (!this.lineUp.contains("null")) {
            appointments += this.lineUp + ", ";
        }
        if (!this.appointmentDate.contains("null")) {
            appointments += "Date: " + this.appointmentDate + ", ";
        }
        if (!this.time.contains("null")){
            appointments += "Time: " + this.time + ", ";
        }
        if (!this.cost.contains("null")) {
            appointments += "Cost: " + this.cost + " ";
        }
        return appointments;
    }

    // toString method
    @Override
    public String toString() {
        String appointments = getAppointment();
        return appointments;
    }
}
