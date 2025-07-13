package org.hign.platform.u202318274.personnel.infrastructure.persistence.jpa.repositories;

import org.hign.platform.u202318274.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202318274.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExaminerRepository extends JpaRepository<Examiner, Long> {

    Optional<Examiner> findByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);

    boolean existsByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);

}
