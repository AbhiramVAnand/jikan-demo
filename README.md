# Jikan-Demo 📺✨
---

## 🔧 What I Used

- **Jetpack Compose** for UI
- **Dagger Hilt** for dependency injection
- **Paging 3** for efficient infinite scrolling
- **Coil** for image loading
- **Navigation-Compose** for handling navigation between screens
- **AndroidView** to embed YouTube trailer videos via WebView
- **Material Chips** for genre display

---

## 🧱 Architecture

This project follows a **clean MVVM architecture**:

- `ViewModel` handles state and business logic.
- `Repository` layer interacts with the network API.
- UI is reactive and built with Compose.

---

## 🖼️ Screens

- **Anime List Screen** – paginated list of anime with posters and titles
- **Anime Detail Screen** – trailer player or image, full synopsis, genres (chips), cast, episode count, and rating

---

## 🔍 API Used

[Jikan API v4](https://docs.api.jikan.moe/)
