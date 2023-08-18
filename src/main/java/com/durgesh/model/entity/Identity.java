package com.durgesh.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Identity {
    @Getter(onMethod_ = {
            @Id,
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    })
    private Integer id;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String createdBy;

}
