# iet-gibb-wasd
Most basic but still fully functional application for the Modul 183 LB 3.

# POSTGRES DB SETUP with pgadmin
- CREATE DATABASE wasd;
- CREATE USER wasd WITH PASSWORD 'wasd';
- GRANT ALL PRIVILEGES ON DATABASE wasd TO wasd;

- CREATE EXTENSION IF NOT EXISTS pgcrypto;