package org.hign.platform.u202318274.assessment.application.internal.commandservices;

import org.hign.platform.u202318274.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202318274.assessment.domain.model.commands.CreateMentalStateCommand;
import org.hign.platform.u202318274.assessment.domain.services.MentalStateCommandService;
import org.hign.platform.u202318274.assessment.infrastructure.persistence.jpa.repositories.MentalStateRepository;
import org.hign.platform.u202318274.shared.domain.exceptions.GeneralException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentalStateCommandServiceImpl implements MentalStateCommandService {

    private final MentalStateRepository mentalStateRepository;

    public MentalStateCommandServiceImpl(MentalStateRepository mentalStateRepository) {
        this.mentalStateRepository = mentalStateRepository;
    }

    @Override
    public Optional<MentalStateExam> handle(CreateMentalStateCommand command) {
        // General validations
        if (command.patientId() == null || command.patientId() <= 0)
            throw new GeneralException("Invalid Patient Id", "INVALID_PATIENT_ID");

        if (command.examDate() == null || command.examDate().after(new java.util.Date()))
            throw new GeneralException("Exam Date cannot be null or in the future", "INVALID_EXAM_DATE");

        if (command.orientationScore() == null || command.orientationScore() < 0 || command.orientationScore() > 10)
            throw new GeneralException("Orientation Score must be between 0 and 5", "INVALID_ORIENTATION_SCORE");

        if (command.registrationScore() == null || command.registrationScore() < 0 || command.registrationScore() > 3)
            throw new GeneralException("Registration Score must be between 0 and 5", "INVALID_REGISTRATION_SCORE");

        if (command.attentionAndCalculationScore() == null || command.attentionAndCalculationScore() < 0 || command.attentionAndCalculationScore() > 5)
            throw new GeneralException("Attention and Calculation Score must be between 0 and 5", "INVALID_ATTENTION_CALCULATION_SCORE");

        if (command.recallScore() == null || command.recallScore() < 0 || command.recallScore() > 3)
            throw new GeneralException("Recall Score must be between 0 and 5", "INVALID_RECALL_SCORE");

        if (command.languageScore() == null || command.languageScore() < 0 || command.languageScore() > 9)
            throw new GeneralException("Language Score must be between 0 and 5", "INVALID_LANGUAGE_SCORE");

        // Validate examiner's National Provider Identifier with ACL



        // Create the MentalStateExam entity
        var mentalStateExam = new MentalStateExam(command);
        mentalStateRepository.save(mentalStateExam);
        return Optional.of(mentalStateExam);
    }


}
