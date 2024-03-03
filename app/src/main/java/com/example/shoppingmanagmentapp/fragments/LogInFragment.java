package com.example.shoppingmanagmentapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shoppingmanagmentapp.DataFile.MyData;
import com.example.shoppingmanagmentapp.DataFile.Users;
import com.example.shoppingmanagmentapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LogInFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogInFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LogInFragment() {
        // Required empty public constructor
        myDaya=MyData.getInstance();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LogInFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LogInFragment newInstance(String param1, String param2) {
        LogInFragment fragment = new LogInFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private MyData myDaya;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);



        Button logInbutton = view.findViewById(R.id.logInButton);
        EditText logInEmailtext = view.findViewById(R.id.logInEmailAddress);
        EditText logInPasswordtext = view.findViewById(R.id.logInPassword);
        Button singInButton = view.findViewById(R.id.signInButton);
        EditText singInEmailtext = view.findViewById(R.id.singIntEmailAddress2);
        EditText singInPasswordtext = view.findViewById(R.id.signInPassword2);
        EditText singInphonetext = view.findViewById(R.id.signInTextPhone);



        singInButton.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v1)
            {
                String emailAddr = singInEmailtext.getText().toString();
                String pass = singInPasswordtext.getText().toString();
                String phone = singInphonetext.getText().toString();
                if (myDaya.cheackIfUserExist(emailAddr)== true)
                {
                    Toast.makeText(getContext(), "This email already exists!", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    myDaya.addUser(emailAddr, pass, phone);
                    Toast.makeText(getContext(), "Successful Log In!", Toast.LENGTH_SHORT).show();
                }

            }
    });


        logInbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String stremail = logInEmailtext.getText().toString();
                String strpass = logInPasswordtext.getText().toString();
                if (myDaya.cheackIfUserExist(stremail)== false)
                {
                    Toast.makeText(getContext(), "This email is not exists! please sign in", Toast.LENGTH_SHORT).show();

                }
                else {
                    if(myDaya.cheackPassword(stremail,strpass)==true)
                    {
                        Bundle bundle = new Bundle();
                        bundle.putString("emailAddress",stremail);
                        Navigation.findNavController(view).navigate(R.id.action_logInFragment_to_shoppingScreenFragment,bundle);
                    }
                    else
                    {
                        Toast.makeText(getContext(), "InValid Email or Password", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });


        return view;
    }
}