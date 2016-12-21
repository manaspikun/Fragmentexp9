package com.techpalle.fragmentexp9;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add frament 1 to fragment2 to container 2
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();


        FragOne f1=new FragOne();
        FragTwo f2=new FragTwo();

        fragmentTransaction.add(R.id.container1,f1);
        fragmentTransaction.add(R.id.container2,f2,"frag2");//tag is generally string
        //tag is used to re-retrieve a fragment at later point of time
        fragmentTransaction.commit();
    }
    public void PassData(String eno,String ename,String esal){
        //pass data to 2nd fragment(wrong approac)
        // Bundle bundle=new Bundle();
        // bundle.putString("eno",eno);
        // bundle.putString("ename",ename);
        // bundle.putString("esal",esal);
        // FragTwo f2=new FragTwo();
        //f2.setarguments(bundle);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragTwo f2= (FragTwo) fragmentManager.findFragmentByTag("frag2");
        //we have to pass data to f2
        f2.catchData(eno,ename,esal);
    }
}

