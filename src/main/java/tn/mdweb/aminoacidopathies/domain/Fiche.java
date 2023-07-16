package tn.mdweb.aminoacidopathies.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Fiche.
 */
@Entity
@Table(name = "fiche")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Fiche implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "datemaj", nullable = false)
    private LocalDate datemaj;

    @ManyToOne(optional = false)
    @NotNull
    private Pathologie pathologie;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Fiche id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatemaj() {
        return this.datemaj;
    }

    public Fiche datemaj(LocalDate datemaj) {
        this.setDatemaj(datemaj);
        return this;
    }

    public void setDatemaj(LocalDate datemaj) {
        this.datemaj = datemaj;
    }

    public Pathologie getPathologie() {
        return this.pathologie;
    }

    public void setPathologie(Pathologie pathologie) {
        this.pathologie = pathologie;
    }

    public Fiche pathologie(Pathologie pathologie) {
        this.setPathologie(pathologie);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fiche)) {
            return false;
        }
        return id != null && id.equals(((Fiche) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Fiche{" +
            "id=" + getId() +
            ", datemaj='" + getDatemaj() + "'" +
            "}";
    }
}
