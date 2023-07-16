package tn.mdweb.aminoacidopathies.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link tn.mdweb.aminoacidopathies.domain.Fiche} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class FicheDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate datemaj;

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
            ", pathologie=" + getPathologie() +
            "}";
    }
}
