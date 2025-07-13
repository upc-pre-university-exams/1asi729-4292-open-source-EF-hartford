package org.hign.platform.u202318274.personnel.application.internal.queryservices;

import org.hign.platform.u202318274.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202318274.personnel.domain.model.queries.GetExaminerByNationalProviderIdentifierQuery;
import org.hign.platform.u202318274.personnel.domain.services.ExaminerQueryService;
import org.hign.platform.u202318274.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExaminerQueryServiceImpl implements ExaminerQueryService {
    private final ExaminerRepository examinerRepository;
    public ExaminerQueryServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }


    @Override
    public Optional<Examiner> handle(GetExaminerByNationalProviderIdentifierQuery query) {
        return examinerRepository.findByNationalProviderIdentifier(query.nationalProviderIdentifier());
    }
}
