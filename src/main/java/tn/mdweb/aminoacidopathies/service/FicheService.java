package tn.mdweb.aminoacidopathies.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.mdweb.aminoacidopathies.domain.Fiche;
import tn.mdweb.aminoacidopathies.repository.FicheRepository;
import tn.mdweb.aminoacidopathies.service.dto.FicheDTO;
import tn.mdweb.aminoacidopathies.service.mapper.FicheMapper;

/**
 * Service Implementation for managing {@link Fiche}.
 */
@Service
@Transactional
public class FicheService {

    private final Logger log = LoggerFactory.getLogger(FicheService.class);

    private final FicheRepository ficheRepository;

    private final FicheMapper ficheMapper;

    public FicheService(FicheRepository ficheRepository, FicheMapper ficheMapper) {
        this.ficheRepository = ficheRepository;
        this.ficheMapper = ficheMapper;
    }

    /**
     * Save a fiche.
     *
     * @param ficheDTO the entity to save.
     * @return the persisted entity.
     */
    public FicheDTO save(FicheDTO ficheDTO) {
        log.debug("Request to save Fiche : {}", ficheDTO);
        Fiche fiche = ficheMapper.toEntity(ficheDTO);
        fiche = ficheRepository.save(fiche);
        return ficheMapper.toDto(fiche);
    }

    /**
     * Update a fiche.
     *
     * @param ficheDTO the entity to save.
     * @return the persisted entity.
     */
    public FicheDTO update(FicheDTO ficheDTO) {
        log.debug("Request to update Fiche : {}", ficheDTO);
        Fiche fiche = ficheMapper.toEntity(ficheDTO);
        fiche = ficheRepository.save(fiche);
        return ficheMapper.toDto(fiche);
    }

    /**
     * Partially update a fiche.
     *
     * @param ficheDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<FicheDTO> partialUpdate(FicheDTO ficheDTO) {
        log.debug("Request to partially update Fiche : {}", ficheDTO);

        return ficheRepository
            .findById(ficheDTO.getId())
            .map(existingFiche -> {
                ficheMapper.partialUpdate(existingFiche, ficheDTO);

                return existingFiche;
            })
            .map(ficheRepository::save)
            .map(ficheMapper::toDto);
    }

    /**
     * Get all the fiches.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<FicheDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Fiches");
        return ficheRepository.findAll(pageable).map(ficheMapper::toDto);
    }

    /**
     * Get one fiche by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<FicheDTO> findOne(Long id) {
        log.debug("Request to get Fiche : {}", id);
        return ficheRepository.findById(id).map(ficheMapper::toDto);
    }

    /**
     * Delete the fiche by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Fiche : {}", id);
        ficheRepository.deleteById(id);
    }
}
