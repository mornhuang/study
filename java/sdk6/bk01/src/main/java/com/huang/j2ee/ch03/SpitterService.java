package com.huang.j2ee.ch03;

import java.util.List;


/**
 * Created By User : Morn
 * Created DateTime: 2015/4/7 21:36
 * Descriptions    :
 */
public interface SpitterService {
    List<Spittle> getRecentSpittles(int count);

    void saveSpittle(Spittle spittle);

    void saveSpitter(Spitter spitter);

    Spitter getSpitter(long id);

    void startFollowing(Spitter follower, Spitter followee);

    List<Spittle> getSpittlesForSpitter(Spitter spitter);

    List<Spittle> getSpittlesForSpitter(String username);

    Spitter getSpitter(String username);

    Spittle getSpittleById(long id);

    void deleteSpittle(long id);

    List<Spitter> getAllSpitters();
}
