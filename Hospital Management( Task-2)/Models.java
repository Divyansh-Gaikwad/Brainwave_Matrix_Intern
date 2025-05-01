import java.io.Serializable;

class Patient implements Serializable {
    String id, name, gender;
    int age;

    Patient(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String toString() {
        return id + ": " + name + " (" + gender + ", " + age + " yrs)";
    }
}

class Appointment implements Serializable {
    String patientId, doctorName, date;

    Appointment(String patientId, String doctorName, String date) {
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.date = date;
    }

    public String toString() {
        return "Patient ID: " + patientId + ", Doctor: " + doctorName + ", Date: " + date;
    }
}

class HealthRecord implements Serializable {
    String patientId, diagnosis, prescription;

    HealthRecord(String patientId, String diagnosis, String prescription) {
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public String toString() {
        return "Patient ID: " + patientId + ", Diagnosis: " + diagnosis + ", Prescription: " + prescription;
    }
}

class Bill implements Serializable {
    String patientId;
    double amount;

    Bill(String patientId, double amount) {
        this.patientId = patientId;
        this.amount = amount;
    }

    public String toString() {
        return "Patient ID: " + patientId + ", Amount: ₹" + amount;
    }
}

class InventoryItem implements Serializable {
    String itemName;
    int quantity;

    InventoryItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String toString() {
        return itemName + ": " + quantity;
    }
}

class Staff implements Serializable {
    String id, name, role;

    Staff(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public String toString() {
        return id + ": " + name + " - " + role;
    }
}
