package com.example.usuario.crud_bbdd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //BBDD_Helper helper;
    //EditText id, nombre, apellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText id = (EditText) findViewById(R.id.id);
        final EditText nombre = (EditText) findViewById(R.id.nombre);
        final EditText apellidos = (EditText) findViewById(R.id.apellido);

        final BBDD_Helper helper = new BBDD_Helper(this);
        Button btnlistar=(Button) findViewById(R.id.listar);
        btnlistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        Button btnBuscar = (Button) findViewById(R.id.buscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db=helper.getReadableDatabase();
                String[] projection ={
                       //Estructura_BBDD.NOMBRE_COLUMNA1,
                        Estructura_BBDD.NOMBRE_COLUMNA2,
                        Estructura_BBDD.NOMBRE_COLUMNA3


                };
                String selection= Estructura_BBDD.NOMBRE_COLUMNA1 + " =?";
                String [] selectionArgs= {id.getText().toString()};
                //String sortOrder = Estructura_BBDD.NOMBRE_COLUMNA2 + "DESC";
                Cursor c=db.query(
                        Estructura_BBDD.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null);

                c.getCount();
                if (c.getCount()>0)
                c.moveToFirst();
                String itemId = c.getString(
                        c.getColumnIndexOrThrow(Estructura_BBDD.NOMBRE_COLUMNA2)
                );
                Toast.makeText(getApplicationContext(),"Nombre asociado a esa ID: " + itemId,Toast.LENGTH_LONG).show();
                nombre.setText(c.getString(0));
                apellidos.setText(c.getString(1));
            }
        });

        Button btnInsertar = (Button) findViewById(R.id.insertar);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = helper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(Estructura_BBDD.NOMBRE_COLUMNA1, id.getText().toString());
                values.put(Estructura_BBDD.NOMBRE_COLUMNA2, nombre.getText().toString());
                values.put(Estructura_BBDD.NOMBRE_COLUMNA3, apellidos.getText().toString());

                long newRowId = db.insert(Estructura_BBDD.TABLE_NAME, null, values);

                Toast.makeText(getApplicationContext(),"Se ha guardado con clave: "+ newRowId,Toast.LENGTH_LONG).show();
            }
        });

        Button btnActualizar = (Button) findViewById(R.id.actualizar);
        btnActualizar.setOnClickListener(this);

        Button btnBorrar = (Button) findViewById(R.id.borrar);
        btnBorrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        /*switch (view.getId()) {
            case R.id.buscar:

                break;
            case R.id.insertar:

                SQLiteDatabase db = helper.getWritableDatabase();

                // Create a new map of values, where column names are the keys

                ContentValues values = new ContentValues();
                values.put(Estructura_BBDD.NOMBRE_COLUMNA1, id.getText().toString());
                values.put(Estructura_BBDD.NOMBRE_COLUMNA2, nombre.getText().toString());
                values.put(Estructura_BBDD.NOMBRE_COLUMNA3, apellidos.getText().toString());

                // Insert the new row, returning the primary key value of the new row

                long newRowId = db.insert(Estructura_BBDD.TABLE_NAME, null, values);

                break;
            case R.id.actualizar:

                break;
            case R.id.borrar:

                break;
        }*/
    }
}