package model;

public class Room {
    public int roomNumber;
    public String type;
    public boolean booked;
    public String customerName;
    public String phone;
    public String email;
    public int daysStayed;
    public int extraCharges;

    public Room(int rn, String type) {
        this.roomNumber = rn;
        this.type = type;
    }
}
