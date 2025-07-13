package org.hign.platform.u202318274.personnel.application.internal.commandservices;

import org.hign.platform.u202318274.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202318274.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202318274.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202318274.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202318274.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.u202318274.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.hign.platform.u202318274.shared.domain.exceptions.GeneralException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExaminerCommandServiceImpl implements ExaminerCommandService {
    private final ExaminerRepository examinerRepository;

    public ExaminerCommandServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    @Override
    public Optional<Examiner> handle(CreateExaminerCommand command) {
        if (command.firstName() == null || command.firstName().isBlank())
            throw new GeneralException("First name cannot be null or blank", "FIRST_NAME_INVALID");

        if (command.lastName() == null || command.lastName().isBlank())
            throw new GeneralException("Last name cannot be null or blank", "LAST_NAME_INVALID");

        // Validate National Provider Identifier
        NationalProviderIdentifier newNationalProviderIdentifier = new NationalProviderIdentifier();
        if (examinerRepository.existsByNationalProviderIdentifier(newNationalProviderIdentifier)) {
            throw new GeneralException("Generated National Provider Identifier collision. Please try again.", "NPI_COLLISION");
        }

        var examiner = new Examiner(command, newNationalProviderIdentifier);
        examinerRepository.save(examiner);
        return Optional.of(examiner);
    }

    /*
    @Override
    public Long handle(CreateExaminerCommand command) {
        // General Validations
        if (command.firstName() == null || command.firstName().isBlank())
            throw new GeneralException("First name cannot be null or blank", "FIRST_NAME_INVALID");

        if (command.lastName() == null || command.lastName().isBlank())
            throw new GeneralException("Last name cannot be null or blank", "LAST_NAME_INVALID");

        if (command.nationalProviderIdentifier() == null)
            throw new GeneralException("National Provider Identifier cannot be null", "NATIONAL_PROVIDER_IDENTIFIER_INVALID");

        // Check if the examiner already exists
        var existsExaminer = examinerRepository.existsByNationalProviderIdentifier(command.nationalProviderIdentifier());
        if (existsExaminer)
            throw new GeneralException("Examiner with this National Provider Identifier already exists", "EXAMINER_ALREADY_EXISTS");

        // Create Examiner
        var examiner = new Examiner(command);
        examinerRepository.save(examiner);
        return examiner.getId();
    }

*/


}
