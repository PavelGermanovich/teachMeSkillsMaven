package homework.lesson24.task1;

import java.util.ArrayList;

public class Flat {
    private ArrayList<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Flat() {
    }

    public Flat(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        StringBuilder flatString = new StringBuilder("Flat with the following rooms: ");
        rooms.forEach(flatString::append);
        return flatString.toString();
    }
}
