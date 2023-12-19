# Entertainment Web App Backend (Frontend Mentor)

## Introduction
Welcome to the Entertainment Web App Backend project! This backend is developed as to complement the [Entertainment Web App](https://www.frontendmentor.io/challenges/entertainment-web-app-J-UhgAW1X)
application challenge by Frontend Mentor. My personal solution to the frontend component of this challenge can be found 
[here](https://github.com/jakegodsall/fm-entertainment-web-app-frontend).
The challenge's objective is to create an application that resembles the provided designs as closely
as possible. While the challenge primarily targets frontend development,
this project extends the scope by introducing a robust backend, enhancing the overall functionality
of the application.

## Overview
The backend is engineered using Java 21 and Spring Boot 3, providing a sturdy and scalable foundation. It interfaces with a MySQL database, utilizing Spring Data JPA for efficient data handling and Flyway for database migrations. The application features Basic HTTP authentication with distinct admin and user roles, ensuring a secure environment. A comprehensive data validation strategy is implemented, covering everything from HTTP request inputs to database constraints.

## Features
* Basic HTTP Authentication: Secure authentication system with distinct roles for admin and user.
* Data Validation: Comprehensive validation across the entire stack.
* MySQL Database Integration: Utilizes Spring Data JPA and Flyway for database interactions and migrations.
* Role-based Access Control: Differentiated access for admins and users.
* CRUD Operations: Complete set of create, read, update, and delete operations for managing movies and TV series.
* Search Functionality: Enables users to search for relevant shows across the platform.
* Bookmark Management: Allows users to add or remove bookmarks from movies and TV series.

## Future Enhancements
* JUnit and Mockito Tests: Plans are in place to incorporate extensive unit and integration testing using JUnit and Mockito.
* CI/CD with GitHub Actions: Automation of tests and deployment processes through GitHub Actions is under consideration.

## Getting Started
### Prerequisites
* Java 21
* Spring Boot 3
* MySQL

### Installation

1. Clone the repository:

```bash
git clone https://github.com/jakegodsall/fm-entertainment-app-backend.git
```

2. Navigate to the project directory:

```shell
cd fm-entertainment-web-app-backend
```

3. Configure the `application.properties` file with your MySQL database details.


4. Run the application:

```shell
./mvnw spring-boot:run
```

## Usage

The backend is designed to work in conjunction with the Frontend Mentor's Entertainment Web App challenge. It provides a robust API for managing the app's data, including movies, TV series, and user bookmarks.

## Contributing
Contributions are welcome! For major changes, please open an issue first to discuss what you would like to change. Please ensure to update tests as appropriate.

## License
[MIT](https://github.com/jakegodsall/fm-entertainment-web-app-backend/blob/main/LICENSE)

