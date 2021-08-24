package com.acabra.clr;

public class HotelRoom {
    private long id;
    private String number;
    private String name;
    private String bedInfo;

    public HotelRoom(long id, String number, String name, String info) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.bedInfo = info;
    }

    public HotelRoom() {
    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", bed info='" + bedInfo + '\'' +
                '}';
    }
}
