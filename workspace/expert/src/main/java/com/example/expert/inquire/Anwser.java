package com.example.expert.inquire;

import com.example.expert.audit.Period;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_ANWSER")
public class Anwser extends Period {
    @Id @GeneratedValue
    private Long id;
    private String anserContents;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID")
    private Question question;
}
