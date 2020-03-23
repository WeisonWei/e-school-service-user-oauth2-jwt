package com.es.user.jwt.entity;

import com.es.user.jwt.repository.UserAuditListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate(true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "t_user", indexes = @Index(name = "idx_name", columnList = "name"))
@EntityListeners({AuditingEntityListener.class, UserAuditListener.class})
public class User extends BaseEntity {

    @Builder.Default
    @Column(name = "name", nullable = true, columnDefinition = VARCHAR_DEFAULT_0)
    private String name = null;

    @Builder.Default
    @Column(name = "age", nullable = true, columnDefinition = INT_DEFAULT_0)
    private Integer age = null;

    @Builder.Default
    @Column(name = "password", nullable = true, columnDefinition = VARCHAR_DEFAULT_0)
    private String password = null;

    @Builder.Default
    @Column(name = "phone", nullable = true, columnDefinition = VARCHAR_DEFAULT_0)
    private String phone = null;

    @Builder.Default
    @Column(name = "email", nullable = true, columnDefinition = VARCHAR_DEFAULT_0)
    private String email = null;

    @Builder.Default
    @Column(name = "birth_day", nullable = true, columnDefinition = DATETIME_DEFAULT_0)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate birthday = LocalDate.now();

    @Builder.Default
    @Column(name = "address", nullable = true, columnDefinition = VARCHAR_DEFAULT_0)
    private String address = null;

    @Builder.Default
    @Column(name = "version", nullable = true, columnDefinition = BIGINT_DEFAULT_0)
    @Version //乐观锁字段
    private Long version = null;

}
