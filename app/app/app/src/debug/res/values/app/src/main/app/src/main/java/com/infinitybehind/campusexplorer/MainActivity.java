package com.infinitybehind.campusexplorer;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;

import com.infinitybehind.campusexplorer.models.DataModel;

import java.security.Permission;
import java.security.Provider;
import java.util.ArrayList;
import java.util.logging.LoggingPermission;

public class MainActivity extends AppCompatActivity implements LocationListener {
    private TabLayout tablayout;
    private ViewPager viewPager;
    FloatingActionButton locateMeBtn;
    double cur_lat;
    double cur_long;

    private ArrayList<DataModel> classroomList = null;
    private ArrayList<DataModel> labList = null;
    private ArrayList<DataModel> othersList = null;
    private ArrayList<DataModel> facultyList = null;

    SQLiteDatabase db = null;

    /**
     * Location Listener works*/
    String gps_serviceName = Context.LOCATION_SERVICE;

    LocationManager lm;

    String provider;


    private ArrayList<DataModel> classroomsDataSet() {
        /**
         * Here we will generate the Classroom dataset
         **/
        ArrayList<DataModel> classroomDataset = new ArrayList<>();
         //SQL command
        try {
            String sql = "SELECT * FROM campus_15 WHERE type='classroom' ORDER BY floor;";

            if (db != null) {
                Cursor c = db.rawQuery(sql, null);
                while (c.moveToNext()) {
                    Log.e("Check", "PASSED");
                    DataModel dataItem = new DataModel();
                    String place = "CLASSROOM";
                    String roomno = c.getString(1);
                    int floor = c.getInt(5);
                    float lat = c.getFloat(3);
                    float longi = c.getFloat(4);
                    Log.e("LONG FROM DATABASE: ", "" + longi);
                    int sno = c.getInt(0);
                    String avatarName = "classroom";

                    System.out.println("FLOOR : " + floor);

                    dataItem.setAvatarName(avatarName);
                    dataItem.setFloor(floor);
                    dataItem.setLatitude(lat);
                    dataItem.setLongitude(longi);
                    dataItem.setPlaceName(place);
                    dataItem.setRoomNo(roomno);
                    classroomDataset.add(dataItem);
                    Log.d("SET : ", "Success");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return classroomDataset;
    }

    private ArrayList<DataModel> labDataSet() {
        ArrayList<DataModel> dataset = new ArrayList<>();

        if (db != null) {
            try {
                String sql = "SELECT * FROM campus_15 WHERE type='lab' ORDER BY floor;";
                Cursor c = db.rawQuery(sql, null);

                while (c.moveToNext()) {
                    Log.e("Check", "PASSED");
                    DataModel dataItem = new DataModel();
                    String place = "LAB";
                    String roomno = c.getString(1);
                     int floor = c.getInt(5);
                    float lat = c.getFloat(3);
                    float longi = c.getFloat(4);
                    int sno = c.getInt(0);
                    String avatarName = "lab";

                    System.out.println("FLOOR : " + floor);

                    dataItem.setAvatarName(avatarName);
                    dataItem.setFloor(floor);
                    dataItem.setLatitude(lat);
                    dataItem.setLatitude(longi);
                    dataItem.setPlaceName(place);
                    dataItem.setRoomNo(roomno);

                    dataset.add(dataItem);
                    Log.d("SET : ", "Success");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return dataset;
    }

    private ArrayList<DataModel> othersDataSet() {
        /**
         * Here we will generate the Others dataset
         * */
        ArrayList<DataModel> othersDataset = new ArrayList<>();
        //SQL command
       try {
            String sql = "SELECT * FROM campus_15 WHERE type='classroom' ORDER BY floor;";

            if (db != null) {
                Cursor c = db.rawQuery(sql, null);
                while (c.moveToNext()) {
                    Log.e("Check", "PASSED");
                    DataModel dataItem = new DataModel();
                    String place = "CLASSROOM";
                    String roomno = c.getString(1);
                    int floor = c.getInt(5);
                    float lat = c.getFloat(3);
                    float longi = c.getFloat(4);
                    Log.e("LONG FROM DATABASE: ", "" + longi);
                    int sno = c.getInt(0);
                    String avatarName = "classroom";

                    System.out.println("FLOOR : " + floor);

                    dataItem.setAvatarName(avatarName);
                     dataItem.setFloor(floor);
                    dataItem.setLatitude(lat);
                    dataItem.setLongitude(longi);
                    dataItem.setPlaceName(place);
                    dataItem.setRoomNo(roomno);

                    classroomDataset.add(dataItem);
                    Log.d("SET : ", "Success");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return classroomDataset;
    }

    private ArrayList<DataModel> labDataSet() {
        ArrayList<DataModel> dataset = new ArrayList<>();

        if (db != null) {
            try {
                String sql = "SELECT * FROM campus_15 WHERE type='lab' ORDER BY floor;";
                Cursor c = db.rawQuery(sql, null);

 while (c.moveToNext()) {
                    Log.e("Check", "PASSED");
                    DataModel dataItem = new DataModel();
                    String place = "LAB";
                    String roomno = c.getString(1);
                    int floor = c.getInt(5);
                    float lat = c.getFloat(3);
                    float longi = c.getFloat(4);
                    int sno = c.getInt(0);
                    String avatarName = "lab";

                    System.out.println("FLOOR : " + floor);

                    dataItem.setAvatarName(avatarName);
                    dataItem.setFloor(floor);
                    dataItem.setLatitude(lat);
                    dataItem.setLatitude(longi);
                    dataItem.setPlaceName(place);
                    dataItem.setRoomNo(roomno);

                    dataset.add(dataItem);
                    Log.d("SET : ", "Success");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                }
        }
        return dataset;
    }

    private ArrayList<DataModel> othersDataSet() {
        /**
         * Here we will generate the Others dataset
         * */
        ArrayList<DataModel> othersDataset = new ArrayList<>();
        //SQL command
        try {
            String sql = "SELECT * FROM campus_15 WHERE type='others' ORDER BY floor;";

            if (db != null) {
                Cursor c = db.rawQuery(sql, null);
                while (c.moveToNext()) {
                    Log.e("Check", "PASSED");
                    DataModel dataItem = new DataModel();
                    String place = c.getString(6);
                    String roomno = c.getString(1);
                    int floor = c.getInt(5);
                    float lat = c.getFloat(3);
                    float longi = c.getFloat(4);
                    int sno = c.getInt(0);
                    String avatarName = "others";
                    System.out.println("FLOOR : " + floor);

                    dataItem.setAvatarName(avatarName);
                    dataItem.setFloor(floor);
                    dataItem.setLatitude(lat);
                    dataItem.setLatitude(longi);
                    dataItem.setPlaceName(roomno);
                    dataItem.setRoomNo(place);

                    othersDataset.add(dataItem);
                    Log.d("SET : ", "Success");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return othersDataset;
    }


    private ArrayList<DataModel> facultyDataSet() {
        /**
         * Here we will generate the Faculty dataset
         * */
        ArrayList<DataModel> facultyDataset = new ArrayList<>();
           //SQL command
        try {
            String sql = "SELECT * FROM campus_15 WHERE type='office' ORDER BY floor;";

            if (db != null) {
                Cursor c = db.rawQuery(sql, null);
                while (c.moveToNext()) {
                    Log.e("Check", "PASSED");
                    DataModel dataItem = new DataModel();
                    String place = c.getString(6);
                    String roomno = c.getString(1);
                    int floor = c.getInt(5);
                    float lat = c.getFloat(3);
                    float longi = c.getFloat(4);
                    int sno = c.getInt(0);
                    String avatarName = "avatar"+sno;

                    System.out.println("FLOOR : " + floor);

                    dataItem.setAvatarName(avatarName);
                    dataItem.setFloor(floor);
                    dataItem.setLatitude(lat);
                    dataItem.setLatitude(longi);
                    dataItem.setPlaceName(roomno);
                    dataItem.setRoomNo(place);

                   facultyDataset.add(dataItem);
                    Log.d("SET : ", "Success");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
             }
        return facultyDataset;
    }

    private void creatingDataSets() {
        db = openOrCreateDatabase("campusExplorerDB", 0, null);

        //Generating the Datasets
        classroomList = classroomsDataSet();
        labList = labDataSet();
        othersList = othersDataSet();
        facultyList = facultyDataSet();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Requesting Permissions
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, 1);


        // Linking Locate me Button
        locateMeBtn = findViewById(R.id.floatingActionButton);
        //Linking the tab layout ans pager layout
          tablayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view2);

        //Setting tabs title
        tablayout.addTab(tablayout.newTab().setText("Classroom"));
        tablayout.addTab(tablayout.newTab().setText("Labs"));
        tablayout.addTab(tablayout.newTab().setText("Faculty"));
        tablayout.addTab(tablayout.newTab().setText("Others"));

        creatingDataSets();

        //Setting the view Pages
        final PagerAdapter adapter = new com.infinitybehind.campusexplorer.adapters.PagerAdapter(
                getSupportFragmentManager(), tablayout.getTabCount(),
                classroomList, labList, othersList,facultyList);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        //Setting Click Listener

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
@Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        /**
         * For Location */
        lm = (LocationManager) getSystemService(gps_serviceName);
        provider = lm.getBestProvider(new Criteria(), false);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = lm.getLastKnownLocation(provider);
        
        if (location != null) {
            //We got the location
            Log.e("LOCATION : ", "Achieved");
        } else {
            Log.e("LOCATION : ", "No Location");
        }
        lm.requestLocationUpdates(provider, 400, 0.5f, this);
        // OnClick method for findMe Button
        locateMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+cur_lat+","+cur_long+"(You Are here.)"));
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
  lm.requestLocationUpdates(provider, 400, 0.5f, this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

        }
    }
    // other 'case' lines to check for other
    // permissions this app might request


    @Override
    protected void onPause() {
        super.onPause();

    //Stop using the location updates to save battery
    lm.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        cur_lat = location.getLatitude();
        cur_long = location.getLongitude();
        Log.e("Curent LAT : ",""+cur_lat);
        Log.e("Current LONG", ""+cur_long);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {
}
}
                while (c.moveToNext()) {
                    
