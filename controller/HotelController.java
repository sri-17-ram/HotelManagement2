package controller;

import model.Room;
import database.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class HotelController {

    public ArrayList<Room> getRooms() {
        ArrayList<Room> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM rooms");

            while (rs.next()) {
                Room r = new Room(rs.getInt("room_number"), rs.getString("room_type"));
                r.booked = rs.getBoolean("booked");
                r.customerName = rs.getString("customer_name");
                r.phone = rs.getString("phone");
                r.email = rs.getString("email");
                r.daysStayed = rs.getInt("days_stayed");
                r.extraCharges = rs.getInt("extra_charges");
                list.add(r);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String bookRoom(int rn, String name, String phone, String email, int days) {
        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(
                "UPDATE rooms SET booked=1, customer_name='" + name + "', phone='" + phone + "', email='" + email + "', days_stayed=" + days + " WHERE room_number=" + rn
            );
            conn.close();
            return "Room booked!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String addCharges(int rn, int amount) {
        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE rooms SET extra_charges = extra_charges + " + amount + " WHERE room_number=" + rn);
            conn.close();
            return "Charges added!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String checkoutRoom(int rn) {
        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE rooms SET booked=0, customer_name='', phone='', email='', days_stayed=0, extra_charges=0 WHERE room_number=" + rn);
            conn.close();
            return "Checkout complete!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
