package com.dam.proyectoandroid.Controlador;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dam.proyectoandroid.Login;
import com.dam.proyectoandroid.LoginFragment;
import com.dam.proyectoandroid.Register;
import com.dam.proyectoandroid.RegisterFragment;

public class PageController extends FragmentPagerAdapter {
    int numoftabs;

    public PageController(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numoftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LoginFragment();
            case 1:
                return new RegisterFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}
