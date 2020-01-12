package com.jc_designs.mytpi.Appliances;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;


import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jc_designs.mytpi.Home;
import com.jc_designs.mytpi.R;
import com.jc_designs.mytpi.globalVariables;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Machine_Certificate extends AppCompatActivity {

    private Machine_Database myDB;
    private SQLiteDatabase sqlDB;

    //Declare TextViews Front Page
    private TextView inspectionType;
    private TextView result;
    private TextView inspectionTypeBack;
    private TextView safe;
    private TextView comments;

    private TextView date;
    private TextView client;
    private TextView address;
    private TextView location;
    private TextView standard;
    private TextView reg;
    private TextView fleet;
    private TextView make;
    private TextView model;
    private TextView serial;
    private TextView swl;
    private TextView description;
    private TextView info1Title;
    private TextView info1;
    private TextView info2Title;
    private TextView info2;
    private TextView info3Title;
    private TextView info3;
    private TextView info4Title;
    private TextView info4;
    private TextView detail1Y;
    private TextView detail1NA;
    private TextView detail1N;
    private TextView detail2Y;
    private TextView detail2NA;
    private TextView detail2N;
    private TextView detail3Y;
    private TextView detail3NA;
    private TextView detail3N;
    private TextView detail4Y;
    private TextView detail4NA;
    private TextView detail4N;
    private TextView detail5Y;
    private TextView detail5NA;
    private TextView detail5N;
    private TextView reason;
    private TextView weight1;
    private TextView weight2;
    private TextView length1;
    private TextView length2;
    private TextView testSWL1;
    private TextView testSWL2;
    private TextView testSWL3;
    private TextView testSWL4;
    private TextView appliedLoad1;
    private TextView appliedLoad2;
    private TextView appliedLoad3;
    private TextView appliedLoad4;
    private TextView boomLength1;
    private TextView boomLength2;
    private TextView boomLength3;
    private TextView boomLength4;
    private TextView radius1;
    private TextView radius2;
    private TextView radius3;
    private TextView radius4;
    private TextView testInfo;
    private TextView defects;
    private TextView recommendations;
    private TextView previousExamCert;
    private TextView previousExamDate;
    private TextView previousTestCert;
    private TextView previousTestDate;
    private TextView nextExam;
    private TextView nextTest;
    private TextView name;
    private TextView timesheet;
    private TextView issueDate;

    private TextView dateBack;
    private TextView superstructure;
    private TextView markings;
    private TextView controls;
    private TextView emergencyStop;
    private TextView tilting;
    private TextView overload;
    private TextView emergenyFunctions;
    private TextView electrical;
    private TextView hydraulics;
    private TextView speed;
    private TextView slewing;
    private TextView braking;
    private TextView tyres;
    private TextView outrigger;
    private TextView sparkArrestor;
    private TextView lights;
    private TextView fireExtinguisher;
    private TextView mainWire;
    private TextView auxWire;
    private TextView trolleyWire;
    private TextView wireRope;
    private TextView mainRopeCert;
    private TextView auxRopeCert;
    private TextView mainLinePull;
    private TextView auxLinePull;
    private TextView CW;
    private TextView ballast;
    private TextView visual;
    private TextView functions;
    private TextView earthing;
    private TextView creeping;
    private TextView ndt;
    private TextView manual;
    //TextView nameBack;

    private LinearLayout table;

    private TextView checklistInspectionType;
    private TextView checklistName;
    private TextView checklistClient;
    private TextView checklistLocation;
    private TextView checklistDate;
    private TextView checklistTimesheet;
    private TextView checklistRecords;
    private TextView checklistNDT;
    private TextView checklistExamCert;
    private TextView checklistExamDate;
    private TextView checklistTestCert;
    private TextView checklistTestDate;
    private TextView checklistMainRopeCert;
    private TextView checklistAuxRopeCert;
    private TextView checklistStandard;
    private TextView checklistDescription;
    private TextView checklistMake;
    private TextView checklistModel;
    private TextView checklistSerial;
    private TextView checklistFleet;
    private TextView checklistReg;
    private TextView checklistSWL;
    private TextView checklistCW;
    private TextView checklistBallast;
    private TextView checklistInfo1;
    private TextView checklistInfo2;
    private TextView checklistInfo3;
    private TextView checklistInfo4;
    private TextView checklistInfo1Title;
    private TextView checklistInfo2Title;
    private TextView checklistInfo3Title;
    private TextView checklistInfo4Title;
    private TextView checklistManual;
    private TextView checklistFireExtinguisher;
    private TextView checklistMarkings;
    private TextView checklistVisual;
    private TextView checklistCabin;
    private TextView checklistLoadChart;
    private TextView checklistChassis;
    private TextView checklistTyres;
    private TextView checklistSlewing;
    private TextView checklistFluid;
    private TextView checklistOutrigger;
    private TextView checklistSuperstructure;
    private TextView checklistSparkArrestor;
    private TextView checklistHydraulics;
    private TextView checklistBraking;
    private TextView checklistConnections;
    private TextView checklistMainDia;
    private TextView checklistAuxDia;
    private TextView checklistTrolleyDia;
    private TextView checklistForks;
    private TextView checklistCylinder;
    private TextView checklistMainLinePull;
    private TextView checklistAuxLinePull;
    private TextView checklistWireRope;
    private TextView checklistControls;
    private TextView checklistSpeed;
    private TextView checklistEmergencyStop;
    private TextView checklistLimitSwitches;
    private TextView checklistElectrical;
    private TextView checklistBatteries;
    private TextView checklistOverload;
    private TextView checklistTilting;
    private TextView checklistAnemometer;
    private TextView checklistLights;
    private TextView checklistEarthing;
    private TextView checklistFunctions;
    private TextView checklistEmergencyFunctions;
    private TextView checklistWeight1;
    private TextView checklistWeight2;
    private TextView checklistLength1;
    private TextView checklistLength2;
    private TextView checklistTestSwl1;
    private TextView checklistTestSwl2;
    private TextView checklistTestSwl3;
    private TextView checklistTestSwl4;
    private TextView checklistAppliedLoad1;
    private TextView checklistAppliedLoad2;
    private TextView checklistAppliedLoad3;
    private TextView checklistAppliedLoad4;
    private TextView checklistBoomLength1;
    private TextView checklistBoomLength2;
    private TextView checklistBoomLength3;
    private TextView checklistBoomLength4;
    private TextView checklistTestRadius1;
    private TextView checklistTestRadius2;
    private TextView checklistTestRadius3;
    private TextView checklistTestRadius4;
    private TextView checklistTestInfo;
    private TextView checklistDeflection;
    private TextView checklistDefects;
    private TextView checklistRecommendations;
    private TextView checklistOutcome;

    private View view;
    private View view2;
    private View view3;
    private View view4;
    private View view5;

    private int viewHeight;
    private int viewWidth;

    private TextView outcomeText;
    private ImageView outcomeImage;
    private TextView completeText;
    private LinearLayout bgLayer;

    private LinearLayout certificateLayout;
    private LinearLayout Page1Cert;

    private Button save_close_button;
    private Button review_button;
    private Button send_button;

    private TextView time;
    private TextView name_completed;

    private TextView calibrationTitle;
    private TextView calibrationItem1;
    private TextView calibrationItem2;
    private TextView calibrationItem3;
    private TextView calibrationItem4;
    private TableRow calibrationRow1;
    private TableRow calibrationRow2;

    private ImageView photo1;
    private ImageView photo2;
    private ImageView photo3;
    private ImageView photo4;

    private TextView photoDate;
    private TextView photoTitle;

    private String photoActive;

    private TextView certLabel;
    private TextView certLabel2;

    private String sent;

    private TextView checklistCalibrated1;
    private TextView checklistCalibrated2;
    private TextView checklistCalibrated3;
    private TextView checklistCalibrated4;

    private static final int REQUEST_CODE_LOCATION = 2;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_certificate);

        globalVariables.PERMISSIONS = " ";

        DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl(globalVariables.FIREBASE_URL);

        myDB = new Machine_Database(this);
        sqlDB = myDB.getReadableDatabase();

        checklistCalibrated1 = (TextView)findViewById(R.id.calibrationItem1CL);
        checklistCalibrated2 = (TextView)findViewById(R.id.calibrationItem2CL);
        checklistCalibrated3 = (TextView)findViewById(R.id.calibrationItem3CL);
        checklistCalibrated4 = (TextView)findViewById(R.id.calibrationItem4CL);

        photo1 = (ImageView) findViewById(R.id.photo1);
        photo2 = (ImageView) findViewById(R.id.photo2);
        photo3 = (ImageView) findViewById(R.id.photo3);
        photo4 = (ImageView) findViewById(R.id.photo4);
        photoDate = (TextView) findViewById(R.id.photoDate);
        photoTitle = (TextView) findViewById(R.id.photoTitle);

        calibrationTitle = (TextView) findViewById(R.id.calibrationTitle);
        calibrationItem1 = (TextView) findViewById(R.id.calibrationItem1);
        calibrationItem2 = (TextView) findViewById(R.id.calibrationItem2);
        calibrationItem3 = (TextView) findViewById(R.id.calibrationItem3);
        calibrationItem4 = (TextView) findViewById(R.id.calibrationItem4);
        calibrationRow1 = (TableRow) findViewById(R.id.calibrationRow1);
        calibrationRow2 = (TableRow) findViewById(R.id.calibrationRow2);

        view = findViewById(R.id.Page1Cert);
        view2 = findViewById(R.id.Page2Cert);
        view3 = findViewById(R.id.Page3Cert);
        view4 = findViewById(R.id.Page4Cert);
        view5 = findViewById(R.id.page5Cert);

        certLabel = (TextView)findViewById(R.id.certNoLabel);
        certLabel2 = (TextView)findViewById(R.id.cerNoBack);

        name_completed = (TextView) findViewById(R.id.inspectorName);

        outcomeImage = (ImageView) findViewById(R.id.outcomeIcon);
        outcomeText = (TextView) findViewById(R.id.outcomeText);
        completeText = (TextView) findViewById(R.id.completeText);
        bgLayer = (LinearLayout) findViewById(R.id.bg);

        Page1Cert = (LinearLayout) findViewById(R.id.Page1Cert);

        save_close_button = (Button) findViewById(R.id.saveCloseButton);
        save_close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (photoActive.equals("yes")) {
                    createPDF(view, view2, view5, view3, view4);
                } else {
                    createPDF(view, view2, view3, view4, view5);
                }
                globalVariables.makeToast(Machine_Certificate.this, "Certificate Saved");

                Intent intent = new Intent(Machine_Certificate.this, Home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });


        review_button = (Button) findViewById(R.id.reviewButton);
        review_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (photoActive.equals("yes")) {
                    createPDF(view, view2, view5, view3, view4);
                } else {
                    createPDF(view, view2, view3, view4, view5);
                }

                String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(sd, globalVariables.PDF_NAME);


                if (file.exists()) {
                    Uri path = Uri.fromFile(file);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(path, "application/pdf");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        globalVariables.makeToast(Machine_Certificate.this, "No Application Available to View PDF");

                    }
                } else {
                    System.out.print("Error");
                }
            }
        });

        send_button = (Button) findViewById(R.id.sendButton);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (photoActive.equals("yes")) {
                    createPDF(view, view2, view5, view3, view4);
                } else {
                    createPDF(view, view2, view3, view4, view5);
                }

                String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(sd, globalVariables.PDF_NAME);

                if (file.exists()) {
                    Uri path = Uri.fromFile(file);
                    Intent intent = new Intent((Intent.ACTION_SEND));
                    intent.setType("application/pdf");
                    intent.putExtra(Intent.EXTRA_STREAM, path);

                    if (globalVariables.FLEET_NUMBER.equals(" ")) {
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Certificate for machine " + globalVariables.SERIAL_NUMBER);
                        intent.putExtra(Intent.EXTRA_TEXT, "Please find the attached certificate of inspection for the " + globalVariables.CLIENT + " machine " + globalVariables.SERIAL_NUMBER + ".");
                    } else {
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Certificate for machine " + globalVariables.FLEET_NUMBER);
                        intent.putExtra(Intent.EXTRA_TEXT, "Please find the attached certificate of inspection for the " + globalVariables.CLIENT + " machine " + globalVariables.FLEET_NUMBER + ".");
                    }

                    startActivity(Intent.createChooser(intent, "Send email using:"));
                }
            }
        });


        certificateLayout = (LinearLayout) findViewById(R.id.certificatePage);

        //bgLayer.setBackgroundResource(R.drawable.bg5);

        date = (TextView) findViewById(R.id.date2);
        client = (TextView) findViewById(R.id.client);
        address = (TextView) findViewById(R.id.address);
        location = (TextView) findViewById(R.id.location);
        standard = (TextView) findViewById(R.id.standard);
        reg = (TextView) findViewById(R.id.reg);
        fleet = (TextView) findViewById(R.id.fleet);
        make = (TextView) findViewById(R.id.make);
        model = (TextView) findViewById(R.id.model);
        serial = (TextView) findViewById(R.id.serial);
        swl = (TextView) findViewById(R.id.swl);
        description = (TextView) findViewById(R.id.description);
        info1Title = (TextView) findViewById(R.id.info1Title);
        info1 = (TextView) findViewById(R.id.info1);
        info2Title = (TextView) findViewById(R.id.info2Title);
        info2 = (TextView) findViewById(R.id.info2);
        info3Title = (TextView) findViewById(R.id.info3Title);
        info3 = (TextView) findViewById(R.id.info3);
        info4Title = (TextView) findViewById(R.id.info4Title);
        info4 = (TextView) findViewById(R.id.info4);
        detail1Y = (TextView) findViewById(R.id.detail1Yes);
        detail1NA = (TextView) findViewById(R.id.detail1NA);
        detail1N = (TextView) findViewById(R.id.detail1No);
        detail2Y = (TextView) findViewById(R.id.detail2Yes);
        detail2NA = (TextView) findViewById(R.id.detail2NA);
        detail2N = (TextView) findViewById(R.id.detail2No);
        detail3Y = (TextView) findViewById(R.id.detail3Yes);
        detail3NA = (TextView) findViewById(R.id.detail3NA);
        detail3N = (TextView) findViewById(R.id.detail3No);
        detail4Y = (TextView) findViewById(R.id.detail4Yes);
        detail4NA = (TextView) findViewById(R.id.detail4NA);
        detail4N = (TextView) findViewById(R.id.detail4No);
        detail5Y = (TextView) findViewById(R.id.detail5Yes);
        detail5NA = (TextView) findViewById(R.id.detail5NA);
        detail5N = (TextView) findViewById(R.id.detail5No);
        reason = (TextView) findViewById(R.id.reason);
        weight1 = (TextView) findViewById(R.id.weight1);
        weight2 = (TextView) findViewById(R.id.weight2);
        length1 = (TextView) findViewById(R.id.length1);
        length2 = (TextView) findViewById(R.id.length2);
        testSWL1 = (TextView) findViewById(R.id.testSwl1);
        testSWL2 = (TextView) findViewById(R.id.testSwl2);
        testSWL3 = (TextView) findViewById(R.id.testSwl3);
        testSWL4 = (TextView) findViewById(R.id.testSwl4);
        appliedLoad1 = (TextView) findViewById(R.id.appliedLoad1);
        appliedLoad2 = (TextView) findViewById(R.id.appliedLoad2);
        appliedLoad3 = (TextView) findViewById(R.id.appliedLoad3);
        appliedLoad4 = (TextView) findViewById(R.id.appliedLoad4);
        boomLength1 = (TextView) findViewById(R.id.boomLength1);
        boomLength2 = (TextView) findViewById(R.id.boomLength2);
        boomLength3 = (TextView) findViewById(R.id.boomLength3);
        boomLength4 = (TextView) findViewById(R.id.boomLength4);
        radius1 = (TextView) findViewById(R.id.testRadius1);
        radius2 = (TextView) findViewById(R.id.testRadius2);
        radius3 = (TextView) findViewById(R.id.testRadius3);
        radius4 = (TextView) findViewById(R.id.testRadius4);
        testInfo = (TextView) findViewById(R.id.testInfo);
        defects = (TextView) findViewById(R.id.defects);
        recommendations = (TextView) findViewById(R.id.recommendations);
        previousExamCert = (TextView) findViewById(R.id.examCert);
        previousExamDate = (TextView) findViewById(R.id.examDate);
        previousTestCert = (TextView) findViewById(R.id.testCert);
        previousTestDate = (TextView) findViewById(R.id.testDate);
        nextExam = (TextView) findViewById(R.id.nextExam);
        nextTest = (TextView) findViewById(R.id.nextTest);
        name = (TextView) findViewById(R.id.inspector);
        timesheet = (TextView) findViewById(R.id.timesheet);
        issueDate = (TextView) findViewById(R.id.date);

        dateBack = (TextView) findViewById(R.id.dateBack);
        superstructure = (TextView) findViewById(R.id.superstructure);
        markings = (TextView) findViewById(R.id.markings);
        controls = (TextView) findViewById(R.id.controls);
        emergencyStop = (TextView) findViewById(R.id.emergencyStop);
        tilting = (TextView) findViewById(R.id.tilting);
        overload = (TextView) findViewById(R.id.overload);
        emergenyFunctions = (TextView) findViewById(R.id.emergencyFunctions);
        electrical = (TextView) findViewById(R.id.electrical);
        hydraulics = (TextView) findViewById(R.id.hydraulic);
        speed = (TextView) findViewById(R.id.speed);
        slewing = (TextView) findViewById(R.id.slewing);
        braking = (TextView) findViewById(R.id.braking);
        tyres = (TextView) findViewById(R.id.tyres);
        outrigger = (TextView) findViewById(R.id.outriggers);
        sparkArrestor = (TextView) findViewById(R.id.sparkArrestor);
        lights = (TextView) findViewById(R.id.lights);
        fireExtinguisher = (TextView) findViewById(R.id.fireExtinguisher);
        mainWire = (TextView) findViewById(R.id.mainWire);
        auxWire = (TextView) findViewById(R.id.auxWire);
        trolleyWire = (TextView) findViewById(R.id.trolleyWire);
        wireRope = (TextView) findViewById(R.id.wireRope);
        mainRopeCert = (TextView) findViewById(R.id.mainRopeCert);
        auxRopeCert = (TextView) findViewById(R.id.auxRopeCert);
        mainLinePull = (TextView) findViewById(R.id.mainLinePull);
        auxLinePull = (TextView) findViewById(R.id.auxLinePull);
        CW = (TextView) findViewById(R.id.CW);
        ballast = (TextView) findViewById(R.id.ballast);
        visual = (TextView) findViewById(R.id.visual);
        functions = (TextView) findViewById(R.id.functions);
        earthing = (TextView) findViewById(R.id.earthing);
        creeping = (TextView) findViewById(R.id.creeping);
        ndt = (TextView) findViewById(R.id.ndtReport);
        manual = (TextView) findViewById(R.id.records);
        //nameBack = (TextView)findViewById(R.id.name);

        inspectionType = (TextView) findViewById(R.id.inspectionType);
        inspectionTypeBack = (TextView) findViewById(R.id.inspectionTypeBack);
        result = (TextView) findViewById(R.id.result);
        safe = (TextView) findViewById(R.id.safe);
        //  comments = (TextView)findViewById(R.id.comments) ;


        table = (LinearLayout) findViewById(R.id.table);

        checklistInspectionType = (TextView) findViewById(R.id.checklistInspectionType);
        checklistName = (TextView) findViewById(R.id.checklistName);
        checklistClient = (TextView) findViewById(R.id.checklistClient);
        checklistLocation = (TextView) findViewById(R.id.checklistLocation);
        checklistDate = (TextView) findViewById(R.id.checklistDate);
        checklistTimesheet = (TextView) findViewById(R.id.checklistTimesheet);
        checklistRecords = (TextView) findViewById(R.id.checklistRecords);
        checklistNDT = (TextView) findViewById(R.id.checklistNDT);
        checklistExamCert = (TextView) findViewById(R.id.checklistExamCert);
        checklistExamDate = (TextView) findViewById(R.id.checklistExamDate);
        checklistTestCert = (TextView) findViewById(R.id.checklistTestCert);
        checklistTestDate = (TextView) findViewById(R.id.checklistTestDate);
        checklistMainRopeCert = (TextView) findViewById(R.id.checklistMainRopeCert);
        checklistAuxRopeCert = (TextView) findViewById(R.id.checklistAuxRopeCert);
        checklistStandard = (TextView) findViewById(R.id.checklistStandard);
        checklistDescription = (TextView) findViewById(R.id.checklistDescription);
        checklistMake = (TextView) findViewById(R.id.checklistMake);
        checklistModel = (TextView) findViewById(R.id.checklistModel);
        checklistSerial = (TextView) findViewById(R.id.checklistSerial);
        checklistFleet = (TextView) findViewById(R.id.checklistFleet);
        checklistReg = (TextView) findViewById(R.id.checklistReg);
        checklistSWL = (TextView) findViewById(R.id.checklistSWL);
        checklistCW = (TextView) findViewById(R.id.checklistCW);
        checklistBallast = (TextView) findViewById(R.id.checklistBallast);
        checklistInfo1 = (TextView) findViewById(R.id.checklistInfo1);
        checklistInfo1Title = (TextView) findViewById(R.id.checklistInfo1Title);
        checklistInfo2 = (TextView) findViewById(R.id.checklistInfo2);
        checklistInfo2Title = (TextView) findViewById(R.id.checklistInfo2Title);
        checklistInfo3 = (TextView) findViewById(R.id.checklistInfo3);
        checklistInfo3Title = (TextView) findViewById(R.id.checklistInfo3Title);
        checklistInfo4 = (TextView) findViewById(R.id.checklistInfo4);
        checklistInfo4Title = (TextView) findViewById(R.id.checklistInfo4Title);
        checklistManual = (TextView) findViewById(R.id.checklistManual);
        checklistFireExtinguisher = (TextView) findViewById(R.id.checklistFire);
        checklistMarkings = (TextView) findViewById(R.id.checklistMarkings);
        checklistVisual = (TextView) findViewById(R.id.checklistVisual);
        checklistCabin = (TextView) findViewById(R.id.checklistCabin);
        checklistLoadChart = (TextView) findViewById(R.id.checklistLoadChart);
        checklistChassis = (TextView) findViewById(R.id.checklistChassis);
        checklistTyres = (TextView) findViewById(R.id.checklistTyres);
        checklistSlewing = (TextView) findViewById(R.id.checklistSlewing);
        checklistFluid = (TextView) findViewById(R.id.checklistFluid);
        checklistOutrigger = (TextView) findViewById(R.id.checklistOutriggers);
        checklistSuperstructure = (TextView) findViewById(R.id.checklistSuperstructure);
        checklistSparkArrestor = (TextView) findViewById(R.id.checklistSparkArrestor);
        checklistHydraulics = (TextView) findViewById(R.id.checklistHydraulics);
        checklistBraking = (TextView) findViewById(R.id.checklistBraking);
        checklistConnections = (TextView) findViewById(R.id.checklistConnections);
        checklistMainDia = (TextView) findViewById(R.id.checklistMainDia);
        checklistAuxDia = (TextView) findViewById(R.id.checklistAuxDia);
        checklistTrolleyDia = (TextView) findViewById(R.id.checklistTrolleyDia);
        checklistForks = (TextView) findViewById(R.id.checklistForks);
        checklistCylinder = (TextView) findViewById(R.id.checklistCylinder);
        checklistMainLinePull = (TextView) findViewById(R.id.checklistMainLinePull);
        checklistAuxLinePull = (TextView) findViewById(R.id.checklistAuxLinePull);
        checklistWireRope = (TextView) findViewById(R.id.checklistWireRope);
        checklistControls = (TextView) findViewById(R.id.checklistControls);
        checklistSpeed = (TextView) findViewById(R.id.checklistSpeed);
        checklistEmergencyStop = (TextView) findViewById(R.id.checklistEmergencyStop);
        checklistLimitSwitches = (TextView) findViewById(R.id.checklistLimitSwitches);
        checklistElectrical = (TextView) findViewById(R.id.checklistElectrical);
        checklistBatteries = (TextView) findViewById(R.id.checklistBatteries);
        checklistOverload = (TextView) findViewById(R.id.checklistOverload);
        checklistTilting = (TextView) findViewById(R.id.checklistTilting);
        checklistAnemometer = (TextView) findViewById(R.id.checklistAnemometer);
        checklistLights = (TextView) findViewById(R.id.checklistLights);
        checklistEarthing = (TextView) findViewById(R.id.checklistEarthing);
        checklistFunctions = (TextView) findViewById(R.id.checklistFunctions);
        checklistEmergencyFunctions = (TextView) findViewById(R.id.checklistEmergencyFunctions);
        checklistWeight1 = (TextView) findViewById(R.id.checklistWeight1);
        checklistWeight2 = (TextView) findViewById(R.id.checklistWeight2);
        checklistLength1 = (TextView) findViewById(R.id.checklistLength1);
        checklistLength2 = (TextView) findViewById(R.id.checklistLength2);
        checklistTestSwl1 = (TextView) findViewById(R.id.checklistTestSwl1);
        checklistTestSwl2 = (TextView) findViewById(R.id.checklistTestSwl2);
        checklistTestSwl3 = (TextView) findViewById(R.id.checklistTestSwl3);
        checklistTestSwl4 = (TextView) findViewById(R.id.checklistTestSwl4);
        checklistAppliedLoad1 = (TextView) findViewById(R.id.checklistAppliedLoad1);
        checklistAppliedLoad2 = (TextView) findViewById(R.id.checklistAppliedLoad2);
        checklistAppliedLoad3 = (TextView) findViewById(R.id.checklistAppliedLoad3);
        checklistAppliedLoad4 = (TextView) findViewById(R.id.checklistAppliedLoad4);
        checklistBoomLength1 = (TextView) findViewById(R.id.checklistBoomLength1);
        checklistBoomLength2 = (TextView) findViewById(R.id.checklistBoomLength2);
        checklistBoomLength3 = (TextView) findViewById(R.id.checklistBoomLength3);
        checklistBoomLength4 = (TextView) findViewById(R.id.checklistBoomLength4);
        checklistTestRadius1 = (TextView) findViewById(R.id.checklistTestRadius1);
        checklistTestRadius2 = (TextView) findViewById(R.id.checklistTestRadius2);
        checklistTestRadius3 = (TextView) findViewById(R.id.checklistTestRadius3);
        checklistTestRadius4 = (TextView) findViewById(R.id.checklistTestRadius4);
        checklistTestInfo = (TextView) findViewById(R.id.checklistTestInfo);
        checklistDeflection = (TextView) findViewById(R.id.checklistDeflection);
        checklistDefects = (TextView) findViewById(R.id.checklistDefects);
        checklistRecommendations = (TextView) findViewById(R.id.checklistRecommendations);
        checklistOutcome = (TextView) findViewById(R.id.checklistOutcome);
        time = (TextView) findViewById(R.id.completedTime);

        getData();


        System.out.println("Photo Active : " + photoActive);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        outcomeImage.setImageBitmap(null);
        bgLayer.setBackground(null);
        certificateLayout.removeAllViews();
    }


    public void getData(){
        Cursor cursor = myDB.getContent(globalVariables.ID, sqlDB);
        if (cursor.moveToFirst()) {
            String FLEET = cursor.getString(1);
            String SERIAL = cursor.getString(2);
            String CLIENT = cursor.getString(3);
            String DATE = cursor.getString(4);
            String EQUIPMENT_TYPE = cursor.getString(5);
            String INSPECTION_TYPE = cursor.getString(6);
            String LOCATION = cursor.getString(7);
            String ADDRESS = cursor.getString(8);
            String TIMESHEET = cursor.getString(9);
            String RECORDS = cursor.getString(10);
            String NDT_REPORT = cursor.getString(11);
            String PREVIOUS_EXAM_CERT = cursor.getString(12);
            String PREVIOUS_EXAM_DATE = cursor.getString(13);
            String PREVIOUS_TEST_CERT = cursor.getString(14);
            String PREVIOUS_TEST_DATE = cursor.getString(15);
            String MAIN_ROPE_CERT = cursor.getString(16);
            String AUX_ROPE_CERT = cursor.getString(17);
            String NAME = cursor.getString(18);
            String LENGTH = cursor.getString(19);
            String WEIGHT = cursor.getString(20);
            String DETAIL_1 = cursor.getString(21);
            String DETAIL_2 = cursor.getString(22);
            String DETAIL_3 = cursor.getString(23);
            String DETAIL_4 = cursor.getString(24);
            String DETAIL_5 = cursor.getString(25);
            String REASON = cursor.getString(26);
            String STANDARD = cursor.getString(27);
            String DESCRIPTION = cursor.getString(28);
            String MAKE = cursor.getString(29);
            String MODEL = cursor.getString(30);
            String REG = cursor.getString(31);
            String SWL = cursor.getString(32);
            String COUNTER_WEIGHT = cursor.getString(33);
            String CENTER_BALLAST = cursor.getString(34);
            String INFO_1_TITLE = cursor.getString(35);
            String INFO_1 = cursor.getString(36);
            String INFO_2_TITLE = cursor.getString(37);
            String INFO_2 = cursor.getString(38);
            String INFO_3_TITLE = cursor.getString(39);
            String INFO_3 = cursor.getString(40);
            String INFO_4_TITLE = cursor.getString(41);
            String INFO_4 = cursor.getString(42);
            String MANUAL = cursor.getString(43);
            String MARKINGS = cursor.getString(44);
            String CABIN = cursor.getString(45);
            String FIRE_EXTINGUISHER = cursor.getString(46);
            String VISUAL = cursor.getString(47);
            String LOAD_CHART = cursor.getString(48);
            String CHASSIS = cursor.getString(49);
            String SLEWING = cursor.getString(50);
            String OUTRIGGER = cursor.getString(51);
            String SPARK_ARRESTOR = cursor.getString(52);
            String BRAKING = cursor.getString(53);
            String CYLINDERS = cursor.getString(54);
            String FORKS = cursor.getString(55);
            String TYRES = cursor.getString(56);
            String FLUID = cursor.getString(57);
            String SUPERSTRUCTURE = cursor.getString(58);
            String HYDRAULIC = cursor.getString(59);
            String CONNECTIONS = cursor.getString(60);
            String WIRE_ROPE = cursor.getString(61);
            String ROPE_MAIN = cursor.getString(62);
            String ROPE_AUX = cursor.getString(63);
            String ROPE_TROLLEY = cursor.getString(64);
            String MAIN_LINE_PULL = cursor.getString(65);
            String AUX_LINE_PULL = cursor.getString(66);
            String CONTROLS = cursor.getString(67);
            String EMERGENCY_STOP = cursor.getString(68);
            String ELECTRICAL_SYSTEM = cursor.getString(69);
            String OVERLOAD = cursor.getString(70);
            String ANEMOMETER = cursor.getString(71);
            String EARTHING = cursor.getString(72);
            String SPEED = cursor.getString(73);
            String LIMIT_SWITCHES = cursor.getString(74);
            String BATTERIES = cursor.getString(75);
            String TILTING = cursor.getString(76);
            String LIGHTS = cursor.getString(77);
            String FUNCTIONS = cursor.getString(78);
            String EMERGENCY_FUNCTIONS = cursor.getString(79);
            String TEST_SWL_1 = cursor.getString(80);
            String TEST_SWL_2 = cursor.getString(81);
            String TEST_SWL_3 = cursor.getString(82);
            String TEST_SWL_4 = cursor.getString(83);
            String APPLIED_LOAD_1 = cursor.getString(84);
            String APPLIED_LOAD_2 = cursor.getString(85);
            String APPLIED_LOAD_3 = cursor.getString(86);
            String APPLIED_LOAD_4 = cursor.getString(87);
            String BOOM_LENGTH_1 = cursor.getString(88);
            String BOOM_LENGTH_2 = cursor.getString(89);
            String BOOM_LENGTH_3 = cursor.getString(90);
            String BOOM_LENGTH_4 = cursor.getString(91);
            String TEST_RADIUS_1 = cursor.getString(92);
            String TEST_RADIUS_2 = cursor.getString(93);
            String TEST_RADIUS_3 = cursor.getString(94);
            String TEST_RADIUS_4 = cursor.getString(95);
            String TEST_INFO = cursor.getString(96);
            String CREEPING = cursor.getString(97);
            String OUTCOME = cursor.getString(98);
            String DEFECTS = cursor.getString(99);
            String RECOMMENDATIONS = cursor.getString(100);
            String NEXT_EXAM = cursor.getString(101);
            String NEXT_TEST = cursor.getString(102);
            String TIME = cursor.getString(103);
            String START = cursor.getString(104);
            String DURATION = cursor.getString(105);

            String CALIBRATION_1 = cursor.getString(106);
            String CALIBRATION_2 = cursor.getString(107);
            String CALIBRATION_3 = cursor.getString(108);
            String CALIBRATION_4 = cursor.getString(109);
            String IMAGES_ACTIVE = cursor.getString(110);
            String IMAGEURI1 = cursor.getString(111);
            String IMAGEURI2 = cursor.getString(112);
            String IMAGEURI3 = cursor.getString(113);
            String IMAGEURI4 = cursor.getString(114);

            checklistCalibrated1.setText(CALIBRATION_1);
            checklistCalibrated2.setText(CALIBRATION_2);
            checklistCalibrated3.setText(CALIBRATION_3);
            checklistCalibrated4.setText(CALIBRATION_4);

            String CERTNO = cursor.getString(115);

            calibrationItem1.setText(CALIBRATION_1);
            calibrationItem2.setText(CALIBRATION_2);
            calibrationItem3.setText(CALIBRATION_3);
            calibrationItem4.setText(CALIBRATION_4);


                photoActive = "no";

                if (IMAGEURI1.contains("content://")) {
                    photo1.setImageURI(Uri.parse(IMAGEURI1));
                    photoActive = "yes";
                }
                if (IMAGEURI2.contains("content://")) {
                    photo2.setImageURI(Uri.parse(IMAGEURI2));
                    photoActive = "yes";
                }
                if (IMAGEURI3.contains("content://")) {
                    photo3.setImageURI(Uri.parse(IMAGEURI3));
                    photoActive = "yes";
                }
                if (IMAGEURI4.contains("content://")) {
                    photo4    .setImageURI(Uri.parse(IMAGEURI4));
                    photoActive = "yes";
                }


            if (CALIBRATION_1.equals("")) {
                calibrationTitle.setText("No Additional Equipment Used");
                calibrationRow1.setVisibility(View.GONE);
                calibrationRow2.setVisibility(View.GONE);
            } else if (CALIBRATION_3.equals("")) {
                calibrationRow2.setVisibility(View.GONE);
            }

            time.setText(TIME);
            name_completed.setText(NAME);
            globalVariables.FLEET_NUMBER = FLEET;
            globalVariables.SERIAL_NUMBER = SERIAL;
            globalVariables.CLIENT = CLIENT;
            globalVariables.DATE = DATE;
            globalVariables.NAME = NAME;
            globalVariables.NEXT_INSPECTION = NEXT_EXAM;
            globalVariables.OUTCOME = OUTCOME;
            globalVariables.END_TIME = TIME;
            globalVariables.TIMESHEET = TIMESHEET;



            if (globalVariables.OUTCOME_STRING.equals("Fail")) {
                setScaledImage(outcomeImage, R.drawable.fail_icon);
                outcomeText.setText("The equipment was found Unsatisfactory.");
                completeText.setText("Inspection Complete");
                System.out.println(globalVariables.OUTCOME_STRING);

            }
            if (globalVariables.OUTCOME_STRING.equals("Pass")) {
                setScaledImage(outcomeImage, R.drawable.pass_icon);
                outcomeText.setText("The equipment was found Satisfactory.");
                completeText.setText("Inspection Complete");
                System.out.println(globalVariables.OUTCOME_STRING);

            } else if (globalVariables.OUTCOME_STRING.equals("")) {
                setScaledImage(outcomeImage, R.drawable.incomplete_icon);
                outcomeText.setText(" ");
                completeText.setText("Inspection Incomplete");
                System.out.println(globalVariables.OUTCOME_STRING);
            }

            if (OUTCOME.equals("Satisfactory") && INSPECTION_TYPE.equals("Thorough Examination")) {
                inspectionType.setText("of Thorough Examination of Lifting Appliance");
                inspectionTypeBack.setText("of Thorough Examination of Lifting Appliance");
                photoTitle.setText("of Thorough Examination of Lifting Appliance");



            } else if (OUTCOME.equals("Satisfactory") && INSPECTION_TYPE.equals("Test & Examination")) {
                inspectionType.setText("of Test & Thorough Examination of Lifting Appliance");
                inspectionTypeBack.setText("of Test & Thorough Examination of Lifting Appliance");
                photoTitle.setText("of Test & Thorough Examination of Lifting Appliance");


            } else if (OUTCOME.equals("Unsatisfactory")) {
                inspectionType.setText("of Non-Conformity");
                inspectionTypeBack.setText("of Non-Conformity");
                photoTitle.setText("of Non-Conformity");


            }


            if (OUTCOME.equals("Satisfactory")) {
                safe.setText("No");
            } else if (OUTCOME.equals("Unsatisfactory")) {
                safe.setText("Yes");
            }

            if (OUTCOME.equals("Satisfactory")) {
                result.setText("Satisfactory");
            } else if (OUTCOME.equals("Unsatisfactory")) {
                result.setText("Unsatisfactory");
                Page1Cert.setBackgroundResource(R.drawable.unsafe_bg);
            }

            date.setText(DATE);
            client.setText(CLIENT);
            address.setText(ADDRESS);
            location.setText(LOCATION);

            if (STANDARD.equals(" ")) {
                standard.setText("Local Regulations");
            } else {
                standard.setText(STANDARD);
            }

            make.setText(MAKE);
            swl.setText(SWL);

            if (REG.equals(" ")) {
                reg.setText("N/A");
            } else {
                reg.setText(REG);
            }

            if (FLEET.equals(" ")) {
                fleet.setText("N/A");
            } else {
                fleet.setText(FLEET);
            }

            serial.setText(SERIAL);
            model.setText(MODEL);
            description.setText(DESCRIPTION);
            info1Title.setText(INFO_1_TITLE);
            info2Title.setText(INFO_2_TITLE);
            info3Title.setText(INFO_3_TITLE);
            info4Title.setText(INFO_4_TITLE);
            info1.setText(INFO_1);
            info2.setText(INFO_2);
            info3.setText(INFO_3);
            info4.setText(INFO_4);

            if (DETAIL_1.equals("Yes")) {
                detail1Y.setText("Yes");
                detail1NA.setText("-");
                detail1N.setText("-");
            } else if (DETAIL_1.equals("N/A")) {
                detail1Y.setText("-");
                detail1NA.setText("N/A");
                detail1N.setText("-");
            } else if (DETAIL_1.equals("No")) {
                detail1Y.setText("-");
                detail1NA.setText("-");
                detail1N.setText("No");
            }

            if (DETAIL_2.equals("Yes")) {
                detail2Y.setText("Yes");
                detail2NA.setText("-");
                detail2N.setText("-");
            } else if (DETAIL_2.equals("N/A")) {
                detail2Y.setText("-");
                detail2NA.setText("N/A");
                detail2N.setText("-");
            } else if (DETAIL_2.equals("No")) {
                detail2Y.setText("-");
                detail2NA.setText("-");
                detail2N.setText("No");
            }

            if (DETAIL_3.equals("Yes")) {
                detail3Y.setText("Yes");
                detail3NA.setText("-");
                detail3N.setText("-");
            } else if (DETAIL_3.equals("N/A")) {
                detail3Y.setText("-");
                detail3NA.setText("N/A");
                detail3N.setText("-");
            } else if (DETAIL_3.equals("No")) {
                detail3Y.setText("-");
                detail3NA.setText("-");
                detail3N.setText("No");
            }

            if (DETAIL_4.equals("Yes")) {
                detail4Y.setText("Yes");
                detail4NA.setText("-");
                detail4N.setText("-");
            } else if (DETAIL_4.equals("N/A")) {
                detail4Y.setText("-");
                detail4NA.setText("N/A");
                detail4N.setText("-");
            } else if (DETAIL_4.equals("No")) {
                detail4Y.setText("-");
                detail4NA.setText("-");
                detail4N.setText("No");
            }

            if (DETAIL_5.equals("Yes")) {
                detail5Y.setText("Yes");
                detail5NA.setText("-");
                detail5N.setText("-");
            } else if (DETAIL_5.equals("N/A")) {
                detail5Y.setText("-");
                detail5NA.setText("N/A");
                detail5N.setText("-");
            } else if (DETAIL_5.equals("No")) {
                detail5Y.setText("-");
                detail5NA.setText("-");
                detail5N.setText("No");
            }


            if (REASON.equals("A")) {
                reason.setText("Within an Interval of 6 Months");
            } else if (REASON.equals("B")) {
                reason.setText("Within an Interval of 12 Months");
            } else if (REASON.equals("C")) {
                reason.setText("In Accordance with an Examination Schedule");
            } else if (REASON.equals("D")) {
                reason.setText("After the Occurrence of Exceptional Circumstances");
            } else if (REASON.equals("E")) {
                reason.setText("New Installation of the Equipment");
            } else if (REASON.equals("F")) {
                reason.setText("After Reconfiguration of the Equipment");
            } else if (REASON.equals("G")) {
                reason.setText("New Equipment");
            } else if (REASON.equals("H")) {
                reason.setText("Upon Request of the Client");
            }

            length1.setText("(" + LENGTH + ")");
            length2.setText("(" + LENGTH + ")");
            weight1.setText("(" + WEIGHT + ")");
            weight2.setText("(" + WEIGHT + ")");

            if (TEST_SWL_1.equals(" ")) {
                testSWL1.setText("-");
            } else {
                testSWL1.setText(TEST_SWL_1);
            }
            if (TEST_SWL_2.equals(" ")) {
                testSWL2.setText("-");
            } else {
                testSWL2.setText(TEST_SWL_2);
            }
            if (TEST_SWL_3.equals(" ")) {
                testSWL3.setText("-");
            } else {
                testSWL3.setText(TEST_SWL_3);
            }
            if (TEST_SWL_4.equals(" ")) {
                testSWL4.setText("-");
            } else {
                testSWL4.setText(TEST_SWL_4);
            }

            if (APPLIED_LOAD_1.equals(" ")) {
                appliedLoad1.setText("-");
            } else {
                appliedLoad1.setText(APPLIED_LOAD_1);
            }
            if (APPLIED_LOAD_2.equals(" ")) {
                appliedLoad2.setText("-");
            } else {
                appliedLoad2.setText(APPLIED_LOAD_2);
            }
            if (APPLIED_LOAD_3.equals(" ")) {
                appliedLoad3.setText("-");
            } else {
                appliedLoad3.setText(APPLIED_LOAD_3);
            }
            if (APPLIED_LOAD_4.equals(" ")) {
                appliedLoad4.setText("-");
            } else {
                appliedLoad4.setText(APPLIED_LOAD_4);
            }

            if (BOOM_LENGTH_1.equals(" ")) {
                boomLength1.setText("-");
            } else {
                boomLength1.setText(BOOM_LENGTH_1);
            }
            if (BOOM_LENGTH_2.equals(" ")) {
                boomLength2.setText("-");
            } else {
                boomLength2.setText(BOOM_LENGTH_2);
            }
            if (BOOM_LENGTH_3.equals(" ")) {
                boomLength3.setText("-");
            } else {
                boomLength3.setText(BOOM_LENGTH_3);
            }
            if (BOOM_LENGTH_4.equals(" ")) {
                boomLength4.setText("-");
            } else {
                boomLength4.setText(BOOM_LENGTH_4);
            }

            if (TEST_RADIUS_1.equals(" ")) {
                radius1.setText("-");
            } else {
                radius1.setText(TEST_RADIUS_1);
            }
            if (TEST_RADIUS_2.equals(" ")) {
                radius2.setText("-");
            } else {
                radius2.setText(TEST_RADIUS_2);
            }
            if (TEST_RADIUS_3.equals(" ")) {
                radius3.setText("-");
            } else {
                radius3.setText(TEST_RADIUS_3);
            }
            if (TEST_RADIUS_4.equals(" ")) {
                radius4.setText("-");
            } else {
                radius4.setText(TEST_RADIUS_4);
            }

            if (TEST_INFO.equals(" ")) {
                testInfo.setText(" No Additional Information.");
            } else {
                testInfo.setText(TEST_INFO);
            }

            if (DEFECTS.equals(" ")) {
                defects.setText("No Defects Found.");
            } else {
                defects.setText(DEFECTS);
            }

            if (RECOMMENDATIONS.equals(" ")) {
                recommendations.setText("No Recommendations Given.");
            } else {
                recommendations.setText(RECOMMENDATIONS);
            }

            if (PREVIOUS_EXAM_CERT.equals(" ")) {
                previousExamCert.setText("-");
            } else {
                previousExamCert.setText(PREVIOUS_EXAM_CERT);
            }
            if (PREVIOUS_EXAM_DATE.equals(" ")) {
                previousExamDate.setText("Not Available");
            } else {
                previousExamDate.setText(PREVIOUS_EXAM_DATE);
            }

            if (PREVIOUS_TEST_CERT.equals(" ")) {
                previousTestCert.setText("-");
            } else {
                previousTestCert.setText(PREVIOUS_TEST_CERT);
            }
            if (PREVIOUS_TEST_DATE.equals(" ")) {
                previousTestDate.setText("Not Available");
            } else {
                previousTestDate.setText(PREVIOUS_TEST_DATE);
            }

            if (OUTCOME.equals("Satisfactory")) {
                if (EQUIPMENT_TYPE.equals("MEWP/AWP") || EQUIPMENT_TYPE.equals("Forklift") || EQUIPMENT_TYPE.equals("Telehandler")) {
                    nextExam.setText(NEXT_EXAM);
                    nextTest.setText(NEXT_TEST);
                } else {
                    nextExam.setText(NEXT_EXAM + " or on Next Reconfiguration.");
                    nextTest.setText(NEXT_TEST + " or on Next Reconfiguration.");
                }
            } else if (OUTCOME.equals("Unsatisfactory")){
                nextExam.setText("Upon Rectification");
                nextTest.setText("Upon Rectification");
            }

            name.setText(NAME);
            timesheet.setText(TIMESHEET);

            DateFormat df = new SimpleDateFormat("dd MMM yyyy");
            String date = df.format(Calendar.getInstance().getTime());
            issueDate.setText(date);

            dateBack.setText(DATE);
            photoDate.setText(DATE);
            superstructure.setText(SUPERSTRUCTURE);
            markings.setText(MARKINGS);
            controls.setText(CONTROLS);
            emergencyStop.setText(EMERGENCY_STOP);
            tilting.setText(TILTING);
            overload.setText(OVERLOAD);
            emergenyFunctions.setText(EMERGENCY_FUNCTIONS);
            electrical.setText(ELECTRICAL_SYSTEM);
            hydraulics.setText(HYDRAULIC);
            speed.setText(SPEED);
            slewing.setText(SLEWING);
            braking.setText(BRAKING);
            tyres.setText(TYRES);
            outrigger.setText(OUTRIGGER);
            sparkArrestor.setText(SPARK_ARRESTOR);
            lights.setText(LIGHTS);
            fireExtinguisher.setText(FIRE_EXTINGUISHER);

            if (ROPE_MAIN.equals(" ")) {
                mainWire.setText("N/A");
            } else {
                mainWire.setText(ROPE_MAIN);
            }

            if (ROPE_AUX.equals(" ")) {
                auxWire.setText("N/A");
            } else {
                auxWire.setText(ROPE_MAIN);
            }

            if (ROPE_TROLLEY.equals(" ")) {
                trolleyWire.setText("N/A");
            } else {
                trolleyWire.setText(ROPE_MAIN);
            }

            wireRope.setText(WIRE_ROPE);

            if (ROPE_MAIN.equals(" ") && MAIN_ROPE_CERT.equals(" ")) {
                mainRopeCert.setText("Not Applicable");
            } else if (ROPE_MAIN != " " && MAIN_ROPE_CERT.equals(" ")) {
                mainRopeCert.setText("Not Available");
            } else {
                mainRopeCert.setText(MAIN_ROPE_CERT);
            }

            if (ROPE_AUX.equals(" ") && AUX_ROPE_CERT.equals(" ")) {
                auxRopeCert.setText("Not Applicable");
            } else if (ROPE_AUX != " " && AUX_ROPE_CERT.equals(" ")) {
                auxRopeCert.setText("Not Available");
            } else {
                auxRopeCert.setText(AUX_ROPE_CERT);
            }

            if (MAIN_LINE_PULL.equals(" ")) {
                mainLinePull.setText("Not Applicable");
            } else {
                mainLinePull.setText(MAIN_LINE_PULL);
            }

            if (AUX_LINE_PULL.equals(" ")) {
                auxLinePull.setText("Not Applicable");
            } else {
                auxLinePull.setText(AUX_LINE_PULL);
            }

            if (COUNTER_WEIGHT.equals(" ")) {
                CW.setText("Not Applicable");
            } else {
                CW.setText(COUNTER_WEIGHT);
            }

            if (CENTER_BALLAST.equals(" ")) {
                ballast.setText("Not Applicable");
            } else {
                ballast.setText(CENTER_BALLAST);
            }

            visual.setText(VISUAL);
            functions.setText(FUNCTIONS);
            earthing.setText(EARTHING);

            if (CREEPING.equals(" ")) {
                creeping.setText("Nil");
            } else {
                creeping.setText(CREEPING);
            }

            if (NDT_REPORT.equals(" ")) {
                ndt.setText("No Test Carried Out");
            } else {
                ndt.setText(NDT_REPORT);
            }

            manual.setText(MANUAL);
            // nameBack.setText(NAME);

            if (OUTCOME.equals("Satisfactory")) {
                //comments.setText("At the time of examination, this machine was found satisfactory for further use.");
            } else if (OUTCOME.equals("Unsatisfactory with Photos") || OUTCOME.equals("Unsatisfactory without Photos")) {
                //comments.setText("At the time of examination, this machine was found unsatisfactory for further use.");
            }

            certLabel.setText(CERTNO);
            certLabel2.setText(CERTNO);

            //Checklist
            checklistInspectionType.setText(INSPECTION_TYPE);
            checklistName.setText(NAME);
            checklistClient.setText(CLIENT);
            checklistLocation.setText(LOCATION);
            checklistDate.setText(DATE);
            checklistTimesheet.setText(TIMESHEET);
            checklistRecords.setText(RECORDS);
            checklistNDT.setText(NDT_REPORT);
            checklistExamCert.setText(PREVIOUS_EXAM_CERT);
            checklistExamDate.setText(PREVIOUS_EXAM_DATE);
            checklistTestCert.setText(PREVIOUS_TEST_CERT);
            checklistTestDate.setText(PREVIOUS_TEST_DATE);
            checklistMainRopeCert.setText(MAIN_ROPE_CERT);
            checklistAuxRopeCert.setText(AUX_ROPE_CERT);
            checklistStandard.setText(STANDARD);
            checklistDescription.setText(DESCRIPTION);
            checklistMake.setText(MAKE);
            checklistModel.setText(MODEL);
            checklistSerial.setText(SERIAL);
            checklistFleet.setText(FLEET);
            checklistReg.setText(REG);
            checklistSWL.setText(SWL);
            checklistCW.setText(COUNTER_WEIGHT);
            checklistBallast.setText(CENTER_BALLAST);
            checklistInfo1.setText(INFO_1);
            checklistInfo1Title.setText(INFO_1_TITLE);
            checklistInfo2.setText(INFO_2);
            checklistInfo2Title.setText(INFO_2_TITLE);
            checklistInfo3.setText(INFO_3);
            checklistInfo3Title.setText(INFO_3_TITLE);
            checklistInfo4.setText(INFO_4);
            checklistInfo4Title.setText(INFO_4_TITLE);
            checklistManual.setText(MANUAL);
            checklistFireExtinguisher.setText(FIRE_EXTINGUISHER);
            checklistMarkings.setText(MARKINGS);
            checklistVisual.setText(VISUAL);
            checklistCabin.setText(CABIN);
            checklistLoadChart.setText(LOAD_CHART);
            checklistChassis.setText(CHASSIS);
            checklistTyres.setText(TYRES);
            checklistSlewing.setText(SLEWING);
            checklistFluid.setText(FLUID);
            checklistOutrigger.setText(OUTRIGGER);
            checklistSuperstructure.setText(SUPERSTRUCTURE);
            checklistSparkArrestor.setText(SPARK_ARRESTOR);
            checklistHydraulics.setText(HYDRAULIC);
            checklistBraking.setText(BRAKING);
            checklistConnections.setText(CONNECTIONS);
            checklistMainDia.setText(ROPE_MAIN);
            checklistAuxDia.setText(ROPE_AUX);
            checklistTrolleyDia.setText(ROPE_TROLLEY);
            checklistForks.setText(FORKS);
            checklistCylinder.setText(CYLINDERS);
            checklistMainLinePull.setText(MAIN_LINE_PULL);
            checklistAuxLinePull.setText(AUX_LINE_PULL);
            checklistWireRope.setText(WIRE_ROPE);
            checklistControls.setText(CONTROLS);
            checklistSpeed.setText(SPEED);
            checklistEmergencyStop.setText(EMERGENCY_STOP);
            checklistLimitSwitches.setText(LIMIT_SWITCHES);
            checklistElectrical.setText(ELECTRICAL_SYSTEM);
            checklistBatteries.setText(BATTERIES);
            checklistOverload.setText(OVERLOAD);
            checklistTilting.setText(TILTING);
            checklistAnemometer.setText(ANEMOMETER);
            checklistLights.setText(LIGHTS);
            checklistEarthing.setText(EARTHING);
            checklistFunctions.setText(FUNCTIONS);
            checklistEmergencyFunctions.setText(EMERGENCY_FUNCTIONS);
            checklistWeight1.setText("(" + WEIGHT + ")");
            checklistWeight2.setText("(" + WEIGHT + ")");
            checklistLength1.setText("(" + LENGTH + ")");
            checklistLength2.setText("(" + LENGTH + ")");
            checklistTestSwl1.setText(TEST_SWL_1);
            checklistTestSwl2.setText(TEST_SWL_2);
            checklistTestSwl3.setText(TEST_SWL_3);
            checklistTestSwl4.setText(TEST_SWL_4);
            checklistAppliedLoad1.setText(APPLIED_LOAD_1);
            checklistAppliedLoad2.setText(APPLIED_LOAD_2);
            checklistAppliedLoad3.setText(APPLIED_LOAD_3);
            checklistAppliedLoad4.setText(APPLIED_LOAD_4);
            checklistBoomLength1.setText(BOOM_LENGTH_1);
            checklistBoomLength2.setText(BOOM_LENGTH_2);
            checklistBoomLength3.setText(BOOM_LENGTH_3);
            checklistBoomLength4.setText(BOOM_LENGTH_4);
            checklistTestRadius1.setText(TEST_RADIUS_1);
            checklistTestRadius2.setText(TEST_RADIUS_2);
            checklistTestRadius3.setText(TEST_RADIUS_3);
            checklistTestRadius4.setText(TEST_RADIUS_4);

            checklistOutcome.setText(OUTCOME);

            if (TEST_INFO.equals(" ")) {
                checklistTestInfo.setText(" No Additional Information.");
            } else {
                checklistTestInfo.setText(TEST_INFO);
            }

            if (DEFECTS.equals(" ")) {
                checklistDefects.setText("No Defects Found.");
            } else {
                checklistDefects.setText(DEFECTS);
            }

            if (RECOMMENDATIONS.equals(" ")) {
                checklistRecommendations.setText("No Recommendations Given.");
            } else {
                checklistRecommendations.setText(RECOMMENDATIONS);
            }

            if (CREEPING.equals(" ")) {
                checklistDeflection.setText("Nil");
            } else {
                checklistDeflection.setText(CREEPING);
            }

            if (OUTCOME.equals("Satisfactory")) {
                checklistOutcome.setText("Satisfactory");
            } else {
                checklistOutcome.setText("Unsatisfactory");
            }


        }
    }

    void createPDF(View page1, View page2, View page3, View page4, View page5) {
        PdfDocument document = new PdfDocument();

        viewHeight = view.getMeasuredHeight();
        viewWidth = view.getMeasuredWidth();


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Request missing location permission.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE_LOCATION);
        } else {
            // Location permission has been granted, continue as usual.
            // Page 1
            View content = page1;
            int pageNumber = 1;
            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(viewWidth, viewHeight, pageNumber).create();
            PdfDocument.Page page = document.startPage(pageInfo);
            content.draw(page.getCanvas());
            document.finishPage(page);

            // Page 2
            View content2 = page2;
            int pageNumber2 = 2;
            PdfDocument.PageInfo pageInfo2 = new PdfDocument.PageInfo.Builder(viewWidth, viewHeight, pageNumber2).create();
            PdfDocument.Page pageTwo = document.startPage(pageInfo2);
            content2.draw(pageTwo.getCanvas());
            document.finishPage(pageTwo);

            if (photoActive.equals("yes")) {
                // Page 3
                View content3 = page3;
                int pageNumber3 = 3;
                PdfDocument.PageInfo pageInfo3 = new PdfDocument.PageInfo.Builder(viewWidth, viewHeight, pageNumber3).create();
                PdfDocument.Page pageThree = document.startPage(pageInfo3);
                content3.draw(pageThree.getCanvas());
                document.finishPage(pageThree);

                // Page 4
                View content4 = page4;
                int pageNumber4 = 4;
                PdfDocument.PageInfo pageInfo4 = new PdfDocument.PageInfo.Builder(viewWidth, viewHeight, pageNumber4).create();
                PdfDocument.Page pageFour = document.startPage(pageInfo4);
                content4.draw(pageFour.getCanvas());
                document.finishPage(pageFour);

                // Page 5
                View content5 = page5;
                int pageNumber5 = 5;
                PdfDocument.PageInfo pageInfo5 = new PdfDocument.PageInfo.Builder(viewWidth, viewHeight, pageNumber5).create();
                PdfDocument.Page pageFive = document.startPage(pageInfo5);
                content5.draw(pageFive.getCanvas());
                document.finishPage(pageFive);

            } else {
                // Page 3
                View content3 = page3;
                int pageNumber3 = 3;
                PdfDocument.PageInfo pageInfo3 = new PdfDocument.PageInfo.Builder(viewWidth, viewHeight, pageNumber3).create();
                PdfDocument.Page pageThree = document.startPage(pageInfo3);
                content3.draw(pageThree.getCanvas());
                document.finishPage(pageThree);

                // Page 4
                View content4 = page4;
                int pageNumber4 = 4;
                PdfDocument.PageInfo pageInfo4 = new PdfDocument.PageInfo.Builder(viewWidth, viewHeight, pageNumber4).create();
                PdfDocument.Page pageFour = document.startPage(pageInfo4);
                content4.draw(pageFour.getCanvas());
                document.finishPage(pageFour);
            }


            // saving pdf document to sdcard
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            String pdfName;
            String fleetNo;

            if (fleet.equals("N/A")) {
                pdfName = certLabel.getText().toString() + " ("+ serial.getText().toString() +")" + ".pdf";
            }else {

                if (fleet.getText().toString().contains("/")){
                    fleetNo = fleet.getText().toString();
                    fleetNo = fleetNo.replace("/", "-");
                } else{
                    fleetNo = fleet.getText().toString();
                }

                pdfName = certLabel.getText().toString() + " ("+ fleetNo +")" + ".pdf";
            }
            // all created files will be saved at path /sdcard/PDFDemo_AndroidSRC/
            String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
            File outputFile = new File(sd, pdfName);

            globalVariables.PDF_NAME = pdfName;

            try {
                outputFile.createNewFile();
                OutputStream out = new FileOutputStream(outputFile);
                document.writeTo(out);
                document.close();
                out.close();

            } catch (IOException e) {
                e.printStackTrace();

            }

        }


    }


    //IMAGE COMPRESSION
    private void setScaledImage(ImageView imageView, final int resId) {
        final ImageView iv = imageView;
        ViewTreeObserver viewTreeObserver = iv.getViewTreeObserver();
        viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                iv.getViewTreeObserver().removeOnPreDrawListener(this);
                int imageViewHeight = iv.getMeasuredHeight();
                int imageViewWidth = iv.getMeasuredWidth();
                iv.setImageBitmap(
                        decodeSampledBitmapFromResource(getResources(),
                                resId, imageViewWidth, imageViewHeight));
                return true;
            }
        });
    }

    private static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                          int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds = true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    private static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {

        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    // Storage Permissions variables
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "Manifest.permission.READ_EXTERNAL_STORAGE",
            "Manifest.permission.WRITE_EXTERNAL_STORAGE"
    };

    //persmission method.
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, "Manifest.permission.WRITE_EXTERNAL_STORAGE");
        int readPermission = ActivityCompat.checkSelfPermission(activity, "Manifest.permission.READ_EXTERNAL_STORAGE");

        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}
