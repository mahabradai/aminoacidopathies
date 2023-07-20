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
import tn.mdweb.aminoacidopathies.domain.enumeration.eactivite;
import tn.mdweb.aminoacidopathies.domain.enumeration.ecasfamiliaux;
import tn.mdweb.aminoacidopathies.domain.enumeration.ecirconstance;
import tn.mdweb.aminoacidopathies.domain.enumeration.econsanguinite;
import tn.mdweb.aminoacidopathies.domain.enumeration.ecouverture;
import tn.mdweb.aminoacidopathies.domain.enumeration.edecesbasage;
import tn.mdweb.aminoacidopathies.domain.enumeration.egouvernorat;
import tn.mdweb.aminoacidopathies.domain.enumeration.egouvernoratmere;
import tn.mdweb.aminoacidopathies.domain.enumeration.elieudeces;
import tn.mdweb.aminoacidopathies.domain.enumeration.eniveauscolarisation;
import tn.mdweb.aminoacidopathies.domain.enumeration.escolarisetype;
import tn.mdweb.aminoacidopathies.domain.enumeration.esexe;
import tn.mdweb.aminoacidopathies.domain.enumeration.estatut;
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

    private static final String DEFAULT_TYPE_OBSERVATION = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_OBSERVATION = "BBBBBBBBBB";

    private static final String DEFAULT_IDENTIFIANT_REGISTRE = "AAAAAAAAAA";
    private static final String UPDATED_IDENTIFIANT_REGISTRE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_ENREGISTREMENT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_ENREGISTREMENT = LocalDate.now(ZoneId.systemDefault());

    private static final esexe DEFAULT_SEXE = esexe.M;
    private static final esexe UPDATED_SEXE = esexe.F;

    private static final LocalDate DEFAULT_DATE_NAISSANCE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_NAISSANCE = LocalDate.now(ZoneId.systemDefault());

    private static final estatut DEFAULT_STATUT = estatut.ENCORE_SUIVI;
    private static final estatut UPDATED_STATUT = estatut.DECEDE;

    private static final LocalDate DEFAULT_DATE_DECES = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DECES = LocalDate.now(ZoneId.systemDefault());

    private static final ecirconstance DEFAULT_CIRCONSTANCE_DECES = ecirconstance.TBL_NEURO;
    private static final ecirconstance UPDATED_CIRCONSTANCE_DECES = ecirconstance.TBL_HEMORRAGIQUE;

    private static final String DEFAULT_AUTRE_CIRCONSTANCE_DECES = "AAAAAAAAAA";
    private static final String UPDATED_AUTRE_CIRCONSTANCE_DECES = "BBBBBBBBBB";

    private static final elieudeces DEFAULT_LIEU_DECES = elieudeces.DOMICILE;
    private static final elieudeces UPDATED_LIEU_DECES = elieudeces.STRUCTURE_SANTE_PUBLIQUE_NP;

    private static final econsanguinite DEFAULT_CONSANGUINITE = econsanguinite.OUI;
    private static final econsanguinite UPDATED_CONSANGUINITE = econsanguinite.NON;

    private static final egouvernorat DEFAULT_ORIGINE_GEO_PERE_GOUVERNORAT = egouvernorat.ARIANA;
    private static final egouvernorat UPDATED_ORIGINE_GEO_PERE_GOUVERNORAT = egouvernorat.BEJA;

    private static final egouvernoratmere DEFAULT_ORIGINE_GEO_MERE_GOUVERNORAT = egouvernoratmere.ARIANA;
    private static final egouvernoratmere UPDATED_ORIGINE_GEO_MERE_GOUVERNORAT = egouvernoratmere.BEJA;

    private static final String DEFAULT_ORIGINE_GEO_PERE_DELEGUATION = "AAAAAAAAAA";
    private static final String UPDATED_ORIGINE_GEO_PERE_DELEGUATION = "BBBBBBBBBB";

    private static final String DEFAULT_ORIGINE_GEO_MERE_DELEGUATION = "AAAAAAAAAA";
    private static final String UPDATED_ORIGINE_GEO_MERE_DELEGUATION = "BBBBBBBBBB";

    private static final ecouverture DEFAULT_COUVERTURE_SOCIALE = ecouverture.AUCUNE;
    private static final ecouverture UPDATED_COUVERTURE_SOCIALE = ecouverture.CNAM;

    private static final String DEFAULT_AUTRE_COUVERTURE_SOCIALE = "AAAAAAAAAA";
    private static final String UPDATED_AUTRE_COUVERTURE_SOCIALE = "BBBBBBBBBB";

    private static final eactivite DEFAULT_ACTIVITE = eactivite.NP;
    private static final eactivite UPDATED_ACTIVITE = eactivite.NON;

    private static final Boolean DEFAULT_BTRAVAIL = false;
    private static final Boolean UPDATED_BTRAVAIL = true;

    private static final String DEFAULT_TRAVAIL = "AAAAAAAAAA";
    private static final String UPDATED_TRAVAIL = "BBBBBBBBBB";

    private static final Boolean DEFAULT_SCOLARISE = false;
    private static final Boolean UPDATED_SCOLARISE = true;

    private static final escolarisetype DEFAULT_TYPE_SCOLARISE = escolarisetype.ECOLE_NORMALE;
    private static final escolarisetype UPDATED_TYPE_SCOLARISE = escolarisetype.ECOLE_INTEGRATION;

    private static final eniveauscolarisation DEFAULT_NIVEAU_SCOLARISATION = eniveauscolarisation.PRIMAIRE;
    private static final eniveauscolarisation UPDATED_NIVEAU_SCOLARISATION = eniveauscolarisation.COLLEGE;

    private static final ecasfamiliaux DEFAULT_CAS_FAMILIAUX = ecasfamiliaux.OUI;
    private static final ecasfamiliaux UPDATED_CAS_FAMILIAUX = ecasfamiliaux.NON;

    private static final Integer DEFAULT_NBCASCONFIRME = 1;
    private static final Integer UPDATED_NBCASCONFIRME = 2;

    private static final Integer DEFAULT_NBCASSUSPECTES = 1;
    private static final Integer UPDATED_NBCASSUSPECTES = 2;

    private static final Integer DEFAULT_NBCASDECEDES = 1;
    private static final Integer UPDATED_NBCASDECEDES = 2;

    private static final edecesbasage DEFAULT_DECES_EN_BAS_AGE = edecesbasage.OUI;
    private static final edecesbasage UPDATED_DECES_EN_BAS_AGE = edecesbasage.NON;

    private static final Integer DEFAULT_NBCAS_DECES_AGE_BAS = 1;
    private static final Integer UPDATED_NBCAS_DECES_AGE_BAS = 2;

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
        Fiche fiche = new Fiche()
            .datemaj(DEFAULT_DATEMAJ)
            .type_observation(DEFAULT_TYPE_OBSERVATION)
            .identifiant_registre(DEFAULT_IDENTIFIANT_REGISTRE)
            .date_enregistrement(DEFAULT_DATE_ENREGISTREMENT)
            .sexe(DEFAULT_SEXE)
            .date_naissance(DEFAULT_DATE_NAISSANCE)
            .statut(DEFAULT_STATUT)
            .date_deces(DEFAULT_DATE_DECES)
            .circonstance_deces(DEFAULT_CIRCONSTANCE_DECES)
            .autre_circonstance_deces(DEFAULT_AUTRE_CIRCONSTANCE_DECES)
            .lieu_deces(DEFAULT_LIEU_DECES)
            .consanguinite(DEFAULT_CONSANGUINITE)
            .origine_geo_pere_gouvernorat(DEFAULT_ORIGINE_GEO_PERE_GOUVERNORAT)
            .origine_geo_mere_gouvernorat(DEFAULT_ORIGINE_GEO_MERE_GOUVERNORAT)
            .origine_geo_pere_deleguation(DEFAULT_ORIGINE_GEO_PERE_DELEGUATION)
            .origine_geo_mere_deleguation(DEFAULT_ORIGINE_GEO_MERE_DELEGUATION)
            .couverture_sociale(DEFAULT_COUVERTURE_SOCIALE)
            .autre_couverture_sociale(DEFAULT_AUTRE_COUVERTURE_SOCIALE)
            .activite(DEFAULT_ACTIVITE)
            .btravail(DEFAULT_BTRAVAIL)
            .travail(DEFAULT_TRAVAIL)
            .scolarise(DEFAULT_SCOLARISE)
            .type_scolarise(DEFAULT_TYPE_SCOLARISE)
            .niveau_scolarisation(DEFAULT_NIVEAU_SCOLARISATION)
            .cas_familiaux(DEFAULT_CAS_FAMILIAUX)
            .nbcasconfirme(DEFAULT_NBCASCONFIRME)
            .nbcassuspectes(DEFAULT_NBCASSUSPECTES)
            .nbcasdecedes(DEFAULT_NBCASDECEDES)
            .deces_en_bas_age(DEFAULT_DECES_EN_BAS_AGE)
            .nbcas_deces_age_bas(DEFAULT_NBCAS_DECES_AGE_BAS);
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
        Fiche fiche = new Fiche()
            .datemaj(UPDATED_DATEMAJ)
            .type_observation(UPDATED_TYPE_OBSERVATION)
            .identifiant_registre(UPDATED_IDENTIFIANT_REGISTRE)
            .date_enregistrement(UPDATED_DATE_ENREGISTREMENT)
            .sexe(UPDATED_SEXE)
            .date_naissance(UPDATED_DATE_NAISSANCE)
            .statut(UPDATED_STATUT)
            .date_deces(UPDATED_DATE_DECES)
            .circonstance_deces(UPDATED_CIRCONSTANCE_DECES)
            .autre_circonstance_deces(UPDATED_AUTRE_CIRCONSTANCE_DECES)
            .lieu_deces(UPDATED_LIEU_DECES)
            .consanguinite(UPDATED_CONSANGUINITE)
            .origine_geo_pere_gouvernorat(UPDATED_ORIGINE_GEO_PERE_GOUVERNORAT)
            .origine_geo_mere_gouvernorat(UPDATED_ORIGINE_GEO_MERE_GOUVERNORAT)
            .origine_geo_pere_deleguation(UPDATED_ORIGINE_GEO_PERE_DELEGUATION)
            .origine_geo_mere_deleguation(UPDATED_ORIGINE_GEO_MERE_DELEGUATION)
            .couverture_sociale(UPDATED_COUVERTURE_SOCIALE)
            .autre_couverture_sociale(UPDATED_AUTRE_COUVERTURE_SOCIALE)
            .activite(UPDATED_ACTIVITE)
            .btravail(UPDATED_BTRAVAIL)
            .travail(UPDATED_TRAVAIL)
            .scolarise(UPDATED_SCOLARISE)
            .type_scolarise(UPDATED_TYPE_SCOLARISE)
            .niveau_scolarisation(UPDATED_NIVEAU_SCOLARISATION)
            .cas_familiaux(UPDATED_CAS_FAMILIAUX)
            .nbcasconfirme(UPDATED_NBCASCONFIRME)
            .nbcassuspectes(UPDATED_NBCASSUSPECTES)
            .nbcasdecedes(UPDATED_NBCASDECEDES)
            .deces_en_bas_age(UPDATED_DECES_EN_BAS_AGE)
            .nbcas_deces_age_bas(UPDATED_NBCAS_DECES_AGE_BAS);
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
        assertThat(testFiche.getType_observation()).isEqualTo(DEFAULT_TYPE_OBSERVATION);
        assertThat(testFiche.getIdentifiant_registre()).isEqualTo(DEFAULT_IDENTIFIANT_REGISTRE);
        assertThat(testFiche.getDate_enregistrement()).isEqualTo(DEFAULT_DATE_ENREGISTREMENT);
        assertThat(testFiche.getSexe()).isEqualTo(DEFAULT_SEXE);
        assertThat(testFiche.getDate_naissance()).isEqualTo(DEFAULT_DATE_NAISSANCE);
        assertThat(testFiche.getStatut()).isEqualTo(DEFAULT_STATUT);
        assertThat(testFiche.getDate_deces()).isEqualTo(DEFAULT_DATE_DECES);
        assertThat(testFiche.getCirconstance_deces()).isEqualTo(DEFAULT_CIRCONSTANCE_DECES);
        assertThat(testFiche.getAutre_circonstance_deces()).isEqualTo(DEFAULT_AUTRE_CIRCONSTANCE_DECES);
        assertThat(testFiche.getLieu_deces()).isEqualTo(DEFAULT_LIEU_DECES);
        assertThat(testFiche.getConsanguinite()).isEqualTo(DEFAULT_CONSANGUINITE);
        assertThat(testFiche.getOrigine_geo_pere_gouvernorat()).isEqualTo(DEFAULT_ORIGINE_GEO_PERE_GOUVERNORAT);
        assertThat(testFiche.getOrigine_geo_mere_gouvernorat()).isEqualTo(DEFAULT_ORIGINE_GEO_MERE_GOUVERNORAT);
        assertThat(testFiche.getOrigine_geo_pere_deleguation()).isEqualTo(DEFAULT_ORIGINE_GEO_PERE_DELEGUATION);
        assertThat(testFiche.getOrigine_geo_mere_deleguation()).isEqualTo(DEFAULT_ORIGINE_GEO_MERE_DELEGUATION);
        assertThat(testFiche.getCouverture_sociale()).isEqualTo(DEFAULT_COUVERTURE_SOCIALE);
        assertThat(testFiche.getAutre_couverture_sociale()).isEqualTo(DEFAULT_AUTRE_COUVERTURE_SOCIALE);
        assertThat(testFiche.getActivite()).isEqualTo(DEFAULT_ACTIVITE);
        assertThat(testFiche.getBtravail()).isEqualTo(DEFAULT_BTRAVAIL);
        assertThat(testFiche.getTravail()).isEqualTo(DEFAULT_TRAVAIL);
        assertThat(testFiche.getScolarise()).isEqualTo(DEFAULT_SCOLARISE);
        assertThat(testFiche.getType_scolarise()).isEqualTo(DEFAULT_TYPE_SCOLARISE);
        assertThat(testFiche.getNiveau_scolarisation()).isEqualTo(DEFAULT_NIVEAU_SCOLARISATION);
        assertThat(testFiche.getCas_familiaux()).isEqualTo(DEFAULT_CAS_FAMILIAUX);
        assertThat(testFiche.getNbcasconfirme()).isEqualTo(DEFAULT_NBCASCONFIRME);
        assertThat(testFiche.getNbcassuspectes()).isEqualTo(DEFAULT_NBCASSUSPECTES);
        assertThat(testFiche.getNbcasdecedes()).isEqualTo(DEFAULT_NBCASDECEDES);
        assertThat(testFiche.getDeces_en_bas_age()).isEqualTo(DEFAULT_DECES_EN_BAS_AGE);
        assertThat(testFiche.getNbcas_deces_age_bas()).isEqualTo(DEFAULT_NBCAS_DECES_AGE_BAS);
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
            .andExpect(jsonPath("$.[*].datemaj").value(hasItem(DEFAULT_DATEMAJ.toString())))
            .andExpect(jsonPath("$.[*].type_observation").value(hasItem(DEFAULT_TYPE_OBSERVATION)))
            .andExpect(jsonPath("$.[*].identifiant_registre").value(hasItem(DEFAULT_IDENTIFIANT_REGISTRE)))
            .andExpect(jsonPath("$.[*].date_enregistrement").value(hasItem(DEFAULT_DATE_ENREGISTREMENT.toString())))
            .andExpect(jsonPath("$.[*].sexe").value(hasItem(DEFAULT_SEXE.toString())))
            .andExpect(jsonPath("$.[*].date_naissance").value(hasItem(DEFAULT_DATE_NAISSANCE.toString())))
            .andExpect(jsonPath("$.[*].statut").value(hasItem(DEFAULT_STATUT.toString())))
            .andExpect(jsonPath("$.[*].date_deces").value(hasItem(DEFAULT_DATE_DECES.toString())))
            .andExpect(jsonPath("$.[*].circonstance_deces").value(hasItem(DEFAULT_CIRCONSTANCE_DECES.toString())))
            .andExpect(jsonPath("$.[*].autre_circonstance_deces").value(hasItem(DEFAULT_AUTRE_CIRCONSTANCE_DECES)))
            .andExpect(jsonPath("$.[*].lieu_deces").value(hasItem(DEFAULT_LIEU_DECES.toString())))
            .andExpect(jsonPath("$.[*].consanguinite").value(hasItem(DEFAULT_CONSANGUINITE.toString())))
            .andExpect(jsonPath("$.[*].origine_geo_pere_gouvernorat").value(hasItem(DEFAULT_ORIGINE_GEO_PERE_GOUVERNORAT.toString())))
            .andExpect(jsonPath("$.[*].origine_geo_mere_gouvernorat").value(hasItem(DEFAULT_ORIGINE_GEO_MERE_GOUVERNORAT.toString())))
            .andExpect(jsonPath("$.[*].origine_geo_pere_deleguation").value(hasItem(DEFAULT_ORIGINE_GEO_PERE_DELEGUATION)))
            .andExpect(jsonPath("$.[*].origine_geo_mere_deleguation").value(hasItem(DEFAULT_ORIGINE_GEO_MERE_DELEGUATION)))
            .andExpect(jsonPath("$.[*].couverture_sociale").value(hasItem(DEFAULT_COUVERTURE_SOCIALE.toString())))
            .andExpect(jsonPath("$.[*].autre_couverture_sociale").value(hasItem(DEFAULT_AUTRE_COUVERTURE_SOCIALE)))
            .andExpect(jsonPath("$.[*].activite").value(hasItem(DEFAULT_ACTIVITE.toString())))
            .andExpect(jsonPath("$.[*].btravail").value(hasItem(DEFAULT_BTRAVAIL.booleanValue())))
            .andExpect(jsonPath("$.[*].travail").value(hasItem(DEFAULT_TRAVAIL)))
            .andExpect(jsonPath("$.[*].scolarise").value(hasItem(DEFAULT_SCOLARISE.booleanValue())))
            .andExpect(jsonPath("$.[*].type_scolarise").value(hasItem(DEFAULT_TYPE_SCOLARISE.toString())))
            .andExpect(jsonPath("$.[*].niveau_scolarisation").value(hasItem(DEFAULT_NIVEAU_SCOLARISATION.toString())))
            .andExpect(jsonPath("$.[*].cas_familiaux").value(hasItem(DEFAULT_CAS_FAMILIAUX.toString())))
            .andExpect(jsonPath("$.[*].nbcasconfirme").value(hasItem(DEFAULT_NBCASCONFIRME)))
            .andExpect(jsonPath("$.[*].nbcassuspectes").value(hasItem(DEFAULT_NBCASSUSPECTES)))
            .andExpect(jsonPath("$.[*].nbcasdecedes").value(hasItem(DEFAULT_NBCASDECEDES)))
            .andExpect(jsonPath("$.[*].deces_en_bas_age").value(hasItem(DEFAULT_DECES_EN_BAS_AGE.toString())))
            .andExpect(jsonPath("$.[*].nbcas_deces_age_bas").value(hasItem(DEFAULT_NBCAS_DECES_AGE_BAS)));
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
            .andExpect(jsonPath("$.datemaj").value(DEFAULT_DATEMAJ.toString()))
            .andExpect(jsonPath("$.type_observation").value(DEFAULT_TYPE_OBSERVATION))
            .andExpect(jsonPath("$.identifiant_registre").value(DEFAULT_IDENTIFIANT_REGISTRE))
            .andExpect(jsonPath("$.date_enregistrement").value(DEFAULT_DATE_ENREGISTREMENT.toString()))
            .andExpect(jsonPath("$.sexe").value(DEFAULT_SEXE.toString()))
            .andExpect(jsonPath("$.date_naissance").value(DEFAULT_DATE_NAISSANCE.toString()))
            .andExpect(jsonPath("$.statut").value(DEFAULT_STATUT.toString()))
            .andExpect(jsonPath("$.date_deces").value(DEFAULT_DATE_DECES.toString()))
            .andExpect(jsonPath("$.circonstance_deces").value(DEFAULT_CIRCONSTANCE_DECES.toString()))
            .andExpect(jsonPath("$.autre_circonstance_deces").value(DEFAULT_AUTRE_CIRCONSTANCE_DECES))
            .andExpect(jsonPath("$.lieu_deces").value(DEFAULT_LIEU_DECES.toString()))
            .andExpect(jsonPath("$.consanguinite").value(DEFAULT_CONSANGUINITE.toString()))
            .andExpect(jsonPath("$.origine_geo_pere_gouvernorat").value(DEFAULT_ORIGINE_GEO_PERE_GOUVERNORAT.toString()))
            .andExpect(jsonPath("$.origine_geo_mere_gouvernorat").value(DEFAULT_ORIGINE_GEO_MERE_GOUVERNORAT.toString()))
            .andExpect(jsonPath("$.origine_geo_pere_deleguation").value(DEFAULT_ORIGINE_GEO_PERE_DELEGUATION))
            .andExpect(jsonPath("$.origine_geo_mere_deleguation").value(DEFAULT_ORIGINE_GEO_MERE_DELEGUATION))
            .andExpect(jsonPath("$.couverture_sociale").value(DEFAULT_COUVERTURE_SOCIALE.toString()))
            .andExpect(jsonPath("$.autre_couverture_sociale").value(DEFAULT_AUTRE_COUVERTURE_SOCIALE))
            .andExpect(jsonPath("$.activite").value(DEFAULT_ACTIVITE.toString()))
            .andExpect(jsonPath("$.btravail").value(DEFAULT_BTRAVAIL.booleanValue()))
            .andExpect(jsonPath("$.travail").value(DEFAULT_TRAVAIL))
            .andExpect(jsonPath("$.scolarise").value(DEFAULT_SCOLARISE.booleanValue()))
            .andExpect(jsonPath("$.type_scolarise").value(DEFAULT_TYPE_SCOLARISE.toString()))
            .andExpect(jsonPath("$.niveau_scolarisation").value(DEFAULT_NIVEAU_SCOLARISATION.toString()))
            .andExpect(jsonPath("$.cas_familiaux").value(DEFAULT_CAS_FAMILIAUX.toString()))
            .andExpect(jsonPath("$.nbcasconfirme").value(DEFAULT_NBCASCONFIRME))
            .andExpect(jsonPath("$.nbcassuspectes").value(DEFAULT_NBCASSUSPECTES))
            .andExpect(jsonPath("$.nbcasdecedes").value(DEFAULT_NBCASDECEDES))
            .andExpect(jsonPath("$.deces_en_bas_age").value(DEFAULT_DECES_EN_BAS_AGE.toString()))
            .andExpect(jsonPath("$.nbcas_deces_age_bas").value(DEFAULT_NBCAS_DECES_AGE_BAS));
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
        updatedFiche
            .datemaj(UPDATED_DATEMAJ)
            .type_observation(UPDATED_TYPE_OBSERVATION)
            .identifiant_registre(UPDATED_IDENTIFIANT_REGISTRE)
            .date_enregistrement(UPDATED_DATE_ENREGISTREMENT)
            .sexe(UPDATED_SEXE)
            .date_naissance(UPDATED_DATE_NAISSANCE)
            .statut(UPDATED_STATUT)
            .date_deces(UPDATED_DATE_DECES)
            .circonstance_deces(UPDATED_CIRCONSTANCE_DECES)
            .autre_circonstance_deces(UPDATED_AUTRE_CIRCONSTANCE_DECES)
            .lieu_deces(UPDATED_LIEU_DECES)
            .consanguinite(UPDATED_CONSANGUINITE)
            .origine_geo_pere_gouvernorat(UPDATED_ORIGINE_GEO_PERE_GOUVERNORAT)
            .origine_geo_mere_gouvernorat(UPDATED_ORIGINE_GEO_MERE_GOUVERNORAT)
            .origine_geo_pere_deleguation(UPDATED_ORIGINE_GEO_PERE_DELEGUATION)
            .origine_geo_mere_deleguation(UPDATED_ORIGINE_GEO_MERE_DELEGUATION)
            .couverture_sociale(UPDATED_COUVERTURE_SOCIALE)
            .autre_couverture_sociale(UPDATED_AUTRE_COUVERTURE_SOCIALE)
            .activite(UPDATED_ACTIVITE)
            .btravail(UPDATED_BTRAVAIL)
            .travail(UPDATED_TRAVAIL)
            .scolarise(UPDATED_SCOLARISE)
            .type_scolarise(UPDATED_TYPE_SCOLARISE)
            .niveau_scolarisation(UPDATED_NIVEAU_SCOLARISATION)
            .cas_familiaux(UPDATED_CAS_FAMILIAUX)
            .nbcasconfirme(UPDATED_NBCASCONFIRME)
            .nbcassuspectes(UPDATED_NBCASSUSPECTES)
            .nbcasdecedes(UPDATED_NBCASDECEDES)
            .deces_en_bas_age(UPDATED_DECES_EN_BAS_AGE)
            .nbcas_deces_age_bas(UPDATED_NBCAS_DECES_AGE_BAS);
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
        assertThat(testFiche.getType_observation()).isEqualTo(UPDATED_TYPE_OBSERVATION);
        assertThat(testFiche.getIdentifiant_registre()).isEqualTo(UPDATED_IDENTIFIANT_REGISTRE);
        assertThat(testFiche.getDate_enregistrement()).isEqualTo(UPDATED_DATE_ENREGISTREMENT);
        assertThat(testFiche.getSexe()).isEqualTo(UPDATED_SEXE);
        assertThat(testFiche.getDate_naissance()).isEqualTo(UPDATED_DATE_NAISSANCE);
        assertThat(testFiche.getStatut()).isEqualTo(UPDATED_STATUT);
        assertThat(testFiche.getDate_deces()).isEqualTo(UPDATED_DATE_DECES);
        assertThat(testFiche.getCirconstance_deces()).isEqualTo(UPDATED_CIRCONSTANCE_DECES);
        assertThat(testFiche.getAutre_circonstance_deces()).isEqualTo(UPDATED_AUTRE_CIRCONSTANCE_DECES);
        assertThat(testFiche.getLieu_deces()).isEqualTo(UPDATED_LIEU_DECES);
        assertThat(testFiche.getConsanguinite()).isEqualTo(UPDATED_CONSANGUINITE);
        assertThat(testFiche.getOrigine_geo_pere_gouvernorat()).isEqualTo(UPDATED_ORIGINE_GEO_PERE_GOUVERNORAT);
        assertThat(testFiche.getOrigine_geo_mere_gouvernorat()).isEqualTo(UPDATED_ORIGINE_GEO_MERE_GOUVERNORAT);
        assertThat(testFiche.getOrigine_geo_pere_deleguation()).isEqualTo(UPDATED_ORIGINE_GEO_PERE_DELEGUATION);
        assertThat(testFiche.getOrigine_geo_mere_deleguation()).isEqualTo(UPDATED_ORIGINE_GEO_MERE_DELEGUATION);
        assertThat(testFiche.getCouverture_sociale()).isEqualTo(UPDATED_COUVERTURE_SOCIALE);
        assertThat(testFiche.getAutre_couverture_sociale()).isEqualTo(UPDATED_AUTRE_COUVERTURE_SOCIALE);
        assertThat(testFiche.getActivite()).isEqualTo(UPDATED_ACTIVITE);
        assertThat(testFiche.getBtravail()).isEqualTo(UPDATED_BTRAVAIL);
        assertThat(testFiche.getTravail()).isEqualTo(UPDATED_TRAVAIL);
        assertThat(testFiche.getScolarise()).isEqualTo(UPDATED_SCOLARISE);
        assertThat(testFiche.getType_scolarise()).isEqualTo(UPDATED_TYPE_SCOLARISE);
        assertThat(testFiche.getNiveau_scolarisation()).isEqualTo(UPDATED_NIVEAU_SCOLARISATION);
        assertThat(testFiche.getCas_familiaux()).isEqualTo(UPDATED_CAS_FAMILIAUX);
        assertThat(testFiche.getNbcasconfirme()).isEqualTo(UPDATED_NBCASCONFIRME);
        assertThat(testFiche.getNbcassuspectes()).isEqualTo(UPDATED_NBCASSUSPECTES);
        assertThat(testFiche.getNbcasdecedes()).isEqualTo(UPDATED_NBCASDECEDES);
        assertThat(testFiche.getDeces_en_bas_age()).isEqualTo(UPDATED_DECES_EN_BAS_AGE);
        assertThat(testFiche.getNbcas_deces_age_bas()).isEqualTo(UPDATED_NBCAS_DECES_AGE_BAS);
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

        partialUpdatedFiche
            .identifiant_registre(UPDATED_IDENTIFIANT_REGISTRE)
            .date_enregistrement(UPDATED_DATE_ENREGISTREMENT)
            .sexe(UPDATED_SEXE)
            .date_naissance(UPDATED_DATE_NAISSANCE)
            .statut(UPDATED_STATUT)
            .circonstance_deces(UPDATED_CIRCONSTANCE_DECES)
            .autre_circonstance_deces(UPDATED_AUTRE_CIRCONSTANCE_DECES)
            .consanguinite(UPDATED_CONSANGUINITE)
            .origine_geo_pere_gouvernorat(UPDATED_ORIGINE_GEO_PERE_GOUVERNORAT)
            .origine_geo_mere_gouvernorat(UPDATED_ORIGINE_GEO_MERE_GOUVERNORAT)
            .btravail(UPDATED_BTRAVAIL)
            .travail(UPDATED_TRAVAIL)
            .type_scolarise(UPDATED_TYPE_SCOLARISE)
            .niveau_scolarisation(UPDATED_NIVEAU_SCOLARISATION)
            .cas_familiaux(UPDATED_CAS_FAMILIAUX)
            .nbcassuspectes(UPDATED_NBCASSUSPECTES)
            .nbcasdecedes(UPDATED_NBCASDECEDES);

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
        assertThat(testFiche.getType_observation()).isEqualTo(DEFAULT_TYPE_OBSERVATION);
        assertThat(testFiche.getIdentifiant_registre()).isEqualTo(UPDATED_IDENTIFIANT_REGISTRE);
        assertThat(testFiche.getDate_enregistrement()).isEqualTo(UPDATED_DATE_ENREGISTREMENT);
        assertThat(testFiche.getSexe()).isEqualTo(UPDATED_SEXE);
        assertThat(testFiche.getDate_naissance()).isEqualTo(UPDATED_DATE_NAISSANCE);
        assertThat(testFiche.getStatut()).isEqualTo(UPDATED_STATUT);
        assertThat(testFiche.getDate_deces()).isEqualTo(DEFAULT_DATE_DECES);
        assertThat(testFiche.getCirconstance_deces()).isEqualTo(UPDATED_CIRCONSTANCE_DECES);
        assertThat(testFiche.getAutre_circonstance_deces()).isEqualTo(UPDATED_AUTRE_CIRCONSTANCE_DECES);
        assertThat(testFiche.getLieu_deces()).isEqualTo(DEFAULT_LIEU_DECES);
        assertThat(testFiche.getConsanguinite()).isEqualTo(UPDATED_CONSANGUINITE);
        assertThat(testFiche.getOrigine_geo_pere_gouvernorat()).isEqualTo(UPDATED_ORIGINE_GEO_PERE_GOUVERNORAT);
        assertThat(testFiche.getOrigine_geo_mere_gouvernorat()).isEqualTo(UPDATED_ORIGINE_GEO_MERE_GOUVERNORAT);
        assertThat(testFiche.getOrigine_geo_pere_deleguation()).isEqualTo(DEFAULT_ORIGINE_GEO_PERE_DELEGUATION);
        assertThat(testFiche.getOrigine_geo_mere_deleguation()).isEqualTo(DEFAULT_ORIGINE_GEO_MERE_DELEGUATION);
        assertThat(testFiche.getCouverture_sociale()).isEqualTo(DEFAULT_COUVERTURE_SOCIALE);
        assertThat(testFiche.getAutre_couverture_sociale()).isEqualTo(DEFAULT_AUTRE_COUVERTURE_SOCIALE);
        assertThat(testFiche.getActivite()).isEqualTo(DEFAULT_ACTIVITE);
        assertThat(testFiche.getBtravail()).isEqualTo(UPDATED_BTRAVAIL);
        assertThat(testFiche.getTravail()).isEqualTo(UPDATED_TRAVAIL);
        assertThat(testFiche.getScolarise()).isEqualTo(DEFAULT_SCOLARISE);
        assertThat(testFiche.getType_scolarise()).isEqualTo(UPDATED_TYPE_SCOLARISE);
        assertThat(testFiche.getNiveau_scolarisation()).isEqualTo(UPDATED_NIVEAU_SCOLARISATION);
        assertThat(testFiche.getCas_familiaux()).isEqualTo(UPDATED_CAS_FAMILIAUX);
        assertThat(testFiche.getNbcasconfirme()).isEqualTo(DEFAULT_NBCASCONFIRME);
        assertThat(testFiche.getNbcassuspectes()).isEqualTo(UPDATED_NBCASSUSPECTES);
        assertThat(testFiche.getNbcasdecedes()).isEqualTo(UPDATED_NBCASDECEDES);
        assertThat(testFiche.getDeces_en_bas_age()).isEqualTo(DEFAULT_DECES_EN_BAS_AGE);
        assertThat(testFiche.getNbcas_deces_age_bas()).isEqualTo(DEFAULT_NBCAS_DECES_AGE_BAS);
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

        partialUpdatedFiche
            .datemaj(UPDATED_DATEMAJ)
            .type_observation(UPDATED_TYPE_OBSERVATION)
            .identifiant_registre(UPDATED_IDENTIFIANT_REGISTRE)
            .date_enregistrement(UPDATED_DATE_ENREGISTREMENT)
            .sexe(UPDATED_SEXE)
            .date_naissance(UPDATED_DATE_NAISSANCE)
            .statut(UPDATED_STATUT)
            .date_deces(UPDATED_DATE_DECES)
            .circonstance_deces(UPDATED_CIRCONSTANCE_DECES)
            .autre_circonstance_deces(UPDATED_AUTRE_CIRCONSTANCE_DECES)
            .lieu_deces(UPDATED_LIEU_DECES)
            .consanguinite(UPDATED_CONSANGUINITE)
            .origine_geo_pere_gouvernorat(UPDATED_ORIGINE_GEO_PERE_GOUVERNORAT)
            .origine_geo_mere_gouvernorat(UPDATED_ORIGINE_GEO_MERE_GOUVERNORAT)
            .origine_geo_pere_deleguation(UPDATED_ORIGINE_GEO_PERE_DELEGUATION)
            .origine_geo_mere_deleguation(UPDATED_ORIGINE_GEO_MERE_DELEGUATION)
            .couverture_sociale(UPDATED_COUVERTURE_SOCIALE)
            .autre_couverture_sociale(UPDATED_AUTRE_COUVERTURE_SOCIALE)
            .activite(UPDATED_ACTIVITE)
            .btravail(UPDATED_BTRAVAIL)
            .travail(UPDATED_TRAVAIL)
            .scolarise(UPDATED_SCOLARISE)
            .type_scolarise(UPDATED_TYPE_SCOLARISE)
            .niveau_scolarisation(UPDATED_NIVEAU_SCOLARISATION)
            .cas_familiaux(UPDATED_CAS_FAMILIAUX)
            .nbcasconfirme(UPDATED_NBCASCONFIRME)
            .nbcassuspectes(UPDATED_NBCASSUSPECTES)
            .nbcasdecedes(UPDATED_NBCASDECEDES)
            .deces_en_bas_age(UPDATED_DECES_EN_BAS_AGE)
            .nbcas_deces_age_bas(UPDATED_NBCAS_DECES_AGE_BAS);

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
        assertThat(testFiche.getType_observation()).isEqualTo(UPDATED_TYPE_OBSERVATION);
        assertThat(testFiche.getIdentifiant_registre()).isEqualTo(UPDATED_IDENTIFIANT_REGISTRE);
        assertThat(testFiche.getDate_enregistrement()).isEqualTo(UPDATED_DATE_ENREGISTREMENT);
        assertThat(testFiche.getSexe()).isEqualTo(UPDATED_SEXE);
        assertThat(testFiche.getDate_naissance()).isEqualTo(UPDATED_DATE_NAISSANCE);
        assertThat(testFiche.getStatut()).isEqualTo(UPDATED_STATUT);
        assertThat(testFiche.getDate_deces()).isEqualTo(UPDATED_DATE_DECES);
        assertThat(testFiche.getCirconstance_deces()).isEqualTo(UPDATED_CIRCONSTANCE_DECES);
        assertThat(testFiche.getAutre_circonstance_deces()).isEqualTo(UPDATED_AUTRE_CIRCONSTANCE_DECES);
        assertThat(testFiche.getLieu_deces()).isEqualTo(UPDATED_LIEU_DECES);
        assertThat(testFiche.getConsanguinite()).isEqualTo(UPDATED_CONSANGUINITE);
        assertThat(testFiche.getOrigine_geo_pere_gouvernorat()).isEqualTo(UPDATED_ORIGINE_GEO_PERE_GOUVERNORAT);
        assertThat(testFiche.getOrigine_geo_mere_gouvernorat()).isEqualTo(UPDATED_ORIGINE_GEO_MERE_GOUVERNORAT);
        assertThat(testFiche.getOrigine_geo_pere_deleguation()).isEqualTo(UPDATED_ORIGINE_GEO_PERE_DELEGUATION);
        assertThat(testFiche.getOrigine_geo_mere_deleguation()).isEqualTo(UPDATED_ORIGINE_GEO_MERE_DELEGUATION);
        assertThat(testFiche.getCouverture_sociale()).isEqualTo(UPDATED_COUVERTURE_SOCIALE);
        assertThat(testFiche.getAutre_couverture_sociale()).isEqualTo(UPDATED_AUTRE_COUVERTURE_SOCIALE);
        assertThat(testFiche.getActivite()).isEqualTo(UPDATED_ACTIVITE);
        assertThat(testFiche.getBtravail()).isEqualTo(UPDATED_BTRAVAIL);
        assertThat(testFiche.getTravail()).isEqualTo(UPDATED_TRAVAIL);
        assertThat(testFiche.getScolarise()).isEqualTo(UPDATED_SCOLARISE);
        assertThat(testFiche.getType_scolarise()).isEqualTo(UPDATED_TYPE_SCOLARISE);
        assertThat(testFiche.getNiveau_scolarisation()).isEqualTo(UPDATED_NIVEAU_SCOLARISATION);
        assertThat(testFiche.getCas_familiaux()).isEqualTo(UPDATED_CAS_FAMILIAUX);
        assertThat(testFiche.getNbcasconfirme()).isEqualTo(UPDATED_NBCASCONFIRME);
        assertThat(testFiche.getNbcassuspectes()).isEqualTo(UPDATED_NBCASSUSPECTES);
        assertThat(testFiche.getNbcasdecedes()).isEqualTo(UPDATED_NBCASDECEDES);
        assertThat(testFiche.getDeces_en_bas_age()).isEqualTo(UPDATED_DECES_EN_BAS_AGE);
        assertThat(testFiche.getNbcas_deces_age_bas()).isEqualTo(UPDATED_NBCAS_DECES_AGE_BAS);
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
