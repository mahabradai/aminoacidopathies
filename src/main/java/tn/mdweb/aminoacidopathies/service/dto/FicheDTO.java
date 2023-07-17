package tn.mdweb.aminoacidopathies.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.*;
import tn.mdweb.aminoacidopathies.domain.enumeration.eactivite;
import tn.mdweb.aminoacidopathies.domain.enumeration.ecasfamiliaux;
import tn.mdweb.aminoacidopathies.domain.enumeration.ecirconstance;
import tn.mdweb.aminoacidopathies.domain.enumeration.econsanguinite;
import tn.mdweb.aminoacidopathies.domain.enumeration.ecouverture;
import tn.mdweb.aminoacidopathies.domain.enumeration.egouvernorat;
import tn.mdweb.aminoacidopathies.domain.enumeration.egouvernoratmere;
import tn.mdweb.aminoacidopathies.domain.enumeration.elieudeces;
import tn.mdweb.aminoacidopathies.domain.enumeration.eniveauscolarisation;
import tn.mdweb.aminoacidopathies.domain.enumeration.escolarisetype;
import tn.mdweb.aminoacidopathies.domain.enumeration.esexe;
import tn.mdweb.aminoacidopathies.domain.enumeration.estatut;

/**
 * A DTO for the {@link tn.mdweb.aminoacidopathies.domain.Fiche} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class FicheDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate datemaj;

    private String type_observation;

    private String identifiant_registre;

    private LocalDate date_enregistrement;

    private esexe sexe;

    private LocalDate date_naissance;

    private estatut statut;

    private LocalDate date_deces;

    private ecirconstance circonstance_deces;

    private String autre_circonstance_deces;

    private elieudeces lieu_deces;

    private econsanguinite consanguinite;

    private egouvernorat origine_geo_pere_gouvernorat;

    private egouvernoratmere origine_geo_mere_gouvernorat;

    private String origine_geo_pere_deleguation;

    private String origine_geo_mere_deleguation;

    private ecouverture couverture_sociale;

    private String autre_couverture_sociale;

    private eactivite activite;

    private Boolean btravail;

    private String travail;

    private Boolean scolarise;

    private escolarisetype type_scolarise;

    private eniveauscolarisation niveau_scolarisation;

    private ecasfamiliaux cas_familiaux;

    private Integer nbcasconfirme;

    private Integer nbcassuspectes;

    private Integer nbcasdecedes;

    private PathologieDTO pathologie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatemaj() {
        return datemaj;
    }

    public void setDatemaj(LocalDate datemaj) {
        this.datemaj = datemaj;
    }

    public String getType_observation() {
        return type_observation;
    }

    public void setType_observation(String type_observation) {
        this.type_observation = type_observation;
    }

    public String getIdentifiant_registre() {
        return identifiant_registre;
    }

    public void setIdentifiant_registre(String identifiant_registre) {
        this.identifiant_registre = identifiant_registre;
    }

    public LocalDate getDate_enregistrement() {
        return date_enregistrement;
    }

    public void setDate_enregistrement(LocalDate date_enregistrement) {
        this.date_enregistrement = date_enregistrement;
    }

    public esexe getSexe() {
        return sexe;
    }

    public void setSexe(esexe sexe) {
        this.sexe = sexe;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    public estatut getStatut() {
        return statut;
    }

    public void setStatut(estatut statut) {
        this.statut = statut;
    }

    public LocalDate getDate_deces() {
        return date_deces;
    }

    public void setDate_deces(LocalDate date_deces) {
        this.date_deces = date_deces;
    }

    public ecirconstance getCirconstance_deces() {
        return circonstance_deces;
    }

    public void setCirconstance_deces(ecirconstance circonstance_deces) {
        this.circonstance_deces = circonstance_deces;
    }

    public String getAutre_circonstance_deces() {
        return autre_circonstance_deces;
    }

    public void setAutre_circonstance_deces(String autre_circonstance_deces) {
        this.autre_circonstance_deces = autre_circonstance_deces;
    }

    public elieudeces getLieu_deces() {
        return lieu_deces;
    }

    public void setLieu_deces(elieudeces lieu_deces) {
        this.lieu_deces = lieu_deces;
    }

    public econsanguinite getConsanguinite() {
        return consanguinite;
    }

    public void setConsanguinite(econsanguinite consanguinite) {
        this.consanguinite = consanguinite;
    }

    public egouvernorat getOrigine_geo_pere_gouvernorat() {
        return origine_geo_pere_gouvernorat;
    }

    public void setOrigine_geo_pere_gouvernorat(egouvernorat origine_geo_pere_gouvernorat) {
        this.origine_geo_pere_gouvernorat = origine_geo_pere_gouvernorat;
    }

    public egouvernoratmere getOrigine_geo_mere_gouvernorat() {
        return origine_geo_mere_gouvernorat;
    }

    public void setOrigine_geo_mere_gouvernorat(egouvernoratmere origine_geo_mere_gouvernorat) {
        this.origine_geo_mere_gouvernorat = origine_geo_mere_gouvernorat;
    }

    public String getOrigine_geo_pere_deleguation() {
        return origine_geo_pere_deleguation;
    }

    public void setOrigine_geo_pere_deleguation(String origine_geo_pere_deleguation) {
        this.origine_geo_pere_deleguation = origine_geo_pere_deleguation;
    }

    public String getOrigine_geo_mere_deleguation() {
        return origine_geo_mere_deleguation;
    }

    public void setOrigine_geo_mere_deleguation(String origine_geo_mere_deleguation) {
        this.origine_geo_mere_deleguation = origine_geo_mere_deleguation;
    }

    public ecouverture getCouverture_sociale() {
        return couverture_sociale;
    }

    public void setCouverture_sociale(ecouverture couverture_sociale) {
        this.couverture_sociale = couverture_sociale;
    }

    public String getAutre_couverture_sociale() {
        return autre_couverture_sociale;
    }

    public void setAutre_couverture_sociale(String autre_couverture_sociale) {
        this.autre_couverture_sociale = autre_couverture_sociale;
    }

    public eactivite getActivite() {
        return activite;
    }

    public void setActivite(eactivite activite) {
        this.activite = activite;
    }

    public Boolean getBtravail() {
        return btravail;
    }

    public void setBtravail(Boolean btravail) {
        this.btravail = btravail;
    }

    public String getTravail() {
        return travail;
    }

    public void setTravail(String travail) {
        this.travail = travail;
    }

    public Boolean getScolarise() {
        return scolarise;
    }

    public void setScolarise(Boolean scolarise) {
        this.scolarise = scolarise;
    }

    public escolarisetype getType_scolarise() {
        return type_scolarise;
    }

    public void setType_scolarise(escolarisetype type_scolarise) {
        this.type_scolarise = type_scolarise;
    }

    public eniveauscolarisation getNiveau_scolarisation() {
        return niveau_scolarisation;
    }

    public void setNiveau_scolarisation(eniveauscolarisation niveau_scolarisation) {
        this.niveau_scolarisation = niveau_scolarisation;
    }

    public ecasfamiliaux getCas_familiaux() {
        return cas_familiaux;
    }

    public void setCas_familiaux(ecasfamiliaux cas_familiaux) {
        this.cas_familiaux = cas_familiaux;
    }

    public Integer getNbcasconfirme() {
        return nbcasconfirme;
    }

    public void setNbcasconfirme(Integer nbcasconfirme) {
        this.nbcasconfirme = nbcasconfirme;
    }

    public Integer getNbcassuspectes() {
        return nbcassuspectes;
    }

    public void setNbcassuspectes(Integer nbcassuspectes) {
        this.nbcassuspectes = nbcassuspectes;
    }

    public Integer getNbcasdecedes() {
        return nbcasdecedes;
    }

    public void setNbcasdecedes(Integer nbcasdecedes) {
        this.nbcasdecedes = nbcasdecedes;
    }

    public PathologieDTO getPathologie() {
        return pathologie;
    }

    public void setPathologie(PathologieDTO pathologie) {
        this.pathologie = pathologie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FicheDTO)) {
            return false;
        }

        FicheDTO ficheDTO = (FicheDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, ficheDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FicheDTO{" +
            "id=" + getId() +
            ", datemaj='" + getDatemaj() + "'" +
            ", type_observation='" + getType_observation() + "'" +
            ", identifiant_registre='" + getIdentifiant_registre() + "'" +
            ", date_enregistrement='" + getDate_enregistrement() + "'" +
            ", sexe='" + getSexe() + "'" +
            ", date_naissance='" + getDate_naissance() + "'" +
            ", statut='" + getStatut() + "'" +
            ", date_deces='" + getDate_deces() + "'" +
            ", circonstance_deces='" + getCirconstance_deces() + "'" +
            ", autre_circonstance_deces='" + getAutre_circonstance_deces() + "'" +
            ", lieu_deces='" + getLieu_deces() + "'" +
            ", consanguinite='" + getConsanguinite() + "'" +
            ", origine_geo_pere_gouvernorat='" + getOrigine_geo_pere_gouvernorat() + "'" +
            ", origine_geo_mere_gouvernorat='" + getOrigine_geo_mere_gouvernorat() + "'" +
            ", origine_geo_pere_deleguation='" + getOrigine_geo_pere_deleguation() + "'" +
            ", origine_geo_mere_deleguation='" + getOrigine_geo_mere_deleguation() + "'" +
            ", couverture_sociale='" + getCouverture_sociale() + "'" +
            ", autre_couverture_sociale='" + getAutre_couverture_sociale() + "'" +
            ", activite='" + getActivite() + "'" +
            ", btravail='" + getBtravail() + "'" +
            ", travail='" + getTravail() + "'" +
            ", scolarise='" + getScolarise() + "'" +
            ", type_scolarise='" + getType_scolarise() + "'" +
            ", niveau_scolarisation='" + getNiveau_scolarisation() + "'" +
            ", cas_familiaux='" + getCas_familiaux() + "'" +
            ", nbcasconfirme=" + getNbcasconfirme() +
            ", nbcassuspectes=" + getNbcassuspectes() +
            ", nbcasdecedes=" + getNbcasdecedes() +
            ", pathologie=" + getPathologie() +
            "}";
    }
}
