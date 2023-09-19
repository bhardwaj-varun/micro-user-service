package com.vb.userservice.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {
    @Id
    @Column(name = "id")
    String id;
    String name;
    String email;
    String about;

    @Transient
    List<Rating> ratings = new ArrayList<>();
}
