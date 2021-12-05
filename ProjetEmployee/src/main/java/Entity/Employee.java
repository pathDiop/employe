package Entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="employee")
public class Employee  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name= "nom",nullable = false)
    private String Nom;
    private String preNom;
    private String courriel;
    private  int age;
    private String fonction;
    private String telephone;

    @Column(name ="adresse_postale")
    private int adressePostal;

    public Employee() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPreNom() {
        return preNom;
    }

    public void setPreNom(String preNom) {
        this.preNom = preNom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAdressePostal() {
        return adressePostal;
    }

    public void setAdressePostal(int adressePostal) {
        this.adressePostal = adressePostal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", preNom='" + preNom + '\'' +
                ", courriel='" + courriel + '\'' +
                ", age=" + age +
                ", fonction='" + fonction + '\'' +
                ", telephone='" + telephone + '\'' +
                ", adressePostal='" + adressePostal + '\'' +
                '}';
    }
}
