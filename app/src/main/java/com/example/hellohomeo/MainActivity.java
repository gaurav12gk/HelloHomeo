package com.example.hellohomeo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellohomeo.Modal.Modal;
import com.example.hellohomeo.Repository.CrewRepository;
import com.example.hellohomeo.ViewModal.CrewViewModal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
 Adapter adapter;
 List<Modal> crewlist;
private CrewViewModal crewViewModal;
private CrewRepository crewRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        crewlist=new ArrayList<>();
        crewRepository=new CrewRepository(getApplication());
        crewViewModal=new ViewModelProvider(this).get(CrewViewModal.class);
        adapter=new Adapter(crewlist,this);
        recyclerView.setAdapter(adapter);
        crewViewModal.getallcrew().observe(this, new Observer<List<Modal>>() {
            @Override
            public void onChanged(List<Modal> modals) {
                adapter.getallcrew(modals);
            recyclerView.setAdapter(adapter);
                Log.d("sdf", "onChanged: "+modals);
            }
        });
        gettingdata();

    }

    private void gettingdata() {
        api myapi = Retrofit.getRetro().create(api.class);
        Call<List<Modal>> call = myapi.getmodel();
        call.enqueue(new Callback<List<Modal>>() {
            @Override
            public void onResponse(Call<List<Modal>> call, Response<List<Modal>> response) {
                if (response.isSuccessful()) {
                    crewRepository.insert(response.body());





//                    List<Modal> list = response.body();
//                //adapter=new Adapter(list);
//                recyclerView.setAdapter(adapter);
//                    Log.d("sdf", "onResponse: "+list.get(0).getImage());
                }
            }

            @Override
            public void onFailure(Call<List<Modal>> call, Throwable t) {

            }
        });
    }
}