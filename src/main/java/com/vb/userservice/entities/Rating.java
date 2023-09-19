package com.vb.userservice.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Rating {
    String ratingId;
    String userId;
    String hotelId;
    String feedback;
    int rating;
}
