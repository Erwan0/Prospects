package com.ynov.guillemin;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProspectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospect);

        Prospect myProspect = new Prospect ();
        myProspect = (Prospect) getIntent().getSerializableExtra("prospects");

        TextView prospectName = (TextView) findViewById(R.id.name);
        prospectName.setText(myProspect.getName());

        TextView prospectFirstname = (TextView) findViewById(R.id.firstname);
        prospectFirstname.setText(myProspect.getFirstname());

        TextView prospectMail = (TextView) findViewById(R.id.mail);
        prospectMail.setText(myProspect.getMail());

        TextView prospectAdresse1 = (TextView) findViewById(R.id.add1);
        prospectAdresse1.setText(myProspect.getAddress1());

        TextView prospectAdresse2 = (TextView) findViewById(R.id.add2);
        prospectAdresse2.setText(myProspect.getAddress2());

        TextView prospectZip = (TextView) findViewById(R.id.zip);
        prospectZip.setText(myProspect.getZip());

        TextView prospectCity = (TextView) findViewById(R.id.city);
        prospectCity.setText(myProspect.getCity());

        TextView prospectCompany = (TextView) findViewById(R.id.company);
        prospectCompany.setText(myProspect.getNameCompany());

        final TextView prospectPhone = (TextView) findViewById(R.id.phoneNumber);
        prospectPhone.setText(myProspect.getPhoneNumber());

        findViewById(R.id.phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call(prospectPhone.getText().toString());
            }
        });

    }

    public void call (final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
}
