package com.example.hellohomeo.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.hellohomeo.Modal.Modal;

import java.util.List;

@Dao
public interface CrewDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Modal> crewlist);

    @Query("SELECT * FROM crew")
    LiveData<List<Modal>> getallcrew();

    @Query("DELETE FROM crew")
    void deleteAll();

}
