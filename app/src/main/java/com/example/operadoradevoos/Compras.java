package com.example.operadoradevoos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Compras#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Compras extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btnConfirmar;
    private Button btnCancelar;
    private Button btnAdd;
    private Button btnSub;
    private TextView valorBase;
    private TextView valorTotal;
    private EditText bags;

    public Compras() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Compras.
     */
    // TODO: Rename and change types and number of parameters
    public static Compras newInstance(String param1, String param2) {
        Compras fragment = new Compras();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compras, container, false);

        btnConfirmar = (Button) view.findViewById(R.id.btnConfirmar);
        btnCancelar = (Button) view.findViewById(R.id.btnCancelar);
        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        btnSub = (Button) view.findViewById(R.id.btnSub);
        valorBase = (TextView) view.findViewById(R.id.valorBase);
        valorTotal = (TextView) view.findViewById(R.id.valorFinal);
        bags = (EditText) view.findViewById(R.id.bags);

        bags.setText("0");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // increase the value of the bags
                int valorBags = Integer.parseInt(bags.getText().toString());
                bags.setText(String.valueOf( valorBags += 1));

                int valor = Integer.parseInt(valorTotal.getText().toString());
                valorTotal.setText(String.valueOf( valor += 8000));
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Subtract the value of the bags
                int valorBags = Integer.parseInt(bags.getText().toString());
                if (valorBags > 0 ) {
                    bags.setText(String.valueOf( valorBags -= 1));
                }

                int valor = Integer.parseInt(valorTotal.getText().toString());
                if (valor > 0 ) {
                    valorTotal.setText(String.valueOf( valor -= 8000));
                }
            }
        });


        return view;
    }
}