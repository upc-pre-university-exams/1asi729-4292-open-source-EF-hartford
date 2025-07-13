package org.hign.platform.u202318274.assessment.domain.services;

import org.hign.platform.u202318274.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202318274.assessment.domain.model.commands.CreateMentalStateCommand;

import java.util.Optional;

public interface MentalStateCommandService {

    Optional<MentalStateExam> handle(CreateMentalStateCommand command);
}
