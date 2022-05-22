package com.example.juegolistviewfutbol;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {

    private SurfaceHolder holder;
    private BucleJuego bucle;
    public int xBall, yBall, altoPantalla, anchoPantalla;
    Random aleatorio = new Random();
    Activity activity;
    Bitmap pelota;
    public int velocidad;
    int x,y,index;
    boolean hayToque=false;
    ArrayList<Toque> toques = new ArrayList<Toque>();
    int puntos=0;
    boolean derrota=false;
   
    private static final String TAG = Juego.class.getSimpleName();

    public Juego(Activity context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        activity = context;
        dimesionesPantalla();
        pelota = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        pelota.createScaledBitmap(pelota, 100, 100, true);
        xBall = aleatorio.nextInt(anchoPantalla-pelota.getWidth());
        yBall = altoPantalla/2-pelota.getHeight();

        velocidad = 4;

        //Listener del onTouch
        setOnTouchListener(this);
    }

    public void dimesionesPantalla(){
        if(Build.VERSION.SDK_INT > 13) {
            Display display = activity.getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            anchoPantalla = size.x;
            altoPantalla = size.y;
        }
        else{
            Display display = activity.getWindowManager().getDefaultDisplay();
            anchoPantalla = display.getWidth();  // deprecated
            altoPantalla = display.getHeight();  // deprecated
        }
        Log.i(Juego.class.getSimpleName(), "alto:" + altoPantalla + "," + "ancho:" + anchoPantalla);
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // se crea la superficie, creamos el game loop

        // Para interceptar los eventos de la SurfaceView
        getHolder().addCallback(this);

        // creamos el game loop
        bucle = new BucleJuego(getHolder(), this);

        // Hacer la Vista focusable para que pueda capturar eventos
        setFocusable(true);

        //comenzar el bucle
        bucle.start();

    }

    /**
     * Este método actualiza el estado del juego. Contiene la lógica del videojuego
     * generando los nuevos estados y dejando listo el sistema para un repintado.
     */
    public void actualizar() {

moverPelota();

        if (hayToque){
            if (x>=xBall && x<=xBall+pelota.getWidth()
                    && y>yBall && y<=yBall+pelota.getHeight()){
                puntos++;
                velocidad = velocidad*(-1);
                hayToque=false;
            }
        }

        derrotar();



    }

    public void moverPelota(){
        yBall+=velocidad;
    }

    public void derrotar(){
        if (yBall<=0 || yBall >= altoPantalla-pelota.getHeight()){
            derrota=true;

            if (segundaLista.jugadorElegido == "Cristiano Ronaldo"){
                segundaLista.puntuacion[1] = puntos;
                Intent o = new Intent(getContext(), segundaLista.class);
                activity.startActivity(o);
            }
            if (segundaLista.jugadorElegido == "Benzema"){
                segundaLista.puntuacion[2] = puntos;
                Intent o = new Intent(getContext(), segundaLista.class);
                activity.startActivity(o);
            }
            if (segundaLista.jugadorElegido == "Luka Modric"){
                segundaLista.puntuacion[3] = puntos;
                Intent o = new Intent(getContext(), segundaLista.class);
                activity.startActivity(o);
            }
            if (segundaLista.jugadorElegido == "Mbappe"){
                segundaLista.puntuacion[4] = puntos;
                Intent o = new Intent(getContext(), segundaLista.class);
                activity.startActivity(o);
            }
            if (segundaLista.jugadorElegido == "Messi"){
                segundaLista.puntuacion[5] = puntos;
                Intent o = new Intent(getContext(), segundaLista.class);
                activity.startActivity(o);
            }

            if (primeraLista.jugadorElegido == "Mbappe"){
                segundaLista.puntuacion[1] = puntos;
                ListaAdapter.puntuacion[1] =puntos;
                Intent o = new Intent(getContext(), primeraLista.class);
                activity.startActivity(o);
            }
            if (primeraLista.jugadorElegido == "Messi"){
                segundaLista.puntuacion[2] = puntos;
                Intent o = new Intent(getContext(), primeraLista.class);
                activity.startActivity(o);
            }
            if (primeraLista.jugadorElegido == "Benzemá!"){
                segundaLista.puntuacion[3] = puntos;
                Intent o = new Intent(getContext(), primeraLista.class);
                activity.startActivity(o);
            }
            if (primeraLista.jugadorElegido == "Cristiano!"){
                segundaLista.puntuacion[4] = puntos;
                Intent o = new Intent(getContext(), primeraLista.class);
                activity.startActivity(o);
            }
            if (primeraLista.jugadorElegido == "Luka Modric!"){
                segundaLista.puntuacion[5] = puntos;
                Intent o = new Intent(getContext(), primeraLista.class);
                activity.startActivity(o);
            }


        }
    }

    public void fin(){
        bucle.JuegoEnEjecucion=false;
        try{
            pelota.recycle();
        } catch (Exception e){
            Log.d("Excepción: ", "reproductores");
        }

    }

    public void derrotaFindeJuego(Paint myPaint, Canvas canvas){
        myPaint.setAlpha(0);

        //Bandera Nazi Victoria
        //  canvas.drawBitmap(banderaNazi, AnchoPantalla/2-banderaNazi.getWidth()/2, AltoPantalla-banderaNazi.getHeight()*2, null);
        myPaint.setColor(Color.GREEN);
        myPaint.setTextSize(anchoPantalla/10);
        canvas.drawText("¡Perdiste!", anchoPantalla/4, altoPantalla/2-100, myPaint);
        myPaint.setTextSize(anchoPantalla/20);
        canvas.drawText("La pelota se escapó", anchoPantalla/4, altoPantalla/2, myPaint);
        myPaint.setColor(Color.MAGENTA);
        canvas.drawText("PUNTOS: " + puntos, anchoPantalla/5, altoPantalla/2+100, myPaint);
        fin();
    }

    /**
     * Este método dibuja el siguiente paso de la animación correspondiente
     */
    public void renderizar(Canvas canvas) {

        canvas.drawColor(Color.BLACK);

        //pintar mensajes que nos ayudan
        Paint p=new Paint();
        p.setStyle(Paint.Style.FILL_AND_STROKE);
        p.setColor(Color.RED);
        p.setTextSize(50);
        canvas.drawText("PUNTOS: "+ puntos +";"+"Tiempo "+bucle.tiempoTotal,50,150,p);

        canvas.drawBitmap(pelota,xBall, yBall, p);


        if (derrota){
            derrotaFindeJuego(p, canvas);
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "Juego destruido!");
        // cerrar el thread y esperar que acabe
        boolean retry = true;
        while (retry) {
            try {
                bucle.join();
                retry = false;
            } catch (InterruptedException e) {

            }
        }
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // Obtener el pointer asociado con la acción
        index = event.getActionIndex();
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                hayToque = true;
                x = (int) event.getX(index);
                y = (int) event.getY(index);
                synchronized (this) {
                    toques.add(index, new Toque(index, x, y));
                }
                // Se comprueba si se ha pulsado.
                Log.i(Juego.class.getSimpleName(), "Pulsado dedo " + index + ".");
                break;
            case MotionEvent.ACTION_POINTER_UP:
                synchronized (this) {
                    toques.remove(index);
                }
                // Se comprueba si se ha soltado.
                Log.i(Juego.class.getSimpleName(), "Soltado dedo " + index + ".");
                break;
            case MotionEvent.ACTION_UP:
                synchronized (this) {
                    toques.remove(index);
                }
                // Se comprueba si se ha soltado.
                Log.i(Juego.class.getSimpleName(), "Soltado dedo " + index + ".ultimo.");
                hayToque = false;
                break;
        }
        return true;
    }
}
