package com.example.korinel.onair_03;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.support.v4.app.ActivityCompat;
import android.support.*;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.content.Context.WIFI_SERVICE;


public class MainActivity extends AppCompatActivity {
    final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
    public String ip;
    public String res;
    public String frames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView forres = (TextView)findViewById(R.id.textView2);
        final TextView forframes = (TextView)findViewById(R.id.textView3);
        forres.setText("Choose the resolution");
        forframes.setText("Choose the framerate");
        //установка разрешений для дропдауна
        final Spinner spinner = (Spinner) findViewById(R.id.resolutions);
        String[] resolution_list=new String[]{"176x144","352x288","640x360","640x480","800x600","1280x960"};
        ArrayAdapter<String> AdapterForResolutions= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, resolution_list);
        AdapterForResolutions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(AdapterForResolutions);
        //done
        //устсновка фреймрейта
        final Spinner spinner2 = (Spinner) findViewById(R.id.framerates);
        String[] framerate_list=new String[]{"15","20","25","30"};
        ArrayAdapter<String> AdapterForFrames= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, framerate_list);
        AdapterForFrames.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(AdapterForFrames);
        //done
        //Выбор разрешения на спиннере
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                res = spinner.getSelectedItem().toString();
                res = res.replace('x','-');
                final EditText ipadd =  (EditText)findViewById(R.id.ipAddress);
                WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
                ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
                ip = String.format("rtsp://%s:1234?h264=500000-%s-%s", ip,frames, res);
                ipadd.setText(ip);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //done
        //Выбор фреймрейта на спиннере
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                frames = spinner2.getSelectedItem().toString();
                final EditText ipadd =  (EditText)findViewById(R.id.ipAddress);
                WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
                ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
                ip = String.format("rtsp://%s:1234?h264=500000-%s-%s", ip,frames, res);
                ipadd.setText(ip);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //
        //устновка текста ссылки
        final EditText ipadd =  (EditText)findViewById(R.id.ipAddress);
        WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
        ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        ip = String.format("rtsp://%s:1234?h264=500000-%s-%s", ip,frames, res);
        ipadd.setText(ip);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.RECORD_AUDIO)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECORD_AUDIO},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }



    }

    public void getIp (View view)
    {
        final EditText ipadd =  (EditText)findViewById(R.id.ipAddress);
        WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
        ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        ip = String.format("rtsp://%s:1234?h264=500000-%s-%s", ip,frames, res);
        ipadd.setText(ip);
    }

    public void RtspStart (View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
