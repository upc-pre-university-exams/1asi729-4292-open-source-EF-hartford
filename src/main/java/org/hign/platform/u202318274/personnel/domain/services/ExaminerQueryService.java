package org.hign.platform.u202318274.personnel.domain.services;

import org.hign.platform.u202318274.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202318274.personnel.domain.model.queries.GetByExaminerIdQuery;
import org.hign.platform.u202318274.personnel.domain.model.queries.GetExaminerByNationalProviderIdQuery;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ExaminerQueryService {
    Optional<Examiner> handle(GetExaminerByNationalProviderIdQuery query);

    Optional<Examiner> handle(GetByExaminerIdQuery query);
}
