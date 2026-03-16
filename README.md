#  Book My Stay – Hotel Booking Management System

##  Overview
A console-based Java application that demonstrates **real-world hotel booking logic** using **Core Java** and **fundamental data structures**.  
The project evolves incrementally across use cases, showing how design decisions improve scalability, fairness, and maintainability.

## Features by Use Case
- **UC1 – Application Entry** → Startup flow with welcome message and versioning.  
- **UC2 – Room Modeling** → Abstract `Room` class with inheritance (`SingleRoom`, `DoubleRoom`, `SuiteRoom`) and static availability.  
- **UC3 – Centralized Inventory** → `HashMap<String, Integer>` for consistent room availability management.  
- **UC4 – Room Search** → Read-only search service to view available rooms without altering state.  
- **UC5 – Booking Requests** → `Queue<Reservation>` ensures **FIFO fairness** in handling guest requests.  
- **UC6 – Reservation Confirmation** → Booking service assigns **unique room IDs**, updates inventory, and prevents double-booking using `Set`.

## 🛠️ Tech Stack
- **Language:** Java (Core Java, OOP principles)  
- **Data Structures:** HashMap, Queue, Set  
- **Execution:** Console-based, deterministic flows  

## How to Run
```bash
# Compile
javac BookMyStayAPP.java

# Run
java BookMyStayAPP
