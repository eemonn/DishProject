package comp3350.dishproject.presentation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Messages {
    /*
    Messages for use when errors occur
     */
    public static void fatalError(final Context context, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Fatal Error");
        alertDialog.setMessage(message);
        alertDialog.show();
    }

    public static void warning(final Context context, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Warning");
        alertDialog.setMessage(message);
        alertDialog.show();
    }
}
