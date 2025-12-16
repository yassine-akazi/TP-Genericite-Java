# 🛒 Système de Gestion des Produits Marocains

Application Java en ligne de commande pour gérer un inventaire de produits marocains avec une architecture générique et orientée objet.

![Java](https://img.shields.io/badge/Java-8%2B-orange)
![License](https://img.shields.io/badge/License-MIT-green)
![Status](https://img.shields.io/badge/Status-Production-success)

## 📋 Table des matières

- [À propos](#à-propos)
- [Fonctionnalités](#fonctionnalités)
- [Architecture](#architecture)
- [Prérequis](#prérequis)
- [Installation](#installation)
- [Utilisation](#utilisation)
- [Structure du projet](#structure-du-projet)
- [Exemples](#exemples)
- [Contribuer](#contribuer)
- [Auteur](#auteur)
- [License](#license)

## 📖 À propos

Ce projet est une application de gestion d'inventaire développée en Java qui démontre l'utilisation de la **généricité** et des **interfaces** pour créer un système flexible et maintenable.  L'application gère un catalogue de produits marocains authentiques de différentes catégories.

### Objectifs pédagogiques

- Utiliser la généricité avec des collections d'objets
- Implémenter le pattern Repository avec des interfaces génériques
- Appliquer les principes SOLID
- Gérer les entrées utilisateur et les exceptions
- Structurer un projet Java professionnel

## ✨ Fonctionnalités

- ✅ **Afficher** la liste complète des produits
- 🔍 **Rechercher** un produit par son identifiant unique
- ➕ **Ajouter** de nouveaux produits à l'inventaire
- 🗑️ **Supprimer** des produits existants
- 💾 Gestion en mémoire avec ArrayList
- ⚠️ Validation des données et gestion des erreurs
- 🇲🇦 Catalogue pré-chargé avec 20 produits marocains

## 🏗️ Architecture

Le projet suit une architecture en couches avec séparation des responsabilités : 

```
┌─────────────────────────────────┐
│   Interface Utilisateur (CLI)   │  ← Application. java
├─────────────────────────────────┤
│     Couche Métier (Service)     │  ← MetierProduitImpl.java
├─────────────────────────────────┤
│    Interface Générique (DAO)    │  ← IMetier<T>
├─────────────────────────────────┤
│      Modèle de données          │  ← Produit. java
└─────────────────────────────────┘
```

### Principes de conception appliqués

- **Généricité** : Interface `IMetier<T>` réutilisable pour tout type d'entité
- **Encapsulation** : Attributs privés avec getters/setters
- **Séparation des préoccupations** : Logique métier séparée de l'interface utilisateur
- **Documentation** : Javadoc complète pour toutes les classes et méthodes

## 🔧 Prérequis

- **Java JDK 8** ou supérieur
- Un terminal/invite de commandes
- (Optionnel) Un IDE Java (IntelliJ IDEA, Eclipse, VS Code)

### Vérifier l'installation de Java

```bash
java -version
javac -version
```

Si Java n'est pas installé, téléchargez-le depuis [oracle. com/java](https://www.oracle.com/java/technologies/downloads/)

## 💻 Installation

### Méthode 1 : Clonage et compilation manuelle

```bash
# 1. Cloner le repository
git clone https://github.com/yassine-akazi/gestion-produits-maroc.git
cd gestion-produits-maroc

# 2. Compiler les fichiers Java
javac *.java

# 3. Exécuter l'application
java Application
```

### Méthode 2 : Avec un IDE

1. Ouvrir votre IDE (IntelliJ IDEA, Eclipse, VS Code)
2. Importer le projet comme un projet Java
3. Exécuter la classe `Application.java`

### Méthode 3 :  Créer un JAR exécutable

```bash
# 1. Compiler
javac *.java

# 2. Créer le manifest
echo "Main-Class: Application" > manifest.txt
echo "" >> manifest.txt

# 3. Créer le JAR
jar cfm GestionProduits.jar manifest. txt *.class

# 4. Exécuter
java -jar GestionProduits.jar
```

## 🚀 Utilisation

### Menu principal

Au lancement, l'application affiche un menu interactif :

```
========================================
    GESTION DES PRODUITS MAROCAINS
========================================
1. Afficher la liste des produits
2. Rechercher un produit par son id
3. Ajouter un nouveau produit
4. Supprimer un produit par id
5. Quitter ce programme
========================================
Votre choix : 
```

### Opérations disponibles

#### 1️⃣ Afficher la liste des produits

Affiche tous les produits avec leurs détails complets (ID, nom, marque, prix, description, stock).

#### 2️⃣ Rechercher un produit

Permet de rechercher un produit spécifique par son ID.

**Exemple :**
```
Entrez l'ID du produit à rechercher :  5

=== Produit trouvé ===
ID: 5
Nom: Couscous Moyen 1kg
Marque:  Dari Couspate
Prix: 15.0 MAD
Description: Couscous grain moyen traditionnel
Stock: 180 unités
```

#### 3️⃣ Ajouter un nouveau produit

Permet d'ajouter un nouveau produit en saisissant toutes ses informations.

**Exemple :**
```
=== Ajouter un nouveau produit ===
ID :  21
Nom : Thé à la Menthe
Marque : Sultan
Prix (MAD) : 35.50
Description : Thé vert premium à la menthe
Nombre en stock : 100

Produit ajouté avec succès !
```

#### 4️⃣ Supprimer un produit

Supprime un produit existant par son ID.

**Exemple :**
```
Entrez l'ID du produit à supprimer : 21

Produit supprimé avec succès !
```

#### 5️⃣ Quitter l'application

Ferme proprement l'application. 

## 📁 Structure du projet

```
gestion-produits-maroc/
│
├── Produit.java              # Classe modèle représentant un produit
├── IMetier.java              # Interface générique pour les opérations CRUD
├── MetierProduitImpl.java    # Implémentation de l'interface IMetier
├── Application.java          # Classe principale avec l'interface utilisateur
├── README.md                 # Documentation du projet
└── manifest.txt              # Fichier manifest pour création du JAR
```

### Description des classes

#### `Produit.java`
Classe POJO (Plain Old Java Object) représentant un produit avec :
- `id` : Identifiant unique
- `nom` : Nom du produit
- `marque` : Marque/fabricant
- `prix` : Prix en dirhams marocains (MAD)
- `description` : Description détaillée
- `nombreEnStock` : Quantité disponible

#### `IMetier<T>`
Interface générique définissant le contrat pour les opérations : 
- `add(T o)` : Ajouter un objet
- `getAll()` : Récupérer tous les objets
- `findById(long id)` : Trouver un objet par ID
- `delete(long id)` : Supprimer un objet

#### `MetierProduitImpl`
Implémentation concrète pour la gestion des produits :
- Stockage en mémoire avec `ArrayList<Produit>`
- Opérations CRUD complètes
- Complexité temporelle O(n) pour la recherche et suppression

#### `Application`
Point d'entrée de l'application :
- Boucle interactive du menu
- Gestion des entrées utilisateur
- Validation et gestion des erreurs
- 20 produits pré-chargés pour la démonstration

## 📦 Catalogue de produits

L'application est pré-chargée avec **20 produits marocains authentiques** :

| Catégorie | Nombre de produits | Marques |
|-----------|-------------------|---------|
| 🥛 Produits laitiers | 3 | Centrale Danone, Danone Maroc, Jaouda |
| 🌾 Farine & Couscous | 3 | Tria, Dari Couspate, MayMouna |
| 🍅 Conserves & Sauces | 3 | Aicha, Le Phare, Crespo Maroc |
| 🫒 Huiles | 3 | Lesieur Cristal, Zitounia, Oleor |
| 🍪 Biscuiterie | 3 | Bimo, Excelo, Tango |
| 🥤 Boissons | 3 | Sidi Ali, Poms, Coca-Cola Maroc |
| 🐟 Produits de la mer | 2 | Unimer, Conserves de Meknès |

## 💡 Exemples d'utilisation

### Exemple 1 : Afficher tous les produits laitiers

```java
// Filtrer et afficher uniquement les produits laitiers
List<Produit> produits = metier.getAll();
produits.stream()
    .filter(p -> p.getId() >= 1 && p.getId() <= 3)
    .forEach(System.out::println);
```

### Exemple 2 :  Calculer la valeur totale du stock

```java
double valeurTotale = metier.getAll().stream()
    .mapToDouble(p -> p.getPrix() * p.getNombreEnStock())
    .sum();
System.out.println("Valeur totale du stock : " + valeurTotale + " MAD");
```

### Exemple 3 : Trouver les produits en rupture de stock

```java
List<Produit> ruptureStock = metier.getAll().stream()
    .filter(p -> p.getNombreEnStock() < 10)
    .collect(Collectors.toList());
```

## 🧪 Tests

### Tests manuels recommandés

1. **Test d'ajout** : Ajouter un produit avec un ID existant (doit échouer)
2. **Test de recherche** :  Rechercher un ID inexistant (doit retourner null)
3. **Test de suppression** : Supprimer un produit puis vérifier qu'il n'existe plus
4. **Test de validation** : Entrer des valeurs invalides (lettres au lieu de nombres)

### Exemple de test unitaire (JUnit)

```java
@Test
public void testAjoutProduit() {
    IMetier<Produit> metier = new MetierProduitImpl();
    Produit p = new Produit(1, "Test", "Test", 10.0, "Test", 5);
    metier.add(p);
    
    assertEquals(1, metier.getAll().size());
    assertEquals(p, metier.findById(1));
}
```

## 🔮 Améliorations futures

- [ ] Persistance des données (fichiers, base de données)
- [ ] Modification des produits existants
- [ ] Recherche par nom ou marque
- [ ] Tri et filtrage avancés
- [ ] Interface graphique (JavaFX ou Swing)
- [ ] API REST pour accès distant
- [ ] Gestion des catégories de produits
- [ ] Historique des opérations
- [ ] Export/Import CSV ou JSON
- [ ] Gestion multi-utilisateurs avec authentification

## 🤝 Contribuer

Les contributions sont les bienvenues !  Voici comment participer :

1. **Fork** le projet
2. Créer une branche pour votre fonctionnalité (`git checkout -b feature/NouvelleFonctionnalite`)
3. Commiter vos changements (`git commit -m 'Ajout de NouvelleFonctionnalite'`)
4. Pousser vers la branche (`git push origin feature/NouvelleFonctionnalite`)
5. Ouvrir une **Pull Request**

### Guidelines de contribution

- Suivre les conventions de nommage Java
- Ajouter des commentaires Javadoc pour les nouvelles méthodes
- Tester votre code avant de soumettre
- Mettre à jour la documentation si nécessaire

## 📝 Changelog

### Version 1.0.0 (2025-12-16)

- ✨ Version initiale
- ✅ Opérations CRUD complètes
- 🇲🇦 Catalogue de 20 produits marocains
- 📚 Documentation complète
- 🛡️ Gestion des erreurs robuste

## 🐛 Problèmes connus

- Les données ne sont pas persistées après fermeture de l'application
- Pas de limite sur le nombre de produits pouvant être ajoutés
- Les prix négatifs ne sont pas validés

## 📄 License

Ce projet est sous licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus de détails.

```
MIT License

Copyright (c) 2025 Yassine Akazi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE. 
```

## 👤 Auteur

**Yassine Akazi**

- GitHub:  [@yassine-akazi](https://github.com/yassine-akazi)
- Email: contact@yassineakazi.com

## 🙏 Remerciements

- Merci aux marques marocaines pour leur contribution à l'économie locale
- Inspiration tirée des systèmes de gestion d'inventaire modernes
- Communauté Java pour les ressources et la documentation

## 📞 Support

Pour toute question ou problème : 

- 📧 Email : support@gestion-produits. ma
- 💬 Issues : [GitHub Issues](https://github.com/yassine-akazi/gestion-produits-maroc/issues)
- 📖 Documentation : [Wiki du projet](https://github.com/yassine-akazi/gestion-produits-maroc/wiki)

---

<div align="center">

**Fait avec ❤️ au Maroc 🇲🇦**

[![Made in Morocco](https://img.shields.io/badge/Made%20in-Morocco-red?style=for-the-badge)](https://www.morocco.com)

</div>