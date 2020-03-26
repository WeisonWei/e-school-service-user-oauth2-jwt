package com.es.user.jwt.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate(true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_address", indexes = @Index(name = "idx_province", columnList = "province"))
public class Address extends BaseEntity {

    @Builder.Default
    @Column(name = "province", nullable = true, columnDefinition = BaseEntity.VARCHAR_DEFAULT_0)
    private String province = null;

    @Builder.Default
    @Column(name = "city", nullable = true, columnDefinition = BaseEntity.VARCHAR_DEFAULT_0)
    private String city = null;


}
