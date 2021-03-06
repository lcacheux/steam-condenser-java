/**
 * This code is free software; you can redistribute it and/or modify it under
 * the terms of the new BSD License.
 *
 * Copyright (c) 2011-2013, Sebastian Staudt
 */

package com.github.koraktor.steamcondenser.steam.community.tf2;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.exceptions.WebApiException;
import com.github.koraktor.steamcondenser.steam.community.GameInventory;
import com.github.koraktor.steamcondenser.steam.community.GameItem;

/**
 * Represents the inventory (aka. Backpack) of a player of the public Team
 * Fortress 2 beta
 *
 * @author Sebastian Staudt
 */
public class TF2BetaInventory extends GameInventory {

    public static final int APP_ID = 520;

    /**
     * This checks the cache for an existing inventory. If it exists it is
     * returned. Otherwise a new inventory is created.
     *
     * @param vanityUrl The vanity URL of the user
     * @return The Team Fortress 2 Beta inventory for the given user
     * @throws SteamCondenserException if creating the inventory fails
     */
    public static TF2BetaInventory create(String vanityUrl)
            throws SteamCondenserException {
        return (TF2BetaInventory) create(APP_ID, vanityUrl, true, false);
    }

    /**
     * This checks the cache for an existing inventory. If it exists it is
     * returned. Otherwise a new inventory is created.
     *
     * @param steamId64 The 64bit Steam ID of the user
     * @return The Team Fortress 2 Beta inventory for the given user
     * @throws SteamCondenserException if creating the inventory fails
     */
    public static TF2BetaInventory create(long steamId64)
            throws SteamCondenserException {
        return (TF2BetaInventory) create(APP_ID, steamId64, true, false);
    }

    /**
     * This checks the cache for an existing inventory. If it exists it is
     * returned. Otherwise a new inventory is created.
     *
     * @param vanityUrl The vanity URL of the user
     * @param fetchNow Whether the data should be fetched now
     * @return The Team Fortress 2 Beta inventory for the given user
     * @throws SteamCondenserException if creating the inventory fails
     */
    public static TF2BetaInventory create(String vanityUrl, boolean fetchNow)
            throws SteamCondenserException {
        return (TF2BetaInventory) create(APP_ID, vanityUrl, fetchNow, false);
    }

    /**
     * This checks the cache for an existing inventory. If it exists it is
     * returned. Otherwise a new inventory is created.
     *
     * @param steamId64 The 64bit Steam ID of the user
     * @param fetchNow Whether the data should be fetched now
     * @return The Team Fortress 2 Beta inventory for the given user
     * @throws SteamCondenserException if creating the inventory fails
     */
    public static TF2BetaInventory create(long steamId64, boolean fetchNow)
            throws SteamCondenserException {
        return (TF2BetaInventory) create(APP_ID, steamId64, fetchNow, false);
    }

    /**
     * This checks the cache for an existing inventory. If it exists it is
     * returned. Otherwise a new inventory is created.
     *
     * @param vanityUrl The vanity URL of the user
     * @param fetchNow Whether the data should be fetched now
     * @param bypassCache Whether the cache should be bypassed
     * @return The Team Fortress 2 Beta inventory for the given user
     * @throws SteamCondenserException if creating the inventory fails
     */
    public static TF2BetaInventory create(String vanityUrl, boolean fetchNow, boolean bypassCache)
            throws SteamCondenserException {
        return (TF2BetaInventory) create(APP_ID, vanityUrl, fetchNow, bypassCache);
    }

    /**
     * This checks the cache for an existing inventory. If it exists it is
     * returned. Otherwise a new inventory is created.
     *
     * @param steamId64 The 64bit Steam ID of the user
     * @param fetchNow Whether the data should be fetched now
     * @param bypassCache Whether the cache should be bypassed
     * @return The Team Fortress 2 Beta inventory for the given user
     * @throws SteamCondenserException if creating the inventory fails
     */
    public static TF2BetaInventory create(long steamId64, boolean fetchNow, boolean bypassCache)
            throws SteamCondenserException {
        return (TF2BetaInventory) create(APP_ID, steamId64, fetchNow, bypassCache);
    }

    /**
     * Creates a new inventory instance for the player with the given Steam ID
     *
     * @param steamId64 The 64bit Steam ID of the user
     * @param fetchNow Whether the data should be fetched now
     * @see GameInventory#create
     * @throws WebApiException on Web API errors
     */
    public TF2BetaInventory(long steamId64, boolean fetchNow)
            throws SteamCondenserException {
        super(APP_ID, steamId64, fetchNow);
    }

    /**
     * Returns the item class for Team Fortress 2
     *
     * @return The item class for Team Fortress 2 is TF2Item
     * @see TF2Item
     */
    protected Class<? extends GameItem> getItemClass() {
        return TF2Item.class;
    }

}
