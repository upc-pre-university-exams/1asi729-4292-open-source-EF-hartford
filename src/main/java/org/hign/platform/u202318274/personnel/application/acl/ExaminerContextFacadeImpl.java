package org.hign.platform.u202318274.personnel.application.acl;

import org.hign.platform.u202318274.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202318274.personnel.domain.model.queries.GetExaminerByNationalProviderIdQuery;
import org.hign.platform.u202318274.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202318274.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.u202318274.personnel.domain.services.ExaminerQueryService;
import org.hign.platform.u202318274.personnel.interfaces.acl.PersonalsContextFacade;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExaminerContextFacadeImpl implements PersonalsContextFacade {
    private final ExaminerQueryService examinerQueryService;

    public ExaminerContextFacadeImpl(ExaminerQueryService examinerQueryService) {
        this.examinerQueryService = examinerQueryService;
    }

    @Override
    public Long fetchExaminerByNationalProviderIdentifier(UUID nationalProviderIdentifier) {
        var getExaminerByNationalProviderIdentifierQuery = new GetExaminerByNationalProviderIdQuery(new NationalProviderIdentifier(nationalProviderIdentifier));
        var examiner = examinerQueryService.handle(getExaminerByNationalProviderIdentifierQuery);
        return examiner.isEmpty() ? 0L : examiner.get().getId();
    }


}
