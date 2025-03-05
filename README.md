# Tamanina  

Tamanina is a native Android application built with Jetpack Compose, designed to help users stay connected to their faith by providing daily Azkar, prayer times, and a Tasbeeh counter. The app ensures a smooth and intuitive experience with a modern UI and a well-structured architecture.  

## Features  

- **Daily Azkar Reminders** – Get notifications for morning and evening Azkar.  
- **Accurate Prayer Times** – Based on the user’s location, fetched using APIs.  
- **Tasbeeh Counter** – A simple digital counter for daily recitations.  
- **Location-based Adjustments** – Stores and updates prayer times using Shared Preferences.  
- **Offline Support** – Stores Azkar and prayer times using Room database.  
- **Customizable UI** – A clean and calming design to enhance user experience.  

## Tech Stack  

- **Language**: Kotlin  
- **UI Framework**: Jetpack Compose  
- **Dependency Injection**: Dagger Hilt  
- **Networking**: Ktor Client  
- **Local Storage**: Room Database & Shared Preferences  
- **State Management**: ViewModel & StateFlow  

## Project Structure  

```
طمأنينة/
طمأنينة/
│-- app/src/main/java/com/saber/tomanina/
│   ├── common/                # Shared utilities and UI components
│   │   ├── utils/             # Helper functions & extensions
│   │   ├── widgets/           # Reusable Compose UI components
│   │
│   ├── core/                  # Core functionalities
│   │   ├── constants/         # Application-wide constant values
│   │   ├── network/           # API client configuration (Ktor)
│   │   ├── storage/           # Data storage layer
│   │   ├── utils/             # General utility classes & extensions
│   │
│   ├── di/                    # Dependency Injection with Dagger Hilt
│   │   ├── AppModule.kt       
│   │   ├── DatabaseModule.kt  
│   │   ├── NetworkModule.kt   
│   │   ├── SharedPreferencesModule.kt
│   │
│   ├── features/              # Application features (modular structure)
│   │   ├── azkar/             # Azkar feature module
│   │   │   ├── data/          # Data layer
│   │   │   ├── domain/        # Business logic (Use Cases)
│   │   │   ├── presentation/  # UI & ViewModels
│   │
│   │   ├── hijri_calender/    # Hijri Calendar feature module
│   │   │   ├── data/          # Data layer
│   │   │   ├── domain/        # Business logic (Use Cases)
│   │   │   ├── presentation/  # UI & ViewModels
│   │
│   │   ├── prayer_times/      # Prayer Times feature module
│   │   │   ├── data/          # Data layer
│   │   │   ├── domain/        # Business logic (Use Cases)
│   │   │   ├── presentation/  # UI & ViewModels
│   │
│   │   ├── quran/      # quran feature module
│   │   │   ├── data/          # Data layer
│   │   │   ├── domain/        # Business logic (Use Cases)
│   │   │   ├── presentation/  # UI & ViewModels
│   │
│   ├── ui/theme/              # Theming & styling for Jetpack Compose
│   ├── MainActivity.kt        # Application entry point

```

## Installation  

1. **Clone the Repository**  

   ```bash
   git clone https://github.com/youssefmsaber/tomanina.git
   cd tomanina
   ```

2. **Open in Android Studio**  

   - Open Android Studio  
   - Select "Open an Existing Project"  
   - Navigate to the project directory  

3. **Build and Run**  

   - Ensure you have an Android device or emulator set up  
   - Click "Run" ▶️ in Android Studio  

## API Configuration  

The app fetches prayer times using an external API. Update your API key in the appropriate data source class.  

## Contributing  

1. **Fork the repository**  
2. **Create a new branch**  

   ```bash
   git checkout -b feature/new-feature
   ```

3. **Commit your changes**  

   ```bash
   git commit -m "Add new feature"
   ```

4. **Push to GitHub**  

   ```bash
   git push origin feature/new-feature
   ```

5. **Open a Pull Request**  

## License  

This project is licensed under the MIT License.  
