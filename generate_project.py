import os

# Smiya d dossier
folder_name = "TP_Genericite"

# Le contenu des fichiers
code_produit = """
public class Produit {
    private long id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombreStock;

    public Produit() {}

    public Produit(long id, String nom, String marque, double prix, String description, int nombreStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreStock = nombreStock;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getNombreStock() { return nombreStock; }
    public void setNombreStock(int nombreStock) { this.nombreStock = nombreStock; }

    @Override
    public String toString() {
        return "Produit [id=" + id + ", nom=" + nom + ", marque=" + marque + ", prix=" + prix + ", qté=" + nombreStock + "]";
    }
}
"""

code_imetier = """
import java.util.List;

public interface IMetier<T> {
    public void add(T o);
    public List<T> getAll();
    public T findById(long id);
    public void delete(long id);
}
"""

code_impl = """
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    private List<Produit> produits = new ArrayList<>();

    @Override
    public void add(Produit o) {
        produits.add(o);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : produits) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        Produit p = findById(id);
        if (p != null) {
            produits.remove(p);
        } else {
            System.out.println("Produit introuvable.");
        }
    }
}
"""

code_app = """
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        while (choix != 5) {
            System.out.println("\\n--- MENU ---");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter ce programme.");
            System.out.print("Votre choix : ");
            
            if(scanner.hasNextInt()){
                choix = scanner.nextInt();
            } else {
                scanner.next();
                continue;
            }

            switch (choix) {
                case 1:
                    System.out.println("Liste des produits :");
                    for (Produit p : metier.getAll()) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.print("Entrez l'ID du produit à rechercher : ");
                    long idRech = scanner.nextLong();
                    Produit p = metier.findById(idRech);
                    if (p != null) System.out.println("Produit trouvé : " + p);
                    else System.out.println("Aucun produit avec cet ID.");
                    break;
                case 3:
                    System.out.println("Ajout d'un nouveau produit :");
                    System.out.print("ID : "); long id = scanner.nextLong(); scanner.nextLine();
                    System.out.print("Nom : "); String nom = scanner.nextLine();
                    System.out.print("Marque : "); String marque = scanner.nextLine();
                    System.out.print("Prix : "); double prix = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Description : "); String desc = scanner.nextLine();
                    System.out.print("Stock : "); int stock = scanner.nextInt();
                    metier.add(new Produit(id, nom, marque, prix, desc, stock));
                    System.out.println("Produit ajouté.");
                    break;
                case 4:
                    System.out.print("Entrez l'ID du produit à supprimer : ");
                    long idDel = scanner.nextLong();
                    metier.delete(idDel);
                    System.out.println("Suppression terminée.");
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
        scanner.close();
    }
}
"""

# Création du dossier et des fichiers
if not os.path.exists(folder_name):
    os.makedirs(folder_name)

files = {
    "Produit.java": code_produit,
    "IMetier.java": code_imetier,
    "MetierProduitImpl.java": code_impl,
    "Application.java": code_app
}

for filename, content in files.items():
    with open(os.path.join(folder_name, filename), "w", encoding="utf-8") as f:
        f.write(content.strip())

print(f"Dossier '{folder_name}' makhdoum w fih les fichiers .java wajdin!")
