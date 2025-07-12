package org.hign.platform.u202318274.assessment.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hign.platform.u202318274.assessment.domain.model.commands.CreateMentalExamCommand;
import org.hign.platform.u202318274.assessment.domain.model.valueobjects.ExaminerNationalProviderRecordId;
import org.hign.platform.u202318274.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.annotation.CreatedDate;

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
    @Column
    private ExaminerNationalProviderRecordId examinerNationalProviderIdentifier;

    @Column
    @NotNull
    private Date examDate;

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

    public MentalStateExam(CreateMentalExamCommand command) {
        this.patientId = command.patientId();
        this.examinerNationalProviderIdentifier = new ExaminerNationalProviderRecordId(command.examinerNationalProviderIdentifier());
        this.examDate = command.examDate();
        this.orientationScore = command.orientationScore();
        this.registrationScore = command.registrationScore();
        this.attentionAndCalculationScore = command.attentionAndCalculationScore();
        this.recallScore = command.recallScore();
        this.languageScore = command.languageScore();

    }
}
