package org.hign.platform.u202318274.assessment.application.internal.outboundservices.acl;

import org.hign.platform.u202318274.assessment.domain.model.valueobjects.ExaminerNationalProviderIdentifier;
import org.hign.platform.u202318274.personnel.interfaces.acl.PersonalsContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExternalPersonnelService {
    private final PersonalsContextFacade personalsContextFacade;

    public ExternalPersonnelService(PersonalsContextFacade personalsContextFacade) {
        this.personalsContextFacade = personalsContextFacade;
    }

    // Mnemothechnic: Choose the foreign key
    public Optional<ExaminerNationalProviderIdentifier> fetchExaminerByNationalProviderIdentifier(UUID nationalProviderIdentifier){
        // Fetch examiner by national provider identifier from the external service
        var examiner = personalsContextFacade.fetchExaminerByNationalProviderIdentifier(nationalProviderIdentifier);
        return examiner == 0L ? Optional.empty() : Optional.of(new ExaminerNationalProviderIdentifier(nationalProviderIdentifier));

    }

}
