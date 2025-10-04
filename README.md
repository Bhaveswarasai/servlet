#UserAuthentication Servlet Project

A simple Java Servlet web app for user registration and login using JDBC and MySQL.

Features
Register new users

Secure login with database validation

Basic error handling and session routing

Tech Stack
Java + Servlet API (Jakarta EE)

JDBC & MySQL

HTML/CSS

#Directory Structure

UserAuthentication

├── src/main/java/com/vc/      # Login & Registration servlets

├── src/main/webapp/              # HTML pages

├── src/main/webapp/WEB-INF/      # web.xml config

Run on Tomcat: Import and deploy. Default DB: root/admin@localhost:3306.

#Flow

Register: Submits details to /Registration, saved in DB

Login: Authenticates via /Login, redirects on success/failure
