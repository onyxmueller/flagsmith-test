package com.example.flagsmithtest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.flagsmithtest.ui.screens.FeatureFlagsScreen
import com.example.flagsmithtest.ui.screens.UiState
import com.example.flagsmithtest.ui.theme.FlagsmithTestTheme
import com.flagsmith.Flagsmith

class MainActivity : ComponentActivity() {
    
    companion object {
        private const val TAG = "MainActivity"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val flagsmith = Flagsmith(
            environmentKey = BuildConfig.FLAGSMITH_ENVIRONMENT_KEY,
            context = this
        )
        
        setContent {
            FlagsmithTestTheme {
                FeatureFlagsApp(flagsmith = flagsmith)
            }
        }
    }
}

@Composable
fun FeatureFlagsApp(flagsmith: Flagsmith) {
    var uiState by remember { mutableStateOf<UiState>(UiState.Loading) }
    var isRefreshing by remember { mutableStateOf(false) }
    
    fun loadFeatureFlags() {
        Log.i("FeatureFlagsApp", "Loading feature flags...")
        flagsmith.getFeatureFlags { result ->
            result.fold(
                onSuccess = { flagList ->
                    Log.i("FeatureFlagsApp", "Successfully loaded ${flagList.size} feature flags")
                    
                    val featureFlags = flagList.map { flag ->
                        FeatureFlag(
                            name = flag.feature.name,
                            enabled = flag.enabled,
                            value = flag.featureStateValue?.toString()
                        )
                    }
                    
                    uiState = UiState.Success(featureFlags)
                    isRefreshing = false
                },
                onFailure = { error ->
                    Log.e("FeatureFlagsApp", "Error loading feature flags", error)
                    uiState = UiState.Error
                    isRefreshing = false
                }
            )
        }
    }
    
    fun onRefresh() {
        Log.i("FeatureFlagsApp", "Refreshing feature flags...")
        isRefreshing = true
        loadFeatureFlags()
    }
    
    // Load flags on first composition
    LaunchedEffect(Unit) {
        loadFeatureFlags()
    }
    
    FeatureFlagsScreen(
        uiState = uiState,
        isRefreshing = isRefreshing,
        onRefresh = ::onRefresh
    )
}