package com.example.jetbizcard

import android.R
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetBizCardTheme {
                Surface(color = MaterialTheme.colorScheme.background){
                    CreateBizCard()
                }
            }
        }
    }
}




@Composable
fun CreateBizCard() {

    Surface (modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        ProfileImage()

    }
}


@Composable
private fun ProfileImage() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Card (modifier = Modifier
        .width(200.dp)
        .height(390.dp)
        .padding(12.dp),
        shape = RoundedCornerShape(corner = androidx.compose.foundation.shape.CornerSize(15.dp)) ,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp)){
       Column (
           modifier = Modifier.fillMaxWidth(),
           verticalArrangement = Arrangement.Top,
           horizontalAlignment = CenterHorizontally
       ){
           Surface(modifier = Modifier
               .size(150.dp)
               .padding(5.dp)
               .align(CenterHorizontally),
           shape = CircleShape,
           border = BorderStroke(0.5.dp, Color.LightGray),
           shadowElevation = 4.dp,
           tonalElevation = 6.dp,
           color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)) {
           Image(
               painter = painterResource(id = com.example.jetbizcard.R.drawable.profile_image),
               contentDescription = "Profile Image",
               modifier = Modifier
                   .size(135.dp) // Adjust size as needed
                   .clip(CircleShape) // Ensure the image is clipped into a circle
                   .fillMaxSize(),
               contentScale = ContentScale.Crop,
           )


       }
           HorizontalDivider(thickness = 2.dp)

           Column(horizontalAlignment = Alignment.Start
           , modifier = Modifier.padding(7.dp)){
               Text(text = "Rahul Roy"
               , style = MaterialTheme.typography.headlineLarge,
                   color = MaterialTheme.colorScheme.primary
               )
               Text(text = "Android Developer")
               Text(text = "Frontend engineer")
               Button(onClick = {
                   buttonClickedState.value = !buttonClickedState.value
               },
                   modifier = Modifier.fillMaxWidth()) {
                   Text(text = "Portfolio"
                       , style = MaterialTheme.typography.bodyLarge)
               }
               if(buttonClickedState.value){
                   Content()
               }
else{
                   Box{}
}

           }
       }

    }
}

@Preview(showBackground = true)
@Composable
fun Content(){
Box(modifier= Modifier
    .fillMaxHeight()
    .fillMaxWidth()
    .padding(5.dp)){
Surface(modifier = Modifier
    .padding(3.dp)
    .fillMaxHeight()
    .fillMaxWidth()
    .border(BorderStroke(2.dp, Color.LightGray)),

    shape = RoundedCornerShape(corner =CornerSize(8.dp )),
){
Portfolio(data = listOf("Project 1","Project 2","Project 3")

)}
}
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->  // Correct usage
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape=RectangleShape) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(color = MaterialTheme.colorScheme.surface)
                    .padding(16.dp)) {
                    
                }
            }
        }
    }
}
@Composable
fun GreetingPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}

    



