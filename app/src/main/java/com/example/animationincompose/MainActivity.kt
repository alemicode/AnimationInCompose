package com.example.animationincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationincompose.ui.theme.AnimationInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationInComposeTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    var isVisible = remember {
                        mutableStateOf(false)
                    }
                    var isRound = remember {
                        mutableStateOf(false)
                    }
                    Button(onClick = {
                        isVisible.value = !isVisible.value
                        isRound.value = !isRound.value
                    }) {
                        Text(text = "Toggle")
                    }
                    val transition = rememberInfiniteTransition(label = "")
                    val color by transition.animateColor(
                        initialValue = Color.Red,
                        targetValue = Color.Green,
                        animationSpec = infiniteRepeatable(
                            animation = tween(200),
                            repeatMode = RepeatMode.Reverse
                        ), label = ""
                    )

                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(color)
                    )
                }
            }
        }
    }
}
