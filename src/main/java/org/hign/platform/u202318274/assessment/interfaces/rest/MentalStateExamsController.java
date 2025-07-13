package org.hign.platform.u202318274.assessment.interfaces.rest;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.u202318274.assessment.domain.services.MentalStateCommandService;
import org.hign.platform.u202318274.assessment.domain.services.MentalStateQueryService;
import org.hign.platform.u202318274.assessment.interfaces.rest.resources.CreateMentalStateExamResource;
import org.hign.platform.u202318274.assessment.interfaces.rest.resources.MentalStateExamResource;
import org.hign.platform.u202318274.assessment.interfaces.rest.transform.CreateMentalStateExamCommandFromResourceAssembler;
import org.hign.platform.u202318274.assessment.interfaces.rest.transform.MentalStateExamFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/mental-state-exams", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Mental State Exams", description = "Available Mental State Exam Endpoints")
public class MentalStateExamsController {
    private final MentalStateCommandService mentalStateCommandService;

    public MentalStateExamsController(MentalStateCommandService mentalStateCommandService) {
        this.mentalStateCommandService = mentalStateCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a new MentalStateExam", description = "Create a new MentalStateExam")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mental State Exam created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Mental State Exam not found")})
    public ResponseEntity<MentalStateExamResource> createMentalStateExam(@RequestBody CreateMentalStateExamResource resource) {
        var createMentalStateExamCommand = CreateMentalStateExamCommandFromResourceAssembler.toCommandFromResource(resource);

        var mentalStateExam = mentalStateCommandService.handle(createMentalStateExamCommand);

        if (mentalStateExam.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var mentalStateExamResource = MentalStateExamFromEntityAssembler.toResourceFromEntity(mentalStateExam.get());

        return new ResponseEntity<>(mentalStateExamResource, HttpStatus.CREATED);
    }
}
