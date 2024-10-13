package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import kotlin.random.Random
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.background
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    var maxSqueezeCount by remember { mutableStateOf(2) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Yellow
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ){
                when (currentStep) {
                    1 -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(text = stringResource(R.string.P1))
                            Spacer(modifier = Modifier.height(16.dp))
                            Image(
                                painter = painterResource(R.drawable.lemon_tree),
                                contentDescription = stringResource(R.string.Desc1),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .clickable {
                                        currentStep = 2
                                        maxSqueezeCount = Random.nextInt(2, 5)
                                        squeezeCount = 0
                                    }
                            )
                            Text(text = stringResource(R.string.Desc1))
                        }
                    }
                    2 -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(text = stringResource(R.string.P2))
                            Spacer(modifier = Modifier.height(16.dp))
                            Image(
                                painter = painterResource(R.drawable.lemon_squeeze),
                                contentDescription = stringResource(R.string.Desc2),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .clickable {
                                        squeezeCount++
                                        if (squeezeCount >= maxSqueezeCount) {
                                            currentStep = 3
                                        }
                                    }
                            )
                            Text(text = stringResource(R.string.Desc2))
                        }
                    }
                    3 -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(text = stringResource(R.string.P3))
                            Spacer(modifier = Modifier.height(16.dp))
                            Image(
                                painter = painterResource(R.drawable.lemon_drink),
                                contentDescription = stringResource(R.string.Desc3),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .clickable {
                                        currentStep = 4
                                    }
                            )
                            Text(text = stringResource(R.string.Desc3))
                        }
                    }
                    4 -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(text = stringResource(R.string.P4))
                            Spacer(modifier = Modifier.height(16.dp))
                            Image(
                                painter = painterResource(R.drawable.lemon_restart),
                                contentDescription = stringResource(R.string.Desc4),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .clickable {
                                        currentStep = 1
                                    }
                            )
                            Text(text = stringResource(R.string.Desc4))
                        }
                    }
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}
