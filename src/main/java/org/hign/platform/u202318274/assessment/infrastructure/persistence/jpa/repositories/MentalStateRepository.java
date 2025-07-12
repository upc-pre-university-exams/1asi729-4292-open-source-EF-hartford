package org.hign.platform.u202318274.assessment.infrastructure.persistence.jpa.repositories;

import org.hign.platform.u202318274.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202318274.personnel.domain.model.aggregates.Examiner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MentalStateRepository extends JpaRepository<MentalStateExam,Long> {
    Optional<MentalStateExam> findByNationalProviderIdentifier(UUID nationalProviderRecordId);

    boolean existsByNationalProviderIdentifier(UUID providerRecordId);
}
