package com.hfad.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class NewTaskDialog extends DialogFragment {
    private String task;
    private String dueDate;
    private EditText taskEntry;
    private EditText dateEntry;

    NewTaskDialogListener listener;

    public interface NewTaskDialogListener {
        void storeTask(String text, String date);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (NewTaskDialogListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Add a Task");
        View dialogView = inflater.inflate(R.layout.new_task_dialog, null);
        builder.setView(dialogView);

        taskEntry = dialogView.findViewById(R.id.taskText);
        dateEntry = dialogView.findViewById(R.id.taskDueDate);

        builder.setPositiveButton("Add This", (dialog, which) -> {
           task = taskEntry.getText().toString();
           dueDate = dateEntry.getText().toString();
           if (TextUtils.isEmpty(task) || TextUtils.isEmpty(dueDate)) {
               Log.i("INFO", "Empty fields not allowed.");
               return;
            }
           listener.storeTask(task, dueDate);
        });

        builder.setNegativeButton("Dont Add", (dialog, which) -> {
            Log.i("INFO", "Task add cancelled.");
        });

        return builder.create();
    }
}
