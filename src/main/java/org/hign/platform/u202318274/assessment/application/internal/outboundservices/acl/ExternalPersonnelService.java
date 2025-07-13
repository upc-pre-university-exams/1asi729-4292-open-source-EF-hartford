package org.hign.platform.u202318274.assessment.application.internal.outboundservices.acl;

import org.hign.platform.u202318274.assessment.domain.model.valueobjects.ExaminerNationalProviderIdentifier;
import org.hign.platform.u202318274.personnel.interfaces.acl.PersonalsContextFacade;

import java.util.Optional;
import java.util.UUID;

public class ExternalPersonnelService {
    private final PersonalsContextFacade personalsContextFacade;

    public ExternalPersonnelService(PersonalsContextFacade personalsContextFacade) {
        this.personalsContextFacade = personalsContextFacade;
    }

    // Mnemothechnic: Choose the foreign key
    public Optional<ExaminerNationalProviderIdentifier> fetchExaminerByNationalProviderIdentifier(UUID examinerNationalProviderId) {
        var examinerId = personalsContextFacade.fetchExaminerByNationalProviderIdentifier(examinerNationalProviderId);
        return examinerId == 0L ? Optional.empty() : Optional.of(new ExaminerNationalProviderIdentifier(examinerNationalProviderId));
    }

    public Optional<ExaminerNationalProviderIdentifier> createMentalStateExam(
            String firstName,
            String lastName,
            UUID nationalProviderIdentifier
    ) {
        var examinerId = personalsContextFacade.createExaminer(firstName, lastName, nationalProviderIdentifier);
        return examinerId == 0L ? Optional.empty() : Optional.of(new ExaminerNationalProviderIdentifier(nationalProviderIdentifier));
    }

}
