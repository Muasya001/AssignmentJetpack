package com.example.assignmentjetpack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignmentjetpack.ui.theme.AssignmentJetpackTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentJetpackTheme {
               Scaffold(
                   topBar ={
                   MyTopAppBar()

               }
               )
               {
                   LazyColumn(contentPadding = PaddingValues(10.dp),
                       modifier = Modifier.fillMaxHeight(1f)

                   )
                   {
                      item{
                        LazyRow{
                               items(MountainViews){  MountainView ->
                                   MountainViewBox(MountainView)

                               }
                           }

                       }
                       item{
                           Row(

                               modifier = Modifier
                                   .fillMaxWidth(1f)
                                   .height(50.dp)
                                   .background(Color.White),
                               horizontalArrangement = Arrangement.SpaceBetween
                           ) {
                               Text(text = "Best Destination")
                               Text(text = "view all")
                           }

                       }


                   }
                   LazyVerticalGrid(
                       columns = GridCells.Fixed(count = 2),
                       modifier = Modifier.fillMaxHeight(.1f),
                   )
                   {
                       items(BestDestinations.size) { index ->
                           MountainCell(BestDestinations[index])
                       }
                   }



               }

            }
        }
    }

    @Composable
    private fun MountainViewBox(MountainView: MountainView) {
        Box(modifier = Modifier.clip(shape = RoundedCornerShape(3.dp))
            .padding(8.dp)
            .background(Color.White))
        {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(1f)

                ) {


                Image(
                    painter = painterResource(id = MountainView.mImage),
                    modifier = Modifier
                        .fillMaxSize(1f),
                    contentDescription = null
                )
                Column(
                    modifier = Modifier.align(alignment = Alignment.BottomStart)

                ) {
                    Text(text = MountainView.name)

                    Image(
                        painter = painterResource(id = MountainView.locationIcon),
                        contentDescription = null
                    )
                    Text(text = MountainView.location)

                }

            }
        }
    }

    @Preview
    @Composable
    private fun MyTopAppBar() {
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.White,
            elevation = 0.dp,

            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = null
                    )
                    Image(
                        painter = painterResource(id = R.drawable.notifications),
                        contentDescription = null
                    )
                }
            }
        )
    }
}

data class MountainView (
    val mImage:Int,
    val name:String,
    val location:String,
    val locationIcon: Int,
    val Iconrating:Int,
    val rating:Float,
    )
val MountainViews = listOf(
    MountainView(
        mImage =R.drawable.northen,
        name ="Kivu",
        Iconrating = R.drawable.rating,
        location = "Northen Mountain",
        locationIcon = R.drawable.location,
        rating = 4.9f
    ),
    MountainView(
        mImage =R.drawable.mountain2,
        name ="Eastern Mountain",
        Iconrating = R.drawable.rating,
        location = "Tanzania",
        locationIcon = R.drawable.location,
        rating = 4.9f
),
    MountainView(
        mImage =R.drawable.mountain3,
        name ="Western Mountain",
        Iconrating = R.drawable.rating,
        location = "Kenya",
        locationIcon = R.drawable.location,
        rating = 4.2f
    ),
    MountainView(
        mImage =R.drawable.mountain4,
        name ="Southern Mountain",
        Iconrating = R.drawable.rating,
        location = "China",
        locationIcon = R.drawable.location,
        rating = 3.9f)
)
data class BestDestination(
    val mImage:Int,
    val name:String,
    val location:String,
    val locationIcon: Int,
    val Iconrating:Int,
    val rating:Float,
    )
val BestDestinations = listOf(
    BestDestination(
        mImage =R.drawable.destination1,
        name =" CaliforniaHotel",
        Iconrating = R.drawable.rating,
        location = "UG",
        locationIcon = R.drawable.location,
        rating = 3.9f),
    BestDestination(
        mImage =R.drawable.destination2,
        name ="Seku",
        Iconrating = R.drawable.rating,
        location = "Maldives",
        locationIcon = R.drawable.location,
        rating = 4.6f),
    BestDestination(
        mImage =R.drawable.destination3,
        name ="Seme",
        Iconrating = R.drawable.rating,
        location = "Naija",
        locationIcon = R.drawable.location,
        rating = 2.1f),
    BestDestination(
        mImage =R.drawable.destination4,
        name ="Southern Kenya",
        Iconrating = R.drawable.rating,
        location = "Maachakos",
        locationIcon = R.drawable.location,
        rating = 3.9f
    ),
    BestDestination(
        mImage =R.drawable.destination5,
        name ="Ruai Park",
        Iconrating = R.drawable.rating,
        location = "Ruai",
        locationIcon = R.drawable.location,
        rating = 3.9f
    ),
    BestDestination(
        mImage =R.drawable.destination6,
        name ="Zuri Park",
        Iconrating = R.drawable.rating,
        location = "Westlands",
        locationIcon = R.drawable.location,
        rating = 23.9f
    ),
    BestDestination(
        mImage =R.drawable.destination7,
        name ="Hilton",
        Iconrating = R.drawable.rating,
        location = "Uhuru Highway",
        locationIcon = R.drawable.location,
        rating = 13.9f
    ),
    BestDestination(
        mImage =R.drawable.destination8,
        name ="Malko ",
        Iconrating = R.drawable.rating,
        location = "Gigiri",
        locationIcon = R.drawable.location,
        rating = 1.9f
    )


    )
@Composable
fun MountainCell(BestDestination: BestDestination) {
    Card(
        modifier = Modifier.fillMaxWidth(.8f)
            .fillMaxHeight(.8f)
            .clip(shape = RoundedCornerShape(8.dp))
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)

                .aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(BestDestination.mImage),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

        
    }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Row() {
                Text(text = BestDestination.name)
                Image(
                    painter = painterResource(BestDestination.Iconrating),
                    contentDescription = null,
                )
            }
            Row() {
                Text(text = BestDestination.location)
                Image(
                    painter = painterResource(BestDestination.locationIcon),
                    contentDescription = null,
                )

            }

        }
    }
}







