package org.prototype.streams.map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kmenzli on 2/9/17.
 */
public class MapSamples {

    public static void mapStreams1() {

        List<Facture> listeCommandes = new ArrayList<Facture>();
        listeCommandes.add(new Facture("20140509", 113.12));
        listeCommandes.add(new Facture("20140508", 113.07));
        listeCommandes.add(new Facture("20140507", 356.03));
        listeCommandes.add(new Facture("20140512", 78.94));
        listeCommandes.add(new Facture("20140409", 163.23));
        listeCommandes.add(new Facture("20140429", 982.34));
        listeCommandes.add(new Facture("20140508", 172.89));

        //--- L’utilisation de l’instruction map() permet de choisir quel élement on veut « récupérer » dans notre steam.
        List listeCommandeMai = listeCommandes.stream()
                                                .filter(x -> x.numero.startsWith("201405"))
                                                .map(x -> x.montant)
                //la méthode COLLECT (opération terminale) pour récupérer nos éléménts dans une liste.
                                                .collect(Collectors.toList());
    }
    public static void mapStreams2() {

        List<Facture> listeCommandes = new ArrayList<Facture>();
        listeCommandes.add(new Facture("20140509", 113.12));
        listeCommandes.add(new Facture("20140508", 113.07));
        listeCommandes.add(new Facture("20140507", 356.03));
        listeCommandes.add(new Facture("20140512", 78.94));
        listeCommandes.add(new Facture("20140409", 163.23));
        listeCommandes.add(new Facture("20140429", 982.34));
        listeCommandes.add(new Facture("20140508", 172.89));

        //---  L’utilisation de map permet aussi de modifier directement ce que nous allons récupérer! Par exemple,
        List listeCommandeMai = listeCommandes.stream()
                .filter(x -> x.numero.startsWith("201405"))
                .map(x -> x.montant*0.2)
        //la méthode COLLECT (opération terminale) pour récupérer nos éléménts dans une liste.
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        mapStreams1();
        mapStreams2();

    }
}
