package com.example.onefeed;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;

/*
import com.github.jreddit.entity.Submission;
import com.github.jreddit.entity.User;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.SubmissionSort;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;
 */

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FeedAdapter adapter;
    private List<Post> postList;

    /*
    RestClient restClient;
    User user;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ask for internet permission
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1);
        }

        // Check if an account is logged in
        /*
        SharedPreferences sharedPreferences = getSharedPreferences("c.PrayagBhakar.OneFeed", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        if (!username.equals("") && !password.equals("")) { // key found
            login(username, password);
        } else { // key not found
            login();
        }
        */

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        postList = new ArrayList<>();
        adapter = new FeedAdapter(this, postList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // specify an adapter (see also next example)
        recyclerView.setAdapter(adapter);

        //loadposts();
        prepTestInfo();
    }

    /*
    private void login(String username, String password) {
        // Initialize REST Client
        restClient = new HttpRestClient();
        restClient.setUserAgent("cs407 Project");

        // Connect the user
        user = new User(restClient, "username", "password");
        try {
            user.connect();
        } catch (Exception e) {
            restClient = null;
            user = null;
            return;
        }

        // save username and password
        SharedPreferences sharedPreferences = getSharedPreferences("c.PrayagBhakar.OneFeed", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", username).apply();
        sharedPreferences.edit().putString("password", password).apply();
    }
    private void login() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Log Into Reddit");
        // Set up Username and Password input
        final EditText username = new EditText(this);
        username.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        username.setHint("USERNAME");
        final EditText password = new EditText(this);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        password.setHint("PASSWORD");
        // Bundle EditTexts
        LinearLayout input = new LinearLayout(this);
        input.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        input.setOrientation(LinearLayout.VERTICAL);

        // Show dialague
        builder.setView(username);
        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                login(username.getText().toString(), password.getText().toString());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
    private void loadposts() {
        // Handle to Submissions, which offers the basic API submission functionality
        Submissions subms = new Submissions(restClient, user);

        // Retrieve submissions of a submission
        List<Submission> submissionsSubreddit = subms.ofSubreddit("all", SubmissionSort.TOP, -1, 100, null, null, true);

        Log.d("myTag", submissionsSubreddit.toString());

        adapter.notifyDataSetChanged();
    }
     */
    private void prepTestInfo() {
        Post a = new Post(
                "PrayagBhakar",
                "https://scontent-ort2-1.cdninstagram.com/v/t51.2885-15/e35/53505092_958917107830910_4483457580112952071_n.jpg?_nc_ht=scontent-ort2-1.cdninstagram.com&_nc_cat=102&_nc_ohc=iJQXs3YjV_cAX94GvgX&oh=768b0b321744968f324ed2f11a5317a5&oe=5EBD4EF9",
                "Don’t know where life’s going, but this feels like the right path \uD83C\uDF35\uD83D\uDEE4\uD83C\uDF32",
                199, 2);
        postList.add(a);

        Post b = new Post(
                "BigNate",
                "https://scontent-ort2-1.cdninstagram.com/v/t51.2885-15/e35/47374808_212333709706634_6190650188395184128_n.jpg?_nc_ht=scontent-ort2-1.cdninstagram.com&_nc_cat=102&_nc_ohc=EYxv5hAAJpEAX8vwzlY&oh=8042c724b50f053a0d302c5c0a725812&oe=5EBED415",
                "Bok Bok B*tch!\uD83D\uDC14 Caught these two gentlemen off guard with a special birthday surprise!! ⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "Happy birthday to @andyxmoy and @tkunsel_ \uD83E\uDD18\uD83D\uDC9A",
                10, 3);
        postList.add(b);

        Post c = new Post(
                "Snoopy",
                "https://scontent-ort2-1.cdninstagram.com/v/t51.2885-15/e35/46540500_2201469730111561_8610220976669458432_n.jpg?_nc_ht=scontent-ort2-1.cdninstagram.com&_nc_cat=101&_nc_ohc=QuuXjgQ6v-MAX9mTzCy&oh=f6b9be8450749e0149d0199dfa5cfb5d&oe=5EBF3799",
                "Just working on my new mixtape. It’s called GPA and it’s dropping next week. \uD83D\uDCDA\uD83D\uDCC9 ⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "\uD83D\uDCF8 : @_mahimabhattar_",
                1500, 15);
        postList.add(c);

        adapter.notifyDataSetChanged();
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

        // Handles going to the appropriate page from the menu
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent2 = new Intent(this, SettingsActivity.class);
                this.startActivity(intent2);
                break;
            case R.id.profile:
                Intent intent1 = new Intent(this, AccountActivity.class);
                this.startActivity(intent1);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
    /*
    public void sendOnChannel1 (View v) {

    }

    public void sendOnChannel2 (View v) {

    }

     */
}
