package com.example.akhil.pizzaapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        PizzaListAdapter adapter = new PizzaListAdapter(this);
        mListPizza.setAdapter(adapter);
    }

    @Override
    public void onItemCallBack() {
        FragmentTransaction ft =getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container_fragment,new PizzaDetailsFragment(),"").addToBackStack(null).commit();}
}
