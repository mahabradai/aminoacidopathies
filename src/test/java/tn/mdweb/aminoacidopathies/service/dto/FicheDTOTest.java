package tn.mdweb.aminoacidopathies.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tn.mdweb.aminoacidopathies.web.rest.TestUtil;

class FicheDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FicheDTO.class);
        FicheDTO ficheDTO1 = new FicheDTO();
        ficheDTO1.setId(1L);
        FicheDTO ficheDTO2 = new FicheDTO();
        assertThat(ficheDTO1).isNotEqualTo(ficheDTO2);
        ficheDTO2.setId(ficheDTO1.getId());
        assertThat(ficheDTO1).isEqualTo(ficheDTO2);
        ficheDTO2.setId(2L);
        assertThat(ficheDTO1).isNotEqualTo(ficheDTO2);
        ficheDTO1.setId(null);
        assertThat(ficheDTO1).isNotEqualTo(ficheDTO2);
    }
}
