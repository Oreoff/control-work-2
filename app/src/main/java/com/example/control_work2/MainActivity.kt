package com.example.control_work2
import androidx.compose.foundation.Image
import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.control_work2.ui.theme.Control_Work2Theme
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Control_Work2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center))
{ var result by remember { mutableStateOf(1)
    }

    val imageResource = when (result) {
        1 -> R.drawable.image_1
        2 -> R.drawable.image_2
        3 -> R.drawable.image_3
        4 -> R.drawable.image_4
        5 -> R.drawable.image_5
        else -> R.drawable.ic_launcher_background
    }
    val desc = when (result) {
        1 -> "Image 1"
        2 -> "Image 2"
        3 -> "Image 3"
        4 -> "Image 4"
        5 -> "Image 5"
        else -> "Error:Image not found"
    }
    val author = when (result) {
        1 -> "Hanz Zimmer"
        2 -> "Maxym Melnyk"
        3 -> "Vincent Van Gog"
        4 -> "Michelangelo"
        5 -> "Rick Astley"
        else -> "Developer is retard, sorry"
    }
    fun ImageScrollerForward():Int
    {
        if(result == 5)result = 1
        else result++;

        return 0;
    }
    fun ImageScrollerBackward():Int
    {
        if(result == 1)result = 5
        else result--;

        return 0;
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    )
        {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .height(500.dp)
                        .fillMaxWidth()

                ) {
                    Image(
                        painter = painterResource(id = imageResource),
                        contentDescription = result.toString()
                    )
                }

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()) {
                Text(text = desc, fontSize = 36.sp)
                Text(text = author, fontSize = 14.sp)
            }
          Row(horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment =  Alignment.Bottom,
              modifier = Modifier
                  .fillMaxSize()
                  .padding(top = 50.dp)

             ){
              Button(
                  onClick = {ImageScrollerBackward()})
              {
                  Text("Previous")
              }
              Button(
                  onClick = {ImageScrollerForward()})
              {
                  Text("Next")
              }
          }
          }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Control_Work2Theme {
        Greeting()
    }
}