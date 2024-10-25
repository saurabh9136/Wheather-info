# Weather Info API

The Weather Info API provides weather information for a specific location based on the pincode and date. It utilizes the OpenWeather API to fetch data and stores the information in a local H2 database. When the same pincode is requested again, the API optimizes data retrieval by using cached data.

## Features

- Get weather information for a specific pincode on a given date.
- Cache weather data in an H2 database for optimized API calls.
- RESTful API, testable via Postman/Swagger.
- Includes pincode latitude and longitude in the database.

## API Documentation

### Base URL

- Localhost (default): `http://localhost:2411`

### Endpoints

#### 1. Get Weather Information by Pincode

- **Endpoint:** `/getAllinfo/{pincode}`
- **Method:** `GET`
- **Description:** Retrieves weather information for the specified pincode. If the data exists in the database and is up-to-date, it fetches the cached data instead of calling the OpenWeather API.

**Path Variable:**
- `pincode` (String): The postal code of the location (e.g., `400075`).

**Sample Request:**

```http
GET http://localhost:9999/getAllinfo/400075
