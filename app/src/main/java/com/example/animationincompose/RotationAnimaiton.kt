package com.example.animationincompose

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun RotationAnimaiton() {

    var rotationState by remember { mutableStateOf(0f) }
    var scaleState by remember { mutableStateOf(1f) }

    val animationRotation by animateFloatAsState(
        targetValue = rotationState,
        animationSpec = tween(
            durationMillis = 1200,
            easing = LinearEasing
        ), label = ""
    )

    val animateScale by animateFloatAsState(
        targetValue = scaleState,
        animationSpec = tween(
            durationMillis = 500,
            easing = LinearEasing
        ), label = ""
    )

    LaunchedEffect(Unit) {
        rotationState = 360f
        delay(2000)
        scaleState = 3f
    }


    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "image",
        modifier = Modifier
            .size(100.dp)
            .rotate(animationRotation)
            .scale(animateScale) // Apply scaling animation
    )
}
