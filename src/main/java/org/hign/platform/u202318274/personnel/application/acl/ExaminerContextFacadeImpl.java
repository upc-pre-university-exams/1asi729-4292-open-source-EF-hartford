package org.hign.platform.u202318274.personnel.application.acl;

import org.hign.platform.u202318274.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202318274.personnel.domain.model.queries.GetExaminerByNationalProviderIdentifierQuery;
import org.hign.platform.u202318274.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.u202318274.personnel.domain.services.ExaminerQueryService;
import org.hign.platform.u202318274.personnel.interfaces.acl.PersonalsContextFacade;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExaminerContextFacadeImpl implements PersonalsContextFacade {
    private final ExaminerCommandService examinerCommandService;
    private final ExaminerQueryService examinerQueryService;

    public ExaminerContextFacadeImpl(ExaminerCommandService examinerCommandService, ExaminerQueryService examinerQueryService) {
        this.examinerCommandService = examinerCommandService;
        this.examinerQueryService = examinerQueryService;
    }

    @Override
    public Long createExaminer(String firstName, String lastName, UUID nationalProviderIdentifier) {
        var createExaminerCommand = new CreateExaminerCommand(
                firstName,
                lastName,
                nationalProviderIdentifier
        );

        var examiner = examinerCommandService.handle(createExaminerCommand);
        return examiner.isEmpty() ? Long.valueOf(0L) : examiner.get().getId();
    }

    @Override
    public Long fetchExaminerByNationalProviderIdentifier(UUID nationalProviderIdentifier) {
        var getExaminerByNationalProviderIdentifierQuery = new GetExaminerByNationalProviderIdentifierQuery(nationalProviderIdentifier);
        var examiner = examinerQueryService.handle(getExaminerByNationalProviderIdentifierQuery);
        return examiner.isEmpty() ? Long.valueOf(0L) : examiner.get().getId();
    }
}
