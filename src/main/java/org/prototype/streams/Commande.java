package org.prototype.streams;

/**
 * Created by kmenzli on 2/9/17.
 */
public class Commande {
    String numero;
    double montant;
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public Commande(String numero, double montant) {
        super();
        this.numero = numero;
        this.montant = montant;
    }
}
