# IndoFriendly

Mobile app for international students at Indonesian universities to learn
everyday Bahasa Indonesia, understand local customs, and connect with local
students. Final project for Mobile App Development 2026.
Built with Jetpack Compose, MVVM and Navigation Compose.

## Planned Features
- [ ] Login and register (JWT access token + refresh token)
- [ ] Role-based UI (admin, international student, local student)
- [ ] Phrases with everyday versions for friend, classmate, older person, dosen (CRUDS)
- [ ] Categories (CRUDS)
- [ ] Customs and gestures (CRUDS)
- [ ] Saved phrases (CRUDS)
- [ ] AI explanations with Gemini through own backend (CRUDS)
- [ ] Local guide: groceries, cultural clothes, food by taste
- [ ] Buddy chat
- [ ] Local file export
- [ ] REST API with MySQL backend

## Tech Stack
Kotlin, Jetpack Compose, MVVM, Navigation Compose, Retrofit, MySQL (backend)

## Progress Log
### Week 1
- Created the repository and Compose project
- Added navigation, ViewModel and Retrofit dependencies
- Added auth data models
- Built login and register screens with form validation (UI only, API not connected yet)
- Added AuthViewModel to hold form state and validation
- Set up Navigation Compose between login and register
- Added the app theme and Compose previews for both screens