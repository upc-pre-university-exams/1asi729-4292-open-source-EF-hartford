package org.hign.platform.u202318274.personnel.interfaces.rest.transform;

import org.hign.platform.u202318274.personnel.interfaces.rest.resources.CreateExaminerResource;

public class CreateExaminerCommandFromResourceAssembler {
    public static CreateExaminerResource toCommandFromResource(CreateExaminerResource resource) {
        return new CreateExaminerResource(
                resource.firstName(),
                resource.lastName(),
                resource.nationalProviderId()
        );
    }
}
