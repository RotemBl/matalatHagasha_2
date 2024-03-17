package com.example.shoppingmanagmentapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppingmanagmentapp.DataFile.CartItems;
import com.example.shoppingmanagmentapp.DataFile.DataModle;
import com.example.shoppingmanagmentapp.DataFile.MyData;
import com.example.shoppingmanagmentapp.DataFile.customeAdapter;
import com.example.shoppingmanagmentapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShoppingScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingScreenFragment extends Fragment {

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

    public ShoppingScreenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShoppingScreenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShoppingScreenFragment newInstance(String param1, String param2) {
        ShoppingScreenFragment fragment = new ShoppingScreenFragment();
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


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view =  inflater.inflate(R.layout.fragment_shopping_screen, container, false);
        Button addToCartButton = view.findViewById(R.id.addToCardButton);



        assert getArguments() != null;
        String userEmailAddr = getArguments().getString("emailAddress");
        TextView myTextview= view.findViewById(R.id.userNameHeader);
        myTextview.setText(userEmailAddr);
        recycleView = view.findViewById(R.id.res);

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