package org.hign.platform.u202318274.assessment.domain.model.commands;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.UUID;

public record CreateMentalStateCommand(
        Long patientId,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        Date examDate,
        UUID examinerNationalProviderIdentifier,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore
) {
}
