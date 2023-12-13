package com.example.animationincompose

import AnimatedBorderCard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.animationincompose.ui.theme.AnimationInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationInComposeTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .border(width = 2.dp, color = Color.Red, shape = RectangleShape),
                ) {
                    AnimatedBorderCard(
                        modifier = Modifier.size(250.dp)
                    ) {
                        Column(modifier = Modifier.padding(24.dp)) {
                            Text(
                                text = "Mohamad Alemi",
                                fontWeight = FontWeight.Bold,
                                fontSize = MaterialTheme.typography.displaySmall.fontSize
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "A Senior Android developer with more than 6 years of experience ",
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize
                            )

                        }
                    }
                }
            }
        }
    }
}
