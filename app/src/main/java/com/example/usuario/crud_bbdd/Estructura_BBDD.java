package com.example.usuario.crud_bbdd;

import android.provider.BaseColumns;

/**
 * Created by usuario on 03/10/2017.
 */

public class Estructura_BBDD {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Estructura_BBDD() {
    }

    /* Inner class that defines the table contents */
    //public static class FeedEntry implements BaseColumns {
    public static final String TABLE_NAME = "datosPersonales";
    public static final String NOMBRE_COLUMNA1 = "Id";
    public static final String NOMBRE_COLUMNA2 = "Nombre";
    public static final String NOMBRE_COLUMNA3 = "Apellido";
    //}

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Estructura_BBDD.TABLE_NAME + " (" +
                    Estructura_BBDD.NOMBRE_COLUMNA1 + " INTEGER PRIMARY KEY," +
                    Estructura_BBDD.NOMBRE_COLUMNA2 + TEXT_TYPE + COMMA_SEP +
                    Estructura_BBDD.NOMBRE_COLUMNA3 + TEXT_TYPE + " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Estructura_BBDD.TABLE_NAME;
}
