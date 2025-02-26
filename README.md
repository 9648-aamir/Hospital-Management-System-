                                                      Hospital Management System

This is a comprehensive Hospital Management System (HMS) built using Spring Boot and JPA (Java Persistence API). The system is designed to manage various aspects of a hospital, including patient records, appointments, medical records, prescriptions, billing, and more. The application follows a RESTful architecture, making it easy to integrate with front-end applications or other services.

                                                                  Features

Patient Management: Add, update, delete, and retrieve patient details.
Appointment Management: Schedule, update, and manage appointments for patients with doctors.
Medical Records: Maintain detailed medical records for patients, including diagnoses, treatments, and notes.
Prescription Management: Create and manage prescriptions for patients.
Billing and Payments: Generate bills, manage payments, and track payment statuses.
Department Management: Manage hospital departments and their details.
Doctor Management: Add, update, and manage doctor details, including their specialization and department.
Room Management: Manage hospital rooms and assign them to patients.
Service Management: Manage hospital services and their associated costs.

                                                 Technologies Used

Spring Boot: Backend framework for building the application.
JPA (Java Persistence API): For ORM (Object-Relational Mapping) and database interactions.
H2 Database: In-memory database for development and testing (can be replaced with MySQL, PostgreSQL, etc.).
Lombok: For reducing boilerplate code (e.g., getters, setters, constructors).
RESTful API: Exposes endpoints for CRUD operations on various entities.
Maven: Build automation and dependency management.

                                                        Entity Overview

The system consists of the following main entities:

1. Patient: Stores patient details such as name, contact information, date of birth, and emergency contact.
2. Doctor: Manages doctor details, including name, specialization, contact information, and department.
3. Appointment: Tracks appointments between patients and doctors, including appointment date, status, and purpose.
4. MedicalRecords: Stores medical records for patients, including diagnoses, treatments, and notes.
5. Prescription: Manages prescriptions for patients, including dosage and frequency.
6. Bills: Tracks billing information for patients, including total amount and payment status.
7. Payment: Manages payment details for bills, including payment method and date.
8. Department: Manages hospital departments and their descriptions.
9. Room: Tracks hospital rooms and their assignment to patients.
10. Service: Manages hospital services and their associated costs.

                                                     API Endpoints

                                                   Patient Controller
POST /patientController/savePatient: Save a new patient.
GET/patientController/getPatientById/{id}: Retrieve a patient by ID.
GET/patientController/getAllPatientsDao: Retrieve all patients.
POST/patientController/updatePatient/{id}: Update an existing patient.
DELETE/patientController/deletePatient/{id}: Delete a patient by ID.

                                                       Doctor Controller
POST/doctorController/saveDoctor: Save a new doctor.
GET/doctorController/getDoctorBy/{id}: Retrieve a doctor by ID.
GET/doctorController/getAllDoctors: Retrieve all doctors.
POST/doctorController/updateDoctor/{id}: Update an existing doctor.
DELETE/doctorController/deleteDoctor/{id}: Delete a doctor by ID.

                                                        Appointment Controller
POST/appointmentController/saveAppointment: Save a new appointment.
GET/appointmentController/getAllAppointment: Retrieve all appointments.
GET/appointmentController/getAppointmentById/{id}: Retrieve an appointment by ID.
POST/appointmentController/UpdateAppointment/{id}: Update an existing appointment.
DELETE/appointmentController/deleteAppointmentById/{id}: Delete an appointment by ID.

                                                      Medical Records Controller
POST/medicalRecordsController/saveMedicalRecord: Save a new medical record.
GET/medicalRecordsController/getAllMedicalRecordByName: Retrieve all medical records.
GETmedicalRecordsController/getMedicalRecordById/{recordId}: Retrieve a medical record by ID.
POST/medicalRecordsController/updateMedicalRecordByDoctorId/{recordId}: Update a medical record by doctor ID.
DELETE/medicalRecordsController/deleteMedicalRecordByName/{fullName}: Delete medical records by patient's full name.

                                                       Prescription Controller
POST/prescriptionController/savePrescription: Save a new prescription.
GET/prescriptionController/getAllPrescription: Retrieve all prescriptions.
GET/prescriptionController/getPrescriptionById/{id}: Retrieve a prescription by ID.
POST/prescriptionController/updatePrescription/{id}: Update an existing prescription.
DELETE/prescriptionController/deletePrescriptionById/{id}: Delete a prescription by ID.

                                                         Bills Controller
POST/billsController/saveBills: Save a new bill.
GET/billsController/getAllBills: Retrieve all bills.
GET/billsController/getBillsById/{id}: Retrieve a bill by ID.
POST/billsController/updateBills/{id}: Update an existing bill.
DELETE/billsController/deleteBillsById/{id}: Delete a bill by ID.

                                                        Payment Controller
POST/paymentController/savePayment: Save a new payment.
GET/paymentController/getAllPayment: Retrieve all payments.
GET/paymentController/getPaymentById/{id}: Retrieve a payment by ID.
POST/paymentController/updatePayment/{id}: Update an existing payment.
DELETE/paymentController/deletePaymentById/{id}: Delete a payment by ID.

                                                        Department Controller
POST/departmentController/saveDepartment: Save a new department.
GET/departmentController/getAllDepartments: Retrieve all departments.
GET/departmentController/getDepartmentById/{id}: Retrieve a department by ID.
POST/departmentController/updateDepartment/{id}: Update an existing department.
DELETE/departmentController/deleteDepartment/{id}: Delete a department by ID.

                                                          Room Controller
POST/roomController/saveAllRoom: Save a new room.
GET/roomController/getAllRoom: Retrieve all rooms.
GET/roomController/getRoomById/{id}: Retrieve a room by ID.
POST/roomController/updateRoom/{id}: Update an existing room.
DELETE/roomController/deleteRoomByIdD/{id}: Delete a room by ID.

                                                      Service Controller
POST/serviceController/saveService: Save a new service.
GET/serviceController/getAllService: Retrieve all services.
GET/serviceController/getServiceById/{id}: Retrieve a service by ID.
POST/serviceController/updateService/{id}: Update an existing service.
DELETE/serviceController/deleteServiceById/{id}: Delete a service by ID.

                                       Database Schema & Relationships
                                      
                                              1. Department
It does not depend on any other entity.
Needed for associating Doctors.

                                              2. Doctor
Depends on Department (foreign key: department_id).
Needed for associating Appointments and MedicalRecords.

                                              3. Patient
Independent but required for MedicalRecords, Appointments, Bills, and Rooms.

                                              4. Room
Depends on Patient (foreign key: patient_id).

                                              5. Appointment
Depends on Patient (foreign key: patient_id).
Depends on Doctor (foreign key: doctor_id).

                                              6. MedicalRecords
Depends on Patient (foreign key: patient_id).
Depends on Doctor (foreign key: doctor_id).

                                              7. Prescription
Depends on MedicalRecords (foreign key: medicalRecordId).

                                              8. Medication
Depends on Prescription (foreign key: prescription_id).

                                              9. Bills
Depends on Patient (foreign key: patient_id).

                                              10. Payment
Depends on Bills (foreign key: bill_id).

                                              11. Service
Independent and can be inserted anytime.
