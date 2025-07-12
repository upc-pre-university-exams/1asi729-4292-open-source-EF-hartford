package org.hign.platform.u202318274.personnel.domain.services;

import org.hign.platform.u202318274.personnel.domain.model.commands.CreateExaminerCommand;

public interface ExaminerCommandService {
    Long handle(CreateExaminerCommand command);
}
