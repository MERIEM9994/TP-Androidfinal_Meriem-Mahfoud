# BookStoreApp - Application de Gestion de Livres 📚

Une application Android moderne développée avec Jetpack Compose et l'architecture MVI.

## 🚀 Fonctionnalités
- Affichage d'une liste de livres
- Fiche détaillée pour chaque livre
- Gestion des états (chargement, erreur, succès)
- Navigation entre écrans
- Design Material 3

## 🏗 Architecture MVI
### Structure des composants
```plaintext
data/
├── Entities/    # Modèles de données
│   └── Book.kt
└── Repository/  # Accès aux données
    └── BookRepository.kt

ui/
├── product/
│   ├── component/       # Composants UI
│   │   ├── ProductsList.kt
│   │   ├── BookItem.kt
│   │   └── DetailsScreen.kt
│   ├── screens/         # Écrans
│   │   └── HomeScreen.kt
│   ├── ProductIntent.kt # Actions utilisateur
│   ├── ProductViewModel.kt
│   └── ProductViewState.kt

nav/              # Navigation
└── Navigation.kt

******************************************************************************************************************************************************************************************
graph TD
    A[Intent] --> B(ViewModel)
    B --> C{ViewState}
    C --> D[UI]
    D -->|User Action| A



🛠 Technologies
Kotlin 100%

Jetpack Compose

Architecture MVI (Model-View-Intent)

Navigation Compose

Material Design 3

StateFlow pour la gestion d'état
******************************************************************************************************************************************************************************************


