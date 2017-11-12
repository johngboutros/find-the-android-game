package com.example.android.layoutplayspace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Find the Android Game

    int[] imageIds = {R.id.imageView1, R.id.imageView2, R.id.imageView3, R.id.imageView4,
            R.id.imageView5, R.id.imageView6, R.id.imageView7, R.id.imageView8, R.id.imageView9};
    ImageView[] mImages = new ImageView[imageIds.length];
    int winId;

    TextView status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < imageIds.length; i++) {
            mImages[i] = (ImageView) findViewById(imageIds[i]);
            mImages[i].setOnClickListener(new ImageClickListener());
        }

        status = (TextView) findViewById(R.id.status);

        resetGame();
    }

    private class ImageClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            resetStatus();
            int id = view.getId();
            boolean won = winId == id;
            showStatus(won);
            if (won) resetGame();
        }
    }

    private void resetStatus() {
        status.setText("");
    }

    private void showStatus(boolean won) {
        status.setText(won ? "Game Won!" : "Try Again!");
    }

    private void resetGame() {
        winId = imageIds[new Random().nextInt(imageIds.length)];
    }
}
