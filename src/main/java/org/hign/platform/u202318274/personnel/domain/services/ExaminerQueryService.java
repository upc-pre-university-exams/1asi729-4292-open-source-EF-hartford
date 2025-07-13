package org.hign.platform.u202318274.personnel.domain.services;

import org.hign.platform.u202318274.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202318274.personnel.domain.model.queries.GetExaminerByNationalProviderIdentifierQuery;

import java.util.Optional;

public interface ExaminerQueryService
{
    Optional<Examiner> handle(GetExaminerByNationalProviderIdentifierQuery query);

}
