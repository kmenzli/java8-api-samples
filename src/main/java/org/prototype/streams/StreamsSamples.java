package org.prototype.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kmenzli on 2/9/17.
 */
public class StreamsSamples {

    public static void beforeJ8() {
        List<Commande> listeCommandes = new ArrayList<Commande>();
        listeCommandes.add(new Commande("20140509", 113.12));
        listeCommandes.add(new Commande("20140508", 113.07));
        listeCommandes.add(new Commande("20140507", 356.03));
        listeCommandes.add(new Commande("20140512", 78.94));
        listeCommandes.add(new Commande("20140409", 163.23));
        listeCommandes.add(new Commande("20140429", 982.34));
        listeCommandes.add(new Commande("20140508", 172.89));

        List lListeCommandeMoisMai =new ArrayList();
        for (Commande commande : listeCommandes) {
            if(commande.numero.startsWith("201405")){
                lListeCommandeMoisMai.add(commande);
            }
        }
    }
    public static void afterJ8() {
        List<Commande> listeCommandes = new ArrayList<Commande>();
        listeCommandes.add(new Commande("20140509", 113.12));
        listeCommandes.add(new Commande("20140508", 113.07));
        listeCommandes.add(new Commande("20140507", 356.03));
        listeCommandes.add(new Commande("20140512", 78.94));
        listeCommandes.add(new Commande("20140409", 163.23));
        listeCommandes.add(new Commande("20140429", 982.34));
        listeCommandes.add(new Commande("20140508", 172.89));
        List lListeCommandeMoisMai = listeCommandes.stream()

                                                    .filter(x -> x.numero.startsWith("201405"))
                                                    .collect(Collectors.toList());

    }
    public static void sortedStream() {
        List<Commande> listeCommandes = new ArrayList<Commande>();
        listeCommandes.add(new Commande("20140509", 113.12));
        listeCommandes.add(new Commande("20140508", 113.07));
        listeCommandes.add(new Commande("20140507", 356.03));
        listeCommandes.add(new Commande("20140512", 78.94));
        listeCommandes.add(new Commande("20140409", 163.23));
        listeCommandes.add(new Commande("20140429", 982.34));
        listeCommandes.add(new Commande("20140508", 172.89));
        //--- Les streams offrent aussi la possibilité de trier directement le résultat de sorti,
        // par exemple si nous voulions récupérer les TVA par ordre croissant,
        // il suffit d’écrire: Ici l’order naturel est utilisé car aucun comparator n’est passé en paramètre de la méthode sorted.
        List lListeCommandeMai = listeCommandes.stream()
                .filter(x -> x.numero.startsWith("201405")).map(x -> x.montant*0.2)
                .sorted()
                .collect(Collectors.toList());

    }
    public static void disctinctStream() {
        List<Commande> listeCommandes = new ArrayList<Commande>();
        listeCommandes.add(new Commande("20140509", 113.12));
        listeCommandes.add(new Commande("20140508", 113.07));
        listeCommandes.add(new Commande("20140507", 356.03));
        listeCommandes.add(new Commande("20140512", 78.94));
        listeCommandes.add(new Commande("20140409", 163.23));
        listeCommandes.add(new Commande("20140429", 982.34));
        listeCommandes.add(new Commande("20140508", 172.89));
        //--- Mais il est aussi possible de ne choisir que des éléments distinct avec l’instruction distinct().
        //--- Ne même l’ordre naturel est utilisé pour réaliser le disctinct.
        List lListeCommandeMai = listeCommandes.stream()
                .filter(x -> x.numero.startsWith("201405")).map(x -> x.montant*0.2)
                .distinct()
                .collect(Collectors.toList());

    }

    public static void sortedWithcomparatorStream() {
        List<Commande> listeCommandes = new ArrayList<Commande>();
        listeCommandes.add(new Commande("20140509", 113.12));
        listeCommandes.add(new Commande("20140508", 113.07));
        listeCommandes.add(new Commande("20140507", 356.03));
        listeCommandes.add(new Commande("20140512", 78.94));
        listeCommandes.add(new Commande("20140409", 163.23));
        listeCommandes.add(new Commande("20140429", 982.34));
        listeCommandes.add(new Commande("20140508", 172.89));

        List lListeCommandeMai= listeCommandes.stream()
                .filter(x -> x.numero.startsWith("201405"))
                .sorted((x1, x2) -> (int)(x1.montant - x2.montant))
                .collect(Collectors.toList());

    }

    public static void maxStream() {
        List<Commande> listeCommandes = new ArrayList<Commande>();
        listeCommandes.add(new Commande("20140509", 113.12));
        listeCommandes.add(new Commande("20140508", 113.07));
        listeCommandes.add(new Commande("20140507", 356.03));
        listeCommandes.add(new Commande("20140512", 78.94));
        listeCommandes.add(new Commande("20140409", 163.23));
        listeCommandes.add(new Commande("20140429", 982.34));
        listeCommandes.add(new Commande("20140508", 172.89));

        //--- Très simplement, pour récupérer le max des commandes, l’utilisation des STREAM simplifie encore l’écriture.
        //--- Ici nous récupérer la commande avec le plus gros montant en spécifiant nous même notre comparator.
        //--- Attention, ici, on remarque que l’on utilise le méthode GET pour récupérer le résultat car max par définition
        //--- ne renvoie qu’un élément.
        Commande commande = listeCommandes.stream()
                .filter(x -> x.numero.startsWith("201405"))
                .max((x1, x2) -> (int) (x1.montant - x2.montant)).get();

    }
    public static void minStream() {
        List<Commande> listeCommandes = new ArrayList<Commande>();
        listeCommandes.add(new Commande("20140509", 113.12));
        listeCommandes.add(new Commande("20140508", 113.07));
        listeCommandes.add(new Commande("20140507", 356.03));
        listeCommandes.add(new Commande("20140512", 78.94));
        listeCommandes.add(new Commande("20140409", 163.23));
        listeCommandes.add(new Commande("20140429", 982.34));
        listeCommandes.add(new Commande("20140508", 172.89));

        //--- Il est aussi possible de limiter le nombre de résultat en sortie d’un stream avec l’utilisation de la commande limit().
        //--- Ici nous allons récupérer les deux commandes avec le plus gros montant.
        List lListeCommandeMai = listeCommandes.stream()
                .filter(x -> x.numero.startsWith("201405"))
                .sorted((x1, x2) -> (int)(x1.montant - x2.montant))
                .limit(2)
                .collect(Collectors.toList());

    }

    public static void countStream() {
        List<Commande> listeCommandes = new ArrayList<Commande>();
        listeCommandes.add(new Commande("20140509", 113.12));
        listeCommandes.add(new Commande("20140508", 113.07));
        listeCommandes.add(new Commande("20140507", 356.03));
        listeCommandes.add(new Commande("20140512", 78.94));
        listeCommandes.add(new Commande("20140409", 163.23));
        listeCommandes.add(new Commande("20140429", 982.34));
        listeCommandes.add(new Commande("20140508", 172.89));

        //--- Il est aussi parfois interessant de juster compter le nombre d’éléments présent dans notre filtre.
        //--- Pour ce faire, on peut utiliser la méthode COUNT directement sur le stream
        long nombreElement = listeCommandes.stream()
                .filter(x -> x.numero.startsWith("201405"))
                .count();

    }


    public static void main(String[] args) {
        minStream();

    }

}
