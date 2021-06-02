package com.example.hellohomeo.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.hellohomeo.Dao.CrewDao;
import com.example.hellohomeo.Database.CrewDatabase;
import com.example.hellohomeo.Modal.Modal;

import java.util.List;


public class CrewRepository {
    private CrewDatabase database;
    private LiveData<List<Modal>> getallcrew;

    public CrewRepository(Application application) {
        database = CrewDatabase.getInstance(application);
        getallcrew = database.crewDao().getallcrew();
    }

    public void insert(List<Modal> crewlist) {
new InsertAsyncTask(database).execute(crewlist);
    }

    public LiveData<List<Modal>> getallcrew() {
        return getallcrew;
    }
    public void deleteAll()  {
        new deleteAllWordsAsyncTask(database.crewDao()).execute();
    }

   static  class InsertAsyncTask extends AsyncTask<List<Modal> ,Void ,Void>{

        private CrewDao crewDao;
        InsertAsyncTask(CrewDatabase crewDatabase){
            crewDao=crewDatabase.crewDao();
        }
        @Override
        protected Void doInBackground(List<Modal>... lists) {
            crewDao.insert(lists[0]);
            return null;
        }
    }
    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private CrewDao mAsyncTaskDao;

        deleteAllWordsAsyncTask(CrewDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }
}
