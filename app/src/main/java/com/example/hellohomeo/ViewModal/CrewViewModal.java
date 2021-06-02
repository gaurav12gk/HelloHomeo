package com.example.hellohomeo.ViewModal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hellohomeo.Modal.Modal;
import com.example.hellohomeo.Repository.CrewRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CrewViewModal  extends AndroidViewModel {
    private CrewRepository crewRepository;
    private LiveData<List<Modal>> getallcrew;

    public CrewViewModal(@NonNull @NotNull Application application) {
        super(application);
        crewRepository=new CrewRepository(application);
        getallcrew=crewRepository.getallcrew();
    }
public void insert(List<Modal> list )
{
    crewRepository.insert(list);
}
public LiveData<List<Modal>> getallcrew(){
            return getallcrew;
}
}
