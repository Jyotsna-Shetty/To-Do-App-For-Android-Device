package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.FileUtils;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.CharBuffer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   
    private ArrayList<String> task;
    private ArrayAdapter<String> taskAdapter;
    
    /* Code for displaying the tasks using files, commented out as it did not work.
        private void showList() throws IOException {
        File listFile = new File(filesDir, "list.txt");
              try {
                  FileInputStream showData = new FileInputStream("listFile.ser");
                  ObjectInputStream showStream = new ObjectInputStream(showData);
                  showStream.close();
                  System.out.println(task.toString());
              } catch (IOException e) {
                  e.printStackTrace();
              } */
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        task = new ArrayList<String>();
        
        /* Calling method to display tasks on screen, commented out as it did not work, kept for reference
        try {
            showList();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        
        // Displaying the newly added tasks on the app screen
        taskAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,task);
        listView.setAdapter(taskAdapter);
    }

    // Click listener for ADD ITEM button
    public void onAddItem(View view) throws IOException {            // IOException added for using files
        EditText NewItem= (EditText) findViewById(R.id.NewItem);
        task.add(NewItem.getText().toString());
        NewItem.setText(" ");                                        // Resets text in the EditText box after every click
        taskAdapter.notifyDataSetChanged();
        //taskAdapter.add(NewItem.getText().toString());                Alternate method to add new task to the Array Adapter

        /* Code for writing newly added task(s) to the file, commented out as it did not work, kept for reference
        File file = new File(MainActivity.this.getFilesDir(), "text");
        try {
            File listFile = new File(file, "list" );
            FileWriter saveData = new FileWriter(listFile);
            saveData.append(NewItem.getText().toString());
            saveData.flush();
            saveData.close();
        }catch (IOException e)    {
            e.printStackTrace();
        }*/
    }
}
