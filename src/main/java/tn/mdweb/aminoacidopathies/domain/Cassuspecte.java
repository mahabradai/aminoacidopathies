package tn.mdweb.aminoacidopathies.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import tn.mdweb.aminoacidopathies.domain.enumeration.elienparente;

/**
 * A Cassuspecte.
 */
@Entity
@Table(name = "cassuspecte")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cassuspecte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "lienparente")
    private elienparente lienparente;

    @Column(name = "lienparenteautre")
    private String lienparenteautre;

    @Column(name = "signes_neurologiques")
    private Boolean signes_neurologiques;

    @Column(name = "troubles_de_la_conscience")
    private Boolean troubles_de_la_conscience;

    @Column(name = "retard_psychomoteur")
    private Boolean retard_psychomoteur;

    @Column(name = "retard_mental")
    private Boolean retard_mental;

    @Column(name = "signes_du_spectre_autistique")
    private Boolean signes_du_spectre_autistique;

    @Column(name = "epilepsie")
    private Boolean epilepsie;

    @Column(name = "crise_pseudoporphyrique")
    private Boolean crise_pseudoporphyrique;

    @Column(name = "autres_signes_neurologiques")
    private String autres_signes_neurologiques;

    @Column(name = "signes_hepatiques")
    private Boolean signes_hepatiques;

    @Column(name = "ictere")
    private Boolean ictere;

    @Column(name = "ballonnement")
    private Boolean ballonnement;

    @Column(name = "syndrome_hemorragique")
    private Boolean syndrome_hemorragique;

    @Column(name = "autres_signes_hepatiques")
    private String autres_signes_hepatiques;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Cassuspecte id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public elienparente getLienparente() {
        return this.lienparente;
    }

    public Cassuspecte lienparente(elienparente lienparente) {
        this.setLienparente(lienparente);
        return this;
    }

    public void setLienparente(elienparente lienparente) {
        this.lienparente = lienparente;
    }

    public String getLienparenteautre() {
        return this.lienparenteautre;
    }

    public Cassuspecte lienparenteautre(String lienparenteautre) {
        this.setLienparenteautre(lienparenteautre);
        return this;
    }

    public void setLienparenteautre(String lienparenteautre) {
        this.lienparenteautre = lienparenteautre;
    }

    public Boolean getSignes_neurologiques() {
        return this.signes_neurologiques;
    }

    public Cassuspecte signes_neurologiques(Boolean signes_neurologiques) {
        this.setSignes_neurologiques(signes_neurologiques);
        return this;
    }

    public void setSignes_neurologiques(Boolean signes_neurologiques) {
        this.signes_neurologiques = signes_neurologiques;
    }

    public Boolean getTroubles_de_la_conscience() {
        return this.troubles_de_la_conscience;
    }

    public Cassuspecte troubles_de_la_conscience(Boolean troubles_de_la_conscience) {
        this.setTroubles_de_la_conscience(troubles_de_la_conscience);
        return this;
    }

    public void setTroubles_de_la_conscience(Boolean troubles_de_la_conscience) {
        this.troubles_de_la_conscience = troubles_de_la_conscience;
    }

    public Boolean getRetard_psychomoteur() {
        return this.retard_psychomoteur;
    }

    public Cassuspecte retard_psychomoteur(Boolean retard_psychomoteur) {
        this.setRetard_psychomoteur(retard_psychomoteur);
        return this;
    }

    public void setRetard_psychomoteur(Boolean retard_psychomoteur) {
        this.retard_psychomoteur = retard_psychomoteur;
    }

    public Boolean getRetard_mental() {
        return this.retard_mental;
    }

    public Cassuspecte retard_mental(Boolean retard_mental) {
        this.setRetard_mental(retard_mental);
        return this;
    }

    public void setRetard_mental(Boolean retard_mental) {
        this.retard_mental = retard_mental;
    }

    public Boolean getSignes_du_spectre_autistique() {
        return this.signes_du_spectre_autistique;
    }

    public Cassuspecte signes_du_spectre_autistique(Boolean signes_du_spectre_autistique) {
        this.setSignes_du_spectre_autistique(signes_du_spectre_autistique);
        return this;
    }

    public void setSignes_du_spectre_autistique(Boolean signes_du_spectre_autistique) {
        this.signes_du_spectre_autistique = signes_du_spectre_autistique;
    }

    public Boolean getEpilepsie() {
        return this.epilepsie;
    }

    public Cassuspecte epilepsie(Boolean epilepsie) {
        this.setEpilepsie(epilepsie);
        return this;
    }

    public void setEpilepsie(Boolean epilepsie) {
        this.epilepsie = epilepsie;
    }

    public Boolean getCrise_pseudoporphyrique() {
        return this.crise_pseudoporphyrique;
    }

    public Cassuspecte crise_pseudoporphyrique(Boolean crise_pseudoporphyrique) {
        this.setCrise_pseudoporphyrique(crise_pseudoporphyrique);
        return this;
    }

    public void setCrise_pseudoporphyrique(Boolean crise_pseudoporphyrique) {
        this.crise_pseudoporphyrique = crise_pseudoporphyrique;
    }

    public String getAutres_signes_neurologiques() {
        return this.autres_signes_neurologiques;
    }

    public Cassuspecte autres_signes_neurologiques(String autres_signes_neurologiques) {
        this.setAutres_signes_neurologiques(autres_signes_neurologiques);
        return this;
    }

    public void setAutres_signes_neurologiques(String autres_signes_neurologiques) {
        this.autres_signes_neurologiques = autres_signes_neurologiques;
    }

    public Boolean getSignes_hepatiques() {
        return this.signes_hepatiques;
    }

    public Cassuspecte signes_hepatiques(Boolean signes_hepatiques) {
        this.setSignes_hepatiques(signes_hepatiques);
        return this;
    }

    public void setSignes_hepatiques(Boolean signes_hepatiques) {
        this.signes_hepatiques = signes_hepatiques;
    }

    public Boolean getIctere() {
        return this.ictere;
    }

    public Cassuspecte ictere(Boolean ictere) {
        this.setIctere(ictere);
        return this;
    }

    public void setIctere(Boolean ictere) {
        this.ictere = ictere;
    }

    public Boolean getBallonnement() {
        return this.ballonnement;
    }

    public Cassuspecte ballonnement(Boolean ballonnement) {
        this.setBallonnement(ballonnement);
        return this;
    }

    public void setBallonnement(Boolean ballonnement) {
        this.ballonnement = ballonnement;
    }

    public Boolean getSyndrome_hemorragique() {
        return this.syndrome_hemorragique;
    }

    public Cassuspecte syndrome_hemorragique(Boolean syndrome_hemorragique) {
        this.setSyndrome_hemorragique(syndrome_hemorragique);
        return this;
    }

    public void setSyndrome_hemorragique(Boolean syndrome_hemorragique) {
        this.syndrome_hemorragique = syndrome_hemorragique;
    }

    public String getAutres_signes_hepatiques() {
        return this.autres_signes_hepatiques;
    }

    public Cassuspecte autres_signes_hepatiques(String autres_signes_hepatiques) {
        this.setAutres_signes_hepatiques(autres_signes_hepatiques);
        return this;
    }

    public void setAutres_signes_hepatiques(String autres_signes_hepatiques) {
        this.autres_signes_hepatiques = autres_signes_hepatiques;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cassuspecte)) {
            return false;
        }
        return id != null && id.equals(((Cassuspecte) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cassuspecte{" +
            "id=" + getId() +
            ", lienparente='" + getLienparente() + "'" +
            ", lienparenteautre='" + getLienparenteautre() + "'" +
            ", signes_neurologiques='" + getSignes_neurologiques() + "'" +
            ", troubles_de_la_conscience='" + getTroubles_de_la_conscience() + "'" +
            ", retard_psychomoteur='" + getRetard_psychomoteur() + "'" +
            ", retard_mental='" + getRetard_mental() + "'" +
            ", signes_du_spectre_autistique='" + getSignes_du_spectre_autistique() + "'" +
            ", epilepsie='" + getEpilepsie() + "'" +
            ", crise_pseudoporphyrique='" + getCrise_pseudoporphyrique() + "'" +
            ", autres_signes_neurologiques='" + getAutres_signes_neurologiques() + "'" +
            ", signes_hepatiques='" + getSignes_hepatiques() + "'" +
            ", ictere='" + getIctere() + "'" +
            ", ballonnement='" + getBallonnement() + "'" +
            ", syndrome_hemorragique='" + getSyndrome_hemorragique() + "'" +
            ", autres_signes_hepatiques='" + getAutres_signes_hepatiques() + "'" +
            "}";
    }
}
