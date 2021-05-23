<snippet>
  <content><![CDATA[

# **Book My Hotel**
We are providing different features to assist users to search for hotel and provide reviews.
<br/>

## How to use 

There are different end points in this application. Please find there description below.
<br/>
1. endpoint related to Hotel services provided.<br/>
    a. for adding new hotel, please use below endpoint and refer sample request body<br/>
         end point - /BookMyHotel/hotel<br/>
         request - Get request<br/>
         request body - {<br/>
                            "hotel" : {<br/>
                            "name" : "Hotel1",<br/>
                            "city" : "city1",<br/>
                            "totalRoom" : 100,<br/>
                            "costOfRoom" : 100,<br/>
                            "facility" : ["AC","FOOD"] <br/>
                        }<br/>

    b. for updating an already existing hotel details, please use below endpoint, request and sample request body<br/>
        end point - /BookMyHotel/hotel<br/>
        request - put request<br/>
        request body - {<br/>
                            "hotelId" : 1,<br/>
                            "hotel" : { <br/>
                            "name" : "Hotel1",<br/>
                            "city" : "city1",<br/>
                            "totalRoom" : 100,<br/>
                            "costOfRoom" : 100,<br/>
                            "facility" : ["AC","FOOD"]<br/>
                            }<br/>
                        }<br/>

    c. for deleting an hotel, use below format for making request<br/>
        endpoint - /BookMyHotel/hotel<br/>
        request - delete request<br/>
        request body -   {<br/>
                                "hotelId" : 1<br/>
                            }<br/>

    d. for searching hotel based on different criterias. all fields are optional. provide values for those field by which you want to filter the result. Please use below for using service.<br/>
        endpoint - /BookMyHotel/searchHotel<br/>
        request - get request<br/>
        request body -  {<br/>
                                "city" : "city2",<br/>
                                "date" : "2021-05-22",<br/>
                                "roomRequired" : 12,<br/>
                                "rating" : "FIVESTAR",<br/>
                                "facilities" : ["AC"]<br/>
                            }<br/>
<br/>
2. endpoint related to User services provided.<br/>
    a. for adding new user, please use below endpoint and refer sample request body<br/>
        end point - /BookMyHotel/user<br/>
        request - Get request<br/>
        request body - {<br/>
                            "user" : {<br/>
                            "name" : "user1",<br/>
                            "gender" : "FEMALE"<br/>
                        }<br/>

    b. for updating an already existing user details, please use below endpoint, request and sample request body<br/>
        end point - /BookMyHotel/user<br/>
        request - put request<br/>
        request body - {<br/>
                            "userId" : 1<br/>
                            "user" : {<br/>
                            "name" : "user1",<br/>
                            "gender" : "FEMALE"<br/>
                            }<br/>
                        }<br/>
<br/>
    c. for deleting an user, use below format for making request<br/>
        endpoint - /BookMyHotel/user<br/>
        request - delete request<br/>
        request body -   {<br/>
                                "userId" : 1<br/>
                            }<br/>
<br/>
2. endpoint related to review services provided.<br/>
    a. for adding new user, please use below endpoint and refer sample request body<br/>
        end point - /BookMyHotel/review<br/>
        request - Get request<br/>
        request body - {<br/>
                            "review" : {<br/>
                              "userId" : 0,<br/>
                              "hotelId" : 1,<br/>
                              "comment" : "comment1",<br/>
                              "rating" : "FIVESTAR"<br/>
                        }<br/>

    b. for updating an already existing review details, please use below endpoint, request and sample request body<br/>
        end point - /BookMyHotel/review<br/>
        request - put request<br/>
        request body - {<br/>
                            "reviewId" : 1,<br/>
                            "review" : {<br/>
                            "name" : "user1",<br/>
                            "gender" : "FEMALE"<br/>
                            }<br/>
                        }<br/>

    c. for deleting an review, use below format for making request<br/>
        endpoint - /BookMyHotel/review<br/>
        request - delete request<br/>
        request body -   {<br/>
                                "reviewId" : 1,<br/>
                                "comment" : "comment1",<br/>
                                "rating" : "ONESTAR"<br/>
                            }<br/>

# Building and starting Application

build command - mvn clean install 
command for starting application - mvn spring-boot:run

]]></content>
  <tabTrigger>readme</tabTrigger>
</snippet>
