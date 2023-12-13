//package com.example.animationincompose
//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.core.animate
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.unit.dp
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
//@Composable
//fun SwipeRefreshAnimation(){
//    val refreshScope = rememberCoroutineScope()
//    val threshold = with(LocalDensity.current) { 160.dp.toPx() }
//
//    var refreshing by remember { mutableStateOf(false) }
//    var itemCount by remember { mutableStateOf(15) }
//    var currentDistance by remember { mutableStateOf(0f) }
//
//    val progress = currentDistance / threshold
//
//    fun refresh() = refreshScope.launch {
//        refreshing = true
//        delay(1500)
//        itemCount += 5
//        refreshing = false
//    }
//
//    fun onPull(pullDelta: Float): Float = when {
//        refreshing -> 0f
//        else -> {
//            val newOffset = (currentDistance + pullDelta).coerceAtLeast(0f)
//            val dragConsumed = newOffset - currentDistance
//            currentDistance = newOffset
//            dragConsumed
//        }
//    }
//
//    fun onRelease(velocity: Float): Float {
//        if (refreshing) return 0f // Already refreshing - don't call refresh again.
//        if (currentDistance > threshold) refresh()
//
//        refreshScope.launch {
//            animate(initialValue = currentDistance, targetValue = 0f) { value, _ ->
//                currentDistance = value
//            }
//        }
//
//        // Only consume if the fling is downwards and the indicator is visible
//        return if (velocity > 0f && currentDistance > 0f) {
//            velocity
//        } else {
//            0f
//        }
//    }
//
//    Box(Modifier.pullRefresh(::onPull, ::onRelease)) {
//        LazyColumn {
//            if (!refreshing) {
//                items(itemCount) {
//                    ListItem { Text(text = "Item ${itemCount - it}") }
//                }
//            }
//        }
//
//        // Custom progress indicator
//        AnimatedVisibility(visible = (refreshing || progress > 0)) {
//            if (refreshing) {
//                LinearProgressIndicator(Modifier.fillMaxWidth())
//            } else {
//                LinearProgressIndicator(progress, Modifier.fillMaxWidth())
//            }
//        }
//    }
//}