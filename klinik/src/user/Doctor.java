package user;

import types.Gender;

public class Doctor extends User{
    private long fees;

    public Doctor(String id, String name, int age, Gender gender, long fees) {
        super(id,name,age,gender);
        this.fees = fees;
    }

    public long getFees() {
        return fees;
    }

    public void setFees(long fees) {
        this.fees = fees;
    }

    public void print() {
        System.out.println("-----doctor-----");
        System.out.printf("| %-12s |%n","name: " + this.name);
        System.out.printf("| %-12s |%n","age: " + this.age);
        System.out.printf("| %-12s |%n","gender: " + this.gender);
        System.out.printf("| %-12s |%n","fees: " + this.fees);
        System.out.println("----------------");
    }
}
