package org.example.escuelarural_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notas")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private int id;

    @Column(name ="nota",nullable = false,length = 5)
    private String grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
