package com.sujeong.composecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sujeong.composecalculator.ui.theme.ComposeCalculatorTheme
import com.sujeong.composecalculator.ui.theme.MediumGray

class CalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel = viewModel<CalculatorViewModel>()
                    val state = viewModel.state
                    val buttonSpacing = 8.dp

                    Calculator(
                        state = state,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(MediumGray),
                        buttonSpacing = buttonSpacing,
                        onAction = viewModel::onAction
                    )
                }
            }
        }
    }
}