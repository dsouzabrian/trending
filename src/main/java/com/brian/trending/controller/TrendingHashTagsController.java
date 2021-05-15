/*
@author brian.dsouza
*/
package com.brian.trending.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import twitter4j.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class TrendingHashTagsController {

    /*
        Function to return top trending HashTags using Twitter API and twitter4j library
    */
    @GetMapping("/trending")
    public List<String> getTrendingHashTags(){

        ArrayList<String> listOfTrendingHashTags = new ArrayList<String>();
        try{
            Twitter twitter = new TwitterFactory().getInstance();
            //Set WOEID = 1 for global or 23424848 for India
            Trends trends = twitter.getPlaceTrends(23424848);
            for (int i = 0; i < trends.getTrends().length; i++) {
                if(trends.getTrends()[i].getName().startsWith("#")) {
                    System.out.println(trends.getTrends()[i].getName());
                    //Adding HashTag in ArrayList
                    listOfTrendingHashTags.add(trends.getTrends()[i].getName());
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
     return listOfTrendingHashTags;
}
}


