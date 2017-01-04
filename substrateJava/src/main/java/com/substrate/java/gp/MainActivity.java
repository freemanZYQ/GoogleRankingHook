        package com.substrate.java.gp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "mainClass";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.newdata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                input("droidGuardCallback/cpr/a","input","hello".getBytes());
                Toast.makeText(MainActivity.this,"new~~~~~",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.olddata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                input("droidGuardCallback/cpr/a","input","hello2".getBytes());
                Toast.makeText(MainActivity.this,"old~~~~~~",Toast.LENGTH_LONG).show();
            }
        });

        zzas cmd = new zzas();
        cmd.run("sTR9aFAdkdnaUojBn5MCnVcmLkw0WJVY8ijmPhrWHpc24KI9LTIfGx2hy32qO1gN");
        cmd.run("61BKDY1B3oiNkB4UAOiQDBPBU96C5XDz9muRmL/JOiM=");
        cmd.run("G5pqxyycf4cJQIz5I0oGbBY1yGw3oXvj8iLKfkYp2yVRtTcktz+X3OVBLJp3J14Y");
        cmd.run("AKByt2/IOvCrmhtfIWmg+RZ+bFkYkfIYB0WIse7f6wM=");
        cmd.run("S3PIUOsU0D8Nwqd9QT3IXltVA1shYhuZmaIie80ULM0GXE4O1PJdUJmZmEeq/CVB");
        cmd.run("1xLMCiUMRnQiLKomFM3scTYXYSaWCCAmgqKs6OfMbSk=");
        cmd.run("+ZpEQ2CjuReU1DKOyvnXnfIYpnazdhIH5TI0G4JXPiNM0XDrcs3+ybGZ+GG7w1+x");
        cmd.run("TEs4f0RxlVj9xshKexFTHTj3XkRUYqAzm3TwsmWkSlE=");

        CollectionUtils utils = new CollectionUtils();
        utils.run(", dalvik.system.VMStack.getThreadStackTrace, java.lang.Thread.getStackTrace, java.util.concurrent.Executors$RunnableAdapter.call");
        //cps
        int[] cps_b = new int[]{222, 102, 196, 157, 211, 196, 204, 224, 186, 202, 183, 38, 201, 205, 206, 102, 202, 215, 117, 195, 133, 102, 183, 182, 117};
        int[] cps_f = new int[]{205, 221, 102, 217, 176, 206, 183, 149, 192, 190, 154, 214, 201, 213, 102, 209, 117, 195, 133, 102, 212, 203, 213, 183, 182, 117};
        int[] cps_e = new int[]{211, 127, 4, 204, 206, 222, 197, 19, 53};
        int[] cps_d = new int[]{210, 102, 203, 222, 196, 157, 196, 219, 186, 183, 38, 216, 210, 102, 117, 218, 195, 210, 133, 217, 102, 219, 183, 182, 117, 224, 208, 102, 183, 182, 214, 217, 117, 181, 203, 188, 37, 228, 218, 182};
        int[] cps_c = new int[]{102};

        Log.d(TAG,"cps_b:"+utils.a(cps_b));
        Log.d(TAG,"cps_f:"+utils.a(cps_f));
        Log.d(TAG,"cps_e:"+utils.a(cps_e));
        Log.d(TAG,"cps_d:"+utils.a(cps_d));
        Log.d(TAG,"cps_c:"+utils.a(cps_c));

        //cpq
        int[] cpq_1 = new int[]{229, 182, 214, 206, 183, 186, 4, 191, 196, 211, 208, 171, 53};
        int[] cpq_2 = new int[]{182, 183, 186, 144, 145, 193};
        int[] cpq_3 = new int[]{222, 182, 219, 224, 214, 207, 210, 183, 202, 200, 210, 186, 225, 4, 191, 205, 196, 204, 216, 171, 212, 199};
        int[] cpq_4 = new int[]{154, 214, 214, 183, 209, 149, 206, 226, 211, 216, 192, 208, 210, 183, 209, 154};

        Log.d(TAG,"cpq_1:"+utils.a(cpq_1));
        Log.d(TAG,"cpq_2:"+utils.a(cpq_2));
        Log.d(TAG,"cpq_3:"+utils.a(cpq_3));
        Log.d(TAG,"cpq_4:"+utils.a(cpq_4));

        int[] cpq_5 = new int[]{222, 219, 200, 102, 216, 200, 37, 181, 191, 206, 229, 145, 214, 201, 217, 165};
        int[] cpq_6 = new int[]{225, 207, 192, 207, 154, 190, 195, 192, 182, 193, 191, 203, 154, 192, 102, 192, 202, 154, 190, 218, 195, 192, 216, 206, 182, 193, 191, 196, 208, 196, 206, 219, 190, 222, 181, 183, 149, 188};
        int[] cpq_7 = new int[]{205, 208, 221, 197, 68, 127, 202, 102, 121, 212, 206, 214, 214, 137, 203, 221, 121, 214, 102, 71, 207, 228, 219, 214, 222, 45, 121, 127, 115, 215, 71, 228, 191, 205, 212, 192, 192, 195, 149, 182};
        int[] cpq_8 = new int[]{197, 200, 68, 127};
        int[] cpq_9 = new int[]{203, 188, 190, 38, 210, 181, 205, 224, 227, 202, 182, 190, 190, 226, 182, 202, 214, 117, 183, 200, 200, 181, 207, 188, 188, 226, 213, 188, 181, 191, 133, 193, 196, 223, 215, 183, 181, 192, 217, 154, 190, 214, 195, 192, 200, 210, 182, 210, 202, 193, 191, 202, 226, 154, 227, 192, 208, 226, 203, 221, 181, 192, 217, 154, 190, 218, 206, 210, 195, 228, 218, 200, 192, 209, 201, 182, 202, 214, 193, 191, 196, 220, 219, 196, 190, 181, 20, 154, 190, 195, 206, 223, 192, 217, 225, 219, 204, 182, 207, 193, 191, 196, 196, 209, 190};
        int[] cpq_10 = new int[]{213, 227, 37, 133};
        Log.d(TAG,"cpq_5:"+utils.a(cpq_5));
        Log.d(TAG,"cpq_6:"+utils.a(cpq_6));
        Log.d(TAG,"cpq_7:"+utils.a(cpq_7));
        Log.d(TAG,"cpq_8:"+utils.a(cpq_8));
        Log.d(TAG,"cpq_9:"+utils.a(cpq_9));
        Log.d(TAG,"cpq_10:"+utils.a(cpq_10));

        //cpr
        CollectionUtils utils2 = new CollectionUtils();
        utils2.run("java.lang.String");
        int[] cpr_1 = new int[]{50, 27, 45, 48, 95, 116, 86};
        Log.d(TAG,"cpr_1:"+utils2.a(cpr_1));

        FbUtils fbUtils = new FbUtils(this);
        fbUtils.run();
    }



    /**
     * 纪录存储到
     * @param fileName
     * @param data
     *
     */
    public  void input(String dir,String fileName,byte[] data){
        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
        File dirFile = new File(root,dir);
        if(dirFile.exists()){
            if(dirFile.isFile()){
                dirFile.delete();
                dirFile.mkdirs();
            }
        }else {
            dirFile.mkdirs();
        }

        File file = new File(dirFile.getAbsolutePath(),fileName);
        if(file.exists()){
            file.delete();
        }
        try {
            FileUtils.createFile(file.getAbsolutePath(), data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }
