package com.example.aidlsampleapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aidlsampleapp.EventBus;
import com.example.aidlsampleapp.Events;
import com.example.aidlsampleapp.R;
import com.squareup.otto.Subscribe;

/**
 * Created by Ajeena on 30-10-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 */
public class UserFragment extends Fragment {
View v;
TextView message;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.user_layout, container, false);
        message = v.findViewById(R.id.message);
        return v;

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getBus().register(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setClickListener(view);
    }

    public void setClickListener(final View view) {
        Button btnSubmit = (Button) view.findViewById(R.id.submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageToActivity();
            }
        });
    }

    private void sendMessageToActivity() {
        Events.FragmentActivityMessage fragmentActivityMessageEvent =
                new Events.FragmentActivityMessage("kunju");

        EventBus.getBus().post(fragmentActivityMessageEvent);
    }

    @Subscribe
    public void getMessage(Events.ActivityFragmentMessage activityFragmentMessage) {
     //Toast.makeText(getActivity(),activityFragmentMessage.getMessage(),Toast.LENGTH_SHORT).show();
     message.setText(activityFragmentMessage.getMessage());
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getBus().unregister(this);
    }
}
