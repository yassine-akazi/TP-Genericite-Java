/**
 * Classe représentant un produit dans le système de gestion. 
 * Cette classe encapsule toutes les informations relatives à un produit,
 * y compris son identifiant, ses caractéristiques et son stock.
 * 
 * @author Yassine Akazi
 * @version 1.0
 * @since 2025-12-16
 */
public class Produit {
    
    // ==================== Attributs ====================
    
    /**
     * Identifiant unique du produit
     */
    private long id;
    
    /**
     * Nom du produit
     */
    private String nom;
    
    /**
     * Marque du produit
     */
    private String marque;
    
    /**
     * Prix unitaire du produit en euros
     */
    private double prix;
    
    /**
     * Description détaillée du produit
     */
    private String description;
    
    /**
     * Quantité disponible en stock
     */
    private int nombreEnStock;

    // ==================== Constructeurs ====================
    
    /**
     * Constructeur par défaut. 
     * Initialise un produit avec des valeurs par défaut.
     */
    public Produit() {
    }

    /**
     * Constructeur avec paramètres.
     * Initialise un produit avec toutes ses caractéristiques.
     * 
     * @param id Identifiant unique du produit
     * @param nom Nom du produit
     * @param marque Marque du produit
     * @param prix Prix unitaire du produit
     * @param description Description détaillée du produit
     * @param nombreEnStock Quantité disponible en stock
     */
    public Produit(long id, String nom, String marque, double prix, String description, int nombreEnStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreEnStock = nombreEnStock;
    }

    // ==================== Getters et Setters ====================
    
    /**
     * Retourne l'identifiant du produit. 
     * 
     * @return L'identifiant unique du produit
     */
    public long getId() {
        return id;
    }

    /**
     * Modifie l'identifiant du produit.
     * 
     * @param id Le nouvel identifiant du produit
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Retourne le nom du produit. 
     * 
     * @return Le nom du produit
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom du produit.
     * 
     * @param nom Le nouveau nom du produit
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la marque du produit.
     * 
     * @return La marque du produit
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Modifie la marque du produit. 
     * 
     * @param marque La nouvelle marque du produit
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * Retourne le prix du produit.
     * 
     * @return Le prix unitaire du produit en euros
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Modifie le prix du produit.
     * 
     * @param prix Le nouveau prix du produit
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Retourne la description du produit.
     * 
     * @return La description détaillée du produit
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifie la description du produit. 
     * 
     * @param description La nouvelle description du produit
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne le nombre d'unités en stock.
     * 
     * @return La quantité disponible en stock
     */
    public int getNombreEnStock() {
        return nombreEnStock;
    }

    /**
     * Modifie le nombre d'unités en stock.
     * 
     * @param nombreEnStock La nouvelle quantité en stock
     */
    public void setNombreEnStock(int nombreEnStock) {
        this.nombreEnStock = nombreEnStock;
    }

    // ==================== Méthodes ====================
    
    /**
     * Retourne une représentation textuelle du produit.
     * Inclut tous les attributs du produit dans un format lisible.
     * 
     * @return Une chaîne de caractères représentant le produit
     */
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nombreEnStock=" + nombreEnStock +
                '}';
    }
}