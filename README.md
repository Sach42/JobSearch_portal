
# Job Management System

This project is a Job Management System developed using Spring Boot. It provides RESTful API endpoints for performing CRUD operations on job entities. The project uses Spring Data JPA for data persistence and H2 Database for storing job data.


## Features

- Create a new job by providing job details such as title, description, location, salary, company email, company name, employer name, job type, and applied date.
- Retrieve a job by its ID.
- Get a list of all jobs.
- Update a job's details.
- Delete a job by its ID.


## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
## Installation

- Clone the repository.
- Import the project into your preferred IDE.
- Build the project using Maven or Gradle.
- Run the application.
- The application will be accessible at http://localhost:8080.
    
# API ENDPOINTS

## Create a Job
- Method: POST
- URL: /jobs
- Request Body:

 {

  "title": "Software Engineer",
  "description": "Develop software applications",
  "location": "New York",
  "salary": 50000,
  "companyEmail": "company@example.com",
  "companyName": "ABC Company",
  "employerName": "John Doe",
  "jobType": "IT",
  "appliedDate": "2023-07-01"

}

## Get a Job by ID
- Method: GET
- URL: /jobs/{id}

## Get all Jobs
- Method: GET
- URL: /jobs

## Update a Job
- Method: PUT
- URL: /jobs/{id}
- Request Body:

{

  "title": "Senior Software Engineer",
  "description": "Develop and maintain software applications",
  "location": "San Francisco",
  "salary": 80000,
  "companyEmail": "updated@example.com",
  "companyName": "XYZ Company",
  "employerName": "Jane Smith",
  "jobType": "IT",
  "appliedDate": "2023-07-01"

}

## Delete a Job
- Method: DELETE
- URL: /jobs/{id}

## License
- This project is licensed under the MIT License.

- Feel free to contribute to the project by submitting pull requests or reporting issues.

Enjoy!
