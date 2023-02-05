package com.example.plant;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    int counter;
    int prev;
    boolean seed;
    boolean tree_1;
    boolean tree_2;
    boolean tree_3;
    boolean tree_4;
    int current;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        counter = 0;
        seed = true;
        tree_1 = false;
        tree_2 = false;
        tree_3 = false;
        tree_4 = false;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onBtnClick(View view) {
//        setContentView(R.layout.activity_main);
//        imageView = (ImageView) findViewById(R.id.seed);
//        imageView.setVisibility(View.INVISIBLE);
        setContentView(R.layout.question);
        prev = counter;
    }

    public void yesClicked(View view){
        setContentView(R.layout.question);
        counter++;

    }

    public void noClicked(View view){
        setContentView(R.layout.question);
        counter--;
    }

    public void onsubmitClick(View view){
        if (counter > prev) {
            setContentView(R.layout.activity_main);
            if (seed) {
                seed = false;
                tree_1 = true;
                imageView = (ImageView) findViewById(R.id.tree1);
                imageView.setVisibility(View.VISIBLE);
            }
            else if(tree_1) {

                imageView = (ImageView) findViewById(R.id.tree2);
                tree_1 = false;
                tree_2 = true;
                imageView.setVisibility(View.VISIBLE);
            }
            else if(tree_2) {
                tree_2 = false;
                tree_3 = true;
                imageView = (ImageView) findViewById(R.id.tree3);
                imageView.setVisibility(View.VISIBLE);
            }
            else if(tree_3) {
                tree_3 = false;
                tree_4 = true;
                imageView = (ImageView) findViewById(R.id.tree4);
                imageView.setVisibility(View.VISIBLE);
            }
            else {

            }
        }
        else {
            setContentView(R.layout.activity_main);
            if (seed) {
            }
            else if(tree_1) {
                tree_1 = false;
                seed = true;
                imageView = (ImageView) findViewById(R.id.seed);
                imageView.setVisibility(View.VISIBLE);
            }
            else if(tree_2) {
                tree_2 = false;
                tree_1 = true;
                imageView = (ImageView) findViewById(R.id.tree1);
                imageView.setVisibility(View.VISIBLE);
            }
            else if(tree_3) {
                tree_3 = false;
                tree_2 = true;
                imageView = (ImageView) findViewById(R.id.tree2);
                imageView.setVisibility(View.VISIBLE);
            }
            else {
                tree_2 = false;
                tree_3 = true;
                imageView = (ImageView) findViewById(R.id.tree3);
                imageView.setVisibility(View.VISIBLE);
            }

        }
    }

}