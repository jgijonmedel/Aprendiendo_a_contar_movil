package com.cyti.aprendiendoacontar.juego;

import android.content.Context;
import android.view.View;

import com.cyti.aprendiendoacontar.BaseActivity;
import com.cyti.aprendiendoacontar.R;
import com.cyti.aprendiendoacontar.Utilities.Consts;
import com.cyti.aprendiendoacontar.Utilities.Recordar;
import com.cyti.aprendiendoacontar.db.Actividad;
import com.cyti.aprendiendoacontar.db.DataBase;
import com.cyti.aprendiendoacontar.dialogos.FinActividadDialog;

public class ConoceNumeros implements Jugable {

    private Context context;
    public static int numero = 1;

    public ConoceNumeros(Context context) {
        this.context = context;
    }

    @Override
    public void correcto() {

    }

    @Override
    public void incorrecto() {

    }

    //Finaliza el ejercicio y guarda los datos en la base de datos
    @Override
    public void finish(View view, int correctos, int incorrectos) {
        DataBase db = DataBase.getInstance(context);

        int correctosAnteriores = 0;
        try {
            correctosAnteriores = db.getActividad().buscarPorNombre(Consts.CONOCE).ejerciciosCorrectos;
        } catch (Exception ex) {
            correctosAnteriores = 0;
        }
        if (correctosAnteriores < correctos) {
            Actividad act = new Actividad();
            act.ejerciciosCorrectos = correctos;
            act.ejerciciosIncorrectos = incorrectos;
            act.nombre = Consts.CONOCE;
            db.getActividad().Insertar(act);
        }
        Recordar.recordarActividad(context, Consts.KEY_CONOCE, correctos);

        showDialog(view, correctos, Consts.CONOCE);
    }

    //Abre el dialogo al finalizar el ejercicio
    public void showDialog(View view, int correctos, String destino) {
        FinActividadDialog dialog = new FinActividadDialog(view, correctos, destino, 20);
        dialog.show(((BaseActivity) context).getSupportFragmentManager(), null);
    }

    //Dependiendo el numero que se indique se obtiene una imagen
    public int obtenerImagen(int numero) {
        int idImagen = 1;

        switch (numero) {
            case 1:
                idImagen = R.drawable.img_uno;
                break;
            case 2:
                idImagen = R.drawable.img_dos;
                break;
            case 3:
                idImagen = R.drawable.img_tres;
                break;
            case 4:
                idImagen = R.drawable.img_cuatro;
                break;
            case 5:
                idImagen = R.drawable.img_cinco;
                break;
            case 6:
                idImagen = R.drawable.img_seis;
                break;
            case 7:
                idImagen = R.drawable.img_siete;
                break;
            case 8:
                idImagen = R.drawable.img_ocho;
                break;
            case 9:
                idImagen = R.drawable.img_nueve;
                break;
            case 10:
                idImagen = R.drawable.img_diez;
                break;
            case 11:
                idImagen = R.drawable.img_once;
                break;
            case 12:
                idImagen = R.drawable.img_doce;
                break;
            case 13:
                idImagen = R.drawable.img_trece;
                break;
            case 14:
                idImagen = R.drawable.img_catorce;
                break;
            case 15:
                idImagen = R.drawable.img_quince;
                break;
            case 16:
                idImagen = R.drawable.img_dieciseis;
                break;
            case 17:
                idImagen = R.drawable.img_diecisiete;
                break;
            case 18:
                idImagen = R.drawable.img_dieciocho;
                break;
            case 19:
                idImagen = R.drawable.img_diecinueve;
                break;
            case 20:
                idImagen = R.drawable.img_veite;
                break;
        }
        return idImagen;
    }
}
