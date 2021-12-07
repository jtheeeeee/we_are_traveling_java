package com.weling.we_are_traveling_java.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter // get 함수를 자동 생성합니다.
@MappedSuperclass // 멤버 변수가 컬럼이 되도록 합니다.
@EntityListeners(AuditingEntityListener.class) // 변경되었을 때 자동으로 기록합니다.
public abstract class Timestamped {
    @CreatedDate // 최초 생성 시점
    private String createdAt;

    @LastModifiedDate // 마지막 변경 시점
    private String modifiedAt;


    //등록일자 형식 변경!!
    @PrePersist
    public void onPrePersist(){
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        this.modifiedAt = this.createdAt;
    }

    @PreUpdate
    public void onPreUpdate(){
        this.modifiedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    }
}