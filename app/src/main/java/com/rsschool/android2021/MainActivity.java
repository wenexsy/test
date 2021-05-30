package com.rsschool.android2021;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements FirstFragment.onActionFirstFragment,
        SecondFragment.onActionSecondFragment {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFirstFragment(0);
    }

    private void openFirstFragment(int previousNumber) {
        final Fragment firstFragment = FirstFragment.newInstance(previousNumber);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, firstFragment);
        transaction.commit();

    }

    private void openSecondFragment(int min, int max) {
        final Fragment secondFragment = SecondFragment.newInstance(min,max);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,secondFragment);
        transaction.commit();

    }

    @Override
    public void onActionPerformed(int min, int max) {
        openSecondFragment(min,max);
    }

    @Override
    public void onActionPerformed(@NotNull int result) {
        openFirstFragment(result);
    }
}

        //transaction.commit();
         // min_value = (EditText)findViewById(R.id.min_value);
        //  textView = (TextView)findViewById(R.id.result);
        //  max_value = (EditText) findViewById(R.id.max_value);
        //  back = (Button) findViewById(R.id.back);
        //  result = (TextView) findViewById(R.id.result);
        //  result_label = (TextView) findViewById(R.id.result_label);

