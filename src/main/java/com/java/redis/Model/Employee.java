package com.java.redis.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.lang.annotation.Documented;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RedisHash("employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private UUID id;

    private String firstName;

    private String lastName;

    private String phone;

    private String mail;

    private BigDecimal balance;

    private Date joinDate;

    private HashMap hobbies;

}
