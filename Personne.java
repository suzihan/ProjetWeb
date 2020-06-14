package models;

import java.util.Date;

import io.ebean.*;
import javax.persistence.*;

import play.data.validation.Constraints.*;

@Entity
public class Personne extends Model{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    protected long id;

    @Required
    private String nom;
    
    @Required
    private String prenom;
    
    private int age;
    
    public Personne(long id, String nom, String prenom,int age){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getPrenom(){
        return prenom;
    }
    
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public void setID(Long id){
        this.id = id;
    }
    
    public Long getID(){
        return this.id;
    }
  
    public static Finder<Long, Personne> find = new Finder<Long,Personne>(Personne.class);
    
}