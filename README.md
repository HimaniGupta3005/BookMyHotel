<snippet>
  <content><![CDATA[

# ${1:Book My Hotel}
TODO: We are providing different features to assist users to search for hotel and provide reviews.

## How to use

There are different end points in this application. Please find there description below.

1. endpoint related to Hotel services provided.
    a. for adding new hotel, please use below endpoint and refer sample request body
        ## end point - /BookMyHotel/hotel
        ## request - Get request
        ## request body - {
                            "hotel" : {
                            "name" : "Hotel1",
                            "city" : "city1",
                            "totalRoom" : 100,
                            "costOfRoom" : 100,
                            "facility" : ["AC","FOOD"]
                        }

    b. for updating an already existing hotel details, please use below endpoint, request and sample request body
        ## end point - /BookMyHotel/hotel
        ## request - put request
        ## request body - {
                            "hotelId" : 1
                            "hotel" : {
                            "name" : "Hotel1",
                            "city" : "city1",
                            "totalRoom" : 100,
                            "costOfRoom" : 100,
                            "facility" : ["AC","FOOD"]
                            }
                        }

    c. for deleting an hotel, use below format for making request
        ## endpoint - /BookMyHotel/hotel
        ## request - delete request
        ## request body -   {
                                "hotelId" : 1
                            }

    d. for searching hotel based on different criterias. all fields are optional. provide values for those field by which you want to filter the result. Please use below for using service.
        ## endpoint - /BookMyHotel/searchHotel
        ## request - get request
        ## request body -  {
                                "city" : "city2",
                                "date" : "2021-05-22",
                                "roomRequired" : 12,
                                "rating" : "FIVESTAR",
                                "facilities" : ["AC"]
                            }



## Usage
TODO: Write usage instructions
## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D
## History
TODO: Write history
## Credits
TODO: Write credits
## License
TODO: Write license
]]></content>
  <tabTrigger>readme</tabTrigger>
</snippet>
