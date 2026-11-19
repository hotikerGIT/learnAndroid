package com.example.learnandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.benchmark.traceprocessor.Row
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnandroid.ui.theme.LearnAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnAndroidTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Hello("Человек", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun Hello(name: String?, modifier: Modifier) {
    val txt = if (name != null) "Hello, $name!" else "Name not given"

    Text(
        text = txt,
        modifier = modifier
    )
}

@Preview(name = "portrait", device = "spec:width=411dp,height=891dp", showSystemUi = true)
@Composable
fun HelloPreviewPortrait() {
    LearnAndroidTheme { Hello(null, Modifier) }
}

@Preview(name = "landscape", device = "spec:parent=pixel_5,orientation=landscape",
    showSystemUi = true
)
@Composable
fun HelloPreviewLandscape() {
    LearnAndroidTheme { Hello(null, Modifier) }
}

@Preview(name = "round", device = "spec:width=200dp,height=200dp,isRound=true",
    backgroundColor = 0xFFFFEB3B, showSystemUi = true, showBackground = true
)
@Composable
fun HelloPreviewPortraitRound() {
    LearnAndroidTheme { Hello(null, Modifier) }
}


@Preview
@Composable
fun Task3PreviewFirst() {
    Text(
        text = stringResource(R.string.task3_resource),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun Task3PreviewSecond() {
    Text(
        text = stringResource(R.string.task3_resource),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.fillMaxWidth(),
        color = Color.Red
    )
}

@Preview
@Composable
fun Task3PreviewThird() {
    Text(
        text = stringResource(R.string.task3_resource),
        style = TextStyle(
            fontSize = 24.sp,
            color = Color.Black,
            textDecoration = TextDecoration.Underline,
            textIndent = TextIndent(firstLine = 48.sp)
        ),
        modifier = Modifier.background(Color.Green)
    )
}

@Composable
fun MyButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text(text = "Нажми на меня")
    }
}

@Preview
@Composable
fun Task4Preview() {
    MyButton();
}

@Preview
@Composable
fun Task5Preview() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxHeight()
                .aspectRatio(1f)
                .background(
                    color = Color(0xFFE65100),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "АБ",
                color = Color.Black
            )
        }
    }
}