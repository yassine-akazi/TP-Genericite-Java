import java.util.List;

/**
 * Interface générique pour la gestion des entités métier.
 * Cette interface définit les opérations CRUD (Create, Read, Update, Delete)
 * de base pour n'importe quel type d'entité. 
 * 
 * Le pattern générique permet de réutiliser cette interface pour différents
 * types d'objets métier sans duplication de code.
 * 
 * @param <T> Le type d'entité géré par cette interface
 * 
 * @author Yassine Akazi
 * @version 1.0
 * @since 2025-12-16
 */
public interface IMetier<T> {
    
    /**
     * Ajoute un nouvel objet à la collection.
     * Cette méthode permet d'insérer une nouvelle entité dans le système.
     * 
     * @param o L'objet à ajouter à la collection
     * @throws IllegalArgumentException si l'objet est null
     */
    public void add(T o);

    /**
     * Récupère tous les objets de la collection.
     * Cette méthode retourne l'ensemble des entités stockées. 
     * 
     * @return Une liste contenant tous les objets de type T. 
     *         Retourne une liste vide si aucun objet n'existe.
     */
    public List<T> getAll();

    /**
     * Recherche un objet par son identifiant unique.
     * Cette méthode permet de récupérer une entité spécifique
     * en utilisant son ID comme critère de recherche.
     * 
     * @param id L'identifiant unique de l'objet à rechercher
     * @return L'objet correspondant à l'ID, ou null si aucun objet n'est trouvé
     */
    public T findById(long id);

    /**
     * Supprime un objet de la collection par son identifiant. 
     * Cette méthode retire définitivement l'entité du système.
     * Si l'ID n'existe pas, aucune action n'est effectuée.
     * 
     * @param id L'identifiant unique de l'objet à supprimer
     */
    public void delete(long id);
}