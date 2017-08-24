package com.example.aluno.mascaracpf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private TextWatcher cpfMask;
    private TextWatcher cnpjMask;
    private RadioGroup radioGroup;
    private RadioButton rdCNPJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText cpf = (EditText) findViewById(R.id.txtCPF);
        // Armazene seus TextWatcher para posterior uso
        cpfMask = Mask.insert("###.###.###-##", cpf);
        cpf.addTextChangedListener(cpfMask);

        cnpjMask = Mask.insert("##.###.###/####-##", cpf);
        rdCNPJ = (RadioButton) findViewById(R.id.rdCNPJ);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int opcao = radioGroup.getCheckedRadioButtonId();
                if (opcao == rdCNPJ.getId()) {
                    cpf.removeTextChangedListener(cpfMask);
                    cpf.addTextChangedListener(cnpjMask);
                } else {
                    cpf.removeTextChangedListener(cnpjMask);
                    cpf.addTextChangedListener(cpfMask);
                }
            }
        });

    }
}
