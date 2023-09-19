package com.vb.userservice;

public interface Constants {
    String HOTEL_SERVICE = "HOTEL-SERVICE";
    String RATING_SERVICE="RATING-SERVICE";

    String GET_RATING_BY_USER_ID_URL="http://"+RATING_SERVICE+"/ratings/users/";
    String GET_HOTEL_BY_RATING_ID_URL="http://"+HOTEL_SERVICE+"/hotels/";

}
