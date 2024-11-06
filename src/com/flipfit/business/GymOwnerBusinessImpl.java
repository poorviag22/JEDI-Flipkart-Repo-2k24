package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymSlots;

public class GymOwnerBusinessImpl implements GymOwnerBusiness {
    public void registerCenter(){
      System.out.println("Registering Gym Center...");
    }
    public void addnewSlot(){
      System.out.println("Adding new slot...");
    }
    public void deleteSlot(){
     System.out.println("Deleting slot...");
    }
    public void deleteCenter(){
  System.out.println("Deleting center...");
    }
    public void editProfile()
    {
      System.out.println("Editing profile...");
    }
    public void viewReport()
    {
System.out.println("Viewing report...");
    }
}
