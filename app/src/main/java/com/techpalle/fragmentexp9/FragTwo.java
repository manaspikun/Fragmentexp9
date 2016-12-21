package com.techpalle.fragmentexp9;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragTwo extends Fragment {
ArrayList<Employee>a1;
    MyAdapter myAdapter;
    ListView lv1;
    public void catchData(String eno,String ename,String esal){
        //pass this data to arraylist
        Employee employee=new Employee(eno,ename,esal);
        a1.add(employee);

        //tell to adapter
        myAdapter.notifyDataSetChanged();

    }
    private class MyAdapter extends BaseAdapter{
        
        @Override
        public int getCount() {
            return a1.size();
        }

        @Override
        public Object getItem(int position) {
            return a1.get(position);
        }


        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Employee e=a1.get(position);
            View v=getActivity().getLayoutInflater().inflate(R.layout.row,null);
            TextView tv1= (TextView) v.findViewById(R.id.textView1);
            TextView tv2= (TextView) v.findViewById(R.id.textView2);
            TextView tv3= (TextView) v.findViewById(R.id.textView3);
            CheckBox cb= (CheckBox) v.findViewById(R.id.checkBox);
            tv1.setText(e.getEno());
            tv2.setText(e.getEname());
            tv3.setText(e.getEsal());
            return v;

        }
    }


    public FragTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_frag_two, container, false);
        lv1= (ListView) v.findViewById(R.id.listview1);
        a1=new ArrayList<Employee>();
        myAdapter=new MyAdapter();
        lv1.setAdapter(myAdapter);

        return v;
    }

}
