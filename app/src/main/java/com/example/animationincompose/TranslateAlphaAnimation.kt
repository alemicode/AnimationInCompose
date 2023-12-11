package com.example.animationincompose

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun AnimatedBox() {
    // Use remember to initialize the Animatable values
    val translateY = remember { Animatable(0f) }
    val alpha = remember { Animatable(1f) }
    val coroutineScope = rememberCoroutineScope()

    // Use Modifier.pointerInput to detect tap gestures
    val modifier = Modifier.clickable {
        // When the Box is tapped, animate the translateY and alpha values
        // Animate to a random y value between -200 and 200
        val targetY = Random.nextInt(-200, 200).toFloat()
        // Animate to either 0 or 1 for alpha
        val targetAlpha = if (alpha.value == 0f) 1f else 0f
        // Use rememberCoroutineScope to get a coroutine scope
        // Use launch to run the animations in parallel
        coroutineScope.launch {
            // Animate the translateY value with a spring animation
            translateY.animateTo(-200f, animationSpec = spring())
            // Animate the alpha value with a tween animation
            alpha.animateTo(targetAlpha, animationSpec = tween(1000))
        }

    }

    // Use Modifier.graphicsLayer to apply the animations to the Box
    Box(
        modifier = modifier
            .size(100.dp)
            .background(Color.Red)
            .graphicsLayer {
                // Use the translateY value to set the translationY property
                translationY = translateY.value
                // Use the alpha value to set the alpha property
                this.alpha = alpha.value
            }
    )
}

