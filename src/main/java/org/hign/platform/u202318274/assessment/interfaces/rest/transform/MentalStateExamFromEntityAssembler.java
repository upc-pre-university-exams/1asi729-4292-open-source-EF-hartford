package org.hign.platform.u202318274.assessment.interfaces.rest.transform;

import org.hign.platform.u202318274.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202318274.assessment.interfaces.rest.resources.MentalStateExamResource;
import org.hign.platform.u202318274.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202318274.personnel.interfaces.rest.resources.ExaminerResource;

public class MentalStateExamFromEntityAssembler {
    public static MentalStateExamResource toResourceFromEntity(MentalStateExam entity) {
        return new MentalStateExamResource(
                entity.getId(),
                entity.getPatientId(),
                entity.getExaminerNationalProviderIdentifier().value(),
                entity.getExamDate(),
                entity.getOrientationScore(),
                entity.getRegistrationScore(),
                entity.getAttentionAndCalculationScore(),
                entity.getRecallScore(),
                entity.getLanguageScore()
        );
    }
}
