package Model;

public class Student {

    private String name;
    private int rollNumber;
    private String address;
    private String phoneNumber;

//    public int getId() {
//        return id;
//    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRollNumber() {
        return this.rollNumber;
    }
    public void setRoll_Number(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
