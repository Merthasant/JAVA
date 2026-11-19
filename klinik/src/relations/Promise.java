package relations;

import types.AppointmentStatus;
import user.Doctor;
import user.Patient;

import java.time.LocalDate;

public class Promise {
    public final Patient patient;
    public final Doctor doctor;
    public LocalDate date;
    public AppointmentStatus status;

    public Promise(Patient patient,Doctor doctor,LocalDate date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = AppointmentStatus.waiting;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}
