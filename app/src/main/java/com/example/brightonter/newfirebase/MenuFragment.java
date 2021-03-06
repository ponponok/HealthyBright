package com.example.brightonter.newfirebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.brightonter.newfirebase.weight.WeightFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brightonter on 9/8/2018.
 */

public class MenuFragment extends Fragment {
    String[] list = {"BMI", "WEIGHT", "SETUP"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayAdapter<String> _menuAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
        ListView _menuList = (ListView) getView().findViewById(R.id.menu_list);
        _menuList.setAdapter(_menuAdapter);
        _menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (_menuAdapter.getItem(position).equals("BMI")){
                    Log.d("System", "[MenuFragment] Go to BMI");
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new BmiFragment())
                            .addToBackStack(null)
                            .commit();
                }else if(_menuAdapter.getItem(position).equals("WEIGHT")){
                    Log.d("System", "[MenuFragment] Go to WEIGHT");
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new WeightFragment())
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
    }
}
