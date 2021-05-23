package com.ragarwal.cowinavailabilityapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.util.*

class InitActivity : AppCompatActivity() {

    private val props = Properties()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        val filePath = this.getBaseContext().cacheDir
        val eula_btn = findViewById<Button>(R.id.eula_accepted)
        var fnf_flag = false
        try{
            //Look for input stream
            val props_ips = FileInputStream(filePath.absolutePath+"/eula.dat")
            props_ips.close()
        }catch ( e:FileNotFoundException){
            //File is not present. Show EULA screen.
            fnf_flag = true
        }catch ( e: Exception){
            throw e
        }finally{

            if (!fnf_flag){
                val fis = FileInputStream(this.getBaseContext().cacheDir.absolutePath+"/eula.dat")
                val eula_status = fis.readBytes().toString()
                if (eula_status.compareTo("EULA_STATUS=true".encodeToByteArray().toString()) == 0){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    eula_btn.setOnClickListener(){
                        val intent = Intent(this, MainActivity::class.java)

                        val fos = FileOutputStream(filePath.absolutePath+"/eula.dat")
                        props.store(fos, ("EULA_STATUS=true"))
                        fos.close()

                        startActivity(intent)
                    }
                }
            }else{
                eula_btn.setOnClickListener(){
                    val intent = Intent(this, MainActivity::class.java)

                    val fos = FileOutputStream(filePath.absolutePath+"/eula.dat")
                    props.store(fos, ("EULA_STATUS=true"))
                    fos.close()

                    startActivity(intent)
                }
            }
        }
    }
}