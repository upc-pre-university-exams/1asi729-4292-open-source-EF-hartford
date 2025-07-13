package org.hign.platform.u202318274.assessment.domain.services;

import org.hign.platform.u202318274.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202318274.assessment.domain.model.queries.GetMentalStateExamByExaminerNationalProviderIdentifierQuery;

import java.util.Optional;

public interface MentalStateQueryService {

    Optional<MentalStateExam> handle(GetMentalStateExamByExaminerNationalProviderIdentifierQuery query);
}
