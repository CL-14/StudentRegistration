# Student Registration App

A simple Android application built with **Jetpack Compose** and **Room Database** to manage and track student registrations locally on device. Developed as part of learning modern Android development patterns and architectural components.

---

## Features

* Home Dashboard: Simple navigation menu to jump between registration and search flows.
* Student Registration: A form to add a student's name, course, and year (1–4) with built-in input validation.
* Database Storage: Uses Room (SQLite abstraction library) with **Coroutines** to persist data asynchronously off the main thread.
* Student Search: Query the local database instantly by student ID to view specific details.
* Modern UI: Built fully with Jetpack Compose, edge-to-edge support, and safe-drawing padding to prevent UI overlap with system bars.

---

## Tech used

* UI Framework: Jetpack Compose
* Navigation: Jetpack Navigation Compose
* Local Database: Room Database (`@Entity`, `@Dao`, `@Database`)
* Concurrency: Kotlin Coroutines (`viewModelScope`, `Dispatchers.IO`)
* Architecture: MVVM (Model-View-ViewModel) pattern separating UI from data operations.

---

## Project Structure

```text
com.example.studentregistration/
├── db/                   # Room database configuration, DAOs, and definitions
├── entities/             # Data models and database entities (e.g Student)
├── ui/theme/             # Material 3 color schemes, typography, and styling
├── view/                 # Compose UI screens and ViewModels for state management
├── MainActivity.kt       # App entry point and Navigation host setup
└── MainApplication.kt    # Application-level initialization for the Room database
```

---

## How to Run

1. Clone or download this repository.
2. Open the project folder (`StudentRegistration`) in **Android Studio**.
3. Let Gradle sync and download dependencies.
4. Run the app on an Android Emulator or a physical device.