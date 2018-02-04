package www.heartfilia.com.madun;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashScreen extends Activity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logo = (ImageView)findViewById(R.id.imageView);

        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                    logo = (ImageView)findViewById(R.id.imageView);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashScreen.this,Login.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
