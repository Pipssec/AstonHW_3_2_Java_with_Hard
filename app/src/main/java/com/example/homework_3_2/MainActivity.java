package com.example.homework_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.homework_3_2.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ImageView imageLoadLibrary = binding.imageViewPictureLibrary;
        EditText editTextUrl = binding.websiteEdittext;
        editTextUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editTextUrl.getText().toString();
                Uri picture = Uri.parse(url);
                Picasso.Builder builder = new Picasso.Builder(MainActivity.this);
                builder.listener(new Picasso.Listener()
                {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
                    {
                        exception.printStackTrace();
                        Toast toast = Toast.makeText(MainActivity.this, "Image load failed", Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
                builder.build().load(picture).into(imageLoadLibrary);
            }
        });
    }
}