package com.github.koraktor.steamcondenser.steam.community;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Leo Cacheux
 */
public class SteamGameTest {

    @Test
    public void testSteamGame() throws Exception {
        SteamGame game = new SteamGame(7670);
        game.loadFromCommunity();

        assertEquals("http://media.steampowered.com/steamcommunity/public/images/apps/7670/9a7c9f640a76e6a32592277dbbc36a0f6da05372.jpg", game.getIconUrl());
    }
}
