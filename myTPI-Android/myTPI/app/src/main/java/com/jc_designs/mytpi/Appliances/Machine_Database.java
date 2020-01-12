package com.jc_designs.mytpi.Appliances;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Machine_Database extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "machineInspection.db";
    public final static String TABLE_NAME = "machine_table";

    //Inspection Info Shown on List View
    public final static String COLUMN_ID = "_id";
    public final static String COLUMN_FLEET = "fleet";
    public final static String COLUMN_SERIAL = "serial";
    public final static String COLUMN_CLIENT = "client";
    public final static String COLUMN_DATE = "date";

    //Inspection Details
    public final static String COLUMN_EQUIPMENT_TYPE = "type";
    public final static String COLUMN_INSPECTION_TYPE = "inspection";
    public final static String COLUMN_LOCATION = "location";
    public final static String COLUMN_ADDRESS = "address";
    public final static String COLUMN_TIMESHEET = "timesheet";
    public final static String COLUMN_RECORDS = "records";
    public final static String COLUMN_NDT_REPORT = "ndt";
    public final static String COLUMN_PREVIOUS_EXAM_CERT = "examCert";
    public final static String COLUMN_PREVIOUS_EXAM_DATE = "examDate";
    public final static String COLUMN_PREVIOUS_TEST_CERT = "testCert";
    public final static String COLUMN_PREVIOUS_TEST_DATE = "testDate";
    public final static String COLUMN_MAIN_ROPE_CERT = "mainRopeCert";
    public final static String COLUMN_AUX_ROPE_CERT = "auxRopeCert";
    public final static String COLUMN_NAME = "name";
    public final static String COLUMN_LENGTH = "length";
    public final static String COLUMN_WEIGHT = "weight";
    public final static String COLUMN_DETAIL_1 = "detailOne";
    public final static String COLUMN_DETAIL_2 = "detailTwo";
    public final static String COLUMN_DETAIL_3 = "detailThree";
    public final static String COLUMN_DETAIL_4 = "detailFour";
    public final static String COLUMN_DETAIL_5 = "detailFive";
    public final static String COLUMN_REASON = "reason";
    public final static String COLUMN_STANDARD = "standard";

    //Machine Info
    public final static String COLUMN_DESCRIPTION = "description";
    public final static String COLUMN_MAKE = "make";
    public final static String COLUMN_MODEL = "model";
    public final static String COLUMN_REG = "reg";
    public final static String COLUMN_SWL = "swl";
    public final static String COLUMN_COUNTER_WEIGHT = "counterWeight";
    public final static String COLUMN_CENTER_BALLAST = "ballast";
    public final static String COLUMN_INFO_1_TITLE = "infoOneTitle";
    public final static String COLUMN_INFO_1 = "infoOne";
    public final static String COLUMN_INFO_2_TITLE = "infoTwoTitle";
    public final static String COLUMN_INFO_2 = "infoTwo";
    public final static String COLUMN_INFO_3_TITLE = "infoThreeTitle";
    public final static String COLUMN_INFO_3 = "infoThree";
    public final static String COLUMN_INFO_4_TITLE = "infoFourTitle";
    public final static String COLUMN_INFO_4 = "infoFour";

    // Visual Condition
    public final static String COLUMN_MANUAL = "manual";
    public final static String COLUMN_MARKINGS = "markings";
    public final static String COLUMN_CABIN = "cabin";
    public final static String COLUMN_FIRE_EXTINGUISHER = "fireExtinguisher";
    public final static String COLUMN_VISUAL = "visual";
    public final static String COLUMN_LOAD_CHART = "loadChart";

    //Mechanical Systems
    public final static String COLUMN_CHASSIS = "chassis";
    public final static String COLUMN_SLEWING = "slewing";
    public final static String COLUMN_OUTRIGGERS = "outriggers";
    public final static String COLUMN_SPARK_ARRESTOR = "sparkArrestor";
    public final static String COLUMN_BRAKING = "braking";
    public final static String COLUMN_CYLINDER = "cylinder";
    public final static String COLUMN_FORKS = "forks";
    public final static String COLUMN_TYRES = "tyres";
    public final static String COLUMN_FLUID = "fluid";
    public final static String COLUMN_SUPERSTRUCTURE = "superstructure";
    public final static String COLUMN_HYDRAULIC = "hydraulic";
    public final static String COLUMN_CONNECTIONS = "connections";
    public final static String COLUMN_WIRE_ROPE = "wireRope";
    public final static String COLUMN_ROPE_MAIN = "ropeMain";
    public final static String COLUMN_ROPE_AUX = "ropeAux";
    public final static String COLUMN_ROPE_TROLLEY = "ropeTrolley";
    public final static String COLUMN_MAIN_LINE_PULL = "mainLinePull";
    public final static String COLUMN_AUX_LINE_PULL = "auxLinePull";

    //Electrical Systems
    public final static String COLUMN_CONTROLS = "controls";
    public final static String COLUMN_EMERGENCY_STOP = "emergencyStop";
    public final static String COLUMN_ELECTRICAL_SYSTEM = "electricalSystem";
    public final static String COLUMN_OVERLOAD = "overload";
    public final static String COLUMN_ANEMOMETER = "anemometer";
    public final static String COLUMN_EARTHING = "earthing";
    public final static String COLUMN_SPEED = "speed";
    public final static String COLUMN_LIMIT_SWITCHES = "limitSwitches";
    public final static String COLUMN_BATTERIES = "batteries";
    public final static String COLUMN_TITLING = "tilting";
    public final static String COLUMN_LIGHTS = "lights";
    public final static String COLUMN_FUNCTIONS = "functions";
    public final static String COLUMN_EMERGENCY_FUNCTIONS = "emergencyFunctions";

    //Testing
    public final static String COLUMN_TEST_SWL_1 = "testSWLOne";
    public final static String COLUMN_TEST_SWL_2 = "testSWLTwo";
    public final static String COLUMN_TEST_SWL_3 = "testSWLThree";
    public final static String COLUMN_TEST_SWL_4 = "testSWLFour";
    public final static String COLUMN_APPLIED_LOAD_1 = "appliedLoadOne";
    public final static String COLUMN_APPLIED_LOAD_2 = "appliedLoadTwo";
    public final static String COLUMN_APPLIED_LOAD_3 = "appliedLoadThree";
    public final static String COLUMN_APPLIED_LOAD_4 = "appliedLoadFour";
    public final static String COLUMN_BOOM_LENGTH_1 = "boomLengthOne";
    public final static String COLUMN_BOOM_LENGTH_2 = "boomLengthTwo";
    public final static String COLUMN_BOOM_LENGTH_3 = "boomLengthThree";
    public final static String COLUMN_BOOM_LENGTH_4 = "boomLengthFour";
    public final static String COLUMN_TEST_RADIUS_1 = "radiusOne";
    public final static String COLUMN_TEST_RADIUS_2 = "radiusTwo";
    public final static String COLUMN_TEST_RADIUS_3 = "radiusThree";
    public final static String COLUMN_TEST_RADIUS_4 = "radiusFour";
    public final static String COLUMN_TEST_INFO = "testInfo";
    public final static String COLUMN_CREEPING = "creeping";

    //Outcome
    public final static String COLUMN_OUTCOME = "outcome";
    public final static String COLUMN_DEFECTS = "defects";
    public final static String COLUMN_RECOMMENDATIONS = "recommendations";
    public final static String COLUMN_NEXT_EXAM = "nextExam";
    public final static String COLUMN_NEXT_TEST = "nextTest";
    public final static String COLUMN_TIME = "completion";

    public final static String COLUMN_START_TIME = "start";
    public final static String COLUMN_DURATION = "duration";

    public final static String COLUMN_CALIBRATION_1 = "calibration1";
    public final static String COLUMN_CALIBRATION_2 = "calibration2";
    public final static String COLUMN_CALIBRATION_3 = "calibration3";
    public final static String COLUMN_CALIBRATION_4 = "calibration4";


    //Images
    public final static String COLUMN_IMAGES_ACTIVE = "imagesActive";
    public final static String COLUMN_IMAGE1 = "image1";
    public final static String COLUMN_IMAGE2 = "image2";
    public final static String COLUMN_IMAGE3 = "image3";
    public final static String COLUMN_IMAGE4 = "image4";

    //Extras
    public final static String COLUMN_CERT_NUMBER = "certNo";



    public Machine_Database(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME
                + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_FLEET + " TEXT, "
                + COLUMN_SERIAL + " TEXT, "
                + COLUMN_CLIENT + " TEXT, "
                + COLUMN_DATE + " TEXT, "
                + COLUMN_EQUIPMENT_TYPE + " TEXT, "
                + COLUMN_INSPECTION_TYPE + " TEXT, "
                + COLUMN_LOCATION + " TEXT, "
                + COLUMN_ADDRESS + " TEXT, "
                + COLUMN_TIMESHEET + " TEXT, "
                + COLUMN_RECORDS + " TEXT, "
                + COLUMN_NDT_REPORT + " TEXT, "
                + COLUMN_PREVIOUS_EXAM_CERT + " TEXT, "
                + COLUMN_PREVIOUS_EXAM_DATE + " TEXT, "
                + COLUMN_PREVIOUS_TEST_CERT + " TEXT, "
                + COLUMN_PREVIOUS_TEST_DATE + " TEXT, "
                + COLUMN_MAIN_ROPE_CERT + " TEXT, "
                + COLUMN_AUX_ROPE_CERT + " TEXT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_LENGTH + " TEXT, "
                + COLUMN_WEIGHT + " TEXT, "
                + COLUMN_DETAIL_1 + " TEXT, "
                + COLUMN_DETAIL_2 + " TEXT, "
                + COLUMN_DETAIL_3 + " TEXT, "
                + COLUMN_DETAIL_4 + " TEXT, "
                + COLUMN_DETAIL_5 + " TEXT, "
                + COLUMN_REASON + " TEXT, "
                + COLUMN_STANDARD + " TEXT, "
                + COLUMN_DESCRIPTION + " TEXT, "
                + COLUMN_MAKE + " TEXT, "
                + COLUMN_REG + " TEXT, "
                + COLUMN_SWL + " TEXT, "
                + COLUMN_COUNTER_WEIGHT + " TEXT, "
                + COLUMN_CENTER_BALLAST + " TEXT, "
                + COLUMN_INFO_1_TITLE + " TEXT, "
                + COLUMN_INFO_1 + " TEXT, "
                + COLUMN_INFO_2_TITLE + " TEXT, "
                + COLUMN_INFO_2 + " TEXT, "
                + COLUMN_INFO_3_TITLE + " TEXT, "
                + COLUMN_INFO_3 + " TEXT, "
                + COLUMN_INFO_4_TITLE + " TEXT, "
                + COLUMN_INFO_4 + " TEXT, "
                + COLUMN_MANUAL + " TEXT, "
                + COLUMN_MARKINGS + " TEXT, "
                + COLUMN_CABIN + " TEXT, "
                + COLUMN_FIRE_EXTINGUISHER + " TEXT, "
                + COLUMN_VISUAL + " TEXT, "
                + COLUMN_LOAD_CHART + " TEXT, "
                + COLUMN_CHASSIS + " TEXT, "
                + COLUMN_SLEWING + " TEXT, "
                + COLUMN_OUTRIGGERS + " TEXT, "
                + COLUMN_SPARK_ARRESTOR + " TEXT, "
                + COLUMN_BRAKING + " TEXT, "
                + COLUMN_CYLINDER + " TEXT, "
                + COLUMN_FORKS + " TEXT, "
                + COLUMN_TYRES + " TEXT, "
                + COLUMN_FLUID + " TEXT, "
                + COLUMN_SUPERSTRUCTURE + " TEXT, "
                + COLUMN_HYDRAULIC + " TEXT, "
                + COLUMN_CONNECTIONS + " TEXT, "
                + COLUMN_WIRE_ROPE + " TEXT, "
                + COLUMN_ROPE_MAIN + " TEXT, "
                + COLUMN_ROPE_AUX + " TEXT, "
                + COLUMN_ROPE_TROLLEY + " TEXT, "
                + COLUMN_MAIN_LINE_PULL + " TEXT, "
                + COLUMN_AUX_LINE_PULL + " TEXT, "
                + COLUMN_CONTROLS + " TEXT, "
                + COLUMN_EMERGENCY_STOP + " TEXT, "
                + COLUMN_ELECTRICAL_SYSTEM + " TEXT, "
                + COLUMN_OVERLOAD + " TEXT, "
                + COLUMN_ANEMOMETER + " TEXT, "
                + COLUMN_EARTHING + " TEXT, "
                + COLUMN_SPEED + " TEXT, "
                + COLUMN_LIMIT_SWITCHES + " TEXT, "
                + COLUMN_BATTERIES + " TEXT, "
                + COLUMN_TITLING + " TEXT, "
                + COLUMN_LIGHTS + " TEXT, "
                + COLUMN_FUNCTIONS + " TEXT, "
                + COLUMN_EMERGENCY_FUNCTIONS + " TEXT, "
                + COLUMN_TEST_SWL_1 + " TEXT, "
                + COLUMN_TEST_SWL_2 + " TEXT, "
                + COLUMN_TEST_SWL_3 + " TEXT, "
                + COLUMN_TEST_SWL_4 + " TEXT, "
                + COLUMN_APPLIED_LOAD_1 + " TEXT, "
                + COLUMN_APPLIED_LOAD_2 + " TEXT, "
                + COLUMN_APPLIED_LOAD_3 + " TEXT, "
                + COLUMN_APPLIED_LOAD_4 + " TEXT, "
                + COLUMN_BOOM_LENGTH_1 + " TEXT, "
                + COLUMN_BOOM_LENGTH_2 + " TEXT, "
                + COLUMN_BOOM_LENGTH_3 + " TEXT, "
                + COLUMN_BOOM_LENGTH_4 + " TEXT, "
                + COLUMN_TEST_RADIUS_1 + " TEXT, "
                + COLUMN_TEST_RADIUS_2 + " TEXT, "
                + COLUMN_TEST_RADIUS_3 + " TEXT, "
                + COLUMN_TEST_RADIUS_4 + " TEXT, "
                + COLUMN_TEST_INFO + " TEXT, "
                + COLUMN_CREEPING + " TEXT, "
                + COLUMN_OUTCOME + " TEXT, "
                + COLUMN_DEFECTS + " TEXT, "
                + COLUMN_RECOMMENDATIONS + " TEXT, "
                + COLUMN_MODEL + " TEXT, "
                + COLUMN_NEXT_EXAM + " TEXT, "
                + COLUMN_NEXT_TEST + " TEXT, "
                + COLUMN_TIME + " TEXT, "
                + COLUMN_START_TIME + " TEXT, "
                + COLUMN_DURATION + " TEXT, "
                + COLUMN_CALIBRATION_1 + " TEXT, "
                + COLUMN_CALIBRATION_2 + " TEXT, "
                + COLUMN_CALIBRATION_3 + " TEXT, "
                + COLUMN_CALIBRATION_4 + " TEXT, "
                + COLUMN_IMAGES_ACTIVE + " TEXT, "
                + COLUMN_IMAGE1 + " TEXT, "
                + COLUMN_IMAGE2 + " TEXT, "
                + COLUMN_IMAGE3 + " TEXT, "
                + COLUMN_IMAGE4 + " TEXT, "
                + COLUMN_CERT_NUMBER + " TEXT "
                + ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(
            String fleet,
            String serial,
            String client,
            String date,

            String equipmentType,
            String inspectionType,
            String location,
            String address,
            String timesheet,
            String records,
            String ndtReport,
            String previousExamCert,
            String previousExamDate,
            String previousTestCert,
            String previousTestDate,
            String mainRopeCert,
            String auxRopeCert,
            String name,
            String length,
            String weight,
            String detail1,
            String detail2,
            String detail3,
            String detail4,
            String detail5,
            String reason,
            String standard,

            String description,
            String make,
            String model,
            String reg,
            String swl,
            String counterWeight,
            String centerBallast,
            String info1Title,
            String info1,
            String info2Title,
            String info2,
            String info3Title,
            String info3,
            String info4Title,
            String info4,

            String manual,
            String markings,
            String cabin,
            String fireExtinguisher,
            String visual,
            String loadChart,

            String chassis,
            String slewing,
            String outrigger,
            String sparkArrestor,
            String braking,
            String cylinder,
            String forks,
            String tyres,
            String fluid,
            String superstructure,
            String hydraulic,
            String connections,
            String wirerope,
            String ropemain,
            String ropeaux,
            String ropetrolley,
            String mainlinepull,
            String auxlinepull,

            String controls,
            String emergencyStop,
            String electricalSystem,
            String overload,
            String anemometer,
            String earthing,
            String speed,
            String limitSwitches,
            String batteries,
            String tilting,
            String lights,
            String functions,
            String emergencyFunctions,

            String testSWL1,
            String testSWL2,
            String testSWL3,
            String testSWL4,
            String appliedLoad1,
            String appliedLoad2,
            String appliedLoad3,
            String appliedLoad4,
            String boomLength1,
            String boomLength2,
            String boomLength3,
            String boomLength4,
            String testRadius1,
            String testRadius2,
            String testRadius3,
            String testRadius4,
            String testInfo,
            String creeping,

            String outcome,
            String defects,
            String recommendations,

            String nextExam,
            String nextTest,
            String time,
            String start,
            String duration,
            String calibration1,
            String calibration2,
            String calibration3,
            String calibration4,

            String image_active,
            String image1,
            String image2,
            String image3,
            String image4,

            String certNo)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FLEET, fleet);
        contentValues.put(COLUMN_SERIAL, serial);
        contentValues.put(COLUMN_CLIENT, client);
        contentValues.put(COLUMN_DATE, date);
        contentValues.put(COLUMN_EQUIPMENT_TYPE, equipmentType);
        contentValues.put(COLUMN_INSPECTION_TYPE, inspectionType);
        contentValues.put(COLUMN_LOCATION, location);
        contentValues.put(COLUMN_ADDRESS, address);
        contentValues.put(COLUMN_TIMESHEET, timesheet);
        contentValues.put(COLUMN_RECORDS, records);
        contentValues.put(COLUMN_NDT_REPORT, ndtReport);
        contentValues.put(COLUMN_PREVIOUS_EXAM_CERT, previousExamCert);
        contentValues.put(COLUMN_PREVIOUS_EXAM_DATE, previousExamDate);
        contentValues.put(COLUMN_PREVIOUS_TEST_CERT, previousTestCert);
        contentValues.put(COLUMN_PREVIOUS_TEST_DATE, previousTestDate);
        contentValues.put(COLUMN_MAIN_ROPE_CERT, mainRopeCert);
        contentValues.put(COLUMN_AUX_ROPE_CERT, auxRopeCert);
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_LENGTH, length);
        contentValues.put(COLUMN_WEIGHT, weight);
        contentValues.put(COLUMN_DETAIL_1, detail1);
        contentValues.put(COLUMN_DETAIL_2, detail2);
        contentValues.put(COLUMN_DETAIL_3, detail3);
        contentValues.put(COLUMN_DETAIL_4, detail4);
        contentValues.put(COLUMN_DETAIL_5, detail5);
        contentValues.put(COLUMN_REASON, reason);
        contentValues.put(COLUMN_STANDARD, standard);
        contentValues.put(COLUMN_DESCRIPTION, description);
        contentValues.put(COLUMN_MAKE, make);
        contentValues.put(COLUMN_MODEL, model);
        contentValues.put(COLUMN_REG, reg);
        contentValues.put(COLUMN_SWL, swl);
        contentValues.put(COLUMN_COUNTER_WEIGHT, counterWeight);
        contentValues.put(COLUMN_CENTER_BALLAST, centerBallast);
        contentValues.put(COLUMN_INFO_1_TITLE, info1Title);
        contentValues.put(COLUMN_INFO_1, info1);
        contentValues.put(COLUMN_INFO_2_TITLE, info2Title);
        contentValues.put(COLUMN_INFO_2, info2);
        contentValues.put(COLUMN_INFO_3_TITLE, info3Title);
        contentValues.put(COLUMN_INFO_3, info3);
        contentValues.put(COLUMN_INFO_4_TITLE, info4Title);
        contentValues.put(COLUMN_INFO_4, info4);
        contentValues.put(COLUMN_MANUAL, manual);
        contentValues.put(COLUMN_MARKINGS, markings);
        contentValues.put(COLUMN_CABIN, cabin);
        contentValues.put(COLUMN_FIRE_EXTINGUISHER, fireExtinguisher);
        contentValues.put(COLUMN_VISUAL, visual);
        contentValues.put(COLUMN_LOAD_CHART, loadChart);
        contentValues.put(COLUMN_CHASSIS, chassis);
        contentValues.put(COLUMN_SLEWING, slewing);
        contentValues.put(COLUMN_OUTRIGGERS, outrigger);
        contentValues.put(COLUMN_SPARK_ARRESTOR, sparkArrestor);
        contentValues.put(COLUMN_BRAKING, braking);
        contentValues.put(COLUMN_CYLINDER, cylinder);
        contentValues.put(COLUMN_FORKS, forks);
        contentValues.put(COLUMN_TYRES, tyres);
        contentValues.put(COLUMN_FLUID, fluid);
        contentValues.put(COLUMN_SUPERSTRUCTURE, superstructure);
        contentValues.put(COLUMN_HYDRAULIC, hydraulic);
        contentValues.put(COLUMN_CONNECTIONS, connections);
        contentValues.put(COLUMN_WIRE_ROPE, wirerope);
        contentValues.put(COLUMN_ROPE_MAIN, ropemain);
        contentValues.put(COLUMN_ROPE_AUX, ropeaux);
        contentValues.put(COLUMN_ROPE_TROLLEY, ropetrolley);
        contentValues.put(COLUMN_MAIN_LINE_PULL, mainlinepull);
        contentValues.put(COLUMN_AUX_LINE_PULL, auxlinepull);
        contentValues.put(COLUMN_CONTROLS, controls);
        contentValues.put(COLUMN_EMERGENCY_STOP, emergencyStop);
        contentValues.put(COLUMN_ELECTRICAL_SYSTEM, electricalSystem);
        contentValues.put(COLUMN_OVERLOAD, overload);
        contentValues.put(COLUMN_ANEMOMETER, anemometer);
        contentValues.put(COLUMN_EARTHING, earthing);
        contentValues.put(COLUMN_SPEED, speed);
        contentValues.put(COLUMN_LIMIT_SWITCHES, limitSwitches);
        contentValues.put(COLUMN_BATTERIES, batteries);
        contentValues.put(COLUMN_TITLING, tilting);
        contentValues.put(COLUMN_LIGHTS, lights);
        contentValues.put(COLUMN_FUNCTIONS, functions);
        contentValues.put(COLUMN_EMERGENCY_FUNCTIONS, emergencyFunctions);
        contentValues.put(COLUMN_TEST_SWL_1, testSWL1);
        contentValues.put(COLUMN_TEST_SWL_2, testSWL2);
        contentValues.put(COLUMN_TEST_SWL_3, testSWL3);
        contentValues.put(COLUMN_TEST_SWL_4, testSWL4);
        contentValues.put(COLUMN_APPLIED_LOAD_1, appliedLoad1);
        contentValues.put(COLUMN_APPLIED_LOAD_2, appliedLoad2);
        contentValues.put(COLUMN_APPLIED_LOAD_3, appliedLoad3);
        contentValues.put(COLUMN_APPLIED_LOAD_4, appliedLoad4);
        contentValues.put(COLUMN_BOOM_LENGTH_1, boomLength1);
        contentValues.put(COLUMN_BOOM_LENGTH_2, boomLength2);
        contentValues.put(COLUMN_BOOM_LENGTH_3, boomLength3);
        contentValues.put(COLUMN_BOOM_LENGTH_4, boomLength4);
        contentValues.put(COLUMN_TEST_RADIUS_1, testRadius1);
        contentValues.put(COLUMN_TEST_RADIUS_2, testRadius2);
        contentValues.put(COLUMN_TEST_RADIUS_3, testRadius3);
        contentValues.put(COLUMN_TEST_RADIUS_4, testRadius4);
        contentValues.put(COLUMN_TEST_INFO, testInfo);
        contentValues.put(COLUMN_CREEPING, creeping);
        contentValues.put(COLUMN_OUTCOME, outcome);
        contentValues.put(COLUMN_DEFECTS, defects);
        contentValues.put(COLUMN_RECOMMENDATIONS, recommendations);
        contentValues.put(COLUMN_NEXT_EXAM, nextExam);
        contentValues.put(COLUMN_NEXT_TEST, nextTest);
        contentValues.put(COLUMN_TIME, time);
        contentValues.put(COLUMN_START_TIME, start);
        contentValues.put(COLUMN_DURATION, duration);
        contentValues.put(COLUMN_CALIBRATION_1, calibration1);
        contentValues.put(COLUMN_CALIBRATION_2, calibration2);
        contentValues.put(COLUMN_CALIBRATION_3, calibration3);
        contentValues.put(COLUMN_CALIBRATION_4, calibration4);

        contentValues.put(COLUMN_IMAGES_ACTIVE, image_active);
        contentValues.put(COLUMN_IMAGE1, image1);
        contentValues.put(COLUMN_IMAGE2, image2);
        contentValues.put(COLUMN_IMAGE3, image3);
        contentValues.put(COLUMN_IMAGE4, image4);

        contentValues.put(COLUMN_CERT_NUMBER, certNo);

        long result = db.insert(TABLE_NAME, null, contentValues);

        return result != -1;

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME, null);
    }

    public Cursor getContent(String id, SQLiteDatabase sqLiteDatabase){
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projections = {
                COLUMN_ID,
                COLUMN_FLEET,
                COLUMN_SERIAL,
                COLUMN_CLIENT,
                COLUMN_DATE,
                COLUMN_EQUIPMENT_TYPE,
                COLUMN_INSPECTION_TYPE,
                COLUMN_LOCATION,
                COLUMN_ADDRESS,
                COLUMN_TIMESHEET,
                COLUMN_RECORDS,
                COLUMN_NDT_REPORT,
                COLUMN_PREVIOUS_EXAM_CERT,
                COLUMN_PREVIOUS_EXAM_DATE,
                COLUMN_PREVIOUS_TEST_CERT,
                COLUMN_PREVIOUS_TEST_DATE,
                COLUMN_MAIN_ROPE_CERT,
                COLUMN_AUX_ROPE_CERT,
                COLUMN_NAME,
                COLUMN_LENGTH,
                COLUMN_WEIGHT,
                COLUMN_DETAIL_1,
                COLUMN_DETAIL_2,
                COLUMN_DETAIL_3,
                COLUMN_DETAIL_4,
                COLUMN_DETAIL_5,
                COLUMN_REASON,
                COLUMN_STANDARD,
                COLUMN_DESCRIPTION,
                COLUMN_MAKE,
                COLUMN_MODEL,
                COLUMN_REG,
                COLUMN_SWL,
                COLUMN_COUNTER_WEIGHT,
                COLUMN_CENTER_BALLAST,
                COLUMN_INFO_1_TITLE,
                COLUMN_INFO_1,
                COLUMN_INFO_2_TITLE,
                COLUMN_INFO_2,
                COLUMN_INFO_3_TITLE,
                COLUMN_INFO_3,
                COLUMN_INFO_4_TITLE,
                COLUMN_INFO_4,
                COLUMN_MANUAL,
                COLUMN_MARKINGS,
                COLUMN_CABIN,
                COLUMN_FIRE_EXTINGUISHER,
                COLUMN_VISUAL,
                COLUMN_LOAD_CHART,
                COLUMN_CHASSIS,
                COLUMN_SLEWING,
                COLUMN_OUTRIGGERS,
                COLUMN_SPARK_ARRESTOR,
                COLUMN_BRAKING,
                COLUMN_CYLINDER,
                COLUMN_FORKS,
                COLUMN_TYRES,
                COLUMN_FLUID,
                COLUMN_SUPERSTRUCTURE,
                COLUMN_HYDRAULIC,
                COLUMN_CONNECTIONS,
                COLUMN_WIRE_ROPE,
                COLUMN_ROPE_MAIN,
                COLUMN_ROPE_AUX,
                COLUMN_ROPE_TROLLEY,
                COLUMN_MAIN_LINE_PULL,
                COLUMN_AUX_LINE_PULL,
                COLUMN_CONTROLS,
                COLUMN_EMERGENCY_STOP,
                COLUMN_ELECTRICAL_SYSTEM,
                COLUMN_OVERLOAD,
                COLUMN_ANEMOMETER,
                COLUMN_EARTHING,
                COLUMN_SPEED,
                COLUMN_LIMIT_SWITCHES,
                COLUMN_BATTERIES,
                COLUMN_TITLING,
                COLUMN_LIGHTS,
                COLUMN_FUNCTIONS,
                COLUMN_EMERGENCY_FUNCTIONS,
                COLUMN_TEST_SWL_1,
                COLUMN_TEST_SWL_2,
                COLUMN_TEST_SWL_3,
                COLUMN_TEST_SWL_4,
                COLUMN_APPLIED_LOAD_1,
                COLUMN_APPLIED_LOAD_2,
                COLUMN_APPLIED_LOAD_3,
                COLUMN_APPLIED_LOAD_4,
                COLUMN_BOOM_LENGTH_1,
                COLUMN_BOOM_LENGTH_2,
                COLUMN_BOOM_LENGTH_3,
                COLUMN_BOOM_LENGTH_4,
                COLUMN_TEST_RADIUS_1,
                COLUMN_TEST_RADIUS_2,
                COLUMN_TEST_RADIUS_3,
                COLUMN_TEST_RADIUS_4,
                COLUMN_TEST_INFO,
                COLUMN_CREEPING,
                COLUMN_OUTCOME,
                COLUMN_DEFECTS,
                COLUMN_RECOMMENDATIONS,
                COLUMN_NEXT_EXAM,
                COLUMN_NEXT_TEST,
                COLUMN_TIME,
                COLUMN_START_TIME,
                COLUMN_DURATION,
                COLUMN_CALIBRATION_1,
                COLUMN_CALIBRATION_2,
                COLUMN_CALIBRATION_3,
                COLUMN_CALIBRATION_4,
                COLUMN_IMAGES_ACTIVE,
                COLUMN_IMAGE1,
                COLUMN_IMAGE2,
                COLUMN_IMAGE3,
                COLUMN_IMAGE4,
                COLUMN_CERT_NUMBER
        };

        String selection = COLUMN_ID+" LIKE ?";
        String[] selection_args = {id};

        Cursor cursor = db.query(TABLE_NAME, projections, selection, selection_args, null, null, null);


        return cursor;
    }

    public boolean updateData(
            String id,
            String fleet,
            String serial,
            String client,
            String date,

            String equipmentType,
            String inspectionType,
            String location,
            String address,
            String timesheet,
            String records,
            String ndtReport,
            String previousExamCert,
            String previousExamDate,
            String previousTestCert,
            String previousTestDate,
            String mainRopeCert,
            String auxRopeCert,
            String name,
            String length,
            String weight,
            String detail1,
            String detail2,
            String detail3,
            String detail4,
            String detail5,
            String reason,
            String standard,

            String description,
            String make,
            String model,
            String reg,
            String swl,
            String counterWeight,
            String centerBallast,
            String info1Title,
            String info1,
            String info2Title,
            String info2,
            String info3Title,
            String info3,
            String info4Title,
            String info4,

            String manual,
            String markings,
            String cabin,
            String fireExtinguisher,
            String visual,
            String loadChart,

            String chassis,
            String slewing,
            String outrigger,
            String sparkArrestor,
            String braking,
            String cylinder,
            String forks,
            String tyres,
            String fluid,
            String superstructure,
            String hydraulic,
            String connections,
            String wirerope,
            String ropemain,
            String ropeaux,
            String ropetrolley,
            String mainlinepull,
            String auxlinepull,

            String controls,
            String emergencyStop,
            String electricalSystem,
            String overload,
            String anemometer,
            String earthing,
            String speed,
            String limitSwitches,
            String batteries,
            String tilting,
            String lights,
            String functions,
            String emergencyFunctions,

            String testSWL1,
            String testSWL2,
            String testSWL3,
            String testSWL4,
            String appliedLoad1,
            String appliedLoad2,
            String appliedLoad3,
            String appliedLoad4,
            String boomLength1,
            String boomLength2,
            String boomLength3,
            String boomLength4,
            String testRadius1,
            String testRadius2,
            String testRadius3,
            String testRadius4,
            String testInfo,
            String creeping,

            String outcome,
            String defects,
            String recommendations,

            String nextExam,
            String nextTest,
            String time,
            String start,
            String duration,
            String calibration1,
            String calibration2,
            String calibration3,
            String calibration4,

            String image_active,
            String image1,
            String image2,
            String image3,
            String image4,

            String certNo


    ){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FLEET, fleet);
        contentValues.put(COLUMN_SERIAL, serial);
        contentValues.put(COLUMN_CLIENT, client);
        contentValues.put(COLUMN_DATE, date);
        contentValues.put(COLUMN_EQUIPMENT_TYPE, equipmentType);
        contentValues.put(COLUMN_INSPECTION_TYPE, inspectionType);
        contentValues.put(COLUMN_LOCATION, location);
        contentValues.put(COLUMN_ADDRESS, address);
        contentValues.put(COLUMN_TIMESHEET, timesheet);
        contentValues.put(COLUMN_RECORDS, records);
        contentValues.put(COLUMN_NDT_REPORT, ndtReport);
        contentValues.put(COLUMN_PREVIOUS_EXAM_CERT, previousExamCert);
        contentValues.put(COLUMN_PREVIOUS_EXAM_DATE, previousExamDate);
        contentValues.put(COLUMN_PREVIOUS_TEST_CERT, previousTestCert);
        contentValues.put(COLUMN_PREVIOUS_TEST_DATE, previousTestDate);
        contentValues.put(COLUMN_MAIN_ROPE_CERT, mainRopeCert);
        contentValues.put(COLUMN_AUX_ROPE_CERT, auxRopeCert);
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_LENGTH, length);
        contentValues.put(COLUMN_WEIGHT, weight);
        contentValues.put(COLUMN_DETAIL_1, detail1);
        contentValues.put(COLUMN_DETAIL_2, detail2);
        contentValues.put(COLUMN_DETAIL_3, detail3);
        contentValues.put(COLUMN_DETAIL_4, detail4);
        contentValues.put(COLUMN_DETAIL_5, detail5);
        contentValues.put(COLUMN_REASON, reason);
        contentValues.put(COLUMN_STANDARD, standard);
        contentValues.put(COLUMN_DESCRIPTION, description);
        contentValues.put(COLUMN_MAKE, make);
        contentValues.put(COLUMN_MODEL, model);
        contentValues.put(COLUMN_REG, reg);
        contentValues.put(COLUMN_SWL, swl);
        contentValues.put(COLUMN_COUNTER_WEIGHT, counterWeight);
        contentValues.put(COLUMN_CENTER_BALLAST, centerBallast);
        contentValues.put(COLUMN_INFO_1_TITLE, info1Title);
        contentValues.put(COLUMN_INFO_1, info1);
        contentValues.put(COLUMN_INFO_2_TITLE, info2Title);
        contentValues.put(COLUMN_INFO_2, info2);
        contentValues.put(COLUMN_INFO_3_TITLE, info3Title);
        contentValues.put(COLUMN_INFO_3, info3);
        contentValues.put(COLUMN_INFO_4_TITLE, info4Title);
        contentValues.put(COLUMN_INFO_4, info4);
        contentValues.put(COLUMN_MANUAL, manual);
        contentValues.put(COLUMN_MARKINGS, markings);
        contentValues.put(COLUMN_CABIN, cabin);
        contentValues.put(COLUMN_FIRE_EXTINGUISHER, fireExtinguisher);
        contentValues.put(COLUMN_VISUAL, visual);
        contentValues.put(COLUMN_LOAD_CHART, loadChart);
        contentValues.put(COLUMN_CHASSIS, chassis);
        contentValues.put(COLUMN_SLEWING, slewing);
        contentValues.put(COLUMN_OUTRIGGERS, outrigger);
        contentValues.put(COLUMN_SPARK_ARRESTOR, sparkArrestor);
        contentValues.put(COLUMN_BRAKING, braking);
        contentValues.put(COLUMN_CYLINDER, cylinder);
        contentValues.put(COLUMN_FORKS, forks);
        contentValues.put(COLUMN_TYRES, tyres);
        contentValues.put(COLUMN_FLUID, fluid);
        contentValues.put(COLUMN_SUPERSTRUCTURE, superstructure);
        contentValues.put(COLUMN_HYDRAULIC, hydraulic);
        contentValues.put(COLUMN_CONNECTIONS, connections);
        contentValues.put(COLUMN_WIRE_ROPE, wirerope);
        contentValues.put(COLUMN_ROPE_MAIN, ropemain);
        contentValues.put(COLUMN_ROPE_AUX, ropeaux);
        contentValues.put(COLUMN_ROPE_TROLLEY, ropetrolley);
        contentValues.put(COLUMN_MAIN_LINE_PULL, mainlinepull);
        contentValues.put(COLUMN_AUX_LINE_PULL, auxlinepull);
        contentValues.put(COLUMN_CONTROLS, controls);
        contentValues.put(COLUMN_EMERGENCY_STOP, emergencyStop);
        contentValues.put(COLUMN_ELECTRICAL_SYSTEM, electricalSystem);
        contentValues.put(COLUMN_OVERLOAD, overload);
        contentValues.put(COLUMN_ANEMOMETER, anemometer);
        contentValues.put(COLUMN_EARTHING, earthing);
        contentValues.put(COLUMN_SPEED, speed);
        contentValues.put(COLUMN_LIMIT_SWITCHES, limitSwitches);
        contentValues.put(COLUMN_BATTERIES, batteries);
        contentValues.put(COLUMN_TITLING, tilting);
        contentValues.put(COLUMN_LIGHTS, lights);
        contentValues.put(COLUMN_FUNCTIONS, functions);
        contentValues.put(COLUMN_EMERGENCY_FUNCTIONS, emergencyFunctions);
        contentValues.put(COLUMN_TEST_SWL_1, testSWL1);
        contentValues.put(COLUMN_TEST_SWL_2, testSWL2);
        contentValues.put(COLUMN_TEST_SWL_3, testSWL3);
        contentValues.put(COLUMN_TEST_SWL_4, testSWL4);
        contentValues.put(COLUMN_APPLIED_LOAD_1, appliedLoad1);
        contentValues.put(COLUMN_APPLIED_LOAD_2, appliedLoad2);
        contentValues.put(COLUMN_APPLIED_LOAD_3, appliedLoad3);
        contentValues.put(COLUMN_APPLIED_LOAD_4, appliedLoad4);
        contentValues.put(COLUMN_BOOM_LENGTH_1, boomLength1);
        contentValues.put(COLUMN_BOOM_LENGTH_2, boomLength2);
        contentValues.put(COLUMN_BOOM_LENGTH_3, boomLength3);
        contentValues.put(COLUMN_BOOM_LENGTH_4, boomLength4);
        contentValues.put(COLUMN_TEST_RADIUS_1, testRadius1);
        contentValues.put(COLUMN_TEST_RADIUS_2, testRadius2);
        contentValues.put(COLUMN_TEST_RADIUS_3, testRadius3);
        contentValues.put(COLUMN_TEST_RADIUS_4, testRadius4);
        contentValues.put(COLUMN_TEST_INFO, testInfo);
        contentValues.put(COLUMN_CREEPING, creeping);
        contentValues.put(COLUMN_OUTCOME, outcome);
        contentValues.put(COLUMN_DEFECTS, defects);
        contentValues.put(COLUMN_RECOMMENDATIONS, recommendations);
        contentValues.put(COLUMN_NEXT_EXAM, nextExam);
        contentValues.put(COLUMN_NEXT_TEST, nextTest);
        contentValues.put(COLUMN_TIME, time);
        contentValues.put(COLUMN_START_TIME, start);
        contentValues.put(COLUMN_DURATION, duration);
        contentValues.put(COLUMN_CALIBRATION_1, calibration1);
        contentValues.put(COLUMN_CALIBRATION_2, calibration2);
        contentValues.put(COLUMN_CALIBRATION_3, calibration3);
        contentValues.put(COLUMN_CALIBRATION_4, calibration4);
        contentValues.put(COLUMN_IMAGES_ACTIVE, image_active);
        contentValues.put(COLUMN_IMAGE1, image1);
        contentValues.put(COLUMN_IMAGE2, image2);
        contentValues.put(COLUMN_IMAGE3, image3);
        contentValues.put(COLUMN_IMAGE4, image4);
        contentValues.put(COLUMN_CERT_NUMBER, certNo);


        db.update(TABLE_NAME, contentValues, "_id = ?", new String[] { id });
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.delete(TABLE_NAME, "_id = ?", new String[] {id});

    }

}