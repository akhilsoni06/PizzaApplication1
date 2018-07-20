package com.example.akhil.pizzaapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class PizzaListFragment extends Fragment implements ItemClickListener {

    private RecyclerView mListPizza;
    private LinearLayoutManager mLinearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_layout, container, false);
        initViews(view);
        return view;
    }


    private void initViews(View view) {
        mListPizza = (RecyclerView) view.findViewById(R.id.list_pizza);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mListPizza.setLayoutManager(mLinearLayoutManager);
        setAdapter();
    }


    private void setAdapter() {

        String jsonStr = getAssetJsonData(getActivity());
        PizzaList pizzaList = new Gson().fromJson(jsonStr, PizzaList.class);

        Log.d("pizza list","size="+pizzaList.pizza.size());
        PizzaListAdapter adapter = new PizzaListAdapter(this);
        mListPizza.setAdapter(adapter);
    }

    @Override
    public void onItemCallBack() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container_fragment, new PizzaDetailsFragment(), "").addToBackStack(null).commit();
    }


    public static String getAssetJsonData(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("pizzalist.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Log.e("data", json);
        return json;

    }
}
