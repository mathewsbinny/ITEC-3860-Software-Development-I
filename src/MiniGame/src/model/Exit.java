package model;

public class Exit {
    //The Exit class contains the direction and destination room ID.

    private Direction direction;
    private Integer roomId;

    //Getters & Setters
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public Integer getRoomId() {
        return roomId;
    }
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Exit(Direction direction, Integer roomId) {
        this.direction = direction;
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Exit{" +
                "direction='" + direction + '\'' +
                ", roomId=" + roomId +
                '}';
    }
}
