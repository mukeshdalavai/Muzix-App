package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ComponentScan
@Configuration
@ConfigurationProperties

@PropertySource("classpath:application.properties")

class MuzixApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    TrackRepository trackRepository;
    @Autowired
    public MuzixApplicationListener(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    @Value("${track.id}")
    private int trackid;

    @Value("${track.name}")
    private String trackName;

    @Value("${track.comments}")
    private String comments;

    @PostConstruct
    public void saveTrack(){
        Track track=new Track(trackid,trackName,comments);
        trackRepository.save(track);
    }

    @Autowired
    private Environment environment;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Track track1=new Track(2,"Humble","By Kendrick Lamer");
        trackRepository.save(track1);
        Track track2=new Track(3,"Goose Bumps","By Travis Scott");
        trackRepository.save(track2);
        Track track3=new Track(4,"Kill Shot","By Eminem");
        trackRepository.save(track3);
        Track track4=new Track(5,"Team","By Krewella");
        trackRepository.save(track4);
        Track track5=new Track(Integer.parseInt(environment.getProperty("track2.id")),environment.getProperty("track2.name"),environment.getProperty("track2.comments"));
        trackRepository.save(track5);
    }
}
