package org.hign.platform.u202318274.assessment.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hign.platform.u202318274.assessment.domain.model.commands.CreateMentalStateCommand;
import org.hign.platform.u202318274.assessment.domain.model.valueobjects.ExaminerNationalProviderIdentifier;
import org.hign.platform.u202318274.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.Date;

@Getter
@Setter
@Entity
public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {
    @Column
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotNull
    private Long patientId;

    @Embedded
    @NotNull
    private ExaminerNationalProviderIdentifier examinerNationalProviderIdentifier;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    Date examDate;

    @Column
    @NotNull
    private Integer orientationScore;

    @Column
    @NotNull
    private Integer registrationScore;

    @Column
    @NotNull
    private Integer attentionAndCalculationScore;

    @Column
    @NotNull
    private Integer recallScore;


    @Column
    @NotNull
    private Integer languageScore;


    public MentalStateExam() {
    }

    public MentalStateExam(CreateMentalStateCommand command) {
        this.patientId = command.patientId();
        this.examinerNationalProviderIdentifier = new ExaminerNationalProviderIdentifier(command.examinerNationalProviderIdentifier());
        this.examDate = command.examDate();
        this.orientationScore = command.orientationScore();
        this.registrationScore = command.registrationScore();
        this.attentionAndCalculationScore = command.attentionAndCalculationScore();
        this.recallScore = command.recallScore();
        this.languageScore = command.languageScore();

    }
}
