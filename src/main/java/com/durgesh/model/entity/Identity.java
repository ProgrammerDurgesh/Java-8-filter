package com.durgesh.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
