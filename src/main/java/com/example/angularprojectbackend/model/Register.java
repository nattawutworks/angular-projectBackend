package com.example.angularprojectbackend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "register")

public class Register {

        @Id
        public String id;
        public String fullName;
        public String email;
        public String password;
        public String tel;

        @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE_TIME)
        public LocalDate birthDay;

        public String sex;

}
