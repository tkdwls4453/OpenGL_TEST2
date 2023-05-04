package com.example.myapplication

import android.app.Activity
import android.opengl.GLSurfaceView
import android.os.Bundle
import android.view.WindowManager
import org.json.JSONArray
import org.json.JSONObject

var roadsArray: JSONArray = JSONArray();
var octagonObject: JSONObject = JSONObject()
var soccerFieldObject: JSONObject = JSONObject()

class MainActivity : Activity() {

    private lateinit var gLView: GLSurfaceView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Json 파일 읽는 부분
        val jsonString = assets.open("jsons/coordinate.json").bufferedReader().use { it.readText() }
        val json = JSONObject(jsonString)
        roadsArray = json.getJSONArray("Roads")
        octagonObject = json.getJSONObject("Octagon")
        soccerFieldObject = json.getJSONObject("soccer_field")

        gLView = MyGLSurfaceView(this)
        setContentView(gLView)
    }
}