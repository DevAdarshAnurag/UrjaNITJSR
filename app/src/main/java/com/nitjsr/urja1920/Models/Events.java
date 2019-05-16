package com.nitjsr.urja1920.Models;

public class Events {
    private String eventName;
    private int eventThumbnail;

    public Events(String eventName, int eventThumbnail) {
        this.eventName = eventName;
        this.eventThumbnail = eventThumbnail;
    }

    public String getEventName() {
        return eventName;
    }

    public int getEventThumbnail() {
        return eventThumbnail;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventThumbnail(int eventThumbnail) {
        this.eventThumbnail = eventThumbnail;
    }
}

/*
final EditText detail,date,time;
        detail = view.findViewById(R.id.detail);
        date = view.findViewById(R.id.date);
        time = view.findViewById(R.id.time);
        view.findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fixture fixture = new Fixture(detail.getText().toString(),"Cricket","NA","NA","Group",false,false, time.getText().toString(), date.getText().toString());
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("CricketFixtures");
                String key = databaseReference.push().getKey();
                Map<String, Object> fixtureValues = fixture.toMap();
                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put(key, fixtureValues);
                databaseReference.updateChildren(childUpdates);
            }
        });
 */

/*<EditText
            android:layout_width="match_parent"
            android:id="@+id/detail"
            android:text="CSE vs MCA + MSc"
            android:layout_height="wrap_content" />
        <EditText
            android:layout_width="match_parent"
            android:id="@+id/date"
            android:text="23/09/2018"
            android:layout_height="wrap_content" />
        <EditText
            android:layout_width="match_parent"
            android:id="@+id/time"
            android:text="6:30 AM"
            android:layout_height="wrap_content" />
        <Button
            android:layout_width="wrap_content"
            android:id="@+id/go"
            android:text="Go"
            android:layout_height="wrap_content" />
            */