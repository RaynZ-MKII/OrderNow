
package com.example.ordernow.Fragments;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.ordernow.Adapters.Images;
        import com.example.ordernow.Adapters.RecyclerAdapter;
        import com.example.ordernow.Carrinho.Carrinho;
        import com.example.ordernow.R;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.Query;
        import com.google.firebase.database.ValueEventListener;
        import com.google.firebase.storage.FirebaseStorage;
        import com.google.firebase.storage.StorageReference;

        import java.util.ArrayList;

public class FragmentCall extends Fragment {

    ImageView cartimage1;
    Button btn_carrinho1;

    public static String QrMenu;

    View v ;
    private DatabaseReference reference;
    private StorageReference mStorageRef;


    private RecyclerView recyclerView1;

    private ArrayList<Images> imageList;
    private RecyclerAdapter recyclerAdapter;

    public FragmentCall() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.call_fragment, container, false);

        recyclerView1 = v.findViewById(R.id.call_recyclerview);

        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView1.setHasFixedSize(true);

        reference = FirebaseDatabase.getInstance().getReference();

        mStorageRef = FirebaseStorage.getInstance().getReference();

        imageList = new ArrayList<>();




        init();

        btn_carrinho1 = (Button) v.findViewById(R.id.btn_carrinho1);

        btn_carrinho1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Carrinho.class);
                startActivity(i);

            }
        });


        return v;

    }

    private void init() {

        clearAll();

        Query query = reference.child("Images");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    if(snapshot.child("QrMenu").getValue().toString().equals(QrMenu) && snapshot.child("categoria").getValue().toString().equals("2")) {

                        Images images = new Images();

                        images.setUrl(snapshot.child("url").getValue().toString());
                        images.setDescription(snapshot.child("description").getValue().toString());
                        images.setNome(snapshot.child("nome").getValue().toString());
                        images.setPreco(snapshot.child("preco").getValue().toString());

                        imageList.add(images);
                    }

                }

                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getContext(), imageList);
                recyclerView1.setAdapter(recyclerAdapter);

                recyclerAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void clearAll(){

        if(imageList != null){

            imageList.clear();

            if(recyclerAdapter != null){

                recyclerAdapter.notifyDataSetChanged();

            }

        }

        imageList = new ArrayList<>();

    }
}

