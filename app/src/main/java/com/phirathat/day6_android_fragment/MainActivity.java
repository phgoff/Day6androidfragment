package com.phirathat.day6_android_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private Button btnDelete;
    private Button btnAdd;
    private String TAG = "MyFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ---- Context ----
//        WindowManager wm =  (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
//        Display display = wm.getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        System.out.println("Size " + size);
//        //String str = this.getResources().getString(R.string.app_name);
//        String str = getApplicationContext().getResources().getString(R.string.app_name);
//        System.out.println("App name: " + str);
//
//        Toast.makeText(this,"Hello", Toast.LENGTH_SHORT).show();

//        Intent intent = new Intent(this, SecondActivity.class);
//        startActivity(intent);

        //ถ้ามีการเรียกใช้ Object ใหม่ เช่น Onclick
        //จะใช้ this ไม่ได้ เพราะมันเรียก Activity ตัวใหม่ที่เพิ่งสร้างมาจาก new View. ...
        //ให้ใช้ getApplicationContext(); หรืแ Main.class
        // ---- Context ----
        EdittvFragment1();
        //replace_javafragment();

        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.javaFragment,
                                OneFragment.newInstance("Send Success"),
                                TAG )
                        .addToBackStack("MyStack")
                        .commit();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag(TAG);
                if(fragment != null) {
                    getSupportFragmentManager().popBackStack();
                    Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
                }

//                onBackPressed();

//                Fragment fragment = getSupportFragmentManager().findFragmentByTag(TAG);
//                if(fragment != null) {
//                    getSupportFragmentManager()
//                            .beginTransaction()
//                            .remove(fragment)
//                            .commit();
//                }

            }
        });

    }

    private void replace_javafragment() {
        JavaFragment fragment = new JavaFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.javaFragment, fragment);
        transaction.commit();
    }

    private void EdittvFragment1() {
        FragmentManager fm = getSupportFragmentManager();
        BlankFragment blankFragment = (BlankFragment) getSupportFragmentManager().findFragmentById(R.id.fragment );
        TextView tvf1 =  (TextView) blankFragment.getView().findViewById(R.id.tv1_blank);
        tvf1.setText("Blank fragment");
    }
}
