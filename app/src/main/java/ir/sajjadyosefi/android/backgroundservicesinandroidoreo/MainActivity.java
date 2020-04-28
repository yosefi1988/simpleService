package ir.sajjadyosefi.android.backgroundservicesinandroidoreo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartIntentService(View view) {
        Intent mIntent = new Intent(MainActivity.this, CounterService.class);
        mIntent.putExtra("maxCountValue", 1000);
        startService(mIntent);
    }
}
