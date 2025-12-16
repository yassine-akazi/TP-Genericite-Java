# TP-Genericite-Java# TP : Gestion de Produits avec Généricité (Java)

Ce projet est une application console Java développée dans le cadre du module **Programmation Orientée Objet 2024**. L'objectif principal est de mettre en pratique le concept de **Généricité** à travers la gestion d'un stock de produits .

## 📄 Description

L'application permet de gérer une collection d'objets de type `Produit` via une architecture souple basée sur une interface générique. Elle offre un menu interactif permettant à l'utilisateur d'effectuer les opérations de base (CRUD) sur les données .

Le projet respecte les contraintes suivantes :
* Utilisation d'une classe `Produit` avec des attributs spécifiques (id, nom, marque, prix, description, stock) .
* Définition d'une interface générique `IMetier<T>` .
* Implémentation de la logique métier via `MetierProduitImpl` .

## 🛠️ Fonctionnalités

L'application propose les fonctionnalités suivantes via un menu textuel :

1.  **Afficher la liste :** Consulter tous les produits disponibles en stock .
2.  **Rechercher :** Trouver un produit spécifique grâce à son identifiant unique (ID) .
3.  **Ajouter :** Insérer un nouveau produit dans la collection .
4.  **Supprimer :** Retirer un produit de la liste via son ID .
5.  **Quitter :** Sortir de l'application .

## 🏗️ Architecture Technique

* **`Produit.java`** : JavaBean représentant l'entité produit.
* **`IMetier.java`** : Interface générique définissant les signatures des méthodes (`add`, `getAll`, `findById`, `delete`) .
* **`MetierProduitImpl.java`** : Classe d'implémentation gérant une `List<Produit>`.
* **`Application.java`** : Point d'entrée contenant la méthode `main` et la boucle d'interaction utilisateur.

## 📦 Changelog (Historique des changements)

Toutes les modifications notables de ce projet seront documentées dans cette section.


#### Ajouté
- Création de la classe entité `Produit` avec constructeurs et accesseurs.
- Création de l'interface générique `IMetier<T>` pour standardiser les opérations.
- Implémentation de la classe `MetierProduitImpl` avec gestion via `ArrayList`.
- Mise en place de la classe `Application` avec un menu interactif (Switch/Case).
- Gestion des entrées utilisateur pour l'ajout et la recherche de produits.

---
**Encadrant :** Mr. Abdelmajid BOUSSELHAM
