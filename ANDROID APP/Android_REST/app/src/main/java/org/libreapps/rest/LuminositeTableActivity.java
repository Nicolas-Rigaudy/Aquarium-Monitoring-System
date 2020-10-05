package org.libreapps.rest;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.libreapps.rest.obj.Luminosite;

import de.codecrafters.tableview.TableColumnModel;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class LuminositeTableActivity extends AppCompatActivity {

    LuminositeTableModel tableModel1;
    LuminositeTableModel tableModel2;

    TableView<String[]> tableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //new ConnectionRest().execute("GET");

        tableModel1 = new LuminositeTableModel();
        tableModel2 = new LuminositeTableModel();
        tableView = (TableView<String[]>) findViewById(R.id.tableView);
        tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableModel1.getLuminosites()));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this, tableModel1.getLuminositeHeaders()));
        tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableModel2.getLuminosites()));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this, tableModel2.getLuminositeHeaders()));
        tableView.setColumnWeight(0,1);
        tableView.setColumnWeight(1,2);
        tableView.setColumnWeight(2,1);


        //TABLE CLICK
        tableView.addDataClickListener(new TableDataClickListener() {
            public void onDataClicked(int rowIndex, Object clickedData) {
                Intent intent = new Intent(LuminositeTableActivity.this, EditActivity.class);
                intent.putExtra("id", tableModel1.get(rowIndex).getId());
                intent.putExtra("timestamp", ((String[])clickedData)[1]);
                intent.putExtra("luminosite", Integer.parseInt(((String[]) clickedData)[2]));
                intent.putExtra("id", tableModel2.get(rowIndex).getId());
                intent.putExtra("timestamp", ((String[])clickedData)[1]);
                intent.putExtra("temperature", Integer.parseInt(((String[]) clickedData)[2]));
                startActivity(intent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LuminositeTableActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
