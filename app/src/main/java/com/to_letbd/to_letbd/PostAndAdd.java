package com.to_letbd.to_letbd;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class PostAndAdd extends AppCompatActivity implements View.OnClickListener {

    public Button btnsubmit,btnMail,btnLocation;
    public EditText Etcontact,Etmail,EtName,Etlocation,EtDetails;

    public double latitude;
    public double longitude;


    protected LocationManager locationManager;
    boolean isGPSEnable = false;
    boolean isNetworkEnable = false;
    boolean canGetLocation = false;
    private static final long min_distance=10;
    private static final long min_time=5;
    Location location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_and_add);
        ini();
     //   Latiudeandlonglatiude();

    }

    public void ini() {
        btnsubmit= (Button) findViewById(R.id.btnSubmit);
        Etcontact= (EditText) findViewById(R.id.EtContact);
        Etmail= (EditText) findViewById(R.id.EtMail);
        EtName= (EditText) findViewById(R.id.EtName);
        Etlocation= (EditText) findViewById(R.id.EtLocation);
        EtDetails= (EditText) findViewById(R.id.SayDetails);
        btnsubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSubmit:
                String contact=Etcontact.getText().toString();
                String mail=Etmail.getText().toString();
                String name=EtName.getText().toString();
                String location=Etlocation.getText().toString();
                String details=EtDetails.getText().toString();
                AddInformation information=new AddInformation(contact,mail,name,location,details,latitude,longitude);
                MyDatabaseHelper helper=MyDatabaseHelper.getInstance(getApplicationContext());
                long datainsert = helper.datainsert(information);
                if (datainsert!=-1){
                    Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

//    private void Latiudeandlonglatiude() {
//
//
//        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//        isGPSEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//        isNetworkEnable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
//        if (!isGPSEnable && !isNetworkEnable) {
//
//            Toast.makeText(getApplicationContext(), "please turn on location", Toast.LENGTH_SHORT).show();
//        } else {
//            this.canGetLocation = true;
//            if (isNetworkEnable) {
//                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                    // TODO: Consider calling
//                    //    ActivityCompat#requestPermissions
//                    // here to request the missing permissions, and then overriding
//                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                    //                                          int[] grantResults)
//                    // to handle the case where the user grants the permission. See the documentation
//                    // for ActivityCompat#requestPermissions for more details.
//                    return;
//                }
//                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
//                        min_time,min_distance, (LocationListener) this );
//                if (locationManager != null){
//                    location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//                    if (location != null){
////                            latitude =location.getLatitude();
////                            longitude=location.getLongitude();
//                    }
//                }
//            }
//            if (isGPSEnable)
//            {
//                if (location == null){
//                    locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,
//                            min_time,min_distance, (LocationListener) this);
//                    if (locationManager != null){
//                        location= locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//                        if (location != null){
////                                latitude=location.getLatitude();
////                                longitude=location.getLongitude();
//
//                        }
//                    }
//                }
//            }
//        }
//    }
//    public void onLocationChanged(Location location) {
//        Log.e("provider", ""+location.getProvider());
//        Log.e("getLatitude", ""+location.getLatitude());
//        Log.e("getAccuracy", ""+location.getAccuracy());
//        Log.e("getlonglitude", ""+location.getLongitude() );
//        latitude = location.getLatitude();
//        longitude = location.getLongitude();
//}
}