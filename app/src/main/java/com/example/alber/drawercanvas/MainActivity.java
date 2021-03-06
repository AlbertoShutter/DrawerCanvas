package com.example.alber.drawercanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.content_main);
        Vista fondo = new Vista(this);
        layout1.addView(fondo);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.content_main);
            Vista fondo = new Vista(this);
            fondo.setBackgroundColor(Color.WHITE);
            layout1.addView(fondo);
        } else if (id == R.id.nav_gallery) {
            RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.content_main);
            Vista fondo = new Vista(this);
            fondo.setBackgroundColor(Color.GREEN);
            layout1.addView(fondo);
        } else if (id == R.id.nav_slideshow) {
            RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.content_main);
            Vista fondo = new Vista(this);
            fondo.setBackgroundColor(Color.RED);
            layout1.addView(fondo);
        } else if (id == R.id.nav_manage) {
            RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.content_main);
            Vista fondo = new Vista(this);
            fondo.setBackgroundColor(Color.YELLOW);
            layout1.addView(fondo);
        } else if (id == R.id.nav_share) {
            RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.content_main);
            Vista fondo = new Vista(this);
            fondo.setBackgroundColor(Color.GRAY);
            layout1.addView(fondo);
        } else if (id == R.id.nav_send) {
            RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.content_main);
            Vista fondo = new Vista(this);
            fondo.setBackgroundColor(Color.BLACK);
            layout1.addView(fondo);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class Vista extends View {

        float x = 50;
        float y = 50;
        String accion = "accion";
        Path path = new Path();

        public Vista (Context context) {
            super(context);
        }

        public void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            paint.setColor(Color.BLUE);

            int ancho = canvas.getWidth();
            if (accion == "down")
                path.moveTo(x,y);
            if (accion == "up")
                path.moveTo(x,y);
            if (accion == "move")
                path.lineTo(x,y);
            canvas.drawPath(path, paint);
        }

        public boolean onTouchEvent(MotionEvent e) {
            x = e.getX();
            y = e.getY();

            if (e.getAction() == MotionEvent.ACTION_DOWN)
                accion = "down";
            if (e.getAction() == MotionEvent.ACTION_MOVE)
                accion = "move";
            if (e.getAction() == MotionEvent.ACTION_UP)
                accion = "up";

            invalidate();
            return true;
        }
    }
}
