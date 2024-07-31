package my.utm.ip.lowcarbon.models.recycle.recycleRepo;

import java.util.List;

import my.utm.ip.lowcarbon.models.recycle.Recycle;

public interface RecycleRepository {
        List<Recycle> getAllRecycle();
    List<Recycle> getAllRecycleByUserId(String user_id);
    List<Recycle> getAllRecycleByMonth(int month);
    void addRecycleActivity(final Recycle recycle);
    void updateRecycleActivity(final Recycle recycle);
    Recycle getRecycleByMonth(String user_id, int month);
    void deleteRecycleActivity(String user_id, int month);
    void deleteRecycleByUserId(String user_id);
} 