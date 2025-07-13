package org.hign.platform.u202318274.personnel.interfaces.acl;

import java.util.UUID;

public interface PersonalsContextFacade {

    Long createExaminer(
            String firstName,
            String lastName,
            UUID nationalProviderIdentifier
    );

    Long fetchExaminerByNationalProviderIdentifier(
            UUID nationalProviderIdentifier
    );
}
