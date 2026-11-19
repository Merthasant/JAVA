package user;

import types.Gender;

public class Patient extends User{
    private String complaint;

    public Patient(String id, String name, int age, Gender gender, String complaint) {
        super(id,name,age,gender);
        this.complaint = complaint;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public void print() {
        System.out.println("-----doctor-----");
        System.out.printf("| %-12s |%n","name: " + this.name);
        System.out.printf("| %-12s |%n","age: " + this.age);
        System.out.printf("| %-12s |%n","gender: " + this.gender);
        System.out.printf("| %-12s |%n","fees: " + this.complaint);
        System.out.println("----------------");
    }
}
