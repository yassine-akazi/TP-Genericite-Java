import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation concrète de l'interface IMetier pour la gestion des produits. 
 * Cette classe fournit les opérations CRUD pour manipuler une collection de produits
 * stockée en mémoire dans une ArrayList.
 * 
 * Cette implémentation utilise une structure de données en mémoire (ArrayList),
 * ce qui signifie que les données ne sont pas persistées après l'arrêt du programme.
 * Pour une persistance, il faudrait implémenter une couche de sauvegarde
 * (fichiers, base de données, etc.).
 * 
 * @author Yassine Akazi
 * @version 1.0
 * @since 2025-12-16
 */
public class MetierProduitImpl implements IMetier<Produit> {
    
    // ==================== Attributs ====================
    
    /**
     * Liste contenant l'ensemble des produits gérés par l'application.
     * Utilise ArrayList pour un accès rapide et une gestion flexible.
     */
    private List<Produit> produits;

    // ==================== Constructeur ====================
    
    /**
     * Constructeur par défaut. 
     * Initialise la liste des produits comme une ArrayList vide.
     */
    public MetierProduitImpl() {
        this.produits = new ArrayList<>();
    }

    // ==================== Méthodes CRUD ====================
    
    /**
     * Ajoute un nouveau produit à la liste.
     * Le produit est ajouté à la fin de la liste existante.
     * 
     * @param o Le produit à ajouter
     * @throws NullPointerException si le produit est null (comportement de ArrayList)
     */
    @Override
    public void add(Produit o) {
        produits.add(o);
    }

    /**
     * Retourne la liste complète de tous les produits.
     * 
     * @return Une liste contenant tous les produits enregistrés. 
     *         Retourne une liste vide si aucun produit n'existe.
     */
    @Override
    public List<Produit> getAll() {
        return produits;
    }

    /**
     * Recherche un produit par son identifiant unique.
     * Parcourt séquentiellement la liste jusqu'à trouver le produit correspondant.
     * 
     * Complexité temporelle:  O(n) où n est le nombre de produits. 
     * 
     * @param id L'identifiant du produit à rechercher
     * @return Le produit trouvé, ou null si aucun produit ne correspond à cet ID
     */
    @Override
    public Produit findById(long id) {
        // Parcours de tous les produits
        for (Produit produit : produits) {
            // Comparaison de l'ID du produit avec l'ID recherché
            if (produit. getId() == id) {
                return produit;
            }
        }
        // Aucun produit trouvé
        return null;
    }

    /**
     * Supprime un produit de la liste par son identifiant.
     * Utilise l'API Stream et removeIf pour une suppression efficace.
     * 
     * Si aucun produit ne correspond à l'ID, aucune action n'est effectuée. 
     * Si plusieurs produits ont le même ID (ce qui ne devrait pas arriver),
     * tous seront supprimés.
     * 
     * @param id L'identifiant du produit à supprimer
     */
    @Override
    public void delete(long id) {
        // Suppression fonctionnelle avec lambda expression
        produits.removeIf(produit -> produit.getId() == id);
    }
}