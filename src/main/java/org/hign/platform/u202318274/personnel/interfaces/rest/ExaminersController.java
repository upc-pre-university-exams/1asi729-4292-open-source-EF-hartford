package org.hign.platform.u202318274.personnel.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.u202318274.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.u202318274.personnel.interfaces.rest.resources.CreateExaminerResource;
import org.hign.platform.u202318274.personnel.interfaces.rest.resources.ExaminerResource;
import org.hign.platform.u202318274.personnel.interfaces.rest.transform.CreateExaminerCommandFromResourceAssembler;
import org.hign.platform.u202318274.personnel.interfaces.rest.transform.ExaminerResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/examiners", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Examiners", description = "Available Examiners Endpoints")
public class ExaminersController {
    private final ExaminerCommandService examinerCommandService;

    public ExaminersController(ExaminerCommandService examinerCommandService) {
        this.examinerCommandService = examinerCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a new examiner", description = "Create a new examiner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Examiner created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Examiner not found")})
    public ResponseEntity<ExaminerResource> createProfile(@RequestBody CreateExaminerResource resource) {
        var createExaminerCommand = CreateExaminerCommandFromResourceAssembler.toCommandFromResource(resource);
        var examiner = examinerCommandService.handle(createExaminerCommand);
        if (examiner.isEmpty()) return ResponseEntity.badRequest().build();
        var createdExaminer = examiner.get();
        var examinerResource = ExaminerResourceFromEntityAssembler.toResourceFromEntity(createdExaminer);
        return new ResponseEntity<>(examinerResource, HttpStatus.CREATED);
    }


}
