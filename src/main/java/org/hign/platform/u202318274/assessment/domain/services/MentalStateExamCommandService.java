package org.hign.platform.u202318274.assessment.domain.services;

import org.hign.platform.u202318274.assessment.domain.model.commands.CreateMentalExamCommand;

public interface MentalStateExamCommandService {

    Long handle(CreateMentalExamCommand command);
}
