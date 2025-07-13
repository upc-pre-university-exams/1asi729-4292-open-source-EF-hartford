package org.hign.platform.u202318274.assessment.domain.model.commands;

import java.util.Date;
import java.util.UUID;

public record CreateMentalStateCommand(
        Long patientId,
        Date examDate,
        UUID examinerNationalProviderIdentifier,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore
) {
}
