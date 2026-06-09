<div align="center">
  <h1>🚀 Crypto Indoinfo</h1>
  <p><strong>A Modern Android Application for Real-Time Cryptocurrency Tracking</strong></p>

  <p>
    <img src="https://img.shields.io/badge/Kotlin-1.9.0-purple.svg?style=flat&logo=kotlin" alt="Kotlin" />
    <img src="https://img.shields.io/badge/Jetpack%20Compose-Material%203-blue.svg?style=flat&logo=android" alt="Jetpack Compose" />
    <img src="https://img.shields.io/badge/Architecture-MVVM-green.svg?style=flat" alt="MVVM" />
    <img src="https://img.shields.io/badge/License-MIT-orange.svg?style=flat" alt="License" />
  </p>
</div>

---

## 📖 Overview

**Crypto Indoinfo** is a comprehensive and visually appealing Android application designed to provide users with real-time updates and detailed insights into the cryptocurrency market. Built natively for Android using the latest technologies and best practices, it offers a seamless and intuitive user experience.

Whether you're tracking the price of Bitcoin, exploring Ethereum's market cap, or checking the latest trends for top altcoins, Crypto Indoinfo delivers accurate and up-to-date data right at your fingertips.

## ✨ Features

- **Real-Time Market Data**: Stay updated with live cryptocurrency prices, market caps, and 24h changes.
- **Top Assets Listing**: Browse through a curated list of top-performing cryptocurrencies.
- **Detailed Coin Information**: Dive deep into specific coins to view their history, supply, active markets, and useful project links (Website, Whitepaper, Source Code, etc.).
- **Modern UI/UX**: A sleek, dark-themed interface built entirely with Jetpack Compose and Material Design 3 guidelines.
- **Offline Caching**: Built-in support for viewing previously fetched data using Room Database.

## 🛠️ Tech Stack

This project is built using modern Android development tools and libraries:

- **[Kotlin](https://kotlinlang.org/)**: First-class and official programming language for Android development.
- **[Jetpack Compose](https://developer.android.com/jetpack/compose)**: Android's modern toolkit for building native UI seamlessly.
- **[Material Design 3](https://m3.material.io/)**: For modern, accessible, and beautiful UI components.
- **[Hilt / Dagger](https://dagger.dev/hilt/)**: Standard dependency injection library for Android.
- **[Retrofit 2](https://square.github.io/retrofit/) & OkHttp**: For robust and type-safe REST API communication.
- **[Room Database](https://developer.android.com/training/data-storage/room)**: For robust local data caching and offline support.
- **[Coil](https://coil-kt.github.io/coil/compose/)**: For fast and efficient image loading.
- **[Navigation Compose](https://developer.android.com/jetpack/compose/navigation)**: For seamless screen transitions and routing.

## 🏗️ Architecture

The app follows the **MVVM (Model-View-ViewModel)** architectural pattern and Clean Architecture principles to ensure separation of concerns, testability, and scalability.

- **UI Layer**: Jetpack Compose screens and ViewModels managing UI state.
- **Domain Layer**: Use cases and repository interfaces representing the business logic.
- **Data Layer**: Repository implementations, remote API data sources (Retrofit), and local database sources (Room).

## 🚀 Getting Started

### Prerequisites

- [Android Studio Iguana](https://developer.android.com/studio) or newer.
- JDK 17 (embedded with Android Studio).

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ekosanto2008/Crypto-Indoinfo.git
   ```

2. **Open the project in Android Studio:**
   - Launch Android Studio.
   - Select `File > Open` and navigate to the cloned directory.

3. **Sync Project with Gradle Files:**
   - Wait for Android Studio to index the project and download all dependencies.

4. **Run the App:**
   - Connect your Android device or start an Emulator.
   - Click the `Run` button (green play icon) or press `Shift + F10`.

## 🤝 Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

Distributed under the MIT License. See `LICENSE` for more information.

---
<div align="center">
  <sub>Built with ❤️ by <a href="https://github.com/ekosanto2008">ekosanto2008</a></sub>
</div>
