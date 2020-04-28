package ir.sajjadyosefi.android.backgroundservicesinandroidoreo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class CounterService extends IntentService {
    final Handler mHandler = new Handler();
    private static final String TAG = "CounterService";

    public CounterService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        showToast("Job Execution Started");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int maxCount = intent.getIntExtra("maxCountValue", -1);
        /**
         * Suppose we are performing task 1 to 1000, Each task will takes time 1 sec , So You saw we sleep thread or one second.
         */
        for (int i = 0; i < maxCount; i++) {
            Log.d(TAG, "onHandleWork: The number is: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Helper for showing tests
    void showToast(final CharSequence text) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(CounterService.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
