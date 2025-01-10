package com.example.jetbizcard

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

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
    Surface (modifier = Modifier.fillMaxWidth()
        .fillMaxHeight()) {
        ProfileImage()
    }
}


@Composable
private fun ProfileImage() {
    Card (modifier = Modifier.width(200.dp)
        .height(390.dp)
        .padding(12.dp),
        shape = RoundedCornerShape(corner = androidx.compose.foundation.shape.CornerSize(15.dp)) ,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp)){
        Surface(modifier = Modifier.size(150.dp)
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
                    .size(135 .dp) // Adjust size as needed
                    .clip(CircleShape) // Ensure the image is clipped into a circle
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
            )


        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}



