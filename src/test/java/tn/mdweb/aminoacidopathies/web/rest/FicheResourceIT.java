package tn.mdweb.aminoacidopathies.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import tn.mdweb.aminoacidopathies.IntegrationTest;
import tn.mdweb.aminoacidopathies.domain.Fiche;
import tn.mdweb.aminoacidopathies.domain.Pathologie;
import tn.mdweb.aminoacidopathies.repository.FicheRepository;
import tn.mdweb.aminoacidopathies.service.dto.FicheDTO;
import tn.mdweb.aminoacidopathies.service.mapper.FicheMapper;

/**
 * Integration tests for the {@link FicheResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class FicheResourceIT {

    private static final LocalDate DEFAULT_DATEMAJ = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATEMAJ = LocalDate.now(ZoneId.systemDefault());

    private static final String ENTITY_API_URL = "/api/fiches";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private FicheRepository ficheRepository;

    @Autowired
    private FicheMapper ficheMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFicheMockMvc;

    private Fiche fiche;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Fiche createEntity(EntityManager em) {
        Fiche fiche = new Fiche().datemaj(DEFAULT_DATEMAJ);
        // Add required entity
        Pathologie pathologie;
        if (TestUtil.findAll(em, Pathologie.class).isEmpty()) {
            pathologie = PathologieResourceIT.createEntity(em);
            em.persist(pathologie);
            em.flush();
        } else {
            pathologie = TestUtil.findAll(em, Pathologie.class).get(0);
        }
        fiche.setPathologie(pathologie);
        return fiche;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Fiche createUpdatedEntity(EntityManager em) {
        Fiche fiche = new Fiche().datemaj(UPDATED_DATEMAJ);
        // Add required entity
        Pathologie pathologie;
        if (TestUtil.findAll(em, Pathologie.class).isEmpty()) {
            pathologie = PathologieResourceIT.createUpdatedEntity(em);
            em.persist(pathologie);
            em.flush();
        } else {
            pathologie = TestUtil.findAll(em, Pathologie.class).get(0);
        }
        fiche.setPathologie(pathologie);
        return fiche;
    }

    @BeforeEach
    public void initTest() {
        fiche = createEntity(em);
    }

    @Test
    @Transactional
    void createFiche() throws Exception {
        int databaseSizeBeforeCreate = ficheRepository.findAll().size();
        // Create the Fiche
        FicheDTO ficheDTO = ficheMapper.toDto(fiche);
        restFicheMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ficheDTO)))
            .andExpect(status().isCreated());

        // Validate the Fiche in the database
        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeCreate + 1);
        Fiche testFiche = ficheList.get(ficheList.size() - 1);
        assertThat(testFiche.getDatemaj()).isEqualTo(DEFAULT_DATEMAJ);
    }

    @Test
    @Transactional
    void createFicheWithExistingId() throws Exception {
        // Create the Fiche with an existing ID
        fiche.setId(1L);
        FicheDTO ficheDTO = ficheMapper.toDto(fiche);

        int databaseSizeBeforeCreate = ficheRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restFicheMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ficheDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Fiche in the database
        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkDatemajIsRequired() throws Exception {
        int databaseSizeBeforeTest = ficheRepository.findAll().size();
        // set the field null
        fiche.setDatemaj(null);

        // Create the Fiche, which fails.
        FicheDTO ficheDTO = ficheMapper.toDto(fiche);

        restFicheMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ficheDTO)))
            .andExpect(status().isBadRequest());

        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllFiches() throws Exception {
        // Initialize the database
        ficheRepository.saveAndFlush(fiche);

        // Get all the ficheList
        restFicheMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(fiche.getId().intValue())))
            .andExpect(jsonPath("$.[*].datemaj").value(hasItem(DEFAULT_DATEMAJ.toString())));
    }

    @Test
    @Transactional
    void getFiche() throws Exception {
        // Initialize the database
        ficheRepository.saveAndFlush(fiche);

        // Get the fiche
        restFicheMockMvc
            .perform(get(ENTITY_API_URL_ID, fiche.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(fiche.getId().intValue()))
            .andExpect(jsonPath("$.datemaj").value(DEFAULT_DATEMAJ.toString()));
    }

    @Test
    @Transactional
    void getNonExistingFiche() throws Exception {
        // Get the fiche
        restFicheMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingFiche() throws Exception {
        // Initialize the database
        ficheRepository.saveAndFlush(fiche);

        int databaseSizeBeforeUpdate = ficheRepository.findAll().size();

        // Update the fiche
        Fiche updatedFiche = ficheRepository.findById(fiche.getId()).get();
        // Disconnect from session so that the updates on updatedFiche are not directly saved in db
        em.detach(updatedFiche);
        updatedFiche.datemaj(UPDATED_DATEMAJ);
        FicheDTO ficheDTO = ficheMapper.toDto(updatedFiche);

        restFicheMockMvc
            .perform(
                put(ENTITY_API_URL_ID, ficheDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(ficheDTO))
            )
            .andExpect(status().isOk());

        // Validate the Fiche in the database
        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeUpdate);
        Fiche testFiche = ficheList.get(ficheList.size() - 1);
        assertThat(testFiche.getDatemaj()).isEqualTo(UPDATED_DATEMAJ);
    }

    @Test
    @Transactional
    void putNonExistingFiche() throws Exception {
        int databaseSizeBeforeUpdate = ficheRepository.findAll().size();
        fiche.setId(count.incrementAndGet());

        // Create the Fiche
        FicheDTO ficheDTO = ficheMapper.toDto(fiche);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFicheMockMvc
            .perform(
                put(ENTITY_API_URL_ID, ficheDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(ficheDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Fiche in the database
        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchFiche() throws Exception {
        int databaseSizeBeforeUpdate = ficheRepository.findAll().size();
        fiche.setId(count.incrementAndGet());

        // Create the Fiche
        FicheDTO ficheDTO = ficheMapper.toDto(fiche);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFicheMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(ficheDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Fiche in the database
        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamFiche() throws Exception {
        int databaseSizeBeforeUpdate = ficheRepository.findAll().size();
        fiche.setId(count.incrementAndGet());

        // Create the Fiche
        FicheDTO ficheDTO = ficheMapper.toDto(fiche);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFicheMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(ficheDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Fiche in the database
        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateFicheWithPatch() throws Exception {
        // Initialize the database
        ficheRepository.saveAndFlush(fiche);

        int databaseSizeBeforeUpdate = ficheRepository.findAll().size();

        // Update the fiche using partial update
        Fiche partialUpdatedFiche = new Fiche();
        partialUpdatedFiche.setId(fiche.getId());

        restFicheMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedFiche.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedFiche))
            )
            .andExpect(status().isOk());

        // Validate the Fiche in the database
        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeUpdate);
        Fiche testFiche = ficheList.get(ficheList.size() - 1);
        assertThat(testFiche.getDatemaj()).isEqualTo(DEFAULT_DATEMAJ);
    }

    @Test
    @Transactional
    void fullUpdateFicheWithPatch() throws Exception {
        // Initialize the database
        ficheRepository.saveAndFlush(fiche);

        int databaseSizeBeforeUpdate = ficheRepository.findAll().size();

        // Update the fiche using partial update
        Fiche partialUpdatedFiche = new Fiche();
        partialUpdatedFiche.setId(fiche.getId());

        partialUpdatedFiche.datemaj(UPDATED_DATEMAJ);

        restFicheMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedFiche.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedFiche))
            )
            .andExpect(status().isOk());

        // Validate the Fiche in the database
        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeUpdate);
        Fiche testFiche = ficheList.get(ficheList.size() - 1);
        assertThat(testFiche.getDatemaj()).isEqualTo(UPDATED_DATEMAJ);
    }

    @Test
    @Transactional
    void patchNonExistingFiche() throws Exception {
        int databaseSizeBeforeUpdate = ficheRepository.findAll().size();
        fiche.setId(count.incrementAndGet());

        // Create the Fiche
        FicheDTO ficheDTO = ficheMapper.toDto(fiche);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFicheMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, ficheDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(ficheDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Fiche in the database
        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchFiche() throws Exception {
        int databaseSizeBeforeUpdate = ficheRepository.findAll().size();
        fiche.setId(count.incrementAndGet());

        // Create the Fiche
        FicheDTO ficheDTO = ficheMapper.toDto(fiche);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFicheMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(ficheDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Fiche in the database
        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamFiche() throws Exception {
        int databaseSizeBeforeUpdate = ficheRepository.findAll().size();
        fiche.setId(count.incrementAndGet());

        // Create the Fiche
        FicheDTO ficheDTO = ficheMapper.toDto(fiche);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFicheMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(ficheDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Fiche in the database
        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteFiche() throws Exception {
        // Initialize the database
        ficheRepository.saveAndFlush(fiche);

        int databaseSizeBeforeDelete = ficheRepository.findAll().size();

        // Delete the fiche
        restFicheMockMvc
            .perform(delete(ENTITY_API_URL_ID, fiche.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Fiche> ficheList = ficheRepository.findAll();
        assertThat(ficheList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
