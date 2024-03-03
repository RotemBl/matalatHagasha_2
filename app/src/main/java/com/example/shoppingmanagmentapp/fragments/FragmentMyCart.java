package com.example.shoppingmanagmentapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shoppingmanagmentapp.DataFile.DataModle;
import com.example.shoppingmanagmentapp.DataFile.MyData;
import com.example.shoppingmanagmentapp.DataFile.customeAdapter;
import com.example.shoppingmanagmentapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMyCart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMyCart extends Fragment {
    private ListView listView;

    private RecyclerView recycleView ;
    private ArrayList<DataModle> dataSet = null;
    private customeAdapter adapter;
    private LinearLayoutManager layoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentMyCart() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMyCart.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMyCart newInstance(String param1, String param2) {
        FragmentMyCart fragment = new FragmentMyCart();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private Button addToCartButton;
    private Button plusButton;
    private String[] itemsNamesArray = MyData.itemsnamesArray; // Retrieve items from MyData

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_my_cart, container, false);
        // Inflate the layout for this fragment
        //assert getArguments() != null;
       // String userEmailAddr = getArguments().getString("emailAddress");
        //TextView myTextview= view.findViewById(R.id.userNameHeader);
        //myTextview.setText(userEmailAddr);
        recycleView = view.findViewById(R.id.res_2);

        layoutManager = new LinearLayoutManager(getActivity());
        recycleView.setLayoutManager(layoutManager);
        dataSet = new ArrayList<>();


        recycleView.setItemAnimator(new DefaultItemAnimator());

        for(int i = 0; i<MyData.drawableArr.length; i++)
        {
            dataSet.add(new DataModle(
                    MyData.itemsnamesArray[i],
                    MyData.quantityArr[i],
                    MyData.drawableArr[i]

            ));
        }
        adapter = new customeAdapter(dataSet);
        recycleView.setAdapter(adapter);



        return  view;
    }
    }
