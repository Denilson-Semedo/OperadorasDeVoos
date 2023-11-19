package com.example.operadoradevoos;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Perfil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Perfil extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btnEditar;

    private EditText nome;
    private EditText email;
    private EditText identificacao;
    private EditText dataNascimento;



    public Perfil() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Perfil.
     */
    // TODO: Rename and change types and number of parameters
    public static Perfil newInstance(String param1, String param2) {
        Perfil fragment = new Perfil();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        btnEditar = (Button) view.findViewById(R.id.btnEditar);
        nome = (EditText) view.findViewById(R.id.nome);
        email = (EditText) view.findViewById(R.id.email);
        identificacao = (EditText) view.findViewById(R.id.identificacao);
        dataNascimento = (EditText) view.findViewById(R.id.dataNasc);

        getDataFromFirebaseRealtimeDatabase();

        return view;
    }

    public void getDataFromFirebaseRealtimeDatabase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://ilhasairlines-default-rtdb.firebaseio.com");
        DatabaseReference myRef = database.getReference("Utilizadores");

        // get User with id 449
        Query query = myRef.orderByChild("uid").equalTo("tizFkzZ8ANSk9OlXLBxCcBwCHNA3");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String nomeValue = "";
                    String emailValue = "";
                    String identificacaoValue = "";
                    String dataNascimentoValue = "";

                    // Check if the child exists before retrieving its value
                    if (dataSnapshot.child("nome").exists()) {
                        nomeValue = dataSnapshot.child("nome").getValue().toString();
                    }

                    if (dataSnapshot.child("email").exists()) {
                        emailValue = dataSnapshot.child("email").getValue().toString();
                    }

                    if (dataSnapshot.child("identificação").exists()) {
                        identificacaoValue = dataSnapshot.child("identificação").getValue().toString();
                    }

                    if (dataSnapshot.child("dataNascimento").exists()) {
                        // Assuming dataNascimento is a Long, convert it to a String
                        dataNascimentoValue = String.valueOf(dataSnapshot.child("dataNascimento").getValue());
                    }

                    nome.setText(nomeValue);
                    email.setText(emailValue);
                    identificacao.setText(identificacaoValue);
                    dataNascimento.setText(dataNascimentoValue);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}