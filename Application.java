import java.util.List;
import java.util.Scanner;

/**
 * Classe principale de l'application de gestion des produits. 
 * Cette classe contient le point d'entrée du programme (méthode main)
 * et gère l'interface utilisateur en ligne de commande.
 * 
 * L'application propose un menu interactif permettant de :
 * - Afficher la liste des produits
 * - Rechercher un produit par ID
 * - Ajouter un nouveau produit
 * - Supprimer un produit
 * - Quitter l'application
 * 
 * @author Yassine Akazi
 * @version 1.0
 * @since 2025-12-16
 */
public class Application {
    
    // ==================== Point d'entrée ====================
    
    /**
     * Méthode principale de l'application.
     * Initialise le système, charge des données de démonstration,
     * et lance la boucle interactive du menu utilisateur.
     * 
     * @param args Arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        // Initialisation du scanner pour la lecture des entrées utilisateur
        Scanner scanner = new Scanner(System.in);
        
        // Création de l'instance de gestion métier des produits
        IMetier<Produit> metier = new MetierProduitImpl();
        
        // ===== Chargement de données de démonstration - Produits Marocains =====
        
        // Produits laitiers
        metier.add(new Produit(1, "Lait Demi-Écremé 1L", "Centrale Danone", 8.50, "Lait frais pasteurisé demi-écrémé", 200));
        metier.add(new Produit(2, "Yaourt Nature", "Danone Maroc", 12.00, "Pack de 4 yaourts nature", 150));
        metier.add(new Produit(3, "Fromage Jben", "Jaouda", 25.00, "Fromage blanc traditionnel 200g", 80));
        
        // Farine, semoule, couscous
        metier.add(new Produit(4, "Farine Supérieure 1kg", "Tria", 6.50, "Farine de blé tendre pour pâtisserie", 300));
        metier.add(new Produit(5, "Couscous Moyen 1kg", "Dari Couspate", 15.00, "Couscous grain moyen traditionnel", 180));
        metier.add(new Produit(6, "Semoule Extra Fine 1kg", "MayMouna", 11.00, "Semoule de blé dur extra fine", 120));
        
        // Conserves et sauces
        metier. add(new Produit(7, "Double Concentré Tomate", "Aicha", 8.00, "Concentré de tomate 70g", 250));
        metier.add(new Produit(8, "Harissa Piquante", "Le Phare", 12.50, "Harissa traditionnelle 200g", 100));
        metier.add(new Produit(9, "Olives Vertes", "Crespo Maroc", 22.00, "Olives vertes dénoyautées 350g", 90));
        
        // Huiles et dérivés
        metier.add(new Produit(10, "Huile de Table 1L", "Lesieur Cristal", 18.00, "Huile végétale raffinée", 200));
        metier.add(new Produit(11, "Huile d'Olive Vierge", "Zitounia", 65.00, "Huile d'olive extra vierge 500ml", 75));
        metier.add(new Produit(12, "Huile d'Argan Bio", "Oleor", 120.00, "Huile d'argan cosmétique 100ml", 50));
        
        // Biscuiterie et sucreries
        metier.add(new Produit(13, "Biscuits Petit Déjeuner", "Bimo", 9.50, "Biscuits au miel 200g", 180));
        metier.add(new Produit(14, "Gâteaux Fourrés", "Excelo", 14.00, "Gâteaux fourrés chocolat 180g", 140));
        metier.add(new Produit(15, "Bonbons Tango", "Tango", 5.00, "Bonbons fruités assortis 100g", 220));
        
        // Boissons et divers
        metier.add(new Produit(16, "Eau Minérale 1. 5L", "Sidi Ali", 4.50, "Eau minérale naturelle", 400));
        metier.add(new Produit(17, "Jus d'Orange", "Poms", 12.00, "Jus 100% orange 1L", 150));
        metier.add(new Produit(18, "Coca-Cola 1L", "Coca-Cola Maroc", 9.00, "Boisson gazeuse", 280));
        
        // Produits de la mer
        metier.add(new Produit(19, "Sardines à l'Huile", "Unimer", 16.50, "Sardines en conserve 125g", 160));
        metier.add(new Produit(20, "Thon Naturel", "Conserves de Meknès", 28.00, "Thon entier au naturel 160g", 110));

        // Variable pour stocker le choix de l'utilisateur
        int choix = 0;

        // ===== Boucle principale du menu =====
        while (choix != 5) {
            // Affichage du menu
            afficherMenu();
            
            try {
                // Lecture du choix de l'utilisateur
                choix = scanner.nextInt();
                scanner.nextLine(); // Consommer le retour à la ligne

                // Traitement du choix
                switch (choix) {
                    case 1:
                        // Afficher tous les produits
                        afficherListeProduits(metier);
                        break;
                    case 2:
                        // Rechercher un produit par ID
                        rechercherProduit(scanner, metier);
                        break;
                    case 3:
                        // Ajouter un nouveau produit
                        ajouterProduit(scanner, metier);
                        break;
                    case 4:
                        // Supprimer un produit
                        supprimerProduit(scanner, metier);
                        break;
                    case 5:
                        // Quitter l'application
                        System.out.println("\n========================================");
                        System.out. println("  Merci d'avoir utilisé notre système");
                        System.out.println("  Au revoir !");
                        System.out. println("========================================");
                        break;
                    default: 
                        // Choix invalide
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } catch (Exception e) {
                // Gestion des erreurs de saisie
                System. out.println("Erreur :  Veuillez entrer un nombre valide.");
                scanner.nextLine(); // Nettoyer le buffer
                choix = 0; // Réinitialiser pour continuer la boucle
            }
            
            // Pause avant de réafficher le menu
            if (choix != 5) {
                System.out.println("\nAppuyez sur Entrée pour continuer...");
                scanner. nextLine();
            }
        }

        // Fermeture du scanner pour libérer les ressources
        scanner.close();
    }

    // ==================== Méthodes d'affichage ====================
    
    /**
     * Affiche le menu principal de l'application.
     * Présente toutes les options disponibles de manière formatée.
     */
    private static void afficherMenu() {
        System.out.println("\n========================================");
        System.out. println("    GESTION DES PRODUITS MAROCAINS");
        System.out.println("========================================");
        System.out.println("1. Afficher la liste des produits");
        System.out.println("2. Rechercher un produit par son id");
        System.out.println("3. Ajouter un nouveau produit");
        System.out.println("4. Supprimer un produit par id");
        System.out.println("5. Quitter ce programme");
        System.out. println("========================================");
        System.out.print("Votre choix : ");
    }

    /**
     * Affiche la liste complète de tous les produits.
     * Si la liste est vide, un message approprié est affiché.
     * Chaque produit est affiché avec tous ses détails de manière formatée.
     * 
     * @param metier L'instance de gestion métier contenant les produits
     */
    private static void afficherListeProduits(IMetier<Produit> metier) {
        // Récupération de tous les produits
        List<Produit> produits = metier.getAll();
        
        // Vérification si la liste est vide
        if (produits. isEmpty()) {
            System.out.println("\nAucun produit dans la liste.");
        } else {
            System.out.println("\n========================================");
            System.out.println("       LISTE DES PRODUITS");
            System.out.println("========================================");
            
            // Parcours et affichage de chaque produit
            for (Produit p : produits) {
                System.out.println("----------------------------------------");
                System.out.println("ID:  " + p.getId());
                System.out.println("Nom: " + p.getNom());
                System.out.println("Marque: " + p.getMarque());
                System.out. println("Prix: " + p. getPrix() + " MAD");
                System.out.println("Description: " + p.getDescription());
                System.out.println("Stock: " + p.getNombreEnStock() + " unités");
            }
            
            System.out.println("----------------------------------------");
            System.out.println("Total:  " + produits.size() + " produit(s)");
        }
    }

    // ==================== Méthodes de gestion ====================
    
    /**
     * Permet à l'utilisateur de rechercher un produit par son ID. 
     * Demande l'ID, effectue la recherche et affiche les détails du produit trouvé.
     * Si le produit n'existe pas, un message approprié est affiché. 
     * 
     * @param scanner Le scanner pour lire l'entrée utilisateur
     * @param metier L'instance de gestion métier pour effectuer la recherche
     */
    private static void rechercherProduit(Scanner scanner, IMetier<Produit> metier) {
        System.out. print("\nEntrez l'ID du produit à rechercher : ");
        
        try {
            // Lecture de l'ID
            long id = scanner.nextLong();
            scanner.nextLine(); // Consommer le retour à la ligne
            
            // Recherche du produit
            Produit produit = metier.findById(id);
            
            // Affichage du résultat
            if (produit != null) {
                System. out.println("\n=== Produit trouvé ===");
                System.out.println("ID: " + produit.getId());
                System.out.println("Nom: " + produit. getNom());
                System.out.println("Marque: " + produit.getMarque());
                System.out.println("Prix: " + produit.getPrix() + " MAD");
                System.out.println("Description: " + produit.getDescription());
                System.out.println("Stock: " + produit. getNombreEnStock() + " unités");
            } else {
                System.out.println("\nAucun produit trouvé avec l'ID " + id);
            }
        } catch (Exception e) {
            // Gestion des erreurs de saisie
            System.out.println("Erreur : ID invalide.");
            scanner.nextLine(); // Nettoyer le buffer
        }
    }

    /**
     * Permet à l'utilisateur d'ajouter un nouveau produit. 
     * Demande toutes les informations nécessaires et crée le produit.
     * Vérifie que l'ID n'existe pas déjà pour éviter les doublons.
     * 
     * @param scanner Le scanner pour lire les entrées utilisateur
     * @param metier L'instance de gestion métier pour ajouter le produit
     */
    private static void ajouterProduit(Scanner scanner, IMetier<Produit> metier) {
        System.out.println("\n=== Ajouter un nouveau produit ===");
        
        try {
            // ===== Saisie de l'ID =====
            System.out.print("ID :  ");
            long id = scanner. nextLong();
            scanner. nextLine(); // Consommer le retour à la ligne
            
            // Vérification de l'unicité de l'ID
            if (metier.findById(id) != null) {
                System.out.println("Erreur : Un produit avec cet ID existe déjà.");
                return;
            }
            
            // ===== Saisie des autres informations =====
            System.out.print("Nom :  ");
            String nom = scanner. nextLine();
            
            System.out.print("Marque : ");
            String marque = scanner.nextLine();
            
            System.out.print("Prix (MAD) : ");
            double prix = scanner.nextDouble();
            scanner.nextLine(); // Consommer le retour à la ligne
            
            System.out.print("Description : ");
            String description = scanner.nextLine();
            
            System.out.print("Nombre en stock : ");
            int stock = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne
            
            // ===== Création et ajout du produit =====
            Produit nouveauProduit = new Produit(id, nom, marque, prix, description, stock);
            metier.add(nouveauProduit);
            
            // Confirmation
            System.out.println("\nProduit ajouté avec succès !");
            
        } catch (Exception e) {
            // Gestion des erreurs de saisie
            System.out.println("Erreur lors de l'ajout du produit.");
            scanner.nextLine(); // Nettoyer le buffer
        }
    }

    /**
     * Permet à l'utilisateur de supprimer un produit par son ID.
     * Vérifie l'existence du produit avant de le supprimer.
     * Affiche un message de confirmation ou d'erreur selon le résultat.
     * 
     * @param scanner Le scanner pour lire l'entrée utilisateur
     * @param metier L'instance de gestion métier pour effectuer la suppression
     */
    private static void supprimerProduit(Scanner scanner, IMetier<Produit> metier) {
        System.out. print("\nEntrez l'ID du produit à supprimer :  ");
        
        try {
            // Lecture de l'ID
            long id = scanner.nextLong();
            scanner.nextLine(); // Consommer le retour à la ligne
            
            // Vérification de l'existence du produit
            Produit produit = metier.findById(id);
            
            if (produit != null) {
                // Suppression du produit
                metier.delete(id);
                System.out.println("\nProduit supprimé avec succès !");
            } else {
                System.out.println("\nAucun produit trouvé avec l'ID " + id);
            }
        } catch (Exception e) {
            // Gestion des erreurs de saisie
            System.out.println("Erreur : ID invalide.");
            scanner.nextLine(); // Nettoyer le buffer
        }
    }
}