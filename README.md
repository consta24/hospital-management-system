# Hospital Management System

This is a Spring Data project that demonstrates the use of various Spring technologies to build a hospital management system. The application allows for the management of patients, doctors, nurses, clinical records, diagnoses, and treatments.

## Technologies Used

- Spring Boot
- Spring Data JPA
- MySQL
- Java 11
- Lombok
- Maven

## Project Structure

The project consists of several domain classes representing the different entities in the system:

- Patient
- Doctor
- Nurse
- ClinicalRecord
- Diagnosis
- Measurement
- Treatment

These entities are managed through various services:

- PatientService
- MedicalPersonnelService
- DiagnosisService
- ClinicalRecordService

The application is initialized with sample data through the DataLoader class, which implements the CommandLineRunner interface.

## Database

The project uses MySQL as the database, with the connection details and configurations specified in the `application.properties` file.
