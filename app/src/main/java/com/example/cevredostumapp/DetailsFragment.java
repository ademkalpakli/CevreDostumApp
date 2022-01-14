package com.example.cevredostumapp;
//ademkalpakli
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String EVENTS = "event";


    // TODO: Rename and change types of parameters
    private  Events event;





    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //* @param Events event
     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(Events event) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(EVENTS, event);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            event = getArguments().getParcelable(EVENTS);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView txtName = (TextView)view.findViewById(R.id.txtEventName);
        txtName.setText(event.getName());

        TextView txtDate = (TextView)view.findViewById(R.id.txtDate);
        txtDate.setText(event.getDate());

        TextView txtTime = (TextView)view.findViewById(R.id.txtTime);
        txtTime.setText(Double.toString(event.getTime()));


        TextView txtLocation = (TextView)view.findViewById(R.id.txtLocation);
        txtLocation.setText(event.getLocation());

        TextView txtDescription = (EditText)view.findViewById(R.id.txtDescription);
        txtDescription.setText(event.getDescription());
        txtDescription.setEnabled(false);


        TextView txtUserNum = (TextView)view.findViewById(R.id.txtUserNum);
        txtUserNum.setText(Integer.toString(event.getUserNum()));

    }
}