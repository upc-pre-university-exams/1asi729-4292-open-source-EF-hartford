package org.hign.platform.u202318274.assessment.domain.model.commands;

import java.util.Date;
import java.util.UUID;

public record CreateMentalExamCommand(
        Long patientId,
        UUID examinerNationalProviderIdentifier,
        Date examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore
) {
}
