package com.codes.tugas9wildanromiza.ui.dashboard;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.codes.tugas9wildanromiza.DetailActivity;
import com.codes.tugas9wildanromiza.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private TextView topBar;
    private TextInputLayout textInputLayout;
    private EditText etNama;
    private TextInputLayout textInputLayout2;
    private EditText etNim;
    private TextInputLayout textInputLayout3;
    private EditText etTtl;
    private TextView textView2;
    private RadioGroup radioGroup;
    private RadioButton laki;
    private RadioButton perempuan;
    private Button button;
    Calendar myCalendar;
    View root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initView();
        myCalendar= Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        etTtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton radioButton;
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = root.findViewById(selectedId);

                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("nama",etNama.getText().toString());
                intent.putExtra("nim",etNim.getText());
                intent.putExtra("ttl",etTtl.getText().toString());
                intent.putExtra("jk",radioButton.getText().toString());
                startActivity(intent);

            }
        });



        return root;
    }

    private void initView() {
        topBar =  root.findViewById(R.id.top_bar);
        textInputLayout =  root.findViewById(R.id.textInputLayout);
        etNama = root.findViewById(R.id.et_nama);
        textInputLayout2 =root.findViewById(R.id.textInputLayout2);
        etNim = root.findViewById(R.id.et_nim);
        textInputLayout3 = root.findViewById(R.id.textInputLayout3);
        etTtl =root. findViewById(R.id.et_ttl);
        textView2 =  root.findViewById(R.id.textView2);
        radioGroup = root.findViewById(R.id.radioGroup);
        laki = root.findViewById(R.id.laki);
        perempuan = root. findViewById(R.id.perempuan);
        button = root. findViewById(R.id.button);
    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etTtl.setText(sdf.format(myCalendar.getTime()));
    }
}