package com.example.shoppingmanagmentapp.DataFile;

import com.example.shoppingmanagmentapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MyData {
   private static MyData instance;


   public ArrayList<Users> usersArrayList;
   public static ArrayList<CartItems> cartItemsList;

   private MyData() {
      usersArrayList = new ArrayList<>();
      cartItemsList = new ArrayList<>();

   }

  public static String[] itemsnamesArray = {"rice", "milk","weight cheese", "cottage cheese","olive oil","watter","butter","cornflakes","cucumber","salt"};
    public static int[] quantityArr = {1,1,1,1,1,1,1,1,1,1};
 public static Integer[] drawableArr ={R.drawable.rice,R.drawable.milk,R.drawable.white_cheese,R.drawable.cottege_cheese,R.drawable.olive_oil,R.drawable.water,
  R.drawable.butter,R.drawable.corenflakes,R.drawable.cucumber,R.drawable.salt};





   public static synchronized MyData getInstance() {
      if (instance == null) {
         instance = new MyData();
      }
      return instance;
   }

   public void addUser(String addEmail, String addPassword, String addPhoneNum) {
      usersArrayList.add(new Users(addEmail, addPassword, addPhoneNum));
   }

   public ArrayList<Users> getUsersArrayList() {
      return usersArrayList;
   }

   public boolean cheackIfUserExist(String addEmail) {
      for (int i = 0; i < usersArrayList.size(); i++) {

         if (Objects.equals(addEmail, usersArrayList.get(i).getUserEmailAddress())) {
            return true;
         }
      }
      return false;

   }

   public boolean cheackPassword(String addEmail, String addpassword) {
      for (int i = 0; i < usersArrayList.size(); i++) {

         if (Objects.equals(addEmail, usersArrayList.get(i).getUserEmailAddress())) {
            if (Objects.equals(usersArrayList.get(i).getUserPassword(), addpassword)) {
               return true;
            }
         }
      }
      return false;

   }
}