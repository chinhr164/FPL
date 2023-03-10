package com.zrapp.imgdownload;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class GPS extends AppCompatActivity {

    TextView tvGPS;
    String TAG = "KiemtraGPS";
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        tvGPS = findViewById(R.id.tvGPS);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    ActivityResultLauncher<String[]> locationPermissionRequest =
            registerForActivityResult(new ActivityResultContracts
                            .RequestMultiplePermissions(), result -> {
                        Boolean fineLocationGranted = result.getOrDefault(
                                Manifest.permission.ACCESS_FINE_LOCATION, false);
                        Boolean coarseLocationGranted = result.getOrDefault(
                                Manifest.permission.ACCESS_COARSE_LOCATION, false);
                        if (fineLocationGranted != null && fineLocationGranted) {
                            // Precise location access granted.
                            Log.d(TAG, "Đã cấp quyền vị trí chính xác tuyệt đối");

                        } else if (coarseLocationGranted != null && coarseLocationGranted) {
                            // Only approximate location access granted.
                            Log.d(TAG, "Đã cấp quyền vị trí chính xác tương đối");

                        } else {
                            // No location access granted.
                            Log.d(TAG, "Bị từ chối cấp quyền vị trí");
                        }
                    }
            );

    @Override
    protected void onResume() {
        super.onResume();
        //Lấy vị trí
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            locationPermissionRequest.launch(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            });
            return;
        }

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object

                            Log.d(TAG, "onSuccess: Tọa độ: lat = " + location.getLatitude());
                            Log.d(TAG, "onSuccess: lng = " + location.getLongitude());

                            // tạo chuỗi hiển thị trên web
                            String gps = "http://www.google.com/maps/search/?api=1&query=" + location.getLatitude() + "%2C" + location.getLongitude();
                            tvGPS.setText(gps);

                        } else {
                            Log.d(TAG, "onSuccess: Location null ");
                        }
                    }
                });
    }
}