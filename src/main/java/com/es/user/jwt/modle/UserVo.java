package com.es.user.jwt.modle;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserVo implements Serializable {
    private Long id;
    private String name;
    private String token;
}
