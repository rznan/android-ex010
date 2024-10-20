package br.com.renan.ex010;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.com.renan.ex010.model.Professor;
import br.com.renan.ex010.model.ProfessorHorista;
import br.com.renan.ex010.model.ProfessorTitular;

/*
* @author: renan santos carvalho
*/
public class MainActivity extends AppCompatActivity {

    private RadioButton rbTitular;
    private RadioButton rbHourly;

    private EditText etName;
    private EditText etId;
    private EditText etIdade;

    private TextView tvSalarioValorHora;
    private EditText etSalarioValorHora;

    private TextView tvHoraAno;
    private EditText etHoraAno;

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        etName = findViewById(R.id.etName);
        etId = findViewById(R.id.etId);
        etIdade = findViewById(R.id.etIdade);


        etHoraAno = findViewById(R.id.etHoraAno);
        tvHoraAno = findViewById(R.id.tvHoraAno);

        etSalarioValorHora = findViewById(R.id.etSalarioValorHora);
        tvSalarioValorHora = findViewById(R.id.tvSalarioValorHora);

        rbTitular = findViewById(R.id.rbTitular);
        rbHourly = findViewById(R.id.rbHourly);
        rbHourly.setChecked(true);
        RadioGroup rgTypes = findViewById(R.id.rgTypes);
        rgTypes.setOnCheckedChangeListener((a, b) -> changeLabels());

        tvResult = findViewById(R.id.tvResult);

        Button btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(e -> calculate());

    }

    private void changeLabels() {
        if(rbTitular.isChecked()) {
            tvSalarioValorHora.setText(R.string.salary_label);
            tvHoraAno.setText(R.string.years_in_institution_label);
        }
        else {
            tvSalarioValorHora.setText(R.string.hours_lesson_label);
            tvHoraAno.setText(R.string.hour_value_label);
        }
    }

    private void calculate() {
        Professor p;

        String name = etName.getText().toString();
        String matricula = etId.getText().toString();
        int idade = Integer.parseInt(etIdade.getText().toString());
        int anosOuHoras = Integer.parseInt(etHoraAno.getText().toString());
        double salarioOuValorHora = Double.parseDouble(etSalarioValorHora.getText().toString());

        if(rbTitular.isChecked()) {
            p = new ProfessorTitular(matricula, name, idade, anosOuHoras, salarioOuValorHora);
        }
        else {
            p = new ProfessorHorista(matricula, name, idade, anosOuHoras, salarioOuValorHora);
        }

        String salaryText = getText(R.string.money_Sign) + String.format("%.2f", p.calcularSalario());
        tvResult.setText(salaryText);
    }
}