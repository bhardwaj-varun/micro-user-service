package com.vb.userservice.services.impl;

import com.vb.userservice.Constants;
import com.vb.userservice.entities.Hotel;
import com.vb.userservice.entities.Rating;
import com.vb.userservice.entities.User;
import com.vb.userservice.exceptions.ResourceNotFoundException;
import com.vb.userservice.repositories.UserRepository;
import com.vb.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String id) {

        User user =userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User by not found with id: "+ id));

        Rating[] ratingsArray = restTemplate.getForObject(Constants.GET_RATING_BY_USER_ID_URL+user.getId(), Rating[].class);

        List<Rating> ratingList = Arrays.stream(ratingsArray).toList();

         List<Rating> ratings = ratingList.stream().map(rating->{
                    //call api
            Hotel hotel = restTemplate.getForObject(Constants.GET_HOTEL_BY_RATING_ID_URL+rating.getHotelId(), Hotel.class);
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratings);
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
