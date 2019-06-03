package com.stackroute.RepositoryTest;


import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track = new Track(7,"Venom","By Eminem");
    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track testTrack = trackRepository.findByTrackId(track.getTrackId());
        Assert.assertEquals(7,testTrack.getTrackId());

    }

    @Test
    public void testSaveTrackFailure(){
        Track testTrack = new Track(1,"team","By Krewella");
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findByTrackId(track.getTrackId());
        Assert.assertNotSame(fetchTrack,testTrack);
    }

    @Test
    public void testGetAllTracks(){
        Track track1 = new Track(4,"All Time Low","By Jon Bellion");
        Track track2 = new Track(5,"Body","By Brando");
        trackRepository.save(track1);
        trackRepository.save(track2);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("All Time Low",list.get(0).getTrackName());
        Assert.assertEquals("Body",list.get(1).getTrackName());
    }

    @Test
    public void testFindByName(){
        trackRepository.save(track);
        List<Track> testTrack = trackRepository.findByTrackName(track.getTrackName());
        Assert.assertEquals(7,testTrack.get(0).getTrackId());

    }
}
