# Simple CRUD
This repository contains a simple CRUD project built with Java Spring. The purpose of this repository is to practice and share how you can build all the CRUD methods using Java Spring and to study the concept of clean architecture

## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
- [Database](#database)

## Installation

1. Clone the repository:

```bash
$ git clone https://github.com/Fledson/crud-product.git
```

2. Install dependencies with Maven

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080


## API Endpoints
The API provides the following endpoints:

```markdown
GET /product - Retrieve a list of all data.

POST /product - Register a new data.

PUT /product - Alter data.

DELETE /product/{id} - Inactivate data.
```

## Database
The project uses PostgresSQL as the database. The necessary database migrations are managed using Flyway.

To install PostgresSQL locally you can [click here](https://www.postgresql.org/download/).



### Inspiration
This project is based on a live on youtube - [Fernanda Kipper | Dev](https://www.youtube.com/watch?v=tP6wtEaCnSI) 
