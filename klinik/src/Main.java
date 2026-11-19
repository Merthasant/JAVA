import bills.CommonBills;
import bills.InsuranceBills;
import relations.Promise;
import types.AppointmentStatus;
import types.Gender;
import user.Doctor;
import user.Patient;
import utils.InputUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final InputUtils input = new InputUtils();

    private static final List<Doctor> doctorList = new ArrayList<>();
    private static final List<Patient> patientList = new ArrayList<>();
    private static final List<Promise> promiseList = new ArrayList<>();
    private static final List<CommonBills> commonBillsList = new ArrayList<>();
    private static final List<InsuranceBills> insuranceBillsList = new ArrayList<>();


    public static void main(String[] args) {
        setup();
        boolean running = true;
        while(running) {
            System.out.println("=== clinic ===");
            System.out.println("1. doctor");
            System.out.println("2. patient");
            System.out.println("3. promise");
            System.out.println("4. bills");
            System.out.println("0. exit");
            int choice = input.inputInt("choice: ", 0, 4);

            switch(choice) {
                case 1 -> doctorMenu();
                case 2 -> patientMenu();
                case 3 -> promiseMenu();
                case 4 -> billsMenu();
                case 0 -> {
                    System.out.println("bye!");
                    running = false;
                }
            }
        }
    }

    public static void setup() {
        // doctor
        doctorList.add(new Doctor("D001","kela", 39,Gender.woman,6000000));
        doctorList.add(new Doctor("D002","budi santoso", 45,Gender.man,5000000));
        doctorList.add(new Doctor("D003","rina wijaya", 36,Gender.woman,4500000));
        doctorList.add(new Doctor("D004","agus pratama", 52,Gender.man,7500000));
        doctorList.add(new Doctor("D005","maya sari", 41,Gender.woman,5500000));

        // patient
        patientList.add(new Patient("P001","victor",21,Gender.man, "heartbreak"));
        patientList.add(new Patient("P002","anisa",25,Gender.woman, "headache"));
        patientList.add(new Patient("P003","rizky",30,Gender.man, "fever"));
        patientList.add(new Patient("P004","dewi",19,Gender.woman, "toothache"));
        patientList.add(new Patient("P005","fajar",44,Gender.man, "back pain"));
        patientList.add(new Patient("P006","putri",28,Gender.woman, "cough"));
        patientList.add(new Patient("P007","dimas",35,Gender.man, "stomachache"));
        patientList.add(new Patient("P008","salsa",23,Gender.woman, "allergy"));
        patientList.add(new Patient("P009","andi",51,Gender.man, "high blood"));
        patientList.add(new Patient("P010","lina",33,Gender.woman, "insomnia"));
        patientList.add(new Patient("P011","bagas",17,Gender.man, "broken arm"));
        patientList.add(new Patient("P012","citra",40,Gender.woman, "migraine"));

        // promise
        promiseList.add(new Promise(patientList.get(0),doctorList.get(0),LocalDate.parse("22-01-2026",input.getDateFormat())));
        promiseList.add(new Promise(patientList.get(1),doctorList.get(1),LocalDate.parse("25-01-2026",input.getDateFormat())));
        promiseList.add(new Promise(patientList.get(4),doctorList.get(3),LocalDate.parse("02-02-2026",input.getDateFormat())));
        promiseList.add(new Promise(patientList.get(7),doctorList.get(2),LocalDate.parse("10-02-2026",input.getDateFormat())));
        promiseList.add(new Promise(patientList.get(8),doctorList.get(4),LocalDate.parse("15-02-2026",input.getDateFormat())));
        promiseList.add(new Promise(patientList.get(10),doctorList.get(3),LocalDate.parse("20-02-2026",input.getDateFormat())));
    }

    public static void doctorMenu() {
        System.out.println("=== doctor ===");
        System.out.println("1. add");
        System.out.println("2. read");
        System.out.println("3. update");
        System.out.println("0. back");
        int choice = input.inputInt("choice: ", 0, 3);

        switch(choice) {
            case 1 -> addDoctor();
            case 2 -> readDoctor();
            case 3 -> {
                readDoctor();
                String id = input.inputString("input id: ");
                updateDoctor(id);
            }
            case 0 -> {}
        }
    }

    public static void patientMenu() {
        System.out.println("=== patient ===");
        System.out.println("1. add");
        System.out.println("2. read");
        System.out.println("3. update");
        System.out.println("0. back");
        int choice = input.inputInt("choice: ", 0, 3);

        switch(choice) {
            case 1 -> addPatient();
            case 2 -> readPatient();
            case 3 -> {
                readPatient();
                String id = input.inputString("input id: ");
                updatePatient(id);
            }
            case 0 -> {}
        }
    }

    public static void promiseMenu() {
        System.out.println("=== promise ===");
        System.out.println("1. add");
        System.out.println("2. read");
        System.out.println("3. update");
        System.out.println("0. back");
        int choice = input.inputInt("choice: ", 0, 3);

        switch(choice) {
            case 1 -> addPromise();
            case 2 -> readPromise();
            case 3 -> updatePromise();
            case 0 -> {}
        }
    }

    //    doctor
    public static void addDoctor() {
        String id = input.inputString("input id: ");
        String name = input.inputString("input name: ");
        int age = input.inputInt("input age: ");
        Gender gender = input.inputGender();
        long fees = input.inputLong("input fees: ");
        doctorList.add(new Doctor(id,name,age,gender,fees));
    }

    public static void readDoctor() {
        if(doctorList.isEmpty()) {
            System.out.println("Doctor Is Empty!");
            return;
        }
        int i = 1;
        System.out.printf("%-4s %-6s %-20s %4s %-8s %20s%n",
                "no",
                "id",
                "name",
                "age",
                "gender",
                "fees");
        for(Doctor item: doctorList) {
            System.out.printf("%-4s %-6s %-20s %4d %-8s %20d%n",
                    i + ".",
                    item.getId(),
                    item.getName(),
                    item.getAge(),
                    item.getGender(),
                    item.getFees()
            );
            i++;
        }
    }

    public static Doctor getDoctorById(String id) {
        for(Doctor item: doctorList) {
            if(item.getId().equalsIgnoreCase(id)){
                return item;
            }
        }
        return null;
    }

    public static void updateDoctor(String id) {
        Doctor getDoctor = getDoctorById(id);
        if(getDoctor == null) {
            System.out.println("doctor data with id " + id + " is not found!");
            return;
        }

        getDoctor.print();

        String name = input.inputString("Update name: ",getDoctor.getName());
        int age = input.inputInt("Update age: ",getDoctor.getAge());
        Gender gender = input.inputGender(getDoctor.getGender());
        long fees = input.inputLong("Update fees: ",getDoctor.getFees());

        getDoctor.setName(name);
        getDoctor.setAge(age);
        getDoctor.setGender(gender);
        getDoctor.setFees(fees);
    }

//    patient
    public static void addPatient() {
        String id = input.inputString("input id: ");
        String name = input.inputString("input name: ");
        int age = input.inputInt("input age: ");
        Gender gender = input.inputGender();
        String complaint = input.inputString("input complaint: ");
        patientList.add(new Patient(id,name,age,gender,complaint));
    }

    public static void readPatient() {
        if(patientList.isEmpty()) {
            System.out.println("Patient Is Empty!");
            return;
        }
        int i = 1;
        System.out.printf("%-4s %-6s %-20s %4s %-8s %-20s%n",
                "no",
                "id",
                "name",
                "age",
                "gender",
                "complaint"
        );
        for(Patient item: patientList) {
            System.out.printf("%-4s %-6s %-20s %4d %-8s %-20s%n",
                    i + ".",
                    item.getId(),
                    item.getName(),
                    item.getAge(),
                    item.getGender(),
                    item.getComplaint()
            );
            i++;
        }
    }

    public static Patient getPatientById(String id) {
        for(Patient item: patientList) {
            if(item.getId().equalsIgnoreCase(id)){
                return item;
            }
        }
        return null;
    }

    public static void updatePatient(String id) {
        Patient getPatient = getPatientById(id);
        if(getPatient == null) {
            System.out.println("patient data with id " + id + " is not found!");
            return;
        }

        getPatient.print();

        String name = input.inputString("Update name: ",getPatient.getName());
        int age = input.inputInt("Update age: ",getPatient.getAge());
        Gender gender = input.inputGender(getPatient.getGender());
        String complaint = input.inputString("Update complaint: ",getPatient.getComplaint());

        getPatient.setName(name);
        getPatient.setAge(age);
        getPatient.setGender(gender);
        getPatient.setComplaint(complaint);
    }

    public static void readPromise() {
        if(promiseList.isEmpty()) {
            System.out.println("promise is empty");
            return;
        }

        int i = 1;
        System.out.printf("%-4s %-20s %-20s %-12s %-20s %-10s%n",
                    "no",
                    "doctor",
                    "patient",
                    "date",
                    "complaint",
                    "status"
                );
        for (Promise item: promiseList) {
            System.out.printf("%-4s %-20s %-20s %-12s %-20s %-10s%n",
                    i + ".",
                    item.doctor.getName(),
                    item.patient.getName(),
                    item.getDate(),
                    item.patient.getComplaint(),
                    item.status
            );
            i++;
        }
    }

    public static void addPromise() {
        System.out.println("------doctor---------");
        readDoctor();
        System.out.println("------patient--------");
        readPatient();
        System.out.println("------promise--------");
        readPromise();

        if(doctorList.isEmpty() || patientList.isEmpty()) {
            System.out.println("clinic data still empty!");
            return;
        }

        int doctorChoice = input.inputInt("Doctor choice: ",1,doctorList.size());
        int patientChoice = input.inputInt("Patient choice", 1,patientList.size());
        LocalDate date = input.inputDate();
        promiseList.add(new Promise(patientList.get(patientChoice - 1), doctorList.get(doctorChoice -1), date));
    }

    public static void updatePromise() {
        readPromise();

        if(promiseList.isEmpty()) return;

        int choicePromise = input.inputInt("choice promise", 1,promiseList.size());
        Promise getPromise = promiseList.get(choicePromise - 1);

        LocalDate date = input.inputDate(getPromise.getDate());
        AppointmentStatus status = input.inputStatus(getPromise.getStatus());

        getPromise.setDate(date);
        getPromise.setStatus(status);

    }

    // commonBills
    public static void readCommonBills() {
        if(commonBillsList.isEmpty()) {
            System.out.println("common bills is empty!");
            return;
        }
        int i = 1;
        System.out.printf("%-3s %-20s %-20s %-12s %15s %15s%n",
                "no",
                "doctor",
                "patient",
                "date",
                "amount",
                "bill"
        );
        for(CommonBills item : commonBillsList) {
            System.out.printf("%-3s %-20s %-20s %-12s %15d %15d%n",
                    i + ".",
                    item.getPromise().getDoctor().getName(),
                    item.getPromise().patient.getName(),
                    item.getPromise().getDate(),
                    item.getAmount(),
                    item.getBills()
            );
            i++;
        }
    }

    public static void addCommonBills() {
        Promise promise = choosePromise();
        if(promise == null) return;

        long amount = input.inputLong("input amount: ");
        commonBillsList.add(new CommonBills(amount, promise));
    }

    // insuranceBills
    public static void readInsuranceBills() {
        if(insuranceBillsList.isEmpty()) {
            System.out.println("insurance bills is empty!");
            return;
        }
        int i = 1;
        System.out.printf("%-3s %-20s %-20s %-12s %15s %10s %15s%n",
                "no",
                "doctor",
                "patient",
                "date",
                "amount",
                "insurance",
                "bill"
        );
        for(InsuranceBills item : insuranceBillsList) {
            System.out.printf("%-3s %-20s %-20s %-12s %15d %9d%% %15d%n",
                    i + ".",
                    item.getPromise().getDoctor().getName(),
                    item.getPromise().patient.getName(),
                    item.getPromise().getDate(),
                    item.getAmount(),
                    item.getInsurancePercent(),
                    item.getBills()
            );
            i++;
        }
    }

    public static void addInsuranceBills() {
        Promise promise = choosePromise();
        if(promise == null) return;

        long amount = input.inputLong("input amount: ");
        int percent = input.inputInt("input insurance percent: ", 1, 100);
        insuranceBillsList.add(new InsuranceBills(amount, promise, percent));
    }

    // shared (parent bills)
    public static Promise choosePromise() {
        if(promiseList.isEmpty()) {
            System.out.println("promise is empty!");
            return null;
        }

        readPromise();
        int choice = input.inputInt("choice promise: ", 1, promiseList.size());
        return promiseList.get(choice - 1);
    }

    public static void billsMenu() {
        System.out.println("=== bills ===");
        System.out.println("1. add common bills");
        System.out.println("2. read common bills");
        System.out.println("3. add insurance bills");
        System.out.println("4. read insurance bills");
        System.out.println("0. back");
        int choice = input.inputInt("choice: ", 0, 4);

        switch(choice) {
            case 1 -> addCommonBills();
            case 2 -> readCommonBills();
            case 3 -> addInsuranceBills();
            case 4 -> readInsuranceBills();
            case 0 -> {}
        }
    }
}
