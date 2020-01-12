package com.jc_designs.mytpi.Appliances;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.jc_designs.mytpi.R;
import com.jc_designs.mytpi.globalVariables;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Joshua on 24/06/2016.
 */
public class Machine_Checklist extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

        Machine_Database myDB;
        SQLiteDatabase sqlDB;

        String time;
        String duration;
        String start;

        EditText certField;

        //Spinner Declarations
        Spinner factor1Spinner;
        Spinner factor2Spinner;
        Spinner factor3Spinner;
        Spinner factor4Spinner;
        Spinner equipmentTypeSpinner;
        Spinner inspectionTypeSpinner;
        Spinner weightSpinner;
        Spinner lengthSpinner;
        Spinner recordsSpinner;
        Spinner detail1Spinner;
        Spinner detail2Spinner;
        Spinner detail3Spinner;
        Spinner detail4Spinner;
        Spinner detail5Spinner;
        Spinner detail6Spinner;
        Spinner manualSpinner;
        Spinner markingsSpinner;
        Spinner cabinSpinner;
        Spinner fireExtinguisherSpinner;
        Spinner visualSpinner;
        Spinner loadChartSpinner;
        Spinner chassisSpinner;
        Spinner slewingSpinner;
        Spinner outriggersSpinner;
        Spinner sparkArrestorSpinner;
        Spinner brakingSpinner;
        Spinner cylinderSpinner;
        Spinner forksSpinner;
        Spinner tyresSpinner;
        Spinner fluidSpinner;
        Spinner superstructureSpinner;
        Spinner hydraulicSpinner;
        Spinner connectionsSpinner;
        Spinner wireRopeSpinner;
        Spinner controlsSpinner;
        Spinner emergencyStopSpinner;
        Spinner electricalSpinner;
        Spinner overloadSpinner;
        Spinner anemometerSpinner;
        Spinner earthingSpinner;
        Spinner speedSpinner;
        Spinner limitSwitchSpinner;
        Spinner batteriesSpinner;
        Spinner tiltingSpinner;
        Spinner lightsSpinner;
        Spinner functionsSpinner;
        Spinner emergencyFunctionsSpinner;
        Spinner nextExamSpinner;
        Spinner nextTestSpinner;
        Spinner outcomeSpinner;

        //TextView Declarations
        TextView info1Label;
        TextView info2Label;
        TextView info3Label;
        TextView info4Label;
        TextView equipmentTypeLabel;
        TextView inspectionTypeLabel;
        TextView weightLabel;
        TextView weight1Label;
        TextView weight2Label;
        TextView weight3Label;
        TextView weight4Label;
        TextView weight5Label;
        TextView weight6Label;
        TextView weight7Label;
        TextView weight8Label;

        TextView lengthLabel;
        TextView length1Label;
        TextView length2Label;
        TextView length3Label;
        TextView length4Label;
        TextView length5Label;
        TextView length6Label;
        TextView length7Label;
        TextView length8Label;

        TextView recordsLabel;
        TextView detail1Label;
        TextView detail2Label;
        TextView detail3Label;
        TextView detail4Label;
        TextView detail5Label;
        TextView detail6Label;
        TextView manualLabel;
        TextView markingsLabel;
        TextView cabinLabel;
        TextView fireExtinguisherLabel;
        TextView visualLabel;
        TextView loadChartLabel;
        TextView chassisLabel;
        TextView slewingLabel;
        TextView outriggersLabel;
        TextView sparkArrestorLabel;
        TextView brakingLabel;
        TextView cylinderLabel;
        TextView forksLabel;
        TextView tyresLabel;
        TextView fluidLabel;
        TextView superstructureLabel;
        TextView hydraulicLabel;
        TextView connectionsLabel;
        TextView wireRopeLabel;
        TextView controlsLabel;
        TextView emergencyStopLabel;
        TextView electricalLabel;
        TextView overloadLabel;
        TextView anemometerLabel;
        TextView earthingLabel;
        TextView speedLabel;
        TextView limitSwitchLabel;
        TextView batteriesLabel;
        TextView tiltingLabel;
        TextView lightsLabel;
        TextView functionsLabel;
        TextView emergencyFunctionsLabel;
        TextView outcomeField;

        //EditText Declarations
        EditText fleetField;
        EditText dateField;
        EditText clientField;
        EditText serialField;
        EditText locationField;
        EditText addressField;
        EditText timesheetField;
        EditText standardField;
        EditText ndtField;
        EditText previousExamCertField;
        EditText previousExamDateField;
        EditText previousLoadCertField;
        EditText previousLoadDateField;
        EditText mainRopeCertField;
        EditText auxRopeCertField;
        EditText nameField;
        public static EditText descriptionField;
        public static EditText makeField;
        public static EditText modelField;
        EditText regField;
        public static EditText swlField;
        EditText CWField;
        EditText ballastField;
        public static EditText info1Field;
        public static EditText info2Field;
        public static EditText info3Field;
        public static EditText info4Field;
        EditText mainWireField;
        EditText auxWireField;
        EditText trolleyWireField;
        EditText mainLinePullField;
        EditText auxLinePullField;
        EditText testSWL1Field;
        EditText testSWL2Field;
        EditText testSWL3Field;
        EditText testSWL4Field;
        EditText appliedLoad1Field;
        EditText appliedLoad2Field;
        EditText appliedLoad3Field;
        EditText appliedLoad4Field;
        EditText boomLength1Field;
        EditText boomLength2Field;
        EditText boomLength3Field;
        EditText boomLength4Field;
        EditText radius1Field;
        EditText radius2Field;
        EditText radius3Field;
        EditText radius4Field;
        EditText testInfoField;
        EditText creepingField;
        EditText defectsField;
        EditText recommendationsField;
        EditText nextExamLabel;
        EditText nextTestLabel;

        EditText calibration1;
        EditText calibration2;
        EditText calibration3;
        EditText calibration4;


        LinearLayout imagesLayout;
        TableRow imagesAddRow;
        Button imagesAddButton;

        LinearLayout imageRow1;
        LinearLayout imageRow2;
        LinearLayout imageRow3;
        LinearLayout imageRow4;

        TextView image1;
        TextView image2;
        TextView image3;
        TextView image4;

        RelativeLayout searchLayout;
        Button searchButton;

        private static final int RESULT_LOAD_IMAGE = 1;

        int numberOfImages;
        int add_replace;

        String imagesActive;

        //Hide Ints
        int detailsInt = 0;
        int machineInt = 0;
        int generalInt = 0;
        int mechanicalInt = 0;
        int electricalInt = 0;
        int testingInt = 0;
        int equipmentInt = 0;
        int imagesInt = 0;
        int conclusionInt = 0;

        Thread loopThread;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        loopThread.interrupt();
    }

    @Override
    protected void onStop() {
        super.onStop();
        loopThread.interrupt();
    }

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_checklist);

        globalVariables.SELECTED_MEWP.setModel("");
        globalVariables.SELECTED_MEWP.setMake("");
        globalVariables.SELECTED_MEWP.setSWL("");
        globalVariables.SELECTED_MEWP.setPlatform("");
        globalVariables.SELECTED_MEWP.setPersons("");
        globalVariables.SELECTED_MEWP.setReach("");
        globalVariables.SELECTED_MEWP.setDescription("");
        globalVariables.SELECTED_MEWP.setWorking("");

        //Notify savepoint
        loopThread = new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(Machine_Checklist.this, "Please remember to Save as you go.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        Thread.sleep(180000); //Wait 3 minutes, then repeat!
                    }catch (Exception e) {
                        return;
                    }
                }
            }
        });

        loopThread.start();



        //Visibility Functions

        //Details Hide
        RelativeLayout detailsToggle = (RelativeLayout) findViewById(R.id.detailsToggle);
        final ImageView detailsIcon = (ImageView) findViewById(R.id.detailsIcon);
        final LinearLayout detailsSection = (LinearLayout) findViewById(R.id.detailsSection);
        detailsSection.setVisibility(View.GONE);
        detailsToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (detailsInt == 0) {
                    detailsSection.setVisibility(View.VISIBLE);
                    detailsIcon.setImageResource(R.drawable.ic_action_toggle_up);
                    detailsInt = 1;
                } else if (detailsInt == 1) {
                    detailsSection.setVisibility(View.GONE);
                    detailsIcon.setImageResource(R.drawable.ic_action_toggle_down);
                    detailsInt = 0;
                }
            }
        });

        //Machine Hide
        RelativeLayout machineToggle = (RelativeLayout) findViewById(R.id.machineToggle);
        final ImageView machineIcon = (ImageView) findViewById(R.id.machineIcon);
        final LinearLayout machineSection = (LinearLayout) findViewById(R.id.machineSection);
        machineSection.setVisibility(View.GONE);
        machineToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (machineInt == 0) {
                    machineSection.setVisibility(View.VISIBLE);
                    machineIcon.setImageResource(R.drawable.ic_action_toggle_up);
                    machineInt = 1;
                } else if (machineInt == 1) {
                    machineSection.setVisibility(View.GONE);
                    machineIcon.setImageResource(R.drawable.ic_action_toggle_down);
                    machineInt = 0;
                }
            }
        });

        //General Hide
        RelativeLayout generalToggle = (RelativeLayout) findViewById(R.id.generalToggle);
        final ImageView generalIcon = (ImageView) findViewById(R.id.generalIcon);
        final LinearLayout generalSection = (LinearLayout) findViewById(R.id.generalSection);
        generalSection.setVisibility(View.GONE);
        generalToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (generalInt == 0) {
                    generalSection.setVisibility(View.VISIBLE);
                    generalIcon.setImageResource(R.drawable.ic_action_toggle_up);
                    generalInt = 1;
                } else if (generalInt == 1) {
                    generalSection.setVisibility(View.GONE);
                    generalIcon.setImageResource(R.drawable.ic_action_toggle_down);
                    generalInt = 0;
                }
            }
        });

        //Mechanical Hide
        RelativeLayout mechanicalToggle = (RelativeLayout) findViewById(R.id.mechanicalToggle);
        final ImageView mechanicalIcon = (ImageView) findViewById(R.id.mechanicalIcon);
        final LinearLayout mechanicalSection = (LinearLayout) findViewById(R.id.mechanicalSection);
        mechanicalSection.setVisibility(View.GONE);
        mechanicalToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mechanicalInt == 0) {
                    mechanicalSection.setVisibility(View.VISIBLE);
                    mechanicalIcon.setImageResource(R.drawable.ic_action_toggle_up);
                    mechanicalInt = 1;
                } else if (mechanicalInt == 1) {
                    mechanicalSection.setVisibility(View.GONE);
                    mechanicalIcon.setImageResource(R.drawable.ic_action_toggle_down);
                    mechanicalInt = 0;
                }
            }
        });

        //Electrical Hide
        RelativeLayout electricalToggle = (RelativeLayout) findViewById(R.id.electricalToggle);
        final ImageView electricalIcon = (ImageView) findViewById(R.id.electricalIcon);
        final LinearLayout electricalSection = (LinearLayout) findViewById(R.id.electricalSection);
        electricalSection.setVisibility(View.GONE);
        electricalToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (electricalInt == 0) {
                    electricalSection.setVisibility(View.VISIBLE);
                    electricalIcon.setImageResource(R.drawable.ic_action_toggle_up);
                    electricalInt = 1;
                } else if (electricalInt == 1) {
                    electricalSection.setVisibility(View.GONE);
                    electricalIcon.setImageResource(R.drawable.ic_action_toggle_down);
                    electricalInt = 0;
                }
            }
        });

        //Testing Hide
        RelativeLayout testingToggle = (RelativeLayout) findViewById(R.id.testingToggle);
        final ImageView testingIcon = (ImageView) findViewById(R.id.testingIcon);
        final LinearLayout testingSection = (LinearLayout) findViewById(R.id.testingSection);
        testingSection.setVisibility(View.GONE);
        testingToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (testingInt == 0) {
                    testingSection.setVisibility(View.VISIBLE);
                    testingIcon.setImageResource(R.drawable.ic_action_toggle_up);
                    testingInt = 1;
                } else if (testingInt == 1) {
                    testingSection.setVisibility(View.GONE);
                    testingIcon.setImageResource(R.drawable.ic_action_toggle_down);
                    testingInt = 0;
                }
            }
        });

        //Equipment Hide
        RelativeLayout equipmentToggle = (RelativeLayout) findViewById(R.id.equipmentToggle);
        final ImageView equipmentIcon = (ImageView) findViewById(R.id.equipmentIcon);
        final LinearLayout equipmentSection = (LinearLayout) findViewById(R.id.equipmentSection);
        equipmentSection.setVisibility(View.GONE);
        equipmentToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equipmentInt == 0) {
                    equipmentSection.setVisibility(View.VISIBLE);
                    equipmentIcon.setImageResource(R.drawable.ic_action_toggle_up);
                    equipmentInt = 1;
                } else if (equipmentInt == 1) {
                    equipmentSection.setVisibility(View.GONE);
                    equipmentIcon.setImageResource(R.drawable.ic_action_toggle_down);
                    equipmentInt = 0;
                }
            }
        });

        //Images Hide
        RelativeLayout imagesToggle = (RelativeLayout) findViewById(R.id.imagesToggle);
        final ImageView imagesIcon = (ImageView) findViewById(R.id.imagesIcon);
        final LinearLayout imagesSection = (LinearLayout) findViewById(R.id.imagesSection);
        imagesSection.setVisibility(View.GONE);
        imagesToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imagesInt == 0) {
                    imagesSection.setVisibility(View.VISIBLE);
                    imagesIcon.setImageResource(R.drawable.ic_action_toggle_up);
                    imagesInt = 1;
                } else if (imagesInt == 1) {
                    imagesSection.setVisibility(View.GONE);
                    imagesIcon.setImageResource(R.drawable.ic_action_toggle_down);
                    imagesInt = 0;
                }
            }
        });

        //Conclusion Hide
        RelativeLayout conclusionToggle = (RelativeLayout) findViewById(R.id.conclusionToggle);
        final ImageView conclusionIcon = (ImageView) findViewById(R.id.conclusionIcon);
        final LinearLayout conclusionSection = (LinearLayout) findViewById(R.id.conclusionSection);
        conclusionSection.setVisibility(View.GONE);
        conclusionToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (conclusionInt == 0) {
                    conclusionSection.setVisibility(View.VISIBLE);
                    conclusionIcon.setImageResource(R.drawable.ic_action_toggle_up);
                    conclusionInt = 1;
                } else if (conclusionInt == 1) {
                    conclusionSection.setVisibility(View.GONE);
                    conclusionIcon.setImageResource(R.drawable.ic_action_toggle_down);
                    conclusionInt = 0;
                }
            }
        });


        //Initialize Fields
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        globalVariables.OUTCOME_STRING = "";

        numberOfImages = 0;

        Button satisfactoryBTN = (Button) findViewById(R.id.satisfactoryBTN);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchLayout = (RelativeLayout) findViewById(R.id.searchLayout);

        searchLayout.setVisibility(View.GONE);


        //Spinner Declarations
        factor1Spinner = (Spinner) findViewById(R.id.factor1Spinner);
        factor2Spinner = (Spinner) findViewById(R.id.factor2Spinner);
        factor3Spinner = (Spinner) findViewById(R.id.factor3Spinner);
        factor4Spinner = (Spinner) findViewById(R.id.factor4Spinner);
        equipmentTypeSpinner = (Spinner) findViewById(R.id.equipmentTypeSpinner);
        inspectionTypeSpinner = (Spinner) findViewById(R.id.inspectionTypeSpinner);
        weightSpinner = (Spinner) findViewById(R.id.weightSpinner);
        lengthSpinner = (Spinner) findViewById(R.id.lengthSpinner);
        recordsSpinner = (Spinner) findViewById(R.id.recordsSpinner);
        detail1Spinner = (Spinner) findViewById(R.id.detail1Spinner);
        detail2Spinner = (Spinner) findViewById(R.id.detail2Spinner);
        detail3Spinner = (Spinner) findViewById(R.id.detail3Spinner);
        detail4Spinner = (Spinner) findViewById(R.id.detail4Spinner);
        detail5Spinner = (Spinner) findViewById(R.id.detail5Spinner);
        detail6Spinner = (Spinner) findViewById(R.id.detail6Spinner);
        manualSpinner = (Spinner) findViewById(R.id.manualSpinner);
        markingsSpinner = (Spinner) findViewById(R.id.markingsSpinner);
        cabinSpinner = (Spinner) findViewById(R.id.cabinSpinner);
        fireExtinguisherSpinner = (Spinner) findViewById(R.id.fireExtinguisherSpinner);
        visualSpinner = (Spinner) findViewById(R.id.visualSpinner);
        loadChartSpinner = (Spinner) findViewById(R.id.loadChartSpinner);
        chassisSpinner = (Spinner) findViewById(R.id.chassisSpinner);
        slewingSpinner = (Spinner) findViewById(R.id.slewingSpinner);
        outriggersSpinner = (Spinner) findViewById(R.id.outriggersSpinner);
        sparkArrestorSpinner = (Spinner) findViewById(R.id.sparkArrestorSpinner);
        brakingSpinner = (Spinner) findViewById(R.id.brakingSpinner);
        cylinderSpinner = (Spinner) findViewById(R.id.cylinderSpinner);
        forksSpinner = (Spinner) findViewById(R.id.forksSpinner);
        tyresSpinner = (Spinner) findViewById(R.id.tyresSpinner);
        fluidSpinner = (Spinner) findViewById(R.id.fluidSpinner);
        superstructureSpinner = (Spinner) findViewById(R.id.superstructureSpinner);
        hydraulicSpinner = (Spinner) findViewById(R.id.hydraulicSpinner);
        connectionsSpinner = (Spinner) findViewById(R.id.connectionsSpinner);
        wireRopeSpinner = (Spinner) findViewById(R.id.wireRopeSpinner);
        controlsSpinner = (Spinner) findViewById(R.id.controlsSpinner);
        emergencyStopSpinner = (Spinner) findViewById(R.id.emergencyStopSpinner);
        electricalSpinner = (Spinner) findViewById(R.id.electricalSpinner);
        overloadSpinner = (Spinner) findViewById(R.id.overloadSpinner);
        anemometerSpinner = (Spinner) findViewById(R.id.anemometerSpinner);
        earthingSpinner = (Spinner) findViewById(R.id.earthingSpinner);
        speedSpinner = (Spinner) findViewById(R.id.speedSpinner);
        limitSwitchSpinner = (Spinner) findViewById(R.id.limitSwitchSpinner);
        batteriesSpinner = (Spinner) findViewById(R.id.batteriesSpinner);
        tiltingSpinner = (Spinner) findViewById(R.id.tiltingSpinner);
        lightsSpinner = (Spinner) findViewById(R.id.lightsSpinner);
        functionsSpinner = (Spinner) findViewById(R.id.functionsSpinner);
        emergencyFunctionsSpinner = (Spinner) findViewById(R.id.emergencyFunctionsSpinner);
        nextExamSpinner = (Spinner) findViewById(R.id.nextExamSpinner);
        nextTestSpinner = (Spinner) findViewById(R.id.nextTestSpinner);
        outcomeSpinner = (Spinner) findViewById(R.id.outcomeSpinner);

        //TextView Declarations
        info1Label = (TextView) findViewById(R.id.info1Label);
        info2Label = (TextView) findViewById(R.id.info2Label);
        info3Label = (TextView) findViewById(R.id.info3Label);
        info4Label = (TextView) findViewById(R.id.info4Label);
        equipmentTypeLabel = (TextView) findViewById(R.id.equipmentTypeLabel);
        inspectionTypeLabel = (TextView) findViewById(R.id.inspectionTypeLabel);
        weightLabel = (TextView) findViewById(R.id.weightLabel);
        lengthLabel = (TextView) findViewById(R.id.lengthLabel);
        weight1Label = (TextView) findViewById(R.id.weight1Label);
        length1Label = (TextView) findViewById(R.id.length1Label);
        weight2Label = (TextView) findViewById(R.id.weight2Label);
        length2Label = (TextView) findViewById(R.id.length2Label);
        weight3Label = (TextView) findViewById(R.id.weight3Label);
        length3Label = (TextView) findViewById(R.id.length3Label);
        weight4Label = (TextView) findViewById(R.id.weight4Label);
        length4Label = (TextView) findViewById(R.id.length4Label);
        weight5Label = (TextView) findViewById(R.id.weight5Label);
        length5Label = (TextView) findViewById(R.id.length5Label);
        weight6Label = (TextView) findViewById(R.id.weight6Label);
        length6Label = (TextView) findViewById(R.id.length6Label);
        weight7Label = (TextView) findViewById(R.id.weight7Label);
        length7Label = (TextView) findViewById(R.id.length7Label);
        weight8Label = (TextView) findViewById(R.id.weight8Label);
        length8Label = (TextView) findViewById(R.id.length8Label);

        recordsLabel = (TextView) findViewById(R.id.recordsLabel);
        detail1Label = (TextView) findViewById(R.id.detail1Label);
        detail2Label = (TextView) findViewById(R.id.detail2Label);
        detail3Label = (TextView) findViewById(R.id.detail3Label);
        detail4Label = (TextView) findViewById(R.id.detail4Label);
        detail5Label = (TextView) findViewById(R.id.detail5Label);
        detail6Label = (TextView) findViewById(R.id.detail6Label);
        manualLabel = (TextView) findViewById(R.id.manualLabel);
        markingsLabel = (TextView) findViewById(R.id.markingsLabel);
        cabinLabel = (TextView) findViewById(R.id.cabinLabel);
        fireExtinguisherLabel = (TextView) findViewById(R.id.fireExtinguisherLabel);
        visualLabel = (TextView) findViewById(R.id.visualLabel);
        loadChartLabel = (TextView) findViewById(R.id.loadChartLabel);
        chassisLabel = (TextView) findViewById(R.id.chassisLabel);
        slewingLabel = (TextView) findViewById(R.id.slewingLabel);
        outriggersLabel = (TextView) findViewById(R.id.outriggersLabel);
        sparkArrestorLabel = (TextView) findViewById(R.id.sparkArrestorLabel);
        brakingLabel = (TextView) findViewById(R.id.brakingLabel);
        cylinderLabel = (TextView) findViewById(R.id.cylinderLabel);
        forksLabel = (TextView) findViewById(R.id.forksLabel);
        tyresLabel = (TextView) findViewById(R.id.tyresLabel);
        fluidLabel = (TextView) findViewById(R.id.fluidLabel);
        superstructureLabel = (TextView) findViewById(R.id.superstructureLabel);
        hydraulicLabel = (TextView) findViewById(R.id.hydraulicLabel);
        connectionsLabel = (TextView) findViewById(R.id.connectionsLabel);
        wireRopeLabel = (TextView) findViewById(R.id.wireRopeLabel);
        controlsLabel = (TextView) findViewById(R.id.controlsLabel);
        emergencyStopLabel = (TextView) findViewById(R.id.emergencyStopLabel);
        electricalLabel = (TextView) findViewById(R.id.electricalLabel);
        overloadLabel = (TextView) findViewById(R.id.overloadLabel);
        anemometerLabel = (TextView) findViewById(R.id.anemometerLabel);
        earthingLabel = (TextView) findViewById(R.id.earthingLabel);
        speedLabel = (TextView) findViewById(R.id.speedLabel);
        limitSwitchLabel = (TextView) findViewById(R.id.limitSwitchLabel);
        batteriesLabel = (TextView) findViewById(R.id.batteriesLabel);
        tiltingLabel = (TextView) findViewById(R.id.tiltingLabel);
        lightsLabel = (TextView) findViewById(R.id.lightsLabel);
        functionsLabel = (TextView) findViewById(R.id.functionsLabel);
        emergencyFunctionsLabel = (TextView) findViewById(R.id.emergencyFunctionsLabel);
        nextExamLabel = (EditText) findViewById(R.id.nextExamLabel);
        nextTestLabel = (EditText) findViewById(R.id.nextTestLabel);
        outcomeField = (TextView) findViewById(R.id.outcomeField);

        //EditText Declarations
        fleetField = (EditText) findViewById(R.id.fleetField);
        dateField = (EditText) findViewById(R.id.dateField);
        clientField = (EditText) findViewById(R.id.clientField);
        serialField = (EditText) findViewById(R.id.serialField);
        locationField = (EditText) findViewById(R.id.locationField);
        addressField = (EditText) findViewById(R.id.addressField);
        timesheetField = (EditText) findViewById(R.id.timesheetField);
        standardField = (EditText) findViewById(R.id.standardField);
        ndtField = (EditText) findViewById(R.id.ndtField);
        previousExamCertField = (EditText) findViewById(R.id.previousExamCertField);
        previousExamDateField = (EditText) findViewById(R.id.previousExamDateField);
        previousLoadCertField = (EditText) findViewById(R.id.previousTestCertField);
        previousLoadDateField = (EditText) findViewById(R.id.previousTestDateField);
        mainRopeCertField = (EditText) findViewById(R.id.mainRopeCertField);
        auxRopeCertField = (EditText) findViewById(R.id.auxRopeCertField);
        nameField = (EditText) findViewById(R.id.nameField);
        descriptionField = (EditText) findViewById(R.id.descriptionField);
        makeField = (EditText) findViewById(R.id.makeField);
        modelField = (EditText) findViewById(R.id.modelField);
        regField = (EditText) findViewById(R.id.regField);
        swlField = (EditText) findViewById(R.id.swlField);
        CWField = (EditText) findViewById(R.id.CWField);
        ballastField = (EditText) findViewById(R.id.ballastField);
        info1Field = (EditText) findViewById(R.id.info1Field);
        info2Field = (EditText) findViewById(R.id.info2Field);
        info3Field = (EditText) findViewById(R.id.info3Field);
        info4Field = (EditText) findViewById(R.id.info4Field);
        mainWireField = (EditText) findViewById(R.id.mainWireField);
        auxWireField = (EditText) findViewById(R.id.auxWireField);
        trolleyWireField = (EditText) findViewById(R.id.trolleyWireField);
        mainLinePullField = (EditText) findViewById(R.id.mainLinePullField);
        auxLinePullField = (EditText) findViewById(R.id.auxLinePullField);
        testSWL1Field = (EditText) findViewById(R.id.testSWL1Field);
        testSWL2Field = (EditText) findViewById(R.id.testSWL2Field);
        testSWL3Field = (EditText) findViewById(R.id.testSWL3Field);
        testSWL4Field = (EditText) findViewById(R.id.testSWL4Field);
        appliedLoad1Field = (EditText) findViewById(R.id.appliedLoad1Field);
        appliedLoad2Field = (EditText) findViewById(R.id.appliedLoad2Field);
        appliedLoad3Field = (EditText) findViewById(R.id.appliedLoad3Field);
        appliedLoad4Field = (EditText) findViewById(R.id.appliedLoad4Field);
        boomLength1Field = (EditText) findViewById(R.id.boomLength1Field);
        boomLength2Field = (EditText) findViewById(R.id.boomLength2Field);
        boomLength3Field = (EditText) findViewById(R.id.boomLength3Field);
        boomLength4Field = (EditText) findViewById(R.id.boomLength4Field);
        radius1Field = (EditText) findViewById(R.id.radius1Field);
        radius2Field = (EditText) findViewById(R.id.radius2Field);
        radius3Field = (EditText) findViewById(R.id.radius3Field);
        radius4Field = (EditText) findViewById(R.id.radius4Field);
        testInfoField = (EditText) findViewById(R.id.testInfoField);
        creepingField = (EditText) findViewById(R.id.creepingField);
        defectsField = (EditText) findViewById(R.id.defectsField);
        recommendationsField = (EditText) findViewById(R.id.recommendationsField);
        calibration1 = (EditText) findViewById(R.id.calibration1);
        calibration2 = (EditText) findViewById(R.id.calibration2);
        calibration3 = (EditText) findViewById(R.id.calibration3);
        calibration4 = (EditText) findViewById(R.id.calibration4);

        //Image System Declarations
        //imagesLayout = (LinearLayout) findViewById(R.id.imagesLayout);
        imagesAddRow = (TableRow) findViewById(R.id.imagesAddRow);
        imagesAddButton = (Button) findViewById(R.id.imagesAddButton);
        imageRow1 = (LinearLayout) findViewById(R.id.imageRow1);
        imageRow2 = (LinearLayout) findViewById(R.id.imageRow2);
        imageRow3 = (LinearLayout) findViewById(R.id.imageRow3);
        imageRow4 = (LinearLayout) findViewById(R.id.imageRow4);
        image1 = (TextView) findViewById(R.id.image1);
        image2 = (TextView) findViewById(R.id.image2);
        image3 = (TextView) findViewById(R.id.image3);
        image4 = (TextView) findViewById(R.id.image4);

        //imagesLayout.setVisibility(View.VISIBLE);
        image1.setVisibility(View.GONE);
        image2.setVisibility(View.GONE);
        image3.setVisibility(View.GONE);
        image4.setVisibility(View.GONE);
        imageRow1.setVisibility(View.GONE);
        imageRow2.setVisibility(View.GONE);
        imageRow3.setVisibility(View.GONE);
        imageRow4.setVisibility(View.GONE);

        certField = (EditText) findViewById(R.id.certField);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNetworkAvailable()){
                    updateData();
                    Intent i = new Intent(Machine_Checklist.this, ModelSearchMEWP.class);
                    startActivity(i);
                } else {
                    globalVariables.makeToast(Machine_Checklist.this, "Please connect to the internet to proceed.");
                }
            }
        });


        if (satisfactoryBTN != null) {
            satisfactoryBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    if (isNetworkAvailable()){
                        updateData();
                        Intent satisfactory = new Intent(Machine_Checklist.this, Machine_Certificate.class);
                        startActivity(satisfactory);
                    } else {
                        globalVariables.makeToast(Machine_Checklist.this, "Please connect to the internet to proceed.");
                    }
                }
            });
        }

        //SIX MONTHS
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        String sixMonths;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 365 / 2);
        Date resultdate = new Date(c.getTimeInMillis());
        sixMonths = sdf.format(resultdate);

        //12 MONTHS
        String twelveMonths;
        Calendar c2 = Calendar.getInstance();
        c2.add(Calendar.DATE, 365);
        Date resultdatetwo = new Date(c2.getTimeInMillis());
        twelveMonths = sdf.format(resultdatetwo);

        //4 Years
        String fourYears;
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, 365 * 4);
        Date resultdatethree = new Date(c1.getTimeInMillis());
        fourYears = sdf.format(resultdatethree);

        List<String> datesArray = new ArrayList<>();
        datesArray.add("Please Select");
        datesArray.add(sixMonths);
        datesArray.add(twelveMonths);
        datesArray.add(fourYears);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, datesArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nextExamSpinner.setAdapter(adapter);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nextTestSpinner.setAdapter(adapter);


        //SPINNER Listeners
        if (factor1Spinner != null) {
            factor1Spinner.setOnItemSelectedListener(this);
        }
        if (factor2Spinner != null) {
            factor2Spinner.setOnItemSelectedListener(this);
        }
        if (factor3Spinner != null) {
            factor3Spinner.setOnItemSelectedListener(this);
        }
        if (factor4Spinner != null) {
            factor4Spinner.setOnItemSelectedListener(this);
        }
        if (equipmentTypeSpinner != null) {
            equipmentTypeSpinner.setOnItemSelectedListener(this);
        }
        if (inspectionTypeSpinner != null) {
            inspectionTypeSpinner.setOnItemSelectedListener(this);
        }
        if (weightSpinner != null) {
            weightSpinner.setOnItemSelectedListener(this);
        }
        if (lengthSpinner != null) {
            lengthSpinner.setOnItemSelectedListener(this);
        }
        if (recordsSpinner != null) {
            recordsSpinner.setOnItemSelectedListener(this);
        }
        if (detail1Spinner != null) {
            detail1Spinner.setOnItemSelectedListener(this);
        }
        if (detail2Spinner != null) {
            detail2Spinner.setOnItemSelectedListener(this);
        }
        if (detail3Spinner != null) {
            detail3Spinner.setOnItemSelectedListener(this);
        }
        if (detail4Spinner != null) {
            detail4Spinner.setOnItemSelectedListener(this);
        }
        if (detail5Spinner != null) {
            detail5Spinner.setOnItemSelectedListener(this);
        }
        if (detail6Spinner != null) {
            detail6Spinner.setOnItemSelectedListener(this);
        }
        if (manualSpinner != null) {
            manualSpinner.setOnItemSelectedListener(this);
        }
        if (markingsSpinner != null) {
            markingsSpinner.setOnItemSelectedListener(this);
        }
        if (cabinSpinner != null) {
            cabinSpinner.setOnItemSelectedListener(this);
        }
        if (fireExtinguisherSpinner != null) {
            fireExtinguisherSpinner.setOnItemSelectedListener(this);
        }
        if (visualSpinner != null) {
            visualSpinner.setOnItemSelectedListener(this);
        }
        if (loadChartSpinner != null) {
            loadChartSpinner.setOnItemSelectedListener(this);
        }
        if (chassisSpinner != null) {
            chassisSpinner.setOnItemSelectedListener(this);
        }
        if (slewingSpinner != null) {
            slewingSpinner.setOnItemSelectedListener(this);
        }
        if (outriggersSpinner != null) {
            outriggersSpinner.setOnItemSelectedListener(this);
        }
        if (sparkArrestorSpinner != null) {
            sparkArrestorSpinner.setOnItemSelectedListener(this);
        }
        if (brakingSpinner != null) {
            brakingSpinner.setOnItemSelectedListener(this);
        }
        if (cylinderSpinner != null) {
            cylinderSpinner.setOnItemSelectedListener(this);
        }
        if (forksSpinner != null) {
            forksSpinner.setOnItemSelectedListener(this);
        }
        if (tyresSpinner != null) {
            tyresSpinner.setOnItemSelectedListener(this);
        }
        if (fluidSpinner != null) {
            fluidSpinner.setOnItemSelectedListener(this);
        }
        if (superstructureSpinner != null) {
            superstructureSpinner.setOnItemSelectedListener(this);
        }
        if (hydraulicSpinner != null) {
            hydraulicSpinner.setOnItemSelectedListener(this);
        }
        if (connectionsSpinner != null) {
            connectionsSpinner.setOnItemSelectedListener(this);
        }
        if (wireRopeSpinner != null) {
            wireRopeSpinner.setOnItemSelectedListener(this);
        }
        if (controlsSpinner != null) {
            controlsSpinner.setOnItemSelectedListener(this);
        }
        if (emergencyStopSpinner != null) {
            emergencyStopSpinner.setOnItemSelectedListener(this);
        }
        if (electricalSpinner != null) {
            electricalSpinner.setOnItemSelectedListener(this);
        }
        if (overloadSpinner != null) {
            overloadSpinner.setOnItemSelectedListener(this);
        }
        if (anemometerSpinner != null) {
            anemometerSpinner.setOnItemSelectedListener(this);
        }
        if (earthingSpinner != null) {
            earthingSpinner.setOnItemSelectedListener(this);
        }
        if (speedSpinner != null) {
            speedSpinner.setOnItemSelectedListener(this);
        }
        if (limitSwitchSpinner != null) {
            limitSwitchSpinner.setOnItemSelectedListener(this);
        }
        if (batteriesSpinner != null) {
            batteriesSpinner.setOnItemSelectedListener(this);
        }
        if (tiltingSpinner != null) {
            tiltingSpinner.setOnItemSelectedListener(this);
        }
        if (lightsSpinner != null) {
            lightsSpinner.setOnItemSelectedListener(this);
        }
        if (functionsSpinner != null) {
            functionsSpinner.setOnItemSelectedListener(this);
        }
        if (emergencyFunctionsSpinner != null) {
            emergencyFunctionsSpinner.setOnItemSelectedListener(this);
        }
        if (nextExamSpinner != null) {
            nextExamSpinner.setOnItemSelectedListener(this);
        }
        if (nextTestSpinner != null) {
            nextTestSpinner.setOnItemSelectedListener(this);
        }
        if (outcomeSpinner != null) {
            outcomeSpinner.setOnItemSelectedListener(this);
        }

        myDB = new Machine_Database(this);
        sqlDB = myDB.getReadableDatabase();

        getData();

        if (imagesAddButton != null) {
            imagesAddButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    add_replace = 0;
                    updateData();
                    Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent1, RESULT_LOAD_IMAGE);
                }
            });
        }

        /**if (image1 != null) {
            image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    add_replace = 1;
                    Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent1, RESULT_LOAD_IMAGE);
                }
            });
        }

        if (image2 != null) {
            image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    add_replace = 2;
                    Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent1, RESULT_LOAD_IMAGE);
                }
            });
        }

        if (image3 != null) {
            image3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    add_replace = 3;
                    Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent1, RESULT_LOAD_IMAGE);
                }
            });
        }

        if (image4 != null) {
            image4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    add_replace = 4;
                    Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent1, RESULT_LOAD_IMAGE);
                }
            });
        } */


        if (image1 != null) {
            image1.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    //Create AlertDialog, perform below if confirmed.

                    final AlertDialog.Builder b = new AlertDialog.Builder(Machine_Checklist.this);
                    b.setIcon(android.R.drawable.ic_dialog_alert);
                    b.setTitle("Remove Image 1:  ");
                    b.setMessage("Are you sure?");

                    b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int whichButton) {

                            add_replace = 0;
                            numberOfImages = 0;
                            image1.setText(" ");

                            imageRow1.setVisibility(View.GONE);
                            image1.setVisibility(View.GONE);
                            Toast.makeText(Machine_Checklist.this, "Image Removed", Toast.LENGTH_SHORT).show();

                        }
                    });

                    b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                        }
                    });

                    b.show();


                    return true;
                }
            });

            image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Create AlertDialog to display the image.
                    AlertDialog.Builder builder = new AlertDialog.Builder(Machine_Checklist.this);
                    View v = getLayoutInflater().inflate(R.layout.image_view_layout, null);
                    builder.setTitle("Image 1");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    builder.setView(v);
                    final AlertDialog dialog = builder.create();


                    //Zoom
                    ImageView iv = (ImageView)v.findViewById(R.id.reviewImageView);
                    iv.setImageURI(Uri.parse(image1.getText().toString()));


                    dialog.show();
                }
            });

        }


        if (image2 != null) {
            image2.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    //Create AlertDialog, perform below if confirmed.

                    final AlertDialog.Builder b = new AlertDialog.Builder(Machine_Checklist.this);
                    b.setIcon(android.R.drawable.ic_dialog_alert);
                    b.setTitle("Remove Image 2:  ");
                    b.setMessage("Are you sure?");

                    b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int whichButton) {


                            add_replace = 1;
                            numberOfImages = 1;
                            image2.setText(" ");
                            imageRow2.setVisibility(View.GONE);
                            image2.setVisibility(View.GONE);
                            Toast.makeText(Machine_Checklist.this, "Image Removed", Toast.LENGTH_SHORT).show();

                        }
                    });

                    b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                        }
                    });

                    b.show();

                    return true;
                }
            });

            image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Create AlertDialog to display the image.
                    AlertDialog.Builder builder = new AlertDialog.Builder(Machine_Checklist.this);
                    View v = getLayoutInflater().inflate(R.layout.image_view_layout, null);
                    builder.setTitle("Image 2");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    builder.setView(v);
                    final AlertDialog dialog = builder.create();


                    //Zoom
                    ImageView iv = (ImageView)v.findViewById(R.id.reviewImageView);
                    iv.setImageURI(Uri.parse(image2.getText().toString()));


                    dialog.show();
                }
            });
        }

        if (image3 != null) {
            image3.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    //Create AlertDialog, perform below if confirmed.

                    final AlertDialog.Builder b = new AlertDialog.Builder(Machine_Checklist.this);
                    b.setIcon(android.R.drawable.ic_dialog_alert);
                    b.setTitle("Remove Image 3:  ");
                    b.setMessage("Are you sure?");

                    b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int whichButton) {

                            add_replace = 2;
                            numberOfImages = 2;
                            image3.setText(" ");

                            imageRow3.setVisibility(View.GONE);
                            image3.setVisibility(View.GONE);
                            Toast.makeText(Machine_Checklist.this, "Image Removed", Toast.LENGTH_SHORT).show();

                        }
                    });

                    b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                        }
                    });

                    b.show();

                    return true;
                }
            });

            image3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Create AlertDialog to display the image.
                    AlertDialog.Builder builder = new AlertDialog.Builder(Machine_Checklist.this);
                    View v = getLayoutInflater().inflate(R.layout.image_view_layout, null);
                    builder.setTitle("Image 3");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    builder.setView(v);
                    final AlertDialog dialog = builder.create();


                    //Zoom
                    ImageView iv = (ImageView)v.findViewById(R.id.reviewImageView);
                    iv.setImageURI(Uri.parse(image3.getText().toString()));


                    dialog.show();
                }
            });
        }


        if (image4 != null) {
            image4.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    //Create AlertDialog, perform below if confirmed.

                    final AlertDialog.Builder b = new AlertDialog.Builder(Machine_Checklist.this);
                    b.setIcon(android.R.drawable.ic_dialog_alert);
                    b.setTitle("Remove Image 4:  ");
                    b.setMessage("Are you sure?");

                    b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int whichButton) {

                            add_replace = 3;
                            numberOfImages = 3;
                            image4.setText(" ");
                            imageRow4.setVisibility(View.GONE);
                            image4.setVisibility(View.GONE);
                            Toast.makeText(Machine_Checklist.this, "Image Removed", Toast.LENGTH_SHORT).show();

                        }
                    });

                    b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                        }
                    });

                    b.show();

                    return true;
                }
            });

            image4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Create AlertDialog to display the image.
                    AlertDialog.Builder builder = new AlertDialog.Builder(Machine_Checklist.this);
                    View v = getLayoutInflater().inflate(R.layout.image_view_layout, null);
                    builder.setTitle("Image 4");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    builder.setView(v);
                    final AlertDialog dialog = builder.create();


                    //Zoom
                    ImageView iv = (ImageView) v.findViewById(R.id.reviewImageView);
                    iv.setImageURI(Uri.parse(image4.getText().toString()));


                    dialog.show();
                }
            });
        }
    }




    //Check network connectivity
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null){
            Uri selectedImage = data.getData();
            if (add_replace == 0) {
                if (numberOfImages == 0) {
                    image1.setText(selectedImage.toString());
                    imageRow1.setVisibility(View.VISIBLE);
                    image1.setVisibility(View.VISIBLE);
                    imagesActive = "yes";
                    numberOfImages++;

                } else if (numberOfImages == 1) {
                    image2.setText(selectedImage.toString());
                    image2.setVisibility(View.VISIBLE);
                    imageRow2.setVisibility(View.VISIBLE);
                    numberOfImages++;

                   } else if (numberOfImages == 2) {
                    image3.setText(selectedImage.toString());
                    imageRow3.setVisibility(View.VISIBLE);
                    image3.setVisibility(View.VISIBLE);
                    numberOfImages++;

                    } else if (numberOfImages == 3) {
                    image4.setText(selectedImage.toString());
                    imageRow4.setVisibility(View.VISIBLE);
                    image4.setVisibility(View.VISIBLE);
                    numberOfImages++;
                }

            } else if(add_replace == 1){
                image1.setText(selectedImage.toString());

            }  else if(add_replace == 2){
                image2.setText(selectedImage.toString());

            }else if(add_replace == 3){
                image3.setText(selectedImage.toString());

            }else if(add_replace == 4){
                image4.setText(selectedImage.toString());

            }
        }
    }

    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.checklist_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            if (id == R.id.save) {
                updateData();
            }
            return false;
        }

    //@Override
    //protected void onStart() {
    //    super.onStart();
    //    getData();
    //}

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    public void getData() {
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
                duration = cursor.getString(105);
                String CALIBRATION1 = cursor.getString(106);
                String CALIBRATION2 = cursor.getString(107);
                String CALIBRATION3 = cursor.getString(108);
                String CALIBRATION4 = cursor.getString(109);
                String IMAGE_ACTIVE = cursor.getString(110);
                String IMAGE1 = cursor.getString(111);
                String IMAGE2 = cursor.getString(112);
                String IMAGE3 = cursor.getString(113);
                String IMAGE4 = cursor.getString(114);
                String CERTNO = cursor.getString(115);


                //change Spinner values of boot
                if (EQUIPMENT_TYPE.equals("") || EQUIPMENT_TYPE.equals(" ")){
                    equipmentTypeSpinner.setSelection(0);
                } else if (EQUIPMENT_TYPE.equals("MEWP/AWP")){
                    equipmentTypeSpinner.setSelection(1);
                } else if (EQUIPMENT_TYPE.equals("Mobile Crane")){
                    equipmentTypeSpinner.setSelection(2);
                } else if (EQUIPMENT_TYPE.equals("Crawler Crane")){
                    equipmentTypeSpinner.setSelection(3);
                } else if (EQUIPMENT_TYPE.equals("Telehandler")){
                    equipmentTypeSpinner.setSelection(4);
                } else if (EQUIPMENT_TYPE.equals("Tower Crane")){
                    equipmentTypeSpinner.setSelection(5);
                } else if (EQUIPMENT_TYPE.equals("Jib Crane")){
                    equipmentTypeSpinner.setSelection(6);
                } else if (EQUIPMENT_TYPE.equals("Quay Crane")){
                    equipmentTypeSpinner.setSelection(7);
                } else if (EQUIPMENT_TYPE.equals("Offshore Crane")){
                    equipmentTypeSpinner.setSelection(8);
                } else if (EQUIPMENT_TYPE.equals("Lorry Loading Crane")){
                    equipmentTypeSpinner.setSelection(9);
                } else if (EQUIPMENT_TYPE.equals("EOT/Gantry Crane")){
                    equipmentTypeSpinner.setSelection(10);
                } else if (EQUIPMENT_TYPE.equals("Passenger Hoist")){
                    equipmentTypeSpinner.setSelection(11);
                } else if (EQUIPMENT_TYPE.equals("Material Hoist")){
                    equipmentTypeSpinner.setSelection(12);
                } else if (EQUIPMENT_TYPE.equals("Suspended Access Platform")){
                    equipmentTypeSpinner.setSelection(13);
                }


                if (INSPECTION_TYPE.equals("") || INSPECTION_TYPE.equals(" ")){
                    inspectionTypeSpinner.setSelection(0);
                } else if (INSPECTION_TYPE.equals("Thorough Examination")){
                    inspectionTypeSpinner.setSelection(1);
                } else if (INSPECTION_TYPE.equals("Test and Examination")){
                    inspectionTypeSpinner.setSelection(2);
                }

                if (RECORDS.equals("") || RECORDS.equals(" ")){
                    recordsSpinner.setSelection(0);
                } else if (RECORDS.equals("Available")) {
                    recordsSpinner.setSelection(1);
                } else if (RECORDS.equals("Not Available")) {
                    recordsSpinner.setSelection(2);
                }

                if (DETAIL_1.equals("") || DETAIL_1.equals(" ")){
                    detail1Spinner.setSelection(0);
                } else if (DETAIL_1.equals("Yes")) {
                    detail1Spinner.setSelection(1);
                } else if (DETAIL_1.equals("N/A")) {
                    detail1Spinner.setSelection(2);
                } else if (DETAIL_1.equals("No")) {
                    detail1Spinner.setSelection(3);
                }

                if (DETAIL_2.equals("") || DETAIL_2.equals(" ")){
                    detail2Spinner.setSelection(0);
                } else if (DETAIL_2.equals("Yes")) {
                    detail2Spinner.setSelection(1);
                } else if (DETAIL_2.equals("N/A")) {
                    detail2Spinner.setSelection(2);
                } else if (DETAIL_2.equals("No")) {
                    detail2Spinner.setSelection(3);
                }

                if (DETAIL_3.equals("") || DETAIL_1.equals(" ")){
                    detail4Spinner.setSelection(0);
                } else if (DETAIL_3.equals("Yes")) {
                    detail4Spinner.setSelection(1);
                } else if (DETAIL_3.equals("N/A")) {
                    detail4Spinner.setSelection(2);
                } else if (DETAIL_3.equals("No")) {
                    detail4Spinner.setSelection(3);
                }

                if (DETAIL_4.equals("") || DETAIL_1.equals(" ")){
                    detail5Spinner.setSelection(0);
                } else if (DETAIL_4.equals("Yes")) {
                    detail5Spinner.setSelection(1);
                } else if (DETAIL_4.equals("N/A")) {
                    detail5Spinner.setSelection(2);
                } else if (DETAIL_4.equals("No")) {
                    detail5Spinner.setSelection(3);
                }

                if (DETAIL_5.equals("") || DETAIL_1.equals(" ")){
                    detail6Spinner.setSelection(0);
                } else if (DETAIL_5.equals("Yes")) {
                    detail6Spinner.setSelection(1);
                } else if (DETAIL_5.equals("N/A")) {
                    detail6Spinner.setSelection(2);
                } else if (DETAIL_5.equals("No")) {
                    detail6Spinner.setSelection(3);
                }

                if (REASON.equals("") || REASON.equals(" ")){
                    detail3Spinner.setSelection(0);
                } else if (REASON.equals("A")) {
                    detail3Spinner.setSelection(1);
                } else if (REASON.equals("B")) {
                    detail3Spinner.setSelection(2);
                } else if (REASON.equals("C")) {
                    detail3Spinner.setSelection(3);
                } else if (REASON.equals("D")) {
                    detail3Spinner.setSelection(4);
                } else if (REASON.equals("E")) {
                    detail3Spinner.setSelection(5);
                } else if (REASON.equals("F")) {
                    detail3Spinner.setSelection(6);
                } else if (REASON.equals("G")) {
                    detail3Spinner.setSelection(7);
                } else if (REASON.equals("H")) {
                    detail3Spinner.setSelection(8);
                }

                if (MARKINGS.equals("") || MARKINGS.equals(" ")) {
                    markingsSpinner.setSelection(0);
                } else if (MARKINGS.equals("Not Applicable")) {
                    markingsSpinner.setSelection(1);
                } else if (MARKINGS.equals("Satisfactory")) {
                    markingsSpinner.setSelection(2);
                } else if (MARKINGS.equals("Not Available")) {
                    markingsSpinner.setSelection(3);
                } else if (MARKINGS.equals("Unsatisfactory")) {
                    markingsSpinner.setSelection(4);
                }

                if (MANUAL.equals("") || MANUAL.equals(" ")) {
                    manualSpinner.setSelection(0);
                } else if (MANUAL.equals("Not Applicable")) {
                    manualSpinner.setSelection(1);
                } else if (MANUAL.equals("Satisfactory")) {
                    manualSpinner.setSelection(2);
                } else if (MANUAL.equals("Not Available")) {
                    manualSpinner.setSelection(3);
                } else if (MANUAL.equals("Unsatisfactory")) {
                    manualSpinner.setSelection(4);
                }

                if (CABIN.equals("") || CABIN.equals(" ")) {
                    cabinSpinner.setSelection(0);
                } else if (CABIN.equals("Not Applicable")) {
                    cabinSpinner.setSelection(1);
                } else if (CABIN.equals("Satisfactory")) {
                    cabinSpinner.setSelection(2);
                } else if (CABIN.equals("Not Available")) {
                    cabinSpinner.setSelection(3);
                } else if (CABIN.equals("Unsatisfactory")) {
                    cabinSpinner.setSelection(4);
                }

                if (FIRE_EXTINGUISHER.equals("") || FIRE_EXTINGUISHER.equals(" ")) {
                    fireExtinguisherSpinner.setSelection(0);
                } else if (FIRE_EXTINGUISHER.equals("Not Applicable")) {
                    fireExtinguisherSpinner.setSelection(1);
                } else if (FIRE_EXTINGUISHER.equals("Satisfactory")) {
                    fireExtinguisherSpinner.setSelection(2);
                } else if (FIRE_EXTINGUISHER.equals("Not Available")) {
                    fireExtinguisherSpinner.setSelection(3);
                } else if (FIRE_EXTINGUISHER.equals("Unsatisfactory")) {
                    fireExtinguisherSpinner.setSelection(4);
                }

                if (VISUAL.equals("") || VISUAL.equals(" ")) {
                    visualSpinner.setSelection(0);
                } else if (VISUAL.equals("Not Applicable")) {
                    visualSpinner.setSelection(1);
                } else if (VISUAL.equals("Satisfactory")) {
                    visualSpinner.setSelection(2);
                } else if (VISUAL.equals("Not Available")) {
                    visualSpinner.setSelection(3);
                } else if (VISUAL.equals("Unsatisfactory")) {
                    visualSpinner.setSelection(4);
                }

                if (LOAD_CHART.equals("") || LOAD_CHART.equals(" ")) {
                    loadChartSpinner.setSelection(0);
                } else if (LOAD_CHART.equals("Not Applicable")) {
                    loadChartSpinner.setSelection(1);
                } else if (LOAD_CHART.equals("Satisfactory")) {
                    loadChartSpinner.setSelection(2);
                } else if (LOAD_CHART.equals("Not Available")) {
                    loadChartSpinner.setSelection(3);
                } else if (LOAD_CHART.equals("Unsatisfactory")) {
                    loadChartSpinner.setSelection(4);
                }

                if (CHASSIS.equals("") || CHASSIS.equals(" ")) {
                    chassisSpinner.setSelection(0);
                } else if (CHASSIS.equals("Not Applicable")) {
                    chassisSpinner.setSelection(1);
                } else if (CHASSIS.equals("Satisfactory")) {
                    chassisSpinner.setSelection(2);
                } else if (CHASSIS.equals("Not Available")) {
                    chassisSpinner.setSelection(3);
                } else if (CHASSIS.equals("Unsatisfactory")) {
                    chassisSpinner.setSelection(4);
                }

                if (SLEWING.equals("") || SLEWING.equals(" ")) {
                    slewingSpinner.setSelection(0);
                } else if (SLEWING.equals("Not Applicable")) {
                    slewingSpinner.setSelection(1);
                } else if (SLEWING.equals("Satisfactory")) {
                    slewingSpinner.setSelection(2);
                } else if (SLEWING.equals("Not Available")) {
                    slewingSpinner.setSelection(3);
                } else if (SLEWING.equals("Unsatisfactory")) {
                    slewingSpinner.setSelection(4);
                }

                if (OUTRIGGER.equals("") || OUTRIGGER.equals(" ")) {
                    outriggersSpinner.setSelection(0);
                } else if (OUTRIGGER.equals("Not Applicable")) {
                    outriggersSpinner.setSelection(1);
                } else if (OUTRIGGER.equals("Satisfactory")) {
                    outriggersSpinner.setSelection(2);
                } else if (OUTRIGGER.equals("Not Available")) {
                    outriggersSpinner.setSelection(3);
                } else if (OUTRIGGER.equals("Unsatisfactory")) {
                    outriggersSpinner.setSelection(4);
                }

                if (SPARK_ARRESTOR.equals("") || SPARK_ARRESTOR.equals(" ")) {
                    sparkArrestorSpinner.setSelection(0);
                } else if (SPARK_ARRESTOR.equals("Not Applicable")) {
                    sparkArrestorSpinner.setSelection(1);
                } else if (SPARK_ARRESTOR.equals("Satisfactory")) {
                    sparkArrestorSpinner.setSelection(2);
                } else if (SPARK_ARRESTOR.equals("Not Available")) {
                    sparkArrestorSpinner.setSelection(3);
                } else if (SPARK_ARRESTOR.equals("Unsatisfactory")) {
                    sparkArrestorSpinner.setSelection(4);
                }

                if (FORKS.equals("") || FORKS.equals(" ")) {
                    forksSpinner.setSelection(0);
                } else if (FORKS.equals("Not Applicable")) {
                    forksSpinner.setSelection(1);
                } else if (FORKS.equals("Satisfactory")) {
                    forksSpinner.setSelection(2);
                } else if (FORKS.equals("Not Available")) {
                    forksSpinner.setSelection(3);
                } else if (FORKS.equals("Unsatisfactory")) {
                    forksSpinner.setSelection(4);
                }

                if (CYLINDERS.equals("") || CYLINDERS.equals(" ")) {
                    cylinderSpinner.setSelection(0);
                } else if (CYLINDERS.equals("Not Applicable")) {
                    cylinderSpinner.setSelection(1);
                } else if (CYLINDERS.equals("Satisfactory")) {
                    cylinderSpinner.setSelection(2);
                } else if (CYLINDERS.equals("Not Available")) {
                    cylinderSpinner.setSelection(3);
                } else if (CYLINDERS.equals("Unsatisfactory")) {
                    cylinderSpinner.setSelection(4);
                }

                if (BRAKING.equals("") || BRAKING.equals(" ")) {
                    brakingSpinner.setSelection(0);
                } else if (BRAKING.equals("Not Applicable")) {
                    brakingSpinner.setSelection(1);
                } else if (BRAKING.equals("Satisfactory")) {
                    brakingSpinner.setSelection(2);
                } else if (BRAKING.equals("Not Available")) {
                    brakingSpinner.setSelection(3);
                } else if (BRAKING.equals("Unsatisfactory")) {
                    brakingSpinner.setSelection(4);
                }

                if (CONNECTIONS.equals("") || CONNECTIONS.equals(" ")) {
                    connectionsSpinner.setSelection(0);
                } else if (CONNECTIONS.equals("Not Applicable")) {
                    connectionsSpinner.setSelection(1);
                } else if (CONNECTIONS.equals("Satisfactory")) {
                    connectionsSpinner.setSelection(2);
                } else if (CONNECTIONS.equals("Not Available")) {
                    connectionsSpinner.setSelection(3);
                } else if (CONNECTIONS.equals("Unsatisfactory")) {
                    connectionsSpinner.setSelection(4);
                }

                if (SUPERSTRUCTURE.equals("") || SUPERSTRUCTURE.equals(" ")) {
                    superstructureSpinner.setSelection(0);
                } else if (SUPERSTRUCTURE.equals("Not Applicable")) {
                    superstructureSpinner.setSelection(1);
                } else if (SUPERSTRUCTURE.equals("Satisfactory")) {
                    superstructureSpinner.setSelection(2);
                } else if (SUPERSTRUCTURE.equals("Not Available")) {
                    superstructureSpinner.setSelection(3);
                } else if (SUPERSTRUCTURE.equals("Unsatisfactory")) {
                    superstructureSpinner.setSelection(4);
                }

                if (HYDRAULIC.equals("") || HYDRAULIC.equals(" ")) {
                    hydraulicSpinner.setSelection(0);
                } else if (HYDRAULIC.equals("Not Applicable")) {
                    hydraulicSpinner.setSelection(1);
                } else if (HYDRAULIC.equals("Satisfactory")) {
                    hydraulicSpinner.setSelection(2);
                } else if (HYDRAULIC.equals("Not Available")) {
                    hydraulicSpinner.setSelection(3);
                } else if (HYDRAULIC.equals("Unsatisfactory")) {
                    hydraulicSpinner.setSelection(4);
                }

                if (FLUID.equals("") || FLUID.equals(" ")) {
                    fluidSpinner.setSelection(0);
                } else if (FLUID.equals("Not Applicable")) {
                    fluidSpinner.setSelection(1);
                } else if (FLUID.equals("Satisfactory")) {
                    fluidSpinner.setSelection(2);
                } else if (FLUID.equals("Not Available")) {
                    fluidSpinner.setSelection(3);
                } else if (FLUID.equals("Unsatisfactory")) {
                    fluidSpinner.setSelection(4);
                }

                if (TYRES.equals("") || TYRES.equals(" ")) {
                    tyresSpinner.setSelection(0);
                } else if (TYRES.equals("Not Applicable")) {
                    tyresSpinner.setSelection(1);
                } else if (TYRES.equals("Satisfactory")) {
                    tyresSpinner.setSelection(2);
                } else if (TYRES.equals("Not Available")) {
                    tyresSpinner.setSelection(3);
                } else if (TYRES.equals("Unsatisfactory")) {
                    tyresSpinner.setSelection(4);
                }

                if (WIRE_ROPE.equals("") || WIRE_ROPE.equals(" ")) {
                    wireRopeSpinner.setSelection(0);
                } else if (WIRE_ROPE.equals("Not Applicable")) {
                    wireRopeSpinner.setSelection(1);
                } else if (WIRE_ROPE.equals("Satisfactory")) {
                    wireRopeSpinner.setSelection(2);
                } else if (WIRE_ROPE.equals("Not Available")) {
                    wireRopeSpinner.setSelection(3);
                } else if (WIRE_ROPE.equals("Unsatisfactory")) {
                    wireRopeSpinner.setSelection(4);
                }

                if (ELECTRICAL_SYSTEM.equals("") || ELECTRICAL_SYSTEM.equals(" ")) {
                    electricalSpinner.setSelection(0);
                } else if (ELECTRICAL_SYSTEM.equals("Not Applicable")) {
                    electricalSpinner.setSelection(1);
                } else if (ELECTRICAL_SYSTEM.equals("Satisfactory")) {
                    electricalSpinner.setSelection(2);
                } else if (ELECTRICAL_SYSTEM.equals("Not Available")) {
                    electricalSpinner.setSelection(3);
                } else if (ELECTRICAL_SYSTEM.equals("Unsatisfactory")) {
                    electricalSpinner.setSelection(4);
                }

                if (EARTHING.equals("") || EARTHING.equals(" ")) {
                    earthingSpinner.setSelection(0);
                } else if (EARTHING.equals("Not Applicable")) {
                    earthingSpinner.setSelection(1);
                } else if (EARTHING.equals("Satisfactory")) {
                    earthingSpinner.setSelection(2);
                } else if (EARTHING.equals("Not Available")) {
                    earthingSpinner.setSelection(3);
                } else if (EARTHING.equals("Unsatisfactory")) {
                    earthingSpinner.setSelection(4);
                }

                if (BATTERIES.equals("") || BATTERIES.equals(" ")) {
                    batteriesSpinner.setSelection(0);
                } else if (BATTERIES.equals("Not Applicable")) {
                    batteriesSpinner.setSelection(1);
                } else if (BATTERIES.equals("Satisfactory")) {
                    batteriesSpinner.setSelection(2);
                } else if (BATTERIES.equals("Not Available")) {
                    batteriesSpinner.setSelection(3);
                } else if (BATTERIES.equals("Unsatisfactory")) {
                    batteriesSpinner.setSelection(4);
                }

                if (ANEMOMETER.equals("") || ANEMOMETER.equals(" ")) {
                    anemometerSpinner.setSelection(0);
                } else if (ANEMOMETER.equals("Not Applicable")) {
                    anemometerSpinner.setSelection(1);
                } else if (ANEMOMETER.equals("Satisfactory")) {
                    anemometerSpinner.setSelection(2);
                } else if (ANEMOMETER.equals("Not Available")) {
                    anemometerSpinner.setSelection(3);
                } else if (ANEMOMETER.equals("Unsatisfactory")) {
                    anemometerSpinner.setSelection(4);
                }

                if (CONTROLS.equals("") || CONTROLS.equals(" ")) {
                    controlsSpinner.setSelection(0);
                } else if (CONTROLS.equals("Not Applicable")) {
                    controlsSpinner.setSelection(1);
                } else if (CONTROLS.equals("Satisfactory")) {
                    controlsSpinner.setSelection(2);
                } else if (CONTROLS.equals("Not Available")) {
                    controlsSpinner.setSelection(3);
                } else if (CONTROLS.equals("Unsatisfactory")) {
                    controlsSpinner.setSelection(4);
                }

                if (SPEED.equals("") || SPEED.equals(" ")) {
                    speedSpinner.setSelection(0);
                } else if (SPEED.equals("Not Applicable")) {
                    speedSpinner.setSelection(1);
                } else if (SPEED.equals("Satisfactory")) {
                    speedSpinner.setSelection(2);
                } else if (SPEED.equals("Not Available")) {
                    speedSpinner.setSelection(3);
                } else if (SPEED.equals("Unsatisfactory")) {
                    speedSpinner.setSelection(4);
                }

                if (EMERGENCY_STOP.equals("") || EMERGENCY_STOP.equals(" ")) {
                    emergencyStopSpinner.setSelection(0);
                } else if (EMERGENCY_STOP.equals("Not Applicable")) {
                    emergencyStopSpinner.setSelection(1);
                } else if (EMERGENCY_STOP.equals("Satisfactory")) {
                    emergencyStopSpinner.setSelection(2);
                } else if (EMERGENCY_STOP.equals("Not Available")) {
                    emergencyStopSpinner.setSelection(3);
                } else if (EMERGENCY_STOP.equals("Unsatisfactory")) {
                    emergencyStopSpinner.setSelection(4);
                }

                if (OVERLOAD.equals("") || OVERLOAD.equals(" ")) {
                    overloadSpinner.setSelection(0);
                } else if (OVERLOAD.equals("Not Applicable")) {
                    overloadSpinner.setSelection(1);
                } else if (OVERLOAD.equals("Satisfactory")) {
                    overloadSpinner.setSelection(2);
                } else if (OVERLOAD.equals("Not Available")) {
                    overloadSpinner.setSelection(3);
                } else if (OVERLOAD.equals("Unsatisfactory")) {
                    overloadSpinner.setSelection(4);
                }

                if (LIMIT_SWITCHES.equals("") || LIMIT_SWITCHES.equals(" ")) {
                    limitSwitchSpinner.setSelection(0);
                } else if (LIMIT_SWITCHES.equals("Not Applicable")) {
                    limitSwitchSpinner.setSelection(1);
                } else if (LIMIT_SWITCHES.equals("Satisfactory")) {
                    limitSwitchSpinner.setSelection(2);
                } else if (LIMIT_SWITCHES.equals("Not Available")) {
                    limitSwitchSpinner.setSelection(3);
                } else if (LIMIT_SWITCHES.equals("Unsatisfactory")) {
                    limitSwitchSpinner.setSelection(4);
                }

                if (TILTING.equals("") || TILTING.equals(" ")) {
                    tiltingSpinner.setSelection(0);
                } else if (TILTING.equals("Not Applicable")) {
                    tiltingSpinner.setSelection(1);
                } else if (TILTING.equals("Satisfactory")) {
                    tiltingSpinner.setSelection(2);
                } else if (TILTING.equals("Not Available")) {
                    tiltingSpinner.setSelection(3);
                } else if (TILTING.equals("Unsatisfactory")) {
                    tiltingSpinner.setSelection(4);
                }

                if (LIGHTS.equals("") || LIGHTS.equals(" ")) {
                    lightsSpinner.setSelection(0);
                } else if (LIGHTS.equals("Not Applicable")) {
                    lightsSpinner.setSelection(1);
                } else if (LIGHTS.equals("Satisfactory")) {
                    lightsSpinner.setSelection(2);
                } else if (LIGHTS.equals("Not Available")) {
                    lightsSpinner.setSelection(3);
                } else if (LIGHTS.equals("Unsatisfactory")) {
                    lightsSpinner.setSelection(4);
                }

                if (FUNCTIONS.equals("") || FUNCTIONS.equals(" ")) {
                    functionsSpinner.setSelection(0);
                } else if (FUNCTIONS.equals("Not Applicable")) {
                    functionsSpinner.setSelection(1);
                } else if (FUNCTIONS.equals("Satisfactory")) {
                    functionsSpinner.setSelection(2);
                } else if (FUNCTIONS.equals("Not Available")) {
                    functionsSpinner.setSelection(3);
                } else if (FUNCTIONS.equals("Unsatisfactory")) {
                    functionsSpinner.setSelection(4);
                }

                if (EMERGENCY_FUNCTIONS.equals("") || EMERGENCY_FUNCTIONS.equals(" ")) {
                    emergencyFunctionsSpinner.setSelection(0);
                } else if (EMERGENCY_FUNCTIONS.equals("Not Applicable")) {
                    emergencyFunctionsSpinner.setSelection(1);
                } else if (EMERGENCY_FUNCTIONS.equals("Satisfactory")) {
                    emergencyFunctionsSpinner.setSelection(2);
                } else if (EMERGENCY_FUNCTIONS.equals("Not Available")) {
                    emergencyFunctionsSpinner.setSelection(3);
                } else if (EMERGENCY_FUNCTIONS.equals("Unsatisfactory")) {
                    emergencyFunctionsSpinner.setSelection(4);
                }

                if (WEIGHT.equals("") || WEIGHT.equals(" ")) {
                    weightSpinner.setSelection(0);
                } else if (WEIGHT.equals("kg")) {
                    weightSpinner.setSelection(1);
                } else if (WEIGHT.equals("tonne")) {
                    weightSpinner.setSelection(2);
                } else if (WEIGHT.equals("ton")) {
                    weightSpinner.setSelection(3);
                } else if (WEIGHT.equals("lbs")) {
                    weightSpinner.setSelection(4);
                } else if (WEIGHT.equals("kN")) {
                    weightSpinner.setSelection(5);
                }

                if (LENGTH.equals("") || LENGTH.equals(" ")) {
                    lengthSpinner.setSelection(0);
                } else if (LENGTH.equals("mtrs")) {
                    lengthSpinner.setSelection(1);
                } else if (LENGTH.equals("ft")) {
                    lengthSpinner.setSelection(2);
                }

                if (OUTCOME.equals("") || OUTCOME.equals(" ")) {
                    outcomeSpinner.setSelection(0);
                } else if (OUTCOME.equals("Satisfactory")) {
                    outcomeSpinner.setSelection(1);
                } else if (OUTCOME.equals("Unsatisfactory")) {
                    outcomeSpinner.setSelection(2);
                }


                imagesActive = IMAGE_ACTIVE;

                    if (IMAGE1.contains("content://")){
                        image1.setVisibility(View.VISIBLE);
                        imageRow1.setVisibility(View.VISIBLE);
                        image1.setText(IMAGE1);
                        numberOfImages = 1;
                    }

                    if (IMAGE2.contains("content://")){
                        image2.setVisibility(View.VISIBLE);
                        imageRow2.setVisibility(View.VISIBLE);
                        image2.setText(IMAGE2);
                        numberOfImages = 2;
                    }

                    if (IMAGE3.contains("content://")){
                        image3.setVisibility(View.VISIBLE);
                        imageRow3.setVisibility(View.VISIBLE);
                        image3.setText(IMAGE3);
                        numberOfImages = 3;
                    }

                    if (IMAGE4.contains("content://")){
                        image4.setVisibility(View.VISIBLE);
                        imageRow4.setVisibility(View.VISIBLE);
                        image4.setText(IMAGE4);
                        numberOfImages = 4;
                    }

                time = TIME;
                start = START;

                calibration1.setText(CALIBRATION1);
                calibration2.setText(CALIBRATION2);
                calibration3.setText(CALIBRATION3);
                calibration4.setText(CALIBRATION4);


                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                Date d1;
                Date d2;

                try{
                    d1 = format.parse(START);
                    d2 = format.parse(TIME);

                    long diff = d2.getTime() - d1.getTime();
                    String diff2 = (new SimpleDateFormat("HH:mm:ss")).format(new Date(diff));

                    globalVariables.DURATION = diff2;

                }catch (Exception e){

                }


                if (OUTCOME.equals("Satisfactory")){
                    globalVariables.OUTCOME_STRING = "Pass";
                } else if (OUTCOME.equals("Unsatisfactory")){
                    globalVariables.OUTCOME_STRING = "Fail";
                } else{
                    globalVariables.OUTCOME_STRING = "";
                }

                if (clientField != null) {
                    clientField.setText(CLIENT);
                }
                if (fleetField != null) {
                    fleetField.setText(FLEET);
                }
                if (dateField != null) {
                    dateField.setText(DATE);
                }
                if (serialField != null) {
                    serialField.setText(SERIAL);
                }
                if (locationField != null) {
                    locationField.setText(LOCATION);
                }
                if (addressField != null) {
                    addressField.setText(ADDRESS);
                }
                if (timesheetField != null) {
                    timesheetField.setText(TIMESHEET);
                }
                if (standardField != null) {
                    standardField.setText(STANDARD);
                }
                if (ndtField != null) {
                    ndtField.setText(NDT_REPORT);
                }
                if (previousExamCertField != null) {
                    previousExamCertField.setText(PREVIOUS_EXAM_CERT);
                }
                if (previousExamDateField != null) {
                    previousExamDateField.setText(PREVIOUS_EXAM_DATE);
                }
                if (previousLoadCertField != null) {
                    previousLoadCertField.setText(PREVIOUS_TEST_CERT);
                }
                if (previousLoadDateField != null) {
                    previousLoadDateField.setText(PREVIOUS_TEST_DATE);
                }
                if (mainRopeCertField != null) {
                    mainRopeCertField.setText(MAIN_ROPE_CERT);
                }
                if (auxRopeCertField != null) {
                    auxRopeCertField.setText(AUX_ROPE_CERT);
                }
                if (nameField != null) {
                    if (NAME.equals(" ")){
                    nameField.setText(globalVariables.FULL_NAME);
                    }else{
                    nameField.setText(NAME);
                    }
                }

                if (descriptionField != null) {
                    if (!globalVariables.SELECTED_MEWP.getDescription().equals("")) {
                        descriptionField.setText(globalVariables.SELECTED_MEWP.getDescription());
                    } else {
                        descriptionField.setText(DESCRIPTION);
                    }
                }
                if (makeField != null) {
                    if (!globalVariables.SELECTED_MEWP.getMake().equals("")) {
                        makeField.setText(globalVariables.SELECTED_MEWP.getMake());
                    } else {
                        makeField.setText(MAKE);
                    }
                }
                if (modelField != null) {
                    if (!globalVariables.SELECTED_MEWP.getModel().equals("")) {
                        modelField.setText(globalVariables.SELECTED_MEWP.getModel());
                    } else {
                        modelField.setText(MODEL);
                    }
                }
                if (regField != null) {
                    regField.setText(REG);
                }
                if (swlField != null) {
                    if (!globalVariables.SELECTED_MEWP.getSWL().equals("")) {
                        swlField.setText(globalVariables.SELECTED_MEWP.getSWL());
                    } else {
                        swlField.setText(SWL);
                    }
                }
                if (CWField != null) {
                    CWField.setText(COUNTER_WEIGHT);
                }
                if (ballastField != null) {
                    ballastField.setText(CENTER_BALLAST);
                }
                if (info1Field != null) {
                    if (!globalVariables.SELECTED_MEWP.getWorking().equals("")) {
                        info1Field.setText(globalVariables.SELECTED_MEWP.getWorking());
                    } else {
                        info1Field.setText(INFO_1);
                    }
                }
                if (info2Field != null) {
                    if (!globalVariables.SELECTED_MEWP.getWorking().equals("")) {
                        info2Field.setText(globalVariables.SELECTED_MEWP.getWorking());
                    } else {
                        info2Field.setText(INFO_2);
                    }
                }
                if (info3Field != null) {
                    info3Field.setText(INFO_3);
                }
                if (info4Field != null) {
                    info4Field.setText(INFO_4);
                }
                if (mainLinePullField != null) {
                    mainLinePullField.setText(MAIN_LINE_PULL);
                }
                if (auxLinePullField != null) {
                    auxLinePullField.setText(AUX_LINE_PULL);
                }
                if (mainWireField != null) {
                    mainWireField.setText(ROPE_MAIN);
                }
                if (auxWireField != null) {
                    auxWireField.setText(ROPE_AUX);
                }
                if (trolleyWireField != null) {
                    trolleyWireField.setText(ROPE_TROLLEY);
                }
                if (testSWL1Field != null) {
                    testSWL1Field.setText(TEST_SWL_1);
                }
                if (testSWL2Field != null) {
                    testSWL2Field.setText(TEST_SWL_2);
                }
                if (testSWL3Field != null) {
                    testSWL3Field.setText(TEST_SWL_3);
                }
                if (testSWL4Field != null) {
                    testSWL4Field.setText(TEST_SWL_4);
                }
                if (appliedLoad1Field != null) {
                    appliedLoad1Field.setText(APPLIED_LOAD_1);
                }
                if (appliedLoad2Field != null) {
                    appliedLoad2Field.setText(APPLIED_LOAD_2);
                }
                if (appliedLoad3Field != null) {
                    appliedLoad3Field.setText(APPLIED_LOAD_3);
                }
                if (appliedLoad4Field != null) {
                    appliedLoad4Field.setText(APPLIED_LOAD_4);
                }
                if (boomLength1Field != null) {
                    boomLength1Field.setText(BOOM_LENGTH_1);
                }
                if (boomLength2Field != null) {
                    boomLength2Field.setText(BOOM_LENGTH_2);
                }
                if (boomLength3Field != null) {
                    boomLength3Field.setText(BOOM_LENGTH_3);
                }
                if (boomLength4Field != null) {
                    boomLength4Field.setText(BOOM_LENGTH_4);
                }
                if (radius1Field != null) {
                    radius1Field.setText(TEST_RADIUS_1);
                }
                if (radius2Field != null) {
                    radius2Field.setText(TEST_RADIUS_2);
                }
                if (radius3Field != null) {
                    radius3Field.setText(TEST_RADIUS_3);
                }
                if (radius4Field != null) {
                    radius4Field.setText(TEST_RADIUS_4);
                }
                if (testInfoField != null) {
                    testInfoField.setText(TEST_INFO);
                }
                if (creepingField != null) {
                    creepingField.setText(CREEPING);
                }
                if (outcomeField != null) {
                    outcomeField.setText(OUTCOME);
                }
                if (defectsField != null) {
                    defectsField.setText(DEFECTS);
                }
                if (recommendationsField != null) {
                    recommendationsField.setText(RECOMMENDATIONS);
                }
                if (info1Label != null) {
                    info1Label.setText(INFO_1_TITLE);
                }
                if (info2Label != null) {
                    info2Label.setText(INFO_2_TITLE);
                }
                if (info3Label != null) {
                    info3Label.setText(INFO_3_TITLE);
                }
                if (info4Label != null) {
                    info4Label.setText(INFO_4_TITLE);
                }
                if (equipmentTypeLabel != null) {
                    equipmentTypeLabel.setText(EQUIPMENT_TYPE);
                    if (EQUIPMENT_TYPE.equals("MEWP/AWP")){
                        searchLayout.setVisibility(View.VISIBLE);
                    }
                }
                if (inspectionTypeLabel != null) {
                    inspectionTypeLabel.setText(INSPECTION_TYPE);
                }
                if (weightLabel != null) {
                    weightLabel.setText(WEIGHT);
                }
                if (lengthLabel != null) {
                    lengthLabel.setText(LENGTH);
                }
                if (weight1Label != null){
                    weight1Label.setText(WEIGHT);
                }
                if (length1Label != null){
                    length1Label.setText(LENGTH);
                }
                if (weight2Label != null){
                    weight2Label.setText(WEIGHT);
                }
                if (length2Label != null){
                    length2Label.setText(LENGTH);
                }

                if (weight3Label != null){
                    weight3Label.setText(WEIGHT);
                }
                if (length3Label != null){
                    length3Label.setText(LENGTH);
                }
                if (weight4Label != null){
                    weight4Label.setText(WEIGHT);
                }
                if (length4Label != null){
                    length4Label.setText(LENGTH);
                }
                if (weight5Label != null){
                    weight5Label.setText(WEIGHT);
                }
                if (length5Label != null){
                    length5Label.setText(LENGTH);
                }
                if (weight6Label != null){
                    weight6Label.setText(WEIGHT);
                }
                if (length6Label != null){
                    length6Label.setText(LENGTH);
                }
                if (weight7Label != null){
                    weight7Label.setText(WEIGHT);
                }
                if (length7Label != null){
                    length7Label.setText(LENGTH);
                }
                if (weight8Label != null){

                    weight8Label.setText(WEIGHT);
                }
                if (length8Label != null){
                    length8Label.setText(LENGTH);
                }

                if (recordsLabel != null) {
                    recordsLabel.setText(RECORDS);
                }
                if (detail1Label != null) {
                    detail1Label.setText(DETAIL_1);
                }
                if (detail2Label != null) {
                    detail2Label.setText(DETAIL_2);
                }
                if (detail3Label != null) {
                    detail3Label.setText(REASON);
                }
                if (detail4Label != null) {
                    detail4Label.setText(DETAIL_3);
                }
                if (detail5Label != null) {
                    detail5Label.setText(DETAIL_4);
                }
                if (detail6Label != null) {
                    detail6Label.setText(DETAIL_5);
                }
                if (manualLabel != null) {
                    manualLabel.setText(MANUAL);
                }
                if (markingsLabel != null) {
                    markingsLabel.setText(MARKINGS);
                }
                if (cabinLabel != null) {
                    cabinLabel.setText(CABIN);
                }
                if (fireExtinguisherLabel != null) {
                    fireExtinguisherLabel.setText(FIRE_EXTINGUISHER);
                }
                if (visualLabel != null) {
                    visualLabel.setText(VISUAL);
                }
                if (loadChartLabel != null) {
                    loadChartLabel.setText(LOAD_CHART);
                }
                if (chassisLabel != null) {
                    chassisLabel.setText(CHASSIS);
                }
                if (slewingLabel != null) {
                    slewingLabel.setText(SLEWING);
                }
                if (outriggersLabel != null) {
                    outriggersLabel.setText(OUTRIGGER);
                }
                if (sparkArrestorLabel != null) {
                    sparkArrestorLabel.setText(SPARK_ARRESTOR);
                }
                if (brakingLabel != null) {
                    brakingLabel.setText(BRAKING);
                }
                if (cylinderLabel != null) {
                    cylinderLabel.setText(CYLINDERS);
                }
                if (forksLabel != null) {
                    forksLabel.setText(FORKS);
                }
                if (tyresLabel != null) {
                    tyresLabel.setText(TYRES);
                }
                if (fluidLabel != null) {
                    fluidLabel.setText(FLUID);
                }
                if (superstructureLabel != null) {
                    superstructureLabel.setText(SUPERSTRUCTURE);
                }
                if (hydraulicLabel != null) {
                    hydraulicLabel.setText(HYDRAULIC);
                }
                if (connectionsLabel != null) {
                    connectionsLabel.setText(CONNECTIONS);
                }
                if (wireRopeLabel != null) {
                    wireRopeLabel.setText(WIRE_ROPE);
                }
                if (controlsLabel != null) {
                    controlsLabel.setText(CONTROLS);
                }
                if (emergencyStopLabel != null) {
                    emergencyStopLabel.setText(EMERGENCY_STOP);
                }
                if (electricalLabel != null) {
                    electricalLabel.setText(ELECTRICAL_SYSTEM);
                }
                if (overloadLabel != null) {
                    overloadLabel.setText(OVERLOAD);
                }
                if (anemometerLabel != null) {
                    anemometerLabel.setText(ANEMOMETER);
                }
                if (earthingLabel != null) {
                    earthingLabel.setText(EARTHING);
                }
                if (speedLabel != null) {
                    speedLabel.setText(SPEED);
                }
                if (limitSwitchLabel != null) {
                    limitSwitchLabel.setText(LIMIT_SWITCHES);
                }
                if (batteriesLabel != null) {
                    batteriesLabel.setText(BATTERIES);
                }
                if (tiltingLabel != null) {
                    tiltingLabel.setText(TILTING);
                }
                if (lightsLabel != null) {
                    lightsLabel.setText(LIGHTS);
                }
                if (functionsLabel != null) {
                    functionsLabel.setText(FUNCTIONS);
                }
                if (emergencyFunctionsLabel != null) {
                    emergencyFunctionsLabel.setText(EMERGENCY_FUNCTIONS);
                }
                if (nextExamLabel != null) {
                    nextExamLabel.setText(NEXT_EXAM);
                }
                if (nextTestLabel != null) {
                    nextTestLabel.setText(NEXT_TEST);
                }

                certField.setText(CERTNO);
            }

        }


        /*@Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_machine_checklist, menu);

            return true;
        }*/

    public void updateData() {

        //Todays Date
        DateFormat df = new SimpleDateFormat("HH:mm:ss");

        if (time.equals(" ") && (outcomeField.getText().toString().equals("Satisfactory") || outcomeField.getText().toString().equals("Unsatisfactory"))) {
            String time_completed = df.format(Calendar.getInstance().getTime());
            time = time_completed;
        }

        boolean update;
        String imageNumber = Integer.toString(numberOfImages);


        update = myDB.updateData(
                globalVariables.ID,
                fleetField.getText().toString(),
                serialField.getText().toString(),
                clientField.getText().toString(),
                dateField.getText().toString(),
                equipmentTypeLabel.getText().toString(),
                inspectionTypeLabel.getText().toString(),
                locationField.getText().toString(),
                addressField.getText().toString(),
                timesheetField.getText().toString(),
                recordsLabel.getText().toString(),
                ndtField.getText().toString(),
                previousExamCertField.getText().toString(),
                previousExamDateField.getText().toString(),
                previousLoadCertField.getText().toString(),
                previousLoadDateField.getText().toString(),
                mainRopeCertField.getText().toString(),
                auxRopeCertField.getText().toString(),
                nameField.getText().toString(),
                lengthLabel.getText().toString(),
                weightLabel.getText().toString(),
                detail1Label.getText().toString(),
                detail2Label.getText().toString(),
                detail4Label.getText().toString(),
                detail5Label.getText().toString(),
                detail6Label.getText().toString(),
                detail3Label.getText().toString(),
                standardField.getText().toString(),
                descriptionField.getText().toString(),
                makeField.getText().toString(),
                modelField.getText().toString(),
                regField.getText().toString(),
                swlField.getText().toString(),
                CWField.getText().toString(),
                ballastField.getText().toString(),
                info1Label.getText().toString(),
                info1Field.getText().toString(),
                info2Label.getText().toString(),
                info2Field.getText().toString(),
                info3Label.getText().toString(),
                info3Field.getText().toString(),
                info4Label.getText().toString(),
                info4Field.getText().toString(),
                manualLabel.getText().toString(),
                markingsLabel.getText().toString(),
                cabinLabel.getText().toString(),
                fireExtinguisherLabel.getText().toString(),
                visualLabel.getText().toString(),
                loadChartLabel.getText().toString(),
                chassisLabel.getText().toString(),
                slewingLabel.getText().toString(),
                outriggersLabel.getText().toString(),
                sparkArrestorLabel.getText().toString(),
                brakingLabel.getText().toString(),
                cylinderLabel.getText().toString(),
                forksLabel.getText().toString(),
                tyresLabel.getText().toString(),
                fluidLabel.getText().toString(),
                superstructureLabel.getText().toString(),
                hydraulicLabel.getText().toString(),
                connectionsLabel.getText().toString(),
                wireRopeLabel.getText().toString(),
                mainWireField.getText().toString(),
                auxWireField.getText().toString(),
                trolleyWireField.getText().toString(),
                mainLinePullField.getText().toString(),
                auxLinePullField.getText().toString(),
                controlsLabel.getText().toString(),
                emergencyStopLabel.getText().toString(),
                electricalLabel.getText().toString(),
                overloadLabel.getText().toString(),
                anemometerLabel.getText().toString(),
                earthingLabel.getText().toString(),
                speedLabel.getText().toString(),
                limitSwitchLabel.getText().toString(),
                batteriesLabel.getText().toString(),
                tiltingLabel.getText().toString(),
                lightsLabel.getText().toString(),
                functionsLabel.getText().toString(),
                emergencyFunctionsLabel.getText().toString(),
                testSWL1Field.getText().toString(),
                testSWL2Field.getText().toString(),
                testSWL3Field.getText().toString(),
                testSWL4Field.getText().toString(),
                appliedLoad1Field.getText().toString(),
                appliedLoad2Field.getText().toString(),
                appliedLoad3Field.getText().toString(),
                appliedLoad4Field.getText().toString(),
                boomLength1Field.getText().toString(),
                boomLength2Field.getText().toString(),
                boomLength3Field.getText().toString(),
                boomLength4Field.getText().toString(),
                radius1Field.getText().toString(),
                radius2Field.getText().toString(),
                radius3Field.getText().toString(),
                radius4Field.getText().toString(),
                testInfoField.getText().toString(),
                creepingField.getText().toString(),
                outcomeField.getText().toString(),
                defectsField.getText().toString(),
                recommendationsField.getText().toString(),
                nextExamLabel.getText().toString(),
                nextTestLabel.getText().toString(),
                " ", globalVariables.START_TIME,
                globalVariables.DURATION,
                calibration1.getText().toString(),
                calibration2.getText().toString(),
                calibration3.getText().toString(),
                calibration4.getText().toString(),
                imagesActive,
                image1.getText().toString(),
                image2.getText().toString(),
                image3.getText().toString(),
                image4.getText().toString(),
                certField.getText().toString()
        );


        globalVariables.NAME = nameField.getText().toString();

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date d1 = null;
        Date d2 = null;

        try{
            d1 = format.parse(start);
            d2 = format.parse(time);

            long diff = d2.getTime() - d1.getTime();
            String diff2 = (new SimpleDateFormat("HH:mm:ss")).format(new Date(diff));

            globalVariables.DURATION = diff2;

        }catch (Exception e){

        }



        if (update) {
            Toast.makeText(Machine_Checklist.this, "Save Successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Machine_Checklist.this, "Error Occurred when Saving", Toast.LENGTH_SHORT).show();
        }
    }


        public void onItemSelected(AdapterView<?> parent, View arg1, int arg2, long arg3) {

            //SIX MONTHS
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
            String sixMonths;
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 365 / 2);
            Date resultdate = new Date(c.getTimeInMillis());
            sixMonths = sdf.format(resultdate);

            //12 MONTHS
            String twelveMonths;
            Calendar c2 = Calendar.getInstance();
            c2.add(Calendar.DATE, 365);
            Date resultdatetwo = new Date(c2.getTimeInMillis());
            twelveMonths = sdf.format(resultdatetwo);

            //4 Years
            String fourYears;
            Calendar c1 = Calendar.getInstance();
            c1.add(Calendar.DATE, 365 * 4);
            Date resultdatethree = new Date(c1.getTimeInMillis());
            fourYears = sdf.format(resultdatethree);

            double appliedLoad;
            double swl;
            DecimalFormat df = new DecimalFormat("####0.0");

            switch (parent.getId()) {
                //TestFactor1 Spinner
                case R.id.factor1Spinner:
                    assert factor1Spinner != null;
                    int position1 = factor1Spinner.getSelectedItemPosition();
                    switch (position1) {
                        case 0:
                            break;

                        case 1:
                            try {
                                swl = Double.parseDouble(testSWL1Field.getText().toString());
                                testSWL1Field.setText(df.format(swl));
                                appliedLoad = swl * 1.00;
                                appliedLoad1Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad1Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 2:
                            try {
                                swl = Double.parseDouble(testSWL1Field.getText().toString());
                                testSWL1Field.setText(df.format(swl));
                                appliedLoad = swl * 1.10;
                                appliedLoad1Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad1Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 3:
                            try {
                                swl = Double.parseDouble(testSWL1Field.getText().toString());
                                testSWL1Field.setText(df.format(swl));
                                appliedLoad = swl * 1.25;
                                appliedLoad1Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad1Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 4:
                            try {
                                swl = Double.parseDouble(testSWL1Field.getText().toString());
                                testSWL1Field.setText(df.format(swl));
                                appliedLoad = swl * 1.50;
                                appliedLoad1Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad1Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 5:
                            try {
                                swl = Double.parseDouble(testSWL1Field.getText().toString());
                                testSWL1Field.setText(df.format(swl));
                                appliedLoad = swl * 2.00;
                                appliedLoad1Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad1Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 6:
                            try {
                                swl = Double.parseDouble(testSWL1Field.getText().toString());
                                testSWL1Field.setText(df.format(swl));
                                appliedLoad = swl * 2.50;
                                appliedLoad1Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad1Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 7:
                            try {
                                swl = Double.parseDouble(testSWL1Field.getText().toString());
                                testSWL1Field.setText(df.format(swl));
                                appliedLoad = swl * 3.00;
                                appliedLoad1Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad1Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                    }
                    break;

                //TestFactor2 Spinner
                case R.id.factor2Spinner:
                    int position2 = factor2Spinner.getSelectedItemPosition();
                    switch (position2) {
                        case 0:
                            break;

                        case 1:
                            try {
                                swl = Double.parseDouble(testSWL2Field.getText().toString());
                                testSWL2Field.setText(df.format(swl));
                                appliedLoad = swl * 1.00;
                                appliedLoad2Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad2Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 2:
                            try {
                                swl = Double.parseDouble(testSWL2Field.getText().toString());
                                testSWL2Field.setText(df.format(swl));
                                appliedLoad = swl * 1.10;
                                appliedLoad2Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad2Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 3:
                            try {
                                swl = Double.parseDouble(testSWL2Field.getText().toString());
                                testSWL2Field.setText(df.format(swl));
                                appliedLoad = swl * 1.25;
                                appliedLoad2Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad2Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 4:
                            try {
                                swl = Double.parseDouble(testSWL2Field.getText().toString());
                                testSWL2Field.setText(df.format(swl));
                                appliedLoad = swl * 1.50;
                                appliedLoad2Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad2Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 5:
                            try {
                                swl = Double.parseDouble(testSWL2Field.getText().toString());
                                testSWL2Field.setText(df.format(swl));
                                appliedLoad = swl * 2.00;
                                appliedLoad2Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad2Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 6:
                            try {
                                swl = Double.parseDouble(testSWL2Field.getText().toString());
                                testSWL2Field.setText(df.format(swl));
                                appliedLoad = swl * 2.50;
                                appliedLoad2Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad2Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 7:
                            try {
                                swl = Double.parseDouble(testSWL2Field.getText().toString());
                                testSWL2Field.setText(df.format(swl));
                                appliedLoad = swl * 3.00;
                                appliedLoad2Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad2Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                    }
                    break;

                //TestFactor3 Spinner
                case R.id.factor3Spinner:
                    int position3 = factor3Spinner.getSelectedItemPosition();
                    switch (position3) {
                        case 0:
                            break;

                        case 1:
                            try {
                                swl = Double.parseDouble(testSWL3Field.getText().toString());
                                testSWL3Field.setText(df.format(swl));
                                appliedLoad = swl * 1.00;
                                appliedLoad3Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad3Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 2:
                            try {
                                swl = Double.parseDouble(testSWL3Field.getText().toString());
                                testSWL3Field.setText(df.format(swl));
                                appliedLoad = swl * 1.10;
                                appliedLoad3Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad3Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 3:
                            try {
                                swl = Double.parseDouble(testSWL3Field.getText().toString());
                                testSWL3Field.setText(df.format(swl));
                                appliedLoad = swl * 1.25;
                                appliedLoad3Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad3Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 4:
                            try {
                                swl = Double.parseDouble(testSWL3Field.getText().toString());
                                testSWL3Field.setText(df.format(swl));
                                appliedLoad = swl * 1.50;
                                appliedLoad3Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad3Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 5:
                            try {
                                swl = Double.parseDouble(testSWL3Field.getText().toString());
                                testSWL3Field.setText(df.format(swl));
                                appliedLoad = swl * 2.00;
                                appliedLoad3Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad3Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 6:
                            try {
                                swl = Double.parseDouble(testSWL3Field.getText().toString());
                                testSWL3Field.setText(df.format(swl));
                                appliedLoad = swl * 2.50;
                                appliedLoad3Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad3Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 7:
                            try {
                                swl = Double.parseDouble(testSWL3Field.getText().toString());
                                testSWL3Field.setText(df.format(swl));
                                appliedLoad = swl * 2.00;
                                appliedLoad3Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad3Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                    }
                    break;

                //TestFactor4 Spinner
                case R.id.factor4Spinner:
                    int position4 = factor4Spinner.getSelectedItemPosition();
                    switch (position4) {
                        case 0:
                            break;

                        case 1:
                            try {
                                swl = Double.parseDouble(testSWL4Field.getText().toString());
                                testSWL4Field.setText(df.format(swl));
                                appliedLoad = swl * 1.00;
                                appliedLoad4Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad4Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 2:
                            try {
                                swl = Double.parseDouble(testSWL4Field.getText().toString());
                                testSWL4Field.setText(df.format(swl));
                                appliedLoad = swl * 1.10;
                                appliedLoad4Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad4Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 3:
                            try {
                                swl = Double.parseDouble(testSWL4Field.getText().toString());
                                testSWL4Field.setText(df.format(swl));
                                appliedLoad = swl * 1.25;
                                appliedLoad4Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad4Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 4:
                            try {
                                swl = Double.parseDouble(testSWL4Field.getText().toString());
                                testSWL4Field.setText(df.format(swl));
                                appliedLoad = swl * 1.50;
                                appliedLoad4Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad4Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 5:
                            try {
                                swl = Double.parseDouble(testSWL4Field.getText().toString());
                                testSWL4Field.setText(df.format(swl));
                                appliedLoad = swl * 2.00;
                                appliedLoad4Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad4Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 6:
                            try {
                                swl = Double.parseDouble(testSWL4Field.getText().toString());
                                testSWL4Field.setText(df.format(swl));
                                appliedLoad = swl * 2.50;
                                appliedLoad4Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad4Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                        case 7:
                            try {
                                swl = Double.parseDouble(testSWL4Field.getText().toString());
                                testSWL4Field.setText(df.format(swl));
                                appliedLoad = swl * 3.00;
                                appliedLoad4Field.setText(df.format(appliedLoad));
                            } catch (Exception e){
                                appliedLoad4Field.setText("0.0");
                                globalVariables.makeToast(Machine_Checklist.this, "Please enter a SWL");
                            }
                            break;
                    }
                    break;

                case R.id.equipmentTypeSpinner:
                    int position5 = equipmentTypeSpinner.getSelectedItemPosition();

                    switch (position5) {
                        case 0:
                            break;
                        case 1:
                            //MEWP
                            info1Label.setText("10. Working Height");
                            info2Label.setText("11. Platform Height");
                            info3Label.setText("12. Max. Number of People");
                            info4Label.setText("13. Horizontal Reach");
                            equipmentTypeLabel.setText("MEWP/AWP");
                            searchLayout.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            //Mobile Crane
                            info1Label.setText("10. Max. Configuration");
                            info2Label.setText("11. Current Configuration");
                            info3Label.setText("12. Radius (Min. to Max.)");
                            info4Label.setText("13. Boom Length (Min. to Max.)");
                            equipmentTypeLabel.setText("Mobile Crane");
                            searchLayout.setVisibility(View.GONE);
                            break;
                        case 3:
                            //Crawler Crane
                            info1Label.setText("10. Max. Configuration");
                            info2Label.setText("11. Current Configuration");
                            info3Label.setText("12. Radius (Min. to Max.)");
                            info4Label.setText("13. Boom Length (Min. to Max.)");
                            equipmentTypeLabel.setText("Crawler Crane");
                            searchLayout.setVisibility(View.GONE);
                            break;
                        case 4:
                            //Telehandler
                            info1Label.setText("10. Fork Length");
                            info2Label.setText("11. Radius (Min. to Max.)");
                            info3Label.setText("12. Boom Length (Min. to Max.)");
                            info4Label.setText("13. Attachments");
                            equipmentTypeLabel.setText("Telehandler");
                            searchLayout.setVisibility(View.GONE);
                            break;
                        case 5:
                            //Forklift
                            info1Label.setText("10. Fork Length");
                            info2Label.setText("11. Mast Height");
                            info3Label.setText("12. Height of Lift");
                            info4Label.setText("13. Attachments");
                            equipmentTypeLabel.setText("Forklift");
                            searchLayout.setVisibility(View.GONE);
                            break;
                        case 6:
                            //Tower Crane
                            info1Label.setText("10. Tower Height");
                            info2Label.setText("11. Radius (Min. to Max.)");
                            info3Label.setText("12. Current Configuration");
                            info4Label.setText("13. Boom Length");
                            equipmentTypeLabel.setText("Tower Crane");
                            searchLayout.setVisibility(View.GONE);
                            break;
                        case 7:
                            //Jib Crane
                            info1Label.setText("10. Tower Height");
                            info2Label.setText("11. Radius (Min. to Max.)");
                            info3Label.setText("12. Current Configuration");
                            info4Label.setText("13. Boom Length");
                            equipmentTypeLabel.setText("Jib Crane");
                            searchLayout.setVisibility(View.GONE);
                            break;
                        case 8:
                            //Quay Crane
                            info1Label.setText("10. Tower Height");
                            info2Label.setText("11. Radius (Min. to Max.)");
                            info3Label.setText("12. Current Configuration");
                            info4Label.setText("13. Boom Length");
                            equipmentTypeLabel.setText("Quay Crane");
                            searchLayout.setVisibility(View.GONE);
                            break;
                        case 9:
                            //Offshore Crane
                            info1Label.setText("10. Max. Configuration");
                            info2Label.setText("11. Current Configuration");
                            info3Label.setText("12. Radius (Min. to Max.)");
                            info4Label.setText("13. Boom Length (Min. to Max.)");
                            equipmentTypeLabel.setText("Offshore Crane");
                            searchLayout.setVisibility(View.GONE);
                            break;
                        case 10:
                            //Lorry Loading Crane
                            info1Label.setText("10. Max. Configuration");
                            info2Label.setText("11. Current Configuration");
                            info3Label.setText("12. Radius (Min. to Max.)");
                            info4Label.setText("13. Boom Length (Min. to Max.)");
                            equipmentTypeLabel.setText("Lorry Loading Crane");
                            searchLayout.setVisibility(View.GONE);
                            break;
                        case 11:
                            //EOT Crane
                            info1Label.setText("10. Height of Lift");
                            info2Label.setText("11. Current Configuration");
                            info3Label.setText("12. Span");
                            info4Label.setText("13. Long Travel Length");
                            equipmentTypeLabel.setText("EOT/Gantry Crane");
                            searchLayout.setVisibility(View.GONE);
                            break;
                        case 12:
                            //Passenger Hoist
                            info1Label.setText("10. Mast Height");
                            info2Label.setText("11. Platform Length");
                            info3Label.setText("12. Platform Width");
                            info4Label.setText("13. Platform Height");
                            equipmentTypeLabel.setText("Passenger Hoist");
                            searchLayout.setVisibility(View.GONE);
                            break;
                        case 13:
                            //Material Hoist
                            info1Label.setText("10. Mast Height");
                            info2Label.setText("11. Platform Length");
                            info3Label.setText("12. Platform Width");
                            info4Label.setText("13. Platform Height");
                            equipmentTypeLabel.setText("Material Hoist");
                            searchLayout.setVisibility(View.GONE);
                            break;
                        case 14:
                            //Cradle
                            info1Label.setText("10. Working Height");
                            info2Label.setText("11. Platform Length");
                            info3Label.setText("12. Platform Width");
                            info4Label.setText("13. Platform Height");
                            equipmentTypeLabel.setText("Suspended Access Platform");
                            searchLayout.setVisibility(View.GONE);
                            break;


                    }
                    break;

                case R.id.inspectionTypeSpinner:
                    int position6 = inspectionTypeSpinner.getSelectedItemPosition();

                    switch (position6) {
                        case 0:
                            break;
                        case 1:
                            inspectionTypeLabel.setText("Thorough Examination");
                            break;
                        case 2:
                            inspectionTypeLabel.setText("Test & Examination");
                            break;
                    }
                    break;

                case R.id.weightSpinner:
                    int position7 = weightSpinner.getSelectedItemPosition();

                    switch (position7) {
                        case 0:
                            break;
                        case 1:
                            weightLabel.setText("kg");
                            weight1Label.setText("kg");
                            weight2Label.setText("kg");
                            weight3Label.setText("kg");
                            weight4Label.setText("kg");
                            weight5Label.setText("kg");
                            weight6Label.setText("kg");
                            weight7Label.setText("kg");
                            weight8Label.setText("kg");
                            break;
                        case 2:
                            weightLabel.setText("tonne");
                            weight1Label.setText("tonne");
                            weight2Label.setText("tonne");
                            weight3Label.setText("tonne");
                            weight4Label.setText("tonne");
                            weight5Label.setText("tonne");
                            weight6Label.setText("tonne");
                            weight7Label.setText("tonne");
                            weight8Label.setText("tonne");
                            break;
                        case 3:
                            weightLabel.setText("ton");
                            weight1Label.setText("ton");
                            weight2Label.setText("ton");
                            weight3Label.setText("ton");
                            weight4Label.setText("ton");
                            weight5Label.setText("ton");
                            weight6Label.setText("ton");
                            weight7Label.setText("ton");
                            weight8Label.setText("ton");
                            break;
                        case 4:
                            weightLabel.setText("lbs");
                            weight1Label.setText("lbs");
                            weight2Label.setText("lbs");
                            weight3Label.setText("lbs");
                            weight4Label.setText("lbs");
                            weight5Label.setText("lbs");
                            weight6Label.setText("lbs");
                            weight7Label.setText("lbs");
                            weight8Label.setText("lbs");
                            break;
                        case 5:
                            weightLabel.setText("kN");
                            weight1Label.setText("kN");
                            weight2Label.setText("kN");
                            weight3Label.setText("kN");
                            weight4Label.setText("kN");
                            weight5Label.setText("kN");
                            weight6Label.setText("kN");
                            weight7Label.setText("kN");
                            weight8Label.setText("kN");
                            break;
                    }
                    break;

                case R.id.lengthSpinner:
                    int position8 = lengthSpinner.getSelectedItemPosition();

                    switch (position8) {
                        case 0:
                            break;
                        case 1:
                            lengthLabel.setText("mtrs");
                            length1Label.setText("mtrs");
                            length2Label.setText("mtrs");
                            length3Label.setText("mtrs");
                            length4Label.setText("mtrs");
                            length5Label.setText("mtrs");
                            length6Label.setText("mtrs");
                            length7Label.setText("mtrs");
                            length8Label.setText("mtrs");
                            break;
                        case 2:
                            lengthLabel.setText("ft");
                            length1Label.setText("ft");
                            length2Label.setText("ft");
                            length3Label.setText("ft");
                            length4Label.setText("ft");
                            length5Label.setText("ft");
                            length6Label.setText("ft");
                            length7Label.setText("ft");
                            length8Label.setText("ft");
                            break;
                    }
                    break;

                case R.id.recordsSpinner:
                    int position9 = recordsSpinner.getSelectedItemPosition();

                    switch (position9) {
                        case 0:
                            break;
                        case 1:
                            recordsLabel.setText("Available");
                            break;
                        case 2:
                            recordsLabel.setText("Not Available");
                            break;
                    }
                    break;

                case R.id.detail1Spinner:
                    int position10 = detail1Spinner.getSelectedItemPosition();

                    switch (position10) {
                        case 0:
                            break;
                        case 1:
                            detail1Label.setText("Yes");
                            break;
                        case 2:
                            detail1Label.setText("N/A");
                            break;
                        case 3:
                            detail1Label.setText("No");
                            break;
                    }
                    break;

                case R.id.detail2Spinner:
                    int position11 = detail2Spinner.getSelectedItemPosition();

                    switch (position11) {
                        case 0:
                            break;
                        case 1:
                            detail2Label.setText("Yes");
                            break;
                        case 2:
                            detail2Label.setText("N/A");
                            break;
                        case 3:
                            detail2Label.setText("No");
                            break;
                    }
                    break;

                case R.id.detail3Spinner:
                    int position12 = detail3Spinner.getSelectedItemPosition();

                    switch (position12) {
                        case 0:
                            break;
                        case 1:
                            detail3Label.setText("A");
                            break;
                        case 2:
                            detail3Label.setText("B");
                            break;
                        case 3:
                            detail3Label.setText("C");
                            break;
                        case 4:
                            detail3Label.setText("D");
                            break;
                        case 5:
                            detail3Label.setText("E");
                            break;
                        case 6:
                            detail3Label.setText("F");
                            break;
                        case 7:
                            detail3Label.setText("G");
                            break;
                        case 8:
                            detail3Label.setText("H");
                            break;
                    }
                    break;

                case R.id.detail4Spinner:
                    int position13 = detail4Spinner.getSelectedItemPosition();

                    switch (position13) {
                        case 0:
                            break;
                        case 1:
                            detail4Label.setText("Yes");
                            break;
                        case 2:
                            detail4Label.setText("N/A");
                            break;
                        case 3:
                            detail4Label.setText("No");
                            break;
                    }
                    break;

                case R.id.detail5Spinner:
                    int position14 = detail5Spinner.getSelectedItemPosition();

                    switch (position14) {
                        case 0:
                            break;
                        case 1:
                            detail5Label.setText("Yes");
                            break;
                        case 2:
                            detail5Label.setText("N/A");
                            break;
                        case 3:
                            detail5Label.setText("No");
                            break;
                    }
                    break;

                case R.id.detail6Spinner:
                    int position15 = detail6Spinner.getSelectedItemPosition();

                    switch (position15) {
                        case 0:
                            break;
                        case 1:
                            detail6Label.setText("Yes");
                            break;
                        case 2:
                            detail6Label.setText("N/A");
                            break;
                        case 3:
                            detail6Label.setText("No");
                            break;
                    }
                    break;

                case R.id.manualSpinner:
                    int position16 = manualSpinner.getSelectedItemPosition();

                    switch (position16) {
                        case 0:
                            break;
                        case 1:
                            manualLabel.setText("Not Applicable");
                            break;
                        case 2:
                            manualLabel.setText("Satisfactory");
                            break;
                        case 3:
                            manualLabel.setText("Not Available");
                            break;
                        case 4:
                            manualLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.markingsSpinner:
                    int position17 = markingsSpinner.getSelectedItemPosition();

                    switch (position17) {
                        case 0:
                            break;
                        case 1:
                            markingsLabel.setText("Not Applicable");
                            break;
                        case 2:
                            markingsLabel.setText("Satisfactory");
                            break;
                        case 3:
                            markingsLabel.setText("Not Available");
                            break;
                        case 4:
                            markingsLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.cabinSpinner:
                    int position18 = cabinSpinner.getSelectedItemPosition();

                    switch (position18) {
                        case 0:
                            break;
                        case 1:
                            cabinLabel.setText("Not Applicable");
                            break;
                        case 2:
                            cabinLabel.setText("Satisfactory");
                            break;
                        case 3:
                            cabinLabel.setText("Not Available");
                            break;
                        case 4:
                            cabinLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.fireExtinguisherSpinner:
                    int position19 = fireExtinguisherSpinner.getSelectedItemPosition();

                    switch (position19) {
                        case 0:
                            break;
                        case 1:
                            fireExtinguisherLabel.setText("Not Applicable");
                            break;
                        case 2:
                            fireExtinguisherLabel.setText("Satisfactory");
                            break;
                        case 3:
                            fireExtinguisherLabel.setText("Not Available");
                            break;
                        case 4:
                            fireExtinguisherLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.visualSpinner:
                    int position20 = visualSpinner.getSelectedItemPosition();

                    switch (position20) {
                        case 0:
                            break;
                        case 1:
                            visualLabel.setText("Not Applicable");
                            break;
                        case 2:
                            visualLabel.setText("Satisfactory");
                            break;
                        case 3:
                            visualLabel.setText("Not Available");
                            break;
                        case 4:
                            visualLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.loadChartSpinner:
                    int position21 = loadChartSpinner.getSelectedItemPosition();

                    switch (position21) {
                        case 0:
                            break;
                        case 1:
                            loadChartLabel.setText("Not Applicable");
                            break;
                        case 2:
                            loadChartLabel.setText("Satisfactory");
                            break;
                        case 3:
                            loadChartLabel.setText("Not Available");
                            break;
                        case 4:
                            loadChartLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.chassisSpinner:
                    int position22 = chassisSpinner.getSelectedItemPosition();

                    switch (position22) {
                        case 0:
                            break;
                        case 1:
                            chassisLabel.setText("Not Applicable");
                            break;
                        case 2:
                            chassisLabel.setText("Satisfactory");
                            break;
                        case 3:
                            chassisLabel.setText("Not Available");
                            break;
                        case 4:
                            chassisLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.slewingSpinner:
                    int position23 = slewingSpinner.getSelectedItemPosition();

                    switch (position23) {
                        case 0:
                            break;
                        case 1:
                            slewingLabel.setText("Not Applicable");
                            break;
                        case 2:
                            slewingLabel.setText("Satisfactory");
                            break;
                        case 3:
                            slewingLabel.setText("Not Available");
                            break;
                        case 4:
                            slewingLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.outriggersSpinner:
                    int position24 = outriggersSpinner.getSelectedItemPosition();

                    switch (position24) {
                        case 0:
                            break;
                        case 1:
                            outriggersLabel.setText("Not Applicable");
                            break;
                        case 2:
                            outriggersLabel.setText("Satisfactory");
                            break;
                        case 3:
                            outriggersLabel.setText("Not Available");
                            break;
                        case 4:
                            outriggersLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.sparkArrestorSpinner:
                    int position25 = sparkArrestorSpinner.getSelectedItemPosition();

                    switch (position25) {
                        case 0:
                            break;
                        case 1:
                            sparkArrestorLabel.setText("Not Applicable");
                            break;
                        case 2:
                            sparkArrestorLabel.setText("Satisfactory");
                            break;
                        case 3:
                            sparkArrestorLabel.setText("Not Available");
                            break;
                        case 4:
                            sparkArrestorLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.brakingSpinner:
                    int position26 = brakingSpinner.getSelectedItemPosition();

                    switch (position26) {
                        case 0:
                            break;
                        case 1:
                            brakingLabel.setText("Not Applicable");
                            break;
                        case 2:
                            brakingLabel.setText("Satisfactory");
                            break;
                        case 3:
                            brakingLabel.setText("Not Available");
                            break;
                        case 4:
                            brakingLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.cylinderSpinner:
                    int position27 = cylinderSpinner.getSelectedItemPosition();

                    switch (position27) {
                        case 0:
                            break;
                        case 1:
                            cylinderLabel.setText("Not Applicable");
                            break;
                        case 2:
                            cylinderLabel.setText("Satisfactory");
                            break;
                        case 3:
                            cylinderLabel.setText("Not Available");
                            break;
                        case 4:
                            cylinderLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.forksSpinner:
                    int position28 = forksSpinner.getSelectedItemPosition();

                    switch (position28) {
                        case 0:
                            break;
                        case 1:
                            forksLabel.setText("Not Applicable");
                            break;
                        case 2:
                            forksLabel.setText("Satisfactory");
                            break;
                        case 3:
                            forksLabel.setText("Not Available");
                            break;
                        case 4:
                            forksLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.tyresSpinner:
                    int position29 = tyresSpinner.getSelectedItemPosition();

                    switch (position29) {
                        case 0:
                            break;
                        case 1:
                            tyresLabel.setText("Not Applicable");
                            break;
                        case 2:
                            tyresLabel.setText("Satisfactory");
                            break;
                        case 3:
                            tyresLabel.setText("Not Available");
                            break;
                        case 4:
                            tyresLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.fluidSpinner:
                    int position30 = fluidSpinner.getSelectedItemPosition();

                    switch (position30) {
                        case 0:
                            break;
                        case 1:
                            fluidLabel.setText("Not Applicable");
                            break;
                        case 2:
                            fluidLabel.setText("Satisfactory");
                            break;
                        case 3:
                            fluidLabel.setText("Not Available");
                            break;
                        case 4:
                            fluidLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.superstructureSpinner:
                    int position31 = superstructureSpinner.getSelectedItemPosition();

                    switch (position31) {
                        case 0:
                            break;
                        case 1:
                            superstructureLabel.setText("Not Applicable");
                            break;
                        case 2:
                            superstructureLabel.setText("Satisfactory");
                            break;
                        case 3:
                            superstructureLabel.setText("Not Available");
                            break;
                        case 4:
                            superstructureLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.hydraulicSpinner:
                    int position32 = hydraulicSpinner.getSelectedItemPosition();

                    switch (position32) {
                        case 0:
                            break;
                        case 1:
                            hydraulicLabel.setText("Not Applicable");
                            break;
                        case 2:
                            hydraulicLabel.setText("Satisfactory");
                            break;
                        case 3:
                            hydraulicLabel.setText("Not Available");
                            break;
                        case 4:
                            hydraulicLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.connectionsSpinner:
                    int position33 = connectionsSpinner.getSelectedItemPosition();

                    switch (position33) {
                        case 0:
                            break;
                        case 1:
                            connectionsLabel.setText("Not Applicable");
                            break;
                        case 2:
                            connectionsLabel.setText("Satisfactory");
                            break;
                        case 3:
                            connectionsLabel.setText("Not Available");
                            break;
                        case 4:
                            connectionsLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.wireRopeSpinner:
                    int position34 = wireRopeSpinner.getSelectedItemPosition();

                    switch (position34) {
                        case 0:
                            break;
                        case 1:
                            wireRopeLabel.setText("Not Applicable");
                            break;
                        case 2:
                            wireRopeLabel.setText("Satisfactory");
                            break;
                        case 3:
                            wireRopeLabel.setText("Not Available");
                            break;
                        case 4:
                            wireRopeLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.controlsSpinner:
                    int position35 = controlsSpinner.getSelectedItemPosition();

                    switch (position35) {
                        case 0:
                            break;
                        case 1:
                            controlsLabel.setText("Not Applicable");
                            break;
                        case 2:
                            controlsLabel.setText("Satisfactory");
                            break;
                        case 3:
                            controlsLabel.setText("Not Available");
                            break;
                        case 4:
                            controlsLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.emergencyStopSpinner:
                    int position36 = emergencyStopSpinner.getSelectedItemPosition();

                    switch (position36) {
                        case 0:
                            break;
                        case 1:
                            emergencyStopLabel.setText("Not Applicable");
                            break;
                        case 2:
                            emergencyStopLabel.setText("Satisfactory");
                            break;
                        case 3:
                            emergencyStopLabel.setText("Not Available");
                            break;
                        case 4:
                            emergencyStopLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.electricalSpinner:
                    int position37 = electricalSpinner.getSelectedItemPosition();

                    switch (position37) {
                        case 0:
                            break;
                        case 1:
                            electricalLabel.setText("Not Applicable");
                            break;
                        case 2:
                            electricalLabel.setText("Satisfactory");
                            break;
                        case 3:
                            electricalLabel.setText("Not Available");
                            break;
                        case 4:
                            electricalLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.overloadSpinner:
                    int position38 = overloadSpinner.getSelectedItemPosition();

                    switch (position38) {
                        case 0:
                            break;
                        case 1:
                            overloadLabel.setText("Not Applicable");
                            break;
                        case 2:
                            overloadLabel.setText("Satisfactory");
                            break;
                        case 3:
                            overloadLabel.setText("Not Available");
                            break;
                        case 4:
                            overloadLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.anemometerSpinner:
                    int position39 = anemometerSpinner.getSelectedItemPosition();

                    switch (position39) {
                        case 0:
                            break;
                        case 1:
                            anemometerLabel.setText("Not Applicable");
                            break;
                        case 2:
                            anemometerLabel.setText("Satisfactory");
                            break;
                        case 3:
                            anemometerLabel.setText("Not Available");
                            break;
                        case 4:
                            anemometerLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.earthingSpinner:
                    int position40 = earthingSpinner.getSelectedItemPosition();

                    switch (position40) {
                        case 0:
                            break;
                        case 1:
                            earthingLabel.setText("Not Applicable");
                            break;
                        case 2:
                            earthingLabel.setText("Satisfactory");
                            break;
                        case 3:
                            earthingLabel.setText("Not Available");
                            break;
                        case 4:
                            earthingLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.speedSpinner:
                    int position41 = speedSpinner.getSelectedItemPosition();

                    switch (position41) {
                        case 0:
                            break;
                        case 1:
                            speedLabel.setText("Not Applicable");
                            break;
                        case 2:
                            speedLabel.setText("Satisfactory");
                            break;
                        case 3:
                            speedLabel.setText("Not Available");
                            break;
                        case 4:
                            speedLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.limitSwitchSpinner:
                    int position42 = limitSwitchSpinner.getSelectedItemPosition();

                    switch (position42) {
                        case 0:
                            break;
                        case 1:
                            limitSwitchLabel.setText("Not Applicable");
                            break;
                        case 2:
                            limitSwitchLabel.setText("Satisfactory");
                            break;
                        case 3:
                            limitSwitchLabel.setText("Not Available");
                            break;
                        case 4:
                            limitSwitchLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.batteriesSpinner:
                    int position43 = batteriesSpinner.getSelectedItemPosition();

                    switch (position43) {
                        case 0:
                            break;
                        case 1:
                            batteriesLabel.setText("Not Applicable");
                            break;
                        case 2:
                            batteriesLabel.setText("Satisfactory");
                            break;
                        case 3:
                            batteriesLabel.setText("Not Available");
                            break;
                        case 4:
                            batteriesLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.tiltingSpinner:
                    int position44 = tiltingSpinner.getSelectedItemPosition();

                    switch (position44) {
                        case 0:
                            break;
                        case 1:
                            tiltingLabel.setText("Not Applicable");
                            break;
                        case 2:
                            tiltingLabel.setText("Satisfactory");
                            break;
                        case 3:
                            tiltingLabel.setText("Not Available");
                            break;
                        case 4:
                            tiltingLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.lightsSpinner:
                    int position45 = lightsSpinner.getSelectedItemPosition();

                    switch (position45) {
                        case 0:
                            break;
                        case 1:
                            lightsLabel.setText("Not Applicable");
                            break;
                        case 2:
                            lightsLabel.setText("Satisfactory");
                            break;
                        case 3:
                            lightsLabel.setText("Not Available");
                            break;
                        case 4:
                            lightsLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.functionsSpinner:
                    int position46 = functionsSpinner.getSelectedItemPosition();

                    switch (position46) {
                        case 0:
                            break;
                        case 1:
                            functionsLabel.setText("Not Applicable");
                            break;
                        case 2:
                            functionsLabel.setText("Satisfactory");
                            break;
                        case 3:
                            functionsLabel.setText("Not Available");
                            break;
                        case 4:
                            functionsLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.emergencyFunctionsSpinner:
                    int position47 = emergencyFunctionsSpinner.getSelectedItemPosition();

                    switch (position47) {
                        case 0:
                            break;
                        case 1:
                            emergencyFunctionsLabel.setText("Not Applicable");
                            break;
                        case 2:
                            emergencyFunctionsLabel.setText("Satisfactory");
                            break;
                        case 3:
                            emergencyFunctionsLabel.setText("Not Available");
                            break;
                        case 4:
                            emergencyFunctionsLabel.setText("Unsatisfactory");
                            break;
                    }
                    break;

                case R.id.nextExamSpinner:
                    int position48 = nextExamSpinner.getSelectedItemPosition();

                    switch (position48) {
                        case 0:
                            break;
                        case 1:
                            nextExamLabel.setText(sixMonths);
                            break;
                        case 2:
                            nextExamLabel.setText(twelveMonths);
                            break;
                        case 3:
                            nextExamLabel.setText(fourYears);
                            break;
                    }
                    break;

                case R.id.nextTestSpinner:
                    int position49 = nextTestSpinner.getSelectedItemPosition();

                    switch (position49) {
                        case 0:
                            break;
                        case 1:
                            nextTestLabel.setText(sixMonths);
                            break;
                        case 2:
                            nextTestLabel.setText(twelveMonths);
                            break;
                        case 3:
                            nextTestLabel.setText(fourYears);
                            break;
                    }
                    break;

                case R.id.outcomeSpinner:
                    int position50 = outcomeSpinner.getSelectedItemPosition();

                    switch (position50) {
                        case 0:
                            break;
                        case 1:
                            outcomeField.setText("Satisfactory");
                            globalVariables.OUTCOME_STRING = "Pass";
                            //imagesLayout.setVisibility(View.GONE);
                            break;
                        case 2:
                            outcomeField.setText("Unsatisfactory");
                            globalVariables.OUTCOME_STRING = "Fail";
                            break;
                    }
                    break;
            }

        }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}

