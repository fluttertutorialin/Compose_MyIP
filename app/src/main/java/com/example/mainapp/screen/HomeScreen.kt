package com.example.mainapp.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.findmyip.model.ComputerDetails
import com.example.mainapp.viewmodel.MainViewModel
import retrofit2.Response

@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val computerDetails by  viewModel.getComputerDetails.observeAsState("initial")
    val users by viewModel.getComputerDetails.observeAsState()

    // Display UI based on the fetched data
    if (users != null) {
        SetData(users!!)
    }

    when (computerDetails) {
        "initial" ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .size(1.dp)
                    .height(200.dp)
                    .width(200.dp),
                contentAlignment = Alignment.Center
            ) { CircularProgressIndicator(strokeWidth = 1.dp) }
    }
}

@Composable
fun SetData(getData: Response<ComputerDetails>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home screen") },
                elevation = AppBarDefaults.TopAppBarElevation
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                modifier = Modifier.padding(8.dp),
                elevation = 16.dp,
                backgroundColor = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Computer details",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 22.sp,
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold // Bold style
                        )
                    )
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "IP :",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text =  getData.body()!!.ip,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))
                    
                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Network :",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.network,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))
                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "version ::",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.version,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))
                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "city ::",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.city,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Region ::",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.region,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Region code ::",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.regionCode,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "country:",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.currency,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Country Name:",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.countryName,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))
                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Country Code:",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.countryCode,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Country Code iso3:",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.countryCodeIso3,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Country Capital",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.countryCapital,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Country TId",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.countryTld,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))
                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Continent Code",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.continentCode,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "postal",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.postal,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))


                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Latitude",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.latitude.toString(),
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Longitude",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.longitude.toString(),
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "TimeZone",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.timezone,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Utc Offset",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.utcOffset,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Country Calling Code",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.countryCallingCode,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Currency",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.currency,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Currency Name",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.countryName,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Currency Name",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.currencyName,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Languages",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.languages,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Country Area",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.countryArea.toString(),
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Country Population",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text =getData.body()!!.countryPopulation.toString(),
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Asn",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.asn,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))

                    Row(
                        modifier = Modifier.padding(6.dp),
                    ) {
                        Text(
                            text = "Org",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold // Bold style
                            )
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = getData.body()!!.org,
                            style = TextStyle(
                                fontSize = 20.sp, // Text size in sp
                                fontWeight = FontWeight.Medium // Bold style
                            )
                        )
                    }
                    // Divider
                    Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))
                }
            }
        }
    }
}
