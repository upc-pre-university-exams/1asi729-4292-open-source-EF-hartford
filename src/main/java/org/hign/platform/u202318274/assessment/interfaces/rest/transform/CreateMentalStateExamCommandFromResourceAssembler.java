package org.hign.platform.u202318274.assessment.interfaces.rest.transform;

import org.hign.platform.u202318274.assessment.domain.model.commands.CreateMentalStateCommand;
import org.hign.platform.u202318274.assessment.interfaces.rest.resources.CreateMentalStateExamResource;
import org.hign.platform.u202318274.shared.domain.exceptions.GeneralException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateMentalStateExamCommandFromResourceAssembler {
    public static CreateMentalStateCommand toCommandFromResource(CreateMentalStateExamResource resource) {
        Date parsedDate;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            parsedDate = sdf.parse(resource.examDate());
        } catch (ParseException e) {
            throw new GeneralException("Invalid date format. Expected yyyy-MM-dd", "INVALID_DATE_FORMAT");
        }

        return new CreateMentalStateCommand(
                resource.patientId(),
                parsedDate,
                resource.examinerNationalProviderId(),
                resource.orientationScore(),
                resource.registrationScore(),
                resource.attentionAndCalculationScore(),
                resource.recallScore(),
                resource.languageScore()
        );
    }
}
