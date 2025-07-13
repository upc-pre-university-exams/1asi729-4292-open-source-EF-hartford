package org.hign.platform.u202318274.assessment.application.internal.queryservices;

import org.hign.platform.u202318274.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202318274.assessment.domain.model.queries.GetMentalStateExamByExaminerNationalProviderIdentifierQuery;
import org.hign.platform.u202318274.assessment.domain.services.MentalStateQueryService;
import org.hign.platform.u202318274.assessment.infrastructure.persistence.jpa.repositories.MentalStateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentalStateQueryServiceImpl implements MentalStateQueryService {

    private final MentalStateRepository mentalStateRepository;

    public MentalStateQueryServiceImpl(MentalStateRepository mentalStateRepository) {
        this.mentalStateRepository = mentalStateRepository;
    }

    @Override
    public Optional<MentalStateExam> handle(GetMentalStateExamByExaminerNationalProviderIdentifierQuery query) {
        return mentalStateRepository.findByExaminerNationalProviderIdentifier(query.examinerNationalProviderIdentifier());
    }
}
