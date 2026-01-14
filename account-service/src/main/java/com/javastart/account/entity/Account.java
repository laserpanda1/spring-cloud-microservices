package com.javastart.account.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private String name;

    private String phone;

    private String email;

    private OffsetDateTime creationTime;

    @ElementCollection
    private List<Long> bills;

    public Account(String name, String phone, OffsetDateTime creationTime , String email, List<Long> bills) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.bills = bills;
    }

}
