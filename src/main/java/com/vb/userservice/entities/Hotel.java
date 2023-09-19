package com.vb.userservice.entities;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {
    String id;
    String name;
    String location;
    String about;


}
