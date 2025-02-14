package com.example.demo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Student")
@Table(name = "student",
       uniqueConstraints = {
        @UniqueConstraint(name = "student_email_unique",columnNames = "email")
       })
public class Student {
    
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id",
        updatable = false
    )
    private Long id;

    @Column(name = "first_name",
        nullable = false,
        columnDefinition = "TEXT")
    private String first_name;

    @Column(name = "last_name",
        nullable = false,
        columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "email",
        nullable = false,
        columnDefinition = "TEXT")
    private String email;

    @Column(name = "age",
        nullable = false)
    private Integer age;
    
    public Student(){

    }

    public Student(String first_name,String lastName,String email,
                   Integer age){
         this.first_name = first_name;
         this.lastName = lastName;
         this.email = email;
         this.age = age;
    }
}
