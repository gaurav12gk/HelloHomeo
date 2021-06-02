package com.example.hellohomeo.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.hellohomeo.Dao.CrewDao;
import com.example.hellohomeo.Modal.Modal;

import org.jetbrains.annotations.NotNull;

@Database(entities = {Modal.class},version = 3)
public abstract  class CrewDatabase extends RoomDatabase {

    private static final String DATABASE_NAME ="CrewDatabase";

    public abstract CrewDao crewDao();

    private  static volatile CrewDatabase INSTANCE;

    public static CrewDatabase getInstance(Context context)
    {
            if(INSTANCE==null)
            {
                synchronized (CrewDatabase.class){
                    if(INSTANCE==null){
                        INSTANCE= Room.databaseBuilder(context,CrewDatabase.class,DATABASE_NAME).
                                fallbackToDestructiveMigration().
                                addCallback(callback).
                                build();
                    }
                }
            }return INSTANCE;
    }

  static   Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsync(INSTANCE);

        }
    };
    static class PopulateAsync extends AsyncTask<Void,Void,Void>{
        private CrewDao crewDao;
PopulateAsync( CrewDatabase crewDatabase){
crewDao=crewDatabase.crewDao();

}
        @Override
        protected Void doInBackground(Void... voids) {
    crewDao.deleteAll();
            return null;
        }
    }
}
