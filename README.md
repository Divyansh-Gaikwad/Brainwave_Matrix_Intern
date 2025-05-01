## Overview
The **Hospital Management System (HMS)** is a Java-based application that manages various aspects of a hospital or healthcare facility. The system includes modules for:

- **Patient Registration**
- **Appointment Scheduling**
- **Electronic Health Records (EHR)**
- **Billing and Invoicing**
- **Inventory Management for Medical Supplies**
- **Staff Management**

This system helps hospital administrators manage patients, staff, appointments, inventory, and other key operations in a centralized way.

## Features

### 1. Staff Management
- **Add, view, update, and remove staff**: Allows administrators to manage staff details like ID, name, and role (Doctor, Nurse, Admin, etc.).
- **Staff Login System**: Requires staff members to log in using their staff ID for access to the system.

### 2. Patient Management
- **Register New Patients**: Allows administrators to enter new patient details.
- **View, Update, and Remove Patient Records**: Enables the viewing and updating of patient information.

### 3. Appointment Scheduling
- **Schedule Appointments**: Staff can schedule appointments for patients with available doctors.
- **View and Cancel Appointments**: View and cancel upcoming appointments.

### 4. Electronic Health Records (EHR)
- **Manage Patient Health Data**: Staff can store and access electronic health records for patients.

### 5. Billing and Invoicing
- **Generate Invoices**: Staff can generate bills and invoices for medical services provided.

### 6. Inventory Management
- **Track Medical Supplies**: Manage and track the availability of medical supplies and resources in the hospital.

### 7. File-Based Persistence (Serialization)
- **Staff, Patient, Appointment, Inventory, etc.**: All data related to staff, patients, and appointments are serialized and saved in `.dat` files.
- **Automatic Saving/Loading**: The application automatically saves data to `.dat` files on exit and loads data on start.

## How to Run the Application

### Prerequisites
- **Java 17 or above**: This application is built using Java.
- **IDE**: You can use any IDE such as IntelliJ IDEA, Eclipse, or NetBeans.

  ### Steps to Run

1. **Clone or Download the Repository**
   - If using Git:
   ```bash
   git clone <repository-url>

2. **Import into Your IDE**
   - Open the project in your IDE (e.g., IntelliJ IDEA, Eclipse).

3. **Compile and Run**
   - Use the IDE's Run button to compile and execute the HospitalManagementSystem.java file.
  
## First-Time Setup

When you run the application for the first time, the login system will not recognize any staff because the `staff.dat` file is empty. Here's what you need to do:

### 1. Skip Login
Temporarily comment out the login check in `HospitalManagementSystem.java`:

```java
// if (!login()) return```
````

### 2. Add Staff
- Run the application.
- Choose Option 7. Add Staff from the main menu to add the first staff member (e.g., Admin).
- Staff ID: 220
- Name: Gourav Goswami
- Role: Admin

### 3. Exit and save
Choose Option 8: Exit to save the staff data to staff.dat

### 4. Enable Login
Uncomment the login line you commented earlier:
```java
// if (!login()) return```
````

### 5. Rerun the Application
Now log in with:
- Staff ID: 220

- Name: Gourav Goswami

