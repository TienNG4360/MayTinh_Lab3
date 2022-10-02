package com.example.maytinh;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText N1, N2;
    Button BT;
    TextView KQ;
    Spinner Spin;
    String Arr[] = {"+","-","*","/"}; //Tạo mảng chứa các phép toán
    int vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Anhxa();
            TaoSpin();
            BT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KQ.setText("" + Tinh());
                }
            });
        }
        void Anhxa()
        {
            //Lấy các đối tượng từ trong View
            N1 = (EditText)findViewById(R.id.EdtN1);
            N2 = (EditText)findViewById(R.id.EdtN2);
            BT = (Button)findViewById(R.id.BtnKq);
            KQ = (TextView)findViewById(R.id.TxtKq);
            Spin = (Spinner) findViewById(R.id.spinnerPhepTinh);
        }
        void TaoSpin()
        {
            //Gán mảng Arr (data source) vào Adapter
            ArrayAdapter <String> adapter = new ArrayAdapter<String>
                    (this,android.R.layout.simple_spinner_item,Arr);
            //Thiết lập cách hiển thị dữ liệu trong spinner
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
            //Thiết lập adapter cho spinner
            Spin.setAdapter(adapter);
            //Bắt sự kiện khi lựa chọn cho spinner
            Spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    vitri = position;
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    vitri=-1;
                }
            });
        }
        double Tinh()
        {
            double X1 = Double.parseDouble(N1.getText().toString());
            double X2 = Double.parseDouble(N2.getText().toString());
            double Z=0;
            switch (vitri)
            {
                case 0: Z= X1+X2; break;
                case 1: Z= X1-X2; break;
                case 2: Z= X1*X2; break;
                case 3: Z= X1/X2; break;
            }
            return Z;
        }

    }