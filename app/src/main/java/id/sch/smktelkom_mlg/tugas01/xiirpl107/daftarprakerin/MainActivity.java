package id.sch.smktelkom_mlg.tugas01.xiirpl107.daftarprakerin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nama;
    EditText sekolah;
    TextView hasil,JK,K,Ke;
    Button buttonOK;
    RadioButton rbL, rbP;
    CheckBox cbPD, cbDG, cbPI;
    Spinner kelas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText) findViewById(R.id.editTextNama);
        sekolah = (EditText) findViewById(R.id.editTextSekolah);
        hasil = (TextView) findViewById(R.id.textViewHasil);
        buttonOK = (Button) findViewById(R.id.buttonSubmit);
        rbL = (RadioButton) findViewById(R.id.radioButtonL);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);
        cbPD = (CheckBox) findViewById(R.id.checkBoxPD);
        cbDG = (CheckBox) findViewById(R.id.checkBoxDG);
        cbPI = (CheckBox) findViewById(R.id.checkBoxPI);
        kelas = (Spinner) findViewById(R.id.spinnerKelas);
        JK = (TextView) findViewById(R.id.textViewJK);
        K = (TextView) findViewById(R.id.textViewK);
        Ke = (TextView) findViewById(R.id.textViewKe);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();


            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String Hasil = null;
            String HasilK = "Keterampilan     : \n";
            String Nama = nama.getText().toString();
            String Sekolah = sekolah.getText().toString();
            String Kelas = kelas.getSelectedItem().toString();
            if (rbP.isChecked()) {
                Hasil = rbP.getText().toString();
            } else if (rbL.isChecked()) {
                Hasil = rbL.getText().toString();
            }
            if (cbPD.isChecked()) HasilK += cbPD.getText() + "\n";
            if (cbDG.isChecked()) HasilK += cbDG.getText() + "\n";
            if (cbPI.isChecked()) HasilK += cbPI.getText() + "\n";

            if (Hasil == null || HasilK == null || Nama == null || Sekolah == null || Kelas == null) {
                hasil.setText("ISI SEMUANYA!!!");
            } else {
                hasil.setText("Nama                 : " + Nama +
                        "\nSekolah              : " + Sekolah +
                        "\nJenis Kelamin   : " + Hasil +
                        "\n" + HasilK +
                        "Kelas                  : " + Kelas);
                ;
            }
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String Nama2 = nama.getText().toString();
        String Sekolah2 = sekolah.getText().toString();
        String Kelas2 = kelas.getSelectedItem().toString();
        String rbPe = rbP.getText().toString();
        String rbLa = rbP.getText().toString();
        String cbPD2 = cbPD.getText().toString();
        String cbDG2 = cbDG.getText().toString();
        String cbPI2 = cbPI.getText().toString();
        if(Nama2.isEmpty()){
            nama.setError("Nama belum diisi");
            valid = false;
        }
        if(Sekolah2.isEmpty()){
            sekolah.setError("Sekolah belum diisi");
            valid = false;
        }
        if(rbPe.isEmpty() || rbLa.isEmpty()){
            JK.setError("Pilih salah satu");
            valid = false;
        }
        if(cbDG2.isEmpty() || cbPD2.isEmpty() || cbPI2.isEmpty()){
            K.setError("Silahkan dipilih!");
            valid = false;
        }
        if(Kelas2.isEmpty()){
            Ke.setError("Kelas belum diisi");
            valid = false;
        }
        return valid;
    }
}


