package com.example.basic.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {
    @Id @GeneratedValue // 시퀀스
//    @Column(name = "MEMBER_ID") // 카멜로 표기하면 자동으로 이렇게 변환된다.
    private Long id;
    private String memberName;
    @Column(unique = true)
    private String memberEmail;
    private String memberPassword;
    private int memberAge;
}
