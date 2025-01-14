package cn.jxufe.cn.myapplication4.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDataHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "comment";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_AUTHOR = "author";

    public MyDataHelper(@Nullable Context context) {
        super(context,  "comments.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TITLE + " TEXT, " + COLUMN_AUTHOR + " TEXT);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public String addOne(CommentModel commentModel){
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_AUTHOR, commentModel.getAuthor());
        cv.put(COLUMN_TITLE, commentModel.getTitle());

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long insert = sqLiteDatabase.insert(TABLE_NAME, COLUMN_AUTHOR, cv);
        if (insert == -1){
            return "fail";
        }
        sqLiteDatabase.close();
        return "success";
    }

    public String deleteOne(CommentModel commentModel){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int delete = sqLiteDatabase.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{String.valueOf(commentModel.getId())});

        sqLiteDatabase.close();
        if(delete == 0){
            return "fail";
        }
        return "success";
    }

    public String updateOne(CommentModel commentModel){

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_AUTHOR, commentModel.getAuthor());
        cv.put(COLUMN_TITLE, commentModel.getTitle());

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int update = sqLiteDatabase.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{String.valueOf(commentModel.getId())});

        sqLiteDatabase.close();

        if (update == 0){
            return "fail";
        }

        return "success";
    }

    public List<CommentModel> getALL(){
        List<CommentModel> list = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        int idIndex = cursor.getColumnIndex(COLUMN_ID);
        int titleIndex = cursor.getColumnIndex(COLUMN_TITLE);
        int authorIndex = cursor.getColumnIndex(COLUMN_AUTHOR);

        while (cursor.moveToNext()){
            CommentModel commentModel = new CommentModel(cursor.getInt(idIndex),cursor.getString(titleIndex),cursor.getString(authorIndex));
            list.add(commentModel);
        }

        sqLiteDatabase.close();

        return list;
    }
}
