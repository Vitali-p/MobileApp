package vitali.appnr1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    Button GoogleMapBut = null, GoogleStreetBut = null, WifiSettBut = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initiate the layout doby of XML file.
        setContentView(R.layout.activity_intent);


        //Get object from XLM file by ID.
        GoogleMapBut = (Button) findViewById(R.id.buttonImplicitteMap);
        GoogleStreetBut = (Button) findViewById(R.id.buttonImplicitteStreet);
        WifiSettBut = (Button) findViewById(R.id.buttonImplicitteWifi);

        GoogleMapBut.setOnClickListener(this);
        GoogleStreetBut.setOnClickListener(this);
        WifiSettBut.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        // Write and use 3 different intents.
        // The Implicit intents, used in a external phone activities.
        try{
            // Execute Implicit intents.
            if(v == GoogleMapBut){
                Intent intentGoogleMap = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:55.7855742,12.5191923?z=12"));
                startActivity(intentGoogleMap);
            }
            else if(v == GoogleStreetBut){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll=55.782093,12.5173112")));
            }
            else if (v == WifiSettBut){
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        } catch (ActivityNotFoundException e){
            // See app error on screen.
            Toast.makeText(this, "You are missing tools in your device:\n" + e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }
}
