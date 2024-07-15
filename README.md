# Labseq Project

This project consists of two main components:
1. **Backend**: A Spring Boot application that provides an API to calculate Labseq values.
2. **Frontend**: A React application that interacts with the backend to display Labseq values to the user.

## Prerequisites

Before you start, ensure you have the following installed on your machine:

- **Java 17**: Download and install from [AdoptOpenJDK](https://adoptopenjdk.net/).
- **Maven**: Download and install from [Maven's official website](https://maven.apache.org/).
- **Node.js**: Download and install from [Node.js official website](https://nodejs.org/).
- **npm**: This comes with Node.js, but you can also install it separately from [npm's official website](https://www.npmjs.com/).

## Backend Setup

### Step 1: Clone the Repository

```sh
git clone <repository-url>
cd labseq/labseq
```

### Step 2: Build the Backend

Navigate to the backend directory and build the project using Maven:

```sh
mvn clean package
```

### Step 3: Run the Backend

Start the Spring Boot application:

```sh
mvn spring-boot:run
```

The backend should now be running on `http://localhost:8080`.

## Frontend Setup

### Step 1: Navigate to the Frontend Directory

```sh
cd labseq/labseq-frontend
```

### Step 2: Install Dependencies

Install the necessary npm packages:

```sh
npm install
```

### Step 3: Run the Frontend

Start the React application:

```sh
npm start
```

The frontend should now be running on `http://localhost:3000`.

## Accessing the Application

1. Open your web browser and navigate to `http://localhost:3000` to access the frontend.
2. Use the input field to enter a value of `n` and click the "Calculate" button.
3. The frontend will send a request to the backend to calculate the Labseq value for `n` and display the result.

## API Documentation

To access the Swagger UI for API documentation, navigate to the following URL:

[Swagger UI](http://localhost:8080/swagger-ui.html)


## License

This project is licensed under the MIT License.

---

By following these instructions, you should be able to set up and run both the backend and frontend components of the Labseq project successfully.