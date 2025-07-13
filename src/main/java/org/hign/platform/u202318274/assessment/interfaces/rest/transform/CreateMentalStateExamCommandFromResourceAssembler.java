package org.hign.platform.u202318274.assessment.interfaces.rest.transform;

import org.hign.platform.u202318274.assessment.domain.model.commands.CreateMentalStateCommand;
import org.hign.platform.u202318274.assessment.interfaces.rest.resources.CreateMentalStateExamResource;
import org.hign.platform.u202318274.shared.domain.exceptions.GeneralException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateMentalStateExamCommandFromResourceAssembler {
    public static CreateMentalStateCommand toCommandFromResource(CreateMentalStateExamResource resource) {
        return new CreateMentalStateCommand(
                resource.patientId(),
                resource.examDate(),
                resource.examinerNationalProviderId(),
                resource.orientationScore(),
                resource.registrationScore(),
                resource.attentionAndCalculationScore(),
                resource.recallScore(),
                resource.languageScore()
        );
    }
}
