package com.example.animationincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationincompose.ui.theme.AnimationInComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationInComposeTheme {
                val scaleA = remember { Animatable(1f) }
                val translateA = remember { Animatable(0f) }
                var selected by remember { mutableStateOf(false) }
                LaunchedEffect(key1 = selected) {
                    if (selected) {
                        launch {
                            scaleA.animateTo(
                                targetValue = 0.6f,
                                animationSpec = tween(500)
                            )
                            translateA.animateTo(
                                targetValue = 1f,
                                animationSpec = tween(500)
                            )
                        }
                    } else {

                    }
                }
                val travelDistance = 120.dp
                val distance = with(LocalDensity.current) { travelDistance.toPx() }
                Button(onClick = {
                    selected = !selected
                }) {}
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .scale(scaleA.value)
                            .graphicsLayer {
                                translationY = distance * translateA.value
                            }
                            .width(200.dp)
                            .height(250.dp)
                            .padding(40.dp)
                            .border(
                                width = 1.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(6.dp)
                            )
                    )

                }
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimationInComposeTheme {
        Greeting("Android")
    }
}