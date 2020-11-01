package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;

public class MainActivity extends AppCompatActivity {

    private String operation;
    private int followingNumber;
    private int Result;
    private boolean primero;
    private boolean showingResult;
    private Double TrigoResult;
    private String ResumOperations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operation= "";
        followingNumber =0;
        Result=0;
        primero=true;
        showingResult=false;
        TrigoResult= 0.0;
        ResumOperations="";
    }
    private void Clean(){
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        txtPantalla.setText("");
        TextView txtOperations = (TextView)findViewById((R.id.txtoperations));
        txtOperations.setText("");
        showingResult=false;
    }
    public void btACClicked(View v){
        Clean();
        primero=true;
        Result=0;
        followingNumber=0;
        TrigoResult=0.0;
        operation="";
        ResumOperations="";
    }
    public void bt1Clicked(View v){
        if(showingResult) Clean();
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        String actualtext = txtPantalla.getText ().toString();
        txtPantalla.setText(actualtext +"1");

    }
    public void bt2Clicked(View v){
        if( showingResult) Clean();
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        String actualtext = txtPantalla.getText ().toString();
        txtPantalla.setText(actualtext +"2");

    }
    public void bt3Clicked(View v){
        if( showingResult) Clean();
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        String actualtext = txtPantalla.getText ().toString();
        txtPantalla.setText(actualtext +"3");

    }
    public void bt4Clicked(View v){
        if( showingResult) Clean();
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        String actualtext = txtPantalla.getText ().toString();
        txtPantalla.setText(actualtext +"4");

    }
    public void bt5Clicked(View v){
        if( showingResult) Clean();
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        String actualtext = txtPantalla.getText ().toString();
        txtPantalla.setText(actualtext +"5");

    }
    public void bt6Clicked(View v){
        if( showingResult) Clean();
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        String actualtext = txtPantalla.getText ().toString();
        txtPantalla.setText(actualtext +"6");

    }
    public void bt7Clicked(View v){
        if( showingResult) Clean();
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        String actualtext = txtPantalla.getText ().toString();
        txtPantalla.setText(actualtext +"7");

    }
    public void bt8Clicked(View v){
        if( showingResult) Clean();
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        String actualtext = txtPantalla.getText ().toString();
        txtPantalla.setText(actualtext +"8");

    }
    public void bt9Clicked(View v){
        if( showingResult) Clean();
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        String actualtext = txtPantalla.getText ().toString();
        txtPantalla.setText(actualtext +"9");

    }
    public void bt0Clicked(View v){
        if( showingResult) Clean();
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        String actualtext = txtPantalla.getText ().toString();
        txtPantalla.setText(actualtext +"0");

    }
    private void Operate(){
        if(operation=="+"){
            Result=Result+ followingNumber;
        }
        else if( operation=="-"){
            Result=Result - followingNumber;
        }
        else if( operation=="x"){
            Result=Result * followingNumber;
        }
        else if( operation=="/"){
            Result=Result/followingNumber;
        }
    }

    public void btPlusClicked (View v){
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        TextView txtOperations = (TextView)findViewById((R.id.txtoperations));
        int actualnumber = Integer.parseInt(txtPantalla.getText().toString());
        String actualnumberstring = txtPantalla.getText().toString();

        if (primero){
            Result=actualnumber;
            txtPantalla.setText("");
            txtOperations.setText(actualnumberstring);
            operation = "+";
            primero= false;
        }
        else{
            followingNumber = actualnumber;
            String actualoperations = txtOperations.getText().toString();
            txtOperations.setText(actualoperations + " + "+ actualnumber);
            Operate();
            txtPantalla.setText("");
        }
    }
    public void btSubstractionClicked (View v){
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        TextView txtOperations = (TextView)findViewById((R.id.txtoperations));
        int actualnumber = Integer.parseInt(txtPantalla.getText().toString());
        String actualnumberstring = txtPantalla.getText().toString();

        if (primero){
            Result=actualnumber;
            txtPantalla.setText("");
            txtOperations.setText(actualnumberstring);
            operation = "-";
            primero= false;
        }
        else{
            followingNumber = actualnumber;
            String actualoperations = txtOperations.getText().toString();
            txtOperations.setText(actualoperations + " - "+ actualnumber);
            Operate();
            txtPantalla.setText("");
        }
    }
    public void btMultiplicationClicked (View v){
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        TextView txtOperations = (TextView)findViewById((R.id.txtoperations));
        int actualnumber = Integer.parseInt(txtPantalla.getText().toString());
        String actualnumberstring = txtPantalla.getText().toString();

        if (primero){
            Result=actualnumber;
            txtPantalla.setText("");
            txtOperations.setText(actualnumberstring);
            operation = "x";
            primero= false;
        }
        else{
            followingNumber = actualnumber;
            String actualoperations = txtOperations.getText().toString();
            txtOperations.setText(actualoperations + " x "+ actualnumber);
            Operate();
            txtPantalla.setText("");
        }
    }
    public void btDivisionClicked (View v){
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        TextView txtOperations = (TextView)findViewById((R.id.txtoperations));
        int actualnumber = Integer.parseInt(txtPantalla.getText().toString());
        String actualnumberstring = txtPantalla.getText().toString();

        if (primero){
            Result=actualnumber;
            txtPantalla.setText("");
            txtOperations.setText(actualnumberstring);
            operation = "/";
            primero= false;
        }
        else{
            followingNumber = actualnumber;
            String actualoperations = txtOperations.getText().toString();
            txtOperations.setText(actualoperations + " / "+ actualnumber);
            Operate();
            txtPantalla.setText("");
        }
    }

    public void btEqualClicked (View v){
        if(operation==""){
            Toast.makeText(this,"NO OPERATION FOUND",Toast.LENGTH_LONG ).show();
        }
        else {
            TextView txtPantalla = (TextView) findViewById((R.id.txtPantalla));
            TextView txtOperations = (TextView)findViewById((R.id.txtoperations));
            String actualoperations = txtOperations.getText().toString();
            int actualnumber = Integer.parseInt(txtPantalla.getText().toString());
            txtOperations.setText(actualoperations + " " + operation+ " " + actualnumber + " = ");
            followingNumber = actualnumber;
            Operate();
            primero = true;
            showingResult = true;
            txtPantalla.setText(Integer.toString(Result));
        }
    }

    public void swRadClicked(View v){
        Switch DegSwitch = (Switch)findViewById(R.id.swDeg);
        DegSwitch.setChecked(false);
    }
    public void swDegClicked(View v){
        Switch RadSwitch = (Switch)findViewById(R.id.swRad);
        RadSwitch.setChecked(false);
    }

    public void btSinClicked( View v){
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        TextView txtOperations = (TextView)findViewById((R.id.txtoperations));
        double actualnumber = Double.parseDouble(txtPantalla.getText().toString());
        Switch RadSwitch = (Switch)findViewById(R.id.swRad);
        if (RadSwitch.isChecked()){
            TrigoResult=sin(actualnumber);
        }
        else{
            TrigoResult=sin(Math.toRadians(actualnumber));
        }
        primero=true;
        showingResult=true;
        txtPantalla.setText(Double.toString(TrigoResult));
        txtOperations.setText("Sin( " + actualnumber+ " ) = ");

   }
    public void btCosClicked( View v){
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        TextView txtOperations = (TextView)findViewById((R.id.txtoperations));
        double actualnumber = Double.parseDouble(txtPantalla.getText().toString());
        Switch RadSwitch = (Switch)findViewById(R.id.swRad);
        if (RadSwitch.isChecked()){
            TrigoResult=cos(actualnumber);
        }
        else{
            TrigoResult=cos(Math.toRadians(actualnumber));
        }
        primero=true;
        showingResult=true;
        txtPantalla.setText(Double.toString(TrigoResult));
        txtOperations.setText("Cos( " + actualnumber+ " ) = ");
    }
    public void btTanClicked( View v){
        TextView txtPantalla = (TextView)findViewById((R.id.txtPantalla));
        TextView txtOperations = (TextView)findViewById((R.id.txtoperations));
        double actualnumber = Double.parseDouble(txtPantalla.getText().toString());
        Switch RadSwitch = (Switch)findViewById(R.id.swRad);
        if (RadSwitch.isChecked()){
            TrigoResult=tan(actualnumber);
        }
        else{
            TrigoResult=tan(Math.toRadians(actualnumber));
        }
        primero=true;
        showingResult=true;
        txtPantalla.setText(Double.toString(TrigoResult));
        txtOperations.setText("Tan( " + actualnumber+ " ) = ");
    }








}