/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetjava.Model.Gestion;

/**
 *
 * @author admin
 */
import java.util.*;
import java.lang.String;
import java.util.stream.Collectors;

public final class Directeur extends Salarie {
     Set<String> subordonnes;// directeurs adjoints ou les superviseurs de département
     double prime;
     List<Employe> employes;
     String mdp;// Liste des employés sous la direction du directeur

    public Directeur(String nom,String prenom, String id, String adresseEmail, String numeroTelephone,double age,double prime,String mdp) {
        super(nom,prenom,id,adresseEmail,numeroTelephone,age);
        this.subordonnes = new HashSet<>();
        this.prime = prime;
        this.employes = new ArrayList<>();
        this.mdp=mdp;
    }
    

   
    public Set<String> getSubordonnes() {
        return subordonnes;
    }

    public void setSubordonnes(Set<String> subordonnes) {
        this.subordonnes = subordonnes;
    }

    public double getPrime() {
        return prime;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
    public String get_mdp(){
        return mdp;
    }
    public void set_mdp(String mdp){
        this.mdp=mdp;
    }

    public static List<Chef> filtrerEmployesParAgeRetraite(int ageRetraite,List<Chef> listes) {
        return listes.stream()
                .filter(e -> e.getAge() > ageRetraite)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return super.toString() + "subordonnes=" + subordonnes + ", prime=" + prime + ", employes=" + employes + ", mdp=" + mdp + '}';
    }
    
}

