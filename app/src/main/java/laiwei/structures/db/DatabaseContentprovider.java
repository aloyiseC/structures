package laiwei.structures.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by laiwei on 2018/11/20 0020.
 */
public class DatabaseContentProvider extends ContentProvider{

    private static final String AUTHORITY = "laiwei.structures";
    private static final String PATH = "data";
    public static final Uri DATABASE_URI = Uri.parse("content://"+AUTHORITY);
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int URI_CODE = 0x123;
    static
    {
        sUriMatcher.addURI(AUTHORITY,PATH,URI_CODE);
    }

    public DatabaseContentProvider() {}

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        getContext().getContentResolver().notifyChange(uri,null);
        //helper.insert(values);
        return DATABASE_URI;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
