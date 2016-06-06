package com.example.rajan.popularmovie_2.data;

import net.simonvt.schematic.annotation.Database;
import net.simonvt.schematic.annotation.Table;

/**
 * Created by rajan on 7/6/16.
 */
@Database(version = MovieDatabase.VERSION)
public class MovieDatabase {

    public static final int VERSION = 1;

    @Table(MovieFavoritesColumns.class)
    public static final String FAVORITES = "favorites";

}