CREATE EXTENSION IF NOT EXISTS pgcrypto;

keytool -genkey -alias wasd -keyalg RSA -keystore keystore.jks -keysize 2048

iet-gibb-wasd